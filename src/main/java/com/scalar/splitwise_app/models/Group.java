package com.scalar.splitwise_app.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity(name ="grp")
public class Group extends BaseModel{

    private String name;
    @ManyToMany
    private List<User_person> user_persons;
    @OneToMany(mappedBy = "group")
    private List<Expense> GroupExpense;
    @ManyToOne
    private User_person createdBy;
}
