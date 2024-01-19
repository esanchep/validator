import org.junit.jupiter.api.Assertions;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Testazo {

    @org.junit.jupiter.api.Test
    void testazo() {
        Supplier<String>            given = () -> "world";
        Function<String, String>    when = "Hello "::concat;
        Consumer<String>            then = (result) -> Assertions.assertEquals("Hello world", result);

        Test.test(given, when, then);
    }

    @org.junit.jupiter.api.Test
    void givenCorrectCredentials_whenCreatingNewUser_thenExpectValidUser() {
        final String expectedUsername = "theUsername";
        final String expectedPassword = "thePassword";
        Supplier<String[]> givenCorrectCredentials = () -> new String[]{expectedUsername, expectedPassword};
        Function<String[], User> whenCreatingNewUser = (credentials) -> new User(credentials[0], credentials[1]);
        Consumer<User> thenExpectValidUser = (user) -> {
            Assertions.assertNotNull(user);
            Assertions.assertEquals(expectedUsername, user.username);
            Assertions.assertEquals(expectedPassword, user.password);
        };

        Test.test(givenCorrectCredentials, whenCreatingNewUser, thenExpectValidUser);
    }

    private static class User {
        final String username;
        final String password;

        public User(final String username, final String password) {
            validate(username);
            validate(password);
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }

        private void validate(final String value) {
            if (null == value || value.trim().isEmpty()) {
                throw new RuntimeException();
            }
        }
    }
}
