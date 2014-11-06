import java.util.HashMap;

import java.util.List;
import java.util.Map;


import org.antlr.v4.runtime.tree.TerminalNode;



public class WACCVisitor extends BasicParserBaseVisitor<Type>{

	private Map<String, List<TerminalNode>> programsSymbolTable = new HashMap<String, List<TerminalNode>>();
	private Map<String, String> variableSymbolTable = new HashMap<String, String>();

	@Override
	public Type visitArglist(BasicParser.ArglistContext ctx) {
		for (int i=0; i<ctx.expr().size(); i++) {
			visitExpr(ctx.expr(i));
		}
		for (int i=0; i<ctx.COMMA().size(); i++) {
			visitTerminal(ctx.COMMA(i));
		}
		return Type.DONTCARE;
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
		variableSymbolTable.put(ctx.IDENT().getText(), ctx.type().getText());
		return Type.IDENT;
	}

	@Override
	public Type visitBinaryOper(BasicParser.BinaryOperContext ctx) {
		return Type.BINOP;
	}

	@Override
	public Type visitExpr(BasicParser.ExprContext ctx) {
		switch (ctx.getStart().getType()) {
		
		   case 51 : return Type.INT;
		   
		   case 49 : return Type.BOOL;
		   
		   case 53 : return Type.CHAR;
		   
		   case 54 : return Type.STRING;
		   
		   case 56 : return Type.PAIR;
		   
		   case 55 : return Type.IDENT;
		   
		   case 20 : return visitExpr(ctx.expr(0)); // case { expr }
		   
		   default : return visitCompoundExpr(ctx); 
		}
	}

	private Type visitCompoundExpr(BasicParser.ExprContext ctx) {
		if ((ctx.getChild(1) instanceof BasicParser.BinaryOperContext)) {  //case expr binOp expr
			
		    Type expr1 = visitExpr(ctx.expr(0));
		    Type expr2 = visitExpr(ctx.expr(1));
		    if (expr1.equals(expr2) && checkBinOp(ctx).equals(expr1) ) {
		        	return expr1;
		    } else {
		        	return Type.ERROR;
		    }
		    
		} else if(ctx.getChild(0) instanceof BasicParser.ArrayelemContext) { 
			
			return visitExpr(ctx.expr(0));
			
		} else if(ctx.getChild(0) instanceof BasicParser.UnaryoperContext &&
			checkBinOp(ctx).equals(visitExpr(ctx.expr(0)))) {
			return visitExpr(ctx.expr(0));
			
		} else {
			
			return Type.ERROR;
		}
	
	}

	private Type checkBinOp(BasicParser.ExprContext ctx) {
		
		switch (ctx.binaryOper().getStart().getType()) {
		
		case BasicParser.DIV : 

		case BasicParser.MUL : 
			
		case BasicParser.MOD :	
			
		case BasicParser.PLUS :
			
		case BasicParser.MINUS :
			
		case BasicParser.GRT :
			
		case BasicParser.GRTEQ :
			
		case BasicParser.SMT :
			
		case BasicParser.NOT:
			
		case BasicParser.LEN:
			
		case BasicParser.ORD:
			
		case BasicParser.CHR:
			
		case BasicParser.SMTEQ : return (Type.INT);
		
		case BasicParser.EQEQ :
			
		case BasicParser.NOTEQ : 
		
		case BasicParser.AND :
			
		case BasicParser.OR : return (Type.BOOL);
		
		default : return Type.ERROR;
		
		}
		
	}

	@Override
	public Type visitArrayelem(BasicParser.ArrayelemContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	 //Need to ask about this
	@Override
	public Type visitParamlist(BasicParser.ParamlistContext ctx) {
		for (BasicParser.ParamContext param : ctx.param()) {
			 visitParam(param);
		}
		return Type.DONTCARE;
	}

	@Override
	public Type visitType(BasicParser.TypeContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Type visitStat(BasicParser.StatContext ctx) {
		switch (ctx.getStart().getType()) {
		
		case BasicParser.SKIP : return Type.SKIP;
		
		case BasicParser.BEGIN : return visitStat(ctx.stat(0));
		
		case BasicParser.FREE : if (ctx.getChild(1) instanceof BasicParser.PairelemContext ||
				                    ctx.getChild(1) instanceof BasicParser.ArrayelemContext) { 
			                        return visitExpr(ctx.expr());
		                        } else {
		        	                return Type.ERROR;
		                        }
		          
		case BasicParser.RETURN :
		
		case BasicParser.EXIT : if (visit(ctx.expr()).equals(Type.INT)) {
			                        return visit(ctx.expr());
		                        } else {
		        	                return Type.ERROR;
		                        }
		
		case BasicParser.PRINT :
		
		case BasicParser.PRINTLN : return visitExpr(ctx.expr());
		
		case BasicParser.WHILE : if (visit(ctx.expr()).equals(Type.BOOL)) {  //while
			                        return visitStat(ctx.stat(0));
		                         }
		
		case BasicParser.IF : if (visit(ctx.expr()).equals(Type.BOOL)) {
			                     visitStat(ctx.stat(0));
			                     return visitStat(ctx.stat(0));
		                      }
		
		case BasicParser.READ : return visitAssignlhs(ctx.assignlhs());
		
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
			return visitStat(ctx.stat(1));
		} else {
			return Type.ERROR;
		}
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
		for (BasicParser.FuncContext func : ctx.func()) {
			visitFunc(func);
		}
		return visitStat(ctx.stat());
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
			return visitExpr(ctx.expr(1));
		} else if (ctx.getStart().getType() == 43 &&  
			programsSymbolTable.get(ctx.IDENT().getText()) == ctx.arglist()) {
			return visitAssignrhs(ctx);
		} else {
			return Type.ERROR;
		}
	}

	@Override
	public Type visitFunc(BasicParser.FuncContext ctx) {
		if (ctx.getChild(3) instanceof BasicParser.ParamlistContext) {
		    programsSymbolTable.put(ctx.IDENT().getText(), ctx.paramlist().getTokens(0));
		}
		if (visitType(ctx.type()).equals(visitStat(ctx.stat()))) {
			return visitType(ctx.type());
		} else {
			return Type.ERROR;
		}
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


