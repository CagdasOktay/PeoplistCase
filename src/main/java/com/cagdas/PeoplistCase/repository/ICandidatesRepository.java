package com.cagdas.PeoplistCase.repository;

import com.cagdas.PeoplistCase.repository.entities.Candidates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICandidatesRepository extends JpaRepository<Candidates, Long> {

    Optional<Candidates> findOptionalById(Long id);

}
