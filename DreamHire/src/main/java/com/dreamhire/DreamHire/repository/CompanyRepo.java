package com.dreamhire.DreamHire.repository;

import com.dreamhire.DreamHire.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface CompanyRepo extends JpaRepository<Company, Integer> {
    Company findByEmail(String email);
}
