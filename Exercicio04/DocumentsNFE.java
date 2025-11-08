public class DocumentsNFE {

    private String number;
    private double totalValue;
    private String xmlContent;
    private String cnpjEmitter;
    private String cnpjRecipient;

    public DocumentsNFE(String number, double totalValue, String xmlContent) {
        this.number = number;
        this.totalValue = totalValue;
        this.xmlContent = xmlContent;
    }
    public DocumentsNFE(String number, double totalValue, String xmlContent, String cnpjEmitter, String cnpjRecipient) {
        this.number = number;
        this.totalValue = totalValue;
        this.xmlContent = xmlContent;
        this.cnpjEmitter = cnpjEmitter;
        this.cnpjRecipient = cnpjRecipient;
    }

    public String getNumber() {
        return number;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public String getXmlContent() {
        return xmlContent;
    }
    public String getCnpjEmitter() {
        return cnpjEmitter;
    }
    public String getCnpjRecipient() {
        return cnpjRecipient;
    }
}
