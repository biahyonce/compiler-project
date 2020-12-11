package com.github.biancacristina.syntax.analysis.structure;

import com.github.biancacristina.lexical.analysis.structure.Token;

import java.util.HashMap;

public class SyntacticGraph {
    private HashMap<String, Procedure> procedures;

    public SyntacticGraph(HashMap<String, Procedure> procedures) {
        this.procedures = procedures;
    }

    public void addProcedure(Procedure procedure) {
        this.procedures.put(procedure.getLabel(), procedure);
    }

    public Procedure getProcedure(String label) {
        return procedures.get(label);
    }

    public void analyze(Token token) {
        // TODO: Start analyze
    }
}
