package com.jatin.ExpenseTracker.controller;

import com.jatin.ExpenseTracker.MO.SaveExpenseMO;
import com.jatin.ExpenseTracker.Service.IExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expense")
public class ExpenseController {

    @Autowired
    @Qualifier("expenseService")
    IExpenseService expenseService;

    @PostMapping(value = "/addMultipleExpenses")
    public ResponseEntity addMultipleExpenses(@RequestBody List<SaveExpenseMO> saveExpenseMOS) {
        return expenseService.addMultipleExpenses(saveExpenseMOS);
    }

    @GetMapping(value = "/getAllExpenses")
    public ResponseEntity getAllExpenses(@RequestParam("userId") Long userId) {
        return expenseService.getAllExpenses(userId);
    }

    @PostMapping(value = "/save")
    public ResponseEntity save(@RequestBody SaveExpenseMO saveExpenseMO) {
        return expenseService.save(saveExpenseMO);
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return new ResponseEntity<>("Hello World!", HttpStatus.OK);
    }
}
