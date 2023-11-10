package com.dreamhire.DreamHire.controller;

import com.dreamhire.DreamHire.dto.request.CompanyRegisterRequestDto;
import com.dreamhire.DreamHire.model.Company;
import com.dreamhire.DreamHire.service.CompanyService;
import com.dreamhire.DreamHire.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;
    @PostMapping("/register")
    public ResponseEntity<StandardResponse> register(@RequestBody CompanyRegisterRequestDto companyRegisterRequestDto) {
        String message = companyService.register(companyRegisterRequestDto);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(message, null), HttpStatus.CREATED
        );
    }

    @GetMapping("/get")
    public ResponseEntity<StandardResponse> get(@RequestParam String email) {
        Company company = companyService.get(email);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse("Success", company), HttpStatus.CREATED
        );
    }

}