package com.dreamhire.DreamHire.service.impl;
import com.dreamhire.DreamHire.dto.request.LoginRequest;
import com.dreamhire.DreamHire.dto.response.LoginResponseDto;
import com.dreamhire.DreamHire.model.SystemUser;
import com.dreamhire.DreamHire.repository.SystemUserRepo;
import com.dreamhire.DreamHire.service.AuthService;
import com.dreamhire.DreamHire.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private JwtService jwtService;
    @Autowired
    private SystemUserRepo systemUserRepo;
    @Autowired
    private AuthenticationManager authenticationManager;

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
        return systemUserRepo.findByEmail(email).get();
    }

    @Override
    public LoginResponseDto login(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(), loginRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            String token = genarateToken(loginRequest.getEmail());
            SystemUser user = getUser(loginRequest.getEmail());
            return new LoginResponseDto(token, user);
        }else{
            throw new RuntimeException("Invalid email or password!");
        }
    }
}
