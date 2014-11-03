// Generated from ./BasicParser.g4 by ANTLR 4.4
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link BasicParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface BasicParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link BasicParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat(@NotNull BasicParser.StatContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicParser#assignrhs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignrhs(@NotNull BasicParser.AssignrhsContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicParser#pairelemtype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPairelemtype(@NotNull BasicParser.PairelemtypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicParser#assignlhs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignlhs(@NotNull BasicParser.AssignlhsContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicParser#arrayliter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayliter(@NotNull BasicParser.ArrayliterContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicParser#paramlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamlist(@NotNull BasicParser.ParamlistContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(@NotNull BasicParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicParser#pairelem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPairelem(@NotNull BasicParser.PairelemContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(@NotNull BasicParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicParser#binaryOper}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryOper(@NotNull BasicParser.BinaryOperContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(@NotNull BasicParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicParser#arrayelem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayelem(@NotNull BasicParser.ArrayelemContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicParser#arraytype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArraytype(@NotNull BasicParser.ArraytypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicParser#func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc(@NotNull BasicParser.FuncContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(@NotNull BasicParser.ParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicParser#arglist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArglist(@NotNull BasicParser.ArglistContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicParser#unaryoper}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryoper(@NotNull BasicParser.UnaryoperContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(@NotNull BasicParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicParser#pairtype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPairtype(@NotNull BasicParser.PairtypeContext ctx);
}