// Generated from /Users/mario/IdeaProjects/AdventOfCode/src/Puzzle7.g4 by ANTLR 4.7

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
public class Puzzle7Parser extends Parser {
    public static final int
            T__0 = 1, T__1 = 2, T__2 = 3, T__3 = 4, ID = 5, INT = 6, NEWLINE = 7, WS = 8, ANY = 9;
    public static final int
            RULE_list = 0, RULE_prog = 1, RULE_name = 2, RULE_disc = 3, RULE_weight = 4;
    public static final String[] ruleNames = {
            "list", "prog", "name", "disc", "weight"
    };
    /**
     * @deprecated Use {@link #VOCABULARY} instead.
     */
    @Deprecated
    public static final String[] tokenNames;
    public static final String _serializedATN =
            "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\13(\4\2\t\2\4\3\t" +
                    "\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\2\6\2\20\n\2\r\2\16\2\21\3\3\3\3" +
                    "\3\3\3\3\3\3\5\3\31\n\3\3\4\3\4\3\5\3\5\3\5\5\5 \n\5\6\5\"\n\5\r\5\16" +
                    "\5#\3\6\3\6\3\6\2\2\7\2\4\6\b\n\2\2\2&\2\17\3\2\2\2\4\23\3\2\2\2\6\32" +
                    "\3\2\2\2\b\34\3\2\2\2\n%\3\2\2\2\f\r\5\4\3\2\r\16\7\t\2\2\16\20\3\2\2" +
                    "\2\17\f\3\2\2\2\20\21\3\2\2\2\21\17\3\2\2\2\21\22\3\2\2\2\22\3\3\2\2\2" +
                    "\23\24\5\6\4\2\24\25\7\3\2\2\25\26\5\n\6\2\26\30\7\4\2\2\27\31\5\b\5\2" +
                    "\30\27\3\2\2\2\30\31\3\2\2\2\31\5\3\2\2\2\32\33\7\7\2\2\33\7\3\2\2\2\34" +
                    "!\7\5\2\2\35\37\5\6\4\2\36 \7\6\2\2\37\36\3\2\2\2\37 \3\2\2\2 \"\3\2\2" +
                    "\2!\35\3\2\2\2\"#\3\2\2\2#!\3\2\2\2#$\3\2\2\2$\t\3\2\2\2%&\7\b\2\2&\13" +
                    "\3\2\2\2\6\21\30\37#";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());
    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
            new PredictionContextCache();
    private static final String[] _LITERAL_NAMES = {
            null, "'('", "')'", "'->'", "','"
    };
    private static final String[] _SYMBOLIC_NAMES = {
            null, null, null, null, null, "ID", "INT", "NEWLINE", "WS", "ANY"
    };
    public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

    static {
        RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION);
    }

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

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }

    public Puzzle7Parser(TokenStream input) {
        super(input);
        _interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
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
    public String getGrammarFileName() {
        return "Puzzle7.g4";
    }

    @Override
    public String[] getRuleNames() {
        return ruleNames;
    }

    @Override
    public String getSerializedATN() {
        return _serializedATN;
    }

    @Override
    public ATN getATN() {
        return _ATN;
    }

    public final ListContext list() throws RecognitionException {
        ListContext _localctx = new ListContext(_ctx, getState());
        enterRule(_localctx, 0, RULE_list);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(13);
                _errHandler.sync(this);
                _la = _input.LA(1);
                do {
                    {
                        {
                            setState(10);
                            prog();
                            setState(11);
                            match(NEWLINE);
                        }
                    }
                    setState(15);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                } while (_la == ID);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ProgContext prog() throws RecognitionException {
        ProgContext _localctx = new ProgContext(_ctx, getState());
        enterRule(_localctx, 2, RULE_prog);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(17);
                name();
                setState(18);
                match(T__0);
                setState(19);
                weight();
                setState(20);
                match(T__1);
                setState(22);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T__2) {
                    {
                        setState(21);
                        disc();
                    }
                }

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final NameContext name() throws RecognitionException {
        NameContext _localctx = new NameContext(_ctx, getState());
        enterRule(_localctx, 4, RULE_name);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(24);
                match(ID);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final DiscContext disc() throws RecognitionException {
        DiscContext _localctx = new DiscContext(_ctx, getState());
        enterRule(_localctx, 6, RULE_disc);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(26);
                match(T__2);
                setState(31);
                _errHandler.sync(this);
                _la = _input.LA(1);
                do {
                    {
                        {
                            setState(27);
                            name();
                            setState(29);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                            if (_la == T__3) {
                                {
                                    setState(28);
                                    match(T__3);
                                }
                            }

                        }
                    }
                    setState(33);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                } while (_la == ID);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final WeightContext weight() throws RecognitionException {
        WeightContext _localctx = new WeightContext(_ctx, getState());
        enterRule(_localctx, 8, RULE_weight);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(35);
                match(INT);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ListContext extends ParserRuleContext {
        public ListContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List<ProgContext> prog() {
            return getRuleContexts(ProgContext.class);
        }

        public ProgContext prog(int i) {
            return getRuleContext(ProgContext.class, i);
        }

        public List<TerminalNode> NEWLINE() {
            return getTokens(Puzzle7Parser.NEWLINE);
        }

        public TerminalNode NEWLINE(int i) {
            return getToken(Puzzle7Parser.NEWLINE, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_list;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof Puzzle7Listener) ((Puzzle7Listener) listener).enterList(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof Puzzle7Listener) ((Puzzle7Listener) listener).exitList(this);
        }
    }

    public static class ProgContext extends ParserRuleContext {
        public ProgContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public NameContext name() {
            return getRuleContext(NameContext.class, 0);
        }

        public WeightContext weight() {
            return getRuleContext(WeightContext.class, 0);
        }

        public DiscContext disc() {
            return getRuleContext(DiscContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_prog;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof Puzzle7Listener) ((Puzzle7Listener) listener).enterProg(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof Puzzle7Listener) ((Puzzle7Listener) listener).exitProg(this);
        }
    }

    public static class NameContext extends ParserRuleContext {
        public NameContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode ID() {
            return getToken(Puzzle7Parser.ID, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_name;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof Puzzle7Listener) ((Puzzle7Listener) listener).enterName(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof Puzzle7Listener) ((Puzzle7Listener) listener).exitName(this);
        }
    }

    public static class DiscContext extends ParserRuleContext {
        public DiscContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List<NameContext> name() {
            return getRuleContexts(NameContext.class);
        }

        public NameContext name(int i) {
            return getRuleContext(NameContext.class, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_disc;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof Puzzle7Listener) ((Puzzle7Listener) listener).enterDisc(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof Puzzle7Listener) ((Puzzle7Listener) listener).exitDisc(this);
        }
    }

    public static class WeightContext extends ParserRuleContext {
        public WeightContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode INT() {
            return getToken(Puzzle7Parser.INT, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_weight;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof Puzzle7Listener) ((Puzzle7Listener) listener).enterWeight(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof Puzzle7Listener) ((Puzzle7Listener) listener).exitWeight(this);
        }
    }
}