package com.jatin.expense_tracker.transformers;

import com.jatin.expense_tracker.mo.input.ExpenseInputMO;
import com.jatin.expense_tracker.model.Expense;
import org.apache.commons.collections4.Transformer;

public class ExpenseTransformer implements Transformer<ExpenseInputMO, Expense> {
    @Override
    public Expense transform(ExpenseInputMO expenseInputMO) {
        Expense expense = new Expense();
        expense.setLocation(expenseInputMO.getLocation());
        expense.setDescription(expenseInputMO.getDescription());
        expense.setExpenseInstant(expenseInputMO.getExpenseInstant());
        expense.setUserId(expenseInputMO.getUserId());
        expense.setCategoryId(expenseInputMO.getCategoryId());
        return expense;
    }
}
