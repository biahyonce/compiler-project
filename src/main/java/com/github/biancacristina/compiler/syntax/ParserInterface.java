package com.github.biancacristina.compiler.syntax;

import com.github.biancacristina.compiler.common.Token;
import com.github.biancacristina.compiler.syntax.tree.ParserTreeInterface;

public interface ParserInterface {
    void eatToken(String label);
    boolean canEatToken(String label);
    Token getCurrentToken();
    void parse();
    void error(String label);
    ParserTreeInterface getTree();
}
