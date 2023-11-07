package com.dreamhire.DreamHire.service.impl;
import com.dreamhire.DreamHire.dto.request.CandidateRegisterRequestDto;
import com.dreamhire.DreamHire.model.Candidate;
import com.dreamhire.DreamHire.repository.CandidateRepo;
import com.dreamhire.DreamHire.service.CandidateService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidateServiceImpl implements CandidateService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CandidateRepo candidateRepo;
    @Override
    public String register(CandidateRegisterRequestDto candidateRegisterRequestDto) {
        Candidate candidate = modelMapper.map(candidateRegisterRequestDto,Candidate.class);
        candidateRepo.save(candidate);
        return "Successfully Registered!";
    }
}
