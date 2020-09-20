package com.jatin.ExpenseTracker.Service;

import com.jatin.ExpenseTracker.MO.SaveExpenseMO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IExpenseService {
    ResponseEntity save(SaveExpenseMO saveExpenseMO);

    ResponseEntity addMultipleExpenses(List<SaveExpenseMO> saveExpenseMOS);

    ResponseEntity getAllExpenses(Long userId);
}
