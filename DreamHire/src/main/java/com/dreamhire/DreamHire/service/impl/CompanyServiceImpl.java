package com.dreamhire.DreamHire.service.impl;

import com.dreamhire.DreamHire.dto.CandidateDto;
import com.dreamhire.DreamHire.dto.CompanyDto;
import com.dreamhire.DreamHire.dto.request.CompanyRegisterRequestDto;
import com.dreamhire.DreamHire.exception.DreamHireException;
import com.dreamhire.DreamHire.model.Company;
import com.dreamhire.DreamHire.repository.CompanyRepo;
import com.dreamhire.DreamHire.service.CompanyService;
import com.dreamhire.DreamHire.util.enums.ErrorEnum;
import com.dreamhire.DreamHire.util.enums.UserType;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CompanyRepo companyRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public CompanyDto register(CompanyRegisterRequestDto companyRegisterRequestDto) {
        if(companyRepo.existsByEmail(companyRegisterRequestDto.getEmail())){
            throw new DreamHireException(ErrorEnum.ERROR_DUPLICATE_EMAIL,
                    "Company is already registered with this email: " +
                            companyRegisterRequestDto.getEmail());
        }else {
            Company company = modelMapper.map(companyRegisterRequestDto,Company.class);
            company.setPassword(passwordEncoder.encode(companyRegisterRequestDto.getPassword()));
            company.setUserType("ROLE_" + UserType.COMPANY);
            Company savedCompany = companyRepo.save(company);
            return modelMapper.map(savedCompany, CompanyDto.class);
        }
    }

    @Override
    public CompanyDto getCompany(int id) {
        if(companyRepo.existsById(id)){
            return modelMapper.map(companyRepo.findById(id),CompanyDto.class);
        }else {
            throw new DreamHireException("Company is Not_Found!");
        }
    }

    @Override
    public List<CompanyDto> getAllCompanies() {
        List<Company> companies = companyRepo.getAllByVisibleIsTrue();
        if(companies.size()>0){
            return modelMapper.map(companies, new TypeToken<List<CandidateDto>>(){}.getType());
        }else {
            throw new DreamHireException("Companies Are Not_Found!");
        }
    }
}
