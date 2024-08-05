package com.scalar.splitwise_app.repository;

import com.scalar.splitwise_app.models.Expense;
import com.scalar.splitwise_app.models.Group;
import com.scalar.splitwise_app.models.User_person;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findAllByGroup(Group group);
}
