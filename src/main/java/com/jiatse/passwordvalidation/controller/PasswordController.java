package com.jiatse.passwordvalidation.controller;

import com.jiatse.passwordvalidation.service.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.websocket.server.PathParam;

@Controller
@RequestMapping(path = "api/password/")
public class PasswordController {
    @Autowired
    private PasswordService passwordService;

    @GetMapping(path = "validation")
    public ResponseEntity<String> passwordValidation(@PathParam("password") final String password) {
        passwordService.passwordValidation(password);
        return ResponseEntity.ok().body("Password verification passed!");
    }
}
