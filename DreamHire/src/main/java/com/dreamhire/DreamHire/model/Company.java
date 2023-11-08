package com.dreamhire.DreamHire.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "companies")
@AllArgsConstructor
@NoArgsConstructor
public class Company extends SystemUser {

    private String name;
    private String logo;

    @Column(columnDefinition = "TEXT")
    private String images;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(length = 4000)
    private String about;

    @Column(length = 4000)
    private String services;

    @Column(length = 4000)
    private String serviceKeys;

    private boolean visible = true;
    private boolean approval = false;
    private boolean payment = false;
    private boolean reject = false;
    private String phone;

    @Column(length = 500)
    private String address;

    @Column(length = 500)
    private String facebook;

    @Column(length = 500)
    private String twitter;

    @Column(length = 500)
    private String linkedIn;

    @Column(length = 500)
    private String registration;
}
