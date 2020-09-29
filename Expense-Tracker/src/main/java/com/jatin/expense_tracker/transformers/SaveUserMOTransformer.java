package com.jatin.expense_tracker.transformers;

import com.jatin.expense_tracker.mo.output.SaveUserMO;
import com.jatin.expense_tracker.model.User;
import org.apache.commons.collections4.Transformer;

public class SaveUserMOTransformer implements Transformer<User, SaveUserMO> {
    @Override
    public SaveUserMO transform(User user) {
        return SaveUserMO.builder()
                .email(user.getEmail())
                .name(user.getName())
                .id(user.getId())
                .build();
    }
}
