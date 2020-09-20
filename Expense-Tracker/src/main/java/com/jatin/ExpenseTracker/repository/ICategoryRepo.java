package com.jatin.ExpenseTracker.repository;

import com.jatin.ExpenseTracker.model.Category;
import com.jatin.ExpenseTracker.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface ICategoryRepo extends JpaRepository<Category, Long> {
    @Query(value = "SELECT * FROM CATEGORY c WHERE c.USER_ID = :userId", nativeQuery = true)
    List<Expense> findAllByUser(@Param("userId") Long userId);
}
