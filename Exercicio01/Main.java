public class Main {
    public static void main(String[] args) {
        FinancialRiskCalculator calculator = new FinancialRiskCalculator();

        calculator.setStrategy(new CalculateVaR());
        double var = calculator.executeStrategy(1_000_000);
        System.out.println("Value at Risk: " + var);

        calculator.setStrategy(new CalculateExpectedShortFall());
        double es = calculator.executeStrategy(1_000_000);
        System.out.println("Expected Shortfall: " + es);

        double expectedShort = calculator.executeStrategy(500_000);
        System.out.println("Expected Shortfall for 500,000: " + expectedShort);
    }
}
