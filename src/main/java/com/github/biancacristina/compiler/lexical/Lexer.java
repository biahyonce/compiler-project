package com.github.biancacristina.compiler.lexical;

import com.github.biancacristina.compiler.common.Token;

public interface Lexer {
	Token getNextToken();
	boolean hasToken();
}
