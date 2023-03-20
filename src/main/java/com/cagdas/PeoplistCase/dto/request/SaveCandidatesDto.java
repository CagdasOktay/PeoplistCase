package com.cagdas.PeoplistCase.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaveCandidatesDto {
    String nameSurname;
    private String phone;
    private String email;

}
