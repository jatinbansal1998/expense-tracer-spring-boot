package com.jatin.ExpenseTracker.repository;

import com.jatin.ExpenseTracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface IUserRepo extends JpaRepository<User, Long> {
}
