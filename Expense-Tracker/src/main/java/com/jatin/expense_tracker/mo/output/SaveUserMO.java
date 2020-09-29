package com.jatin.expense_tracker.mo.output;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaveUserMO implements Serializable {
    private static final long serialVersionUID = 2456026734266670772L;
    private Long id;
    private String name;
    private String email;
}
