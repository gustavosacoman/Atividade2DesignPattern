public class Main {
    public static void main(String[] args) {
        System.out.println("--- 🏦 Teste do Padrão Adapter (Gateway Bancário) ---");

        IBanckSystemLegacy sistemaLegado = new BankSystemLegacy();

        IProcessTrasactions meuGatewayDePagamento = new GatewayBankSystemLegacy(sistemaLegado);

        System.out.println("\nTentando autorizar R$ 150.75 BRL...");
        boolean sucesso1 = meuGatewayDePagamento.Autorize("1234-5678", 150.75, "BRL");
        System.out.println("Resultado: " + (sucesso1 ? "Autorizado" : "Recusado"));

        System.out.println("\nTentando autorizar $ 50.00 USD...");
        boolean sucesso2 = meuGatewayDePagamento.Autorize("8765-4321", 50.00, "USD");
        System.out.println("Resultado: " + (sucesso2 ? "Autorizado" : "Recusado"));

        System.out.println("\nTentando autorizar ¥ 1000 JPY (Moeda não suportada)...");
        boolean sucesso3 = meuGatewayDePagamento.Autorize("9999-0000", 1000, "JPY");
        System.out.println("Resultado: " + (sucesso3 ? "Autorizado" : "Recusado"));
    }
}
