package com.dreamhire.DreamHire.service.impl;

import com.dreamhire.DreamHire.dto.request.JobPostRequestDto;
import com.dreamhire.DreamHire.dto.response.JobPostResponseDto;
import com.dreamhire.DreamHire.exception.DreamHireException;
import com.dreamhire.DreamHire.model.JobPost;
import com.dreamhire.DreamHire.repository.CompanyRepo;
import com.dreamhire.DreamHire.repository.JobPostRepo;
import com.dreamhire.DreamHire.service.JobPostService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPostServiceImpl implements JobPostService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private JobPostRepo jobPostRepo;

    @Autowired
    private CompanyRepo companyRepo;

    @Override
    public JobPostResponseDto save(JobPostRequestDto jobPostRequestDto, int id) {
        JobPost jobPost = modelMapper.map(jobPostRequestDto,JobPost.class);
        if(companyRepo.existsById(id)){
            jobPost.setCompany(companyRepo.findById(id));
            JobPost savedJob = jobPostRepo.save(jobPost);
            return modelMapper.map(savedJob, JobPostResponseDto.class);
        }else {
            throw new DreamHireException("Given CompanyId is invalid!");
        }
    }

    @Override
    public List<JobPostResponseDto> getAllJobPosts() {
        List<JobPost> jobs = jobPostRepo.getAllByValidateIsTrue();
        if(jobs.size()>0){
            return modelMapper.map(jobs, new TypeToken<List<JobPostResponseDto>>(){}.getType());
        }else {
            throw new DreamHireException("Valid Jobs Are Not_Found!");
        }
    }

    @Override
    public JobPostResponseDto getJobPost(int id) {
        if(jobPostRepo.existsById(id)){
            JobPost job = jobPostRepo.findById(id);
            return modelMapper.map(job, JobPostResponseDto.class);
        }else {
            throw new DreamHireException("JobPost is Not_Found!");
        }
    }
}
