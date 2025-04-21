package com.example.leadapp.mapper;

import com.example.leadapp.dto.LeadDto;
import com.example.leadapp.entity.Lead;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.UUID;

/**
 * MapStruct mapper interface for converting between {@link LeadDto} and {@link Lead} entities.
 * This interface provides automatic mapping logic to reduce boilerplate code.
 */
@Mapper(
    componentModel = "spring",
    imports = {UUID.class, LocalDateTime.class, ZoneOffset.class},
    nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL
)
public interface LeadMapper {

    /**
     * Static instance of the mapper to allow manual usage if needed.
     */
    LeadMapper INSTANCE = Mappers.getMapper(LeadMapper.class);

    /**
     * Maps a {@link LeadDto} object to a {@link Lead} entity.
     *
     * @param leadDto the DTO containing lead data.
     * @return the mapped {@link Lead} entity.
     */
    @Mapping(target = "phone", expression = "java(leadDto.getPhoneNumber())")
    Lead mapLeadDtoToLead(LeadDto leadDto);

    /**
     * Maps a {@link Lead} entity to a {@link LeadDto}.
     *
     * @param lead the entity containing lead data.
     * @return the mapped {@link LeadDto}.
     */
    @Mapping(target = "phoneNumber", expression = "java(lead.getPhone())")
    LeadDto mapLeadToLeadDto(Lead lead);

}
