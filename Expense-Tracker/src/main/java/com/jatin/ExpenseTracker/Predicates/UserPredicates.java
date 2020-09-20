package com.jatin.ExpenseTracker.Predicates;

import com.jatin.ExpenseTracker.model.User;
import com.jatin.ExpenseTracker.repository.IUserRepo;
import org.apache.commons.collections4.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserPredicates {

    @Autowired
    private IUserRepo userRepo;

    private final Predicate<Long> VALID_USER = userId -> userRepo.findById(userId).isPresent();

    public boolean isValidUser(User user) {
        return user.getId() != null && VALID_USER.evaluate(user.getId());
    }

    public boolean isValidUser(Long userId) {
        return VALID_USER.evaluate(userId);
    }
}
