package com.example.leadapp.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.time.LocalDateTime;

/**
 * Data Transfer Object (DTO) representing the details of a lead.
 * This class is used for transferring lead data between client and server.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class LeadDto {

    Long id;

    @NotBlank(message = "Full name is required")
    String fullName;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    String email;

    @Pattern(regexp = "^[0-9]*$", message = "Phone must contain numbers only")
    String phone;

    String companyName;

    String notes;

    LocalDateTime createdAt;

}
