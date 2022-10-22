package com.jiatse.passwordvalidation.service;

import com.jiatse.passwordvalidation.exception.ValidatorException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ValidationService {

    public void passwordValidation(final String password) {
        checkLength(password);
        checkAtLeastOneLowercaseLetterAndOneNumber(password);
        checkContainsOnlyLowercaseLettersAndNumbers(password);
        checkForDuplicateSequences(password);
    }

    private void checkLength(final String password) {
        final int minLength = 5, maxLength = 12;
        if (StringUtils.length(password) < minLength || StringUtils.length(password) > maxLength) {
            final String errorMessage = String.format("Password length is not between %s and %s!", minLength, maxLength);
            throw new ValidatorException(errorMessage);
        }
    }

    private void checkAtLeastOneLowercaseLetterAndOneNumber(@NonNull final String password) {
        final Pattern pattern = Pattern.compile("([a-z])(\\d)|(\\d)([a-z])");
        final Matcher matcher = pattern.matcher(password);
        if (!matcher.find()) {
            throw new ValidatorException("Password does not contain at least one lowercase letter and one number!");
        }
    }

    private void checkContainsOnlyLowercaseLettersAndNumbers(@NonNull final String password) {
        final Pattern pattern = Pattern.compile("[^a-z\\d]");
        final Matcher matcher = pattern.matcher(password);
        if (matcher.find()) {
            throw new ValidatorException("Password contains characters other than lowercase letters and numbers!");
        }
    }

    private void checkForDuplicateSequences(@NonNull final String password) {
        for (int sequenceSize = 1; sequenceSize <= password.length() / 2; sequenceSize++) {
            for (int startIndex = 0; startIndex < password.length(); startIndex++) {
                final int endIndex = startIndex + sequenceSize;
                if (endIndex > password.length()) {
                    break;
                }

                final String sequence = password.substring(startIndex, endIndex);
                final Pattern pattern = Pattern.compile(sequence + sequence);
                final Matcher matcher = pattern.matcher(password);
                if (matcher.find()) {
                    final String errorMessage = String.format("Password contains repeating sequences : %s!", sequence);
                    throw new ValidatorException(errorMessage);
                }
            }
        }
    }
}
