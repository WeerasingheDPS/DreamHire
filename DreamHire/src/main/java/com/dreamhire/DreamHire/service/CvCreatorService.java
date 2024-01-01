package com.dreamhire.DreamHire.service;

import com.dreamhire.DreamHire.dto.SystemUserDto;
import com.dreamhire.DreamHire.dto.request.CvCreatorRegisterDto;
import com.dreamhire.DreamHire.model.SystemUser;

public interface CvCreatorService {
    SystemUserDto register(CvCreatorRegisterDto registerDto);
}
