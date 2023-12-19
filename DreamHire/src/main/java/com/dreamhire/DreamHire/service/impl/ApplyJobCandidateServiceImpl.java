package com.dreamhire.DreamHire.service.impl;

import com.dreamhire.DreamHire.dto.ApplyJobDto;
import com.dreamhire.DreamHire.exception.DreamHireException;
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
    public ApplyJobDto save(ApplyJobDto applyJobDto, int id) {
        if (applyJobCandidateRepo.existsByCandidateIdAndJobPostId(id, applyJobDto.getJobID())){
            throw new DreamHireException("You have already applied this job!");
        }else {
            ApplyJobCandidate applyJobCandidate = modelMapper.map(applyJobDto,ApplyJobCandidate.class);
            if(jobPostRepo.existsById(applyJobDto.getJobID())){
                applyJobCandidate.setJobPost(jobPostRepo.findById(applyJobDto.getJobID()));
            }else {
                throw new DreamHireException("JobPostId is invalid!");
            }
            if(candidateRepo.existsById(id)){
                applyJobCandidate.setCandidate(candidateRepo.findById(id));
                ApplyJobCandidate savedApplyJobCandidate =  applyJobCandidateRepo.save(applyJobCandidate);
                return modelMapper.map(savedApplyJobCandidate, ApplyJobDto.class);
            }else {
                throw new DreamHireException("CandidateId is invalid!");
            }
        }
    }
}
