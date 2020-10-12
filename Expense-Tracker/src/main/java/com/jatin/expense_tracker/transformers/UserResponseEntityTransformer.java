package com.jatin.expense_tracker.transformers;

import com.jatin.expense_tracker.model.User;
import com.jatin.expense_tracker.response.vo.UserResponseEntity;
import org.apache.commons.collections4.Transformer;

public class UserResponseEntityTransformer implements Transformer<User, UserResponseEntity> {
    @Override
    public UserResponseEntity transform(User user) {
        return UserResponseEntity.builder()
                .email(user.getEmail())
                .name(user.getName())
                .id(user.getId())
                .build();
    }
}
