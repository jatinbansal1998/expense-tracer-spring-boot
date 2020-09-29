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
public class UserInputMO implements Serializable {
    private static final long serialVersionUID = 3995330433678807935L;
    private String name;
    private String email;
}
