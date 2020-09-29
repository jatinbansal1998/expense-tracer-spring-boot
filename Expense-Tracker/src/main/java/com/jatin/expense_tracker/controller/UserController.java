package com.jatin.expense_tracker.controller;

import com.jatin.expense_tracker.mo.input.UserInputMO;
import com.jatin.expense_tracker.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    @Qualifier("userService")
    IUserService userService;

    @GetMapping(value = "/getAllUsers")
    public ResponseEntity getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(value = "/getUser")
    public ResponseEntity getUserById(Long userId) {
        return userService.getUserById(userId);
    }

    @PostMapping(value = "/save")
    public ResponseEntity save(@RequestBody UserInputMO userInputMO) {
        return userService.save(userInputMO);
    }
}
