// Generated from Lambda by ANTLR 4.5.3
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LambdaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LAMBDA=1, DOT=2, SPACE=3, LEFT_PAREN=4, RIGHT_PAREN=5, VAR=6, WS=7, NEWLINE=8;
	public static final int
		RULE_lambdaTerm = 0, RULE_expr = 1, RULE_var = 2, RULE_abs = 3, RULE_func = 4, 
		RULE_arg = 5;
	public static final String[] ruleNames = {
		"lambdaTerm", "expr", "var", "abs", "func", "arg"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'\\'", "'.'", "' '", "'('", "')'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "LAMBDA", "DOT", "SPACE", "LEFT_PAREN", "RIGHT_PAREN", "VAR", "WS", 
		"NEWLINE"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Lambda"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LambdaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class LambdaTermContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(LambdaParser.NEWLINE, 0); }
		public TerminalNode EOF() { return getToken(LambdaParser.EOF, 0); }
		public LambdaTermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambdaTerm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LambdaListener ) ((LambdaListener)listener).enterLambdaTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LambdaListener ) ((LambdaListener)listener).exitLambdaTerm(this);
		}
	}

	public final LambdaTermContext lambdaTerm() throws RecognitionException {
		LambdaTermContext _localctx = new LambdaTermContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_lambdaTerm);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(12);
			expr();
			setState(13);
			_la = _input.LA(1);
			if ( !(_la==EOF || _la==NEWLINE) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
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

	public static class ExprContext extends ParserRuleContext {
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public AbsContext abs() {
			return getRuleContext(AbsContext.class,0);
		}
		public FuncContext func() {
			return getRuleContext(FuncContext.class,0);
		}
		public TerminalNode SPACE() { return getToken(LambdaParser.SPACE, 0); }
		public ArgContext arg() {
			return getRuleContext(ArgContext.class,0);
		}
		public TerminalNode LEFT_PAREN() { return getToken(LambdaParser.LEFT_PAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(LambdaParser.RIGHT_PAREN, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LambdaListener ) ((LambdaListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LambdaListener ) ((LambdaListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_expr);
		try {
			setState(25);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(15);
				var();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(16);
				abs();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(17);
				func(0);
				setState(18);
				match(SPACE);
				setState(19);
				arg();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(21);
				match(LEFT_PAREN);
				setState(22);
				expr();
				setState(23);
				match(RIGHT_PAREN);
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

	public static class VarContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(LambdaParser.VAR, 0); }
		public VarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LambdaListener ) ((LambdaListener)listener).enterVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LambdaListener ) ((LambdaListener)listener).exitVar(this);
		}
	}

	public final VarContext var() throws RecognitionException {
		VarContext _localctx = new VarContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_var);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(27);
			match(VAR);
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

	public static class AbsContext extends ParserRuleContext {
		public TerminalNode LAMBDA() { return getToken(LambdaParser.LAMBDA, 0); }
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public TerminalNode DOT() { return getToken(LambdaParser.DOT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AbsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_abs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LambdaListener ) ((LambdaListener)listener).enterAbs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LambdaListener ) ((LambdaListener)listener).exitAbs(this);
		}
	}

	public final AbsContext abs() throws RecognitionException {
		AbsContext _localctx = new AbsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_abs);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(29);
			match(LAMBDA);
			setState(30);
			var();
			setState(31);
			match(DOT);
			setState(32);
			expr();
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
		public TerminalNode VAR() { return getToken(LambdaParser.VAR, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(LambdaParser.LEFT_PAREN, 0); }
		public AbsContext abs() {
			return getRuleContext(AbsContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(LambdaParser.RIGHT_PAREN, 0); }
		public FuncContext func() {
			return getRuleContext(FuncContext.class,0);
		}
		public TerminalNode SPACE() { return getToken(LambdaParser.SPACE, 0); }
		public ArgContext arg() {
			return getRuleContext(ArgContext.class,0);
		}
		public FuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LambdaListener ) ((LambdaListener)listener).enterFunc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LambdaListener ) ((LambdaListener)listener).exitFunc(this);
		}
	}

	public final FuncContext func() throws RecognitionException {
		return func(0);
	}

	private FuncContext func(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		FuncContext _localctx = new FuncContext(_ctx, _parentState);
		FuncContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_func, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			switch (_input.LA(1)) {
			case VAR:
				{
				setState(35);
				match(VAR);
				}
				break;
			case LEFT_PAREN:
				{
				setState(36);
				match(LEFT_PAREN);
				setState(37);
				abs();
				setState(38);
				match(RIGHT_PAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(47);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new FuncContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_func);
					setState(42);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(43);
					match(SPACE);
					setState(44);
					arg();
					}
					} 
				}
				setState(49);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
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

	public static class ArgContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(LambdaParser.VAR, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(LambdaParser.LEFT_PAREN, 0); }
		public AbsContext abs() {
			return getRuleContext(AbsContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(LambdaParser.RIGHT_PAREN, 0); }
		public FuncContext func() {
			return getRuleContext(FuncContext.class,0);
		}
		public TerminalNode SPACE() { return getToken(LambdaParser.SPACE, 0); }
		public ArgContext arg() {
			return getRuleContext(ArgContext.class,0);
		}
		public ArgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LambdaListener ) ((LambdaListener)listener).enterArg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LambdaListener ) ((LambdaListener)listener).exitArg(this);
		}
	}

	public final ArgContext arg() throws RecognitionException {
		ArgContext _localctx = new ArgContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_arg);
		try {
			setState(61);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(50);
				match(VAR);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(51);
				match(LEFT_PAREN);
				setState(52);
				abs();
				setState(53);
				match(RIGHT_PAREN);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(55);
				match(LEFT_PAREN);
				setState(56);
				func(0);
				setState(57);
				match(SPACE);
				setState(58);
				arg();
				setState(59);
				match(RIGHT_PAREN);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 4:
			return func_sempred((FuncContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean func_sempred(FuncContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\nB\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\5\3\34\n\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\5\6+\n\6\3\6\3\6\3\6\7\6\60\n\6\f\6\16\6\63\13\6\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7@\n\7\3\7\2\3\n\b\2\4\6\b\n\f\2"+
		"\3\3\3\n\nB\2\16\3\2\2\2\4\33\3\2\2\2\6\35\3\2\2\2\b\37\3\2\2\2\n*\3\2"+
		"\2\2\f?\3\2\2\2\16\17\5\4\3\2\17\20\t\2\2\2\20\3\3\2\2\2\21\34\5\6\4\2"+
		"\22\34\5\b\5\2\23\24\5\n\6\2\24\25\7\5\2\2\25\26\5\f\7\2\26\34\3\2\2\2"+
		"\27\30\7\6\2\2\30\31\5\4\3\2\31\32\7\7\2\2\32\34\3\2\2\2\33\21\3\2\2\2"+
		"\33\22\3\2\2\2\33\23\3\2\2\2\33\27\3\2\2\2\34\5\3\2\2\2\35\36\7\b\2\2"+
		"\36\7\3\2\2\2\37 \7\3\2\2 !\5\6\4\2!\"\7\4\2\2\"#\5\4\3\2#\t\3\2\2\2$"+
		"%\b\6\1\2%+\7\b\2\2&\'\7\6\2\2\'(\5\b\5\2()\7\7\2\2)+\3\2\2\2*$\3\2\2"+
		"\2*&\3\2\2\2+\61\3\2\2\2,-\f\3\2\2-.\7\5\2\2.\60\5\f\7\2/,\3\2\2\2\60"+
		"\63\3\2\2\2\61/\3\2\2\2\61\62\3\2\2\2\62\13\3\2\2\2\63\61\3\2\2\2\64@"+
		"\7\b\2\2\65\66\7\6\2\2\66\67\5\b\5\2\678\7\7\2\28@\3\2\2\29:\7\6\2\2:"+
		";\5\n\6\2;<\7\5\2\2<=\5\f\7\2=>\7\7\2\2>@\3\2\2\2?\64\3\2\2\2?\65\3\2"+
		"\2\2?9\3\2\2\2@\r\3\2\2\2\6\33*\61?";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}