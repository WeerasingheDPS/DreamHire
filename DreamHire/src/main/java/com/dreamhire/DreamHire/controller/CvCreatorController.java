package com.dreamhire.DreamHire.controller;

import com.dreamhire.DreamHire.dto.CompanyDto;
import com.dreamhire.DreamHire.dto.SystemUserDto;
import com.dreamhire.DreamHire.dto.request.CompanyRegisterRequestDto;
import com.dreamhire.DreamHire.dto.request.CvCreatorRegisterDto;
import com.dreamhire.DreamHire.model.SystemUser;
import com.dreamhire.DreamHire.service.CvCreatorService;
import com.dreamhire.DreamHire.util.constant.UrlConstant;
import com.dreamhire.DreamHire.util.response.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(path = UrlConstant.V1_CV_CREATOR)
public class CvCreatorController {

    @Autowired
    private CvCreatorService cvCreatorService;

    @PostMapping("/register")
    public ResponseEntity<StandardResponse> register(@RequestBody CvCreatorRegisterDto registerDto) {
        SystemUserDto cvCreator = cvCreatorService.register(registerDto);
        return new ResponseEntity<StandardResponse>(
                StandardResponse
                        .builder()
                        .result(cvCreator)
                        .success(true)
                        .build(), HttpStatus.CREATED
        );
    }
}
