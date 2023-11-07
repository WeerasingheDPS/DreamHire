package com.dreamhire.DreamHire.controller;

import com.dreamhire.DreamHire.dto.request.CandidateRegisterRequestDto;
import com.dreamhire.DreamHire.service.CandidateService;
import com.dreamhire.DreamHire.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/candidate")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @PostMapping("/register")
    public ResponseEntity<StandardResponse> register(@RequestBody CandidateRegisterRequestDto candidateRegisterRequestDto){
        String message = candidateService.register(candidateRegisterRequestDto);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(message,null), HttpStatus.CREATED
        );
    }
}
