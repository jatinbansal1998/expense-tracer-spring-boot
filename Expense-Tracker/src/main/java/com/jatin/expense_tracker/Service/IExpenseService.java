package com.jatin.expense_tracker.Service;

import com.jatin.expense_tracker.MO.SaveExpenseMO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IExpenseService {
    ResponseEntity save(SaveExpenseMO saveExpenseMO);

    ResponseEntity addMultipleExpenses(List<SaveExpenseMO> saveExpenseMOS);

    ResponseEntity getAllExpenses(Long userId);
}
