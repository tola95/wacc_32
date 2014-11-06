import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;



public class WACCVisitor extends BasicParserBaseVisitor<Type>{
	
//	private Map<String, List<>> = new HashMap<>();

	@Override
	public Type visit(@NotNull ParseTree arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Type visitChildren(@NotNull RuleNode arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Type visitErrorNode(@NotNull ErrorNode arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Type visitTerminal(@NotNull TerminalNode arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	//
	//
	//
	//
	//
	//
	//
	//

	@Override
	public Type visitArglist(BasicParser.ArglistContext ctx) {
		for (int i=0; i<ctx.expr().size(); i++) {
			visitExpr(ctx.expr(i));
		}
		for (int i=0; i<ctx.COMMA().size(); i++) {
			visitTerminal(ctx.COMMA(i));
		}
		return null;
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
	public Type visitParam(BasicParser.ParamContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Type visitBinaryOper(BasicParser.BinaryOperContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Type visitExpr(BasicParser.ExprContext ctx) {
		Type t;
		switch (ctx.getStart().getType()) {
		
		   case 51 : t =  Type.INT;
		   
		   case 49 : t = Type.BOOL;
		   
		   case 53 : t = Type.CHAR;
		   
		   case 54 : t = Type.STRING;
		   
		   case 56 : t = Type.PAIR;
		   
		   case 55 : t = Type.IDENT;
		   
		   case 20 : t = visitExpr(ctx.expr(0)); // case { expr }
		   
		   default : t = visitCompoundExpr(ctx); 
		}
		return t;
	}

	private Type visitCompoundExpr(BasicParser.ExprContext ctx) {
		if ((ctx.getChild(1) instanceof BasicParser.BinaryOperContext)) {  //case expr binOp expr
			
		    Type expr1 = visit(ctx.expr(0));
		    Type expr2 = visit(ctx.expr(1));
		    if (expr1.equals(expr2) ) {
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
	
	}

	private Type checkIfExprAllowed(Type expr1, BasicParser.ExprContext ctx) {
		
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
		
	}

	@Override
	public Type visitArrayelem(BasicParser.ArrayelemContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Type visitParamlist(BasicParser.ParamlistContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Type visitType(BasicParser.TypeContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Type visitStat(BasicParser.StatContext ctx) {
		switch (ctx.getStart().getType()) {
		
		case 26 : return Type.SKIP;
		
		case 24 : return visitStat(ctx.stat(0));
		
		case 29 : if (ctx.getChild(1) instanceof BasicParser.PairelemContext ||
				      ctx.getChild(1) instanceof BasicParser.ArrayelemContext) { 
			          visitExpr(ctx.expr());
		          } else {
		        	  return Type.ERROR;
		          }
		          
		case 30 :
		
		case 31 : if (visit(ctx.expr()).equals(Type.INT)) {
			          return visit(ctx.expr());
		          } else {
		        	  return Type.ERROR;
		          }
		
		case 32 :
		
		case 33 : return visitExpr(ctx.expr());
		
		case 47 : if (visit(ctx.expr()).equals(Type.BOOL)) {  //while
			          visitStat(ctx.stat(0));
		          }
		
		case 34 : if (visit(ctx.expr()).equals(Type.BOOL)) {
			          visitStat(ctx.stat(0));
			          visitStat(ctx.stat(1));
		          }
		
		case 27 : return visitAssignlhs(ctx.assignlhs());
		
		default : return visitComplexStat(ctx);
		
		}
	}

	private Type visitComplexStat(BasicParser.StatContext ctx) {
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
	}

	@Override
	public Type visitArrayliter(BasicParser.ArrayliterContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Type visitPairtype(BasicParser.PairtypeContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Type visitProgram(BasicParser.ProgramContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Type visitUnaryoper(BasicParser.UnaryoperContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
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
	}

	@Override
	public Type visitFunc(BasicParser.FuncContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Type visitPairelemtype(BasicParser.PairelemtypeContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Type visitPairelem(BasicParser.PairelemContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}


}


