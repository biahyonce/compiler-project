package com.github.biancacristina.syntax.analysis.structure;

import com.github.biancacristina.lexical.analysis.structure.Token;

public class ProcedureVertex extends Vertex {
    public ProcedureVertex(String label) {
        super(label);
    }

    @Override
    public void process(Token token, SyntacticGraph syntacticGraph) {

    }

    private boolean procedureExists(Procedure procedure) {
        return procedure != null;
    }
}