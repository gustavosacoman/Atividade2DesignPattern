public abstract class AbstractValidator {
    protected AbstractValidator next;

    public void setNext(AbstractValidator nextValidator) {
        this.next = nextValidator;
    }

    public abstract void validate(ValidationContext ctx);

    protected void next(ValidationContext ctx) {
        if (this.next != null) {
            this.next.validate(ctx);
        }
    }
}