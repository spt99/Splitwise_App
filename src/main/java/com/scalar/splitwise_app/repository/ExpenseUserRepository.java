package com.scalar.splitwise_app.repository;

import com.scalar.splitwise_app.models.Expense;
import com.scalar.splitwise_app.models.ExpenseUser;
import com.scalar.splitwise_app.models.Group;
import com.scalar.splitwise_app.models.User_person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseUserRepository extends JpaRepository<ExpenseUser, Long> {

    List<ExpenseUser> findAllByUser(User_person user);
}
