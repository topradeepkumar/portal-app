package com.projects.collab.controller;

import com.projects.collab.pojo.RegistrationUser;
import com.projects.collab.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegistrationController {

    @Autowired
    private RegistrationService service;

    @PostMapping(path="/v1/register")
    public @ResponseBody ResponseEntity<String> addNewUser (@RequestBody RegistrationUser user) {
        ResponseEntity<String> response;
        boolean result = service.register(user);
        if(result) {
            response = new ResponseEntity<>(
                    "User has been created successfully",
                    HttpStatus.CREATED);
        } else {
            response = new ResponseEntity<>(
                    "There was problem during registration",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }
}
