package com.dreamhire.DreamHire.dto.request;

import com.dreamhire.DreamHire.model.Candidate;
import com.dreamhire.DreamHire.model.Company;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.Date;

import static com.fasterxml.jackson.databind.type.LogicalType.DateTime;

@Data
public class ApplyJobCanRequestDto {

    private int jobID;
    @CreatedDate
    private LocalDateTime appliedDate;
    private String candidateName;
    private String candidatePhone;
    private String candidateEmail;
    private String candidateCity;
    private String tags;
    private String jobTitle;
    private Candidate candidate;
}
