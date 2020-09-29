package com.jatin.expense_tracker.mo.input;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryInputMO implements Serializable {
    private static final long serialVersionUID = -202933407256973781L;

    private String name;

    private Long userId;
}
