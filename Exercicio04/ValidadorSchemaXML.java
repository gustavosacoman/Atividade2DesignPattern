public class ValidadorSchemaXML extends AbstractValidator {

    @Override
    public void validate(ValidationContext ctx) {

        if (ctx.getNfe().getXmlContent() == null || ctx.getNfe().getXmlContent().isEmpty()) {
            ctx.addError("Erro de Schema XML");
        }

        if (ctx.getErrorCount() < 3) {
            next(ctx); 
        }
    }
}
