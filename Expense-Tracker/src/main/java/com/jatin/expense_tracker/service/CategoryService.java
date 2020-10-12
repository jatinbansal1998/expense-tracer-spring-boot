package com.jatin.expense_tracker.service;

import com.jatin.expense_tracker.mo.input.CategoryInputMO;
import com.jatin.expense_tracker.model.Category;
import com.jatin.expense_tracker.predicates.CategoryPredicates;
import com.jatin.expense_tracker.predicates.UserPredicates;
import com.jatin.expense_tracker.repository.ICategoryRepo;
import com.jatin.expense_tracker.repository.IUserRepo;
import com.jatin.expense_tracker.response.vo.ErrorResponseEntity;
import com.jatin.expense_tracker.transformers.CategoryResponseEntityTransformer;
import com.jatin.expense_tracker.transformers.CategoryTransformer;
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
    public ResponseEntity save(CategoryInputMO categoryInputMO) {
        if (!userPredicates.isValidUser(categoryInputMO.getUserId()))
            return new ResponseEntity<>(new ErrorResponseEntity("User Id not found"), HttpStatus.NOT_FOUND);
        Category saveCategory = new CategoryTransformer().transform(categoryInputMO);
        categoryRepo.save(saveCategory);
        return new ResponseEntity<>(new CategoryResponseEntityTransformer().transform(saveCategory), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity getAllCategories(Long userId) {
        ResponseEntity responseEntity;
        if (userPredicates.isValidUser(userId)) {
            responseEntity = new ResponseEntity<>(
                    categoryRepo.findAllByUser(userId).stream()
                            .map(new CategoryResponseEntityTransformer()::transform)
                            .collect(Collectors.toList())
                    , HttpStatus.OK);
        } else
            responseEntity = new ResponseEntity<>(new ErrorResponseEntity("User Id not found"), HttpStatus.NOT_FOUND);
        return responseEntity;
    }
}
