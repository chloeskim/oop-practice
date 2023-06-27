package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;

/**
 * the password must be at least 8 characters and no more than 12 characters.
 * if not (less than 8 characters or more than 12 characters), then throw IllegalArgumentException.
 * need to write test code to cover the boundary conditions for password validation.
 */
public class PasswordValidatorTest {

    @DisplayName("If the password is at least 8 characters and no more than 12 characters, no exception will be thrown.")
    @Test
    void ValidatePasswordTest() {
        assertThatCode(() -> PasswordValidator.validate("serverwizard"))
                .doesNotThrowAnyException();
    }

    @DisplayName("If the password is less than 8 characters OR exceeds 12 characters, an IllegalArgumentException will be thrown.")
    @ParameterizedTest
    @ValueSource(strings = {"aabbcce", "aabbccddeeffg"})
    void ValidatePasswordTest2(String password) {
        assertThatCode(() -> PasswordValidator.validate(password))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("The password MUST be at least 8 characters and no more than 12 characters.");
    }
}
