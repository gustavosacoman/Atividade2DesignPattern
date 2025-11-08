public class BankSystemLegacy implements IBanckSystemLegacy {
    @Override
    public boolean processTransaction(java.util.HashMap<String, Object> transactionData) {
        if (!transactionData.containsKey("auth_token") || 
            !transactionData.containsKey("legacy_currency_code")) {
            System.out.println("ERRO LEGADO: Faltam campos obrigatórios (token ou código de moeda).");
            return false;
        }
    
        System.out.println("Processando transação no sistema bancário legado...");
        System.out.println("Valor: " + transactionData.get("amount"));
        System.out.println("Código Moeda: " + transactionData.get("legacy_currency_code"));
        System.out.println("Token: " + transactionData.get("auth_token"));
        System.out.println("--- PROCESSAMENTO LEGADO CONCLUÍDO ---");

        return true;
    }
    
}
