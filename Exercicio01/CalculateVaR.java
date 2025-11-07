

import interfaces.IStrategyCalculateRisk;

public class CalculateVaR implements IStrategyCalculateRisk {

    @Override
    public double Calculate(double totalValue) {
        return totalValue * 0.05;
    }
}   
