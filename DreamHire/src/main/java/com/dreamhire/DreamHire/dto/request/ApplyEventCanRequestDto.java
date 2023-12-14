package com.dreamhire.DreamHire.dto.request;

import lombok.Data;

@Data
public class ApplyEventCanRequestDto {

    private String candidateName;
    private String candidatePhone;
    private String candidateEmail;
    private String candidateAddress;
    private int eventId;
}
