package com.github.biancacristina.compiler.syntax.impl;

import com.github.biancacristina.compiler.common.Token;
import com.github.biancacristina.compiler.lexical.Lexer;
import com.github.biancacristina.compiler.syntax.ParserInterface;
import com.github.biancacristina.compiler.syntax.grammar.GrammarInterface;
import com.github.biancacristina.compiler.syntax.grammar.exception.SyntaxException;

public class Parser implements ParserInterface {
    private Lexer lexer;
    private GrammarInterface grammar;
    private Token currentToken;

    public Parser(Lexer lexer, GrammarInterface grammar) {
        this.lexer = lexer;
        this.grammar = grammar;
        this.currentToken = lexer.getNextToken();
        this.grammar.setParser(this);
    }

    public Token getCurrentToken() {
        return this.currentToken;
    }

    public void eatToken(String label) {
        System.out.println("EAT TOKEN <" + label + ">");
        System.out.println("CURRENT TOKEN <" + this.currentToken.getLabel() + ">");
        if(this.currentToken.getLabel().equals(label)) {
            this.currentToken = this.lexer.getNextToken();
            return;
        }
        throw new SyntaxException("Eat token failed. Unexpected token.");
    }

    public void parse() {
        this.grammar.getFirstRule().process();
    }
}
