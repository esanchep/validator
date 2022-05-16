public class ValidatorNotEmpty implements Validator<String> {

    public ValidatorNotEmpty(String value) {
        validate(value);
    }

    @Override
    public void validate(String value) {
        if (null != value && value.trim().isEmpty()) {
            throw new ValidatorException("String is empty");
        }
    }
}
