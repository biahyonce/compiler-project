import java.util.Scanner;
import java.io.InputStream;

import service.impl.AutomatonSimulationServiceImpl;

public class LexicalAnalysis {

    private static String readFile(String fileName) {
        InputStream inputStream  = LexicalAnalysis.class.getResourceAsStream(fileName);
        Scanner scanner = new Scanner(inputStream);
        String fileStr = "";
        while(scanner.hasNextLine()) {
            fileStr += scanner.nextLine();
        }
        return fileStr;
    }

    public static void main(String[] args) {
        AutomatonSimulationServiceImpl simulator = new AutomatonSimulationServiceImpl();
        
        String s = LexicalAnalysis.readFile(args[0]);
        // System.out.println(s);
        simulator.simulate(s);
    }
}