package com.jatin.ExpenseTracker.Service;

import com.jatin.ExpenseTracker.MO.SaveCategoryMO;
import com.jatin.ExpenseTracker.Predicates.CategoryPredicates;
import com.jatin.ExpenseTracker.Predicates.UserPredicates;
import com.jatin.ExpenseTracker.Transformers.CategoryTransformer;
import com.jatin.ExpenseTracker.Transformers.SaveCategoryMOTransformer;
import com.jatin.ExpenseTracker.model.Category;
import com.jatin.ExpenseTracker.repository.ICategoryRepo;
import com.jatin.ExpenseTracker.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service("categoryService")
public class CategoryService implements ICategoryService {
    @Autowired
    ICategoryRepo categoryRepo;

    @Autowired
    IUserRepo userRepo;

    @Autowired
    UserPredicates userPredicates;

    @Autowired
    CategoryPredicates categoryPredicates;

    @Override
    public ResponseEntity save(SaveCategoryMO saveCategoryMO) {
        if (!userPredicates.isValidUser(saveCategoryMO.getUserId()))
            return new ResponseEntity<>("User Id Not found", HttpStatus.NOT_FOUND);
        Category saveCategory = new CategoryTransformer().transform(saveCategoryMO);
        categoryRepo.save(saveCategory);
        return new ResponseEntity(saveCategory.getId(), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity getAllCategories(Long userId) {
        ResponseEntity responseEntity;
        if (userPredicates.isValidUser(userId)) {
            responseEntity = new ResponseEntity(
                    categoryRepo.findAllByUser(userId).stream()
                            .map(new SaveCategoryMOTransformer()::transform)
                            .collect(Collectors.toList())
                    , HttpStatus.OK);
        } else responseEntity = new ResponseEntity<>("User Id not found", HttpStatus.NOT_FOUND);
        return responseEntity;
    }
}
