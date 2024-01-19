import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Test {

    public static <T, R> void test(Supplier<T> given, Function<T, R> when, Consumer<R> then) {
        T value = given.get();
        R result = when.apply(value);
        then.accept(result);
    }

}
