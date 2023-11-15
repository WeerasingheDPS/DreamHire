package com.dreamhire.DreamHire.controller;

import com.dreamhire.DreamHire.dto.CandidateDto;
import com.dreamhire.DreamHire.dto.request.CandidateRegisterRequestDto;
import com.dreamhire.DreamHire.service.CandidateService;
import com.dreamhire.DreamHire.util.response.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
                new StandardResponse(true, message, null, 201), HttpStatus.CREATED
        );
    }
    @GetMapping("/{id}")
    public ResponseEntity<StandardResponse> getCandidate(@PathVariable int id){
        CandidateDto candidate = candidateService.getCandidate(id);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(true, "success", candidate, 200), HttpStatus.OK
        );
    }

    @GetMapping
    public ResponseEntity<StandardResponse> getAllCandidates(){
        List<CandidateDto> candidates = candidateService.getAllCandidates();
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(true, "success", candidates, 200), HttpStatus.OK
        );
    }

}
