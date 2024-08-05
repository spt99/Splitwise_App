package com.scalar.splitwise_app.services;

import com.scalar.splitwise_app.models.Expense;
import com.scalar.splitwise_app.models.ExpenseUser;
import com.scalar.splitwise_app.models.Group;
import com.scalar.splitwise_app.models.User_person;
import com.scalar.splitwise_app.repository.ExpenseRepository;
import com.scalar.splitwise_app.repository.ExpenseUserRepository;
import com.scalar.splitwise_app.repository.GroupRepository;
import com.scalar.splitwise_app.repository.User_personRepository;
import com.scalar.splitwise_app.strategies.SettleUpStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SettleUpService {
    private ExpenseRepository expenseRepository;
    private GroupRepository groupRepository;
    private SettleUpStrategy settleUpStrategy;
    private User_personRepository UserRepository;
    private ExpenseUserRepository ExpenseUserRepository;

    @Autowired
    public SettleUpService(ExpenseRepository expenseRepository, GroupRepository groupRepository, ExpenseUserRepository ExpenseUserRepository, User_personRepository UserRepository, SettleUpStrategy settleUpStrategy) {
        this.expenseRepository = expenseRepository;
        this.groupRepository = groupRepository;
        this.settleUpStrategy = settleUpStrategy;
        this.UserRepository = UserRepository;
        this.ExpenseUserRepository = ExpenseUserRepository;
    };
    public List<Expense> settleUpUser(Long userId){
        // get the user from user rep
        // get all expense for particular user
        // settle up expenses using a settling up strategy
        // return expenseToSettleUp

        Optional<User_person> OptionalUser = UserRepository.findById(userId);
        if(OptionalUser.isEmpty()){
            throw new RuntimeException("User not found");
        }
        User_person userPerson= OptionalUser.get();
        List<ExpenseUser> expensesUser = ExpenseUserRepository.findAllByUser(userPerson);
        Set<Expense> expensesSettleUp = new HashSet<>();
        for(ExpenseUser expenseUser : expensesUser){
            expensesSettleUp.add(expenseUser.getExpense());
        }
        List<Expense> ExpensesToReturn = settleUpStrategy.settleUp(expensesSettleUp.stream().toList());
        // I need to add lIST<EXPENSE> to expense class so that
        // I can filter out the expense where this user is involved
        List<Expense> expenseToReturn = new ArrayList<>();
        for(Expense expense : expensesSettleUp){
            for(ExpenseUser expenseUser : expense.getExpenseUsers()){
                if(expenseUser.getUser().equals(userPerson)){
                    expenseToReturn.add(expense);
                    break;
                }
            }
        }

        return ExpensesToReturn;

    }
    public List<Expense> settleUpGroup(Long groupId){
        // get the GROUP from group rep
        // get all expense for particular group
        // settle up expenses using a settling up strategy
        // return expenseToSettleUp
        Optional<Group> OptionalGrp = groupRepository.findById(groupId);
        if(OptionalGrp.isEmpty()){
            throw new RuntimeException("Group not found");
        }
        Group group = OptionalGrp.get();
        List<Expense> expenses = expenseRepository.findAllByGroup(group);
        // we have expenses for required group, now we get dummy expenses to get group settled
        List<Expense> ExpensesToReturn = settleUpStrategy.settleUp(expenses);
        return ExpensesToReturn;

    }
}
