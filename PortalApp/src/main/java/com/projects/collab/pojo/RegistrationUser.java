package com.projects.collab.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class RegistrationUser {

    @JsonProperty("adminUserId")
    private String adminUserId;

    @JsonProperty("firstName")
    private String firstname;

    @JsonProperty("middleName")
    private String middlename;

    @JsonProperty("lastName")
    private String lastname;

    @JsonProperty("aadhaar")
    private String aadhaar;

    @JsonProperty("phoneNumber")
    private String phonenumber;

    @JsonProperty("address")
    private Address address;

    @JsonProperty("password")
    private String password;
}
