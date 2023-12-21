package com.dreamhire.DreamHire.dto;

import com.dreamhire.DreamHire.model.Candidate;
import com.dreamhire.DreamHire.model.Company;
import com.dreamhire.DreamHire.model.Event;
import lombok.Data;

@Data
public class ApplyEventDto {

    private int id;

    private Event event;

    private Candidate candidate;

    private String candidateName;

    private String candidatePhone;

    private String candidateEmail;

    private String candidateAddress;

    private Company company;
}
