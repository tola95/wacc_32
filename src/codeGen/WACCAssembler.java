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
import WACCFrontEnd.PrimType;
import WACCFrontEnd.WACCVisitor;
import antlr.BasicParser;
import antlr.BasicParserBaseVisitor;

public class WACCAssembler extends BasicParserBaseVisitor<Operand> {

	// Creating a list that stores all the instructions.
	public static List<Instruction> assemblyCode = new ArrayList<>();
	// Storing datas.
	public static List<String> data = new ArrayList<>();
	static List<Reg> availRegs = Reg.getRegs();
	// Instructions that come after the main code.
	private List<Instruction> endInstruc = new ArrayList<>();
	// This should only be printed once.
	boolean printedAlready = false;

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
		int scope = WACCVisitor.TOP_ST.getTotalScope();
		if (scope > 0) {
			assemblyCode.add(new ARMInstruction(Instruc.SUB, Reg.SP, Reg.SP,
					new Immediate("#" + scope)));
		}
		visit(ctx.stat());
		int i = WACCVisitor.TOP_ST.getTotalScope();
		if (i > 0) {
			assemblyCode.add(new ARMInstruction(Instruc.ADD, Reg.SP, Reg.SP,
					new Immediate("#" + i)));
		}
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
		availRegs = Reg.getRegs();
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
		endInstruc.add(new Label("p_print_string"));
		enterScope(endInstruc);
		endInstruc.add(new ARMInstruction(Instruc.LDR, Reg.R1, new Address(
				Reg.R0, null)));
		endInstruc.add(new ARMInstruction(Instruc.ADD, Reg.R2, Reg.R0,
				new Immediate("#4")));
		endInstruc.add(new ARMInstruction(Instruc.LDR, Reg.R0, new Immediate(
				getData(str))));
		partOfPrint();
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
			endInstruc.add(new ARMInstruction(Instruc.LDR, Reg.R0, new Immediate(
				getData(str))));
			endInstruc.add(new ARMInstruction(Instruc.ADD, Reg.R0, Reg.R0,
				new Immediate("#4")));
			endInstruc.add(new ARMInstruction(Instruc.BL, new Immediate("puts")));
			endInstruc.add(new ARMInstruction(Instruc.MOV, Reg.R0, new Immediate(
				"#0")));
			endInstruc.add(new ARMInstruction(Instruc.BL, new Immediate("fflush")));
			exitScope(endInstruc);
		}
	}

	public void p_print_int(String str, boolean bool) {
		if (!bool) {
			endInstruc.add(new Label("p_print_int"));
			enterScope(endInstruc);
			endInstruc.add(new ARMInstruction(Instruc.MOV, Reg.R1, Reg.R0));
			endInstruc.add(new ARMInstruction(Instruc.LDR, Reg.R0, new Immediate(
				getData(str))));
			partOfPrint();
		}
		
	}
    
	@Override 
	public Operand visitRead_Stat(@NotNull BasicParser.Read_StatContext ctx) { 
		Reg avail = availRegs.get(0);
		assemblyCode.add(new ARMInstruction(Instruc.ADD, availRegs.get(0), Reg.SP, new Immediate("#" + WACCVisitor.TOP_ST.calculateOffset(ctx.assignlhs().getText()))));
		assemblyCode.add(new ARMInstruction(Instruc.MOV, Reg.R0, avail));
		String type = WACCVisitor.TOP_ST.lookUpCurrLevelAndEnclosingLevels(ctx.assignlhs().getText()).toString();
		switch (type) {
		case "INT" :
			assemblyCode.add(new ARMInstruction(Instruc.BL, new Immediate("p_read_int")));
			p_read_int("\"%d\\0\"");
		}
		return avail; 
	}
	
	private void p_read_int(String str) {
		endInstruc.add(new Label("p_read_int"));
		enterScope(endInstruc);
		endInstruc.add(new ARMInstruction(Instruc.MOV, Reg.R1, Reg.R0));
		endInstruc.add(new ARMInstruction(Instruc.LDR, Reg.R0, new Immediate(
				getData(str))));
		endInstruc.add(new ARMInstruction(Instruc.ADD, Reg.R0, Reg.R0, new Immediate("#4")));
		endInstruc.add(new ARMInstruction(Instruc.BL, new Immediate("scanf")));
		exitScope(endInstruc);
	}
	
	@Override
	public Operand visitPrintln_Stat(
			@NotNull BasicParser.Println_StatContext ctx) {
		Operand reg = visit(ctx.expr());
		assemblyCode.add(new ARMInstruction(Instruc.MOV, Reg.R0, reg));
		// The expression after println can be many things. One of which is
		// identifiers.
		// This if statement checks that case and identifies its type.
		if (ctx.expr().getChild(0) instanceof BasicParser.IdentContext) {
			String type = WACCVisitor.TOP_ST.lookUpCurrLevelAndEnclosingLevels(
					ctx.expr().getText()).toString();
			switch (type) {
			case "INT":
				assemblyCode.add(new ARMInstruction(Instruc.BL, new Immediate(
						"p_print_int")));
				p_print_int("\"%d\\0\"", printedAlready);
			default:
				assemblyCode.add(new ARMInstruction(Instruc.BL, new Immediate("p_print_ln")));
				p_print_ln("\"\\0\"", printedAlready);
				printedAlready = true;
				return reg;
			}
		} else 
			assemblyCode.add(new ARMInstruction(Instruc.BL, new Immediate(
					"p_print_string")));
			p_print_statement("\"%.*s\\0\"");
			assemblyCode.add(new ARMInstruction(Instruc.BL, new Immediate(
					"p_print_ln")));
			p_print_ln("\"\\0\"", printedAlready);
			printedAlready = true;
			return reg;
	}

	@Override
	public Operand visitIntLiter_Expr(
			@NotNull BasicParser.IntLiter_ExprContext ctx) {
		Reg availReg = availRegs.get(0);
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
		switch (ctx.start.getType()) {
		case BasicParser.CHAR:
		case BasicParser.BOOL:
			assemblyCode.add(new ARMInstruction(Instruc.STRB, reg, new Address(
					Reg.SP, null)));
			break;
		case BasicParser.INT:
		case BasicParser.STRING:
			int offset = WACCVisitor.TOP_ST.calculateOffset(ctx.IDENT()
					.getText());
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
		Reg availReg = availRegs.get(0);
		assemblyCode.add(new ARMInstruction(Instruc.LDR, availReg,
				new Immediate("=" + ctx.getText())));
		return availReg;
	}

	@Override
	public Operand visitCharLiter_Expr(
			@NotNull BasicParser.CharLiter_ExprContext ctx) {
		Reg availReg = availRegs.get(0);
		assemblyCode.add(new ARMInstruction(Instruc.MOV, availReg,
				new Immediate("#" + ctx.getText())));
		return availReg;
	}

	@Override
	public Operand visitAssignLhsRhs_Stat(
			@NotNull BasicParser.AssignLhsRhs_StatContext ctx) {
		visit(ctx.assignrhs());
		if (WACCVisitor.TOP_ST.lookUpCurrLevelAndEnclosingLevels(
				ctx.assignlhs().getText()).equals(PrimType.BOOL)) {
			assemblyCode.add(new ARMInstruction(Instruc.STRB, availRegs.get(0),
					new Address(Reg.SP, null)));
		} else {
			assemblyCode.add(new ARMInstruction(Instruc.STR, availRegs.get(0),
					new Address(Reg.SP, null)));
		}

		return null;
	}

	@Override
	public Operand visitAssignlhs(@NotNull BasicParser.AssignlhsContext ctx) {
		return visit(ctx.getChild(0));
	}
	
	

	@Override
	public Operand visitIdent(@NotNull BasicParser.IdentContext ctx) {
		String str = ctx.IDENT().getText();
		int offset = WACCVisitor.TOP_ST.calculateOffset(str);
		Address add = new Address(Reg.SP, offset);
		Reg avail = availRegs.get(0);
		switch (WACCVisitor.TOP_ST.lookUpCurrLevelAndEnclosingLevels(str)
				.toString()) {
		case "INT":
			assemblyCode.add(new ARMInstruction(Instruc.LDR, avail, add));
		}
		return avail;
	}

	@Override
	public Operand visitStrLiter_Expr(
			@NotNull BasicParser.StrLiter_ExprContext ctx) {
		assemblyCode.add(new ARMInstruction(Instruc.LDR, availRegs.get(0),
				new Immediate(getData(ctx.getText()))));
		return availRegs.get(0);
	}

	@Override
	public Operand visitBool_Liter(@NotNull BasicParser.Bool_LiterContext ctx) {
		if (ctx.getText().equals("false")) {
			assemblyCode.add(new ARMInstruction(Instruc.MOV, availRegs.get(0),
					new Immediate("#0")));
		} else
			assemblyCode.add(new ARMInstruction(Instruc.MOV, availRegs.get(0),
					new Immediate("#1")));
		return availRegs.get(0);
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
