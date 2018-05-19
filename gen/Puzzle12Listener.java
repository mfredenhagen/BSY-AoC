// Generated from /Users/mario/IdeaProjects/AdventOfCode/src/Puzzle12.g4 by ANTLR 4.7

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link Puzzle12Parser}.
 */
public interface Puzzle12Listener extends ParseTreeListener {
    /**
     * Enter a parse tree produced by {@link Puzzle12Parser#list}.
     *
     * @param ctx the parse tree
     */
    void enterList(Puzzle12Parser.ListContext ctx);

    /**
     * Exit a parse tree produced by {@link Puzzle12Parser#list}.
     *
     * @param ctx the parse tree
     */
    void exitList(Puzzle12Parser.ListContext ctx);

    /**
     * Enter a parse tree produced by {@link Puzzle12Parser#prog}.
     *
     * @param ctx the parse tree
     */
    void enterProg(Puzzle12Parser.ProgContext ctx);

    /**
     * Exit a parse tree produced by {@link Puzzle12Parser#prog}.
     *
     * @param ctx the parse tree
     */
    void exitProg(Puzzle12Parser.ProgContext ctx);

    /**
     * Enter a parse tree produced by {@link Puzzle12Parser#name}.
     *
     * @param ctx the parse tree
     */
    void enterName(Puzzle12Parser.NameContext ctx);

    /**
     * Exit a parse tree produced by {@link Puzzle12Parser#name}.
     *
     * @param ctx the parse tree
     */
    void exitName(Puzzle12Parser.NameContext ctx);

    /**
     * Enter a parse tree produced by {@link Puzzle12Parser#pipes}.
     *
     * @param ctx the parse tree
     */
    void enterPipes(Puzzle12Parser.PipesContext ctx);

    /**
     * Exit a parse tree produced by {@link Puzzle12Parser#pipes}.
     *
     * @param ctx the parse tree
     */
    void exitPipes(Puzzle12Parser.PipesContext ctx);
}