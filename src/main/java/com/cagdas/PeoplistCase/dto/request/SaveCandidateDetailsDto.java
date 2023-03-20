package com.cagdas.PeoplistCase.dto.request;

import com.cagdas.PeoplistCase.repository.entities.enums.Type;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaveCandidateDetailsDto {
    Long id;
    Long candidateId;
    String email;
    String content;
    boolean candidateResponded;
    String date;
    Type type;
}
