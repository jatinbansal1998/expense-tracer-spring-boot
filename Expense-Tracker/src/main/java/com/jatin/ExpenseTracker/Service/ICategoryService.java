package com.jatin.ExpenseTracker.Service;

import com.jatin.ExpenseTracker.MO.SaveCategoryMO;
import org.springframework.http.ResponseEntity;

public interface ICategoryService {
    ResponseEntity save(SaveCategoryMO saveCategoryMO);

    ResponseEntity getAllCategories(Long userId);
}
