package com.dreamhire.DreamHire.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "candidates")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Candidate extends SystemUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private Date birthday;
    private String city;
    private String name;
    private boolean visible = true;
    private String profilePicture;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String phone;

    @Column(length = 500)
    private String address;

    @Column(length = 500)
    private String facebook;

    @Column(length = 500)
    private String twitter;

    @Column(length = 500)
    private String linkedIn;

    private String currency;
    private String minSalary;
    private String maxSalary;
}
