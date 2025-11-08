
import java.util.HashMap;

public class GatewayBankSystemLegacy implements IProcessTrasactions {
    private IBanckSystemLegacy banckSystemLegacy;

    public GatewayBankSystemLegacy(IBanckSystemLegacy banckSystemLegacy) {
        this.banckSystemLegacy = banckSystemLegacy;
    }

    @Override
    public boolean Autorize(String cardNumber, double amount, String coin) {

        int coinType = 0;
        if (coin.contains("USD"))
            coinType = 1;
        else if (coin.contains("EUR"))
            coinType = 2;
        else if (coin.contains("BRL"))
            coinType = 3;
        else
        {
            System.out.println("Currency not accepted");
            return false;
        }
            

        HashMap<String, Object> transactionData = new HashMap<>();
        transactionData.put("cardNumber", cardNumber);
        transactionData.put("amount", amount);
        transactionData.put("coin", coinType);

        // Required fields for legacy system
        transactionData.put("auth_token", "hardcoded_legacy_token_12345");

        // Mapping currency code for legacy system
        return banckSystemLegacy.processTransaction(transactionData);
    }


}
