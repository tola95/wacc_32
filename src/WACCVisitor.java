import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;



public class WACCVisitor extends BasicParserBaseVisitor<Type> {
	
	private SymbolTable TOP_ST; 
	HashMap<String, Function> functions;
	
	
    @Override
	public Type visitProgram(BasicParser.ProgramContext ctx) {
    	TOP_ST = new SymbolTable(null);
    	for (BasicParser.FuncContext func : ctx.func()) {
    		List<Type> params = new ArrayList<Type>();
    		if (func.paramlist() != null) {
    			for (BasicParser.ParamContext l : func.paramlist().param()) {
    				params.add(visit(l.type()));
    			}
    		}
    		functions.put(func.IDENT().getText(), new Function(visit(func.type()), params));
    	}
    	return visitChildren(ctx);
	}
    
    @Override
	public Type visitFunc(BasicParser.FuncContext ctx) {
    	SymbolTable symboltable1 = new SymbolTable(TOP_ST);
    	TOP_ST = symboltable1;
    	if (ctx.paramlist() != null) {
    		visit(ctx.paramlist());
    		SymbolTable symboltable2 = new SymbolTable(symboltable1);
    		TOP_ST = symboltable2;
    		visit(ctx.stat());
    		TOP_ST = TOP_ST.getParent().getParent();
    	}
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
	public Type visitArrayLiter_assignrhs(@NotNull BasicParser.ArrayLiter_assignrhsContext ctx) { 
		return visit(ctx.arrayliter()); 
	}
	
	@Override 
	public Type visitPairElem_assignrhs(@NotNull BasicParser.PairElem_assignrhsContext ctx) { 
		return visit(ctx.pairelem());
	}
	
	@Override 
	public Type visitCall_assignrhs(@NotNull BasicParser.Call_assignrhsContext ctx) {
		String function = ctx.IDENT().getText();
		if (!functions.containsKey(function)) {
			System.err.println("Function not defined");
			System.exit(200);
		}
		List<Type> paramList = functions.get(function).getParamList();
		List<BasicParser.ExprContext> argList = ctx.arglist().expr();
		if (!(paramList.size() == argList.size())) {
			System.err.println("Number of parameters incorrect");
			System.exit(200);
		}
		for (int i = 0; i < paramList.size(); i ++) {
			Type expected = paramList.get(i);
			Type actual = visit(argList.get(i));
			if (!(paramList.get(i).isOfType(visit(argList.get(i))))) {
				System.err.println("The types for the parameters do not match. Expected: " 
						+ expected + "Actual: " + actual);
				System.exit(200);
			}
		}
		return functions.get(function).getReturnType();
	}
	
	@Override 
	public Type visitBaseType_type(@NotNull BasicParser.BaseType_typeContext ctx) { 
		return visit(ctx.basetype());
	}

	@Override 
	public Type visitArrayType_type(@NotNull BasicParser.ArrayType_typeContext ctx) { 
		return visit(ctx.arraytype());
	}
	
	@Override 
	public Type visitPairType_type(@NotNull BasicParser.PairType_typeContext ctx) { 
		return visit(ctx.pairtype());
	}
	
	@Override
	public Type visitUnaryOper_Expr(@NotNull BasicParser.UnaryOper_ExprContext ctx) { 
		Type exprType = visit(ctx.expr());
		int unaryOperType = ctx.start.getType(); 
	    if (exprType == PrimType.BOOL && unaryOperType == BasicParser.NOT) {
	    	return exprType;
	    }
	    if (exprType == PrimType.INT && unaryOperType == BasicParser.MINUS) {
	    	return exprType;
	    }
	    if (exprType instanceof ArrayType && unaryOperType == BasicParser.LEN) {
	    	return exprType;
	    }
	    if (exprType == PrimType.CHAR && unaryOperType == BasicParser.ORD) {
	    	return PrimType.INT;
	    }
	    if (exprType == PrimType.INT && unaryOperType == BasicParser.CHR) {
	    	return PrimType.CHAR;
	    }
	    System.err.println("UnaryOper and expr don't match");
	    System.exit(200);
	    return null;

	}

	@Override
	public Type visitParenth_Expr(@NotNull BasicParser.Parenth_ExprContext ctx) { 
	    return visit(ctx.expr());
	}

	@Override
	public Type visitFactor_Expr(@NotNull BasicParser.Factor_ExprContext ctx) { 
	    Type expr1 = visit(ctx.expr(0));
	    Type expr2 = visit(ctx.expr(1));
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
	    Type expr1 = visit(ctx.expr(0));
	    Type expr2 = visit(ctx.expr(1));
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
		 System.err.println("Type error: Both expressions required to be of either type int or type char. Error in line: " 
				 + ctx.start.getLine() + "Left exp of type: " + expr1 + " Right exp of type: " + expr2);
		 System.exit(200);
		 return null;
	}
	
	@Override 
	public Type visitEquality_Expr(@NotNull BasicParser.Equality_ExprContext ctx) { 
		Type expr1 = visit(ctx.expr(0));
		Type expr2 = visit(ctx.expr(1));
		if (!expr1.isOfType(expr2)) {
			System.err.println("Type error: Both expressions required to be of the same type. Error in line: " 
					 + ctx.start.getLine() + "Left exp of type: " + expr1 + " Right exp of type: " + expr2);
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
	public Type visitArrayElem_Expr(@NotNull BasicParser.ArrayElem_ExprContext ctx) { 
		SymbolTable st = new SymbolTable(TOP_ST);
		st.add(ctx.arrayelem().IDENT().getText(), new ArrayType(visit(ctx.arrayelem())));
	    return visit(ctx.arrayelem());
	}

	/*@Override 
	public Type visitBool_Liter(@NotNull BasicParser.Bool_LiterContext ctx) { 
	    if (ctx.start.getType() == BasicParser.TRUE) { 
		    return PrimType.TRUE;
	    } else if (ctx.start.getType() == BasicParser.FALSE) {
	        return PrimType.FALSE;
	    } else {
	        return PrimType.ERROR;
	    }
	}*/

	@Override 

	public Type visitArrayelem(@NotNull BasicParser.ArrayelemContext ctx) {
		String id = ctx.IDENT().getText();
		Type typeOfArray = TOP_ST.lookUpCurrLevelAndEnclosingLevels(id);
		if (typeOfArray == null) {
			System.err.println("Identifier " + id + " at line " 
		       + ctx.IDENT().getSymbol().getLine() + " and position: " 
					+ ctx.IDENT().getSymbol().getCharPositionInLine() + " not declared.");
			System.exit(200);
		}
		return typeOfArray;
	}
	
	@Override 
	public Type visitNewPair_assignrhs(@NotNull BasicParser.NewPair_assignrhsContext ctx) { 
		visit(ctx.expr(0));
		visit(ctx.expr(1));
		return null;
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
	public Type visitString_baseType(@NotNull BasicParser.String_baseTypeContext ctx) { 
		return PrimType.STRING;
	}
	
	@Override 
	public Type visitIdentEq_Stat(@NotNull BasicParser.IdentEq_StatContext ctx) {
		Type type1 = visit(ctx.type());
		Type type2 = visit(ctx.assignrhs());
		if (!(type1.isOfType(type2))) {
			System.err.println("Mismatched types. Expected: " + type1 + "Actual: " + type2);
			System.exit(200);
		}
		String id = ctx.IDENT().getText();
		if (TOP_ST.lookUpCurrLevelOnly(id) == null) {
			TOP_ST.add(ctx.IDENT().getText(), type1);
		} else {
			System.err.println("Identifier already declared: " + id);
			System.exit(200);
		}		
		return null;
	}
	
	@Override 
	public Type visitRead_Stat(@NotNull BasicParser.Read_StatContext ctx) { 
		 Type t = visit(ctx.assignlhs());
		 if (!(t.isOfType(PrimType.CHAR) || t.isOfType(PrimType.INT)
			 ||t.isOfType(PrimType.STRING))) {
			 System.err.println("Cannot read. Type is invalid");
			 System.exit(200);
		 }
		 return null;
	}
    
    @Override 
    public Type visitBegin_Stat(@NotNull BasicParser.Begin_StatContext ctx) { 
    	SymbolTable symbolTable1 = new SymbolTable(TOP_ST);
    	TOP_ST = symbolTable1;
    	visit(ctx.stat());
    	TOP_ST = TOP_ST.getParent();
    	return null;
    }
    
    @Override 
    public Type visitAssignLhsRhs_Stat(@NotNull BasicParser.AssignLhsRhs_StatContext ctx) {
    	Type lhs = visit(ctx.assignlhs());
    	Type rhs = visit(ctx.assignrhs());
    	if (!lhs.isOfType(rhs)) {
    		System.err.println("Mismatched types of lhs: " + lhs + " and rhs: " + rhs);
    		System.exit(200);
    	}
    	return null;
    }
    
    @Override 
    public Type visitFree_Stat(@NotNull BasicParser.Free_StatContext ctx) { 
    	Type t = visit(ctx.expr());
    	if (!(t instanceof ArrayType || t instanceof PairType)) {
    		System.err.println("Incorrect type. Must be of arraytype or pairtype. Actual type: " 
    				+ t);
    		System.exit(200);
    	}
    	return null;
    }
    
    @Override 
    public Type visitArrayelem_AssignLhs(@NotNull BasicParser.Arrayelem_AssignLhsContext ctx) { 
    	return visitChildren(ctx); 
    }
    
    @Override 
    public Type visitIdent_AssignLhs(@NotNull BasicParser.Ident_AssignLhsContext ctx) {
    	String id = ctx.IDENT().getText();
    	Type type = TOP_ST.lookUpCurrLevelAndEnclosingLevels(id);
    	if (type == null) {
    		System.err.println("The identifier " + id + "not declared");
    		System.exit(200);
    	}
    	return type;
    }
    
    @Override
    public Type visitReturn_Stat(@NotNull BasicParser.Return_StatContext ctx) { 
    	return visit(ctx.expr());
    }
    
    @Override 
    public Type visitExit_Stat(@NotNull BasicParser.Exit_StatContext ctx) { 
    	Type t = visit(ctx.expr());
    	if (t != PrimType.INT) {
    		System.err.println("Expected type: Int, Actual type: " + t);
    		System.exit(200);
    	}
    	return null;
    }
    
    @Override 
    public Type visitPrint_Stat(@NotNull BasicParser.Print_StatContext ctx) { 
    	return visit(ctx.expr());
    }
    
    @Override
    public Type visitSemicolon_Stat(@NotNull BasicParser.Semicolon_StatContext ctx) {
    	visit(ctx.stat(0));
    	visit(ctx.stat(1));
    	return null;
    }
    
    @Override 
    public Type visitIf_Stat(@NotNull BasicParser.If_StatContext ctx) { 
    	Type t = visit(ctx.expr());
    	if (t == PrimType.BOOL) {
    		SymbolTable sym1 = new SymbolTable(TOP_ST);
    		TOP_ST = sym1;
    		visit(ctx.stat(0));
    		TOP_ST = TOP_ST.getParent();
    		SymbolTable sym2 = new SymbolTable(TOP_ST);
    		TOP_ST = sym2;
    		visit(ctx.stat(1));
    		TOP_ST = TOP_ST.getParent();
    	}
    	System.err.println("Expression does not resolve to a Bool Type. Actual type: " + t);
    	System.exit(200); 
    	return null;
    }
    
    @Override 
    public Type visitWhile_Stat(@NotNull BasicParser.While_StatContext ctx) {
    	Type t = visit(ctx.expr());
    	if (t != PrimType.BOOL) {
    		System.err.println("Expression does not resolve to a Bool Type. Actual type: " + t);
    	    System.exit(200);
    	}
    	SymbolTable sym1 = new SymbolTable(TOP_ST);
    	TOP_ST = sym1;
    	visit(ctx.stat());
    	TOP_ST = TOP_ST.getParent();
    	return null;
    }
    
    @Override 
    public Type visitBoolLiter_Expr(@NotNull BasicParser.BoolLiter_ExprContext ctx) { 
    	return PrimType.BOOL;
    }
    
    @Override 
    public Type visitIntLiter_Expr(@NotNull BasicParser.IntLiter_ExprContext ctx) { 
    	return PrimType.INT;
    }
    
    @Override 
    public Type visitCharLiter_Expr(@NotNull BasicParser.CharLiter_ExprContext ctx) { 
    	return PrimType.CHAR; 
    }
    
    @Override 
    public Type visitStrLiter_Expr(@NotNull BasicParser.StrLiter_ExprContext ctx) { 
    	return PrimType.STRING; 
    }
    
    @Override 
    public Type visitPairLiter_Expr(@NotNull BasicParser.PairLiter_ExprContext ctx) { 
    	return PrimType.NULL; 
    }
    
    @Override 
    public Type visitIdent_Expr(@NotNull BasicParser.Ident_ExprContext ctx) { 
    	String id = ctx.IDENT().getText();
    	Type t = TOP_ST.lookUpCurrLevelAndEnclosingLevels(id);
    	if (t == null) {
    		System.err.println("Ident " + id + "not defined");
    		System.exit(200);
    	}
    	return t;
    }
	
	@Override 
	public Type visitUnaryoper(@NotNull BasicParser.UnaryoperContext ctx) { 
		switch (ctx.start.getType()) {
		case BasicParser.NOT : return PrimType.BOOL;
		case BasicParser.MINUS : return PrimType.INT;
		case BasicParser.LEN : return PrimType.INT;
		case BasicParser.ORD : return PrimType.INT;
		case BasicParser.CHR : return PrimType.CHAR;
		default : return null;
		}
	}
	
	@Override 
	public Type visitBaseType_arrayType(@NotNull BasicParser.BaseType_arrayTypeContext ctx) { 
		return visit(ctx.basetype()); 
	}
	
	@Override 
	public Type visitArrayType_arrayType(@NotNull BasicParser.ArrayType_arrayTypeContext ctx) { 
		return visit(ctx.arraytype()); 
	}
	
	@Override 
	public Type visitPairType_arrayType(@NotNull BasicParser.PairType_arrayTypeContext ctx) { 
		return visit(ctx.pairtype()); 
	}
	
	@Override 
	public Type visitBaseType_pairElemType(@NotNull BasicParser.BaseType_pairElemTypeContext ctx) { 
		return visit(ctx.basetype()); 
	}

	@Override
	public Type visitPairelem(BasicParser.PairelemContext ctx) {
		Type t = visit(ctx.expr());
		if (!(t instanceof PairType)) {
			System.err.println("Not a pair type. Actual: " + t);
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
		Type type = visit(ctx.arglist().expr(0));
		for (BasicParser.ExprContext expr : ctx.arglist().expr()) {
			if (!visit(expr).isOfType(type)) {
				System.err.println("Type error at line " + expr.getStart().getLine() + 
						"and position " + expr.getStart().getCharPositionInLine() +  
						". All the items in the list must be of type " + type);
				System.exit(200);
			}
		}
		return type;
	}
	
}



