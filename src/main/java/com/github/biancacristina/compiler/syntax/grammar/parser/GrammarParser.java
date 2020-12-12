package com.github.biancacristina.compiler.syntax.grammar.parser;

import com.github.biancacristina.compiler.syntax.grammar.request.RuleRequest;

import java.util.ArrayList;

public interface GrammarParser {
    ArrayList<RuleRequest> read();
}
