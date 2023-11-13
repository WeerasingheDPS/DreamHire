package com.dreamhire.DreamHire.controller;

import com.dreamhire.DreamHire.dto.JobPostDto;
import com.dreamhire.DreamHire.service.JobPostService;
import com.dreamhire.DreamHire.util.response.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/jobpost")
public class JobPostController {

    @Autowired
    private JobPostService jobPostService;
    @PostMapping("/save/{id}")
    public ResponseEntity<StandardResponse> save(@PathVariable int id, @RequestBody JobPostDto jobPostDto) {
        String message = jobPostService.save(jobPostDto, id);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(true, message, null, 201), HttpStatus.CREATED
        );
    }
}
