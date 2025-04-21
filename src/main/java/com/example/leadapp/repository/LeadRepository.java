package com.example.leadapp.repository;

import com.example.leadapp.entity.Lead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing {@link Lead} entities.
 * Extends {@link JpaRepository} to provide CRUD operations and database interaction methods.
 */
@Repository
public interface LeadRepository extends JpaRepository<Lead, Long> {

}
