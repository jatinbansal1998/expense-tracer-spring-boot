package com.jatin.expense_tracker.Service;

import com.jatin.expense_tracker.MO.SaveExpenseMO;
import com.jatin.expense_tracker.Predicates.CategoryPredicates;
import com.jatin.expense_tracker.Predicates.UserPredicates;
import com.jatin.expense_tracker.Transformers.ExpenseTransformer;
import com.jatin.expense_tracker.Transformers.SaveExpenseTransformer;
import com.jatin.expense_tracker.model.Expense;
import com.jatin.expense_tracker.repository.ICategoryRepo;
import com.jatin.expense_tracker.repository.IExpenseRepo;
import com.jatin.expense_tracker.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service("expenseService")
public class ExpenseService implements IExpenseService {
    @Autowired
    IExpenseRepo expenseRepo;

    @Autowired
    ICategoryRepo categoryRepo;

    @Autowired
    IUserRepo userRepo;

    @Autowired
    UserPredicates userPredicates;

    @Autowired
    CategoryPredicates categoryPredicates;

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ResponseEntity save(SaveExpenseMO saveExpenseMO) {
        if (!userPredicates.isValidUser(saveExpenseMO.getUserId()))
            return new ResponseEntity<>("User Id Not found", HttpStatus.NOT_FOUND);
        if (!categoryPredicates.doesCategoryExist(saveExpenseMO.getCategoryId()))
            return new ResponseEntity<>("Category Id not found", HttpStatus.NOT_FOUND);
        Expense savedExpense = new ExpenseTransformer().transform(saveExpenseMO);
        expenseRepo.save(savedExpense);
        return new ResponseEntity(savedExpense.getId(), HttpStatus.CREATED);
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ResponseEntity addMultipleExpenses(List<SaveExpenseMO> saveExpenseMOS) {
        final Predicate<Expense> saveExpenseMOCategoryPredicate = expense -> expense.getCategoryId() != null;
        final Predicate<Expense> saveExpenseMOUserPredicate = expense -> expense.getUserId() != null;
        final Predicate<Expense> validUserPredicate = expense -> userPredicates.isValidUser(expense.getUserId());
        final Predicate<Expense> validCategoryPredicate = expense -> categoryPredicates.doesCategoryExist(expense.getCategoryId());
        final List<Expense> validExpenseList = saveExpenseMOS.stream()
                .map(new ExpenseTransformer()::transform)
                .filter(validUserPredicate)
                .filter(validCategoryPredicate)
                .filter(saveExpenseMOUserPredicate)
                .filter(saveExpenseMOCategoryPredicate)
                .collect(Collectors.toList());
        return new ResponseEntity(expenseRepo.saveAll(validExpenseList), HttpStatus.OK);
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ResponseEntity getAllExpenses(Long userId) {
        ResponseEntity responseEntity;
        if (userPredicates.isValidUser(userId)) {
            responseEntity = new ResponseEntity(
                    expenseRepo.findAllByUser(userId).stream()
                            .map(new SaveExpenseTransformer()::transform)
                            .collect(Collectors.toList())
                    , HttpStatus.OK);
        } else responseEntity = new ResponseEntity<>("User Id not found", HttpStatus.NOT_FOUND);
        return responseEntity;
    }
}