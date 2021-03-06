package com.jatin.ExpenseTracker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "USER")
@SequenceGenerator(name = "default_gen", sequenceName = "USER_SEQ", allocationSize = 1)

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {

    @Column(name = "USER_NAME")
    private String name;

    @Column(name = "USER_EMAIL")
    private String email;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    private List<Category> categories;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    private List<Expense> expenses;
}
