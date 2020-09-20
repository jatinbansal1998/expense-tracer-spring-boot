package com.jatin.ExpenseTracker.Transformers;

import com.jatin.ExpenseTracker.MO.SaveCategoryMO;
import com.jatin.ExpenseTracker.model.Category;
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
