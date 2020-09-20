package com.jatin.ExpenseTracker.model;

import com.jatin.ExpenseTracker.JPADataTypeConstants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CATEGORY")
@SequenceGenerator(name = "default_gen", sequenceName = "CATEGORY_SEQ", allocationSize = 1)

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category extends BaseEntity {

    @Column(name = "CATEGORY_NAME")
    private String name;

    @Column(name = "USER_ID", columnDefinition = JPADataTypeConstants.ID)
    private Long userId;

//    @Column(name = "USER_ID", columnDefinition = JPADataTypeConstants.ID)
//    private Long userId;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "CATEGORY_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    private List<Expense> expense;
}
