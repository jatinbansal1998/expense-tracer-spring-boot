package com.jatin.expense_tracker.Service;

import com.jatin.expense_tracker.MO.SaveCategoryMO;
import org.springframework.http.ResponseEntity;

public interface ICategoryService {
    ResponseEntity save(SaveCategoryMO saveCategoryMO);

    ResponseEntity getAllCategories(Long userId);
}
