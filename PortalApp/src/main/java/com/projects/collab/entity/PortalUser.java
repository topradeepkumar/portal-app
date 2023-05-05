package com.projects.collab.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "user")
public class PortalUser {

    @Id
    @Column(name = "phone_number")
    private String phonenumber;

    @Column(name = "first_name")
    private String firstname;

    @Column(name = "middle_name")
    private String middlename;

    @Column(name = "last_name")
    private String lastname;

    @Column(name = "aadhaar")
    private String aadhaar;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    @Column(name = "admin")
    private Boolean admin;
}
