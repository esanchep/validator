import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ValidatorNotNullTest {

    @Test
    void ValidatorNotNull_withNonNullValue_isValid() {
        // Given
        final Object value = new Object();

        // When
        final ValidatorNotNull validatorNotNull = new ValidatorNotNull(value);

        // Then
        assertNotNull(validatorNotNull);
    }

    @Test
    void ValidatorNotNull_withNullValue_throwsValidatorException() {
        // Given
        final String value = null;

        // When
        final ValidatorException validatorException = assertThrows(ValidatorException.class, () -> new ValidatorNotNull(value));

        // Then
        assertNotNull(validatorException);
        assertEquals(ValidatorNotNull.ERROR_MESSAGE, validatorException.getMessage());
    }

}