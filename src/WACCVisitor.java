import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		return PrimType.NULL;
		
	}
	
    @Override
	public Type visitParam(BasicParser.ParamContext ctx) {
    	Type t = visit(ctx.type());
    	TOP_ST.add(ctx.IDENT().getText(), t);
    	return t;
	}
    
	@Override
	public Type visitAssignlhs(BasicParser.AssignlhsContext ctx) {
		if (ctx.getStart().getType() == 55) {
			return PrimType.IDENT;
		} else if (ctx.getChild(0) instanceof BasicParser.ArrayelemContext) {
			return visit(ctx.arrayelem());
		} else if (ctx.getChild(0) instanceof BasicParser.PairelemContext) {
			return visit(ctx.pairelem());
		} else {
			return PrimType.ERROR;
		}
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
		if (ctx.getChild(3) instanceof BasicParser.ArglistContext) {
			return PrimType.NULL;
		}
		return PrimType.NULL;
	}
	
	@Override 
	public Type visitBaseType_type(@NotNull BasicParser.BaseType_typeContext ctx) { 
		return visit(ctx.basetype());
	}
	
	@Override 
	public Type visitNewPair_assignrhs(@NotNull BasicParser.NewPair_assignrhsContext ctx) { 
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
    public Type visitBegin_Stat(@NotNull BasicParser.Begin_StatContext ctx) { 
    	SymbolTable symbolTable1 = new SymbolTable(TOP_ST);
    	TOP_ST = symbolTable1;
    	visit(ctx.stat());
    	TOP_ST = TOP_ST.getParent();
    	return null;
    }
    
    @Override 
    public Type visitFree_Stat(@NotNull BasicParser.Free_StatContext ctx) { 
    	if (visit(ctx.expr()) != PrimType.INT) {
    		System.exit(200);
    	}
    	return null;
    }
    
    @Override
    public Type visitReturn_Stat(@NotNull BasicParser.Return_StatContext ctx) { 
    	return visit(ctx.expr());
    }
    
   
    
    @Override 
    public Type visitExit_Stat(@NotNull BasicParser.Exit_StatContext ctx) { 
    	if (visit(ctx.expr()) != PrimType.INT) {
    		System.exit(200);
    	}
    	return null;
    }
    
    @Override 
    public Type visitPrint_Stat(@NotNull BasicParser.Print_StatContext ctx) { 
    	return visit(ctx.expr());
    }
    
    @Override 
    public Type visitPrintln_Stat(@NotNull BasicParser.Println_StatContext ctx) { 
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
    	if (visit(ctx.expr()) == PrimType.BOOL) {
    		return PrimType.BOOL;
    	}
    	System.exit(200); return PrimType.ERROR;
    }
    
    @Override 
    public Type visitWhile_Stat(@NotNull BasicParser.While_StatContext ctx) { 
    	if (visit(ctx.expr()) == PrimType.BOOL) {
    		return visit(ctx.stat());
    	} 
    	System.exit(200); return PrimType.ERROR;
    }
    
    @Override 
    public Type visitBoolLiter_Expr(@NotNull BasicParser.BoolLiter_ExprContext ctx) { 
    	if (ctx.start.getType() == BasicParser.BOOL) {
    		return PrimType.BOOL;
    	} 
    	System.exit(200); return PrimType.ERROR;
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
    	return PrimType.IDENT; 
    }

	@Override
	public Type visitArglist(BasicParser.ArglistContext ctx) {
		if (ctx.expr().size() == ctx.COMMA().size() + 1) {
			return PrimType.NULL;
		}
		System.exit(200);
		return PrimType.NULL;
	}
	
	@Override 
	public Type visitFactor(@NotNull BasicParser.FactorContext ctx) { 
		switch (ctx.start.getType()) {
		case BasicParser.MUL : return PrimType.MUL;
		case BasicParser.DIV : return PrimType.DIV;
		case BasicParser.MOD : return PrimType.MOD;
		default : System.exit(200); return PrimType.ERROR;
		}
	}
	
	@Override 
	public Type visitTerm_Expr(@NotNull BasicParser.Term_ExprContext ctx) { 
		return visitChildren(ctx); 
	}
	
	@Override 
	public Type visitTerm(@NotNull BasicParser.TermContext ctx) { 
		switch (ctx.start.getType()) {
		case BasicParser.PLUS  : return PrimType.PLUS;
		case BasicParser.MINUS : return PrimType.MINUS;
		case BasicParser.GRT   : return PrimType.GRT;
		case BasicParser.GRTEQ : return PrimType.GRTEQ;
		case BasicParser.SMT   : return PrimType.SMT;
		case BasicParser.EQEQ  : return PrimType.EQEQ;
		case BasicParser.SMTEQ : return PrimType.SMTEQ;
		case BasicParser.NOTEQ : return PrimType.NOTEQ;
		case BasicParser.AND   : return PrimType.AND;
		case BasicParser.OR    : return PrimType.OR;
		default                : System.exit(200); return PrimType.ERROR;
		}
	}
	
	
	@Override
	public Type visitFactor_Expr(@NotNull BasicParser.Factor_ExprContext ctx) { 
		if (visit(ctx.expr(0)) == PrimType.INT && visit(ctx.expr(1)) == PrimType.INT) {
			return PrimType.INT;
		} else System.exit(200); return PrimType.ERROR;
	}
	
	@Override 
	public Type visitArrayelem(@NotNull BasicParser.ArrayelemContext ctx) { 
		return visit(ctx.expr());
	}
	
	@Override 
	public Type visitBool_Liter(@NotNull BasicParser.Bool_LiterContext ctx) { 
		 if (ctx.start.getType() == BasicParser.TRUE) {
			 return PrimType.TRUE;
		 } 
		 return PrimType.FALSE;
	}
	
	/*@Override
	public Type visitExpr(BasicParser.ExprContext ctx) {
		Type t;
		switch (ctx.getStart().getType()) {
		
		   case BasicParser.INT_LITER : return  Type.INT;
		   
		   case BasicParser.BOOL_LITER : return Type.BOOL;
		   
		   case BasicParser.CHAR_LITER : return Type.CHAR;
		   
		   case BasicParser.STR_LITER : return Type.STRING;
		   
		   case BasicParser.PAIR_LITER : return Type.PAIR;
		   
		   case BasicParser.IDENT : return Type.IDENT;
		   
		   //case BasicParser.OPEN_PARENTHESES : t = visitExpr(ctx.expr(0)); // case { expr }
		   
		   default : t = null; 
		}
		return t;
	}*/

	/*private Type visitCompoundExpr(BasicParser.ExprContext ctx) {
		
		if ((ctx.getChild(1) instanceof BasicParser.TermContext ||
				ctx.getChild(1) instanceof BasicParser.FactorContext )) { 
		    Type expr1 = visit(ctx.expr(0));
		    Type expr2 = visit(ctx.expr(1));
		    return null;
		} else {
			return null;
		}
	}*/
		/*    if (expr1.equals(expr2) ) {
		        	return checkIfExprAllowed(expr1, ctx);
		    } else {
		        	return Type.ERROR;
		    }
		    
		} else if(!ctx.arrayelem().isEmpty()) { 
			
			return visit(ctx.expr(0));
			
		} else if(!ctx.unaryoper().isEmpty()) {
			
			Type expr1 = visit(ctx.expr(0));
			return checkIfExprAllowed(expr1, ctx);
			
		} else {
			
			return Type.ERROR;
		}
	
	}*/

	/*private Type visitComplexStat(BasicParser.StatContext ctx) {
		if (ctx.getChild(0) instanceof BasicParser.TypeContext &&
		    visit(ctx.type()).equals(visitAssignrhs(ctx.assignrhs()))) {
			return visitAssignrhs(ctx.assignrhs());
		} else if (ctx.getChild(0) instanceof BasicParser.AssignlhsContext &&
		    visit(ctx.assignlhs()).equals(visitAssignrhs(ctx.assignrhs()))) {
			return visitAssignrhs(ctx.assignrhs());  
		} else if (ctx.getChild(0) instanceof BasicParser.StatContext) {
			visitStat(ctx.stat(0));
			visitStat(ctx.stat(1));
		} else {
			return Type.ERROR;
		}
		return null;
	}

	@Override
	public Type visitProg(BasicParser.ProgContext ctx) {
		
		return null;
	}

	@Override
	public Type visitArrayliter(BasicParser.ArrayliterContext ctx) {
		if (ctx.getChild(1) instanceof BasicParser.ArglistContext) {
			return visit(ctx.arglist());
		}
		return Type.NULL;
	}

	/*@Override
	public Type visitPairtype(BasicParser.PairtypeContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	/*@Override
	public Type visitAssignrhs(BasicParser.AssignrhsContext ctx) {
		if (ctx.getChild(0) instanceof BasicParser.ExprContext) {
			return visit(ctx.expr(0));
		} else if (ctx.getChild(0) instanceof BasicParser.ArrayliterContext) {
			return visit(ctx.arrayliter());
		} else if (ctx.getChild(0) instanceof BasicParser.PairelemContext) {
			return visit(ctx.pairelem());
		} else if (ctx.getStart().getType() == 42) {
			visitExpr(ctx.expr(0));
			visitExpr(ctx.expr(1));
		} else if (ctx.getStart().getType() == 43) {
			//Will do when I implement Symbol Table
			
		} else {
			return Type.ERROR;
		}
		return null;
	}*/
	
	@Override 
	public Type visitUnaryoper(@NotNull BasicParser.UnaryoperContext ctx) { 
		return PrimType.NULL;
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
	public Type visitPair_pairElemType(@NotNull BasicParser.Pair_pairElemTypeContext ctx) { 
		return PrimType.PAIR;
	}
	
	@Override 
	public Type visitBaseType_pairElemType(@NotNull BasicParser.BaseType_pairElemTypeContext ctx) { 
		return visit(ctx.basetype()); 
	}

	@Override
	public Type visitPairelem(BasicParser.PairelemContext ctx) {
		return visit(ctx.expr());
	}
	
	@Override 
	public Type visitArrayliter(@NotNull BasicParser.ArrayliterContext ctx) { 
		if (ctx.getChild(1) instanceof BasicParser.ArglistContext) {
			return visit(ctx.arglist());
		}
		return PrimType.NULL;
	}
	
}



