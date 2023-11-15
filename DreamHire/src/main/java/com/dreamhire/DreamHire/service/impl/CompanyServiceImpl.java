package com.dreamhire.DreamHire.service.impl;

import com.dreamhire.DreamHire.dto.CandidateDto;
import com.dreamhire.DreamHire.dto.CompanyDto;
import com.dreamhire.DreamHire.dto.request.CompanyRegisterRequestDto;
import com.dreamhire.DreamHire.exception.NotFoundException;
import com.dreamhire.DreamHire.model.Candidate;
import com.dreamhire.DreamHire.model.Company;
import com.dreamhire.DreamHire.repository.CompanyRepo;
import com.dreamhire.DreamHire.service.CompanyService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return "Company is Successfully Registered!";
    }

    @Override
    public CompanyDto getCompany(int id) {
        if(companyRepo.existsById(id)){
            return modelMapper.map(companyRepo.findById(id),CompanyDto.class);
        }else {
            throw new NotFoundException("Company is Not_Found!");
        }
    }

    @Override
    public List<CompanyDto> getAllCompanies() {
        List<Company> companies = companyRepo.getAllByVisibleIsTrue();
        if(companies.size()>0){
            return modelMapper.map(companies, new TypeToken<List<CandidateDto>>(){}.getType());
        }else {
            throw new NotFoundException("Companies Are Not_Found!");
        }
    }
}
