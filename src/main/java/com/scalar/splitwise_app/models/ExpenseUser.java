package com.scalar.splitwise_app.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

@Getter
@Setter
@Entity
public class ExpenseUser extends BaseModel{
    @ManyToOne
    private Expense expense;
    @ManyToOne
    private User_person user;
    private double amount;
    @Enumerated(EnumType.ORDINAL)
    private ExpenseUserType expense_type;
}
