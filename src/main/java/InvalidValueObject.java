public class InvalidValueObject implements ValueObject<Object> {

    private final Object value;

    public InvalidValueObject(Object value) {
        validate(value, String.class, ValidatorNotNull.class);
        this.value = value;
    }

    @Override
    public Object value() {
        return value;
    }
}
