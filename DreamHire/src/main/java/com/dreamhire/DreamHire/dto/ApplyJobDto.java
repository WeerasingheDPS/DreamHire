package com.dreamhire.DreamHire.dto;

import com.dreamhire.DreamHire.model.Candidate;
import com.dreamhire.DreamHire.model.Company;
import lombok.Data;

@Data
public class ApplyJobDto {
    private int id;
    private int jobID;
    private String candidateName;
    private String candidatePhone;
    private String candidateEmail;
    private String candidateCity;
    private String tags;
    private String jobTitle;
    private Candidate candidate;
    private Company company;
}
