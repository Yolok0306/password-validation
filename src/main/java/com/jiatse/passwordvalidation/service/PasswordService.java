package com.jiatse.passwordvalidation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PasswordService {
    @Autowired
    private ValidationService validationService;

    public void passwordValidation(final String password) {
        validationService.passwordValidation(password);
    }
}
