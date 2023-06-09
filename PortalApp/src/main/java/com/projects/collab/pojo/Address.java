package com.projects.collab.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Address {

    @JsonProperty("addressLine1")
    private String addressline1;

    @JsonProperty("addressLine2")
    private String addressline2;

    @JsonProperty("village")
    private String village;

    @JsonProperty("mandal")
    private String mandal;

    @JsonProperty("city")
    private String city;

    @JsonProperty("district")
    private String district;

    @JsonProperty("state")
    private String state;

    @JsonProperty("postalcode")
    private String postalcode;
}
