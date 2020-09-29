package com.jatin.expense_tracker.transformers;

import com.jatin.expense_tracker.mo.input.CategoryInputMO;
import com.jatin.expense_tracker.model.Category;
import org.apache.commons.collections4.Transformer;

public class CategoryTransformer implements Transformer<CategoryInputMO, Category> {
    @Override
    public Category transform(CategoryInputMO categoryInputMO) {
        Category category = new Category();
        category.setName(categoryInputMO.getName());
        category.setUserId(categoryInputMO.getUserId());
        return category;
    }
}
