package com.projects.collab.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
public class PersonData {

    @JsonProperty("person_id")
    private Integer personId;

    @JsonProperty("first_name")
    private String firstname;

    @JsonProperty("last_name")
    private String lastname;

    @JsonProperty("city")
    private String city;

    @JsonProperty("pincode")
    private String pincode;
}
