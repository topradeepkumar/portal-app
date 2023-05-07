package com.projects.collab.controller;

import com.projects.collab.pojo.RegistrationUser;
import com.projects.collab.service.UpdateDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UpdateDetailsController {

    @Autowired
    private UpdateDetailsService service;

    @PatchMapping(path = "/v1/update")
    public @ResponseBody ResponseEntity<String> addNewUser(@RequestBody RegistrationUser user) {
        ResponseEntity<String> response;
        boolean result = service.updateUserDetails(user);
        if (result) {
            response = new ResponseEntity<>(
                    "User has been updated successfully",
                    HttpStatus.OK);
        } else {
            response = new ResponseEntity<>(
                    "There was problem during updating user details with ADMIN ID: " + user.getAdminUserId(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    @DeleteMapping(path = "/v1/delete")
    public @ResponseBody ResponseEntity<String> dlelteUser(@RequestBody RegistrationUser user) {
        ResponseEntity<String> response;
        boolean result = service.deleteUserDetails(user);
        if (result) {
            response = new ResponseEntity<>(
                    "User has been deleted successfully",
                    HttpStatus.OK);
        } else {
            response = new ResponseEntity<>(
                    "There was problem during deleting user details with ADMIN ID: " + user.getAdminUserId(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    @PatchMapping(path = "/v1/updateMeToAdmin")
    public @ResponseBody ResponseEntity<String> updateToAdmin(@RequestBody RegistrationUser user) {
        ResponseEntity<String> response;
        boolean result = service.updateUserToAdmin(user);
        if (result) {
            response = new ResponseEntity<>(
                    "User has been UPGRADED as ADMIN successfully",
                    HttpStatus.OK);
        } else {
            response = new ResponseEntity<>(
                    "There was problem during updating user details with ADMIN ID: " + user.getAdminUserId(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }
}
