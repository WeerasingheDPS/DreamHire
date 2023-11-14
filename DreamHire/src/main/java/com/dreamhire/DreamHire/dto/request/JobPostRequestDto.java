package com.dreamhire.DreamHire.dto.request;

import com.dreamhire.DreamHire.model.Company;
import lombok.Data;

import java.util.Date;

@Data
public class JobPostRequestDto {

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
    private String cover;
    private String currency;
    private String minSalary;
    private String maxSalary;
    private int numberOfVacancies;
}
