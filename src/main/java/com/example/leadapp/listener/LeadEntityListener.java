package com.example.leadapp.listener;

import com.example.leadapp.entity.Lead;
import jakarta.persistence.PrePersist;

import java.time.LocalDateTime;

/**
 * Entity listener for the {@link Lead} entity.
 * This listener is used to perform actions before the entity is persisted to the database.
 */
public class LeadEntityListener {

    /**
     * Callback method that is invoked before a {@link Lead} entity is persisted.
     * Sets the {@code createdAt} field to the current timestamp.
     *
     * @param lead the {@link Lead} entity that is about to be persisted.
     */
    @PrePersist
    public void prePersist(Lead lead) {
        lead.setCreatedAt(LocalDateTime.now());
    }

}
