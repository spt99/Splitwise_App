package com.scalar.splitwise_app.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity

public class Expense extends BaseModel{
    private String description;
    private double amount;
    @ManyToOne
    private User_person createdBy;
    @Enumerated(EnumType.ORDINAL)
    private ExpenseType expenseType;
    @ManyToOne
    private Group group;
    @OneToMany (mappedBy = "expense")
    private List<ExpenseUser> expenseUsers;
}
