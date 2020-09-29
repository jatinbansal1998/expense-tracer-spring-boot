package com.jatin.expense_tracker.mo.input;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExpenseInputMO implements Serializable {
    private static final long serialVersionUID = 8385142469421544880L;

    private Long userId;

    private Long categoryId;

    private String description;

    private Instant expenseInstant;

    private String location;
}
