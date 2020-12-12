package com.github.biancacristina.compiler.syntax.grammar.request;

public class RuleRequest {
    private String production;
    private String sentences;

    public RuleRequest(String production, String sentences) {
        this.production = production;
        this.sentences = sentences;
    }

    public String getProduction() {
        return production;
    }

    public String getSentences() {
        return sentences;
    }
}
