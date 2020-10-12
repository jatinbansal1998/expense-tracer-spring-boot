package com.jatin.expense_tracker.response.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponseEntity extends BaseResponseEntity {
    private static final long serialVersionUID = 2456026734266670772L;
    private Long id;
    private String name;
    private String email;
}
