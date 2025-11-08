public class ValidadorDB extends AbstractValidator {
    private DatabaseService db;

    public ValidadorDB(DatabaseService db) {
        this.db = db;
    }

    @Override
    public void validate(ValidationContext ctx) {
        String numeroNFe = ctx.getNfe().getNumber();
        
        if (db.existNumber(numeroNFe)) {
            ctx.addError("Duplicidade de NF-e");
        } else {
            db.insertLog(numeroNFe);

            ctx.getRollbackActions().push(() -> {
                db.removeLog(numeroNFe);
                System.out.println("ROLLBACK: Removido log de " + numeroNFe);
            });
        }

        if (ctx.getErrorCount() < 3) {
            next(ctx);
        }
    }
    
}
