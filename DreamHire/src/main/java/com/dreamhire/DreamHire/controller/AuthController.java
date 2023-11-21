package com.dreamhire.DreamHire.controller;


import com.dreamhire.DreamHire.dto.request.LoginRequest;
import com.dreamhire.DreamHire.dto.response.LoginResponseDto;
import com.dreamhire.DreamHire.model.SystemUser;
import com.dreamhire.DreamHire.service.AuthService;
import com.dreamhire.DreamHire.util.response.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(path = "api/v1/auth")
public class AuthController {

    @Autowired
    private AuthService authService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @PostMapping( "/login")
    public ResponseEntity<StandardResponse> loginUser(@RequestBody LoginRequest loginRequest){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),loginRequest.getPassword()));
        if(authentication.isAuthenticated()){
            //return "Success";
            String token = authService.genarateToken(loginRequest.getEmail());
            SystemUser user = authService.getUser(loginRequest.getEmail());
            LoginResponseDto loginResponse = new LoginResponseDto(token, user);
            return new ResponseEntity<StandardResponse>(
                    new StandardResponse(true, "success", loginResponse, 200), HttpStatus.OK
            );

        }else {
            throw new RuntimeException("Invalid Access!");
        }
    }

}
