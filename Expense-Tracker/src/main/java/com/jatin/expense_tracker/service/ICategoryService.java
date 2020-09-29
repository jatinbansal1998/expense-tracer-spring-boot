package com.jatin.expense_tracker.service;

import com.jatin.expense_tracker.mo.SaveCategoryMO;
import org.springframework.http.ResponseEntity;

public interface ICategoryService {
    ResponseEntity save(SaveCategoryMO saveCategoryMO);

    ResponseEntity getAllCategories(Long userId);
}
