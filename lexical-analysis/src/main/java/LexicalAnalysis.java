import service.impl.AutomatonSimulationServiceImpl;

public class LexicalAnalysis {
    public static void main(String[] args) {
        AutomatonSimulationServiceImpl simulator = new AutomatonSimulationServiceImpl();
        String s = "+/*";
        simulator.simulate(s);
    }
}