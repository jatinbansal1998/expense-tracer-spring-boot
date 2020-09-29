package com.jatin.expense_tracker.service;

import com.jatin.expense_tracker.mo.input.ExpenseInputMO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IExpenseService {
    ResponseEntity save(ExpenseInputMO saveExpenseMO);

    ResponseEntity addMultipleExpenses(List<ExpenseInputMO> saveExpenseMOS);

    ResponseEntity getAllExpenses(Long userId);
}
