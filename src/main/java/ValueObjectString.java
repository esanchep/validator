public class ValueObjectString implements ValueObject<String> {

    private final String value;

    public ValueObjectString(String value) {
        validate(value, ValidatorNotNull.class, ValidatorNotEmpty.class);
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }
}
