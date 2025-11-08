public class ValidatorDigitalCertificate extends AbstractValidator {

   @Override
    public void validate(ValidationContext ctx) {
        System.out.println("--- Validando Certificado Digital ---");
        
        if (!ctx.getNfe().getXmlContent().contains("<Assinatura>")) {
            ctx.addError("NF-e não assinada digitalmente");
        }
        
        if (ctx.getErrorCount() < 3) {
            next(ctx); 
        }
    }
    
}
