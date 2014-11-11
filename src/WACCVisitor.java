import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

public class WACCVisitor extends BasicParserBaseVisitor<Type> implements BasicParserVisitor<Type> {
	
	
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
			for (int i=0; i<ctx.param().size(); i++) {
				visit(ctx.param(i));
			}
			return Type.NULL;
		} else System.exit(200); return Type.NULL;
	}
	
    @Override
	public Type visitParam(BasicParser.ParamContext ctx) {
//    	identSymbolTable.put(ctx.IDENT().getText(), ctx.type());
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
	public Type visitArrayliter(BasicParser.ArrayliterContext ctx) {
		if (ctx.getChild(1) instanceof BasicParser.ArglistContext) {
			return visit(ctx.arglist());
		}
		return Type.NULL;
	}

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



