package com.jatin.expense_tracker.transformers;

import com.jatin.expense_tracker.model.Category;
import com.jatin.expense_tracker.response.vo.CategoryResponseEntity;
import org.apache.commons.collections4.Transformer;

public class CategoryResponseEntityTransformer implements Transformer<Category, CategoryResponseEntity> {
    @Override
    public CategoryResponseEntity transform(Category category) {
        return CategoryResponseEntity.builder()
                .id(category.getId())
                .name(category.getName())
                .userId(category.getUserId()).build();
    }
}
