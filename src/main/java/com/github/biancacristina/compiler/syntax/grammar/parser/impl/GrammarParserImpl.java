package com.github.biancacristina.compiler.syntax.grammar.parser.impl;

import com.github.biancacristina.compiler.syntax.grammar.exception.GrammarParserException;
import com.github.biancacristina.compiler.syntax.grammar.parser.GrammarParser;
import com.github.biancacristina.compiler.syntax.grammar.request.FirstRequest;
import com.github.biancacristina.compiler.syntax.grammar.request.FollowRequest;
import com.github.biancacristina.compiler.syntax.grammar.request.RuleRequest;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class GrammarParserImpl implements GrammarParser {
    private static final String GRAMMAR_FILE = "/grammar.txt";
    private static final String FIRST_FILE = "/first.txt";
    private static final String FOLLOW_FILE = "/follow.txt";
    private static final String SPLIT_REGEX = "\\s+";

    @Override
    public ArrayList<RuleRequest> readRules() {
        try {
            ArrayList<RuleRequest> rules = new ArrayList<>();
            InputStream inputStream = GrammarParserImpl.class.getResourceAsStream(GRAMMAR_FILE);
            Scanner scanner = new Scanner(inputStream);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] rule = line.split(SPLIT_REGEX);
                rules.add(new RuleRequest(rule));
            }
            return rules;
        } catch (Exception e) {
            throw new GrammarParserException("Error on parsing grammar file", e);
        }
    }

    @Override
    public ArrayList<FirstRequest> readFirst() {
        try {
             ArrayList<FirstRequest> firstList = new ArrayList<>();
             InputStream inputStream = GrammarParserImpl.class.getResourceAsStream(FIRST_FILE);
             Scanner scanner = new Scanner(inputStream);
             while (scanner.hasNextLine()) {
                 String line = scanner.nextLine();
                 String[] first = line.split(SPLIT_REGEX);
                 firstList.add(new FirstRequest(first));
             }
             return firstList;
        } catch (Exception e) {
            throw new GrammarParserException("Error on parsing first file", e);
        }
    }

    @Override
    public ArrayList<FollowRequest> readFollow() {
        try {
            ArrayList<FollowRequest> followList = new ArrayList<>();
            InputStream inputStream = GrammarParserImpl.class.getResourceAsStream(FOLLOW_FILE);
            Scanner scanner = new Scanner(inputStream);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] follow = line.split(SPLIT_REGEX);
                followList.add(new FollowRequest(follow));
            }
            return followList;
        } catch (Exception e) {
            throw new GrammarParserException("Error on parsing follow file", e);
        }
    }
}
