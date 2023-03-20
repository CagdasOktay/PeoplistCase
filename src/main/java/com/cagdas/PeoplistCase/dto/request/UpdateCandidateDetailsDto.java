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
public class UpdateCandidateDetailsDto {
    Long candidatesId;
    String content;
    String date;
    Type type;
    boolean candidateResponded;
}
