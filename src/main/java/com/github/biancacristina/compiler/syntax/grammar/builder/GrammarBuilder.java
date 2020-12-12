package com.github.biancacristina.compiler.syntax.grammar.builder;

import com.github.biancacristina.compiler.syntax.grammar.GrammarInterface;
import com.github.biancacristina.compiler.syntax.grammar.ItemInterface;
import com.github.biancacristina.compiler.syntax.grammar.impl.Grammar;
import com.github.biancacristina.compiler.syntax.grammar.impl.Production;
import com.github.biancacristina.compiler.syntax.grammar.impl.Sentence;
import com.github.biancacristina.compiler.syntax.grammar.request.ItemRequest;
import com.github.biancacristina.compiler.syntax.grammar.request.RuleRequest;

import java.util.ArrayList;

public class GrammarBuilder {
    private static GrammarBuilder instance;

    private GrammarBuilder(){}

    public GrammarInterface build(ArrayList<RuleRequest> rules) {
        GrammarInterface grammar = new Grammar();
        rules.forEach( rule -> buildRule(grammar, rule.getProduction(), rule.getSentences()) );
        return grammar;
    }

    private void buildRule(GrammarInterface grammar, String productionLabel, String sentenceString) {
        Sentence sentence = buildSentence(grammar, sentenceString);
        Production production;
        if (grammar.hasItem(productionLabel)) {
            production = (Production) grammar.get(productionLabel);
            production.addSentence(sentence);
        } else {
            production = new Production(productionLabel);
            production.addSentence(sentence);
            grammar.put(production);
        }
    }

    private Sentence buildSentence(GrammarInterface grammar, String sentenceString) {
        Sentence sentence = new Sentence();
        for(int i=0;i<sentenceString.length();i++) {
            String label = String.valueOf(sentenceString.charAt(i));
            ItemInterface item;
            if (grammar.hasItem(label)) {
                item = grammar.get(label);
            } else {
                ItemRequest itemRequest = new ItemRequest(label);
                item = itemRequest.toItem();
                grammar.put(item);
            }
            sentence.add(item);
        }
        return sentence;
    }

    public static GrammarBuilder getInstance() {
        if(GrammarBuilder.instance == null) {
            GrammarBuilder.instance = new GrammarBuilder();
        }
        return GrammarBuilder.instance;
    }
}
