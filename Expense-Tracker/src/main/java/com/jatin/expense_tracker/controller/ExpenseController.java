package com.jatin.expense_tracker.controller;

import com.jatin.expense_tracker.mo.input.ExpenseInputMO;
import com.jatin.expense_tracker.service.IExpenseService;
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
    public ResponseEntity addMultipleExpenses(@RequestBody List<ExpenseInputMO> expenseInputMOS) {
        return expenseService.addMultipleExpenses(expenseInputMOS);
    }

    @GetMapping(value = "/getAllExpenses")
    public ResponseEntity getAllExpenses(@RequestParam("userId") Long userId) {
        return expenseService.getAllExpenses(userId);
    }

    @PostMapping(value = "/save")
    public ResponseEntity save(@RequestBody ExpenseInputMO expenseInputMO) {
        return expenseService.save(expenseInputMO);
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return new ResponseEntity<>("Hello World!", HttpStatus.OK);
    }
}
