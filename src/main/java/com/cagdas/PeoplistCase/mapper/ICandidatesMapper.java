package com.cagdas.PeoplistCase.mapper;


import com.cagdas.PeoplistCase.dto.request.*;
import com.cagdas.PeoplistCase.dto.response.CandidatesStatusResponseDto;
import com.cagdas.PeoplistCase.repository.entities.CandidateDetails;
import com.cagdas.PeoplistCase.repository.entities.Candidates;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ICandidatesMapper {
    ICandidatesMapper INSTANCE = Mappers.getMapper(ICandidatesMapper.class);

    Candidates toCandidates(final DeleteCandidatesDto deleteCandidateDto);
    Candidates toCandidates(final SaveCandidatesDto saveCandidateDto);
    Candidates toCandidates(final UpdateCandidatesDto updateCandidateDto);
    Candidates toCandidates(final CandidatesStatusResponseDto statusResponseDto);
    CandidatesStatusResponseDto toCandidateStatusResponseDto (final Candidates candidate);
    CandidateDetails toCandidateDetail(final SaveCandidateDetailsDto saveCandidateDetailDto);
    CandidateDetails toCandidateDetail(final UpdateCandidateDetailsDto updateCandidateDetailDto);
    CandidateDetails toCandidateDetail(final DeleteCandidateDetailsDto deleteCandidateDetailDto);

}
