package com.dreamhire.DreamHire.service.impl;

import com.dreamhire.DreamHire.dto.ApplyJobDto;
import com.dreamhire.DreamHire.model.ApplyJobCandidate;
import com.dreamhire.DreamHire.repository.ApplyJobCandidateRepo;
import com.dreamhire.DreamHire.repository.CandidateRepo;
import com.dreamhire.DreamHire.repository.JobPostRepo;
import com.dreamhire.DreamHire.service.ApplyJobCandidateService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplyJobCandidateServiceImpl implements ApplyJobCandidateService {
    @Autowired
    private ApplyJobCandidateRepo applyJobCandidateRepo;
    @Autowired
    private CandidateRepo candidateRepo;
    @Autowired
    private JobPostRepo jobPostRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public String save(ApplyJobDto applyJobDto, int id) {
        ApplyJobCandidate applyJobCandidate = modelMapper.map(applyJobDto,ApplyJobCandidate.class);
        applyJobCandidate.setJobPost(jobPostRepo.findById(applyJobDto.getJobID()));
        applyJobCandidate.setCandidate(candidateRepo.findById(id));
        applyJobCandidateRepo.save(applyJobCandidate);
        return "Successfully Saved!";
    }
}
