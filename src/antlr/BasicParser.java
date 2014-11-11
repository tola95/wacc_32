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
		WHILE=50, FST=47, MOD=3, CHAR=20, DO=41, NOT=14, AND=12, OPEN_SQUAREB=25, 
		ORD=16, IF=37, FREE=32, CLOSE_PARENTHESES=24, SMTEQ=9, THEN=38, COMMA=44, 
		IS=31, DONE=42, PRINTLN=36, BEGIN=27, RETURN=33, CHAR_LITER=58, IDENT=60, 
		PLUS=4, PAIR=49, STR_LITER=59, EQ=22, COMMENT=51, GRT=6, NEWPAIR=45, SMT=8, 
		EQEQ=10, INTEGER=57, EXIT=34, SND=48, ELSE=39, BOOL=52, PAIR_LITER=61, 
		INT=19, SEMICOLON=43, CLOSE_SQUAREB=26, MINUS=5, TRUE=53, MUL=2, PRINT=35, 
		CHR=17, FI=40, SKIP=29, GRTEQ=7, NOTEQ=11, WS=18, NEWLINE=55, READ=30, 
		OR=13, INT_LITER=56, OPEN_PARENTHESES=23, LEN=15, CALL=46, DIV=1, END=28, 
		FALSE=54, STRING=21;
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
		public TerminalNode EOF() { return getToken(BasicParser.EOF, 0); }
		public List<FuncContext> func() {
			return getRuleContexts(FuncContext.class);
		}
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public FuncContext func(int i) {
			return getRuleContext(FuncContext.class,i);
		}
		public TerminalNode BEGIN() { return getToken(BasicParser.BEGIN, 0); }
		public TerminalNode END() { return getToken(BasicParser.END, 0); }
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
			setState(53); match(EOF);
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
		public ParamlistContext paramlist() {
			return getRuleContext(ParamlistContext.class,0);
		}
		public TerminalNode CLOSE_PARENTHESES() { return getToken(BasicParser.CLOSE_PARENTHESES, 0); }
		public TerminalNode OPEN_PARENTHESES() { return getToken(BasicParser.OPEN_PARENTHESES, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public TerminalNode IS() { return getToken(BasicParser.IS, 0); }
		public TerminalNode IDENT() { return getToken(BasicParser.IDENT, 0); }
		public TerminalNode END() { return getToken(BasicParser.END, 0); }
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
			setState(55); type();
			setState(56); match(IDENT);
			setState(57); match(OPEN_PARENTHESES);
			setState(59);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << CHAR) | (1L << STRING) | (1L << PAIR) | (1L << BOOL))) != 0)) {
				{
				setState(58); paramlist();
				}
			}

			setState(61); match(CLOSE_PARENTHESES);
			setState(62); match(IS);
			setState(63); stat(0);
			setState(64); match(END);
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
			setState(66); param();
			setState(71);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(67); match(COMMA);
				setState(68); param();
				}
				}
				setState(73);
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
			setState(74); type();
			setState(75); match(IDENT);
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
	public static class IdentEq_StatContext extends StatContext {
		public AssignrhsContext assignrhs() {
			return getRuleContext(AssignrhsContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(BasicParser.IDENT, 0); }
		public TerminalNode EQ() { return getToken(BasicParser.EQ, 0); }
		public IdentEq_StatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitIdentEq_Stat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Read_StatContext extends StatContext {
		public TerminalNode READ() { return getToken(BasicParser.READ, 0); }
		public AssignlhsContext assignlhs() {
			return getRuleContext(AssignlhsContext.class,0);
		}
		public Read_StatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitRead_Stat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class While_StatContext extends StatContext {
		public TerminalNode WHILE() { return getToken(BasicParser.WHILE, 0); }
		public TerminalNode DO() { return getToken(BasicParser.DO, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode DONE() { return getToken(BasicParser.DONE, 0); }
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public While_StatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitWhile_Stat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Print_StatContext extends StatContext {
		public TerminalNode PRINT() { return getToken(BasicParser.PRINT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Print_StatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitPrint_Stat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Println_StatContext extends StatContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode PRINTLN() { return getToken(BasicParser.PRINTLN, 0); }
		public Println_StatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitPrintln_Stat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Return_StatContext extends StatContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RETURN() { return getToken(BasicParser.RETURN, 0); }
		public Return_StatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitReturn_Stat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Free_StatContext extends StatContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode FREE() { return getToken(BasicParser.FREE, 0); }
		public Free_StatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitFree_Stat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Begin_StatContext extends StatContext {
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public TerminalNode BEGIN() { return getToken(BasicParser.BEGIN, 0); }
		public TerminalNode END() { return getToken(BasicParser.END, 0); }
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
	public static class AssignLhsRhs_StatContext extends StatContext {
		public AssignrhsContext assignrhs() {
			return getRuleContext(AssignrhsContext.class,0);
		}
		public AssignlhsContext assignlhs() {
			return getRuleContext(AssignlhsContext.class,0);
		}
		public TerminalNode EQ() { return getToken(BasicParser.EQ, 0); }
		public AssignLhsRhs_StatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitAssignLhsRhs_Stat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Exit_StatContext extends StatContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode EXIT() { return getToken(BasicParser.EXIT, 0); }
		public Exit_StatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitExit_Stat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class If_StatContext extends StatContext {
		public TerminalNode THEN() { return getToken(BasicParser.THEN, 0); }
		public TerminalNode IF() { return getToken(BasicParser.IF, 0); }
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public TerminalNode FI() { return getToken(BasicParser.FI, 0); }
		public TerminalNode ELSE() { return getToken(BasicParser.ELSE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
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
	public static class Skip_StatContext extends StatContext {
		public TerminalNode SKIP() { return getToken(BasicParser.SKIP, 0); }
		public Skip_StatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitSkip_Stat(this);
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
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			switch (_input.LA(1)) {
			case SKIP:
				{
				_localctx = new Skip_StatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(78); match(SKIP);
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
				setState(79); type();
				setState(80); match(IDENT);
				setState(81); match(EQ);
				setState(82); assignrhs();
				}
				break;
			case FST:
			case SND:
			case IDENT:
				{
				_localctx = new AssignLhsRhs_StatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(84); assignlhs();
				setState(85); match(EQ);
				setState(86); assignrhs();
				}
				break;
			case READ:
				{
				_localctx = new Read_StatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(88); match(READ);
				setState(89); assignlhs();
				}
				break;
			case FREE:
				{
				_localctx = new Free_StatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(90); match(FREE);
				setState(91); expr(0);
				}
				break;
			case RETURN:
				{
				_localctx = new Return_StatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(92); match(RETURN);
				setState(93); expr(0);
				}
				break;
			case EXIT:
				{
				_localctx = new Exit_StatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(94); match(EXIT);
				setState(95); expr(0);
				}
				break;
			case PRINT:
				{
				_localctx = new Print_StatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(96); match(PRINT);
				setState(97); expr(0);
				}
				break;
			case PRINTLN:
				{
				_localctx = new Println_StatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(98); match(PRINTLN);
				setState(99); expr(0);
				}
				break;
			case IF:
				{
				_localctx = new If_StatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(100); match(IF);
				setState(101); expr(0);
				setState(102); match(THEN);
				setState(103); stat(0);
				setState(104); match(ELSE);
				setState(105); stat(0);
				setState(106); match(FI);
				}
				break;
			case WHILE:
				{
				_localctx = new While_StatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(108); match(WHILE);
				setState(109); expr(0);
				setState(110); match(DO);
				setState(111); stat(0);
				setState(112); match(DONE);
				}
				break;
			case BEGIN:
				{
				_localctx = new Begin_StatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(114); match(BEGIN);
				setState(115); stat(0);
				setState(116); match(END);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(125);
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
					setState(120);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(121); match(SEMICOLON);
					setState(122); stat(2);
					}
					} 
				}
				setState(127);
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
			setState(131);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(128); match(IDENT);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(129); arrayelem();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(130); pairelem();
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
	public static class Call_assignrhsContext extends AssignrhsContext {
		public TerminalNode CALL() { return getToken(BasicParser.CALL, 0); }
		public TerminalNode CLOSE_PARENTHESES() { return getToken(BasicParser.CLOSE_PARENTHESES, 0); }
		public TerminalNode OPEN_PARENTHESES() { return getToken(BasicParser.OPEN_PARENTHESES, 0); }
		public TerminalNode IDENT() { return getToken(BasicParser.IDENT, 0); }
		public ArglistContext arglist() {
			return getRuleContext(ArglistContext.class,0);
		}
		public Call_assignrhsContext(AssignrhsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitCall_assignrhs(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NewPair_assignrhsContext extends AssignrhsContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public TerminalNode CLOSE_PARENTHESES() { return getToken(BasicParser.CLOSE_PARENTHESES, 0); }
		public TerminalNode COMMA() { return getToken(BasicParser.COMMA, 0); }
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OPEN_PARENTHESES() { return getToken(BasicParser.OPEN_PARENTHESES, 0); }
		public TerminalNode NEWPAIR() { return getToken(BasicParser.NEWPAIR, 0); }
		public NewPair_assignrhsContext(AssignrhsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitNewPair_assignrhs(this);
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

	public final AssignrhsContext assignrhs() throws RecognitionException {
		AssignrhsContext _localctx = new AssignrhsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_assignrhs);
		int _la;
		try {
			setState(150);
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
				setState(133); expr(0);
				}
				break;
			case OPEN_SQUAREB:
				_localctx = new ArrayLiter_assignrhsContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(134); arrayliter();
				}
				break;
			case NEWPAIR:
				_localctx = new NewPair_assignrhsContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(135); match(NEWPAIR);
				setState(136); match(OPEN_PARENTHESES);
				setState(137); expr(0);
				setState(138); match(COMMA);
				setState(139); expr(0);
				setState(140); match(CLOSE_PARENTHESES);
				}
				break;
			case FST:
			case SND:
				_localctx = new PairElem_assignrhsContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(142); pairelem();
				}
				break;
			case CALL:
				_localctx = new Call_assignrhsContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(143); match(CALL);
				setState(144); match(IDENT);
				setState(145); match(OPEN_PARENTHESES);
				setState(147);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << NOT) | (1L << LEN) | (1L << ORD) | (1L << CHR) | (1L << OPEN_PARENTHESES) | (1L << TRUE) | (1L << FALSE) | (1L << INT_LITER) | (1L << CHAR_LITER) | (1L << STR_LITER) | (1L << IDENT) | (1L << PAIR_LITER))) != 0)) {
					{
					setState(146); arglist();
					}
				}

				setState(149); match(CLOSE_PARENTHESES);
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
		public List<TerminalNode> COMMA() { return getTokens(BasicParser.COMMA); }
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
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
			setState(152); expr(0);
			setState(157);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(153); match(COMMA);
				setState(154); expr(0);
				}
				}
				setState(159);
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
		public TerminalNode FST() { return getToken(BasicParser.FST, 0); }
		public TerminalNode SND() { return getToken(BasicParser.SND, 0); }
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
			setState(160);
			_la = _input.LA(1);
			if ( !(_la==FST || _la==SND) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(161); expr(0);
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
	public static class Char_baseTypeContext extends BasetypeContext {
		public TerminalNode CHAR() { return getToken(BasicParser.CHAR, 0); }
		public Char_baseTypeContext(BasetypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitChar_baseType(this);
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
			setState(167);
			switch (_input.LA(1)) {
			case INT:
				_localctx = new Int_baseTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(163); match(INT);
				}
				break;
			case BOOL:
				_localctx = new Bool_baseTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(164); match(BOOL);
				}
				break;
			case CHAR:
				_localctx = new Char_baseTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(165); match(CHAR);
				}
				break;
			case STRING:
				_localctx = new String_baseTypeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(166); match(STRING);
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
			setState(172);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				_localctx = new BaseType_typeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(169); basetype();
				}
				break;
			case 2:
				_localctx = new ArrayType_typeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(170); arraytype(0);
				}
				break;
			case 3:
				_localctx = new PairType_typeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(171); pairtype();
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
		public ArraytypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arraytype; }
	 
		public ArraytypeContext() { }
		public void copyFrom(ArraytypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BaseType_arrayTypeContext extends ArraytypeContext {
		public BasetypeContext basetype() {
			return getRuleContext(BasetypeContext.class,0);
		}
		public TerminalNode CLOSE_SQUAREB() { return getToken(BasicParser.CLOSE_SQUAREB, 0); }
		public TerminalNode OPEN_SQUAREB() { return getToken(BasicParser.OPEN_SQUAREB, 0); }
		public BaseType_arrayTypeContext(ArraytypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitBaseType_arrayType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PairType_arrayTypeContext extends ArraytypeContext {
		public TerminalNode CLOSE_SQUAREB() { return getToken(BasicParser.CLOSE_SQUAREB, 0); }
		public PairtypeContext pairtype() {
			return getRuleContext(PairtypeContext.class,0);
		}
		public TerminalNode OPEN_SQUAREB() { return getToken(BasicParser.OPEN_SQUAREB, 0); }
		public PairType_arrayTypeContext(ArraytypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitPairType_arrayType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayType_arrayTypeContext extends ArraytypeContext {
		public ArraytypeContext arraytype() {
			return getRuleContext(ArraytypeContext.class,0);
		}
		public TerminalNode CLOSE_SQUAREB() { return getToken(BasicParser.CLOSE_SQUAREB, 0); }
		public TerminalNode OPEN_SQUAREB() { return getToken(BasicParser.OPEN_SQUAREB, 0); }
		public ArrayType_arrayTypeContext(ArraytypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitArrayType_arrayType(this);
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
			setState(183);
			switch (_input.LA(1)) {
			case INT:
			case CHAR:
			case STRING:
			case BOOL:
				{
				_localctx = new BaseType_arrayTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(175); basetype();
				setState(176); match(OPEN_SQUAREB);
				setState(177); match(CLOSE_SQUAREB);
				}
				break;
			case PAIR:
				{
				_localctx = new PairType_arrayTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(179); pairtype();
				setState(180); match(OPEN_SQUAREB);
				setState(181); match(CLOSE_SQUAREB);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(190);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ArrayType_arrayTypeContext(new ArraytypeContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_arraytype);
					setState(185);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(186); match(OPEN_SQUAREB);
					setState(187); match(CLOSE_SQUAREB);
					}
					} 
				}
				setState(192);
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
		public List<PairelemtypeContext> pairelemtype() {
			return getRuleContexts(PairelemtypeContext.class);
		}
		public TerminalNode CLOSE_PARENTHESES() { return getToken(BasicParser.CLOSE_PARENTHESES, 0); }
		public TerminalNode COMMA() { return getToken(BasicParser.COMMA, 0); }
		public TerminalNode OPEN_PARENTHESES() { return getToken(BasicParser.OPEN_PARENTHESES, 0); }
		public TerminalNode PAIR() { return getToken(BasicParser.PAIR, 0); }
		public PairelemtypeContext pairelemtype(int i) {
			return getRuleContext(PairelemtypeContext.class,i);
		}
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
			setState(193); match(PAIR);
			setState(194); match(OPEN_PARENTHESES);
			setState(195); pairelemtype();
			setState(196); match(COMMA);
			setState(197); pairelemtype();
			setState(198); match(CLOSE_PARENTHESES);
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
		public PairelemtypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pairelemtype; }
	 
		public PairelemtypeContext() { }
		public void copyFrom(PairelemtypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Pair_pairElemTypeContext extends PairelemtypeContext {
		public TerminalNode PAIR() { return getToken(BasicParser.PAIR, 0); }
		public Pair_pairElemTypeContext(PairelemtypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitPair_pairElemType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayType_pairElemTypeContext extends PairelemtypeContext {
		public ArraytypeContext arraytype() {
			return getRuleContext(ArraytypeContext.class,0);
		}
		public ArrayType_pairElemTypeContext(PairelemtypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitArrayType_pairElemType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BaseType_pairElemTypeContext extends PairelemtypeContext {
		public BasetypeContext basetype() {
			return getRuleContext(BasetypeContext.class,0);
		}
		public BaseType_pairElemTypeContext(PairelemtypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitBaseType_pairElemType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PairelemtypeContext pairelemtype() throws RecognitionException {
		PairelemtypeContext _localctx = new PairelemtypeContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_pairelemtype);
		try {
			setState(203);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				_localctx = new BaseType_pairElemTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(200); basetype();
				}
				break;
			case 2:
				_localctx = new Pair_pairElemTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(201); match(PAIR);
				}
				break;
			case 3:
				_localctx = new ArrayType_pairElemTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(202); arraytype(0);
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
	public static class Factor_ExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public Factor_ExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitFactor_Expr(this);
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
	public static class IntLiter_ExprContext extends ExprContext {
		public TerminalNode INT_LITER() { return getToken(BasicParser.INT_LITER, 0); }
		public IntLiter_ExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitIntLiter_Expr(this);
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
	public static class Parenth_ExprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode CLOSE_PARENTHESES() { return getToken(BasicParser.CLOSE_PARENTHESES, 0); }
		public TerminalNode OPEN_PARENTHESES() { return getToken(BasicParser.OPEN_PARENTHESES, 0); }
		public Parenth_ExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitParenth_Expr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Term_ExprContext extends ExprContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
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
	public static class PairLiter_ExprContext extends ExprContext {
		public TerminalNode PAIR_LITER() { return getToken(BasicParser.PAIR_LITER, 0); }
		public PairLiter_ExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitPairLiter_Expr(this);
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
	public static class CharLiter_ExprContext extends ExprContext {
		public TerminalNode CHAR_LITER() { return getToken(BasicParser.CHAR_LITER, 0); }
		public CharLiter_ExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BasicParserVisitor ) return ((BasicParserVisitor<? extends T>)visitor).visitCharLiter_Expr(this);
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
			setState(220);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				_localctx = new UnaryOper_ExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(206); unaryoper();
				setState(207); expr(11);
				}
				break;
			case 2:
				{
				_localctx = new Parenth_ExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(209); match(OPEN_PARENTHESES);
				setState(210); expr(0);
				setState(211); match(CLOSE_PARENTHESES);
				}
				break;
			case 3:
				{
				_localctx = new IntLiter_ExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(213); match(INT_LITER);
				}
				break;
			case 4:
				{
				_localctx = new BoolLiter_ExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(214); bool_Liter();
				}
				break;
			case 5:
				{
				_localctx = new CharLiter_ExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(215); match(CHAR_LITER);
				}
				break;
			case 6:
				{
				_localctx = new StrLiter_ExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(216); match(STR_LITER);
				}
				break;
			case 7:
				{
				_localctx = new PairLiter_ExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(217); match(PAIR_LITER);
				}
				break;
			case 8:
				{
				_localctx = new Ident_ExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(218); match(IDENT);
				}
				break;
			case 9:
				{
				_localctx = new ArrayElem_ExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(219); arrayelem();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(232);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(230);
					switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
					case 1:
						{
						_localctx = new Factor_ExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(222);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(223); factor();
						setState(224); expr(10);
						}
						break;
					case 2:
						{
						_localctx = new Term_ExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(226);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(227); term();
						setState(228); expr(9);
						}
						break;
					}
					} 
				}
				setState(234);
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
		public TerminalNode LEN() { return getToken(BasicParser.LEN, 0); }
		public TerminalNode MINUS() { return getToken(BasicParser.MINUS, 0); }
		public TerminalNode NOT() { return getToken(BasicParser.NOT, 0); }
		public TerminalNode CHR() { return getToken(BasicParser.CHR, 0); }
		public TerminalNode ORD() { return getToken(BasicParser.ORD, 0); }
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
			setState(235);
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
		public TerminalNode MUL() { return getToken(BasicParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(BasicParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(BasicParser.MOD, 0); }
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
			setState(237);
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
		public TerminalNode TRUE() { return getToken(BasicParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(BasicParser.FALSE, 0); }
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
			setState(239);
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
		public TerminalNode GRTEQ() { return getToken(BasicParser.GRTEQ, 0); }
		public TerminalNode SMT() { return getToken(BasicParser.SMT, 0); }
		public TerminalNode EQEQ() { return getToken(BasicParser.EQEQ, 0); }
		public TerminalNode AND() { return getToken(BasicParser.AND, 0); }
		public TerminalNode OR() { return getToken(BasicParser.OR, 0); }
		public TerminalNode MINUS() { return getToken(BasicParser.MINUS, 0); }
		public TerminalNode SMTEQ() { return getToken(BasicParser.SMTEQ, 0); }
		public TerminalNode GRT() { return getToken(BasicParser.GRT, 0); }
		public TerminalNode PLUS() { return getToken(BasicParser.PLUS, 0); }
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
			setState(241);
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
		public TerminalNode CLOSE_SQUAREB() { return getToken(BasicParser.CLOSE_SQUAREB, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(BasicParser.IDENT, 0); }
		public TerminalNode OPEN_SQUAREB() { return getToken(BasicParser.OPEN_SQUAREB, 0); }
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
			setState(243); match(IDENT);
			setState(244); match(OPEN_SQUAREB);
			setState(245); expr(0);
			setState(246); match(CLOSE_SQUAREB);
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
		public TerminalNode CLOSE_SQUAREB() { return getToken(BasicParser.CLOSE_SQUAREB, 0); }
		public TerminalNode OPEN_SQUAREB() { return getToken(BasicParser.OPEN_SQUAREB, 0); }
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
			setState(248); match(OPEN_SQUAREB);
			setState(250);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << NOT) | (1L << LEN) | (1L << ORD) | (1L << CHR) | (1L << OPEN_PARENTHESES) | (1L << TRUE) | (1L << FALSE) | (1L << INT_LITER) | (1L << CHAR_LITER) | (1L << STR_LITER) | (1L << IDENT) | (1L << PAIR_LITER))) != 0)) {
				{
				setState(249); arglist();
				}
			}

			setState(252); match(CLOSE_SQUAREB);
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
		public TerminalNode EOF() { return getToken(BasicParser.EOF, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
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
			setState(257);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << NOT) | (1L << LEN) | (1L << ORD) | (1L << CHR) | (1L << OPEN_PARENTHESES) | (1L << TRUE) | (1L << FALSE) | (1L << INT_LITER) | (1L << CHAR_LITER) | (1L << STR_LITER) | (1L << IDENT) | (1L << PAIR_LITER))) != 0)) {
				{
				{
				setState(254); expr(0);
				}
				}
				setState(259);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(260); match(EOF);
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
	private boolean stat_sempred(StatContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3?\u0109\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\7\2\61\n\2"+
		"\f\2\16\2\64\13\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\5\3>\n\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\4\3\4\3\4\7\4H\n\4\f\4\16\4K\13\4\3\5\3\5\3\5\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\5\6y\n\6\3\6\3\6\3\6\7\6~\n\6\f\6\16\6\u0081\13\6\3\7\3\7\3"+
		"\7\5\7\u0086\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\5\b\u0096\n\b\3\b\5\b\u0099\n\b\3\t\3\t\3\t\7\t\u009e\n\t\f\t\16\t"+
		"\u00a1\13\t\3\n\3\n\3\n\3\13\3\13\3\13\3\13\5\13\u00aa\n\13\3\f\3\f\3"+
		"\f\5\f\u00af\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00ba\n\r\3\r"+
		"\3\r\3\r\7\r\u00bf\n\r\f\r\16\r\u00c2\13\r\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\17\3\17\3\17\5\17\u00ce\n\17\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00df\n\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\7\20\u00e9\n\20\f\20\16\20\u00ec\13\20"+
		"\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\26"+
		"\3\26\5\26\u00fd\n\26\3\26\3\26\3\27\7\27\u0102\n\27\f\27\16\27\u0105"+
		"\13\27\3\27\3\27\3\27\2\5\n\30\36\30\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\36 \"$&(*,\2\7\3\2\61\62\4\2\7\7\20\23\3\2\3\5\3\2\678\3\2\6\17\u011e"+
		"\2.\3\2\2\2\49\3\2\2\2\6D\3\2\2\2\bL\3\2\2\2\nx\3\2\2\2\f\u0085\3\2\2"+
		"\2\16\u0098\3\2\2\2\20\u009a\3\2\2\2\22\u00a2\3\2\2\2\24\u00a9\3\2\2\2"+
		"\26\u00ae\3\2\2\2\30\u00b9\3\2\2\2\32\u00c3\3\2\2\2\34\u00cd\3\2\2\2\36"+
		"\u00de\3\2\2\2 \u00ed\3\2\2\2\"\u00ef\3\2\2\2$\u00f1\3\2\2\2&\u00f3\3"+
		"\2\2\2(\u00f5\3\2\2\2*\u00fa\3\2\2\2,\u0103\3\2\2\2.\62\7\35\2\2/\61\5"+
		"\4\3\2\60/\3\2\2\2\61\64\3\2\2\2\62\60\3\2\2\2\62\63\3\2\2\2\63\65\3\2"+
		"\2\2\64\62\3\2\2\2\65\66\5\n\6\2\66\67\7\36\2\2\678\7\2\2\38\3\3\2\2\2"+
		"9:\5\26\f\2:;\7>\2\2;=\7\31\2\2<>\5\6\4\2=<\3\2\2\2=>\3\2\2\2>?\3\2\2"+
		"\2?@\7\32\2\2@A\7!\2\2AB\5\n\6\2BC\7\36\2\2C\5\3\2\2\2DI\5\b\5\2EF\7."+
		"\2\2FH\5\b\5\2GE\3\2\2\2HK\3\2\2\2IG\3\2\2\2IJ\3\2\2\2J\7\3\2\2\2KI\3"+
		"\2\2\2LM\5\26\f\2MN\7>\2\2N\t\3\2\2\2OP\b\6\1\2Py\7\37\2\2QR\5\26\f\2"+
		"RS\7>\2\2ST\7\30\2\2TU\5\16\b\2Uy\3\2\2\2VW\5\f\7\2WX\7\30\2\2XY\5\16"+
		"\b\2Yy\3\2\2\2Z[\7 \2\2[y\5\f\7\2\\]\7\"\2\2]y\5\36\20\2^_\7#\2\2_y\5"+
		"\36\20\2`a\7$\2\2ay\5\36\20\2bc\7%\2\2cy\5\36\20\2de\7&\2\2ey\5\36\20"+
		"\2fg\7\'\2\2gh\5\36\20\2hi\7(\2\2ij\5\n\6\2jk\7)\2\2kl\5\n\6\2lm\7*\2"+
		"\2my\3\2\2\2no\7\64\2\2op\5\36\20\2pq\7+\2\2qr\5\n\6\2rs\7,\2\2sy\3\2"+
		"\2\2tu\7\35\2\2uv\5\n\6\2vw\7\36\2\2wy\3\2\2\2xO\3\2\2\2xQ\3\2\2\2xV\3"+
		"\2\2\2xZ\3\2\2\2x\\\3\2\2\2x^\3\2\2\2x`\3\2\2\2xb\3\2\2\2xd\3\2\2\2xf"+
		"\3\2\2\2xn\3\2\2\2xt\3\2\2\2y\177\3\2\2\2z{\f\3\2\2{|\7-\2\2|~\5\n\6\4"+
		"}z\3\2\2\2~\u0081\3\2\2\2\177}\3\2\2\2\177\u0080\3\2\2\2\u0080\13\3\2"+
		"\2\2\u0081\177\3\2\2\2\u0082\u0086\7>\2\2\u0083\u0086\5(\25\2\u0084\u0086"+
		"\5\22\n\2\u0085\u0082\3\2\2\2\u0085\u0083\3\2\2\2\u0085\u0084\3\2\2\2"+
		"\u0086\r\3\2\2\2\u0087\u0099\5\36\20\2\u0088\u0099\5*\26\2\u0089\u008a"+
		"\7/\2\2\u008a\u008b\7\31\2\2\u008b\u008c\5\36\20\2\u008c\u008d\7.\2\2"+
		"\u008d\u008e\5\36\20\2\u008e\u008f\7\32\2\2\u008f\u0099\3\2\2\2\u0090"+
		"\u0099\5\22\n\2\u0091\u0092\7\60\2\2\u0092\u0093\7>\2\2\u0093\u0095\7"+
		"\31\2\2\u0094\u0096\5\20\t\2\u0095\u0094\3\2\2\2\u0095\u0096\3\2\2\2\u0096"+
		"\u0097\3\2\2\2\u0097\u0099\7\32\2\2\u0098\u0087\3\2\2\2\u0098\u0088\3"+
		"\2\2\2\u0098\u0089\3\2\2\2\u0098\u0090\3\2\2\2\u0098\u0091\3\2\2\2\u0099"+
		"\17\3\2\2\2\u009a\u009f\5\36\20\2\u009b\u009c\7.\2\2\u009c\u009e\5\36"+
		"\20\2\u009d\u009b\3\2\2\2\u009e\u00a1\3\2\2\2\u009f\u009d\3\2\2\2\u009f"+
		"\u00a0\3\2\2\2\u00a0\21\3\2\2\2\u00a1\u009f\3\2\2\2\u00a2\u00a3\t\2\2"+
		"\2\u00a3\u00a4\5\36\20\2\u00a4\23\3\2\2\2\u00a5\u00aa\7\25\2\2\u00a6\u00aa"+
		"\7\66\2\2\u00a7\u00aa\7\26\2\2\u00a8\u00aa\7\27\2\2\u00a9\u00a5\3\2\2"+
		"\2\u00a9\u00a6\3\2\2\2\u00a9\u00a7\3\2\2\2\u00a9\u00a8\3\2\2\2\u00aa\25"+
		"\3\2\2\2\u00ab\u00af\5\24\13\2\u00ac\u00af\5\30\r\2\u00ad\u00af\5\32\16"+
		"\2\u00ae\u00ab\3\2\2\2\u00ae\u00ac\3\2\2\2\u00ae\u00ad\3\2\2\2\u00af\27"+
		"\3\2\2\2\u00b0\u00b1\b\r\1\2\u00b1\u00b2\5\24\13\2\u00b2\u00b3\7\33\2"+
		"\2\u00b3\u00b4\7\34\2\2\u00b4\u00ba\3\2\2\2\u00b5\u00b6\5\32\16\2\u00b6"+
		"\u00b7\7\33\2\2\u00b7\u00b8\7\34\2\2\u00b8\u00ba\3\2\2\2\u00b9\u00b0\3"+
		"\2\2\2\u00b9\u00b5\3\2\2\2\u00ba\u00c0\3\2\2\2\u00bb\u00bc\f\4\2\2\u00bc"+
		"\u00bd\7\33\2\2\u00bd\u00bf\7\34\2\2\u00be\u00bb\3\2\2\2\u00bf\u00c2\3"+
		"\2\2\2\u00c0\u00be\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\31\3\2\2\2\u00c2"+
		"\u00c0\3\2\2\2\u00c3\u00c4\7\63\2\2\u00c4\u00c5\7\31\2\2\u00c5\u00c6\5"+
		"\34\17\2\u00c6\u00c7\7.\2\2\u00c7\u00c8\5\34\17\2\u00c8\u00c9\7\32\2\2"+
		"\u00c9\33\3\2\2\2\u00ca\u00ce\5\24\13\2\u00cb\u00ce\7\63\2\2\u00cc\u00ce"+
		"\5\30\r\2\u00cd\u00ca\3\2\2\2\u00cd\u00cb\3\2\2\2\u00cd\u00cc\3\2\2\2"+
		"\u00ce\35\3\2\2\2\u00cf\u00d0\b\20\1\2\u00d0\u00d1\5 \21\2\u00d1\u00d2"+
		"\5\36\20\r\u00d2\u00df\3\2\2\2\u00d3\u00d4\7\31\2\2\u00d4\u00d5\5\36\20"+
		"\2\u00d5\u00d6\7\32\2\2\u00d6\u00df\3\2\2\2\u00d7\u00df\7:\2\2\u00d8\u00df"+
		"\5$\23\2\u00d9\u00df\7<\2\2\u00da\u00df\7=\2\2\u00db\u00df\7?\2\2\u00dc"+
		"\u00df\7>\2\2\u00dd\u00df\5(\25\2\u00de\u00cf\3\2\2\2\u00de\u00d3\3\2"+
		"\2\2\u00de\u00d7\3\2\2\2\u00de\u00d8\3\2\2\2\u00de\u00d9\3\2\2\2\u00de"+
		"\u00da\3\2\2\2\u00de\u00db\3\2\2\2\u00de\u00dc\3\2\2\2\u00de\u00dd\3\2"+
		"\2\2\u00df\u00ea\3\2\2\2\u00e0\u00e1\f\13\2\2\u00e1\u00e2\5\"\22\2\u00e2"+
		"\u00e3\5\36\20\f\u00e3\u00e9\3\2\2\2\u00e4\u00e5\f\n\2\2\u00e5\u00e6\5"+
		"&\24\2\u00e6\u00e7\5\36\20\13\u00e7\u00e9\3\2\2\2\u00e8\u00e0\3\2\2\2"+
		"\u00e8\u00e4\3\2\2\2\u00e9\u00ec\3\2\2\2\u00ea\u00e8\3\2\2\2\u00ea\u00eb"+
		"\3\2\2\2\u00eb\37\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ed\u00ee\t\3\2\2\u00ee"+
		"!\3\2\2\2\u00ef\u00f0\t\4\2\2\u00f0#\3\2\2\2\u00f1\u00f2\t\5\2\2\u00f2"+
		"%\3\2\2\2\u00f3\u00f4\t\6\2\2\u00f4\'\3\2\2\2\u00f5\u00f6\7>\2\2\u00f6"+
		"\u00f7\7\33\2\2\u00f7\u00f8\5\36\20\2\u00f8\u00f9\7\34\2\2\u00f9)\3\2"+
		"\2\2\u00fa\u00fc\7\33\2\2\u00fb\u00fd\5\20\t\2\u00fc\u00fb\3\2\2\2\u00fc"+
		"\u00fd\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe\u00ff\7\34\2\2\u00ff+\3\2\2\2"+
		"\u0100\u0102\5\36\20\2\u0101\u0100\3\2\2\2\u0102\u0105\3\2\2\2\u0103\u0101"+
		"\3\2\2\2\u0103\u0104\3\2\2\2\u0104\u0106\3\2\2\2\u0105\u0103\3\2\2\2\u0106"+
		"\u0107\7\2\2\3\u0107-\3\2\2\2\25\62=Ix\177\u0085\u0095\u0098\u009f\u00a9"+
		"\u00ae\u00b9\u00c0\u00cd\u00de\u00e8\u00ea\u00fc\u0103";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}