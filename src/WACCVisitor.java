import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;



public class WACCVisitor extends BasicParserBaseVisitor<Type> {
	
//	private Map<String, List<>> = new HashMap<>();
    @Override
	public Type visitProgram(BasicParser.ProgramContext ctx) {
    	for (BasicParser.FuncContext func : ctx.func()) {
    		visit(func);
    	}
    	return visit(ctx.stat());
	}
    
    @Override
	public Type visitFunc(BasicParser.FuncContext ctx) {
		Type t = visit(ctx.type());
		if (ctx.getChild(3) instanceof BasicParser.ParamlistContext) {
			visit(ctx.paramlist());
		}
		if (visit(ctx.stat()) == t) {
			return Type.NULL;
		} 
		System.exit(200); 
		return Type.NULL;
	}
    
	@Override
	public Type visitParamlist(BasicParser.ParamlistContext ctx) {
		if (ctx.COMMA().size() == ctx.param().size() - 1) {
			return Type.NULL;
		} else System.exit(200); return Type.NULL;
	}
	
    @Override
	public Type visitParam(BasicParser.ParamContext ctx) {
		return visit(ctx.type());
	}
    
	@Override
	public Type visitAssignlhs(BasicParser.AssignlhsContext ctx) {
		if (ctx.getStart().getType() == 55) {
			return Type.IDENT;
		} else if (ctx.getChild(0) instanceof BasicParser.ArrayelemContext) {
			return visit(ctx.arrayelem());
		} else if (ctx.getChild(0) instanceof BasicParser.PairelemContext) {
			return visit(ctx.pairelem());
		} else {
			return Type.ERROR;
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
	public Type visitBaseType_type(@NotNull BasicParser.BaseType_typeContext ctx) { 
		return visit(ctx.basetype());
	}
	
	@Override 
	public Type visitNewPair_assignrhs(@NotNull BasicParser.NewPair_assignrhsContext ctx) { 
		return null;
	}
	
	@Override 
	public Type visitInt_baseType(@NotNull BasicParser.Int_baseTypeContext ctx) { 
		return Type.INT;
	}
	
	@Override 
	public Type visitBool_baseType(@NotNull BasicParser.Bool_baseTypeContext ctx) { 
		return Type.BOOL;
	}
	
	@Override 
	public Type visitChar_baseType(@NotNull BasicParser.Char_baseTypeContext ctx) { 
		return Type.CHAR;
	}
	
	@Override 
	public Type visitString_baseType(@NotNull BasicParser.String_baseTypeContext ctx) { 
		return Type.STRING;
	}
	
    @Override 
    public Type visitSkip_Stat(@NotNull BasicParser.Skip_StatContext ctx) { 
    	return Type.SKIP; 
    }
    
    @Override 
    public Type visitExp_Stat(@NotNull BasicParser.Exp_StatContext ctx) { 
    	switch (ctx.start.getType()) {
    	case BasicParser.FREE    :
    	case BasicParser.RETURN  :
    	case BasicParser.EXIT    :
    	case BasicParser.PRINT   :
    	case BasicParser.PRINTLN : return visit(ctx.expr());
    	default                  : return Type.ERROR;
    	}
    }
    
    @Override 
    public Type visitBegin_Stat(@NotNull BasicParser.Begin_StatContext ctx) { 
    	if (ctx.stop.getType() == BasicParser.END) {
    		return visit(ctx.getChild(1));
    	}
    	System.exit(200);
    	return Type.ERROR;
    }
    
    @Override
    public Type visitSemicolon_Stat(@NotNull BasicParser.Semicolon_StatContext ctx) {
    	visit(ctx.stat(0));
    	visit(ctx.stat(1));
    	return null;
    }
    
    @Override 
    public Type visitIf_Stat(@NotNull BasicParser.If_StatContext ctx) { 
    	if (visit(ctx.expr()) == Type.BOOL) {
    		return Type.BOOL;
    	}
    	System.exit(200); return Type.ERROR;
    }
    
    @Override 
    public Type visitWhile_Stat(@NotNull BasicParser.While_StatContext ctx) { 
    	if (visit(ctx.expr()) == Type.BOOL) {
    		return visit(ctx.stat());
    	} 
    	System.exit(200); return Type.ERROR;
    }
    
    @Override 
    public Type visitBoolLiter_Expr(@NotNull BasicParser.BoolLiter_ExprContext ctx) { 
    	if (ctx.start.getType() == BasicParser.BOOL) {
    		return Type.BOOL;
    	} 
    	System.exit(200); return Type.ERROR;
    }
    
    @Override 
    public Type visitIntLiter_Expr(@NotNull BasicParser.IntLiter_ExprContext ctx) { 
    	return Type.INT;
    }
    
    @Override 
    public Type visitCharLiter_Expr(@NotNull BasicParser.CharLiter_ExprContext ctx) { 
    	return Type.CHAR; 
    }
    
    @Override 
    public Type visitStrLiter_Expr(@NotNull BasicParser.StrLiter_ExprContext ctx) { 
    	return Type.STRING; 
    }
    
    
    
    @Override 
    public Type visitPairLiter_Expr(@NotNull BasicParser.PairLiter_ExprContext ctx) { 
    	return Type.NULL; 
    }
    
    @Override 
    public Type visitIdent_Expr(@NotNull BasicParser.Ident_ExprContext ctx) { 
    	return Type.IDENT; 
    }

	@Override
	public Type visitArglist(BasicParser.ArglistContext ctx) {
		if (ctx.expr().size() == ctx.COMMA().size() + 1) {
			return Type.NULL;
		}
		System.exit(200);
		return Type.NULL;
	}
	
	@Override 
	public Type visitFactor(@NotNull BasicParser.FactorContext ctx) { 
		switch (ctx.start.getType()) {
		case BasicParser.MUL : return Type.MUL;
		case BasicParser.DIV : return Type.DIV;
		case BasicParser.MOD : return Type.MOD;
		default : System.exit(-1); return Type.ERROR;
		}
	}
	
	@Override 
	public Type visitTerm_Expr(@NotNull BasicParser.Term_ExprContext ctx) { 
		return visitChildren(ctx); 
	}
	
	@Override 
	public Type visitTerm(@NotNull BasicParser.TermContext ctx) { 
		switch (ctx.start.getType()) {
		case BasicParser.PLUS  : return Type.PLUS;
		case BasicParser.MINUS : return Type.MINUS;
		case BasicParser.GRT   : return Type.GRT;
		case BasicParser.GRTEQ : return Type.GRTEQ;
		case BasicParser.SMT   : return Type.SMT;
		case BasicParser.EQEQ  : return Type.EQEQ;
		case BasicParser.SMTEQ : return Type.SMTEQ;
		case BasicParser.NOTEQ : return Type.NOTEQ;
		case BasicParser.AND   : return Type.AND;
		case BasicParser.OR    : return Type.OR;
		default                : System.exit(-1); return Type.ERROR;
		}
	}
	
	
	@Override
	public Type visitFactor_Expr(@NotNull BasicParser.Factor_ExprContext ctx) { 
		if (visit(ctx.expr(0)) == Type.INT && visit(ctx.expr(1)) == Type.INT) {
			return Type.INT;
		} else System.exit(-1); return Type.ERROR;
	}
	
	@Override 
	public Type visitArrayelem(@NotNull BasicParser.ArrayelemContext ctx) { 
		return visit(ctx.expr());
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

	/*private Type checkIfExprAllowed(Type expr1, BasicParser.ExprContext ctx) {
		
		switch (ctx.binaryOper().getStart().getType()) {
		
		case 1 : 
			
		case 2 :
			
		case 3 :	
			
		case 4 :
			
		case 5 :
			
		case 6 :
			
		case 7 :
			
		case 8 :
			
		case 14:
			
		case 15:
			
		case 16:
			
		case 17:
			
		case 9 : return (Type.INT);
		
		case 10 :
			
		case 11 : 
		
		case 12 :
			
		case 13 : return (Type.BOOL);
		
		default : return Type.ERROR;
		
		}
		
	}*/

	/*@Override
	public Type visitStat(BasicParser.StatContext ctx) {
		switch (ctx.getStart().getType()) {
		
		case BasicParser.SKIP : return Type.SKIP;
		
		case BasicParser.BEGIN : if (ctx.stop.getType() == BasicParser.END) {
			return visitStat(ctx.stat(0));
		} else {
			return Type.ERROR;
		}
		
		case 29 : if (ctx.getChild(1) instanceof BasicParser.PairelemContext ||
				      ctx.getChild(1) instanceof BasicParser.ArrayelemContext) { 
			          visitExpr(ctx.expr());
		          } else {
		        	  return Type.ERROR;
		          }
		          
		
		case BasicParser.READ : return visitAssignlhs(ctx.assignlhs());
		
		case BasicParser.IS :
			
		case BasicParser.EXIT :
		
		case BasicParser.PRINT :
			
		case BasicParser.PRINTLN :
		
		case BasicParser.FREE : return visitExpr(ctx.expr());
		
		case 47 : if (visit(ctx.expr()).equals(Type.BOOL)) {  //while
			          visitStat(ctx.stat(0));
		          }
		
		case 34 : if (visit(ctx.expr()).equals(Type.BOOL)) {
			          visitStat(ctx.stat(0));
			          visitStat(ctx.stat(1));
		          }
		
		default : return visitComplexStat(ctx);
		
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
	public Type visitArraytype(BasicParser.ArraytypeContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}*/

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

	

	@Override
	public Type visitUnaryoper(BasicParser.UnaryoperContext ctx) {
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
	public Type visitPairelemtype(BasicParser.PairelemtypeContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Type visitPairelem(BasicParser.PairelemContext ctx) {
		
		return null;
	}


}



