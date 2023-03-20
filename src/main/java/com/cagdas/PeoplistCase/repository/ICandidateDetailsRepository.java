package com.cagdas.PeoplistCase.repository;

import com.cagdas.PeoplistCase.repository.entities.CandidateDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICandidateDetailsRepository extends JpaRepository<CandidateDetails, Long> {
    Optional<CandidateDetails> findOptionalById(Long id);
    Optional<CandidateDetails> findOptionalByCandidatesId(Long id);




}
