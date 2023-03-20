package com.cagdas.PeoplistCase.controller;


import com.cagdas.PeoplistCase.dto.request.SaveCandidatesDto;
import com.cagdas.PeoplistCase.dto.request.UpdateCandidatesDto;
import com.cagdas.PeoplistCase.repository.entities.Candidates;
import com.cagdas.PeoplistCase.repository.entities.enums.Status;
import com.cagdas.PeoplistCase.services.CandidatesService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.hibernate.boot.jaxb.cfg.spi.JaxbCfgEventTypeEnum.SAVE;

@RestController
@RequestMapping("candidates")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class CandidatesController {
    private final CandidatesService candidatesService;

    @PostMapping("/save")
    public ResponseEntity<Candidates> save(@RequestBody @Valid SaveCandidatesDto saveCandidatesDto) {
        return ResponseEntity.ok(candidatesService.save(saveCandidatesDto));
    }

    @PutMapping("/update")
    public ResponseEntity<Candidates> update(@RequestBody @Valid UpdateCandidatesDto updateCandidatesDto) {
        return ResponseEntity.ok(candidatesService.update2(updateCandidatesDto));
    }

    @GetMapping("/findall")
    public ResponseEntity<List<Candidates>> findAll() {
        return ResponseEntity.ok(candidatesService.findAll());
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Boolean> deleteCandidates(@RequestBody @PathVariable Long id) {
        System.out.println("id...: " +id);
        return ResponseEntity.ok(candidatesService.deleteCandidate(id));

    }

    @GetMapping("/findbyid")
    public ResponseEntity<Candidates> getById(@RequestBody @PathVariable Long id) {
        return ResponseEntity.ok(candidatesService.getById(id));
    }

    @GetMapping("/getstatus")
    public ResponseEntity<Status> getCandidateStatus(@RequestBody Long id) {
        return ResponseEntity.ok(candidatesService.getByStatus(id));
    }

}
