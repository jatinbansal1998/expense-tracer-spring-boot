package com.jatin.ExpenseTracker.Transformers;

import com.jatin.ExpenseTracker.MO.SaveExpenseMO;
import com.jatin.ExpenseTracker.model.Expense;
import org.apache.commons.collections4.Transformer;

public class ExpenseTransformer implements Transformer<SaveExpenseMO, Expense> {
    @Override
    public Expense transform(SaveExpenseMO saveExpenseMO) {
        Expense expense = new Expense();
        expense.setLocation(saveExpenseMO.getLocation());
        expense.setDescription(saveExpenseMO.getDescription());
        expense.setExpenseInstant(saveExpenseMO.getExpenseInstant());
        expense.setUserId(saveExpenseMO.getUserId());
        expense.setCategoryId(saveExpenseMO.getCategoryId());
        return expense;
    }
}
