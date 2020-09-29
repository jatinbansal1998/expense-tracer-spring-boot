package com.jatin.expense_tracker.model;

import com.jatin.expense_tracker.JPADataTypeConstants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@MappedSuperclass

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 6942311569301957329L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "default_gen")
    @Column(name = "ID", columnDefinition = JPADataTypeConstants.ID)
    private Long id;

    @Column(name = "CREATION_INSTANT")
    private Instant created;

    @Column(name = "LAST_UPDATE_INSTANT")
    private Instant updated;

    @PrePersist
    protected void onCreate() {
        created = Instant.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updated = Instant.now();
    }
}
