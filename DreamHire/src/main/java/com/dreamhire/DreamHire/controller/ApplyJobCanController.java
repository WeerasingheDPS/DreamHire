package com.dreamhire.DreamHire.controller;

import com.dreamhire.DreamHire.dto.ApplyJobDto;
import com.dreamhire.DreamHire.service.ApplyJobCandidateService;
import com.dreamhire.DreamHire.util.response.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/applyjobcandidate")
public class ApplyJobCanController {

    @Autowired
    private ApplyJobCandidateService applyJobCandidateService;

    @PostMapping("/save/{id}")
    public ResponseEntity<StandardResponse> save(@PathVariable int id, @RequestBody ApplyJobDto applyJobDto){
        String message = applyJobCandidateService.save(applyJobDto, id);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(true, message, null, 201), HttpStatus.CREATED
        );
    }
}
