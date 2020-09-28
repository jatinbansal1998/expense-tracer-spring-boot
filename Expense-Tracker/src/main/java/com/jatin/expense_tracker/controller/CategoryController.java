package com.jatin.expense_tracker.controller;

import com.jatin.expense_tracker.MO.SaveCategoryMO;
import com.jatin.expense_tracker.Service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    @Qualifier("categoryService")
    ICategoryService categoryService;

    @GetMapping("/getAllCategory")
    public ResponseEntity getAllCategory(@RequestParam("userId") Long userId) {
        return categoryService.getAllCategories(userId);
    }

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody SaveCategoryMO saveCategoryMO) {
        return categoryService.save(saveCategoryMO);
    }
}
