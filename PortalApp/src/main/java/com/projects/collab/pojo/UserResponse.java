package com.projects.collab.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserResponse {

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
