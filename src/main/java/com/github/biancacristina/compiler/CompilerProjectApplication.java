package com.github.biancacristina.compiler;

import com.github.biancacristina.compiler.automaton.service.impl.AutomatonSimulationServiceImpl;

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
        AutomatonSimulationServiceImpl simulator = new AutomatonSimulationServiceImpl();

        String s = CompilerProjectApplication.readFile("/input.txt");
        simulator.simulate(s);
    }
}