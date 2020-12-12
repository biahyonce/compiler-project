package com.github.biancacristina.compiler.syntax.grammar.builder;

import com.github.biancacristina.compiler.syntax.grammar.GrammarInterface;
import com.github.biancacristina.compiler.syntax.grammar.impl.Grammar;

import java.util.ArrayList;

public class GrammarBuilder {
    private static GrammarBuilder instance;

    private GrammarBuilder(){}

    public GrammarInterface build(ArrayList<ArrayList<String>> rules) {
        GrammarInterface grammar = new Grammar();
        // TODO for each grammar rule, build its sentence and add on the grammar
        return grammar;
    }

    private void buildSentence(GrammarInterface grammar, ArrayList<String> sentenceItems) {
        // TODO add each sentenceItem on grammar
    }

    // singleton
    public static GrammarBuilder getInstance() {
        if(GrammarBuilder.instance == null) {
            GrammarBuilder.instance = new GrammarBuilder();
        }
        return GrammarBuilder.instance;
    }
}
