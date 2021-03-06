package codeGen;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;

import Intsr.ARMInstruction;
import Intsr.Address;
import Intsr.Data;
import Intsr.Directives;
import Intsr.Immediate;
import Intsr.Instruc;
import Intsr.Instruction;
import Intsr.Label;
import Intsr.Operand;
import Intsr.Reg;
import Intsr.RegManager;
import Intsr.Types;
import WACCFrontEnd.ArrayType;
import WACCFrontEnd.Int;
import WACCFrontEnd.PairType;
import WACCFrontEnd.PrimType;
import WACCFrontEnd.Type;
import WACCFrontEnd.WACCVisitor;
import antlr.BasicParser;
import antlr.BasicParser.ArrayLiter_assignrhsContext;
import antlr.BasicParser.ArrayelemContext;
import antlr.BasicParser.PairelemContext;
import antlr.BasicParser.PairtypeContext;
import antlr.BasicParserBaseVisitor;

public class WACCAssembler extends BasicParserBaseVisitor<Operand> {

	// Creating a list that stores all the instructions.
	public static List<Instruction> assemblyCode = new ArrayList<>();
	// Storing datas.
	public static List<String> data = new ArrayList<>();
	private static RegManager availRegs = new RegManager();
	// static List<Reg> availRegs = Reg.getRegs();
	// Instructions that come after the main code.
	private List<Instruction> endInstruc = new ArrayList<>();
	// This should only be printed once.
	boolean printedAlready = false;
	int label = 0;
	PrintManager manage = new PrintManager();

	// Visit a Program Context
	@Override
	public Operand visitProgram(@NotNull BasicParser.ProgramContext ctx) {
		WACCVisitor.TOP_ST.calculateScope(); // Calculate
		addData(); // Add program data to .data
		assemblyCode.add(Directives.TEXT); // Add .text directive
		assemblyCode.add(Directives.GLOBALM);// Add .global main to code
		List<BasicParser.FuncContext> functions = ctx.func();
		if (functions != null) {
			for (BasicParser.FuncContext func : functions) {
				visitFunc(func); // Visit every function in the program
			}
		}
		assemblyCode.add(new Label("main"));// Create main Label
		enterScope(assemblyCode);// add Push {LR} to assembly code
		createSub(); // Add "sub scope from stack pointer statement" to code
		visit(ctx.stat()); // visit Program Statement
		createAdd(); // Add "add scope from stack pointer statement" to code
		assemblyCode.add(new ARMInstruction(Instruc.LDR, Reg.R0, new Immediate(
				"=0")));// Load register RO with 0
		exitScope(assemblyCode); // add Pop {PC} to assembly code
		assemblyCode.add(Directives.LTORG);// Add .ltorg directive to code
		assemblyCode.addAll(endInstruc);// Add all end Instructions if any
		finishCode();
		return null;
	}

	public void enterScope(List<Instruction> list) {
		// Push LR to stack
		list.add(new ARMInstruction(Instruc.PUSH, Reg.LR));
	}

	public void exitScope(List<Instruction> list) {
		// Pop PC from stack
		list.add(new ARMInstruction(Instruc.POP, Reg.PC));
	}

	@Override
	public Operand visitCall_assignrhs(
			@NotNull BasicParser.Call_assignrhsContext ctx) {
		Reg r = availRegs.useRegs();
		if (ctx.getChild(3) instanceof BasicParser.ArglistContext) {
			for (BasicParser.ExprContext expr : ctx.arglist().expr()) {
				availRegs.refreshReg();
				r = (Reg) visit(expr);
				int off = (r.getType() == Types.BOOL || r.getType() == Types.CHAR) ? 1
						: 4;
				WACCVisitor.TOP_ST.add(off);
				assemblyCode
						.add(new ARMInstruction((r.getType() == Types.BOOL || r
								.getType() == Types.CHAR) ? Instruc.STRB
								: Instruc.STR, r, new Address(Reg.SP,
								new Immediate("-" + off), '!')));
			}
			WACCVisitor.TOP_ST.resetCumulative();
		}
		assemblyCode.add(new ARMInstruction(Instruc.BL, new Immediate("f_"
				+ ctx.IDENT().getText())));
		int i = 0;
		for (Type type : WACCVisitor.functions.get(ctx.IDENT().toString())
				.getParamList()) {
			i += type.getSize();
		} if (i > 0) {
			assemblyCode.add(new ARMInstruction(Instruc.ADD, Reg.SP, Reg.SP, new Immediate(
				"#" + i)));
		}
		assemblyCode.add(new ARMInstruction(Instruc.MOV, r, Reg.R0));
		setRegType(r, WACCVisitor.functions.get(ctx.IDENT().toString()).getReturnType());
		return r;
	}

	public Operand visitFunc(@NotNull BasicParser.FuncContext ctx) {
		assemblyCode.add(new Label("f_" + ctx.IDENT().getText()));
		WACCVisitor.TOP_ST = WACCVisitor.TOP_ST.getChildren().get(0);
		WACCVisitor.TOP_ST.enableAll();
		enterScope(assemblyCode);
		WACCVisitor.TOP_ST = WACCVisitor.TOP_ST.getChildren().get(0);
		WACCVisitor.TOP_ST.calculateScope();
		createSub();
		visit(ctx.stat());
		exitScope(assemblyCode);
		assemblyCode.add(Directives.LTORG);
		WACCVisitor.TOP_ST = WACCVisitor.TOP_ST.getParent().getParent();
		WACCVisitor.TOP_ST.removeChild();
		availRegs.refreshReg();
		return null;
	}

	// Visit Sequence statement separated by semicolons
	@Override
	public Operand visitSemicolon_Stat(
			@NotNull BasicParser.Semicolon_StatContext ctx) {
		visit(ctx.stat(0)); // Visit first statement
		availRegs.refreshReg(); // Refresh registers
		visit(ctx.stat(1)); // Visit second statement
		return null;
	}

	@Override
	public Operand visitReturn_Stat(@NotNull BasicParser.Return_StatContext ctx) {
		Reg reg = (Reg) visit(ctx.expr());
		assemblyCode.add(new ARMInstruction(Instruc.MOV, Reg.R0, (Reg) reg));
		int i = WACCVisitor.TOP_ST.getTotalScope();
		i += WACCVisitor.TOP_ST.getParent().getTotalScope();
		assemblyCode.add(new ARMInstruction(Instruc.ADD, Reg.SP, Reg.SP, new Immediate("#" + i)));
		exitScope(assemblyCode);
		return null;
	}

	// Visit and/or expression
	private Operand andOr(Instruc i, BasicParser.ExprContext ctx1,
			BasicParser.ExprContext ctx2) {
		Operand reg1 = visit(ctx1); // First Register
		Operand reg2 = visit(ctx2); // Second Register
		// Add new line of code with instruction and both register
		assemblyCode.add(new ARMInstruction(i, reg1, reg1, reg2));
		// Set type of regs (necessary further on in the code)
		Reg r = (Reg) reg1;
		r.setType(Types.BOOL);
		return r;
	}

	@Override
	public Operand visitParenth_Expr(
			@NotNull BasicParser.Parenth_ExprContext ctx) {
		// Visit expr as parenth expr is an instanceof expr
		return visit(ctx.expr());
	}

	@Override
	public Operand visitAnd_Expr(@NotNull BasicParser.And_ExprContext ctx) {
		// Visit and statement with both exprs as arguments
		return andOr(Instruc.AND, ctx.expr(0), ctx.expr(1));
	}

	@Override
	public Operand visitOr_Expr(@NotNull BasicParser.Or_ExprContext ctx) {
		// Visit or statement with both exprs as arguments
		return andOr(Instruc.ORR, ctx.expr(0), ctx.expr(1));
	}

	// While Statement, initial proceedings
	private void L1_While(BasicParser.While_StatContext ctx, int i) {
		assemblyCode.add(new Label("L" + i)); // Add new Label 'L1'
		// Top symboltable becomes the first child symboltable
		WACCVisitor.TOP_ST = WACCVisitor.TOP_ST.getChildren().get(0);
		createSub();// Add "sub scope from stack pointer statement" to code
		visit(ctx.stat()); // Visit the statement
		createAdd();// Add "add scope from stack pointer statement" to code
		// return symboltable to the parent (top) symboltable
		WACCVisitor.TOP_ST = WACCVisitor.TOP_ST.getParent();
		WACCVisitor.TOP_ST.removeChild(); // Delete the child node
		L0_While(ctx, i - 1);
	}

	@Override
	public Operand visitEquality_Expr(
			@NotNull BasicParser.Equality_ExprContext ctx) {
		String oper = ctx.getChild(1).getText(); // oper is the comparator
		Operand reg1 = visit(ctx.expr(0)); // Reg first expr evaluates to
		Operand reg2 = visit(ctx.expr(1)); // Reg second expr evaluates to
		assemblyCode.add(new ARMInstruction(Instruc.CMP, reg1, reg2));
		if (oper.equals("==")) {
			assemblyCode.add(new ARMInstruction(Instruc.MOVEQ, reg1,
					new Immediate("#1")));
			assemblyCode.add(new ARMInstruction(Instruc.MOVNE, reg1,
					new Immediate("#0")));
		} else {
			assemblyCode.add(new ARMInstruction(Instruc.MOVNE, reg1,
					new Immediate("#1")));
			assemblyCode.add(new ARMInstruction(Instruc.MOVEQ, reg1,
					new Immediate("#0")));
		}
		Reg r = (Reg) reg1;
		r.setType(Types.BOOL); // Set type of r
		return reg1;
	}

	// While statement, final proceedings
	private void L0_While(BasicParser.While_StatContext ctx, int i) {
		assemblyCode.add(new Label("L" + i)); // Add Label 'L0'
		availRegs.refreshReg();

		Reg r = (Reg) visit(ctx.expr()); // visit expr and store result as r
		// Add 'CMP r #1' which checks if expression is true
		assemblyCode
				.add(new ARMInstruction(Instruc.CMP, r, new Immediate("#1")));
		// Add 'BEQ L1'. Code branches to L1 if above line is true
		assemblyCode.add(new ARMInstruction(Instruc.BEQ, // Add L1 branch
				new Immediate("L" + (i + 1))));
	}

	@Override
	public Operand visitBool_Liter(@NotNull BasicParser.Bool_LiterContext ctx) {
		Reg avail = availRegs.useRegs(); // avail is the next available register
		avail.setType(Types.BOOL); // set type of avail to BOOL
		if (ctx.getText().equals("false")) {
			// MOV avail #0 if context evaluates to false
			assemblyCode.add(new ARMInstruction(Instruc.MOV, avail,
					new Immediate("#0")));
		} else
			// MOV avail #1 if context evaluates to true
			assemblyCode.add(new ARMInstruction(Instruc.MOV, avail,
					new Immediate("#1")));
		return avail; // return avail register
	}

	@Override
	public Operand visitIf_Stat(@NotNull BasicParser.If_StatContext ctx) {
		Operand reg = visit(ctx.expr());
		WACCVisitor.TOP_ST = WACCVisitor.TOP_ST.getChildren().get(0);
		WACCVisitor.TOP_ST.calculateScope();
		assemblyCode.add(new ARMInstruction(Instruc.CMP, reg, new Immediate(
				"#0"))); // Add CMP reg 0 to code. Checks if ctx is false
		// Add BEQ L0 to code. If ctx is false, code will go to label L0
		int fiLabel = label + 1, elseLabel = label;
		label += 2;
		assemblyCode.add(new ARMInstruction(Instruc.BEQ, new Immediate("L"
				+ elseLabel)));
		availRegs.refreshReg();
		visit(ctx.stat(0)); // Visit 'then' stat
		// Add B L1 to code. If ctx is true, code will go to label L1
		assemblyCode.add(new ARMInstruction(Instruc.B, new Immediate("L"
				+ fiLabel)));
		assemblyCode.add(new Label("L" + elseLabel));// Add Label L0
		availRegs.refreshReg();
		WACCVisitor.TOP_ST = WACCVisitor.TOP_ST.getParent();
		WACCVisitor.TOP_ST.removeChild();
		WACCVisitor.TOP_ST = WACCVisitor.TOP_ST.getChildren().get(0);
		WACCVisitor.TOP_ST.calculateScope();
		createSub();
		visit(ctx.stat(1));// Visit 'else' stat
		createAdd();
		assemblyCode.add(new Label("L" + fiLabel));// Add Label L1
		WACCVisitor.TOP_ST = WACCVisitor.TOP_ST.getParent();
		WACCVisitor.TOP_ST.removeChild();
		return null;
	}

	@Override
	public Operand visitExit_Stat(@NotNull BasicParser.Exit_StatContext ctx) {
		assemblyCode.add(new ARMInstruction(Instruc.MOV, Reg.R0, visit(ctx
				.expr()))); // MOV RO 'whatever operand expr evaluates to'
		// BL exit
		assemblyCode.add(new ARMInstruction(Instruc.BL, new Immediate("exit")));
		return null;
	}

	// Helper method to print statements
	public void p_print_statement(String str) {
		if (!manage.print_string()) {
			endInstruc.add(new Label("p_print_string"));
			enterScope(endInstruc);
			endInstruc.add(new ARMInstruction(Instruc.LDR, Reg.R1, new Address(
					Reg.R0, 0)));
			endInstruc.add(new ARMInstruction(Instruc.ADD, Reg.R2, Reg.R0,
					new Immediate("#4")));
			endInstruc.add(new ARMInstruction(Instruc.LDR, Reg.R0,
					new Immediate(getData("\"%.*s\\0\""))));
			partOfPrint();
		}
	}

	// Helper method to help helper print methods as they have a common last
	// 4 lines and exitscope case
	public void partOfPrint() {
		endInstruc.add(new ARMInstruction(Instruc.ADD, Reg.R0, Reg.R0,
				new Immediate("#4")));
		endInstruc.add(new ARMInstruction(Instruc.BL, new Immediate("printf")));
		endInstruc.add(new ARMInstruction(Instruc.MOV, Reg.R0, new Immediate(
				"#0")));
		endInstruc.add(new ARMInstruction(Instruc.BL, new Immediate("fflush")));
		exitScope(endInstruc);
	}

	// Helper method to print ln
	public void p_print_ln(String str, boolean bool) {
		if (!bool) {
			endInstruc.add(new Label("p_print_ln"));
			enterScope(endInstruc);
			endInstruc.add(new ARMInstruction(Instruc.LDR, Reg.R0,
					new Immediate(getData(str))));
			endInstruc.add(new ARMInstruction(Instruc.ADD, Reg.R0, Reg.R0,
					new Immediate("#4")));
			endInstruc
					.add(new ARMInstruction(Instruc.BL, new Immediate("puts")));
			endInstruc.add(new ARMInstruction(Instruc.MOV, Reg.R0,
					new Immediate("#0")));
			endInstruc.add(new ARMInstruction(Instruc.BL, new Immediate(
					"fflush")));
			exitScope(endInstruc);
		}
	}

	@Override
	public Operand visitPrint_Stat(@NotNull BasicParser.Print_StatContext ctx) {
		Operand reg = visit(ctx.expr());
		print(ctx.expr(), reg);
		return reg;
	}

	public void print(BasicParser.ExprContext ctx, Operand reg) {
		assemblyCode.add(new ARMInstruction(Instruc.MOV, Reg.R0, reg));
		// The expression after println can be many things. One of which is
		// identifiers.
		switch (reg.getType()) {
		case INT:
			DataManager.dataAdd(WACCAssembler.data, DataManager.INT);
			assemblyCode.add(new ARMInstruction(Instruc.BL, new Immediate(
					"p_print_int")));
			p_print_int("\"%d\\0\"");
			break;
		case CHAR:
			assemblyCode.add(new ARMInstruction(Instruc.BL, new Immediate(
					"putchar")));
			p_print_statement("\"%.*s\\0\"");
			break;
		case STRING:
			DataManager.dataAdd(WACCAssembler.data, DataManager.STRING);
			assemblyCode.add(new ARMInstruction(Instruc.BL, new Immediate(
					"p_print_string")));
			p_print_statement("\"%.*s\\0\"");
			break;
		case BOOL:
			assemblyCode.add(new ARMInstruction(Instruc.BL, new Immediate(
					"p_print_bool")));// Add BL p_print_bool to assembly code
			p_print_bool();
			break;
		case ARRAY:
		case NULL:
		case PAIR:
			assemblyCode.add(new ARMInstruction(Instruc.BL, new Immediate(
					"p_print_reference")));
			p_print_reference();
		}
	}

	@Override
	public Operand visitPrintln_Stat(
			@NotNull BasicParser.Println_StatContext ctx) {
		Operand r = visit(ctx.expr());
		print(ctx.expr(), r);
		assemblyCode.add(new ARMInstruction(Instruc.BL, new Immediate(
				"p_print_ln")));
		p_print_ln("\"\\0\"", printedAlready);
		printedAlready = true;
		return r;
	}

	@Override
	public Operand visitFree_Stat(@NotNull BasicParser.Free_StatContext ctx) {
		Type type = WACCVisitor.TOP_ST.lookUpCurrLevelAndEnclosingLevels(ctx
				.expr().getText());
		Reg r = (Reg) visit(ctx.expr());
		assemblyCode.add(new ARMInstruction(Instruc.MOV, Reg.R0, r));
		if (type.toString().equals("PAIR")) {
			assemblyCode.add(new ARMInstruction(Instruc.BL, new Immediate(
					"p_free_pair")));
			p_free_pair();
		}
		return null;
	}

	private void p_free_pair() {
		DataManager.dataAdd(data, DataManager.NULLREF);
		String str = "\"NullReferenceError: dereference a null reference\\n\\0\"";
		if (!manage.freepair()) {
			endInstruc.add(new Label("p_free_pair"));
			enterScope(endInstruc);
			endInstruc.add(new ARMInstruction(Instruc.CMP, Reg.R0,
					new Immediate("#0")));
			endInstruc.add(new ARMInstruction(Instruc.LDREQ, Reg.R0,
					new Immediate(getData(str))));
			endInstruc.add(new ARMInstruction(Instruc.BEQ, new Immediate(
					"p_throw_runtime_error")));
			endInstruc.add(new ARMInstruction(Instruc.PUSH, new Immediate(
					Reg.R0.toString())));
			endInstruc.add(new ARMInstruction(Instruc.LDR, Reg.R0, new Address(
					Reg.R0, 0)));
			endInstruc
					.add(new ARMInstruction(Instruc.BL, new Immediate("free")));
			endInstruc.add(new ARMInstruction(Instruc.LDR, Reg.R0, new Address(
					Reg.SP, 0)));
			endInstruc.add(new ARMInstruction(Instruc.LDR, Reg.R0, new Address(
					Reg.R0, 4)));
			endInstruc
					.add(new ARMInstruction(Instruc.BL, new Immediate("free")));
			endInstruc.add(new ARMInstruction(Instruc.POP, new Immediate(Reg.R0
					.toString())));
			endInstruc
					.add(new ARMInstruction(Instruc.BL, new Immediate("free")));
			exitScope(endInstruc);
			p_throw_runtime_error();
		}
	}

	private void p_print_reference() {
		if (!manage.print_array()) {
			String str = "\"%p\\0\"";
			endInstruc.add(new Label("p_print_reference"));
			enterScope(endInstruc);
			endInstruc.add(new ARMInstruction(Instruc.MOV, Reg.R1, Reg.R0));
			endInstruc.add(new ARMInstruction(Instruc.LDR, Reg.R0,
					new Immediate(getData(str))));
			endInstruc.add(new ARMInstruction(Instruc.ADD, Reg.R0, Reg.R0,
					new Immediate("#4")));
			endInstruc.add(new ARMInstruction(Instruc.BL, new Immediate(
					"printf")));
			endInstruc.add(new ARMInstruction(Instruc.MOV, Reg.R0,
					new Immediate("#0")));
			endInstruc.add(new ARMInstruction(Instruc.BL, new Immediate(
					"fflush")));
			exitScope(endInstruc);
		}
	}

	@Override
	public Operand visitArrayelem(@NotNull BasicParser.ArrayelemContext ctx) {
		Reg reg = availRegs.useRegs();
		Type type = WACCVisitor.TOP_ST.lookUpCurrLevelAndEnclosingLevels(ctx
				.ident().getText());
		if (type == PrimType.STRING) {
			type = new ArrayType(PrimType.CHAR);
		}
		for (int i = 0; i < ctx.expr().size(); i++) {
			type = ((ArrayType) type).getType();
		}
		int t = type.getSize();
		int offset = WACCVisitor.TOP_ST.calculateOffset(ctx.ident().getText());
		assemblyCode.add(new ARMInstruction(Instruc.ADD, reg, Reg.SP,
				new Immediate("#" + offset)));
		for (BasicParser.ExprContext expr : ctx.expr()) {
			Operand r = visit(expr);
			assemblyCode.add(new ARMInstruction(Instruc.LDR, reg, new Address(
					reg, 0)));
			assemblyCode.add(new ARMInstruction(Instruc.MOV, Reg.R0, r));
			assemblyCode.add(new ARMInstruction(Instruc.MOV, Reg.R1, reg));
			assemblyCode.add(new ARMInstruction(Instruc.BL, new Immediate(
					"p_check_array_bounds")));
			assemblyCode.add(new ARMInstruction(Instruc.ADD, reg, reg,
					new Immediate("#4")));
			if (t / 2 > 1) {
				assemblyCode.add(new ARMInstruction(Instruc.ADD, reg, reg, r,
						new Immediate("LSL #" + t / 2)));
			} else {
				assemblyCode.add(new ARMInstruction(Instruc.ADD, reg, reg, r));
			}
			availRegs.addReg((Reg) r);
			p_check_array_bounds();
		}
		return setRegType(reg, type);
	}

	private Reg setRegType(Reg reg, Type type) {
		if (type instanceof Int) {
			reg.setType(Types.INT);
		} else if (type.equals(PrimType.BOOL)) {
			reg.setType(Types.BOOL);
		} else if (type.equals(PrimType.CHAR)) {
			reg.setType(Types.CHAR);
		} else
			reg.setType(Types.STRING);
		return reg;
	}

	@Override
	public Operand visitArrayElem_Expr(
			@NotNull BasicParser.ArrayElem_ExprContext ctx) {
		Operand r = visit(ctx.arrayelem());
		Types type = r.getType();
		assemblyCode.add(new ARMInstruction(type == Types.BOOL
				|| type == Types.CHAR ? Instruc.LDRSB : Instruc.LDR, (Reg) r,
				new Address((Reg) r, 0)));
		return r;
	}

	private void p_check_array_bounds() {
		if (!manage.array_bounds()) {
			String str1 = "\"ArrayIndexOutOfBoundsError: "
					+ "negative index\\n\\0\"";
			String str2 = "\"ArrayIndexOutOfBoundsError: "
					+ "index too large\\n\\0\"";
			endInstruc.add(new Label("p_check_array_bounds"));
			enterScope(endInstruc);
			endInstruc.add(new ARMInstruction(Instruc.CMP, Reg.R0,
					new Immediate("#0")));
			endInstruc.add(new ARMInstruction(Instruc.LDRLT, Reg.R0,
					new Immediate(getData(str1))));
			endInstruc.add(new ARMInstruction(Instruc.BLLT, new Immediate(
					"p_throw_runtime_error")));
			endInstruc.add(new ARMInstruction(Instruc.LDR, Reg.R1, new Address(
					Reg.R1, 0)));
			endInstruc.add(new ARMInstruction(Instruc.CMP, Reg.R0, Reg.R1));
			endInstruc.add(new ARMInstruction(Instruc.LDRCS, Reg.R0,
					new Immediate(getData(str2))));
			endInstruc.add(new ARMInstruction(Instruc.BLCS, new Immediate(
					"p_throw_runtime_error")));
			exitScope(endInstruc);
			p_throw_runtime_error();
		}
	}

	// Helper method to print bools
	private void p_print_bool() {
		if (!manage.print_bool()) {
			endInstruc.add(new Label("p_print_bool"));
			enterScope(endInstruc);
			endInstruc.add(new ARMInstruction(Instruc.CMP, Reg.R0,
					new Immediate("#0")));
			endInstruc.add(new ARMInstruction(Instruc.LDRNE, Reg.R0,
					new Immediate(getData("\"true\\0\""))));
			endInstruc.add(new ARMInstruction(Instruc.LDREQ, Reg.R0,
					new Immediate(getData("\"false\\0\""))));
			partOfPrint();
		}
	}

	// Helper method to print ints
	public void p_print_int(String str) {
		if (!manage.print_int()) {
			endInstruc.add(new Label("p_print_int"));
			enterScope(endInstruc);
			endInstruc.add(new ARMInstruction(Instruc.MOV, Reg.R1, Reg.R0));
			endInstruc.add(new ARMInstruction(Instruc.LDR, Reg.R0,
					new Immediate(getData(str))));
			partOfPrint();
		}
	}

	@Override
	public Operand visitRead_Stat(@NotNull BasicParser.Read_StatContext ctx) {
		// next available register
		if (ctx.assignlhs().getChild(0) instanceof BasicParser.PairelemContext) {
			Reg r = (Reg) visit(ctx.assignlhs().pairelem());
			assemblyCode.add(new ARMInstruction(Instruc.MOV, Reg.R0, r));
			assemblyCode.add(new ARMInstruction(Instruc.BL, new Immediate(
					"p_check_null_pointer")));
			p_check_null_pointer();
			return r;
		}
		Reg avail = availRegs.useRegs();
		int offset = WACCVisitor.TOP_ST.calculateOffset(ctx.assignlhs()
				.getText()); // offset of lhs
		assemblyCode.add(new ARMInstruction(Instruc.ADD, avail, Reg.SP,
				new Immediate("#" + offset)));
		assemblyCode.add(new ARMInstruction(Instruc.MOV, Reg.R0, avail));
		// lhs type as stated by top symboltable

		String type = WACCVisitor.TOP_ST.lookUpCurrLevelAndEnclosingLevels(
				ctx.assignlhs().getText()).toString();
		switch (type) {
		case "INT":
			assemblyCode.add(new ARMInstruction(Instruc.BL, new Immediate(
					"p_read_int")));// Branch into p_read_int if type is int
			if (!manage.read_int())
				p_read("\"%d\\0\"", "int");
			break;
		case "CHAR":
			assemblyCode.add(new ARMInstruction(Instruc.BL, new Immediate(
					"p_read_char")));// Branch into p_read_char if type is char
			if (!manage.read_char())
				p_read("\" %c\\0\"", "char");
		}
		return avail;
	}

	// Helper method that covers all p_read_ cases
	private void p_read(String str, String type) {
		endInstruc.add(new Label("p_read_" + type));
		enterScope(endInstruc);
		endInstruc.add(new ARMInstruction(Instruc.MOV, Reg.R1, Reg.R0));
		endInstruc.add(new ARMInstruction(Instruc.LDR, Reg.R0, new Immediate(
				getData(str))));
		endInstruc.add(new ARMInstruction(Instruc.ADD, Reg.R0, Reg.R0,
				new Immediate("#4")));
		endInstruc.add(new ARMInstruction(Instruc.BL, new Immediate("scanf")));
		exitScope(endInstruc);
	}

	// Visit while stat
	@Override
	public Operand visitWhile_Stat(@NotNull BasicParser.While_StatContext ctx) {
		int i = label;
		label += 2;
		assemblyCode.add(new ARMInstruction(Instruc.B, new Immediate("L" + i))); // Add
																					// //
																					// //
																					// branch
		L1_While(ctx, i + 1);
		return null;
	}

	@Override
	public Operand visitIntLiter_Expr(
			@NotNull BasicParser.IntLiter_ExprContext ctx) {
		Reg availReg = availRegs.useRegs(); // next available register
		availReg.setType(Types.INT); // Set type of register to Int
		String s = ctx.getText();
		int i = Integer.parseInt(s); // the int version of the ctx
		s = Integer.toString(i);
		assemblyCode.add(new ARMInstruction(Instruc.LDR, availReg,
				new Immediate("=" + s)));
		return availReg; // return the register
	}

	// Add data to data field
	public List<Instruction> addData() {
		List<Instruction> list = new ArrayList<Instruction>();
		if (!data.isEmpty()) {
			list.add(Directives.DATA); // Add data directive
			for (int i = 0; i < data.size(); i++) {
				list.add(new Label("msg_" + i));
				String str = data.get(i);
				int length = str.length() - 2; // length of the word added
				int remove = 0;
				for (int j = 0; j < str.length(); j++) {
					if (str.charAt(j) == '\\') {
						remove++;
						j++;
					}
				}
				length -= remove;
				list.add(new Data(length, str));
			}
		}
		return list;
	}

	// Final part of the code
	public void finishCode() {
		List<Instruction> code = addData();
		code.addAll(assemblyCode);
		assemblyCode = code;
	}

	// Prints out the code to the output file
	public void getInstructions() {
		for (Instruction str : assemblyCode) {
			System.out.print(str.toString());
		}
	}

	@Override
	public Operand visitUnaryOper_Expr(
			@NotNull BasicParser.UnaryOper_ExprContext ctx) {
		Operand reg = visit(ctx.expr()); // visit expr
		switch (ctx.start.getType()) {
		case BasicParser.NOT:
			assemblyCode.add(new ARMInstruction(Instruc.EOR, reg, reg,
					new Immediate("#1")));
			break;
		case BasicParser.MINUS:
			DataManager.dataAdd(data, DataManager.OVERFLOW);
			DataManager.dataAdd(data, DataManager.STRING);
			assemblyCode.add(new ARMInstruction(Instruc.RSBS, reg, reg,
					new Immediate("#0")));
			assemblyCode.add(new ARMInstruction(Instruc.BLVS, new Immediate(
					"p_throw_overflow_error")));
			p_throw_overflow_error();
			break;
		case BasicParser.ORD:
			Reg r = (Reg) reg;
			r.setType(Types.INT);// set type to int
			reg = r;
			break;
		case BasicParser.CHR:
			Reg ch = (Reg) reg;
			ch.setType(Types.CHAR);// set type to char
			reg = ch;
			break;
		case BasicParser.LEN:
			assemblyCode.add(new ARMInstruction(Instruc.LDR, reg, new Address(
					Reg.SP, 0)));
			assemblyCode.add(new ARMInstruction(Instruc.LDR, reg, new Address(
					(Reg) reg, 0)));
			Reg len = ((Reg) reg);
			len.setType(Types.INT);
			reg = len;
			break;
		}
		return reg;
	}

	private Reg arrayType(BasicParser.IdentEq_StatContext ctx) {
		int offset = WACCVisitor.TOP_ST.calculateOffset(ctx.IDENT().getText());
		BasicParser.ArrayLiter_assignrhsContext a = (BasicParser.ArrayLiter_assignrhsContext) ctx
				.assignrhs();
		int length = 0;
		if (a.arrayliter().arglist() != null) {
			length = a.arrayliter().arglist().expr().size();
		}
		Reg reg = availRegs.useRegs();
		Type type = WACCVisitor.TOP_ST.lookUpCurrLevelOnly(ctx.IDENT()
				.getText());
		Type innerType = ((ArrayType) type).getType();
		assemblyCode.add(new ARMInstruction(Instruc.LDR, Reg.R0, new Immediate(
				"=" + calculateArray(length, innerType.getSize()))));
		assemblyCode
				.add(new ARMInstruction(Instruc.BL, new Immediate("malloc")));
		assemblyCode.add(new ARMInstruction(Instruc.MOV, reg, Reg.R0));
		int i = 0;
		if (a.arrayliter().arglist() != null) {
			for (i = 0; i < a.arrayliter().arglist().expr().size(); i++) {
				Operand r = visit(a.arrayliter().arglist().expr(i));
				availRegs.addReg((Reg) r);
				assemblyCode.add(new ARMInstruction(r.getType() == Types.BOOL
						|| r.getType() == Types.CHAR ? Instruc.STRB
						: Instruc.STR, r, new Address(reg, 4 + (i * innerType
						.getSize()))));
			}

		}
		Reg r = availRegs.useRegs();
		assemblyCode.add(new ARMInstruction(Instruc.LDR, r, new Immediate("="
				+ i)));
		assemblyCode
				.add(new ARMInstruction(Instruc.STR, r, new Address(reg, 0)));
		assemblyCode.add(new ARMInstruction(Instruc.STR, reg, new Address(
				Reg.SP, offset)));
		return reg;
	}

	private Operand newPair(BasicParser.NewPair_assignrhsContext ctx, Type t,
			int offset) {
		Reg reg = availRegs.useRegs();
		assemblyCode.add(new ARMInstruction(Instruc.LDR, Reg.R0, new Immediate(
				"=8")));
		assemblyCode
				.add(new ARMInstruction(Instruc.BL, new Immediate("malloc")));
		assemblyCode.add(new ARMInstruction(Instruc.MOV, reg, Reg.R0));
		Reg r = (Reg) visit(ctx.expr(0));
		PairType pairType = (PairType) t;
		assemblyCode.add(new ARMInstruction(Instruc.LDR, Reg.R0, new Immediate(
				"=" + pairType.getFst().getSize())));
		assemblyCode
				.add(new ARMInstruction(Instruc.BL, new Immediate("malloc")));
		assemblyCode.add(new ARMInstruction((r.getType() == Types.BOOL || r
				.getType() == Types.CHAR) ? Instruc.STRB : Instruc.STR, r,
				new Address(Reg.R0, 0)));
		assemblyCode.add(new ARMInstruction(Instruc.STR, Reg.R0, new Address(
				reg, 0)));
		availRegs.addReg(r);
		r = (Reg) visit(ctx.expr(1));
		assemblyCode.add(new ARMInstruction(Instruc.LDR, Reg.R0, new Immediate(
				"=" + pairType.getSnd().getSize())));
		assemblyCode
				.add(new ARMInstruction(Instruc.BL, new Immediate("malloc")));
		assemblyCode.add(new ARMInstruction((r.getType() == Types.BOOL || r
				.getType() == Types.CHAR) ? Instruc.STRB : Instruc.STR, r,
				new Address(Reg.R0, 0)));
		assemblyCode.add(new ARMInstruction(Instruc.STR, Reg.R0, new Address(
				reg, 4)));
		assemblyCode.add(new ARMInstruction(Instruc.STR, reg, new Address(
				Reg.SP, offset)));
		return null;

	}

	@Override
	public Operand visitPairelem(@NotNull BasicParser.PairelemContext ctx) {
		Reg reg = availRegs.useRegs();
		int offset = WACCVisitor.TOP_ST.calculateOffset(ctx.expr().getText());
		Type type = ((PairType) WACCVisitor.TOP_ST
				.lookUpCurrLevelAndEnclosingLevels(ctx.expr().getText()))
				.getSnd();
		if (ctx.start.getType() == BasicParser.FST) {
			type = ((PairType) WACCVisitor.TOP_ST
					.lookUpCurrLevelAndEnclosingLevels(ctx.expr().getText()))
					.getFst();
		}
		assemblyCode.add(new ARMInstruction(Instruc.LDR, reg, new Address(
				Reg.SP, offset)));
		assemblyCode.add(new ARMInstruction(Instruc.MOV, Reg.R0, reg));
		assemblyCode.add(new ARMInstruction(Instruc.BL, new Immediate(
				"p_check_null_pointer")));
		p_check_null_pointer();
		if (ctx.start.getText().equals("fst")) {
			assemblyCode.add(new ARMInstruction(Instruc.LDR, reg, new Address(
					reg, 0)));
		} else {
			assemblyCode.add(new ARMInstruction(Instruc.LDR, reg, new Address(
					reg, 4)));
		}
		if (ctx.getParent() instanceof BasicParser.AssignrhsContext) {
			assemblyCode.add(new ARMInstruction(
					(type.getSize() == 1) ? Instruc.LDRSB : Instruc.LDR, reg,
					new Address(reg, 0)));
		}
		return setRegType(reg, type);

	}

	private void p_check_null_pointer() {
		if (!manage.nullReference()) {
			String str = "\"NullReferenceError: dereference a null reference\\n\\0\"";
			endInstruc.add(new Label("p_check_null_pointer"));
			enterScope(endInstruc);
			endInstruc.add(new ARMInstruction(Instruc.CMP, Reg.R0,
					new Immediate("#0")));
			endInstruc.add(new ARMInstruction(Instruc.LDREQ, Reg.R0,
					new Immediate(getData(str))));
			endInstruc.add(new ARMInstruction(Instruc.BLEQ, new Immediate(
					"p_throw_runtime_error")));
			exitScope(endInstruc);
			p_throw_runtime_error();
		}
	}

	@Override
	public Operand visitPairLiter_Expr(
			@NotNull BasicParser.PairLiter_ExprContext ctx) {
		Reg reg = availRegs.useRegs();
		assemblyCode.add(new ARMInstruction(Instruc.LDR, reg, new Immediate(
				"=0")));
		reg.setType(Types.NULL);
		return reg;
	}

	// Visit IdentEq Stat
	@Override
	public Operand visitIdentEq_Stat(
			@NotNull BasicParser.IdentEq_StatContext ctx) {
		WACCVisitor.TOP_ST.addToDeclare(ctx.IDENT().getText());
		// offset between ident and bp
		int offset = WACCVisitor.TOP_ST.calculateOffset(ctx.IDENT().getText());
		ParseTree context = ctx.type().getChild(0);
		if (context instanceof BasicParser.ArraytypeContext
				&& ctx.assignrhs() instanceof BasicParser.ArrayLiter_assignrhsContext) {
			return arrayType(ctx);
		}
		if (context instanceof BasicParser.PairtypeContext
				&& ctx.assignrhs().getStart().getType() == BasicParser.NEWPAIR) {
			Type type = WACCVisitor.TOP_ST
					.lookUpCurrLevelAndEnclosingLevels(ctx.IDENT().getText());
			BasicParser.NewPair_assignrhsContext newpair = (BasicParser.NewPair_assignrhsContext) ctx
					.assignrhs();
			return newPair(newpair, type, offset);
		}
		Operand reg = visit(ctx.assignrhs());
		// switch on the type of the first node of ctx
		Type type = WACCVisitor.TOP_ST.lookUpCurrLevelAndEnclosingLevels(ctx
				.IDENT().getText());
		if (type.isOfType(new ArrayType(PrimType.ANY))
				|| type.isOfType(new PairType(PrimType.ANY, PrimType.ANY))) {
			if (offset == 0) {
				assemblyCode.add(new ARMInstruction(Instruc.STR, reg,
						new Address(Reg.SP, 0)));
			} else {
				assemblyCode.add(new ARMInstruction(Instruc.STR, reg,
						new Address(Reg.SP, offset)));
			}
			return null;
		}
		switch (ctx.start.getType()) {
		case BasicParser.CHAR:
		case BasicParser.BOOL:
			assemblyCode.add(new ARMInstruction(Instruc.STRB, reg, new Address(
					Reg.SP, offset)));
			break;
		case BasicParser.INT:
		default:
			if (offset == 0) {
				assemblyCode.add(new ARMInstruction(Instruc.STR, reg,
						new Address(Reg.SP, 0)));
			} else {
				assemblyCode.add(new ARMInstruction(Instruc.STR, reg,
						new Address(Reg.SP, offset)));
			}
			break;
		}
		return null;
	}

	// Calculates the number of bytes used by the array for each element
	private int calculateArray(int elems, int type) {
		return (elems * type) + 4;
	}

	// Visits Begin statement
	@Override
	public Operand visitBegin_Stat(@NotNull BasicParser.Begin_StatContext ctx) {
		WACCVisitor.TOP_ST = WACCVisitor.TOP_ST.getChildren().get(0);
		WACCVisitor.TOP_ST.calculateScope();
		createSub();
		visit(ctx.stat());
		createAdd();
		WACCVisitor.TOP_ST = WACCVisitor.TOP_ST.getParent();
		WACCVisitor.TOP_ST.removeChild();
		return null;
	}

	@Override
	public Operand visitCharLiter_Expr(
			@NotNull BasicParser.CharLiter_ExprContext ctx) {
		Reg availReg = availRegs.useRegs();
		availReg.setType(Types.CHAR);
		String str = "0";
		if (!ctx.getText().equals("'\\0'")) {
			str = ctx.getText();
		}
		assemblyCode.add(new ARMInstruction(Instruc.MOV, availReg,
				new Immediate("#" + str)));
		return availReg;
	}

	// Subtract from stack pointer
	private void createSub() {
		int scope = WACCVisitor.TOP_ST.getTotalScope();
		while (scope > 0) {
			assemblyCode.add(new ARMInstruction(Instruc.SUB, Reg.SP, Reg.SP,
					new Immediate("#" + Math.min(scope, 1024))));
			scope -= 1024;
		}
	}

	// Add to stack pointer
	private void createAdd() {
		int scope = WACCVisitor.TOP_ST.getTotalScope();
		while (scope > 0) {
			assemblyCode.add(new ARMInstruction(Instruc.ADD, Reg.SP, Reg.SP,
					new Immediate("#" + Math.min(scope, 1024))));
			scope -= 1024;
		}
	}

	@Override
	public Operand visitAssignLhsRhs_Stat(
			@NotNull BasicParser.AssignLhsRhs_StatContext ctx) {
		Operand avail = visit(ctx.assignrhs());
		ParseTree context = ctx.assignlhs().getChild(0);
		if (context instanceof BasicParser.ArrayelemContext) {
			Operand r = visit(ctx.assignlhs().arrayelem());
			assemblyCode.add(new ARMInstruction(Instruc.STRB, avail,
					new Address((Reg) r, 0)));
			return null;
		}
		if (context instanceof BasicParser.PairelemContext) {
			Operand r = visit(ctx.assignlhs().pairelem());
			assemblyCode.add(new ARMInstruction(Instruc.STRB, avail,
					new Address((Reg) r, 0)));
			return null;
		}
		Type type = WACCVisitor.TOP_ST.lookUpCurrLevelAndEnclosingLevels(ctx
				.assignlhs().getText());
		int offset = WACCVisitor.TOP_ST.calculateOffset(ctx.assignlhs()
				.getText());
		if (type.equals(PrimType.BOOL) || type.equals(PrimType.CHAR)) {
			assemblyCode.add(new ARMInstruction(Instruc.STRB, avail,
					new Address(Reg.SP, offset))); // STRB for bools and chars
		} else {
			assemblyCode.add(new ARMInstruction(Instruc.STR, avail,
					new Address(Reg.SP, offset))); // STR for everything else
		}
		return null;
	}

	@Override
	public Operand visitAssignlhs(@NotNull BasicParser.AssignlhsContext ctx) {
		// AssingLHS ctx is always an ident
		return visit(ctx.ident());
	}

	@Override
	public Operand visitExp_assignrhs(
			@NotNull BasicParser.Exp_assignrhsContext ctx) {
		// Exp_assignrhs is basically an expr tbh
		return visit(ctx.expr());
	}

	@Override
	public Operand visitFactor_Expr(@NotNull BasicParser.Factor_ExprContext ctx) {
		Operand reg1 = visit(ctx.expr(0));
		Operand reg2 = visit(ctx.expr(1));
		switch (ctx.getChild(1).getText()) {
		case "*":
			assemblyCode.add(new ARMInstruction(Instruc.SMULL, reg1, reg2,
					reg1, reg2));
			assemblyCode.add(new ARMInstruction(Instruc.CMP, reg2, reg1,
					new Immediate("ASR #31")));
			// Important in case there is a multiplication error
			assemblyCode.add(new ARMInstruction(Instruc.BLNE, new Immediate(
					"p_throw_overflow_error")));
			p_throw_overflow_error();
			break;
		case "/":
			assemblyCode.add(new ARMInstruction(Instruc.MOV, Reg.R0, reg1));
			assemblyCode.add(new ARMInstruction(Instruc.MOV, Reg.R1, reg2));
			// Imporant in case someone decides to divide by zero or something
			assemblyCode.add(new ARMInstruction(Instruc.BL, new Immediate(
					"p_check_divide_by_zero")));
			p_check_divide_by_zero();
			// Some built in stuff not sure what it does yet
			assemblyCode.add(new ARMInstruction(Instruc.BL, new Immediate(
					"__aeabi_idiv")));
			assemblyCode.add(new ARMInstruction(Instruc.MOV, reg1, Reg.R0));
			break;
		case "%":
			assemblyCode.add(new ARMInstruction(Instruc.MOV, Reg.R0, reg1));
			assemblyCode.add(new ARMInstruction(Instruc.MOV, Reg.R1, reg2));
			// Imporant in case someone decides to divide by zero or something
			assemblyCode.add(new ARMInstruction(Instruc.BL, new Immediate(
					"p_check_divide_by_zero")));
			p_check_divide_by_zero();
			assemblyCode.add(new ARMInstruction(Instruc.BL, new Immediate(
			// Some built in stuff not sure what it does yet
					"__aeabi_idivmod")));
			assemblyCode.add(new ARMInstruction(Instruc.MOV, reg1, Reg.R1));
		}
		Reg r = (Reg) reg1;
		r.setType(Types.INT);
		return r;
	}

	// Visit Term_Exp, largely self explanatory
	@Override
	public Operand visitTerm_Expr(@NotNull BasicParser.Term_ExprContext ctx) {
		Operand reg1 = visit(ctx.expr(0));
		if (!availRegs.hasNext()) {
			assemblyCode.add(new ARMInstruction(Instruc.PUSH, new Immediate(
					reg1.toString())));
		}
		Operand reg2 = visit(ctx.expr(1));
		if (reg1.toString().equals(reg2.toString())) {
			assemblyCode.add(new ARMInstruction(Instruc.POP, Reg.R11));
			reg2 = Reg.R11;
		}
		switch (ctx.getChild(1).getText()) {
		case "+":
			assemblyCode
					.add(new ARMInstruction(Instruc.ADDS, reg1, reg1, reg2));
			break;
		case "-":
			assemblyCode
					.add(new ARMInstruction(Instruc.SUBS, reg1, reg1, reg2));
			break;
		}

		// In case the ints supplied are higher than the int values we can hold
		assemblyCode.add(new ARMInstruction(Instruc.BLVS, new Immediate(
				"p_throw_overflow_error")));
		p_throw_overflow_error();
		Reg r = (Reg) reg1;
		r.setType(Types.INT);
		return r;
	}

	// Implementation of what happens when you have an overflow error
	private void p_throw_overflow_error() {
		if (!manage.overflow()) {
			String str = "\"OverflowError: the result is too small"
					+ "/large to store in a 4-byte signed-integer.\\n\"";
			endInstruc.add(new Label("p_throw_overflow_error"));
			endInstruc.add(new ARMInstruction(Instruc.LDR, Reg.R0,
					new Immediate(getData(str))));
			endInstruc.add(new ARMInstruction(Instruc.BL, new Immediate(
					"p_throw_runtime_error")));
			p_throw_runtime_error();
		}

	}

	// Implementation of what happens when you have a runtime error
	private void p_throw_runtime_error() {
		if (!manage.runtime()) {
			endInstruc.add(new Label("p_throw_runtime_error"));
			endInstruc.add(new ARMInstruction(Instruc.BL, new Immediate(
					"p_print_string")));
			endInstruc.add(new ARMInstruction(Instruc.MOV, Reg.R0,
					new Immediate("#-1")));
			endInstruc
					.add(new ARMInstruction(Instruc.BL, new Immediate("exit")));
			p_print_statement("\"%.*s\\0\"");
		}
	}

	// Implementation of what happens when you have a divide by zero error
	private void p_check_divide_by_zero() {
		String str = "\"DivideByZeroError: divide or modul by zero\\n\\0\"";
		endInstruc.add(new Label("p_check_divide_by_zero"));
		enterScope(endInstruc);
		endInstruc.add(new ARMInstruction(Instruc.CMP, Reg.R1, new Immediate(
				"#0")));
		endInstruc.add(new ARMInstruction(Instruc.LDREQ, Reg.R0, new Immediate(
				getData(str))));
		endInstruc.add(new ARMInstruction(Instruc.BLEQ, new Immediate(
				"p_throw_runtime_error")));
		exitScope(endInstruc);
		p_throw_runtime_error();
	}

	// Visit IDENT
	@Override
	public Operand visitIdent(@NotNull BasicParser.IdentContext ctx) {
		String str = ctx.IDENT().getText();
		int offset = WACCVisitor.TOP_ST.calculateOffset(str);
		Address add = new Address(Reg.SP, offset);
		Reg avail = availRegs.useRegs();
		Type type = WACCVisitor.TOP_ST.lookUpCurrLevelAndEnclosingLevels(str);
		switch (type.toString()) {
		case "CHAR":
			avail.setType(Types.CHAR);
			assemblyCode.add(new ARMInstruction(Instruc.LDRSB, avail, add));
			break;
		case "BOOL":
			avail.setType(Types.BOOL);
			assemblyCode.add(new ARMInstruction(Instruc.LDRSB, avail, add));
			break;
		case "INT":
			avail.setType(Types.INT);
			assemblyCode.add(new ARMInstruction(Instruc.LDR, avail, add));
			break;
		case "STRING":

			avail.setType(Types.STRING);
			assemblyCode.add(new ARMInstruction(Instruc.LDR, avail, add));
			break;
		case "ARRAY":
			avail.setType(Types.ARRAY);
			if (((ArrayType) type).getType().isOfType(PrimType.CHAR)) {
				avail.setType(Types.STRING);
			}
			assemblyCode.add(new ARMInstruction(Instruc.LDR, avail,
					new Address(Reg.SP, offset)));
			break;
		case "PAIR":
			avail.setType(Types.PAIR);
			assemblyCode.add(new ARMInstruction(Instruc.LDR, avail,
					new Address(Reg.SP, offset)));
			break;
		}
		return avail;
	}

	@Override
	public Operand visitStrLiter_Expr(
			@NotNull BasicParser.StrLiter_ExprContext ctx) {
		WACCAssembler.data.add(ctx.getText());
		Reg avail = availRegs.useRegs();
		avail.setType(Types.STRING);
		// Add the associated data label of the string to code
		assemblyCode.add(new ARMInstruction(Instruc.LDR, avail, new Immediate(
				"=msg_" + Integer.toString(data.size() - 1))));
		return avail;
	}

	// Visit Compare Expression, largely self explanatory
	@Override
	public Operand visitCompare_Expr(
			@NotNull BasicParser.Compare_ExprContext ctx) {
		Operand arg1 = visit(ctx.expr(0));
		Operand arg2 = visit(ctx.expr(1));

		assemblyCode.add(new ARMInstruction(Instruc.CMP, arg1, arg2));

		switch (ctx.getChild(1).getText()) {
		case "<":
			assemblyCode.add(new ARMInstruction(Instruc.MOVLT, arg1,
					new Immediate("#1")));
			assemblyCode.add(new ARMInstruction(Instruc.MOVGE, arg1,
					new Immediate("#0")));
			break;
		case "<=":
			assemblyCode.add(new ARMInstruction(Instruc.MOVLE, arg1,
					new Immediate("#1")));
			assemblyCode.add(new ARMInstruction(Instruc.MOVGT, arg1,
					new Immediate("#0")));
			break;
		case ">":
			assemblyCode.add(new ARMInstruction(Instruc.MOVGT, arg1,
					new Immediate("#1")));
			assemblyCode.add(new ARMInstruction(Instruc.MOVLE, arg1,
					new Immediate("#0")));
			break;
		case ">=":
			assemblyCode.add(new ARMInstruction(Instruc.MOVGE, arg1,
					new Immediate("#1")));
			assemblyCode.add(new ARMInstruction(Instruc.MOVLT, arg1,
					new Immediate("#0")));
			break;
		default:
		}
		Reg h = (Reg) arg1; // Set type of reg
		h.setType(Types.BOOL);
		return arg1;
	}

	// String representation of the .data DIRECTIVE
	public String getData(String s) {
		StringBuilder str = new StringBuilder();
		str.append("=msg_");
		for (int i = 0; i < data.size(); i++) {
			if (data.get(i).equals(s)) {
				str.append(Integer.toString(i));
				break;
			}
		}
		return str.toString();
	}

}
