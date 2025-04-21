package com.example.leadapp.entity;

import com.example.leadapp.listener.LeadEntityListener;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "lead_information")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(LeadEntityListener.class)
public class Lead {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "full_name")
    String fullName;

    String email;

    String phone;

    @Column(name = "company_name")
    String companyName;

    String notes;

    @Column(name = "created_at")
    LocalDateTime createdAt;

}
