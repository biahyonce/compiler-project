package com.github.biancacristina.compiler.lexical.buffer;

import com.github.biancacristina.compiler.lexical.structure.Token;

public interface Buffer {
	Token getNextToken();
	boolean hasToken();
}
