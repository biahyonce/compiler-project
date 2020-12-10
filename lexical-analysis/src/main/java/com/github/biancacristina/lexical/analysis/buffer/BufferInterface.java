package com.github.biancacristina.lexical.analysis.buffer;

import com.github.biancacristina.lexical.analysis.structure.Token;

public interface BufferInterface {
	Token getNextToken();
	boolean hasToken();
}
