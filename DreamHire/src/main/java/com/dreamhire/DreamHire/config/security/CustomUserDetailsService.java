package com.dreamhire.DreamHire.config.security;

import com.dreamhire.DreamHire.model.SystemUser;
import com.dreamhire.DreamHire.repository.SystemUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private SystemUserRepo systemUserRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<SystemUser> user = systemUserRepo.findByEmail(email);
        return user.map(CustomUserDetails::new).orElseThrow(()-> new UsernameNotFoundException("user not found with email: "+ email));
    }
}
