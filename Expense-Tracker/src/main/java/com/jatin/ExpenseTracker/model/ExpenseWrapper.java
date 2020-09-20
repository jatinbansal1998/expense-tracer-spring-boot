package com.jatin.ExpenseTracker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseWrapper {
    private List<Expense> expenses;
}
