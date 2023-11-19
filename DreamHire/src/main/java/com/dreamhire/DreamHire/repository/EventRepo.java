package com.dreamhire.DreamHire.repository;

import com.dreamhire.DreamHire.model.Event;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface EventRepo extends JpaRepository<Event, Integer> {
    Event findById(int id);
    boolean existsById(int id);
}
