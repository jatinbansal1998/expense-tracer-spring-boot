package com.jatin.ExpenseTracker.model;

import com.jatin.ExpenseTracker.JPADataTypeConstants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.time.Instant;

@Entity
@Table(name = "EXPENSE")
@SequenceGenerator(name = "default_gen", sequenceName = "EXPENSE_SEQ", allocationSize = 1)

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Expense extends BaseEntity {

    @Column(name = "EXPENSE_DESC")
    private String description;

    @Column(name = "EXPENSE_INSTANT")
    private Instant expenseInstant;

    @Column(name = "EXPENSE_LOCATION")
    private String location;

    @Column(name = "CATEGORY_ID", columnDefinition = JPADataTypeConstants.ID)
    private Long categoryId;

    @Column(name = "USER_ID", columnDefinition = JPADataTypeConstants.ID)
    private Long userId;
}
