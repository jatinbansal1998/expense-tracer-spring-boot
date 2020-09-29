package com.jatin.expense_tracker.mo.output;

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
public class SaveExpenseMO implements Serializable {

    private static final long serialVersionUID = 3008720660346812664L;

    private Long id;

    private Long userId;

    private Long categoryId;

    private String description;

    private Instant expenseInstant;

    private String location;
}
