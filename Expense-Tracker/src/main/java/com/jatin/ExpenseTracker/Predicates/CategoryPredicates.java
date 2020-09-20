package com.jatin.ExpenseTracker.Predicates;

import com.jatin.ExpenseTracker.model.Category;
import com.jatin.ExpenseTracker.repository.ICategoryRepo;
import org.apache.commons.collections4.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryPredicates {

    @Autowired
    private ICategoryRepo categoryRepo;

    public final Predicate<Long> VALID_CATEGORY = userId -> categoryRepo.findById(userId).isPresent();

    public boolean isValidCategory(Category category) {
        return category.getId() != null && VALID_CATEGORY.evaluate(category.getId());
    }

    public boolean isValidCategory(Long categoryId) {
        return VALID_CATEGORY.evaluate(categoryId);
    }
}
