package com.dreamhire.DreamHire.service.impl;

import com.dreamhire.DreamHire.dto.CandidateDto;
import com.dreamhire.DreamHire.dto.CompanyDto;
import com.dreamhire.DreamHire.dto.SystemUserDto;
import com.dreamhire.DreamHire.dto.request.CompanyRegisterRequestDto;
import com.dreamhire.DreamHire.exception.DreamHireException;
import com.dreamhire.DreamHire.model.Company;
import com.dreamhire.DreamHire.repository.CompanyRepo;
import com.dreamhire.DreamHire.repository.SystemUserRepo;
import com.dreamhire.DreamHire.service.CompanyService;
import com.dreamhire.DreamHire.util.enums.ErrorEnum;
import com.dreamhire.DreamHire.util.enums.UserType;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.dreamhire.DreamHire.util.enums.ErrorEnum.ERROR_NOT_FOUND;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CompanyRepo companyRepo;
    @Autowired
    private SystemUserRepo systemUserRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public CompanyDto register(CompanyRegisterRequestDto companyRegisterRequestDto) {
        if(systemUserRepo.existsByEmailAndUserType(companyRegisterRequestDto.getEmail(), "ROLE_" + UserType.COMPANY)){
            throw new DreamHireException(ErrorEnum.ERROR_DUPLICATE_EMAIL,
                    "Company has been already registered with this email: " +
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
        }else throw new DreamHireException(ERROR_NOT_FOUND, "Company is Not_Found with this id: " + id);

    }

    @Override
    public List<CompanyDto> getAllCompanies() {
        List<Company> companies = companyRepo.getAllByVisibleIsTrue();
        if(companies.size()>0){
            return modelMapper.map(companies, new TypeToken<List<CompanyDto>>(){}.getType());
        }else throw new DreamHireException(ERROR_NOT_FOUND, "Companies Are Not_Found!");
    }

    @Override
    public String saveBr(int id, String businessReport) {
        if(companyRepo.existsById(id)){
            Company company = companyRepo.findById(id);
            company.setRegistration(businessReport);
            companyRepo.save(company);
            return "Business report id successfully uploaded";
        }else throw new DreamHireException(ERROR_NOT_FOUND, "Company is not found with this id: " + id);
    }

    @Override
    public List<CompanyDto> getPendingApprovalCompanies() {
        List<Company> companies = companyRepo.getAllByApprovalIsFalseAndRegistrationIsNotNull();

        if(companies.size()>0){
            List<CompanyDto> companyDtos = modelMapper.map(companies, new TypeToken<List<CompanyDto>>(){}.getType());
            return companyDtos;
        }else throw new DreamHireException(ERROR_NOT_FOUND, "Pending approval request is not found!");
    }
}
