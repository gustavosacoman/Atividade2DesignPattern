public class ValidatorFiscalRules extends AbstractValidator {

    @Override
    public void validate(ValidationContext ctx) {

        
        if (ctx.getNfe().getTotalValue() < 0) {
            ctx.addError("Valor total da NFE não pode ser negativo");
        }
        if (ctx.getNfe().getCnpjEmitter() == null || ctx.getNfe().getCnpjEmitter().isEmpty()) {
            ctx.addError("CNPJ do emitente é obrigatório");
        }
        if (ctx.getNfe().getCnpjRecipient() == null || ctx.getNfe().getCnpjRecipient().isEmpty()) {
            ctx.addError("CNPJ do destinatário é obrigatório");
        }

        if (ctx.getErrorCount() < 3) {
            next(ctx); 
        }
    }
    
}
