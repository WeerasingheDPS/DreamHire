package com.dreamhire.DreamHire.service.impl;

import com.dreamhire.DreamHire.dto.request.CompanyRegisterRequestDto;
import com.dreamhire.DreamHire.model.Company;
import com.dreamhire.DreamHire.repository.CompanyRepo;
import com.dreamhire.DreamHire.service.CompanyService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CompanyRepo companyRepo;
    @Override
    public String register(CompanyRegisterRequestDto companyRegisterRequestDto) {
        Company company = modelMapper.map(companyRegisterRequestDto,Company.class);
        companyRepo.save(company);
        return "Successfully Registered!";
    }

    @Override
    public Company get(String email) {
        Company company = companyRepo.findByEmail(email);
        return company;
    }
}
