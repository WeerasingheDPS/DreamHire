package com.dreamhire.DreamHire.service.impl;
import com.dreamhire.DreamHire.dto.CandidateDto;
import com.dreamhire.DreamHire.dto.CompanyDto;
import com.dreamhire.DreamHire.dto.request.CandidateRegisterRequestDto;
import com.dreamhire.DreamHire.exception.NotFoundException;
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
        candidateRepo.save(modelMapper.map(candidateRegisterRequestDto,Candidate.class));
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
}
