package lambdaCalculus.grammar.deBruijnLambda;// Generated from DeBruijn by ANTLR 4.5.3

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DeBruijnParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LAMBDA=1, DOT=2, SPACE=3, LEFT_PAREN=4, RIGHT_PAREN=5, NUM=6, WS=7, NEWLINE=8;
	public static final int
		RULE_lambdaTerm = 0, RULE_expr = 1, RULE_num = 2, RULE_abst = 3, RULE_func = 4, 
		RULE_arg = 5;
	public static final String[] ruleNames = {
		"lambdaTerm", "expr", "num", "abst", "func", "arg"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'\\'", "'.'", "' '", "'('", "')'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "LAMBDA", "DOT", "SPACE", "LEFT_PAREN", "RIGHT_PAREN", "NUM", "WS", 
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
	public String getGrammarFileName() { return "DeBruijn"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public DeBruijnParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class LambdaTermContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(DeBruijnParser.NEWLINE, 0); }
		public TerminalNode EOF() { return getToken(DeBruijnParser.EOF, 0); }
		public LambdaTermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambdaTerm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DeBruijnListener) ((DeBruijnListener)listener).enterLambdaTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DeBruijnListener) ((DeBruijnListener)listener).exitLambdaTerm(this);
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
			expr(0);
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
		public NumContext num() {
			return getRuleContext(NumContext.class,0);
		}
		public AbstContext abst() {
			return getRuleContext(AbstContext.class,0);
		}
		public FuncContext func() {
			return getRuleContext(FuncContext.class,0);
		}
		public ArgContext arg() {
			return getRuleContext(ArgContext.class,0);
		}
		public List<TerminalNode> SPACE() { return getTokens(DeBruijnParser.SPACE); }
		public TerminalNode SPACE(int i) {
			return getToken(DeBruijnParser.SPACE, i);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<TerminalNode> LEFT_PAREN() { return getTokens(DeBruijnParser.LEFT_PAREN); }
		public TerminalNode LEFT_PAREN(int i) {
			return getToken(DeBruijnParser.LEFT_PAREN, i);
		}
		public List<TerminalNode> RIGHT_PAREN() { return getTokens(DeBruijnParser.RIGHT_PAREN); }
		public TerminalNode RIGHT_PAREN(int i) {
			return getToken(DeBruijnParser.RIGHT_PAREN, i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DeBruijnListener) ((DeBruijnListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DeBruijnListener) ((DeBruijnListener)listener).exitExpr(this);
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
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(16);
				num();
				}
				break;
			case 2:
				{
				setState(17);
				abst();
				}
				break;
			case 3:
				{
				setState(18);
				func(0);
				setState(20); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(19);
					match(SPACE);
					}
					}
					setState(22); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==SPACE );
				setState(24);
				arg();
				}
				break;
			case 4:
				{
				setState(27); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(26);
						match(LEFT_PAREN);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(29); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
				} while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER );
				setState(31);
				expr(0);
				setState(33);
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(32);
						match(RIGHT_PAREN);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(35);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
				} while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER );
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(48);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expr);
					setState(39);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(41);
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(40);
						match(SPACE);
						}
						}
						setState(43);
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==SPACE );
					setState(45);
					arg();
					}
					}
				}
				setState(50);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
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

	public static class NumContext extends ParserRuleContext {
		public TerminalNode NUM() { return getToken(DeBruijnParser.NUM, 0); }
		public NumContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_num; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DeBruijnListener) ((DeBruijnListener)listener).enterNum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DeBruijnListener) ((DeBruijnListener)listener).exitNum(this);
		}
	}

	public final NumContext num() throws RecognitionException {
		NumContext _localctx = new NumContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_num);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			match(NUM);
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

	public static class AbstContext extends ParserRuleContext {
		public TerminalNode LAMBDA() { return getToken(DeBruijnParser.LAMBDA, 0); }
		public TerminalNode DOT() { return getToken(DeBruijnParser.DOT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AbstContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_abst; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DeBruijnListener) ((DeBruijnListener)listener).enterAbst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DeBruijnListener) ((DeBruijnListener)listener).exitAbst(this);
		}
	}

	public final AbstContext abst() throws RecognitionException {
		AbstContext _localctx = new AbstContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_abst);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			match(LAMBDA);
			setState(54);
			match(DOT);
			setState(55);
			expr(0);
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
		public NumContext num() {
			return getRuleContext(NumContext.class,0);
		}
		public AbstContext abst() {
			return getRuleContext(AbstContext.class,0);
		}
		public List<TerminalNode> LEFT_PAREN() { return getTokens(DeBruijnParser.LEFT_PAREN); }
		public TerminalNode LEFT_PAREN(int i) {
			return getToken(DeBruijnParser.LEFT_PAREN, i);
		}
		public List<TerminalNode> RIGHT_PAREN() { return getTokens(DeBruijnParser.RIGHT_PAREN); }
		public TerminalNode RIGHT_PAREN(int i) {
			return getToken(DeBruijnParser.RIGHT_PAREN, i);
		}
		public FuncContext func() {
			return getRuleContext(FuncContext.class,0);
		}
		public ArgContext arg() {
			return getRuleContext(ArgContext.class,0);
		}
		public List<TerminalNode> SPACE() { return getTokens(DeBruijnParser.SPACE); }
		public TerminalNode SPACE(int i) {
			return getToken(DeBruijnParser.SPACE, i);
		}
		public FuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DeBruijnListener) ((DeBruijnListener)listener).enterFunc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DeBruijnListener) ((DeBruijnListener)listener).exitFunc(this);
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
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			switch (_input.LA(1)) {
			case NUM:
				{
				setState(58);
				num();
				}
				break;
			case LEFT_PAREN:
				{
				setState(60);
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(59);
					match(LEFT_PAREN);
					}
					}
					setState(62);
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==LEFT_PAREN );
				setState(64);
				abst();
				setState(66);
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(65);
						match(RIGHT_PAREN);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(68);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
				} while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER );
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(81);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new FuncContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_func);
					setState(72);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(74);
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(73);
						match(SPACE);
						}
						}
						setState(76);
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==SPACE );
					setState(78);
					arg();
					}
					}
				}
				setState(83);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
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
		public NumContext num() {
			return getRuleContext(NumContext.class,0);
		}
		public List<TerminalNode> LEFT_PAREN() { return getTokens(DeBruijnParser.LEFT_PAREN); }
		public TerminalNode LEFT_PAREN(int i) {
			return getToken(DeBruijnParser.LEFT_PAREN, i);
		}
		public AbstContext abst() {
			return getRuleContext(AbstContext.class,0);
		}
		public List<TerminalNode> RIGHT_PAREN() { return getTokens(DeBruijnParser.RIGHT_PAREN); }
		public TerminalNode RIGHT_PAREN(int i) {
			return getToken(DeBruijnParser.RIGHT_PAREN, i);
		}
		public FuncContext func() {
			return getRuleContext(FuncContext.class,0);
		}
		public ArgContext arg() {
			return getRuleContext(ArgContext.class,0);
		}
		public List<TerminalNode> SPACE() { return getTokens(DeBruijnParser.SPACE); }
		public TerminalNode SPACE(int i) {
			return getToken(DeBruijnParser.SPACE, i);
		}
		public ArgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DeBruijnListener) ((DeBruijnListener)listener).enterArg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DeBruijnListener) ((DeBruijnListener)listener).exitArg(this);
		}
	}

	public final ArgContext arg() throws RecognitionException {
		ArgContext _localctx = new ArgContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_arg);
		int _la;
		try {
			int _alt;
			setState(106);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(84);
				num();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(85);
				match(LEFT_PAREN);
				setState(86);
				abst();
				setState(87);
				match(RIGHT_PAREN);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(90);
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(89);
						match(LEFT_PAREN);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(92);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
				} while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER );
				setState(94);
				func(0);
				setState(96);
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(95);
					match(SPACE);
					}
					}
					setState(98);
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==SPACE );
				setState(100);
				arg();
				setState(102);
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(101);
						match(RIGHT_PAREN);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(104);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
				} while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER );
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
		case 1:
			return expr_sempred((ExprContext)_localctx, predIndex);
		case 4:
			return func_sempred((FuncContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean func_sempred(FuncContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\no\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\6\3"+
		"\27\n\3\r\3\16\3\30\3\3\3\3\3\3\6\3\36\n\3\r\3\16\3\37\3\3\3\3\6\3$\n"+
		"\3\r\3\16\3%\5\3(\n\3\3\3\3\3\6\3,\n\3\r\3\16\3-\3\3\7\3\61\n\3\f\3\16"+
		"\3\64\13\3\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\6\6?\n\6\r\6\16\6@\3\6"+
		"\3\6\6\6E\n\6\r\6\16\6F\5\6I\n\6\3\6\3\6\6\6M\n\6\r\6\16\6N\3\6\7\6R\n"+
		"\6\f\6\16\6U\13\6\3\7\3\7\3\7\3\7\3\7\3\7\6\7]\n\7\r\7\16\7^\3\7\3\7\6"+
		"\7c\n\7\r\7\16\7d\3\7\3\7\6\7i\n\7\r\7\16\7j\5\7m\n\7\3\7\2\4\4\n\b\2"+
		"\4\6\b\n\f\2\3\3\3\n\nz\2\16\3\2\2\2\4\'\3\2\2\2\6\65\3\2\2\2\b\67\3\2"+
		"\2\2\nH\3\2\2\2\fl\3\2\2\2\16\17\5\4\3\2\17\20\t\2\2\2\20\3\3\2\2\2\21"+
		"\22\b\3\1\2\22(\5\6\4\2\23(\5\b\5\2\24\26\5\n\6\2\25\27\7\5\2\2\26\25"+
		"\3\2\2\2\27\30\3\2\2\2\30\26\3\2\2\2\30\31\3\2\2\2\31\32\3\2\2\2\32\33"+
		"\5\f\7\2\33(\3\2\2\2\34\36\7\6\2\2\35\34\3\2\2\2\36\37\3\2\2\2\37\35\3"+
		"\2\2\2\37 \3\2\2\2 !\3\2\2\2!#\5\4\3\2\"$\7\7\2\2#\"\3\2\2\2$%\3\2\2\2"+
		"%#\3\2\2\2%&\3\2\2\2&(\3\2\2\2\'\21\3\2\2\2\'\23\3\2\2\2\'\24\3\2\2\2"+
		"\'\35\3\2\2\2(\62\3\2\2\2)+\f\4\2\2*,\7\5\2\2+*\3\2\2\2,-\3\2\2\2-+\3"+
		"\2\2\2-.\3\2\2\2./\3\2\2\2/\61\5\f\7\2\60)\3\2\2\2\61\64\3\2\2\2\62\60"+
		"\3\2\2\2\62\63\3\2\2\2\63\5\3\2\2\2\64\62\3\2\2\2\65\66\7\b\2\2\66\7\3"+
		"\2\2\2\678\7\3\2\289\7\4\2\29:\5\4\3\2:\t\3\2\2\2;<\b\6\1\2<I\5\6\4\2"+
		"=?\7\6\2\2>=\3\2\2\2?@\3\2\2\2@>\3\2\2\2@A\3\2\2\2AB\3\2\2\2BD\5\b\5\2"+
		"CE\7\7\2\2DC\3\2\2\2EF\3\2\2\2FD\3\2\2\2FG\3\2\2\2GI\3\2\2\2H;\3\2\2\2"+
		"H>\3\2\2\2IS\3\2\2\2JL\f\3\2\2KM\7\5\2\2LK\3\2\2\2MN\3\2\2\2NL\3\2\2\2"+
		"NO\3\2\2\2OP\3\2\2\2PR\5\f\7\2QJ\3\2\2\2RU\3\2\2\2SQ\3\2\2\2ST\3\2\2\2"+
		"T\13\3\2\2\2US\3\2\2\2Vm\5\6\4\2WX\7\6\2\2XY\5\b\5\2YZ\7\7\2\2Zm\3\2\2"+
		"\2[]\7\6\2\2\\[\3\2\2\2]^\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_`\3\2\2\2`b\5\n"+
		"\6\2ac\7\5\2\2ba\3\2\2\2cd\3\2\2\2db\3\2\2\2de\3\2\2\2ef\3\2\2\2fh\5\f"+
		"\7\2gi\7\7\2\2hg\3\2\2\2ij\3\2\2\2jh\3\2\2\2jk\3\2\2\2km\3\2\2\2lV\3\2"+
		"\2\2lW\3\2\2\2l\\\3\2\2\2m\r\3\2\2\2\21\30\37%\'-\62@FHNS^djl";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}