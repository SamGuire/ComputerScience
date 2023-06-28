package com.example.ormsandbox.controller;

import com.example.ormsandbox.common.HTTPException;
import com.example.ormsandbox.common.LoginForm;
import com.example.ormsandbox.service.authentication.IAuthenticationService;
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
@RequestMapping(value="/api/auth")
public class AuthenticationController {
    @Autowired
    IAuthenticationService authService;

    public AuthenticationController(){}

    @PostMapping(value = "/login")
    public ResponseEntity<String> login(@RequestBody LoginForm form, HttpServletResponse response) {
        try {
            Map<String,String> jwtAndRefreshToken = authService.login(form.getEmail(), form.getPassword());
            Cookie jwtCookie = new Cookie("jwtToken",jwtAndRefreshToken.get("jwt"));
            Cookie refreshTokenCookie = new Cookie("refreshToken",jwtAndRefreshToken.get("refreshToken"));

            jwtCookie.setHttpOnly(true);
            jwtCookie.setPath("/");
            refreshTokenCookie.setHttpOnly(true);
            refreshTokenCookie.setPath("/");
            response.addCookie(jwtCookie);
            response.addCookie(refreshTokenCookie);
            return ResponseEntity.ok().body("Logged in");
        } catch (HTTPException httpException) {
            return ResponseEntity.status(httpException.getHttpCode()).body(httpException.getMessage());
        }
    }

    @GetMapping(value = "/refresh")
    public ResponseEntity<String> refresh(HttpServletResponse response, HttpServletRequest request) {
        try {
            Cookie[] cookies = request.getCookies();
            for (Cookie cookie: cookies) {
                if (cookie.getName().equals("refreshToken")) {
                    String newJWTToken = authService.refreshAccessToken(cookie.getValue());
                    Cookie jwtCookie = new Cookie("jwtToken",newJWTToken);
                    jwtCookie.setHttpOnly(true);
                    jwtCookie.setPath("/");
                    response.addCookie(jwtCookie);
                    return ResponseEntity.status(200).body("Refreshed");
                }
            }
            return ResponseEntity.status(404).body("Missing refresh token to modify");
        } catch (HTTPException httpException) {
            return ResponseEntity.status(httpException.getHttpCode()).body(httpException.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

}
