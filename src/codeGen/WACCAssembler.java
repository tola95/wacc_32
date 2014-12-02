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
	//static List<Reg> availRegs = Reg.getRegs();
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
					new Immediate(getData(str))));
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

	/*public Operand print(BasicParser.ExprContext ctx) {
		Operand reg = visit(ctx);
		assemblyCode.add(new ARMInstruction(Instruc.MOV, Reg.R0, reg));
		// The expression after println can be many things. One of which is
		// identifiers.
		// This if statement checks that case and identifies its type.
		if (ctx.getChild(0) instanceof BasicParser.IdentContext) {
			String type = WACCVisitor.TOP_ST.lookUpCurrLevelAndEnclosingLevels(
					ctx.getText()).toString();
			System.out.println(reg.getType());
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
		} else {
			assemblyCode.add(new ARMInstruction(Instruc.BL, new Immediate(
					"p_print_string")));
			p_print_statement("\"%.*s\\0\"");
		}
		return reg;
	}*/
	
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
			case ARRAY:
				break;
			case PAIR:
				break;
			default:
				break;
			}
		return reg;
	}

	private void p_print_bool() {
		// TODO Auto-generated method stub
		if (!manage.print_bool()) {
			endInstruc.add(new Label("p_print_bool"));
			enterScope(endInstruc);
			System.out.println("You smart\n\tYou loyal\n\t");
			endInstruc.add(new ARMInstruction(Instruc.CMP, Reg.R0, 
					new Immediate("#0")));
			endInstruc.add(new ARMInstruction(Instruc.LDRNE, Reg.R0, 
					new Immediate("=msg_0")));
			endInstruc.add(new ARMInstruction(Instruc.LDREQ, Reg.R0, 
					new Immediate("=msg_1")));
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
		assemblyCode.add(new ARMInstruction(Instruc.ADD, avail,
				Reg.SP, new Immediate("#" + offset)));
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
	
	private void L1(BasicParser.While_StatContext ctx) {
		assemblyCode.add(new Label("L1"));
		visit(ctx.stat());
		L0(ctx);
	}
	
	private void L0(BasicParser.While_StatContext ctx) {
		assemblyCode.add(new Label("L0"));
		Reg r = availRegs.useRegs();
		assemblyCode.add(new ARMInstruction(Instruc.LDRSB, r, new Address(Reg.SP, new Immediate("4"))));
		Operand charReg = visit(ctx.expr());
		assemblyCode.add(new ARMInstruction(Instruc.CMP, r, charReg));
		assemblyCode.add(new ARMInstruction(Instruc.MOVNE, r, new Immediate("#1")));
		assemblyCode.add(new ARMInstruction(Instruc.MOVEQ, r, new Immediate("#0")));
		assemblyCode.add(new ARMInstruction(Instruc.CMP, r, new Immediate("#1")));
		assemblyCode.add(new ARMInstruction(Instruc.BEQ, new Immediate("L1")));
	}

	@Override 
	public Operand visitWhile_Stat(@NotNull BasicParser.While_StatContext ctx) { 
		assemblyCode.add(new ARMInstruction(Instruc.BL, new Immediate("L0")));
		L1(ctx);
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
	public Operand visitIdentEq_Stat(
			@NotNull BasicParser.IdentEq_StatContext ctx) {
		Operand reg = visit(ctx.assignrhs());
		int offset = WACCVisitor.TOP_ST.calculateOffset(ctx.IDENT().getText());
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
	public Operand visitIdent(@NotNull BasicParser.IdentContext ctx) {
		String str = ctx.IDENT().getText();
		int offset = WACCVisitor.TOP_ST.calculateOffset(str);
		Address add = new Address(Reg.SP, offset);
		Reg avail = availRegs.useRegs();
		switch (WACCVisitor.TOP_ST.lookUpCurrLevelAndEnclosingLevels(str)
				.toString()) {
		case "INT":
			avail.setType(Types.INT);
			assemblyCode.add(new ARMInstruction(Instruc.LDR, avail, add));
		}
		return avail;
	}

	@Override
	public Operand visitStrLiter_Expr(
			@NotNull BasicParser.StrLiter_ExprContext ctx) {
		Reg avail = availRegs.useRegs();
		avail.setType(Types.STRING);
		assemblyCode.add(new ARMInstruction(Instruc.LDR, avail,
				new Immediate(getData(ctx.getText()))));
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
	
	//*******//
	@Override
	public Operand visitArrayElem_Expr(
			@NotNull BasicParser.ArrayElem_ExprContext ctx) {
		return visit(ctx.arrayelem());
	}

	public String getData(String s) {
		StringBuilder str = new StringBuilder();
		str.append("=msg_");
		for (int i = 0; i < data.size(); i++) {
			if (data.get(i).equals(s)) {
				str.append(Integer.toString(i));
			}
		}
		return str.toString();
	}

}
