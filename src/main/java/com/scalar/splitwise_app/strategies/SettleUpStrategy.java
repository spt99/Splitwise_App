package com.scalar.splitwise_app.strategies;

import com.scalar.splitwise_app.models.Expense;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface SettleUpStrategy {
    public List<Expense> settleUp(List<Expense> expenses);
}
