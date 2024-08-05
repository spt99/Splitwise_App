package com.scalar.splitwise_app.dtos;

import com.scalar.splitwise_app.models.Expense;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter@Setter
public class SettleUpResponseDto {
    List<Expense> expenses;

}
