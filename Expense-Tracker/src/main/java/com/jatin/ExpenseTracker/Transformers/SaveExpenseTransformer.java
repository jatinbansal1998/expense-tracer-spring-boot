package com.jatin.ExpenseTracker.Transformers;

import com.jatin.ExpenseTracker.MO.SaveExpenseMO;
import com.jatin.ExpenseTracker.model.Expense;
import org.apache.commons.collections4.Transformer;

public class SaveExpenseTransformer implements Transformer<Expense, SaveExpenseMO> {
    @Override
    public SaveExpenseMO transform(Expense expense) {
        SaveExpenseMO saveExpenseMO = SaveExpenseMO.builder()
                .categoryId(expense.getCategoryId())
                .description(expense.getDescription())
                .expenseInstant(expense.getExpenseInstant())
                .location(expense.getLocation())
                .userId(expense.getUserId())
                .id(expense.getId()).build();
        return saveExpenseMO;
    }
}
