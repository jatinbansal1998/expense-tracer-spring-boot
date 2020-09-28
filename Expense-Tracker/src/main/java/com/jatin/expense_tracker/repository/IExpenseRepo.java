package com.jatin.expense_tracker.repository;

import com.jatin.expense_tracker.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface IExpenseRepo extends JpaRepository<Expense, Long> {
    @Query(value = "SELECT * FROM EXPENSE e WHERE e.USER_ID = :userId", nativeQuery = true)
    List<Expense> findAllByUser(@Param("userId") Long userId);
}
