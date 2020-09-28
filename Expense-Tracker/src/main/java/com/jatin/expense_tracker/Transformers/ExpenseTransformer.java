package com.jatin.expense_tracker.Transformers;

import com.jatin.expense_tracker.MO.SaveExpenseMO;
import com.jatin.expense_tracker.model.Expense;
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
