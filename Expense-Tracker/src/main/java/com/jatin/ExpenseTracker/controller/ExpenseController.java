package com.jatin.ExpenseTracker.controller;

import com.jatin.ExpenseTracker.model.Category;
import com.jatin.ExpenseTracker.model.Expense;
import com.jatin.ExpenseTracker.model.SaveExpenseMO;
import com.jatin.ExpenseTracker.model.User;
import com.jatin.ExpenseTracker.repository.ICategoryRepo;
import com.jatin.ExpenseTracker.repository.IExpenseRepo;
import com.jatin.ExpenseTracker.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class ExpenseController {

    @Autowired
    IExpenseRepo expenseRepo;

    @Autowired
    ICategoryRepo categoryRepo;

    @Autowired
    IUserRepo userRepo;

//    @Autowired
//    IExpenseRepo expenseRepo;
//
//    @PostMapping(value = "/addMultipleExpenses", consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<List<Expense>> addMultipleExpenses(@RequestBody List<Expense> expenses) {
//        expenseRepo.save(expenses.get(0));
//        return new ResponseEntity<>(expenseRepo.saveAll(expenses), HttpStatus.OK);
//    }

    @GetMapping(value = "/getAllExpenses")
    public ResponseEntity<List<SaveExpenseMO>> getAllExpenses(@RequestParam("userId") Long userId) {
        return new ResponseEntity<>(expenseRepo.findAllByUser(userId).stream().map(this::transformExpense).collect(Collectors.toList()), HttpStatus.OK);
    }

    @PostMapping(value = "/save")
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ResponseEntity<Long> save(@RequestBody SaveExpenseMO saveExpenseMO) {
        Expense savedExpense = transformSaveExpenseMO(saveExpenseMO);
        if (savedExpense.getUser() != null && savedExpense.getUser() != null) {
            expenseRepo.save(savedExpense);
            return new ResponseEntity<Long>(savedExpense.getId(), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return new ResponseEntity<>("Hello World!", HttpStatus.OK);
    }

    private Expense transformSaveExpenseMO(SaveExpenseMO saveExpenseMO) {
        Expense expense = new Expense();
        expense.setLocation(saveExpenseMO.getLocation());
        expense.setDescription(saveExpenseMO.getDescription());
        expense.setExpenseInstant(saveExpenseMO.getExpenseInstant());
        Optional<User> user = userRepo.findById(saveExpenseMO.getUserId());
        expense.setUser(user.orElse(null));
        Optional<Category> categoryOption = categoryRepo.findById(saveExpenseMO.getCategoryId());
        expense.setCategory(categoryOption.orElse(null));
        return expense;
    }

    private SaveExpenseMO transformExpense(Expense expense) {
        SaveExpenseMO saveExpenseMO = new SaveExpenseMO();
        saveExpenseMO.setCategoryId(expense.getCategory().getId());
        saveExpenseMO.setDescription(expense.getDescription());
        saveExpenseMO.setExpenseInstant(expense.getExpenseInstant());
        saveExpenseMO.setLocation(expense.getLocation());
        saveExpenseMO.setUserId(expense.getUser().getId());
        return saveExpenseMO;
    }
}
