package com.projects.collab.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserResponse {

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
}
