package com.dreamhire.DreamHire.service.impl;

import com.dreamhire.DreamHire.model.SystemUser;
import com.dreamhire.DreamHire.repository.SystemUserRepo;
import com.dreamhire.DreamHire.service.AuthService;
import com.dreamhire.DreamHire.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private JwtService jwtService;
    @Autowired
    private SystemUserRepo systemUserRepo;


    @Override
    public String genarateToken(String email) {
        return jwtService.generateToken(email);
    }

    @Override
    public void validateToken(String token, UserDetails userDetails) {
        jwtService.validateToken(token, userDetails);
    }

    @Override
    public SystemUser getUser(String email) {
        SystemUser systemUser = systemUserRepo.findByEmail(email).get();
        return systemUser;
    }
}
