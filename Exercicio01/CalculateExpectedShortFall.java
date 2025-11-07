
import interfaces.IStrategyCalculateRisk;

public class CalculateExpectedShortFall implements IStrategyCalculateRisk {

    @Override
    public double Calculate(double totalValue) {
        return totalValue * 0.08;
    }
}   
