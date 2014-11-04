import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import BasicParser.ExprContext;


public class SemanticChecker extends BasicParserBaseVisitor<Type>{

	@Override
	public T visit(@NotNull ParseTree arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T visitChildren(@NotNull RuleNode arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T visitErrorNode(@NotNull ErrorNode arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T visitTerminal(@NotNull TerminalNode arg0) {
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
		// TODO Auto-generated method stub
		return null;
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
		   
		   default : t = visitCompoundExpr(ctx);
		}
		return t;
	}

	private Type visitCompoundExpr(BasicParser.ExprContext ctx) {
		BasicParser.ExprContext expr1 = ctx.expr(0);
		BasicParser.ExprContext expr2 = ctx.expr(1);
	//	if ()
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Type visitProg(BasicParser.ProgContext ctx) {
		// TODO Auto-generated method stub
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
	public T visitProgram(BasicParser.ProgramContext ctx) {
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
		// TODO Auto-generated method stub
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
