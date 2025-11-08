public class ValidadorSefaz extends AbstractValidator {

   private boolean consultSefaz(ValidationContext ctx) {
        System.out.println("SEFAZ: Consultando NFe " + ctx.getNfe().getNumber() + "...");

        if (ctx.getNfe().getTotalValue() > 10000) {
            System.out.println("SEFAZ: ERRO! Sistema fora do ar para valores altos.");
            return false;
        }
        System.out.println("SEFAZ: OK!");
        return true;
    }

    @Override
    public void validate(ValidationContext ctx) {
        System.out.println("--- Validando na SEFAZ ---");
        
        if (!consultSefaz(ctx)) {
            ctx.addError("Falha na comunicação com a SEFAZ");
            
        }
        
        next(ctx); 
    }
    
}
