package com.jatin.expense_tracker.Predicates;

import com.jatin.expense_tracker.model.Category;
import com.jatin.expense_tracker.repository.ICategoryRepo;
import org.apache.commons.collections4.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryPredicates {

    @Autowired
    private ICategoryRepo categoryRepo;

    public final Predicate<Long> CATEGORY_EXISTS = userId -> categoryRepo.findById(userId).isPresent();

    public boolean doesCategoryExist(Category category) {
        return category.getId() != null && CATEGORY_EXISTS.evaluate(category.getId());
    }

    public boolean doesCategoryExist(Long categoryId) {
        return CATEGORY_EXISTS.evaluate(categoryId);
    }
}
