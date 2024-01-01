package com.dreamhire.DreamHire.service.impl;

import com.dreamhire.DreamHire.dto.SystemUserDto;
import com.dreamhire.DreamHire.dto.request.CvCreatorRegisterDto;
import com.dreamhire.DreamHire.exception.DreamHireException;
import com.dreamhire.DreamHire.model.SystemUser;
import com.dreamhire.DreamHire.repository.SystemUserRepo;
import com.dreamhire.DreamHire.service.CvCreatorService;
import com.dreamhire.DreamHire.util.enums.ErrorEnum;
import com.dreamhire.DreamHire.util.enums.UserType;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CvCreatorServiceImpl implements CvCreatorService {

    @Autowired
    private SystemUserRepo systemUserRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public SystemUserDto register(CvCreatorRegisterDto registerDto) {
        if(systemUserRepo.existsByEmailAndUserType(registerDto.getEmail(), "ROLE_" + UserType.CV_CREATOR)){
            throw new DreamHireException(ErrorEnum.ERROR_DUPLICATE_EMAIL,
                    "You are already registered with this email: " +
                            registerDto.getEmail());
        }
        SystemUser cvCreator = new SystemUser();
        cvCreator.setEmail(registerDto.getEmail());
        cvCreator.setUserType("ROLE_" + UserType.CV_CREATOR);
        cvCreator.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        SystemUser savedUser = systemUserRepo.save(cvCreator);
        SystemUserDto systemUserDto = modelMapper.map(savedUser, SystemUserDto.class);
        return systemUserDto;
    }
}
