package com.cagdas.PeoplistCase.repository.entities;

import com.cagdas.PeoplistCase.repository.entities.enums.Type;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name= "tblcandidatedetails")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CandidateDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private long candidatesId;
    private String content;
    private String date;
    @Builder.Default
    private boolean candidateResponded=false;
    @Enumerated(EnumType.STRING)
    private Type type;



}
