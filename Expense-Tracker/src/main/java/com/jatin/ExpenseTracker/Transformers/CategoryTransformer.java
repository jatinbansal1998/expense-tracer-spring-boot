package com.jatin.ExpenseTracker.Transformers;

import com.jatin.ExpenseTracker.MO.SaveCategoryMO;
import com.jatin.ExpenseTracker.model.Category;
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
