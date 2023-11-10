package com.dreamhire.DreamHire.dto;

import com.dreamhire.DreamHire.model.Company;
import jakarta.persistence.Column;
import lombok.Data;

import java.util.Date;

@Data
public class JobPostDto {
    private int id;
    private String companyName;
    private Date postedDate;
    private String jobTitle;
    private String jobType;
    private String experience;
    private String education;
    private Date deadline;
    private String description;
    private String howToApply;
    private String jobRequirements;
    private String tags;
    private String author;
    private boolean validate;
    private String cover;
    private String currency;
    private String minSalary;
    private String maxSalary;
    private int numberOfVacancies;
}
