package com.jatin.ExpenseTracker.model;

import com.jatin.ExpenseTracker.JPADataTypeConstants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 6942311569301957329L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "default_gen")
    @Column(name = "ID", columnDefinition = JPADataTypeConstants.ID)
    private Long Id;

//    @Column(name = "CREATION_OR_LAST_UPDATED_TIME")
//    private LocalDateTime creationTime = LocalDateTime.now();
}
