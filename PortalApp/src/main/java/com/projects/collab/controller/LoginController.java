package com.projects.collab.controller;

import com.projects.collab.entity.PortalUser;
import com.projects.collab.mapper.DatabaseToReponseMapper;
import com.projects.collab.pojo.RegistrationUser;
import com.projects.collab.pojo.UserResponse;
import com.projects.collab.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    private LoginService service;

    @GetMapping(path="/v1/getAllUsers")
    public @ResponseBody ResponseEntity<Iterable<UserResponse>> fetchUsers () {
        ResponseEntity<Iterable<UserResponse>> response;
        Iterable<PortalUser> result = service.findNonAdmins();
        if (Objects.nonNull(result)) {
            List<UserResponse> interimResponse = new ArrayList<>();
            for (PortalUser portalUser : result) {
                UserResponse userResponse =
                        DatabaseToReponseMapper.mapToUserResponse(portalUser);
                interimResponse.add(userResponse);
            }
            response = new ResponseEntity<>(
                    interimResponse,
                    HttpStatus.OK);
        } else {
            response = new ResponseEntity<>(
                    null,
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    @GetMapping(path="/v1/getAllAdminUsers")
    public @ResponseBody ResponseEntity<Iterable<UserResponse>> fetchAdminUsers () {
        ResponseEntity<Iterable<UserResponse>> response;
        Iterable<PortalUser> result = service.findAllAdmins();
        if (Objects.nonNull(result)) {
            List<UserResponse> interimResponse = new ArrayList<>();
            for (PortalUser portalUser : result) {
                UserResponse userResponse =
                        DatabaseToReponseMapper.mapToUserResponse(portalUser);
                interimResponse.add(userResponse);
            }
            response = new ResponseEntity<>(
                    interimResponse,
                    HttpStatus.OK);
        } else {
            response = new ResponseEntity<>(
                    null,
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    @PostMapping(path="/v1/login")
    public @ResponseBody ResponseEntity<UserResponse> login (@RequestBody RegistrationUser user) {
        ResponseEntity<UserResponse> response;
        Optional<PortalUser> portalUser = service.findById(user.getPhonenumber());
        if(portalUser.isPresent()) {
            String password = user.getPassword();
            if(password.length() == 8) {
                PortalUser portalUserOptional = portalUser.get();
                String phoneNumber = portalUserOptional.getPhonenumber();
                String aadhaar = portalUserOptional.getAadhaar();
                String generatedPassword = phoneNumber.substring(phoneNumber.length()-4, phoneNumber.length())
                        + aadhaar.substring(aadhaar.length()-4, aadhaar.length());
                System.out.println(generatedPassword);
                if(password.equals(generatedPassword)) {
                    UserResponse userResponse =
                            DatabaseToReponseMapper.mapToUserResponse(portalUserOptional);
                    response = new ResponseEntity<>(
                            userResponse,
                            HttpStatus.OK);
                } else {
                    response = new ResponseEntity<>(
                            null,
                            HttpStatus.NO_CONTENT);
                }
            } else {
                response = new ResponseEntity<>(
                        null,
                        HttpStatus.NO_CONTENT);
            }
        } else {
            response = new ResponseEntity<>(
                    null,
                    HttpStatus.NO_CONTENT);
        }
        return response;
    }
}
