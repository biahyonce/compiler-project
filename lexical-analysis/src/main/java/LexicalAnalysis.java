import service.impl.AutomatonSimulationServiceImpl;

public class LexicalAnalysis {
    public static void main(String[] args) {
        AutomatonSimulationServiceImpl a = new AutomatonSimulationServiceImpl();
        String s = "+";
        a.simulate(s);
    }
}