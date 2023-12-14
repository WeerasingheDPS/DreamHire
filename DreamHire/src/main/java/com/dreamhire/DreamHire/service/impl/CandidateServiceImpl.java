package com.dreamhire.DreamHire.service.impl;
import com.dreamhire.DreamHire.dto.CandidateDto;
import com.dreamhire.DreamHire.dto.CompanyDto;
import com.dreamhire.DreamHire.dto.request.CandidateRegisterRequestDto;
import com.dreamhire.DreamHire.dto.response.JobPostResponseDto;
import com.dreamhire.DreamHire.exception.NotFoundException;
import com.dreamhire.DreamHire.exception.RejectException;
import com.dreamhire.DreamHire.model.Candidate;
import com.dreamhire.DreamHire.model.JobPost;
import com.dreamhire.DreamHire.repository.CandidateRepo;
import com.dreamhire.DreamHire.service.CandidateService;
import com.dreamhire.DreamHire.util.enums.UserType;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateServiceImpl implements CandidateService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CandidateRepo candidateRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public String register(CandidateRegisterRequestDto candidateRegisterRequestDto) {
        if(candidateRepo.existsByEmail(candidateRegisterRequestDto.getEmail())){
            throw new RejectException("Candidate is already registered");
        }
        Candidate candidate = modelMapper.map(candidateRegisterRequestDto,Candidate.class);
        candidate.setUserType("ROLE_" + UserType.CANDIDATE);
        candidate.setPassword(passwordEncoder.encode(candidateRegisterRequestDto.getPassword()));
        candidateRepo.save(candidate);
        return "Candidate is Successfully Registered!";
    }

    @Override
    public CandidateDto getCandidate(int id) {
        if(candidateRepo.existsById(id)){
            return modelMapper.map(candidateRepo.findById(id), CandidateDto.class);
        }else {
            throw new NotFoundException("Candidate is Not_Found!");
        }
    }

    @Override
    public List<CandidateDto> getAllCandidates() {
        List<Candidate> candidates = candidateRepo.getAllByVisibleIsTrue();
        if(candidates.size()>0){
            return modelMapper.map(candidates, new TypeToken<List<CandidateDto>>(){}.getType());
        }else {
            throw new NotFoundException("Candidates Are Not_Found!");
        }
    }
}
