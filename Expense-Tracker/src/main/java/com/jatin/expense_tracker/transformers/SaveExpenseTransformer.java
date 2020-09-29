package com.jatin.expense_tracker.transformers;

import com.jatin.expense_tracker.mo.SaveExpenseMO;
import com.jatin.expense_tracker.model.Expense;
import org.apache.commons.collections4.Transformer;

public class SaveExpenseTransformer implements Transformer<Expense, SaveExpenseMO> {
    @Override
    public SaveExpenseMO transform(Expense expense) {
        return SaveExpenseMO.builder()
                .categoryId(expense.getCategoryId())
                .description(expense.getDescription())
                .expenseInstant(expense.getExpenseInstant())
                .location(expense.getLocation())
                .userId(expense.getUserId())
                .id(expense.getId()).build();
    }
}
