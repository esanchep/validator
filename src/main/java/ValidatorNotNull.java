public class ValidatorNotNull implements Validator<Object> {

    public ValidatorNotNull(Object value) {
        validate(value);
    }

    @Override
    public void validate(Object value) {
        if (null == value) {
            throw new ValidatorException("Value is null");
        }
    }
}
