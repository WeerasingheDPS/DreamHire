package com.dreamhire.DreamHire.service;

import com.dreamhire.DreamHire.dto.CandidateDto;
import com.dreamhire.DreamHire.dto.request.CandidateRegisterRequestDto;

public interface CandidateService {
    String register(CandidateRegisterRequestDto candidateRegisterRequestDto);

    CandidateDto getCandidate(int id);
}
