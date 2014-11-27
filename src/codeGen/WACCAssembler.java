package codeGen;

import java.util.ArrayList;
import java.util.List;
import org.antlr.v4.runtime.misc.NotNull;
import Intsr.ARMInstruction;
import Intsr.Address;
import Intsr.Directives;
import Intsr.Immediate;
import Intsr.Instruc;
import Intsr.Instruction;
import Intsr.Label;
import Intsr.Reg;
import WACCFrontEnd.WACCVisitor;
import antlr.BasicParser;
import antlr.BasicParserBaseVisitor;

public class WACCAssembler extends BasicParserBaseVisitor<String> {

	// Creating a list that stores all the instructions.
	List<Instruction> assemblyCode = new ArrayList<>();
	// Storing datas.
	public static List<String> data = new ArrayList<>();
	static List<Reg> availRegs = Reg.getRegs();

	@Override
	public String visitProgram(@NotNull BasicParser.ProgramContext ctx) {
		WACCVisitor.TOP_ST.calculateScope();
		showData();
		assemblyCode.add(Directives.TEXT);
		assemblyCode.add(Directives.GLOBALM);
		List<BasicParser.FuncContext> functions = ctx.func();
		if (functions != null) {
			for (BasicParser.FuncContext func : functions) {
				visitFunc(func);
			}
		}
		assemblyCode.add(new Label("main"));
		assemblyCode.add(new ARMInstruction(Instruc.PUSH, Reg.LR));
		visit(ctx.stat());
		int i = WACCVisitor.TOP_ST.getTotalScope();
		if (i > 0) {
			assemblyCode.add(new ARMInstruction(Instruc.ADD, Reg.SP, Reg.SP,
					new Immediate("#" + i)));
		}
		assemblyCode.add(new ARMInstruction(Instruc.LDR, Reg.R0, new Immediate(
				"=0")));
		assemblyCode.add(new ARMInstruction(Instruc.POP, Reg.PC));
		assemblyCode.add(Directives.LTORG);
		return null;
	}

	@Override
	public String visitSemicolon_Stat(
			@NotNull BasicParser.Semicolon_StatContext ctx) {
		visit(ctx.stat(0));
		availRegs = Reg.getRegs();
		visit(ctx.stat(1));
		return "";
	}

	@Override
	public String visitExit_Stat(@NotNull BasicParser.Exit_StatContext ctx) {
		visitChildren(ctx);
		assemblyCode.add(new ARMInstruction(Instruc.BL, new Immediate("exit")));
		return null;
	}

	@Override
	public String visitIntLiter_Expr(
			@NotNull BasicParser.IntLiter_ExprContext ctx) {
		String s = ctx.getText();
		assemblyCode.add(new ARMInstruction(Instruc.LDR, Reg.R4, new Immediate(
				"=" + s)));
		assemblyCode.add(new ARMInstruction(Instruc.MOV, Reg.R0, Reg.R4));
		return ctx.getText();
	}

	public void showData() {
		if (!data.isEmpty()) {
			System.out.print(Directives.DATA.toString());
			for (int i = 0; i < data.size(); i++) {
				System.out.print(new Label("msg_" + i).toString());
				String str = data.get(i);
				System.out.println(Directives.WORD.toString() + " "
						+ Integer.toString(str.length() - 2));
				System.out.println(Directives.ASCII.toString() + " " + str);
			}
		}

	}

	public void getInstructions() {
		for (Instruction str : assemblyCode) {
			System.out.print(str.toString());
		}
	}

	@Override
	public String visitIdentEq_Stat(@NotNull BasicParser.IdentEq_StatContext ctx) {
		int offset = WACCVisitor.TOP_ST.calculateOffset(ctx.IDENT().getText());
		assemblyCode.add(new ARMInstruction(Instruc.SUB, availRegs.get(0),
				Reg.SP, new Immediate("#" + offset)));
		visit(ctx.assignrhs());
		assemblyCode.add(new ARMInstruction(Instruc.STR, availRegs.get(0),
				new Address(Reg.SP, null)));
		return null;
	}

	@Override
	public String visitAssignLhsRhs_Stat(
			@NotNull BasicParser.AssignLhsRhs_StatContext ctx) {
		String str = ctx.assignrhs().getText();
		int offset = WACCVisitor.TOP_ST.calculateOffset(ctx.assignlhs()
				.getText());
		assemblyCode.add(new ARMInstruction(Instruc.LDR, availRegs.get(0),
				new Immediate(getData(str))));
		assemblyCode.add(new ARMInstruction(Instruc.STR, availRegs.get(0),
				new Address(Reg.SP, null)));
		return null;
	}
	
	@Override
	public String visitStrLiter_Expr(@NotNull BasicParser.StrLiter_ExprContext ctx) { 
		assemblyCode.add(new ARMInstruction(Instruc.LDR, availRegs.get(0),
				new Immediate(getData(ctx.getText()))));
		return visitChildren(ctx); 
	}

	public String getData(String s) {
		StringBuilder str = new StringBuilder();
		str.append("=msg_");
		for (int i = 0; i < data.size(); i++) {
			if (data.get(i).equals(s)) {
				str.append(Integer.toString(i));
			}
		}
		return str.toString() + "\n";
	}

}
