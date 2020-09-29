package com.jatin.expense_tracker.transformers;

import com.jatin.expense_tracker.mo.SaveCategoryMO;
import com.jatin.expense_tracker.model.Category;
import org.apache.commons.collections4.Transformer;

public class CategoryTransformer implements Transformer<SaveCategoryMO, Category> {
    @Override
    public Category transform(SaveCategoryMO saveCategoryMO) {
        Category category = new Category();
        category.setName(saveCategoryMO.getName());
        category.setUserId(saveCategoryMO.getUserId());
        return category;
    }
}
