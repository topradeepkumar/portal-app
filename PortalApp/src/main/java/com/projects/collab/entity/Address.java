package com.projects.collab.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long addressId;

    @Column(name = "address_line1")
    private String addressline1;

    @Column(name = "address_line2")
    private String addressline2;

    @Column(name = "village")
    private String village;

    @Column(name = "mandal")
    private String mandal;

    @Column(name = "city")
    private String city;

    @Column(name = "district")
    private String district;

    @Column(name = "state")
    private String state;

    @Column(name = "postalcode")
    private String postalcode;
}
