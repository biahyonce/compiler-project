package com.github.biancacristina.compiler.syntax;

import com.github.biancacristina.compiler.common.Token;

public interface ParserInterface {
    void eatToken(String label);
    Token getCurrentToken();
    void parse();
}
