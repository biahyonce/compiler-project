import service.impl.AutomatonSimulationServiceImpl;

public class LexicalAnalysis {
    public static void main(String[] args) {
        AutomatonSimulationServiceImpl simulator = new AutomatonSimulationServiceImpl();
        String s = "if a<b";
        simulator.simulate(s);
    }
}