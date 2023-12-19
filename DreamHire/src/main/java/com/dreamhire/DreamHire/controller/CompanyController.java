package com.dreamhire.DreamHire.controller;

import com.dreamhire.DreamHire.dto.CompanyDto;
import com.dreamhire.DreamHire.dto.request.CompanyRegisterRequestDto;
import com.dreamhire.DreamHire.model.Company;
import com.dreamhire.DreamHire.service.CompanyService;
import com.dreamhire.DreamHire.util.response.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;
    @PostMapping("/register")
    public ResponseEntity<StandardResponse> register(@RequestBody CompanyRegisterRequestDto companyRegisterRequestDto) {
        CompanyDto company = companyService.register(companyRegisterRequestDto);
        return new ResponseEntity<StandardResponse>(
                StandardResponse
                        .builder()
                        .result(company)
                        .success(true)
                        .build(), HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<StandardResponse> get(@PathVariable int id) {
        CompanyDto company = companyService.getCompany(id);
        return new ResponseEntity<StandardResponse>(
                StandardResponse
                        .builder()
                        .result(company)
                        .success(true)
                        .build(), HttpStatus.OK
        );
    }

    @GetMapping
    public ResponseEntity<StandardResponse> getAllCompanies() {
        List<CompanyDto> companies = companyService.getAllCompanies();
        return new ResponseEntity<StandardResponse>(
                StandardResponse
                        .builder()
                        .result(companies)
                        .success(true)
                        .build(), HttpStatus.OK
        );
    }

}