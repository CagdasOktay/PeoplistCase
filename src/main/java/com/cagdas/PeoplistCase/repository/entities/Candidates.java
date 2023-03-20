package com.cagdas.PeoplistCase.repository.entities;



import com.cagdas.PeoplistCase.repository.entities.enums.Status;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "tblcandidates")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class Candidates {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)

        private Long id;
        private String nameSurname;
        private String phone;
        private String email;

        @Enumerated(EnumType.STRING)
        @Builder.Default
        private Status status = Status.SOURCED;
        @Builder.Default
        private long date = System.currentTimeMillis();

    }

