package codeGen;

import java.util.ArrayList;

import java.util.List;
import org.antlr.v4.runtime.misc.NotNull;

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
import WACCFrontEnd.PrimType;
import WACCFrontEnd.Type;
import WACCFrontEnd.WACCVisitor;
import antlr.BasicParser;
import antlr.BasicParserBaseVisitor;

public class WACCAssembler extends BasicParserBaseVisitor<Operand> {

	// Creating a list that stores all the instructions.
	public static List<Instruction> assemblyCode = new ArrayList<>();
	// Storing datas.
	public static List<String> data = new ArrayList<>();
	public static RegManager availRegs = new RegManager();
	// static List<Reg> availRegs = Reg.getRegs();
	// Instructions that come after the main code.
	private List<Instruction> endInstruc = new ArrayList<>();
	// This should only be printed once.
	boolean printedAlready = false;
	PrintManager manage = new PrintManager();

	@Override
	public Operand visitProgram(@NotNull BasicParser.ProgramContext ctx) {
		WACCVisitor.TOP_ST.calculateScope();
		addData();
		assemblyCode.add(Directives.TEXT);
		assemblyCode.add(Directives.GLOBALM);
		List<BasicParser.FuncContext> functions = ctx.func();
		if (functions != null) {
			for (BasicParser.FuncContext func : functions) {
				visitFunc(func);
			}
		}
		assemblyCode.add(new Label("main"));
		enterScope(assemblyCode);
		createSub();
		visit(ctx.stat());
		createAdd();
		assemblyCode.add(new ARMInstruction(Instruc.LDR, Reg.R0, new Immediate(
				"=0")));
		exitScope(assemblyCode);
		assemblyCode.add(Directives.LTORG);
		assemblyCode.addAll(endInstruc);
		return null;
	}

	public void enterScope(List<Instruction> list) {
		list.add(new ARMInstruction(Instruc.PUSH, Reg.LR));
	}

	public void exitScope(List<Instruction> list) {
		list.add(new ARMInstruction(Instruc.POP, Reg.PC));
	}

	@Override
	public Operand visitSemicolon_Stat(
			@NotNull BasicParser.Semicolon_StatContext ctx) {
		visit(ctx.stat(0));
		availRegs.refreshReg();
		visit(ctx.stat(1));
		return null;
	}

	private Operand andOr(Instruc i, BasicParser.ExprContext ctx1,
			BasicParser.ExprContext ctx2) {
		Operand reg1 = visit(ctx1);
		Operand reg2 = visit(ctx2);
		assemblyCode.add(new ARMInstruction(i, reg1, reg1, reg2));
		Reg r = (Reg) reg1;
		r.setType(Types.BOOL);
		return r;
	}

	@Override
	public Operand visitParenth_Expr(@NotNull BasicParser.Parenth_ExprContext ctx) {
		return visit(ctx.expr());
	}

	@Override
	public Operand visitAnd_Expr(@NotNull BasicParser.And_ExprContext ctx) {
		return andOr(Instruc.AND, ctx.expr(0), ctx.expr(1));
	}

	@Override
	public Operand visitOr_Expr(@NotNull BasicParser.Or_ExprContext ctx) {
		return andOr(Instruc.ORR, ctx.expr(0), ctx.expr(1));
	}

	private void L1_While(BasicParser.While_StatContext ctx) {
		assemblyCode.add(new Label("L1"));
		visit(ctx.stat());
		L0_While(ctx);
	}

	@Override
	public Operand visitEquality_Expr(
			@NotNull BasicParser.Equality_ExprContext ctx) {
		String oper = ctx.getChild(1).getText();
		Operand reg1 = visit(ctx.expr(0));
		Operand reg2 = visit(ctx.expr(1));
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
		r.setType(Types.BOOL);
		return reg1;
	}

	private void L0_While(BasicParser.While_StatContext ctx) {
		assemblyCode.add(new Label("L0"));
		Reg r = availRegs.useRegs();
		assemblyCode.add(new ARMInstruction(Instruc.LDRSB, r, new Address(
				Reg.SP, new Immediate("4"))));
		assemblyCode
				.add(new ARMInstruction(Instruc.CMP, r, new Immediate("#1")));
		assemblyCode.add(new ARMInstruction(Instruc.BEQ, new Immediate("L1")));
	}

	@Override
	public Operand visitBool_Liter(@NotNull BasicParser.Bool_LiterContext ctx) {
		Reg avail = availRegs.useRegs();
		avail.setType(Types.BOOL);
		if (ctx.getText().equals("false")) {
			assemblyCode.add(new ARMInstruction(Instruc.MOV, avail,
					new Immediate("#0")));
		} else
			assemblyCode.add(new ARMInstruction(Instruc.MOV, avail,
					new Immediate("#1")));
		return avail;
	}

	@Override
	public Operand visitIf_Stat(@NotNull BasicParser.If_StatContext ctx) {
		Operand reg = visit(ctx.expr());
		assemblyCode.add(new ARMInstruction(Instruc.CMP, reg, new Immediate(
				"#0")));
		assemblyCode.add(new ARMInstruction(Instruc.BEQ, new Immediate("L0")));
		visit(ctx.stat(0));
		assemblyCode.add(new ARMInstruction(Instruc.B, new Immediate("L1")));
		assemblyCode.add(new Label("L0"));
		visit(ctx.stat(1));
		assemblyCode.add(new Label("L1"));
		return null;
	}

	@Override
	public Operand visitExit_Stat(@NotNull BasicParser.Exit_StatContext ctx) {
		assemblyCode.add(new ARMInstruction(Instruc.MOV, Reg.R0, visit(ctx
				.expr())));
		assemblyCode.add(new ARMInstruction(Instruc.BL, new Immediate("exit")));
		return null;
	}

	public void p_print_statement(String str) {
		if (!manage.print_string()) {
			endInstruc.add(new Label("p_print_string"));
			enterScope(endInstruc);
			endInstruc.add(new ARMInstruction(Instruc.LDR, Reg.R1, new Address(
					Reg.R0, null)));
			endInstruc.add(new ARMInstruction(Instruc.ADD, Reg.R2, Reg.R0,
					new Immediate("#4")));
			endInstruc.add(new ARMInstruction(Instruc.LDR, Reg.R0,
					new Immediate(getData("\"%.*s\\0\""))));
			partOfPrint();
		}
	}

	public void partOfPrint() {
		endInstruc.add(new ARMInstruction(Instruc.ADD, Reg.R0, Reg.R0,
				new Immediate("#4")));
		endInstruc.add(new ARMInstruction(Instruc.BL, new Immediate("printf")));
		endInstruc.add(new ARMInstruction(Instruc.MOV, Reg.R0, new Immediate(
				"#0")));
		endInstruc.add(new ARMInstruction(Instruc.BL, new Immediate("fflush")));
		exitScope(endInstruc);
	}

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
		return print(ctx.expr());
	}

	public Operand print(BasicParser.ExprContext ctx) {
		Operand reg = visit(ctx);
		assemblyCode.add(new ARMInstruction(Instruc.MOV, Reg.R0, reg));
		// The expression after println can be many things. One of which is
		// identifiers.
		switch (reg.getType()) {
		case INT:
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
			assemblyCode.add(new ARMInstruction(Instruc.BL, new Immediate(
					"p_print_string")));
			p_print_statement("\"%.*s\\0\"");
			break;
		case BOOL:
			assemblyCode.add(new ARMInstruction(Instruc.BL, new Immediate(
					"p_print_bool")));
			p_print_bool();
			break;
		}
		return reg;
	}

	private void p_print_bool() {
		// TODO Auto-generated method stub
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
		Reg avail = availRegs.useRegs();
		int offset = WACCVisitor.TOP_ST.calculateOffset(ctx.assignlhs()
				.getText());
		assemblyCode.add(new ARMInstruction(Instruc.ADD, avail, Reg.SP,
				new Immediate("#" + offset)));
		assemblyCode.add(new ARMInstruction(Instruc.MOV, Reg.R0, avail));
		String type = WACCVisitor.TOP_ST.lookUpCurrLevelAndEnclosingLevels(
				ctx.assignlhs().getText()).toString();
		switch (type) {
		case "INT":
			assemblyCode.add(new ARMInstruction(Instruc.BL, new Immediate(
					"p_read_int")));
			if (!manage.read_int())
				p_read("\"%d\\0\"", "int");
			break;
		case "CHAR":
			assemblyCode.add(new ARMInstruction(Instruc.BL, new Immediate(
					"p_read_char")));
			if (!manage.read_char())
				p_read("\" %c\\0\"", "char");
		}
		return avail;
	}

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

	@Override
	public Operand visitPrintln_Stat(
			@NotNull BasicParser.Println_StatContext ctx) {
		Operand reg = print(ctx.expr());
		assemblyCode.add(new ARMInstruction(Instruc.BL, new Immediate(
				"p_print_ln")));
		p_print_ln("\"\\0\"", printedAlready);
		printedAlready = true;
		return reg;
	}

	@Override
	public Operand visitWhile_Stat(@NotNull BasicParser.While_StatContext ctx) {
		assemblyCode.add(new ARMInstruction(Instruc.BL, new Immediate("L0")));
		L1_While(ctx);
		return null;
	}

	@Override
	public Operand visitIntLiter_Expr(
			@NotNull BasicParser.IntLiter_ExprContext ctx) {
		Reg availReg = availRegs.useRegs();
		availReg.setType(Types.INT);
		String s = ctx.getText();
		int i = Integer.parseInt(s);
		s = Integer.toString(i);
		assemblyCode.add(new ARMInstruction(Instruc.LDR, availReg,
				new Immediate("=" + s)));
		return availReg;
	}

	public void addData() {
		if (!data.isEmpty()) {
			assemblyCode.add(Directives.DATA);
			for (int i = 0; i < data.size(); i++) {
				assemblyCode.add(new Label("msg_" + i));
				String str = data.get(i);
				int length = str.length() - 2;
				if (str.contains("\\0")) {
					length -= 1;
				}
				assemblyCode.add(new Data(length, str));
			}
		}
	}

	public static List<Instruction> getCode() {
		return assemblyCode;
	}

	public void getInstructions() {
		for (Instruction str : assemblyCode) {
			System.out.print(str.toString());
		}
	}

	@Override
	public Operand visitUnaryOper_Expr(
			@NotNull BasicParser.UnaryOper_ExprContext ctx) {
		Operand reg = visit(ctx.expr());
		switch (ctx.start.getType()) {
		case BasicParser.NOT:
			assemblyCode.add(new ARMInstruction(Instruc.EOR, reg, reg,
					new Immediate("#1")));
			break;
		case BasicParser.MINUS:
			assemblyCode.add(new ARMInstruction(Instruc.RSBS, reg, reg,
					new Immediate("#0")));
			break;
		case BasicParser.ORD:
			Reg r = (Reg) reg;
			r.setType(Types.INT);
			reg = r;
			break;
		case BasicParser.CHR:
			Reg ch = (Reg) reg;
			ch.setType(Types.CHAR);
			reg = ch;
			break;
		}
		return reg;
	}

	@Override
	public Operand visitIdentEq_Stat(
			@NotNull BasicParser.IdentEq_StatContext ctx) {
		int offset = WACCVisitor.TOP_ST.calculateOffset(ctx.IDENT().getText());
		if (ctx.type().getChild(0) instanceof BasicParser.ArraytypeContext) {
			BasicParser.ArrayLiter_assignrhsContext a = (BasicParser.ArrayLiter_assignrhsContext) ctx.assignrhs();
			int length = 0;
			if (a.arrayliter().arglist() != null) {
				length = a.arrayliter().arglist().expr().size();				
			}
			Reg reg = availRegs.useRegs();
			Type type = WACCVisitor.TOP_ST.lookUpCurrLevelOnly(ctx.IDENT().getText());
			Type innerType = ((ArrayType) type).getType();
			assemblyCode.add(new ARMInstruction(Instruc.LDR, Reg.R0, new Immediate("=" + calculateArray(length, innerType.getSize()))));
			assemblyCode.add(new ARMInstruction(Instruc.BL, new Immediate("malloc")));
			assemblyCode.add(new ARMInstruction(Instruc.MOV, reg, Reg.R0));
			int i = 0;
			if (a.arrayliter().arglist() != null) {
				for (i = 0; i < a.arrayliter().arglist().expr().size(); i++) {
					Operand r = visit(a.arrayliter().arglist().expr(i));
					availRegs.addReg((Reg) r);
					assemblyCode.add(new ARMInstruction(Instruc.STR, r, new Address(reg ,new Immediate(Integer.toString((i+1) * innerType.getSize())))));
				}				
			}
			Reg r = availRegs.useRegs();
			assemblyCode.add(new ARMInstruction(Instruc.LDR, r, new Immediate("=" + i)));
			assemblyCode.add(new ARMInstruction(Instruc.STR, r, new Address(reg, 0)));
			assemblyCode.add(new ARMInstruction(Instruc.STR, reg, new Address(Reg.SP, offset)));
			return reg;
		}
		Operand reg = visit(ctx.assignrhs());
		switch (ctx.start.getType()) {
		case BasicParser.CHAR:
		case BasicParser.BOOL:
			assemblyCode.add(new ARMInstruction(Instruc.STRB, reg, new Address(
					Reg.SP, offset)));
			break;
		case BasicParser.INT:
		case BasicParser.STRING:
			if (offset == 0) {
				assemblyCode.add(new ARMInstruction(Instruc.STR, reg,
						new Address(Reg.SP, null)));
			} else {
				assemblyCode.add(new ARMInstruction(Instruc.STR, reg,
						new Address(Reg.SP, new Immediate("" + offset))));
			}
			break;
		}
		
		return null;
	}
	
	private int calculateArray(int elems, int type) {
		return (elems * type) + 4;
	}
	
	@Override
	public Operand visitBegin_Stat(@NotNull BasicParser.Begin_StatContext ctx) {
		Reg availReg = availRegs.useRegs();
		assemblyCode.add(new ARMInstruction(Instruc.LDR, availReg,
				new Immediate("=" + ctx.getText())));
		return availReg;
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

	private void createSub() {
		int scope = WACCVisitor.TOP_ST.getTotalScope();
		while (scope > 0) {
			assemblyCode.add(new ARMInstruction(Instruc.SUB, Reg.SP, Reg.SP,
					new Immediate("#" + Math.min(scope, 1024))));
			scope -= 1024;
		}
	}

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
		Type type = WACCVisitor.TOP_ST.lookUpCurrLevelAndEnclosingLevels(ctx
				.assignlhs().getText());
		Operand avail = visit(ctx.assignrhs());
		if (type.equals(PrimType.BOOL) || type.equals(PrimType.CHAR)) {
			assemblyCode.add(new ARMInstruction(Instruc.STRB, avail,
					new Address(Reg.SP, null)));
		} else {
			assemblyCode.add(new ARMInstruction(Instruc.STR, avail,
					new Address(Reg.SP, null)));
		}
		return null;
	}

	@Override
	public Operand visitAssignlhs(@NotNull BasicParser.AssignlhsContext ctx) {
		return visit(ctx.ident());
	}

	@Override
	public Operand visitExp_assignrhs(
			@NotNull BasicParser.Exp_assignrhsContext ctx) {
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
			assemblyCode.add(new ARMInstruction(Instruc.BLNE, new Immediate(
					"p_throw_overflow_error")));
			p_throw_overflow_error();
			break;
		case "/":
			assemblyCode.add(new ARMInstruction(Instruc.MOV, Reg.R0, reg1));
			assemblyCode.add(new ARMInstruction(Instruc.MOV, Reg.R1, reg2));
			assemblyCode.add(new ARMInstruction(Instruc.BL, new Immediate(
					"p_check_divide_by_zero")));
			p_check_divide_by_zero();
			assemblyCode.add(new ARMInstruction(Instruc.BL, new Immediate(
					"__aeabi_idiv")));
			assemblyCode.add(new ARMInstruction(Instruc.MOV, reg1, Reg.R0));
			break;
		case "%":
			assemblyCode.add(new ARMInstruction(Instruc.MOV, Reg.R0, reg1));
			assemblyCode.add(new ARMInstruction(Instruc.MOV, Reg.R1, reg2));
			assemblyCode.add(new ARMInstruction(Instruc.BL, new Immediate(
					"p_check_divide_by_zero")));
			p_check_divide_by_zero();
			assemblyCode.add(new ARMInstruction(Instruc.BL, new Immediate(
					"__aeabi_idivmod")));
			assemblyCode.add(new ARMInstruction(Instruc.MOV, reg1, Reg.R1));
		}
		Reg r = (Reg) reg1;
		r.setType(Types.INT);
		return r;
	}

	@Override
	public Operand visitTerm_Expr(@NotNull BasicParser.Term_ExprContext ctx) {
		Operand reg1 = visit(ctx.expr(0));
		Operand reg2 = visit(ctx.expr(1));
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
		assemblyCode.add(new ARMInstruction(Instruc.BLVS, new Immediate(
				"p_throw_overflow_error")));
		p_throw_overflow_error();
		Reg r = (Reg) reg1;
		r.setType(Types.INT);
		return r;
	}

	private void p_throw_overflow_error() {
		if (!manage.runtime()) {
			String str = "\"OverflowError: the result is too small/large to store in a 4-byte signed-integer.\\n\"";
			endInstruc.add(new Label("p_throw_overflow_error"));
			endInstruc.add(new ARMInstruction(Instruc.LDR, Reg.R0,
					new Immediate(getData(str))));
			endInstruc.add(new ARMInstruction(Instruc.BL, new Immediate(
					"p_throw_runtime_error")));
			p_throw_runtime_error();
		}

	}

	private void p_throw_runtime_error() {
		endInstruc.add(new Label("p_throw_runtime_error"));
		endInstruc.add(new ARMInstruction(Instruc.BL, new Immediate(
				"p_print_string")));
		endInstruc.add(new ARMInstruction(Instruc.MOV, Reg.R0, new Immediate(
				"#-1")));
		endInstruc.add(new ARMInstruction(Instruc.BL, new Immediate("exit")));
		p_print_statement("\"%.*s\\0\"");
	}

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

	@Override
	public Operand visitIdent(@NotNull BasicParser.IdentContext ctx) {
		String str = ctx.IDENT().getText();
		int offset = WACCVisitor.TOP_ST.calculateOffset(str);
		Address add = new Address(Reg.SP, offset);
		Reg avail = availRegs.useRegs();
		switch (WACCVisitor.TOP_ST.lookUpCurrLevelAndEnclosingLevels(str)
				.toString()) {
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
		}
		return avail;
	}

	@Override
	public Operand visitStrLiter_Expr(
			@NotNull BasicParser.StrLiter_ExprContext ctx) {
		Reg avail = availRegs.useRegs();
		avail.setType(Types.STRING);
		assemblyCode.add(new ARMInstruction(Instruc.LDR, avail, new Immediate(
				getData(ctx.getText()))));
		return avail;
	}

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
		Reg h = (Reg) arg1;
		h.setType(Types.BOOL);
		return arg1;
	}

	public Operand visitArrayliter(
			@NotNull BasicParser.ArrayliterContext ctx) {
		return visit(ctx.arglist());
	}
	
	public Operand visitArglist(
			@NotNull BasicParser.ArglistContext ctx) {
		List<BasicParser.ExprContext> l = ctx.expr();
		Reg reg = availRegs.useRegs();
		Reg reg2 = availRegs.useRegs();
		for (BasicParser.ExprContext elem : l) {
			assemblyCode.add(new ARMInstruction(Instruc.LDR, reg, 
					new Immediate(elem.getText())));
/*			assemblyCode.add(new ARMInstruction(Instruc.STR, reg2,
					new Address(reg, new Immediate(
							(WACCVisitor.TOP_ST.calculateOffset(reg.toString()
									))))));*/
		}
		return reg;
	}
	
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
