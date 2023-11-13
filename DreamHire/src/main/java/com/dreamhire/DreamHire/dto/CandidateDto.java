package com.dreamhire.DreamHire.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateDto {

    private String title;
    private String email;
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
