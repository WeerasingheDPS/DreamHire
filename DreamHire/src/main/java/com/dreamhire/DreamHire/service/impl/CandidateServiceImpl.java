package com.dreamhire.DreamHire.service.impl;
import com.dreamhire.DreamHire.dto.CandidateDto;
import com.dreamhire.DreamHire.dto.request.CandidateRegisterRequestDto;
import com.dreamhire.DreamHire.exception.DreamHireException;
import com.dreamhire.DreamHire.model.Candidate;
import com.dreamhire.DreamHire.repository.CandidateRepo;
import com.dreamhire.DreamHire.service.CandidateService;
import com.dreamhire.DreamHire.util.enums.ErrorEnum;
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
    public CandidateDto register(CandidateRegisterRequestDto candidateRegisterRequestDto) {
        if(candidateRepo.existsByEmail(candidateRegisterRequestDto.getEmail())){
            throw new DreamHireException(ErrorEnum.ERROR_DUPLICATE_EMAIL,
                    "Candidate is already registered with this email: " +
                            candidateRegisterRequestDto.getEmail());
        }
        Candidate candidate = modelMapper.map(candidateRegisterRequestDto,Candidate.class);
        candidate.setUserType("ROLE_" + UserType.CANDIDATE);
        candidate.setPassword(passwordEncoder.encode(candidateRegisterRequestDto.getPassword()));
        Candidate savedCandidate = candidateRepo.save(candidate);
        return modelMapper.map(savedCandidate, CandidateDto.class) ;
    }

    @Override
    public CandidateDto getCandidate(int id) {
        if(candidateRepo.existsById(id)){
            return modelMapper.map(candidateRepo.findById(id), CandidateDto.class);
        }else {
            throw new DreamHireException("Candidate is Not_Found!");
        }
    }

    @Override
    public List<CandidateDto> getAllCandidates() {
        List<Candidate> candidates = candidateRepo.getAllByVisibleIsTrue();
        if(candidates.size()>0){
            return modelMapper.map(candidates, new TypeToken<List<CandidateDto>>(){}.getType());
        }else {
            throw new DreamHireException("Candidates Are Not_Found!");
        }
    }
}
