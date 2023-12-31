package com.dreamhire.DreamHire.dto.request;

import lombok.Data;

@Data
public class CompanyRegisterRequestDto {

    private int id;
    private String userType;
    private String email;
    private String password;
    private String name;
    private String logo;
    private String images;
    private String description;
    private String about;
    private String services;
    private String serviceKeys;
    private boolean visible = true;
    private boolean approval = false;
    private boolean payment = false;
    private boolean reject = false;
    private String phone;
    private String address;
    private String facebook;
    private String twitter;
    private String linkedIn;
    private String registration;
}
