package WACCFrontEnd;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;

import org.antlr.v4.runtime.misc.NotNull;

import codeGen.DataManager;
import codeGen.WACCAssembler;

import antlr.BasicParser;
import antlr.BasicParserBaseVisitor;

public class WACCVisitor extends BasicParserBaseVisitor<Type> {

	public static SymbolTable TOP_ST;
	public static HashMap<String, Function> functions = new HashMap<String, Function>();
	private int index = 1;

	@Override
	public Type visitProgram(BasicParser.ProgramContext ctx) {
		TOP_ST = new SymbolTable(null, null);
		for (BasicParser.FuncContext func : ctx.func()) {
			List<Type> params = new ArrayList<Type>();
			if (func.paramlist() != null) {
				for (BasicParser.ParamContext l : func.paramlist().param()) {
					params.add(visit(l.type()));
				}
			}
			if (functions.containsKey(func.IDENT().getText())) {
				System.err.println("Function " + func.IDENT().getText()
						+ " at line " + func.start.getLine()
						+ " is already defined");
				System.exit(200);
			}
			functions.put(func.IDENT().getText(),
					new Function(visit(func.type()), params));
		}
		return visitChildren(ctx);
	}

	@Override
	public Type visitFunc(BasicParser.FuncContext ctx) {
		SymbolTable symboltable1 = new SymbolTable(TOP_ST, visit(ctx.type()));
		TOP_ST.addChildren(symboltable1);
		TOP_ST = symboltable1;
		if (ctx.paramlist() != null) {
			visit(ctx.paramlist());
		}
		WACCVisitor.TOP_ST.getDictionary().put("1", PrimType.INT);
		SymbolTable symboltable2 = new SymbolTable(symboltable1);
		symboltable1.addChildren(symboltable2);
		TOP_ST = symboltable2;
		SyntaxChecker.checkReturnType(ctx.stat());
		if (!SyntaxChecker.checkReturnType(ctx.stat())) {
			System.err.println("No return type of function "
					+ ctx.IDENT().getSymbol().getText() + " at line "
					+ ctx.start.getLine());
			System.exit(100);
		}
		visit(ctx.stat());
		TOP_ST = TOP_ST.getParent().getParent();
		return null;

	}

	@Override
	public Type visitParam(BasicParser.ParamContext ctx) {
		Type t = visit(ctx.type());
		TOP_ST.add(ctx.IDENT().getText(), t);
		return t;
	}

	@Override
	public Type visitExp_assignrhs(@NotNull BasicParser.Exp_assignrhsContext ctx) {
		return visit(ctx.expr());
	}

	@Override
	public Type visitArrayLiter_assignrhs(
			@NotNull BasicParser.ArrayLiter_assignrhsContext ctx) {
		return visit(ctx.arrayliter());
	}

	@Override
	public Type visitPairElem_assignrhs(
			@NotNull BasicParser.PairElem_assignrhsContext ctx) {
		return visit(ctx.pairelem());
	}

	@Override
	public Type visitCall_assignrhs(
			@NotNull BasicParser.Call_assignrhsContext ctx) {
		String function = ctx.IDENT().getText();
		if (!functions.containsKey(function)) {
			System.err.println("Function " + function + " at line "
					+ ctx.IDENT().getSymbol().getLine() + " not defined");
			System.exit(200);
		}
		List<Type> paramList = functions.get(function).getParamList();
		List<BasicParser.ExprContext> argList;
		if (ctx.arglist() == null) {
			argList = new ArrayList<BasicParser.ExprContext>();
		} else {
			argList = ctx.arglist().expr();
		}
		if (!(paramList.size() == argList.size())) {
			System.err.println("Number of parameters for function "
					+ ctx.IDENT().getSymbol().getText() + " at line "
					+ ctx.start.getLine() + "are incorrect");
			System.exit(200);
		}
		for (int i = 0; i < paramList.size(); i++) {
			Type expected = paramList.get(i);
			Type actual = visit(argList.get(i));
			if (!(paramList.get(i).isOfType(visit(argList.get(i))))) {
				System.err.println("The types of the parameters of function "
						+ ctx.IDENT().getSymbol().getText() + " at line "
						+ ctx.start.getLine() + " do not match. Expected: "
						+ expected + " Actual: " + actual);
				System.exit(200);
			}
		}
		return functions.get(function).getReturnType();
	}

	@Override
	public Type visitUnaryOper_Expr(
			@NotNull BasicParser.UnaryOper_ExprContext ctx) {
		Type exprType = visit(ctx.expr());
		int unaryOperType = ctx.start.getType();
		if (exprType == PrimType.BOOL && unaryOperType == BasicParser.NOT) {
			return PrimType.BOOL;
		}
		if (exprType == PrimType.INT && unaryOperType == BasicParser.MINUS) {
			index *= -1;
			return PrimType.INT;
		}
		if (exprType instanceof ArrayType && unaryOperType == BasicParser.LEN) {
			ArrayType a = (ArrayType) exprType;
			index = a.getLength();
			return PrimType.INT;
		}
		if (exprType == PrimType.CHAR && unaryOperType == BasicParser.ORD) {
			char chr = ctx.expr().getText().charAt(0);
			index = (int) chr;
			return PrimType.INT;
		}
		if (exprType == PrimType.INT && unaryOperType == BasicParser.CHR) {
			return PrimType.CHAR;
		}
		System.err.println("UnaryOper and expr at line " + ctx.start.getLine()
				+ " don't match");
		System.exit(200);
		return null;

	}

	@Override
	public Type visitParenth_Expr(@NotNull BasicParser.Parenth_ExprContext ctx) {
		return visit(ctx.expr());
	}

	@Override
	public Type visitFactor_Expr(@NotNull BasicParser.Factor_ExprContext ctx) {
		String oper = ctx.getChild(1).getText();
		if (oper.equals("/") || oper.equals("%")) {
			DataManager.dataAdd(WACCAssembler.data, DataManager.STRING);
			DataManager.dataAdd(WACCAssembler.data, DataManager.DIVIDE);
		} else {
			DataManager.dataAdd(WACCAssembler.data, DataManager.STRING);
			DataManager.dataAdd(WACCAssembler.data, DataManager.OVERFLOW);
		}
		index = 0;
		Type expr1 = visit(ctx.expr(0));
		int op1 = index;
		Type expr2 = visit(ctx.expr(1));
		int op2 = index;
//		if (oper.equals("/")) {
//			index = op1 / op2;           divide by zero
//		} else if (oper.equals("%")) {
//			index = op1 % op2; 
//		} else {
//			index = op1 * op2;
//		}
		
		if (!expr1.isOfType(PrimType.INT)) {
			System.err.println("Type error at line: " + ctx.start.getLine()
					+ " Position: " + ctx.start.getCharPositionInLine()
					+ " Expected type: int \t Actual type: " + expr1);
			System.exit(200);
		}
		if (!expr2.isOfType(PrimType.INT)) {
			System.err.println("Type error at line: " + ctx.stop.getLine()
					+ " Position: " + ctx.stop.getCharPositionInLine()
					+ " Expected type: int \t Actual type: " + expr2);
			System.exit(200);
		}
		return PrimType.INT;
	}

	@Override
	public Type visitTerm_Expr(@NotNull BasicParser.Term_ExprContext ctx) {
		String oper = ctx.getChild(1).getText();
		if (oper.equals("+") || oper.equals("-")) {
			DataManager.dataAdd(WACCAssembler.data, DataManager.STRING);
			DataManager.dataAdd(WACCAssembler.data, DataManager.OVERFLOW);
		}
		Type expr1 = visit(ctx.expr(0));
		int op1 = index;
		Type expr2 = visit(ctx.expr(1));
		int op2 = index;
		if (oper.equals("+")) {
			index = op1 + op2;
		} else {
			index = op1 - op2;
		}
		if (!expr1.isOfType(PrimType.INT)) {
			System.err.println("Type error at line: " + ctx.start.getLine()
					+ " Position: " + ctx.start.getCharPositionInLine()
					+ " Expected type: int \t Actual type: " + expr1);
			System.exit(200);
		}
		if (!expr2.isOfType(PrimType.INT)) {
			System.err.println("Type error at line: " + ctx.stop.getLine()
					+ " Position: " + ctx.stop.getCharPositionInLine()
					+ " Expected type: int \t Actual type: " + expr2);
			System.exit(200);
		}
		return PrimType.INT;
	}

	@Override
	public Type visitCompare_Expr(@NotNull BasicParser.Compare_ExprContext ctx) {
		Type expr1 = visit(ctx.expr(0));
		Type expr2 = visit(ctx.expr(1));
		if (expr1.isOfType(PrimType.INT) && expr2.isOfType(PrimType.INT)) {
			return PrimType.BOOL;
		}
		if (expr1.isOfType(PrimType.CHAR) && expr2.isOfType(PrimType.CHAR)) {
			return PrimType.BOOL;
		}
		System.err
				.println("Type error: Both expressions required to be of either type int or type char. Error in line: "
						+ ctx.start.getLine()
						+ "Left exp of type: "
						+ expr1
						+ " Right exp of type: " + expr2);
		System.exit(200);
		return null;
	}

	@Override
	public Type visitEquality_Expr(@NotNull BasicParser.Equality_ExprContext ctx) {
		Type expr1 = visit(ctx.expr(0));
		Type expr2 = visit(ctx.expr(1));
		if (!expr1.isOfType(expr2)) {
			System.err
					.println("Type error: Both expressions required to be of the same type. Error in line: "
							+ ctx.start.getLine()
							+ "Left exp of type: "
							+ expr1 + " Right exp of type: " + expr2);
			System.exit(200);
		}
		return PrimType.BOOL;
	}

	@Override
	public Type visitAnd_Expr(@NotNull BasicParser.And_ExprContext ctx) {
		Type expr1 = visit(ctx.expr(0));
		Type expr2 = visit(ctx.expr(1));
		if (!expr1.isOfType(PrimType.BOOL)) {
			System.err.println("Type error at line: " + ctx.start.getLine()
					+ " Position: " + ctx.start.getCharPositionInLine()
					+ " Expected type: bool \t Actual type: " + expr1);
			System.exit(200);
		}
		if (!expr2.isOfType(PrimType.BOOL)) {
			System.err.println("Type error at line: " + ctx.stop.getLine()
					+ " Position: " + ctx.stop.getCharPositionInLine()
					+ " Expected type: bool \t Actual type: " + expr2);
			System.exit(200);
		}
		return PrimType.BOOL;
	}

	@Override
	public Type visitOr_Expr(@NotNull BasicParser.Or_ExprContext ctx) {
		Type expr1 = visit(ctx.expr(0));
		Type expr2 = visit(ctx.expr(1));
		if (!expr1.isOfType(PrimType.BOOL)) {
			System.err.println("Type error at line: " + ctx.start.getLine()
					+ " Position: " + ctx.start.getCharPositionInLine()
					+ " Expected type: bool \t Actual type: " + expr1);
			System.exit(200);
		}
		if (!expr2.isOfType(PrimType.BOOL)) {
			System.err.println("Type error at line: " + ctx.stop.getLine()
					+ " Position: " + ctx.stop.getCharPositionInLine()
					+ " Expected type: bool \t Actual type: " + expr2);
			System.exit(200);
		}
		return PrimType.BOOL;
	}

	@Override
	public Type visitArrayelem(@NotNull BasicParser.ArrayelemContext ctx) {
		DataManager.dataAdd(WACCAssembler.data, DataManager.ARRAYNEG);
		DataManager.dataAdd(WACCAssembler.data, DataManager.ARRAYLARGE);
		DataManager.dataAdd(WACCAssembler.data, DataManager.STRING);
		index = 0;
		Type t1 = visit(ctx.expr(0));
		if (t1 != PrimType.INT) {
			System.err.println("Needed index of type int. Got type " + t1
					+ " at line " + ctx.expr(0).start.getLine()
					+ " and position: "
					+ ctx.expr(0).start.getCharPositionInLine());
			System.exit(200);
		}
		Type t2 = visit(ctx.ident());
		if (t2 == PrimType.STRING) {
			t2 = new ArrayType(PrimType.CHAR);
		}
		if (!(t2 instanceof ArrayType)) {
			System.err.println("Identifier " + ctx.ident().IDENT()
					+ " at line " + ctx.ident().IDENT().getSymbol().getLine()
					+ " and position "
					+ ctx.ident().IDENT().getSymbol().getCharPositionInLine()
					+ " is not of array type" + " Actual type: " + t2);
			System.exit(200);
		}
		return ((ArrayType) t2).getType();
	}

	@Override
	public Type visitNewPair_assignrhs(
			@NotNull BasicParser.NewPair_assignrhsContext ctx) {
		return new PairType(visit(ctx.expr(0)), visit(ctx.expr(1)));
	}

	@Override
	public Type visitPair_pairElemType(
			@NotNull BasicParser.Pair_pairElemTypeContext ctx) {
		return new PairType(PrimType.ANY, PrimType.ANY);
	}

	@Override
	public Type visitInt_baseType(@NotNull BasicParser.Int_baseTypeContext ctx) {
		return PrimType.INT;
	}

	@Override
	public Type visitBool_baseType(@NotNull BasicParser.Bool_baseTypeContext ctx) {
		return PrimType.BOOL;
	}

	@Override
	public Type visitChar_baseType(@NotNull BasicParser.Char_baseTypeContext ctx) {
		return PrimType.CHAR;
	}

	@Override
	public Type visitString_baseType(
			@NotNull BasicParser.String_baseTypeContext ctx) {
		return PrimType.STRING;
	}

	@Override
	public Type visitIdentEq_Stat(@NotNull BasicParser.IdentEq_StatContext ctx) {
		Type type1 = visit(ctx.type());
		Type type2 = visit(ctx.assignrhs());
		if (!(type1.isOfType(type2))) {
			System.err.println(" Mismatched types at line "
					+ ctx.start.getLine() + " and position "
					+ ctx.start.getCharPositionInLine() + " Expected: " + type1
					+ "Actual: " + type2);
			System.exit(200);
		}
		String id = ctx.IDENT().getText();
		if (TOP_ST.lookUpCurrLevelOnly(id) == null) {
			TOP_ST.add(ctx.IDENT().getText(), type2);
		} else {
			System.err.println("Identifier " + id + " at line "
					+ ctx.start.getLine() + " and position "
					+ ctx.start.getCharPositionInLine() + " already declared");
			System.exit(200);
		}
		return null;
	}

	@Override
	public Type visitRead_Stat(@NotNull BasicParser.Read_StatContext ctx) {
		Type t = visit(ctx.assignlhs());
		switch(t.toString()) {
		case "INT":
			DataManager.dataAdd(WACCAssembler.data, DataManager.INT);
			break;
		case "CHAR":
			DataManager.dataAdd(WACCAssembler.data, DataManager.CHAR);
		}
		if (!(t.isOfType(PrimType.CHAR) || t.isOfType(PrimType.INT) || t
				.isOfType(PrimType.STRING))) {
			System.err.println("Cannot read at line " + ctx.start.getLine()
					+ " and position " + ctx.start.getCharPositionInLine()
					+ " Type is invalid");
			System.exit(200);
		}
		return null;
	}

	@Override
	public Type visitAssignlhs(@NotNull BasicParser.AssignlhsContext ctx) {
		return visit(ctx.getChild(0));
	}

	@Override
	public Type visitBegin_Stat(@NotNull BasicParser.Begin_StatContext ctx) {
		SymbolTable symbolTable1 = new SymbolTable(TOP_ST);
		TOP_ST.addChildren(symbolTable1);
		TOP_ST = symbolTable1;
		visit(ctx.stat());
		TOP_ST = TOP_ST.getParent();
		return null;
	}

	@Override
	public Type visitAssignLhsRhs_Stat(
			@NotNull BasicParser.AssignLhsRhs_StatContext ctx) {
		Type lhs = visit(ctx.assignlhs());
		Type rhs = visit(ctx.assignrhs());
		if (!lhs.isOfType(rhs)) {
			System.err.println("Mismatched types at line "
					+ ctx.start.getLine() + "and position "
					+ ctx.start.getCharPositionInLine() + " Type lhs: " + lhs
					+ " and Type rhs: " + rhs);
			System.exit(200);
		}
		return null;
	}

	@Override
	public Type visitFree_Stat(@NotNull BasicParser.Free_StatContext ctx) {
		Type t = visit(ctx.expr());
		if (!(t instanceof ArrayType || t instanceof PairType)) {
			System.err.println("Incorrect type at line " + ctx.start.getLine()
					+ " and position " + ctx.start.getCharPositionInLine()
					+ " Must be of arraytype or pairtype. Actual type: " + t);
			System.exit(200);
		}
		return null;
	}

	@Override
	public Type visitArrayType_pairElemType(
			@NotNull BasicParser.ArrayType_pairElemTypeContext ctx) {
		return visit(ctx.arraytype());
	}

	@Override
	public Type visitPairtype(@NotNull BasicParser.PairtypeContext ctx) {
		return new PairType(visit(ctx.pairelemtype(0)),
				visit(ctx.pairelemtype(1)));
	}

	@Override
	public Type visitReturn_Stat(@NotNull BasicParser.Return_StatContext ctx) {
		Type t1 = visit(ctx.expr());
		if (!(t1.isOfType(TOP_ST.getReturnType()))) {
			System.err.println("Unexpected return type at line "
					+ ctx.start.getLine() + " and position "
					+ ctx.start.getCharPositionInLine());
			System.exit(200);
		}
		return visit(ctx.expr());
	}

	@Override
	public Type visitExit_Stat(@NotNull BasicParser.Exit_StatContext ctx) {
		Type t = visit(ctx.expr());
		if (t != PrimType.INT) {
			System.err.println("Unexpected type at line " + ctx.start.getLine()
					+ " and position " + ctx.start.getCharPositionInLine()
					+ "Expected type: Int, Actual type: " + t);
			System.exit(200);
		}
		return null;
	}

	@Override
	public Type visitPrint_Stat(@NotNull BasicParser.Print_StatContext ctx) {
		helperPrint(ctx.expr());
		return null;
	}
	
	private void helperPrint(BasicParser.ExprContext ctx) {
		Type t = visit(ctx);
		switch (t.toString()) {
		case "STRING":
			DataManager.dataAdd(WACCAssembler.data, DataManager.STRING);
			break;
		case "INT":
			DataManager.dataAdd(WACCAssembler.data, DataManager.INT);
			break;
		case "BOOL":
			DataManager.dataAdd(WACCAssembler.data, DataManager.BOOL);
			break;
		case "ARRAY":
		case "PAIR":
			DataManager.dataAdd(WACCAssembler.data, DataManager.ARRAY);
			break;
		}	
	}
 
	@Override
	public Type visitPrintln_Stat(@NotNull BasicParser.Println_StatContext ctx) {
		helperPrint(ctx.expr());
		return null;
	}

	@Override
	public Type visitSemicolon_Stat(
			@NotNull BasicParser.Semicolon_StatContext ctx) {
		visit(ctx.stat(0));
		visit(ctx.stat(1));
		return null;
	}

	@Override
	public Type visitIf_Stat(@NotNull BasicParser.If_StatContext ctx) {
		Type t = visit(ctx.expr());
		if (t != PrimType.BOOL) {
			System.err.println("Expression at line " + ctx.start.getLine()
					+ " and position "
					+ ctx.expr().start.getCharPositionInLine()
					+ " does not resolve to a Bool Type. Actual type: " + t);
			System.exit(200);
		}
		SymbolTable sym1 = new SymbolTable(TOP_ST);
		TOP_ST.addChildren(sym1);
		TOP_ST = sym1;
		visit(ctx.stat(0));
		TOP_ST = TOP_ST.getParent();
		SymbolTable sym2 = new SymbolTable(TOP_ST);
		TOP_ST.addChildren(sym2);
		TOP_ST = sym2;
		visit(ctx.stat(1));
		TOP_ST = TOP_ST.getParent();
		return null;

	}

	@Override
	public Type visitWhile_Stat(@NotNull BasicParser.While_StatContext ctx) {
		Type t = visit(ctx.expr());
		if (t != PrimType.BOOL) {
			System.err.println("Expression at line " + ctx.start.getLine()
					+ " and position "
					+ ctx.expr().start.getCharPositionInLine()
					+ " does not resolve to a Bool Type. Actual type: " + t);
			System.exit(200);
		}
		SymbolTable sym1 = new SymbolTable(TOP_ST);
		TOP_ST.addChildren(sym1);
		TOP_ST = sym1;
		visit(ctx.stat());
		TOP_ST = TOP_ST.getParent();
		return null;
	}

	@Override
	public Type visitBoolLiter_Expr(
			@NotNull BasicParser.BoolLiter_ExprContext ctx) {
		return PrimType.BOOL;
	}

	@Override
	public Type visitIntLiter_Expr(@NotNull BasicParser.IntLiter_ExprContext ctx) {
		index = Integer.parseInt(ctx.getText());
		return PrimType.INT;
	}

	@Override
	public Type visitCharLiter_Expr(
			@NotNull BasicParser.CharLiter_ExprContext ctx) {
		return PrimType.CHAR;
	}

	@Override
	public Type visitStrLiter_Expr(@NotNull BasicParser.StrLiter_ExprContext ctx) {
		return PrimType.STRING;
	}

	@Override
	public Type visitPairLiter_Expr(
			@NotNull BasicParser.PairLiter_ExprContext ctx) {
		return new PairType(PrimType.ANY, PrimType.ANY);
	}

	@Override
	public Type visitIdent(@NotNull BasicParser.IdentContext ctx) {
		String id = ctx.IDENT().getText();
		Type type = TOP_ST.lookUpCurrLevelAndEnclosingLevels(id);
		if (type == null) {
			System.err.println("The identifier " + id + " at line "
					+ ctx.start.getLine() + " and position "
					+ ctx.start.getCharPositionInLine() + "is undefined.");
			System.exit(200);
		}
		return type;
	}

	@Override
	public Type visitIdent_Expr(@NotNull BasicParser.Ident_ExprContext ctx) {
		return visit(ctx.ident());
	}

	@Override
	public Type visitUnaryoper(@NotNull BasicParser.UnaryoperContext ctx) {
		switch (ctx.start.getType()) {
		case BasicParser.NOT:
			return PrimType.BOOL;
		case BasicParser.MINUS:
			return PrimType.INT;
		case BasicParser.LEN:
			return PrimType.INT;
		case BasicParser.ORD:
			return PrimType.INT;
		case BasicParser.CHR:
			return PrimType.CHAR;
		default:
			return null;
		}
	}

	@Override
	public Type visitBaseType_pairElemType(
			@NotNull BasicParser.BaseType_pairElemTypeContext ctx) {
		return visit(ctx.basetype());
	}

	@Override
	public Type visitArraytype(@NotNull BasicParser.ArraytypeContext ctx) {
		return new ArrayType(visit(ctx.getChild(0)));
	}

	@Override
	public Type visitPairelem(BasicParser.PairelemContext ctx) {
		DataManager.dataAdd(WACCAssembler.data, DataManager.NULLREF);
		Type t = visit(ctx.expr());
		if (!(t instanceof PairType)) {
			System.err.println("Not a pair type at line " + ctx.start.getLine()
					+ " and position " + ctx.start.getCharPositionInLine()
					+ " Actual: " + t);
			System.exit(200);
		}
		PairType pair = (PairType) t;
		if (ctx.FST() != null) {
			return pair.getFst();
		}
		return pair.getSnd();

	}

	@Override
	public Type visitArrayliter(@NotNull BasicParser.ArrayliterContext ctx) {
		if (ctx.arglist() != null) {
			int length = ctx.arglist().expr().size();
			Type type = visit(ctx.arglist().expr(0));
			for (BasicParser.ExprContext expr : ctx.arglist().expr()) {
				if (!visit(expr).isOfType(type)) {
					System.err.println("Type error at line "
							+ expr.getStart().getLine() + "and position "
							+ expr.getStart().getCharPositionInLine()
							+ ". All the items in the list must be of type "
							+ type);
					System.exit(200);
				}
			}
			ArrayType array = new ArrayType(type);
			array.setLength(length);
			return array;
		}
		return new ArrayType(PrimType.ANY);
	}

}
