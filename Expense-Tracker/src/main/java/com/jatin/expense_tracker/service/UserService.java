package com.jatin.expense_tracker.service;

import com.jatin.expense_tracker.mo.input.UserInputMO;
import com.jatin.expense_tracker.model.User;
import com.jatin.expense_tracker.repository.IUserRepo;
import com.jatin.expense_tracker.transformers.SaveUserMOTransformer;
import com.jatin.expense_tracker.transformers.UserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service("userService")
public class UserService implements IUserService {
    @Autowired
    IUserRepo userRepo;

    @Override
    public ResponseEntity getAllUsers() {
        return new ResponseEntity<>(userRepo.findAll().stream().map(new SaveUserMOTransformer()::transform).collect(Collectors.toList()), HttpStatus.OK);
    }

    @Override
    public ResponseEntity getUserById(Long userId) {
        Optional<User> optionalUser = userRepo.findById(userId);
        ResponseEntity responseEntity;
        if (optionalUser.isPresent())
            responseEntity = new ResponseEntity<>(new SaveUserMOTransformer().transform(optionalUser.get()), HttpStatus.OK);
        else responseEntity = new ResponseEntity<>("User ID not found", HttpStatus.NOT_FOUND);
        return responseEntity;
    }

    @Override
    public ResponseEntity save(UserInputMO userInputMO) {
        User user = new UserTransformer().transform(userInputMO);
        userRepo.save(user);
        return new ResponseEntity(user.getId(), HttpStatus.CREATED);
    }
}
