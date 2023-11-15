package com.dreamhire.DreamHire.repository;

import com.dreamhire.DreamHire.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface CandidateRepo extends JpaRepository<Candidate, Integer> {
    Candidate findById(int id);
    boolean existsById(int id);

    List<Candidate> getAllByVisibleIsTrue();
}
