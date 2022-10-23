package com.jiatse.passwordvalidation.service;

import com.jiatse.passwordvalidation.exception.ValidatorException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class ValidationServiceTest {
    @Spy
    private ValidationService validationService;

    @Test
    public void passwordValidationPassedTest() {
        boolean result;
        try {
            validationService.passwordValidation("core135");
            result = true;
        } catch (final ValidatorException validatorException) {
            result = false;
        }
        Assert.assertTrue(result);
    }

    @Test
    public void passwordValidationFailedTest() {
        Assert.assertThrows(ValidatorException.class, () -> validationService.passwordValidation(null));
        Assert.assertThrows(ValidatorException.class, () -> validationService.passwordValidation(""));
        Assert.assertThrows(ValidatorException.class, () -> validationService.passwordValidation("vim1"));
        Assert.assertThrows(ValidatorException.class, () -> validationService.passwordValidation("exited"));
        Assert.assertThrows(ValidatorException.class, () -> validationService.passwordValidation("13579"));
        Assert.assertThrows(ValidatorException.class, () -> validationService.passwordValidation("sda2P"));
        Assert.assertThrows(ValidatorException.class, () -> validationService.passwordValidation("crudcrud1"));
    }
}
