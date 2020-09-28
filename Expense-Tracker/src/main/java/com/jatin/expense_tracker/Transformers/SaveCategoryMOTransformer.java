package com.jatin.expense_tracker.Transformers;

import com.jatin.expense_tracker.MO.SaveCategoryMO;
import com.jatin.expense_tracker.model.Category;
import org.apache.commons.collections4.Transformer;

public class SaveCategoryMOTransformer implements Transformer<Category, SaveCategoryMO> {
    @Override
    public SaveCategoryMO transform(Category category) {
        SaveCategoryMO saveCategoryMO = SaveCategoryMO.builder()
                .id(category.getId())
                .name(category.getName())
                .userId(category.getUserId()).build();
        return saveCategoryMO;
    }
}
