public class Main {
    public static void main(String[] args) {
        FinancialRiskCalculator calculator = new FinancialRiskCalculator();

        calculator.setStrategy(new CalculateVaR());
        double var = calculator.executeStrategy(7_294.525);
        System.out.println("Value at Risk 7294.525: " + var);

        calculator.setStrategy(new CalculateExpectedShortFall());
        double es = calculator.executeStrategy(11_671.24);
        System.out.println("Expected Shortfall 11671.24: " + es);

        calculator.setStrategy(new StressTestCalculate());
        double expectedShort = calculator.executeStrategy(51_061.675);
        System.out.println("Stress Test 51061.675: " + expectedShort);
    }
}
