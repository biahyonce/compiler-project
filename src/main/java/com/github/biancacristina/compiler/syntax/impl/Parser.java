package com.github.biancacristina.compiler.syntax.impl;

import com.github.biancacristina.compiler.common.Token;
import com.github.biancacristina.compiler.lexical.Lexer;
import com.github.biancacristina.compiler.syntax.ParserInterface;
import com.github.biancacristina.compiler.syntax.grammar.GrammarInterface;
import com.github.biancacristina.compiler.syntax.grammar.exception.SyntaxException;
import com.github.biancacristina.compiler.syntax.tree.ParserTreeInterface;
import com.github.biancacristina.compiler.syntax.tree.ParserTreeNodeInterface;
import com.github.biancacristina.compiler.syntax.tree.impl.ParserTree;

public class Parser implements ParserInterface {
    private Lexer lexer;
    private GrammarInterface grammar;
    private Token currentToken;
    private ParserTreeInterface tree;

    public Parser(Lexer lexer, GrammarInterface grammar) {
        this.lexer = lexer;
        this.grammar = grammar;
        this.currentToken = lexer.getNextToken();
        this.grammar.setParser(this);
        this.tree = new ParserTree();
    }

    public Token getCurrentToken() {
        return this.currentToken;
    }

    public void eatToken(String label) {
        System.out.println("EAT TOKEN <" + label + ">");
        System.out.println("CURRENT TOKEN <" + this.currentToken.getLabel() + ", " + this.currentToken.getAttribute() + ">");
        if(this.canEatToken(label)) {
            this.currentToken = this.lexer.getNextToken();
            System.out.println("CURRENT TOKEN AFTER EAT <" + this.currentToken.getLabel() + ", " + this.currentToken.getAttribute() + ">");
            return;
        }
        throw new SyntaxException("Eat token failed. Unexpected token.");
    }

    public boolean canEatToken(String label) {
        return (
                this.currentToken.getLabel().equals(label)
                || this.currentToken.getAttribute().equals(label)
        );
    }

    public void parse() {
        this.tree.setRoot(this.grammar.getFirstRule().process());
    }

    public void error(String label) throws SyntaxException{
        String errorMessage = "Syntax Error on <"
                + label
                + "> token, at position: "
                + this.getCurrentToken().getErrorInfo();
        System.out.println(errorMessage);
        throw new SyntaxException(errorMessage);
    }

    public ParserTreeInterface getTree() {
        return this.tree;
    }
}
