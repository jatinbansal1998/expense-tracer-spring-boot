package com.jatin.expense_tracker.transformers;

import com.jatin.expense_tracker.mo.input.UserInputMO;
import com.jatin.expense_tracker.model.User;
import org.apache.commons.collections4.Transformer;

public class UserTransformer implements Transformer<UserInputMO, User> {
    @Override
    public User transform(UserInputMO userInputMO) {
        User user = new User();
        user.setEmail(userInputMO.getEmail());
        user.setName(userInputMO.getName());
        return user;
    }
}
