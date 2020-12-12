package com.github.biancacristina.compiler.syntax.grammar.parser.impl;

import com.github.biancacristina.compiler.syntax.grammar.exception.GrammarParserException;
import com.github.biancacristina.compiler.syntax.grammar.parser.GrammarParser;
import com.github.biancacristina.compiler.syntax.grammar.request.RuleRequest;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class GrammarParserImpl implements GrammarParser {
    private static final String GRAMMAR_FILE = "/grammar.txt";
    private static final String SPLIT_REGEX = "\\s+";

    @Override
    public ArrayList<RuleRequest> read() {
        try {
            ArrayList<RuleRequest> rules = new ArrayList<>();
            InputStream inputStream = GrammarParserImpl.class.getResourceAsStream(GRAMMAR_FILE);
            Scanner scanner = new Scanner(inputStream);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] rule = line.split(SPLIT_REGEX);
                rules.add(new RuleRequest(rule[0], rule[1]));
            }
            return rules;
        } catch (Exception e) {
            throw new GrammarParserException("Error on parsing grammar file", e);
        }
    }
}
