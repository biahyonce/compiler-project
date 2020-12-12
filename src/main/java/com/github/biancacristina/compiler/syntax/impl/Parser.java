package com.github.biancacristina.compiler.syntax.impl;

import com.github.biancacristina.compiler.lexical.Lexer;
import com.github.biancacristina.compiler.syntax.ParserInterface;
import com.github.biancacristina.compiler.syntax.grammar.GrammarInterface;

public class Parser implements ParserInterface {
    private Lexer lexer;
    private GrammarInterface grammar;

    public Parser(Lexer lexer, GrammarInterface grammar) {
        this.lexer = lexer;
        this.grammar = grammar;
    }
    public void parse() {

    }
}
