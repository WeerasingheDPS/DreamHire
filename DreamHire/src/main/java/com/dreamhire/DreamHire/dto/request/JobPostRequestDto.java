package com.dreamhire.DreamHire.dto.request;

import lombok.Data;
import java.time.LocalDateTime;
@Data
public class JobPostRequestDto {

    private String jobTitle;
    private String jobType;
    private String experience;
    private String education;
    private LocalDateTime deadline;
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
    private boolean validate = true;
}
