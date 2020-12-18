package com.github.biancacristina.compiler.syntax.grammar.request;

import java.util.Arrays;
import java.util.List;

public class RuleRequest {
    private String production;
    private List<String> sentences;

    public RuleRequest(String[] rule) {
        List<String> ruleList = Arrays.asList(rule);
        this.production = ruleList.get(0);
        this.sentences = ruleList.subList(1, ruleList.size());
    }

    public String getProduction() {
        return production;
    }

    public List<String> getSentences() {
        return sentences;
    }
}
