package com.dreamhire.DreamHire.service;

import com.dreamhire.DreamHire.dto.request.LoginRequest;
import com.dreamhire.DreamHire.dto.response.LoginResponseDto;
import com.dreamhire.DreamHire.model.SystemUser;
import org.springframework.security.core.userdetails.UserDetails;

public interface AuthService {

    String genarateToken(String email);


    void validateToken(String token, UserDetails userDetails);

    SystemUser getUser(String email);

    LoginResponseDto login(LoginRequest loginRequest);
}
