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
import antlr.BasicParser.ArrayelemContext;
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
	int label = 0;
	PrintManager manage = new PrintManager();

	//Visit a Program Context
	@Override
	public Operand visitProgram(@NotNull BasicParser.ProgramContext ctx) {
		WACCVisitor.TOP_ST.calculateScope(); //Calculate 
		addData(); //Add program data to .data
		assemblyCode.add(Directives.TEXT); //Add .text directive 
		assemblyCode.add(Directives.GLOBALM);//Add .global main to code
		List<BasicParser.FuncContext> functions = ctx.func();
		if (functions != null) {
			for (BasicParser.FuncContext func : functions) {
				visitFunc(func); //Visit every function in the program
			}
		}
		assemblyCode.add(new Label("main"));//Create main Label
		enterScope(assemblyCode);//add Push {LR} to assembly code
		createSub(); //Add "sub scope from stack pointer statement" to code
		visit(ctx.stat()); //visit Program Statement
		createAdd(); //Add "add scope from stack pointer statement" to code
		assemblyCode.add(new ARMInstruction(Instruc.LDR, Reg.R0, new Immediate(
				"=0")));//Load register RO with 0
		exitScope(assemblyCode); //add Pop {PC} to assembly code
		assemblyCode.add(Directives.LTORG);//Add .ltorg directive to code
		assemblyCode.addAll(endInstruc);//Add all end Instructions if any
		finishCode();
		return null;
	}

	public void enterScope(List<Instruction> list) {
		//Push LR to stack
		list.add(new ARMInstruction(Instruc.PUSH, Reg.LR));
	}

	public void exitScope(List<Instruction> list) {
		//Pop PC from stack
		list.add(new ARMInstruction(Instruc.POP, Reg.PC));
	}

	//Visit Sequence statement separated by semicolons
	@Override
	public Operand visitSemicolon_Stat(
			@NotNull BasicParser.Semicolon_StatContext ctx) {
		visit(ctx.stat(0)); //Visit first statement
		availRegs.refreshReg(); //Refresh registers
		visit(ctx.stat(1)); //Visit second statement
		return null;
	}

	//Visit and/or expression
	private Operand andOr(Instruc i, BasicParser.ExprContext ctx1,
			BasicParser.ExprContext ctx2) {
		Operand reg1 = visit(ctx1); //First Register
		Operand reg2 = visit(ctx2); //Second Register
		//Add new line of code with instruction and both register
		assemblyCode.add(new ARMInstruction(i, reg1, reg1, reg2));
		//Set type of regs (necessary further on in the code)
		Reg r = (Reg) reg1;
		r.setType(Types.BOOL); 
		return r;
	}

	@Override
	public Operand visitParenth_Expr(
			@NotNull BasicParser.Parenth_ExprContext ctx) {
		//Visit expr as parenth expr is an instanceof expr
		return visit(ctx.expr());
	}

	@Override
	public Operand visitAnd_Expr(@NotNull BasicParser.And_ExprContext ctx) {
		//Visit and statement with both exprs as arguments
		return andOr(Instruc.AND, ctx.expr(0), ctx.expr(1));
	}

	@Override
	public Operand visitOr_Expr(@NotNull BasicParser.Or_ExprContext ctx) {
		//Visit or statement with both exprs as arguments
		return andOr(Instruc.ORR, ctx.expr(0), ctx.expr(1));
	}

	//While Statement, initial proceedings
	private void L1_While(BasicParser.While_StatContext ctx) {
		assemblyCode.add(new Label("L" + (label + 1))); //Add new Label 'L1'
		//Top symboltable becomes the first child symboltable
		WACCVisitor.TOP_ST = WACCVisitor.TOP_ST.getChildren().get(0);
		createSub();//Add "sub scope from stack pointer statement" to code
		visit(ctx.stat()); //Visit the statement
		createAdd();//Add "add scope from stack pointer statement" to code
		//return symboltable to the parent (top) symboltable
		WACCVisitor.TOP_ST = WACCVisitor.TOP_ST.getParent();
		WACCVisitor.TOP_ST.removeChild(); //Delete the child node
		L0_While(ctx);
	}

	@Override
	public Operand visitEquality_Expr(
			@NotNull BasicParser.Equality_ExprContext ctx) {
		String oper = ctx.getChild(1).getText(); //oper is the comparator
		Operand reg1 = visit(ctx.expr(0)); //Reg first expr evaluates to
		Operand reg2 = visit(ctx.expr(1)); //Reg second expr evaluates to
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
		r.setType(Types.BOOL); //Set type of r
		return reg1;
	}

	//While statement, final proceedings
	private void L0_While(BasicParser.While_StatContext ctx) {
		assemblyCode.add(new Label("L" + label)); //Add Label 'L0'
		availRegs.refreshReg();
		
		Reg r = (Reg) visit(ctx.expr()); //visit expr and store result as r
		//Add 'CMP r #1' which checks if expression is true
		assemblyCode
				.add(new ARMInstruction(Instruc.CMP, r, new Immediate("#1")));
		//Add 'BEQ L1'. Code branches to L1 if above line is true
		assemblyCode.add(new ARMInstruction(Instruc.BEQ,  // Add L1 branch
				                           new Immediate("L" + (label + 1))));
		label += 2;
	}

	@Override
	public Operand visitBool_Liter(
			@NotNull BasicParser.Bool_LiterContext ctx) {
		Reg avail = availRegs.useRegs(); //avail is the next available register
		avail.setType(Types.BOOL); //set type of avail to BOOL
		if (ctx.getText().equals("false")) {
			//MOV avail #0 if context evaluates to false
			assemblyCode.add(new ARMInstruction(Instruc.MOV, avail,
					new Immediate("#0")));
		} else
			//MOV avail #1 if context evaluates to true
			assemblyCode.add(new ARMInstruction(Instruc.MOV, avail,
					new Immediate("#1")));
		return avail; //return avail register
	}

	@Override
	public Operand visitIf_Stat(@NotNull BasicParser.If_StatContext ctx) {
		Operand reg = visit(ctx.expr());
		assemblyCode.add(new ARMInstruction(Instruc.CMP, reg, new Immediate(
				"#0"))); //Add CMP reg 0 to code. Checks if ctx is false
		//Add BEQ L0 to code. If ctx is false, code will go to label L0
		int fiLabel = label + 1, elseLabel = label;
		label += 2;
		assemblyCode.add(new ARMInstruction(Instruc.BEQ, 
		                                    new Immediate("L" + elseLabel)));
		availRegs.refreshReg();
		visit(ctx.stat(0)); //Visit 'then' stat
		//Add B L1 to code. If ctx is true, code will go to label L1
		assemblyCode.add(new ARMInstruction(Instruc.B,
		                                    new Immediate("L" + fiLabel)));
		assemblyCode.add(new Label("L" + elseLabel));//Add Label L0
		availRegs.refreshReg();
		visit(ctx.stat(1));//Visit 'else' stat
		assemblyCode.add(new Label("L" + fiLabel));//Add Label L1
		return null;
	}

	@Override
	public Operand visitExit_Stat(@NotNull BasicParser.Exit_StatContext ctx) {
		assemblyCode.add(new ARMInstruction(Instruc.MOV, Reg.R0, visit(ctx
				.expr()))); //MOV RO 'whatever operand expr evaluates to'
		//BL exit
		assemblyCode.add(
				new ARMInstruction(Instruc.BL, new Immediate("exit")));
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
		}
		//return reg;
	}
	
	@Override
	public Operand visitPrintln_Stat(
			@NotNull BasicParser.Println_StatContext ctx) {
		Operand r = visit(ctx.expr());
		Types type = r.getType();
		if ((type == Types.INT) || (type == Types.CHAR) || (type == Types.STRING)) {
			print(ctx.expr(), r);
		} else if (type == Types.BOOL) {
			assemblyCode.add(new ARMInstruction(Instruc.MOV, Reg.R0, r));
			assemblyCode.add(new ARMInstruction(Instruc.BL, new Immediate(
					"p_print_bool")));
			p_print_bool();
		} else if (ctx.expr() instanceof BasicParser.ArrayElem_ExprContext) {
			
		}
		assemblyCode.add(new ARMInstruction(Instruc.BL, new Immediate(
				"p_print_ln")));
		p_print_ln("\"\\0\"", printedAlready);
		printedAlready = true;
		return r;
	}
	
	@Override 
	public Operand visitArrayelem(@NotNull BasicParser.ArrayelemContext ctx) {
	    Reg reg = availRegs.useRegs();
	    Type type = WACCVisitor.TOP_ST.lookUpCurrLevelAndEnclosingLevels(ctx.ident().getText());
	    type = ((ArrayType) type).getType();
	    int t = type.getSize();
		int offset = WACCVisitor.TOP_ST.calculateOffset(ctx.ident().getText());
		assemblyCode.add(new ARMInstruction(Instruc.ADD, reg, Reg.SP, new Immediate("#" + offset)));
		Operand r = visit(ctx.expr(0));
		assemblyCode.add(new ARMInstruction(Instruc.LDR, reg, new Address(reg, 0)));
		assemblyCode.add(new ARMInstruction(Instruc.MOV, Reg.R0, r));
		assemblyCode.add(new ARMInstruction(Instruc.MOV, Reg.R1, reg));
		assemblyCode.add(new ARMInstruction(Instruc.BL, new Immediate("p_check_array_bounds")));
		p_check_array_bounds();
		assemblyCode.add(new ARMInstruction(Instruc.ADD, reg, reg, new Immediate("#4")));
		assemblyCode.add(new ARMInstruction(Instruc.ADD, reg, reg, r, new Immediate("LSL #" + t/2)));
		assemblyCode.add(new ARMInstruction(Instruc.LDR, reg, new Address(reg, 0)));
		reg.setType(Types.INT);
		return reg; 
	}
	
	private void p_check_array_bounds() {
		if (!manage.array_bounds()) {
			String str1 = "\"ArrayIndexOutOfBoundsError: negative index\\n\\0\"";
			String str2 = "\"ArrayIndexOutOfBoundsError: index too large\\n\\0\"";
			endInstruc.add(new Label("p_check_array_bounds"));
			enterScope(endInstruc);
			endInstruc.add(new ARMInstruction(Instruc.CMP, Reg.R0, new Immediate("#0")));
			endInstruc.add(new ARMInstruction(Instruc.LDRLT, Reg.R0, new Immediate(getData(str1))));
			endInstruc.add(new ARMInstruction(Instruc.BLLT, new Immediate("p_throw_runtime_error")));
			endInstruc.add(new ARMInstruction(Instruc.LDR, Reg.R1, new Address(Reg.R1, 0)));
			endInstruc.add(new ARMInstruction(Instruc.CMP, Reg.R0, Reg.R1));
			endInstruc.add(new ARMInstruction(Instruc.LDRCS, Reg.R0, new Immediate(getData(str2))));
			endInstruc.add(new ARMInstruction(Instruc.BLCS, new Immediate("p_throw_runtime_error")));
			exitScope(endInstruc);
			p_throw_runtime_error();
		}
	}

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
	public Operand visitWhile_Stat(@NotNull BasicParser.While_StatContext ctx) {
		assemblyCode.add(new ARMInstruction(Instruc.BL, new Immediate("L" + label))); // Add L0 branch
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
	
	public List<Instruction> addData() {
		List<Instruction> list = new ArrayList<Instruction>();
		if (!data.isEmpty()) {
			list.add(Directives.DATA);
			for (int i = 0; i < data.size(); i++) {
				list.add(new Label("msg_" + i));
				String str = data.get(i);
				int length = str.length() - 2;
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
	
	public void finishCode() {
		List<Instruction> code = addData();
		code.addAll(assemblyCode);
		assemblyCode = code;
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
		case BasicParser.LEN:
			assemblyCode.add(new ARMInstruction(Instruc.LDR, reg, new Address(Reg.SP, 0)));
			assemblyCode.add(new ARMInstruction(Instruc.LDR, reg, new Address((Reg) reg, 0)));
			Reg len = ((Reg) reg);
			len.setType(Types.INT);
			reg = len;
			break;
		}
		return reg;
	}
	
	private Reg arrayType(BasicParser.IdentEq_StatContext ctx) {
		int offset = WACCVisitor.TOP_ST.calculateOffset(ctx.IDENT().getText());
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

	@Override
	public Operand visitIdentEq_Stat(
			@NotNull BasicParser.IdentEq_StatContext ctx) {
		int offset = WACCVisitor.TOP_ST.calculateOffset(ctx.IDENT().getText());
		if (ctx.type().getChild(0) instanceof BasicParser.ArraytypeContext) {
			return arrayType(ctx);
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
		if (!manage.overflow()) {
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
		if (!manage.runtime()) {
			endInstruc.add(new Label("p_throw_runtime_error"));
			endInstruc.add(new ARMInstruction(Instruc.BL, new Immediate(
					"p_print_string")));
			endInstruc.add(new ARMInstruction(Instruc.MOV, Reg.R0, new Immediate(
					"#-1")));
			endInstruc.add(new ARMInstruction(Instruc.BL, new Immediate("exit")));
			p_print_statement("\"%.*s\\0\"");			
		}
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
		WACCAssembler.data.add(ctx.getText());
		Reg avail = availRegs.useRegs();
		avail.setType(Types.STRING);
		assemblyCode.add(new ARMInstruction(Instruc.LDR, avail, new Immediate("=msg_" + Integer.toString(data.size() - 1))));
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
