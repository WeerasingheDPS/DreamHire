package com.dreamhire.DreamHire.dto;

import lombok.Data;

@Data
public class CompanyDto {
    private int id;
    private String email;
    private String name;
    private String logo;
    private String images;
    private String description;
    private String about;
    private String services;
    private String serviceKeys;
    private boolean visible;
    private boolean approval;
    private boolean payment;
    private boolean reject;
    private String phone;
    private String address;
    private String facebook;
    private String twitter;
    private String linkedIn;
    private String registration;
}
