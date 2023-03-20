package com.cagdas.PeoplistCase.dto.response;

import com.cagdas.PeoplistCase.repository.entities.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CandidatesStatusResponseDto {
    Status status;
}

