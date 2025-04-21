package com.example.leadapp.dto;

import lombok.*;

import java.util.List;

/**
 * Data Transfer Object (DTO) representing a collection of leads.
 * This class is used to encapsulate and transfer a list of {@link LeadDto} objects.
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class AllLeads {

    List<LeadDto> leadDtoList;

}
