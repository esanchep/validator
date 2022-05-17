import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ValidatorNotEmptyTest {

    @Test
    void ValidatorNotEmpty_withNonEmptyString_isValid() {
        // Given
        final String value = "anyValidString";

        // When
        final ValidatorNotEmpty validatorNotEmpty = assertDoesNotThrow(() -> new ValidatorNotEmpty(value));

        // Then
        assertNotNull(validatorNotEmpty);
    }

    @Test
    void ValidatorNotEmpty_withNullValue_isValid() {
        // Given
        final String value = null;

        // When
        final ValidatorNotEmpty validatorNotEmpty = assertDoesNotThrow(() -> new ValidatorNotEmpty(value));

        // Then
        assertNotNull(validatorNotEmpty);
    }

    @Test
    void ValidatorNotEmpty_withEmptyValue_throwsValidatorException() {
        // Given
        final String value = "";

        // When
        final ValidatorException validatorException = assertThrows(ValidatorException.class, () -> new ValidatorNotEmpty(value));

        // Then
        assertNotNull(validatorException);
        assertEquals(ValidatorNotEmpty.ERROR_MESSAGE, validatorException.getMessage());
    }

    @Test
    void ValidatorNotEmpty_withSpacesOnlyValue_throwsValidatorException() {
        // Given
        final String value = "     ";

        // When
        final ValidatorException validatorException = assertThrows(ValidatorException.class, () -> new ValidatorNotEmpty(value));

        // Then
        assertNotNull(validatorException);
        assertEquals(ValidatorNotEmpty.ERROR_MESSAGE, validatorException.getMessage());
    }

}