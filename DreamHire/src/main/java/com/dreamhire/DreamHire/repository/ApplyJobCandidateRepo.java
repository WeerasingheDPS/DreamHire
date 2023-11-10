package com.dreamhire.DreamHire.repository;

import com.dreamhire.DreamHire.model.ApplyJobCandidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface ApplyJobCandidateRepo extends JpaRepository<ApplyJobCandidate, Integer> {
}
