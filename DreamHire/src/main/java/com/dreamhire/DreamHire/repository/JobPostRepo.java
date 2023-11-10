package com.dreamhire.DreamHire.repository;

import com.dreamhire.DreamHire.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface JobPostRepo extends JpaRepository<JobPost ,Integer> {

    JobPost findById(int id);
}
