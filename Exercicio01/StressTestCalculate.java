
import interfaces.IStrategyCalculateRisk;

public class StressTestCalculate implements IStrategyCalculateRisk {

    @Override
    public double Calculate(double totalValue) {
        return totalValue * 0.35;
    }
}   
