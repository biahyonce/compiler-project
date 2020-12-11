package com.github.biancacristina.syntax.analysis.structure;

public class SyntacticGraph {
    private Rule rule;

    public SyntacticGraph(Rule rules) {
        this.rule = rules;
    }

    public Rule getRule() {
        return rule;
    }
}
