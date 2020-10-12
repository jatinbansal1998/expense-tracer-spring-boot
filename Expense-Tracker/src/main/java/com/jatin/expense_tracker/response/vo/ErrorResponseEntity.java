package com.jatin.expense_tracker.response.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorResponseEntity extends BaseResponseEntity {
    private static final long serialVersionUID = 8290679595796053458L;
    private String errorMessage;
}
