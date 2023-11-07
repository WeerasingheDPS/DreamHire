package com.dreamhire.DreamHire.dto.request;

import lombok.Data;

import java.util.Date;

@Data
public class CandidateRegisterRequestDto {
    private int id;
    private String userType;
    private String email;
    private String password;
    private String title;
    private Date birthday;
    private String city;
    private String name;
    private boolean visible = true;
    private String profilePicture;
    private String description;
    private String phone;
    private String address;
    private String facebook;
    private String twitter;
    private String linkedIn;
    private String currency;
    private String minSalary;
    private String maxSalary;
}
