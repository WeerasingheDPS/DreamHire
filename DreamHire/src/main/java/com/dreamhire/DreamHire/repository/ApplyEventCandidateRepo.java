package com.dreamhire.DreamHire.repository;

import com.dreamhire.DreamHire.model.ApplyEventCandidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface ApplyEventCandidateRepo extends JpaRepository<ApplyEventCandidate, Integer> {
}
