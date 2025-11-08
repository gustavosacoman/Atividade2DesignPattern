import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        
        DatabaseService db = new DatabaseService();

        AbstractValidator validadorSchema = new ValidadorSchemaXML();
        AbstractValidator validadorCertificado = new ValidatorDigitalCertificate();
        AbstractValidator validadorFiscal = new ValidatorFiscalRules();
        AbstractValidator validadorDB = new ValidadorDB(db);
        AbstractValidator validadorSefaz = new ValidadorSefaz();

        validadorSchema.setNext(validadorCertificado);
        validadorCertificado.setNext(validadorFiscal);
        validadorFiscal.setNext(validadorDB);
        validadorDB.setNext(validadorSefaz);

        
        System.out.println("Iniciando validacao: NF-e com Erros");
        DocumentsNFE nfeComErro = new DocumentsNFE("123", -50.0, "<xml>sem assinatura</xml>");
        ValidationContext ctxErro = new ValidationContext(nfeComErro);
        validadorSchema.validate(ctxErro);
        processResults(ctxErro);
        
        System.out.println("\nIniciando validacao: NF-e Válida");
        DocumentsNFE nfeValida = new DocumentsNFE(
            "456", 
            200.0,
            "<xml><Assinatura>...</Assinatura></xml>",
            "11.111.111/0001-11",
            "22.222.222/0001-22" 
        );
        
        ValidationContext ctxValido = new ValidationContext(nfeValida);
        validadorSchema.validate(ctxValido);
        processResults(ctxValido);
        
        System.out.println("\nIniciando validacao: NF-e Duplicada");
        
        DocumentsNFE nfeDuplicada = new DocumentsNFE(
            "456",
            15000.0, 
            "<xml><Assinatura>...</Assinatura></xml>",
            "11.111.111/0001-11",
            "22.222.222/0001-22"
        );
        
        ValidationContext ctxDuplicado = new ValidationContext(nfeDuplicada);
        validadorSchema.validate(ctxDuplicado);
        processResults(ctxDuplicado);
        
        System.out.println("\nDB 'numerosNFeRegistrados' contém '456'? " + db.existNumber("456"));

        System.out.println("\nIniciando validacao: NF-e Perfeita");
        
        DocumentsNFE nfePerfeita = new DocumentsNFE(
            "789", 
            500.0, 
            "<xml><Assinatura>valida</Assinatura></xml>",
            "33.333.333/0001-33",
            "44.444.444/0001-44"
        );
        
        ValidationContext ctxPerfeito = new ValidationContext(nfePerfeita);
        validadorSchema.validate(ctxPerfeito);
        processResults(ctxPerfeito); 

        System.out.println("DB 'numerosNFeRegistrados' contém '789'? " + db.existNumber("789"));
    }

    public static void processResults(ValidationContext ctx) {
        if (ctx.hasErrors()) {
            System.out.println("\n--- Validacao falhou ---");
            System.out.println("Erros encontrados:");
            for (String err : ctx.getErrors()) {
                System.out.println("  - " + err);
            }
            
            System.out.println("... Iniciando Rollback ...");
            Stack<Runnable> actions = ctx.getRollbackActions();
            while (!actions.isEmpty()) {
                actions.pop().run();
            }
        } else {
            System.out.println("\n--- Validacao concluida com sucesso! ---");
        }
    }
}