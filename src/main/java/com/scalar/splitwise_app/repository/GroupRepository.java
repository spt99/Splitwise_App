package com.scalar.splitwise_app.repository;

import com.scalar.splitwise_app.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GroupRepository extends JpaRepository<Group, Long> {
    @Override
    Optional<Group> findById(Long id);
}
