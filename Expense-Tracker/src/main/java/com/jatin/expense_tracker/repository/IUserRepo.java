package com.jatin.expense_tracker.repository;

import com.jatin.expense_tracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface IUserRepo extends JpaRepository<User, Long> {
}
