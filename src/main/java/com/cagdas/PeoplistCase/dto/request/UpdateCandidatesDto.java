package com.cagdas.PeoplistCase.dto.request;

import com.cagdas.PeoplistCase.repository.entities.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateCandidatesDto {
    Long id;
    String nameSurname;
    String phone;
    String email;
    Status status;

}
