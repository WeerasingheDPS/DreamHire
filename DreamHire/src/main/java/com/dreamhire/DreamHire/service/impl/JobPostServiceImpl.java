package com.dreamhire.DreamHire.service.impl;

import com.dreamhire.DreamHire.dto.JobPostDto;
import com.dreamhire.DreamHire.dto.request.CompanyRegisterRequestDto;
import com.dreamhire.DreamHire.model.JobPost;
import com.dreamhire.DreamHire.repository.CompanyRepo;
import com.dreamhire.DreamHire.repository.JobPostRepo;
import com.dreamhire.DreamHire.service.JobPostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobPostServiceImpl implements JobPostService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private JobPostRepo jobPostRepo;

    @Autowired
    private CompanyRepo companyRepo;

    @Override
    public String save(JobPostDto jobPostDto, int id) {
        JobPost jobPost = modelMapper.map(jobPostDto,JobPost.class);
        jobPost.setCompany(companyRepo.findById(id));
        jobPostRepo.save(jobPost);
        return "Successfully Saved!";
    }
}
