// Generated from /Users/mario/IdeaProjects/AdventOfCode/src/Puzzle7.g4 by ANTLR 4.7

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link Puzzle7Parser}.
 */
public interface Puzzle7Listener extends ParseTreeListener {
    /**
     * Enter a parse tree produced by {@link Puzzle7Parser#list}.
     *
     * @param ctx the parse tree
     */
    void enterList(Puzzle7Parser.ListContext ctx);

    /**
     * Exit a parse tree produced by {@link Puzzle7Parser#list}.
     *
     * @param ctx the parse tree
     */
    void exitList(Puzzle7Parser.ListContext ctx);

    /**
     * Enter a parse tree produced by {@link Puzzle7Parser#prog}.
     *
     * @param ctx the parse tree
     */
    void enterProg(Puzzle7Parser.ProgContext ctx);

    /**
     * Exit a parse tree produced by {@link Puzzle7Parser#prog}.
     *
     * @param ctx the parse tree
     */
    void exitProg(Puzzle7Parser.ProgContext ctx);

    /**
     * Enter a parse tree produced by {@link Puzzle7Parser#name}.
     *
     * @param ctx the parse tree
     */
    void enterName(Puzzle7Parser.NameContext ctx);

    /**
     * Exit a parse tree produced by {@link Puzzle7Parser#name}.
     *
     * @param ctx the parse tree
     */
    void exitName(Puzzle7Parser.NameContext ctx);

    /**
     * Enter a parse tree produced by {@link Puzzle7Parser#disc}.
     *
     * @param ctx the parse tree
     */
    void enterDisc(Puzzle7Parser.DiscContext ctx);

    /**
     * Exit a parse tree produced by {@link Puzzle7Parser#disc}.
     *
     * @param ctx the parse tree
     */
    void exitDisc(Puzzle7Parser.DiscContext ctx);

    /**
     * Enter a parse tree produced by {@link Puzzle7Parser#weight}.
     *
     * @param ctx the parse tree
     */
    void enterWeight(Puzzle7Parser.WeightContext ctx);

    /**
     * Exit a parse tree produced by {@link Puzzle7Parser#weight}.
     *
     * @param ctx the parse tree
     */
    void exitWeight(Puzzle7Parser.WeightContext ctx);
}