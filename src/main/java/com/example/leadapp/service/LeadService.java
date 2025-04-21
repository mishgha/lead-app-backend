package com.example.leadapp.service;

import com.example.leadapp.dto.AllLeads;
import com.example.leadapp.dto.LeadDto;
import com.example.leadapp.entity.Lead;
import com.example.leadapp.mapper.LeadMapper;
import com.example.leadapp.repository.LeadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Service class that handles business logic related to Lead operations.
 * Provides functionality to fetch, add, and delete lead information.
 */
@Service
@RequiredArgsConstructor
public class LeadService {

    private final LeadRepository leadsRepository;
    private final LeadMapper leadMapper;

    private static final String LEAD_INFORMATION_NOT_FOUND = "Lead information not found";
    private static final String LEAD_INFORMATION_DELETED = "Lead information deleted successfully";

    /**
     * Retrieves all leads from the database, maps them to DTOs, and returns the list.
     *
     * @return a {@link ResponseEntity} containing {@link AllLeads} and HTTP status 200 OK.
     */
    public ResponseEntity<AllLeads> getAllLeadsInformation() {
        List<Lead> allLeadsEntity = leadsRepository.findAll();
        List<LeadDto> allLeadDto = new ArrayList<>();

        for (Lead lead : allLeadsEntity) {
            LeadDto leadDto = leadMapper.mapLeadToLeadDto(lead);
            allLeadDto.add(leadDto);
        }

        return new ResponseEntity<>(new AllLeads(allLeadDto), HttpStatus.OK);
    }

    /**
     * Adds a new lead to the database.
     *
     * @param leadDto the DTO containing lead data to be saved.
     * @return a {@link ResponseEntity} containing the saved {@link LeadDto} and HTTP status 200 OK.
     */
    @Transactional
    public ResponseEntity<LeadDto> addLeadInformation(LeadDto leadDto) {
        Lead leadInformationToBeSaved = leadMapper.mapLeadDtoToLead(leadDto);
        Lead savedLeadInformation = leadsRepository.save(leadInformationToBeSaved);
        LeadDto leadDtoToSend = leadMapper.mapLeadToLeadDto(savedLeadInformation);

        return new ResponseEntity<>(leadDtoToSend, HttpStatus.OK);
    }

    /**
     * Deletes an existing lead by its ID.
     *
     * @param leadId the ID of the lead to be deleted.
     * @return a {@link ResponseEntity} with a success message and HTTP status 200 OK if found,
     *         or 404 NOT FOUND if the lead does not exist.
     */
    @Transactional
    public ResponseEntity<String> deleteLeadInformation(Long leadId) {
        Optional<Lead> leadToBeDeleted = leadsRepository.findById(leadId);

        if (!leadToBeDeleted.isPresent()) {
            return new ResponseEntity<>(LEAD_INFORMATION_NOT_FOUND, HttpStatus.NOT_FOUND);
        }

        leadsRepository.delete(leadToBeDeleted.get());

        return new ResponseEntity<>(LEAD_INFORMATION_DELETED, HttpStatus.OK);
    }

}
