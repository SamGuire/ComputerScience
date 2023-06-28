package com.example.ormsandbox.controller;

import com.example.ormsandbox.common.HTTPException;
import com.example.ormsandbox.common.LoginForm;
import com.example.ormsandbox.common.RegistrationForm;
import com.example.ormsandbox.service.authentication.IAuthenticationService;
import com.example.ormsandbox.service.user.IUserService;
import com.example.ormsandbox.utility.jwt.JWTTokenUtil;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.Map;

@RestController
@RequestMapping(value="/api/user")
public class UserController {
    @Autowired
    IUserService userService;

    public UserController(){}

    @PostMapping(value = "/createAccount")
    public ResponseEntity<String> login(@RequestBody RegistrationForm form, HttpServletResponse response) {
        try {
            boolean userCreated = userService.createUser(form);
            return ResponseEntity.ok().body(Boolean.toString(userCreated));
        } catch (HTTPException httpException) {
            return ResponseEntity.status(httpException.getHttpCode()).body(httpException.getMessage());
        }
    }



}
