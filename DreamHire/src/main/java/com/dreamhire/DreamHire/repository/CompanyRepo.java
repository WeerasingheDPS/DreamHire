package com.dreamhire.DreamHire.repository;

import com.dreamhire.DreamHire.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface CompanyRepo extends JpaRepository<Company, Integer> {
    Company findByEmail(String email);
    Company findById(int id);
    boolean existsById(int id);
    List<Company> getAllByVisibleIsTrue();
    boolean existsByEmail(String email);

    List<Company> getAllByApprovalIsFalseAndRegistrationIsNotNull();
}
