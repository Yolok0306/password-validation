package com.jiatse.passwordvalidation.service;

import com.jiatse.passwordvalidation.exception.ValidatorException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class PasswordServiceTest {
    @Spy
    private ValidationService validationService;
    @InjectMocks
    private PasswordService passwordService;

    @Test
    public void passwordValidationTest() {
        boolean result;
        try {
            passwordService.passwordValidation("core135");
            result = true;
        } catch (final ValidatorException validatorException) {
            result = false;
        }
        Assert.assertTrue(result);
    }
}
