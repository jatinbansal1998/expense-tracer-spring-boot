package com.jatin.expense_tracker.transformers;

import com.jatin.expense_tracker.model.Expense;
import com.jatin.expense_tracker.response.vo.ExpenseResponseEntity;
import org.apache.commons.collections4.Transformer;

public class ExpenseResponseEntityTransformer implements Transformer<Expense, ExpenseResponseEntity> {
    @Override
    public ExpenseResponseEntity transform(Expense expense) {
        return ExpenseResponseEntity.builder()
                .categoryId(expense.getCategoryId())
                .description(expense.getDescription())
                .expenseInstant(expense.getExpenseInstant())
                .location(expense.getLocation())
                .userId(expense.getUserId())
                .id(expense.getId()).build();
    }
}
