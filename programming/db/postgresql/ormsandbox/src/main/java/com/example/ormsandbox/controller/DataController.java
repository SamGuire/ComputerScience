package com.example.ormsandbox.controller;


import com.example.ormsandbox.service.dummy.SomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="api/data")
public class DataController {

    @Autowired
    SomeService someService;

    @GetMapping(value="/protected")
    @Secured({"ROLE_ISSAM"})
    public ResponseEntity<Integer> callProtectedService() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return ResponseEntity.ok().body(someService.protectedService());

    }
}
