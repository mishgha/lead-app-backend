package com.example.leadapp.controller;

import com.example.leadapp.dto.AllLeads;
import com.example.leadapp.dto.LeadDto;
import com.example.leadapp.service.LeadService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller class responsible for handling lead-related HTTP requests.
 * Provides endpoints for retrieving all leads, adding a new lead, and deleting a lead.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/lead")
@CrossOrigin(origins = "http://localhost:3000")
public class LeadController {

    private final LeadService leadService;

    /**
     * Retrieves all leads information.
     *
     * @return a {@link ResponseEntity} containing an {@link AllLeads} object with all leads data.
     */
    @GetMapping("/")
    ResponseEntity<AllLeads> getAllLeadsInformation() {
        return leadService.getAllLeadsInformation();
    }

    /**
     * Adds a new lead to the system.
     *
     * @param leadDto the {@link LeadDto} object containing lead data.
     * @return a {@link ResponseEntity} containing the saved {@link LeadDto}.
     */
    @PostMapping("/")
    ResponseEntity<LeadDto> addLeadInformation(@Valid @RequestBody LeadDto leadDto) {
        return leadService.addLeadInformation(leadDto);
    }

    /**
     * Deletes a lead from the system based on the provided lead ID.
     *
     * @param leadId the ID of the lead to delete.
     * @return a {@link ResponseEntity} containing a success or failure message.
     */
    @DeleteMapping("/{leadId}")
    ResponseEntity<String> deleteLeadInformation(@Valid @PathVariable Long leadId) {
        return leadService.deleteLeadInformation(leadId);
    }

}
