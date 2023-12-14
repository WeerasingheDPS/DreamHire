package com.dreamhire.DreamHire.controller;

import com.dreamhire.DreamHire.dto.request.JobPostRequestDto;
import com.dreamhire.DreamHire.dto.response.JobPostResponseDto;
import com.dreamhire.DreamHire.service.JobPostService;
import com.dreamhire.DreamHire.util.response.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/jobpost")
public class JobPostController {

    @Autowired
    private JobPostService jobPostService;
    @PreAuthorize("hasAnyRole('COMPANY', 'ACCOUNT')")
    @PostMapping("/save/{id}")
    public ResponseEntity<StandardResponse> save(@PathVariable int id, @RequestBody JobPostRequestDto jobPostRequestDto) {
        String message = jobPostService.save(jobPostRequestDto, id);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(true, message, null, 201), HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<StandardResponse> getAllJobPosts(){
        List<JobPostResponseDto> jobPosts = jobPostService.getAllJobPosts();
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(true, "Success", jobPosts, 200), HttpStatus.OK
        );
    }

    @GetMapping(value = "/get/{id}")
    public ResponseEntity<StandardResponse> getJobPost(@PathVariable int id){
        JobPostResponseDto jobPost = jobPostService.getJobPost(id);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(true, "Success", jobPost, 200), HttpStatus.OK
        );
    }
}
