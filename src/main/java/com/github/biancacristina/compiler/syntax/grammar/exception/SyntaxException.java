package com.github.biancacristina.compiler.syntax.grammar.exception;

public class SyntaxException extends RuntimeException{
    private String message;
    public SyntaxException(String m) {
        this.message = m;
    }
}
