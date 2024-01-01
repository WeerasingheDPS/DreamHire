package com.dreamhire.DreamHire.repository;

import com.dreamhire.DreamHire.model.SystemUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface SystemUserRepo extends JpaRepository<SystemUser, Integer> {
    Optional<SystemUser> findByEmail(String email);

    boolean existsByEmailAndUserType(String email, String userType);
}
