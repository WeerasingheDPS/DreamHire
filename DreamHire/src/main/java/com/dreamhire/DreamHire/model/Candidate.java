package com.dreamhire.DreamHire.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "candidates")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Candidate extends SystemUser{

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
