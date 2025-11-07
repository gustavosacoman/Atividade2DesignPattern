import interfaces.IStrategyCalculateRisk;

public class FinancialRiskCalculator {
    private IStrategyCalculateRisk strategy;

    public void setStrategy(IStrategyCalculateRisk strategy) {
        this.strategy = strategy;
    }

    public double executeStrategy(double totalValue) {
        return strategy.Calculate(totalValue);
    }
}
