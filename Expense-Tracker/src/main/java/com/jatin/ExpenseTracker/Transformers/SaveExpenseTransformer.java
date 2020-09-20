package com.jatin.ExpenseTracker.Transformers;

import com.jatin.ExpenseTracker.MO.SaveExpenseMO;
import com.jatin.ExpenseTracker.model.Expense;
import org.apache.commons.collections4.Transformer;

public class SaveExpenseTransformer implements Transformer<Expense, SaveExpenseMO> {
    @Override
    public SaveExpenseMO transform(Expense expense) {
        SaveExpenseMO saveExpenseMO = new SaveExpenseMO();
        saveExpenseMO.setCategoryId(expense.getCategoryId());
        saveExpenseMO.setDescription(expense.getDescription());
        saveExpenseMO.setExpenseInstant(expense.getExpenseInstant());
        saveExpenseMO.setLocation(expense.getLocation());
        saveExpenseMO.setUserId(expense.getUserId());
        return saveExpenseMO;
    }
}
