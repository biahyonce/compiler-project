package com.github.biancacristina.compiler;

import com.github.biancacristina.compiler.automaton.Automaton;
import com.github.biancacristina.compiler.automaton.service.impl.AutomatonCreationServiceImpl;
import com.github.biancacristina.compiler.lexical.impl.LexerImpl;
import com.github.biancacristina.compiler.syntax.ParserInterface;
import com.github.biancacristina.compiler.syntax.grammar.GrammarInterface;
import com.github.biancacristina.compiler.syntax.grammar.builder.GrammarBuilder;
import com.github.biancacristina.compiler.syntax.grammar.parser.impl.GrammarParserImpl;
import com.github.biancacristina.compiler.syntax.impl.Parser;

import java.io.InputStream;
import java.util.Scanner;

public class CompilerProjectApplication {

    private static String readFile(String fileName) {
        InputStream inputStream  = CompilerProjectApplication.class.getResourceAsStream(fileName);
        Scanner scanner = new Scanner(inputStream);
        StringBuilder fileStr = new StringBuilder();
        while(scanner.hasNextLine()) {
            fileStr.append(scanner.nextLine());
        }
        scanner.close();
        return fileStr.toString();
    }

    public static void main(String[] args) {
        String s = CompilerProjectApplication.readFile("/input.txt");

        Automaton automaton = (new AutomatonCreationServiceImpl()).create();
        LexerImpl lexer = LexerImpl.getInstance();
        lexer.build(automaton, s);

        GrammarInterface grammar = GrammarBuilder.getInstance().build(new GrammarParserImpl().read());
        ParserInterface parser = new Parser(lexer, grammar);
        parser.parse();
    }
}