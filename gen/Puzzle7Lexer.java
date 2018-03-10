// Generated from /Users/mario/IdeaProjects/AdventOfCode/src/Puzzle7.g4 by ANTLR 4.7

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class Puzzle7Lexer extends Lexer {
    public static final int
            T__0 = 1, T__1 = 2, T__2 = 3, T__3 = 4, ID = 5, INT = 6, NEWLINE = 7, WS = 8, ANY = 9;
    public static final String[] ruleNames = {
            "T__0", "T__1", "T__2", "T__3", "ID", "INT", "NEWLINE", "WS", "ANY"
    };
    /**
     * @deprecated Use {@link #VOCABULARY} instead.
     */
    @Deprecated
    public static final String[] tokenNames;
    public static final String _serializedATN =
            "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\138\b\1\4\2\t\2\4" +
                    "\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3\2" +
                    "\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\6\3\6\7\6!\n\6\f\6\16\6$\13\6\3\7\6\7\'" +
                    "\n\7\r\7\16\7(\3\b\3\b\3\b\5\b.\n\b\3\t\6\t\61\n\t\r\t\16\t\62\3\t\3\t" +
                    "\3\n\3\n\2\2\13\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\3\2\6\3\2c|\3" +
                    "\2\62;\4\2\f\f\17\17\5\2\13\f\17\17\"\"\2;\2\3\3\2\2\2\2\5\3\2\2\2\2\7" +
                    "\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2" +
                    "\2\2\23\3\2\2\2\3\25\3\2\2\2\5\27\3\2\2\2\7\31\3\2\2\2\t\34\3\2\2\2\13" +
                    "\36\3\2\2\2\r&\3\2\2\2\17-\3\2\2\2\21\60\3\2\2\2\23\66\3\2\2\2\25\26\7" +
                    "*\2\2\26\4\3\2\2\2\27\30\7+\2\2\30\6\3\2\2\2\31\32\7/\2\2\32\33\7@\2\2" +
                    "\33\b\3\2\2\2\34\35\7.\2\2\35\n\3\2\2\2\36\"\t\2\2\2\37!\t\2\2\2 \37\3" +
                    "\2\2\2!$\3\2\2\2\" \3\2\2\2\"#\3\2\2\2#\f\3\2\2\2$\"\3\2\2\2%\'\t\3\2" +
                    "\2&%\3\2\2\2\'(\3\2\2\2(&\3\2\2\2()\3\2\2\2)\16\3\2\2\2*+\7\17\2\2+.\7" +
                    "\f\2\2,.\t\4\2\2-*\3\2\2\2-,\3\2\2\2.\20\3\2\2\2/\61\t\5\2\2\60/\3\2\2" +
                    "\2\61\62\3\2\2\2\62\60\3\2\2\2\62\63\3\2\2\2\63\64\3\2\2\2\64\65\b\t\2" +
                    "\2\65\22\3\2\2\2\66\67\13\2\2\2\67\24\3\2\2\2\7\2\"(-\62\3\b\2\2";
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
    public static String[] channelNames = {
            "DEFAULT_TOKEN_CHANNEL", "HIDDEN"
    };
    public static String[] modeNames = {
            "DEFAULT_MODE"
    };

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

    public Puzzle7Lexer(CharStream input) {
        super(input);
        _interp = new LexerATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
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
    public String[] getChannelNames() {
        return channelNames;
    }

    @Override
    public String[] getModeNames() {
        return modeNames;
    }

    @Override
    public ATN getATN() {
        return _ATN;
    }
}