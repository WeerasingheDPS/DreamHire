package com.dreamhire.DreamHire.service;

import com.dreamhire.DreamHire.dto.CompanyDto;
import com.dreamhire.DreamHire.dto.request.CompanyRegisterRequestDto;
import com.dreamhire.DreamHire.model.Company;
import com.dreamhire.DreamHire.model.SystemUser;

import java.util.List;

public interface CompanyService {
    CompanyDto register(CompanyRegisterRequestDto companyRegisterRequestDto);

    CompanyDto getCompany(int id);

    List<CompanyDto> getAllCompanies();
}
