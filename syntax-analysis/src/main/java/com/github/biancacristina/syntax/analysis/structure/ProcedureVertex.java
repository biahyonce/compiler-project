package com.github.biancacristina.syntax.analysis.structure;

import com.github.biancacristina.syntax.analysis.exception.ProcedureException;

import java.util.Stack;

public class ProcedureVertex extends Vertex {
    public ProcedureVertex(String label) {
        super(label);
    }

    @Override
    public void process(Stack<Token> stack, SyntacticGraph syntacticGraph) {
        String label = this.getLabel();
        Procedure procedure = syntacticGraph.getProcedure(label);
        if (procedureExists(procedure)) { procedure.process(stack, syntacticGraph); }
        else { throw new ProcedureException("Procedure labeled " + label + "was not found"); }
    }

    private boolean procedureExists(Procedure procedure) {
        return procedure != null;
    }
}