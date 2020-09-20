package com.jatin.ExpenseTracker.repository;

import com.jatin.ExpenseTracker.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ICategoryRepo extends JpaRepository<Category, Long> {
}
