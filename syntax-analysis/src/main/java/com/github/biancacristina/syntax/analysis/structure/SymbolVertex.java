package com.github.biancacristina.syntax.analysis.structure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Stack;

public class SymbolVertex extends Vertex {
    private static final Logger logger = LoggerFactory.getLogger(SymbolVertex.class);
    public SymbolVertex(String label) {
        super(label);
    }

    @Override
    public void process(Stack<Token> stack, SyntacticGraph syntacticGraph) {
        String token = stack.pop().getValue();
        if (!tokenMatch(token)) { logger.error("Token " + token + "was not accepted"); }
        logger.info("Processed token " + token);
    }

    private boolean tokenMatch(String token) {
        return token.equals(this.getLabel());
    }
}
