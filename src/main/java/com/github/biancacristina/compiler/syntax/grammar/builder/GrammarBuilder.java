package com.github.biancacristina.compiler.syntax.grammar.builder;

import com.github.biancacristina.compiler.syntax.grammar.GrammarInterface;
import com.github.biancacristina.compiler.syntax.grammar.ItemInterface;
import com.github.biancacristina.compiler.syntax.grammar.impl.Grammar;
import com.github.biancacristina.compiler.syntax.grammar.impl.Production;
import com.github.biancacristina.compiler.syntax.grammar.impl.Sentence;
import com.github.biancacristina.compiler.syntax.grammar.request.FirstRequest;
import com.github.biancacristina.compiler.syntax.grammar.request.FollowRequest;
import com.github.biancacristina.compiler.syntax.grammar.request.ItemRequest;
import com.github.biancacristina.compiler.syntax.grammar.request.RuleRequest;

import java.util.ArrayList;
import java.util.List;

public class GrammarBuilder {
    private static GrammarBuilder instance;

    private GrammarBuilder(){}

    public GrammarInterface build(ArrayList<RuleRequest> rules, ArrayList<FirstRequest> firstList, ArrayList<FollowRequest> followList) {
        GrammarInterface grammar = new Grammar();
        rules.forEach( rule -> buildRule(grammar, rule.getProduction(), rule.getSentences()) );
        firstList.forEach( first -> {
            Production production = (Production) grammar.get(first.getProduction());
            System.out.println(production.getLabel());
            production.addFirst(first.getFirst());
        } );
        followList.forEach( follow -> {
            Production production = (Production) grammar.get(follow.getProduction());
            production.addFollow(follow.getFollow());
        } );
        return grammar;
    }

    private void buildRule(GrammarInterface grammar, String productionLabel, List<String> sentenceString) {
        Production production;
        if (grammar.hasItem(productionLabel)) {
            production = (Production) grammar.get(productionLabel);
        } else {
            production = new Production(productionLabel);
            grammar.put(production);
        }
        Sentence sentence = buildSentence(grammar, sentenceString);
        production.addSentence(sentence);
    }

    private Sentence buildSentence(GrammarInterface grammar, List<String> sentenceString) {
        Sentence sentence = new Sentence();
        for (String label : sentenceString) {
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
