package com.jatin.expense_tracker.transformers;

import com.jatin.expense_tracker.mo.SaveUserMO;
import com.jatin.expense_tracker.model.User;
import org.apache.commons.collections4.Transformer;

public class UserTransformer implements Transformer<SaveUserMO, User> {
    @Override
    public User transform(SaveUserMO saveUserMO) {
        User user = new User();
        user.setEmail(saveUserMO.getEmail());
        user.setName(saveUserMO.getName());
        return user;
    }
}
