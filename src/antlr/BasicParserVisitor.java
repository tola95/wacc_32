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
	 * Visit a parse tree produced by the {@code semicolon_Stat}
	 * labeled alternative in {@link BasicParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSemicolon_Stat(@NotNull BasicParser.Semicolon_StatContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicParser#bool_Liter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool_Liter(@NotNull BasicParser.Bool_LiterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code if_Stat}
	 * labeled alternative in {@link BasicParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_Stat(@NotNull BasicParser.If_StatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenth_Expr}
	 * labeled alternative in {@link BasicParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenth_Expr(@NotNull BasicParser.Parenth_ExprContext ctx);
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
	 * Visit a parse tree produced by the {@code strLiter_Expr}
	 * labeled alternative in {@link BasicParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStrLiter_Expr(@NotNull BasicParser.StrLiter_ExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayElem_Expr}
	 * labeled alternative in {@link BasicParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayElem_Expr(@NotNull BasicParser.ArrayElem_ExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unaryOper_Expr}
	 * labeled alternative in {@link BasicParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryOper_Expr(@NotNull BasicParser.UnaryOper_ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(@NotNull BasicParser.ParamContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exp_Stat}
	 * labeled alternative in {@link BasicParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp_Stat(@NotNull BasicParser.Exp_StatContext ctx);
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
	 * Visit a parse tree produced by {@link BasicParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(@NotNull BasicParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(@NotNull BasicParser.FactorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolLiter_Expr}
	 * labeled alternative in {@link BasicParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolLiter_Expr(@NotNull BasicParser.BoolLiter_ExprContext ctx);
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
	 * Visit a parse tree produced by the {@code assignLhsRhs_Stat}
	 * labeled alternative in {@link BasicParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignLhsRhs_Stat(@NotNull BasicParser.AssignLhsRhs_StatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ident_Expr}
	 * labeled alternative in {@link BasicParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdent_Expr(@NotNull BasicParser.Ident_ExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pairLiter_Expr}
	 * labeled alternative in {@link BasicParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPairLiter_Expr(@NotNull BasicParser.PairLiter_ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicParser#paramlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamlist(@NotNull BasicParser.ParamlistContext ctx);
	/**
	 * Visit a parse tree produced by the {@code while_Stat}
	 * labeled alternative in {@link BasicParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile_Stat(@NotNull BasicParser.While_StatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intLiter_Expr}
	 * labeled alternative in {@link BasicParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntLiter_Expr(@NotNull BasicParser.IntLiter_ExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code read_Stat}
	 * labeled alternative in {@link BasicParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRead_Stat(@NotNull BasicParser.Read_StatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code charLiter_Expr}
	 * labeled alternative in {@link BasicParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharLiter_Expr(@NotNull BasicParser.CharLiter_ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(@NotNull BasicParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by the {@code factor_Expr}
	 * labeled alternative in {@link BasicParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor_Expr(@NotNull BasicParser.Factor_ExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code begin_Stat}
	 * labeled alternative in {@link BasicParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBegin_Stat(@NotNull BasicParser.Begin_StatContext ctx);
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
	 * Visit a parse tree produced by the {@code term_Expr}
	 * labeled alternative in {@link BasicParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm_Expr(@NotNull BasicParser.Term_ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicParser#func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc(@NotNull BasicParser.FuncContext ctx);
	/**
	 * Visit a parse tree produced by the {@code identEq_Stat}
	 * labeled alternative in {@link BasicParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentEq_Stat(@NotNull BasicParser.IdentEq_StatContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicParser#basetype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasetype(@NotNull BasicParser.BasetypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link BasicParser#pairtype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPairtype(@NotNull BasicParser.PairtypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code skip_Stat}
	 * labeled alternative in {@link BasicParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSkip_Stat(@NotNull BasicParser.Skip_StatContext ctx);
}