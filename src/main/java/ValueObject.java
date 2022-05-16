import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public interface ValueObject<T> {

    default void validate(T value, Class<?>... validators) {
        if (null == validators || validators.length == 0) {
            return;
        }
        Arrays.stream(validators).forEach(validator -> {
            try {
                if (!Validator.class.isAssignableFrom(validator)) {
                    throw new Exception("Invalid class [" + validator.getName() + "]. Only classes implementing Validator interface are allowed.");
                }
                Class<?> paramType = Arrays.stream(Arrays.stream(validator.getConstructors()).findFirst().get().getParameterTypes()).findFirst().get();
                Constructor<?> constructor = validator.getConstructor(paramType);
                constructor.newInstance(value);
            } catch (InvocationTargetException e) {
                throw new ValidatorException(e.getCause().getMessage());
            } catch (ValidatorException e) {
                throw e;
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        });
    }

    T value();

}
