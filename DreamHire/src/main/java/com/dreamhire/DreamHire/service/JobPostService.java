package com.dreamhire.DreamHire.service;

import com.dreamhire.DreamHire.dto.JobPostDto;
import com.dreamhire.DreamHire.dto.request.CompanyRegisterRequestDto;

public interface JobPostService {
    String save(JobPostDto jobPostDto, int id);
}
