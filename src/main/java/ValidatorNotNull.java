public class ValidatorNotNull implements Validator<Object> {

    public static final String ERROR_MESSAGE = "Value is null";

    public ValidatorNotNull(Object value) {
        validate(value);
    }

    @Override
    public void validate(Object value) {
        if (null == value) {
            throw new ValidatorException(ERROR_MESSAGE);
        }
    }
}
