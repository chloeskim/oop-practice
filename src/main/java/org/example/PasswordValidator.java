package org.example;

public class PasswordValidator {
    private static final String WRONG_PASSWORD_LENGTH_EXCEPTION_MESSAGE = "The password MUST be at least 8 characters and no more than 12 characters.";

    public static void validate(String password) {
        int length = password.length();
        if(length < 8 || length > 12 ) {
            throw new IllegalArgumentException(WRONG_PASSWORD_LENGTH_EXCEPTION_MESSAGE);
        }
    }
}
