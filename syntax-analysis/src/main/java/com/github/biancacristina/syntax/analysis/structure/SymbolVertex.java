package com.github.biancacristina.syntax.analysis.structure;

import com.github.biancacristina.lexical.analysis.structure.Token;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SymbolVertex extends Vertex {
    private static final Logger logger = LoggerFactory.getLogger(SymbolVertex.class);
    public SymbolVertex(String label) {
        super(label);
    }

    @Override
    public void process(Token token, SyntacticGraph syntacticGraph) {

    }


    private boolean tokenMatch(String token) {
        return token.equals(this.getLabel());
    }
}
