// Generated from ./BasicParser.g4 by ANTLR 4.4
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BasicParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PRINT=35, NEWPAIR=45, STR_LITER=59, PAIR_LITER=61, DO=41, CHR=17, MINUS=5, 
		SEMICOLON=43, ELSE=39, IF=37, INTEGER=57, DONE=42, MUL=2, FST=47, NEWLINE=55, 
		TRUE=53, IS=31, EQ=22, READ=30, NOT=14, AND=12, GRTEQ=7, END=28, THEN=38, 
		SMT=8, EXIT=34, PLUS=4, CLOSE_PARENTHESES=24, ORD=16, CALL=46, FI=40, 
		PRINTLN=36, OPEN_PARENTHESES=23, GRT=6, CLOSE_SQUAREB=26, SND=48, CHAR=20, 
		BEGIN=27, FREE=32, INT=19, COMMENT=51, RETURN=33, SMTEQ=9, SKIP=29, WS=18, 
		COMMA=44, MOD=3, OR=13, CHAR_LITER=58, INT_LITER=56, NOTEQ=11, DIV=1, 
		LEN=15, IDENT=60, BOOL=52, EQEQ=10, STRING=21, OPEN_SQUAREB=25, WHILE=50, 
		FALSE=54, PAIR=49;
	public static final String[] tokenNames = {
		"<INVALID>", "'/'", "'*'", "'%'", "'+'", "'-'", "'>'", "'>='", "'<'", 
		"'<='", "'=='", "'!='", "'&&'", "'||'", "'!'", "'len'", "'ord'", "'chr'", 
		"WS", "'int'", "'char'", "'string'", "'='", "'('", "')'", "'['", "']'", 
		"'begin'", "'end'", "'skip'", "'read'", "'is'", "'free'", "'return'", 
		"'exit'", "'print'", "'println'", "'if'", "'then'", "'else'", "'fi'", 
		"'do'", "'done'", "';'", "','", "'newpair'", "'call'", "'fst'", "'snd'", 
		"'pair'", "'while'", "COMMENT", "'bool'", "'true'", "'false'", "'\n'", 
		"INT_LITER", "INTEGER", "CHAR_LITER", "STR_LITER", "IDENT", "'null'"
	};
	public static final int
		RULE_program = 0, RULE_func = 1, RULE_paramlist = 2, RULE_param = 3, RULE_stat = 4, 
		RULE_assignlhs = 5, RULE_assignrhs = 6, RULE_arglist = 7, RULE_pairelem = 8, 
		RULE_basetype = 9, RULE_type = 10, RULE_arraytype = 11, RULE_pairtype = 12, 
		RULE_pairelemtype = 13, RULE_expr = 14, RULE_unaryoper = 15, RULE_factor = 16, 
		RULE_bool_Liter = 17, RULE_term = 18, RULE_arrayelem = 19, RULE_arrayliter = 20, 
		RULE_prog = 21;
	public static final String[] ruleNames = {
		"program", "func", "paramlist", "param", "stat", "assignlhs", "assignrhs", 
		"arglist", "pairelem", "basetype", "type", "arraytype", "pairtype", "pairelemtype", 
		"expr", "unaryoper", "factor", "bool_Liter", "term", "arrayelem", "arrayliter", 
		"prog"
	};

	@Override
	public String getGrammarFileName() { return "BasicParser.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public BasicParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public List<FuncContext> func() {
			return getRuleContexts(FuncContext.class);
		}
		public FuncContext func(int i) {
			return getRuleContext(FuncContext.class,i);
		}
		public TerminalNode BEGIN() { return getToken(BasicParser.BEGIN, 0); }
		public TerminalNode END() { return getToken(BasicParser.END, 0); }
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(44); match(BEGIN);
			setState(48);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(45); func();
					}
					} 
				}
				setState(50);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(51); stat(0);
			setState(52); match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncContext extends ParserRuleContext {
		public TerminalNode CLOSE_PARENTHESES() { return getToken(BasicParser.CLOSE_PARENTHESES, 0); }
		public ParamlistContext paramlist() {
			return getRuleContext(ParamlistContext.class,0);
		}
		public TerminalNode IS() { return getToken(BasicParser.IS, 0); }
		public TerminalNode END() { return getToken(BasicParser.END, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(BasicParser.IDENT, 0); }
		public TerminalNode OPEN_PARENTHESES() { return getToken(BasicParser.OPEN_PARENTHESES, 0); }
		public FuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitFunc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncContext func() throws RecognitionException {
		FuncContext _localctx = new FuncContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_func);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54); type();
			setState(55); match(IDENT);
			setState(56); match(OPEN_PARENTHESES);
			setState(58);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << CHAR) | (1L << STRING) | (1L << PAIR) | (1L << BOOL))) != 0)) {
				{
				setState(57); paramlist();
				}
			}

			setState(60); match(CLOSE_PARENTHESES);
			setState(61); match(IS);
			setState(62); stat(0);
			setState(63); match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamlistContext extends ParserRuleContext {
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public List<TerminalNode> COMMA() { return getTokens(BasicParser.COMMA); }
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public TerminalNode COMMA(int i) {
			return getToken(BasicParser.COMMA, i);
		}
		public ParamlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramlist; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitParamlist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamlistContext paramlist() throws RecognitionException {
		ParamlistContext _localctx = new ParamlistContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_paramlist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65); param();
			setState(70);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(66); match(COMMA);
				setState(67); param();
				}
				}
				setState(72);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(BasicParser.IDENT, 0); }
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73); type();
			setState(74); match(IDENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatContext extends ParserRuleContext {
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
	 
		public StatContext() { }
		public void copyFrom(StatContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Begin_StatContext extends StatContext {
		public TerminalNode BEGIN() { return getToken(BasicParser.BEGIN, 0); }
		public TerminalNode END() { return getToken(BasicParser.END, 0); }
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public Begin_StatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitBegin_Stat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Semicolon_StatContext extends StatContext {
		public TerminalNode SEMICOLON() { return getToken(BasicParser.SEMICOLON, 0); }
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public Semicolon_StatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitSemicolon_Stat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Exp_StatContext extends StatContext {
		public TerminalNode RETURN() { return getToken(BasicParser.RETURN, 0); }
		public TerminalNode PRINT() { return getToken(BasicParser.PRINT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode FREE() { return getToken(BasicParser.FREE, 0); }
		public TerminalNode PRINTLN() { return getToken(BasicParser.PRINTLN, 0); }
		public TerminalNode EXIT() { return getToken(BasicParser.EXIT, 0); }
		public Exp_StatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitExp_Stat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdentEq_StatContext extends StatContext {
		public AssignrhsContext assignrhs() {
			return getRuleContext(AssignrhsContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode EQ() { return getToken(BasicParser.EQ, 0); }
		public TerminalNode IDENT() { return getToken(BasicParser.IDENT, 0); }
		public IdentEq_StatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitIdentEq_Stat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignLhsRhs_StatContext extends StatContext {
		public AssignlhsContext assignlhs() {
			return getRuleContext(AssignlhsContext.class,0);
		}
		public AssignrhsContext assignrhs() {
			return getRuleContext(AssignrhsContext.class,0);
		}
		public TerminalNode EQ() { return getToken(BasicParser.EQ, 0); }
		public AssignLhsRhs_StatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitAssignLhsRhs_Stat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class If_StatContext extends StatContext {
		public TerminalNode FI() { return getToken(BasicParser.FI, 0); }
		public TerminalNode ELSE() { return getToken(BasicParser.ELSE, 0); }
		public TerminalNode IF() { return getToken(BasicParser.IF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode THEN() { return getToken(BasicParser.THEN, 0); }
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public If_StatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitIf_Stat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class While_StatContext extends StatContext {
		public TerminalNode DONE() { return getToken(BasicParser.DONE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode DO() { return getToken(BasicParser.DO, 0); }
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public TerminalNode WHILE() { return getToken(BasicParser.WHILE, 0); }
		public While_StatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitWhile_Stat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Skip_StatContext extends StatContext {
		public TerminalNode SKIP() { return getToken(BasicParser.SKIP, 0); }
		public Skip_StatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitSkip_Stat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Read_StatContext extends StatContext {
		public AssignlhsContext assignlhs() {
			return getRuleContext(AssignlhsContext.class,0);
		}
		public TerminalNode READ() { return getToken(BasicParser.READ, 0); }
		public Read_StatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitRead_Stat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		return stat(0);
	}

	private StatContext stat(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		StatContext _localctx = new StatContext(_ctx, _parentState);
		StatContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_stat, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			switch (_input.LA(1)) {
			case SKIP:
				{
				_localctx = new Skip_StatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(77); match(SKIP);
				}
				break;
			case INT:
			case CHAR:
			case STRING:
			case PAIR:
			case BOOL:
				{
				_localctx = new IdentEq_StatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(78); type();
				setState(79); match(IDENT);
				setState(80); match(EQ);
				setState(81); assignrhs();
				}
				break;
			case FST:
			case SND:
			case IDENT:
				{
				_localctx = new AssignLhsRhs_StatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(83); assignlhs();
				setState(84); match(EQ);
				setState(85); assignrhs();
				}
				break;
			case READ:
				{
				_localctx = new Read_StatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(87); match(READ);
				setState(88); assignlhs();
				}
				break;
			case FREE:
			case RETURN:
			case EXIT:
			case PRINT:
			case PRINTLN:
				{
				_localctx = new Exp_StatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(89);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FREE) | (1L << RETURN) | (1L << EXIT) | (1L << PRINT) | (1L << PRINTLN))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(90); expr(0);
				}
				break;
			case IF:
				{
				_localctx = new If_StatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(91); match(IF);
				setState(92); expr(0);
				setState(93); match(THEN);
				setState(94); stat(0);
				setState(95); match(ELSE);
				setState(96); stat(0);
				setState(97); match(FI);
				}
				break;
			case WHILE:
				{
				_localctx = new While_StatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(99); match(WHILE);
				setState(100); expr(0);
				setState(101); match(DO);
				setState(102); stat(0);
				setState(103); match(DONE);
				}
				break;
			case BEGIN:
				{
				_localctx = new Begin_StatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(105); match(BEGIN);
				setState(106); stat(0);
				setState(107); match(END);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(116);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Semicolon_StatContext(new StatContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_stat);
					setState(111);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(112); match(SEMICOLON);
					setState(113); stat(2);
					}
					} 
				}
				setState(118);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class AssignlhsContext extends ParserRuleContext {
		public PairelemContext pairelem() {
			return getRuleContext(PairelemContext.class,0);
		}
		public ArrayelemContext arrayelem() {
			return getRuleContext(ArrayelemContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(BasicParser.IDENT, 0); }
		public AssignlhsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignlhs; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitAssignlhs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignlhsContext assignlhs() throws RecognitionException {
		AssignlhsContext _localctx = new AssignlhsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_assignlhs);
		try {
			setState(122);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(119); match(IDENT);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(120); arrayelem();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(121); pairelem();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignrhsContext extends ParserRuleContext {
		public AssignrhsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignrhs; }
	 
		public AssignrhsContext() { }
		public void copyFrom(AssignrhsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ArrayLiter_assignrhsContext extends AssignrhsContext {
		public ArrayliterContext arrayliter() {
			return getRuleContext(ArrayliterContext.class,0);
		}
		public ArrayLiter_assignrhsContext(AssignrhsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitArrayLiter_assignrhs(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PairElem_assignrhsContext extends AssignrhsContext {
		public PairelemContext pairelem() {
			return getRuleContext(PairelemContext.class,0);
		}
		public PairElem_assignrhsContext(AssignrhsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitPairElem_assignrhs(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Exp_assignrhsContext extends AssignrhsContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Exp_assignrhsContext(AssignrhsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitExp_assignrhs(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NewPair_assignrhsContext extends AssignrhsContext {
		public TerminalNode NEWPAIR() { return getToken(BasicParser.NEWPAIR, 0); }
		public TerminalNode CLOSE_PARENTHESES() { return getToken(BasicParser.CLOSE_PARENTHESES, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(BasicParser.COMMA, 0); }
		public TerminalNode OPEN_PARENTHESES() { return getToken(BasicParser.OPEN_PARENTHESES, 0); }
		public NewPair_assignrhsContext(AssignrhsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitNewPair_assignrhs(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Call_assignrhsContext extends AssignrhsContext {
		public TerminalNode CLOSE_PARENTHESES() { return getToken(BasicParser.CLOSE_PARENTHESES, 0); }
		public TerminalNode CALL() { return getToken(BasicParser.CALL, 0); }
		public ArglistContext arglist() {
			return getRuleContext(ArglistContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(BasicParser.IDENT, 0); }
		public TerminalNode OPEN_PARENTHESES() { return getToken(BasicParser.OPEN_PARENTHESES, 0); }
		public Call_assignrhsContext(AssignrhsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitCall_assignrhs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignrhsContext assignrhs() throws RecognitionException {
		AssignrhsContext _localctx = new AssignrhsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_assignrhs);
		int _la;
		try {
			setState(141);
			switch (_input.LA(1)) {
			case MINUS:
			case NOT:
			case LEN:
			case ORD:
			case CHR:
			case OPEN_PARENTHESES:
			case TRUE:
			case FALSE:
			case INT_LITER:
			case CHAR_LITER:
			case STR_LITER:
			case IDENT:
			case PAIR_LITER:
				_localctx = new Exp_assignrhsContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(124); expr(0);
				}
				break;
			case OPEN_SQUAREB:
				_localctx = new ArrayLiter_assignrhsContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(125); arrayliter();
				}
				break;
			case NEWPAIR:
				_localctx = new NewPair_assignrhsContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(126); match(NEWPAIR);
				setState(127); match(OPEN_PARENTHESES);
				setState(128); expr(0);
				setState(129); match(COMMA);
				setState(130); expr(0);
				setState(131); match(CLOSE_PARENTHESES);
				}
				break;
			case FST:
			case SND:
				_localctx = new PairElem_assignrhsContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(133); pairelem();
				}
				break;
			case CALL:
				_localctx = new Call_assignrhsContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(134); match(CALL);
				setState(135); match(IDENT);
				setState(136); match(OPEN_PARENTHESES);
				setState(138);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << NOT) | (1L << LEN) | (1L << ORD) | (1L << CHR) | (1L << OPEN_PARENTHESES) | (1L << TRUE) | (1L << FALSE) | (1L << INT_LITER) | (1L << CHAR_LITER) | (1L << STR_LITER) | (1L << IDENT) | (1L << PAIR_LITER))) != 0)) {
					{
					setState(137); arglist();
					}
				}

				setState(140); match(CLOSE_PARENTHESES);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArglistContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(BasicParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(BasicParser.COMMA, i);
		}
		public ArglistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arglist; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitArglist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArglistContext arglist() throws RecognitionException {
		ArglistContext _localctx = new ArglistContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_arglist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143); expr(0);
			setState(148);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(144); match(COMMA);
				setState(145); expr(0);
				}
				}
				setState(150);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PairelemContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SND() { return getToken(BasicParser.SND, 0); }
		public TerminalNode FST() { return getToken(BasicParser.FST, 0); }
		public PairelemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pairelem; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitPairelem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PairelemContext pairelem() throws RecognitionException {
		PairelemContext _localctx = new PairelemContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_pairelem);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			_la = _input.LA(1);
			if ( !(_la==FST || _la==SND) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(152); expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BasetypeContext extends ParserRuleContext {
		public BasetypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_basetype; }
	 
		public BasetypeContext() { }
		public void copyFrom(BasetypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Char_baseTypeContext extends BasetypeContext {
		public TerminalNode CHAR() { return getToken(BasicParser.CHAR, 0); }
		public Char_baseTypeContext(BasetypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitChar_baseType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Int_baseTypeContext extends BasetypeContext {
		public TerminalNode INT() { return getToken(BasicParser.INT, 0); }
		public Int_baseTypeContext(BasetypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitInt_baseType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class String_baseTypeContext extends BasetypeContext {
		public TerminalNode STRING() { return getToken(BasicParser.STRING, 0); }
		public String_baseTypeContext(BasetypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitString_baseType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Bool_baseTypeContext extends BasetypeContext {
		public TerminalNode BOOL() { return getToken(BasicParser.BOOL, 0); }
		public Bool_baseTypeContext(BasetypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitBool_baseType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BasetypeContext basetype() throws RecognitionException {
		BasetypeContext _localctx = new BasetypeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_basetype);
		try {
			setState(158);
			switch (_input.LA(1)) {
			case INT:
				_localctx = new Int_baseTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(154); match(INT);
				}
				break;
			case BOOL:
				_localctx = new Bool_baseTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(155); match(BOOL);
				}
				break;
			case CHAR:
				_localctx = new Char_baseTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(156); match(CHAR);
				}
				break;
			case STRING:
				_localctx = new String_baseTypeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(157); match(STRING);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	 
		public TypeContext() { }
		public void copyFrom(TypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ArrayType_typeContext extends TypeContext {
		public ArraytypeContext arraytype() {
			return getRuleContext(ArraytypeContext.class,0);
		}
		public ArrayType_typeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitArrayType_type(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BaseType_typeContext extends TypeContext {
		public BasetypeContext basetype() {
			return getRuleContext(BasetypeContext.class,0);
		}
		public BaseType_typeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitBaseType_type(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PairType_typeContext extends TypeContext {
		public PairtypeContext pairtype() {
			return getRuleContext(PairtypeContext.class,0);
		}
		public PairType_typeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitPairType_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_type);
		try {
			setState(163);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				_localctx = new BaseType_typeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(160); basetype();
				}
				break;
			case 2:
				_localctx = new ArrayType_typeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(161); arraytype(0);
				}
				break;
			case 3:
				_localctx = new PairType_typeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(162); pairtype();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArraytypeContext extends ParserRuleContext {
		public TerminalNode OPEN_SQUAREB() { return getToken(BasicParser.OPEN_SQUAREB, 0); }
		public ArraytypeContext arraytype() {
			return getRuleContext(ArraytypeContext.class,0);
		}
		public PairtypeContext pairtype() {
			return getRuleContext(PairtypeContext.class,0);
		}
		public BasetypeContext basetype() {
			return getRuleContext(BasetypeContext.class,0);
		}
		public TerminalNode CLOSE_SQUAREB() { return getToken(BasicParser.CLOSE_SQUAREB, 0); }
		public ArraytypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arraytype; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitArraytype(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArraytypeContext arraytype() throws RecognitionException {
		return arraytype(0);
	}

	private ArraytypeContext arraytype(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ArraytypeContext _localctx = new ArraytypeContext(_ctx, _parentState);
		ArraytypeContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_arraytype, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			switch (_input.LA(1)) {
			case INT:
			case CHAR:
			case STRING:
			case BOOL:
				{
				setState(166); basetype();
				setState(167); match(OPEN_SQUAREB);
				setState(168); match(CLOSE_SQUAREB);
				}
				break;
			case PAIR:
				{
				setState(170); pairtype();
				setState(171); match(OPEN_SQUAREB);
				setState(172); match(CLOSE_SQUAREB);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(181);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ArraytypeContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_arraytype);
					setState(176);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(177); match(OPEN_SQUAREB);
					setState(178); match(CLOSE_SQUAREB);
					}
					} 
				}
				setState(183);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class PairtypeContext extends ParserRuleContext {
		public TerminalNode CLOSE_PARENTHESES() { return getToken(BasicParser.CLOSE_PARENTHESES, 0); }
		public List<PairelemtypeContext> pairelemtype() {
			return getRuleContexts(PairelemtypeContext.class);
		}
		public PairelemtypeContext pairelemtype(int i) {
			return getRuleContext(PairelemtypeContext.class,i);
		}
		public TerminalNode PAIR() { return getToken(BasicParser.PAIR, 0); }
		public TerminalNode COMMA() { return getToken(BasicParser.COMMA, 0); }
		public TerminalNode OPEN_PARENTHESES() { return getToken(BasicParser.OPEN_PARENTHESES, 0); }
		public PairtypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pairtype; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitPairtype(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PairtypeContext pairtype() throws RecognitionException {
		PairtypeContext _localctx = new PairtypeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_pairtype);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184); match(PAIR);
			setState(185); match(OPEN_PARENTHESES);
			setState(186); pairelemtype();
			setState(187); match(COMMA);
			setState(188); pairelemtype();
			setState(189); match(CLOSE_PARENTHESES);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PairelemtypeContext extends ParserRuleContext {
		public ArraytypeContext arraytype() {
			return getRuleContext(ArraytypeContext.class,0);
		}
		public BasetypeContext basetype() {
			return getRuleContext(BasetypeContext.class,0);
		}
		public TerminalNode PAIR() { return getToken(BasicParser.PAIR, 0); }
		public PairelemtypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pairelemtype; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitPairelemtype(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PairelemtypeContext pairelemtype() throws RecognitionException {
		PairelemtypeContext _localctx = new PairelemtypeContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_pairelemtype);
		try {
			setState(194);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(191); basetype();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(192); match(PAIR);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(193); arraytype(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BoolLiter_ExprContext extends ExprContext {
		public Bool_LiterContext bool_Liter() {
			return getRuleContext(Bool_LiterContext.class,0);
		}
		public BoolLiter_ExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitBoolLiter_Expr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StrLiter_ExprContext extends ExprContext {
		public TerminalNode STR_LITER() { return getToken(BasicParser.STR_LITER, 0); }
		public StrLiter_ExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitStrLiter_Expr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayElem_ExprContext extends ExprContext {
		public ArrayelemContext arrayelem() {
			return getRuleContext(ArrayelemContext.class,0);
		}
		public ArrayElem_ExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitArrayElem_Expr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Term_ExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Term_ExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitTerm_Expr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnaryOper_ExprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public UnaryoperContext unaryoper() {
			return getRuleContext(UnaryoperContext.class,0);
		}
		public UnaryOper_ExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitUnaryOper_Expr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Ident_ExprContext extends ExprContext {
		public TerminalNode IDENT() { return getToken(BasicParser.IDENT, 0); }
		public Ident_ExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitIdent_Expr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PairLiter_ExprContext extends ExprContext {
		public TerminalNode PAIR_LITER() { return getToken(BasicParser.PAIR_LITER, 0); }
		public PairLiter_ExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitPairLiter_Expr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Parenth_ExprContext extends ExprContext {
		public TerminalNode CLOSE_PARENTHESES() { return getToken(BasicParser.CLOSE_PARENTHESES, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode OPEN_PARENTHESES() { return getToken(BasicParser.OPEN_PARENTHESES, 0); }
		public Parenth_ExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitParenth_Expr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntLiter_ExprContext extends ExprContext {
		public TerminalNode INT_LITER() { return getToken(BasicParser.INT_LITER, 0); }
		public IntLiter_ExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitIntLiter_Expr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CharLiter_ExprContext extends ExprContext {
		public TerminalNode CHAR_LITER() { return getToken(BasicParser.CHAR_LITER, 0); }
		public CharLiter_ExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitCharLiter_Expr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Factor_ExprContext extends ExprContext {
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Factor_ExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitFactor_Expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				_localctx = new UnaryOper_ExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(197); unaryoper();
				setState(198); expr(11);
				}
				break;
			case 2:
				{
				_localctx = new Parenth_ExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(200); match(OPEN_PARENTHESES);
				setState(201); expr(0);
				setState(202); match(CLOSE_PARENTHESES);
				}
				break;
			case 3:
				{
				_localctx = new IntLiter_ExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(204); match(INT_LITER);
				}
				break;
			case 4:
				{
				_localctx = new BoolLiter_ExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(205); bool_Liter();
				}
				break;
			case 5:
				{
				_localctx = new CharLiter_ExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(206); match(CHAR_LITER);
				}
				break;
			case 6:
				{
				_localctx = new StrLiter_ExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(207); match(STR_LITER);
				}
				break;
			case 7:
				{
				_localctx = new PairLiter_ExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(208); match(PAIR_LITER);
				}
				break;
			case 8:
				{
				_localctx = new Ident_ExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(209); match(IDENT);
				}
				break;
			case 9:
				{
				_localctx = new ArrayElem_ExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(210); arrayelem();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(223);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(221);
					switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
					case 1:
						{
						_localctx = new Factor_ExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(213);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(214); factor();
						setState(215); expr(10);
						}
						break;
					case 2:
						{
						_localctx = new Term_ExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(217);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(218); term();
						setState(219); expr(9);
						}
						break;
					}
					} 
				}
				setState(225);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class UnaryoperContext extends ParserRuleContext {
		public TerminalNode NOT() { return getToken(BasicParser.NOT, 0); }
		public TerminalNode ORD() { return getToken(BasicParser.ORD, 0); }
		public TerminalNode LEN() { return getToken(BasicParser.LEN, 0); }
		public TerminalNode MINUS() { return getToken(BasicParser.MINUS, 0); }
		public TerminalNode CHR() { return getToken(BasicParser.CHR, 0); }
		public UnaryoperContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryoper; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitUnaryoper(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryoperContext unaryoper() throws RecognitionException {
		UnaryoperContext _localctx = new UnaryoperContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_unaryoper);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(226);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << NOT) | (1L << LEN) | (1L << ORD) | (1L << CHR))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FactorContext extends ParserRuleContext {
		public TerminalNode MOD() { return getToken(BasicParser.MOD, 0); }
		public TerminalNode DIV() { return getToken(BasicParser.DIV, 0); }
		public TerminalNode MUL() { return getToken(BasicParser.MUL, 0); }
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitFactor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_factor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DIV) | (1L << MUL) | (1L << MOD))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Bool_LiterContext extends ParserRuleContext {
		public TerminalNode FALSE() { return getToken(BasicParser.FALSE, 0); }
		public TerminalNode TRUE() { return getToken(BasicParser.TRUE, 0); }
		public Bool_LiterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool_Liter; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitBool_Liter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bool_LiterContext bool_Liter() throws RecognitionException {
		Bool_LiterContext _localctx = new Bool_LiterContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_bool_Liter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230);
			_la = _input.LA(1);
			if ( !(_la==TRUE || _la==FALSE) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TermContext extends ParserRuleContext {
		public TerminalNode EQEQ() { return getToken(BasicParser.EQEQ, 0); }
		public TerminalNode SMTEQ() { return getToken(BasicParser.SMTEQ, 0); }
		public TerminalNode SMT() { return getToken(BasicParser.SMT, 0); }
		public TerminalNode AND() { return getToken(BasicParser.AND, 0); }
		public TerminalNode PLUS() { return getToken(BasicParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(BasicParser.MINUS, 0); }
		public TerminalNode GRT() { return getToken(BasicParser.GRT, 0); }
		public TerminalNode GRTEQ() { return getToken(BasicParser.GRTEQ, 0); }
		public TerminalNode OR() { return getToken(BasicParser.OR, 0); }
		public TerminalNode NOTEQ() { return getToken(BasicParser.NOTEQ, 0); }
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(232);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << MINUS) | (1L << GRT) | (1L << GRTEQ) | (1L << SMT) | (1L << SMTEQ) | (1L << EQEQ) | (1L << NOTEQ) | (1L << AND) | (1L << OR))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayelemContext extends ParserRuleContext {
		public TerminalNode OPEN_SQUAREB() { return getToken(BasicParser.OPEN_SQUAREB, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode CLOSE_SQUAREB() { return getToken(BasicParser.CLOSE_SQUAREB, 0); }
		public TerminalNode IDENT() { return getToken(BasicParser.IDENT, 0); }
		public ArrayelemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayelem; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitArrayelem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayelemContext arrayelem() throws RecognitionException {
		ArrayelemContext _localctx = new ArrayelemContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_arrayelem);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234); match(IDENT);
			setState(235); match(OPEN_SQUAREB);
			setState(236); expr(0);
			setState(237); match(CLOSE_SQUAREB);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayliterContext extends ParserRuleContext {
		public TerminalNode OPEN_SQUAREB() { return getToken(BasicParser.OPEN_SQUAREB, 0); }
		public TerminalNode CLOSE_SQUAREB() { return getToken(BasicParser.CLOSE_SQUAREB, 0); }
		public ArglistContext arglist() {
			return getRuleContext(ArglistContext.class,0);
		}
		public ArrayliterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayliter; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitArrayliter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayliterContext arrayliter() throws RecognitionException {
		ArrayliterContext _localctx = new ArrayliterContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_arrayliter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239); match(OPEN_SQUAREB);
			setState(241);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << NOT) | (1L << LEN) | (1L << ORD) | (1L << CHR) | (1L << OPEN_PARENTHESES) | (1L << TRUE) | (1L << FALSE) | (1L << INT_LITER) | (1L << CHAR_LITER) | (1L << STR_LITER) | (1L << IDENT) | (1L << PAIR_LITER))) != 0)) {
				{
				setState(240); arglist();
				}
			}

			setState(243); match(CLOSE_SQUAREB);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProgContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public TerminalNode EOF() { return getToken(BasicParser.EOF, 0); }
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(248);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << NOT) | (1L << LEN) | (1L << ORD) | (1L << CHR) | (1L << OPEN_PARENTHESES) | (1L << TRUE) | (1L << FALSE) | (1L << INT_LITER) | (1L << CHAR_LITER) | (1L << STR_LITER) | (1L << IDENT) | (1L << PAIR_LITER))) != 0)) {
				{
				{
				setState(245); expr(0);
				}
				}
				setState(250);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(251); match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 4: return stat_sempred((StatContext)_localctx, predIndex);
		case 11: return arraytype_sempred((ArraytypeContext)_localctx, predIndex);
		case 14: return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean stat_sempred(StatContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean arraytype_sempred(ArraytypeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1: return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2: return precpred(_ctx, 9);
		case 3: return precpred(_ctx, 8);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3?\u0100\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\7\2\61\n\2"+
		"\f\2\16\2\64\13\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\5\3=\n\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\4\3\4\3\4\7\4G\n\4\f\4\16\4J\13\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6p\n\6\3\6\3\6\3\6\7\6"+
		"u\n\6\f\6\16\6x\13\6\3\7\3\7\3\7\5\7}\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u008d\n\b\3\b\5\b\u0090\n\b\3\t\3\t\3"+
		"\t\7\t\u0095\n\t\f\t\16\t\u0098\13\t\3\n\3\n\3\n\3\13\3\13\3\13\3\13\5"+
		"\13\u00a1\n\13\3\f\3\f\3\f\5\f\u00a6\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\5\r\u00b1\n\r\3\r\3\r\3\r\7\r\u00b6\n\r\f\r\16\r\u00b9\13\r\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\5\17\u00c5\n\17\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20"+
		"\u00d6\n\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\7\20\u00e0\n\20\f"+
		"\20\16\20\u00e3\13\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25"+
		"\3\25\3\25\3\25\3\26\3\26\5\26\u00f4\n\26\3\26\3\26\3\27\7\27\u00f9\n"+
		"\27\f\27\16\27\u00fc\13\27\3\27\3\27\3\27\2\5\n\30\36\30\2\4\6\b\n\f\16"+
		"\20\22\24\26\30\32\34\36 \"$&(*,\2\b\3\2\"&\3\2\61\62\4\2\7\7\20\23\3"+
		"\2\3\5\3\2\678\3\2\6\17\u0111\2.\3\2\2\2\48\3\2\2\2\6C\3\2\2\2\bK\3\2"+
		"\2\2\no\3\2\2\2\f|\3\2\2\2\16\u008f\3\2\2\2\20\u0091\3\2\2\2\22\u0099"+
		"\3\2\2\2\24\u00a0\3\2\2\2\26\u00a5\3\2\2\2\30\u00b0\3\2\2\2\32\u00ba\3"+
		"\2\2\2\34\u00c4\3\2\2\2\36\u00d5\3\2\2\2 \u00e4\3\2\2\2\"\u00e6\3\2\2"+
		"\2$\u00e8\3\2\2\2&\u00ea\3\2\2\2(\u00ec\3\2\2\2*\u00f1\3\2\2\2,\u00fa"+
		"\3\2\2\2.\62\7\35\2\2/\61\5\4\3\2\60/\3\2\2\2\61\64\3\2\2\2\62\60\3\2"+
		"\2\2\62\63\3\2\2\2\63\65\3\2\2\2\64\62\3\2\2\2\65\66\5\n\6\2\66\67\7\36"+
		"\2\2\67\3\3\2\2\289\5\26\f\29:\7>\2\2:<\7\31\2\2;=\5\6\4\2<;\3\2\2\2<"+
		"=\3\2\2\2=>\3\2\2\2>?\7\32\2\2?@\7!\2\2@A\5\n\6\2AB\7\36\2\2B\5\3\2\2"+
		"\2CH\5\b\5\2DE\7.\2\2EG\5\b\5\2FD\3\2\2\2GJ\3\2\2\2HF\3\2\2\2HI\3\2\2"+
		"\2I\7\3\2\2\2JH\3\2\2\2KL\5\26\f\2LM\7>\2\2M\t\3\2\2\2NO\b\6\1\2Op\7\37"+
		"\2\2PQ\5\26\f\2QR\7>\2\2RS\7\30\2\2ST\5\16\b\2Tp\3\2\2\2UV\5\f\7\2VW\7"+
		"\30\2\2WX\5\16\b\2Xp\3\2\2\2YZ\7 \2\2Zp\5\f\7\2[\\\t\2\2\2\\p\5\36\20"+
		"\2]^\7\'\2\2^_\5\36\20\2_`\7(\2\2`a\5\n\6\2ab\7)\2\2bc\5\n\6\2cd\7*\2"+
		"\2dp\3\2\2\2ef\7\64\2\2fg\5\36\20\2gh\7+\2\2hi\5\n\6\2ij\7,\2\2jp\3\2"+
		"\2\2kl\7\35\2\2lm\5\n\6\2mn\7\36\2\2np\3\2\2\2oN\3\2\2\2oP\3\2\2\2oU\3"+
		"\2\2\2oY\3\2\2\2o[\3\2\2\2o]\3\2\2\2oe\3\2\2\2ok\3\2\2\2pv\3\2\2\2qr\f"+
		"\3\2\2rs\7-\2\2su\5\n\6\4tq\3\2\2\2ux\3\2\2\2vt\3\2\2\2vw\3\2\2\2w\13"+
		"\3\2\2\2xv\3\2\2\2y}\7>\2\2z}\5(\25\2{}\5\22\n\2|y\3\2\2\2|z\3\2\2\2|"+
		"{\3\2\2\2}\r\3\2\2\2~\u0090\5\36\20\2\177\u0090\5*\26\2\u0080\u0081\7"+
		"/\2\2\u0081\u0082\7\31\2\2\u0082\u0083\5\36\20\2\u0083\u0084\7.\2\2\u0084"+
		"\u0085\5\36\20\2\u0085\u0086\7\32\2\2\u0086\u0090\3\2\2\2\u0087\u0090"+
		"\5\22\n\2\u0088\u0089\7\60\2\2\u0089\u008a\7>\2\2\u008a\u008c\7\31\2\2"+
		"\u008b\u008d\5\20\t\2\u008c\u008b\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008e"+
		"\3\2\2\2\u008e\u0090\7\32\2\2\u008f~\3\2\2\2\u008f\177\3\2\2\2\u008f\u0080"+
		"\3\2\2\2\u008f\u0087\3\2\2\2\u008f\u0088\3\2\2\2\u0090\17\3\2\2\2\u0091"+
		"\u0096\5\36\20\2\u0092\u0093\7.\2\2\u0093\u0095\5\36\20\2\u0094\u0092"+
		"\3\2\2\2\u0095\u0098\3\2\2\2\u0096\u0094\3\2\2\2\u0096\u0097\3\2\2\2\u0097"+
		"\21\3\2\2\2\u0098\u0096\3\2\2\2\u0099\u009a\t\3\2\2\u009a\u009b\5\36\20"+
		"\2\u009b\23\3\2\2\2\u009c\u00a1\7\25\2\2\u009d\u00a1\7\66\2\2\u009e\u00a1"+
		"\7\26\2\2\u009f\u00a1\7\27\2\2\u00a0\u009c\3\2\2\2\u00a0\u009d\3\2\2\2"+
		"\u00a0\u009e\3\2\2\2\u00a0\u009f\3\2\2\2\u00a1\25\3\2\2\2\u00a2\u00a6"+
		"\5\24\13\2\u00a3\u00a6\5\30\r\2\u00a4\u00a6\5\32\16\2\u00a5\u00a2\3\2"+
		"\2\2\u00a5\u00a3\3\2\2\2\u00a5\u00a4\3\2\2\2\u00a6\27\3\2\2\2\u00a7\u00a8"+
		"\b\r\1\2\u00a8\u00a9\5\24\13\2\u00a9\u00aa\7\33\2\2\u00aa\u00ab\7\34\2"+
		"\2\u00ab\u00b1\3\2\2\2\u00ac\u00ad\5\32\16\2\u00ad\u00ae\7\33\2\2\u00ae"+
		"\u00af\7\34\2\2\u00af\u00b1\3\2\2\2\u00b0\u00a7\3\2\2\2\u00b0\u00ac\3"+
		"\2\2\2\u00b1\u00b7\3\2\2\2\u00b2\u00b3\f\4\2\2\u00b3\u00b4\7\33\2\2\u00b4"+
		"\u00b6\7\34\2\2\u00b5\u00b2\3\2\2\2\u00b6\u00b9\3\2\2\2\u00b7\u00b5\3"+
		"\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\31\3\2\2\2\u00b9\u00b7\3\2\2\2\u00ba"+
		"\u00bb\7\63\2\2\u00bb\u00bc\7\31\2\2\u00bc\u00bd\5\34\17\2\u00bd\u00be"+
		"\7.\2\2\u00be\u00bf\5\34\17\2\u00bf\u00c0\7\32\2\2\u00c0\33\3\2\2\2\u00c1"+
		"\u00c5\5\24\13\2\u00c2\u00c5\7\63\2\2\u00c3\u00c5\5\30\r\2\u00c4\u00c1"+
		"\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c4\u00c3\3\2\2\2\u00c5\35\3\2\2\2\u00c6"+
		"\u00c7\b\20\1\2\u00c7\u00c8\5 \21\2\u00c8\u00c9\5\36\20\r\u00c9\u00d6"+
		"\3\2\2\2\u00ca\u00cb\7\31\2\2\u00cb\u00cc\5\36\20\2\u00cc\u00cd\7\32\2"+
		"\2\u00cd\u00d6\3\2\2\2\u00ce\u00d6\7:\2\2\u00cf\u00d6\5$\23\2\u00d0\u00d6"+
		"\7<\2\2\u00d1\u00d6\7=\2\2\u00d2\u00d6\7?\2\2\u00d3\u00d6\7>\2\2\u00d4"+
		"\u00d6\5(\25\2\u00d5\u00c6\3\2\2\2\u00d5\u00ca\3\2\2\2\u00d5\u00ce\3\2"+
		"\2\2\u00d5\u00cf\3\2\2\2\u00d5\u00d0\3\2\2\2\u00d5\u00d1\3\2\2\2\u00d5"+
		"\u00d2\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d5\u00d4\3\2\2\2\u00d6\u00e1\3\2"+
		"\2\2\u00d7\u00d8\f\13\2\2\u00d8\u00d9\5\"\22\2\u00d9\u00da\5\36\20\f\u00da"+
		"\u00e0\3\2\2\2\u00db\u00dc\f\n\2\2\u00dc\u00dd\5&\24\2\u00dd\u00de\5\36"+
		"\20\13\u00de\u00e0\3\2\2\2\u00df\u00d7\3\2\2\2\u00df\u00db\3\2\2\2\u00e0"+
		"\u00e3\3\2\2\2\u00e1\u00df\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\37\3\2\2"+
		"\2\u00e3\u00e1\3\2\2\2\u00e4\u00e5\t\4\2\2\u00e5!\3\2\2\2\u00e6\u00e7"+
		"\t\5\2\2\u00e7#\3\2\2\2\u00e8\u00e9\t\6\2\2\u00e9%\3\2\2\2\u00ea\u00eb"+
		"\t\7\2\2\u00eb\'\3\2\2\2\u00ec\u00ed\7>\2\2\u00ed\u00ee\7\33\2\2\u00ee"+
		"\u00ef\5\36\20\2\u00ef\u00f0\7\34\2\2\u00f0)\3\2\2\2\u00f1\u00f3\7\33"+
		"\2\2\u00f2\u00f4\5\20\t\2\u00f3\u00f2\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4"+
		"\u00f5\3\2\2\2\u00f5\u00f6\7\34\2\2\u00f6+\3\2\2\2\u00f7\u00f9\5\36\20"+
		"\2\u00f8\u00f7\3\2\2\2\u00f9\u00fc\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fa\u00fb"+
		"\3\2\2\2\u00fb\u00fd\3\2\2\2\u00fc\u00fa\3\2\2\2\u00fd\u00fe\7\2\2\3\u00fe"+
		"-\3\2\2\2\25\62<Hov|\u008c\u008f\u0096\u00a0\u00a5\u00b0\u00b7\u00c4\u00d5"+
		"\u00df\u00e1\u00f3\u00fa";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}