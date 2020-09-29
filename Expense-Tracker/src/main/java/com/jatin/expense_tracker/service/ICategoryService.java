package com.jatin.expense_tracker.service;

import com.jatin.expense_tracker.mo.input.CategoryInputMO;
import org.springframework.http.ResponseEntity;

public interface ICategoryService {
    ResponseEntity save(CategoryInputMO saveCategoryMO);

    ResponseEntity getAllCategories(Long userId);
}
