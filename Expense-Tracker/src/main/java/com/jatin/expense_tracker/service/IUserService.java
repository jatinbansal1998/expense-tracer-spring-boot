package com.jatin.expense_tracker.service;

import com.jatin.expense_tracker.mo.SaveUserMO;
import org.springframework.http.ResponseEntity;

public interface IUserService {
    ResponseEntity getAllUsers();

    ResponseEntity getUserById(Long userId);

    ResponseEntity save(SaveUserMO saveUserMO);
}
