package com.dreamhire.DreamHire.service;

import com.dreamhire.DreamHire.dto.CandidateDto;
import com.dreamhire.DreamHire.dto.request.CandidateRegisterRequestDto;

import java.util.List;

public interface CandidateService {
    CandidateDto register(CandidateRegisterRequestDto candidateRegisterRequestDto);

    CandidateDto getCandidate(int id);

    List<CandidateDto> getAllCandidates();
}
