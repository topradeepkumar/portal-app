package com.projects.collab.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Person {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer personid;

    private String firstname;

    private String lastname;

    private String city;

    private String pincode;
}
