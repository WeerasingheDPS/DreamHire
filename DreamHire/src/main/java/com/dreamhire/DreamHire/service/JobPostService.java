package com.dreamhire.DreamHire.service;
import com.dreamhire.DreamHire.dto.request.JobPostRequestDto;
import com.dreamhire.DreamHire.dto.response.JobPostResponseDto;

import java.util.List;

public interface JobPostService {
    String save(JobPostRequestDto jobPostRequestDto, int id);
    List<JobPostResponseDto> getAllJobPosts();

    JobPostResponseDto getJobPost(int id);
}
