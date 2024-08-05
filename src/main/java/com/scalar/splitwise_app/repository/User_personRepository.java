package com.scalar.splitwise_app.repository;

import com.scalar.splitwise_app.models.Group;
import com.scalar.splitwise_app.models.User_person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface User_personRepository extends JpaRepository<User_person, Long> {
    @Override
    Optional<User_person> findById(Long id);
}
