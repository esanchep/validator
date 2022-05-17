public class ValidatorNotEmpty implements Validator<String> {
    public static final String ERROR_MESSAGE = "String is empty";

    public ValidatorNotEmpty(String value) {
        validate(value);
    }

    @Override
    public void validate(String value) {
        if (null != value && value.trim().isEmpty()) {
            throw new ValidatorException(ERROR_MESSAGE);
        }
    }
}
