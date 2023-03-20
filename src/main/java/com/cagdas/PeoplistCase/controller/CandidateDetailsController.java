package com.cagdas.PeoplistCase.controller;


import com.cagdas.PeoplistCase.dto.request.DeleteCandidateDetailsDto;
import com.cagdas.PeoplistCase.dto.request.SaveCandidateDetailsDto;
import com.cagdas.PeoplistCase.dto.request.UpdateCandidateDetailsDto;
import com.cagdas.PeoplistCase.repository.entities.CandidateDetails;
import com.cagdas.PeoplistCase.services.CandidateDetailsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/candidatedetails")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")

public class CandidateDetailsController {
    private final CandidateDetailsService candidateDetailsService;

    @PostMapping("/save")
    public ResponseEntity<CandidateDetails> save(@RequestBody @Valid SaveCandidateDetailsDto saveCandidateDetailsDto) {
        return ResponseEntity.ok(candidateDetailsService.save(saveCandidateDetailsDto));
    }

    @PutMapping("/update")
    public ResponseEntity<CandidateDetails> update(@RequestBody @Valid UpdateCandidateDetailsDto updateCandidateDetailsDto) {
        return ResponseEntity.ok(candidateDetailsService.update(updateCandidateDetailsDto));
    }

    @GetMapping("/findall")
    public ResponseEntity<List<CandidateDetails>> findAll() {
        return ResponseEntity.ok(candidateDetailsService.findAll());
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Boolean> deleteCandidate(@RequestBody DeleteCandidateDetailsDto deleteCandidateDetailsDto) {
        return ResponseEntity.ok(candidateDetailsService.delete(deleteCandidateDetailsDto));

    }
    @GetMapping("/findbyid")
    public ResponseEntity<CandidateDetails> getById( @PathVariable Long id) {
        return ResponseEntity.ok(candidateDetailsService.getById(id));
    }
}