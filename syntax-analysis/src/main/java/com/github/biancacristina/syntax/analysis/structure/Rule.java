package com.github.biancacristina.syntax.analysis.structure;

import java.util.HashMap;

public class Rule {
    private HashMap<String, Procedure> procedures;

    public Rule(HashMap<String, Procedure> procedures) {
        this.procedures = procedures;
    }

    public void addProcedure(Procedure procedure) {
        this.procedures.put(procedure.getLabel(), procedure);
    }
}
