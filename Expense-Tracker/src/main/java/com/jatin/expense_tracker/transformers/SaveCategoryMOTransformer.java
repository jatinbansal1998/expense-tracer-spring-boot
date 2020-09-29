package com.jatin.expense_tracker.transformers;

import com.jatin.expense_tracker.mo.output.SaveCategoryMO;
import com.jatin.expense_tracker.model.Category;
import org.apache.commons.collections4.Transformer;

public class SaveCategoryMOTransformer implements Transformer<Category, SaveCategoryMO> {
    @Override
    public SaveCategoryMO transform(Category category) {
        return SaveCategoryMO.builder()
                .id(category.getId())
                .name(category.getName())
                .userId(category.getUserId()).build();
    }
}
