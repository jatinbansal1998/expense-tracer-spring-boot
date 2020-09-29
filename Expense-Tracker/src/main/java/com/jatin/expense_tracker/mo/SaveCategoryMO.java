package com.jatin.expense_tracker.mo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaveCategoryMO implements Serializable {

    private static final long serialVersionUID = 3993677310244967171L;

    private Long id;

    private String name;

    private Long userId;
}
