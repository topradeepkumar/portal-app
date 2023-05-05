package com.projects.collab.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class RegistrationUser {

    @JsonProperty("admin_user_id")
    private String adminUserId;

    @JsonProperty("first_name")
    private String firstname;

    @JsonProperty("middle_name")
    private String middlename;

    @JsonProperty("last_name")
    private String lastname;

    @JsonProperty("aadhaar")
    private String aadhaar;

    @JsonProperty("phone_number")
    private String phonenumber;

    @JsonProperty("address")
    private Address address;
}
