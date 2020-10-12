package com.jatin.expense_tracker.response.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryResponseEntity extends BaseResponseEntity {

    private static final long serialVersionUID = 3993677310244967171L;

    private Long id;

    private String name;

    private Long userId;
}
