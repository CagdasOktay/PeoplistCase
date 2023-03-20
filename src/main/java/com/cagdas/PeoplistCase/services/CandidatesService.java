package com.cagdas.PeoplistCase.services;

import com.cagdas.PeoplistCase.dto.request.SaveCandidatesDto;
import com.cagdas.PeoplistCase.dto.request.UpdateCandidatesDto;
import com.cagdas.PeoplistCase.exception.CandidatesServiceExceptions;
import com.cagdas.PeoplistCase.exception.ErrorType;
import com.cagdas.PeoplistCase.mapper.ICandidatesMapper;
import com.cagdas.PeoplistCase.repository.ICandidateDetailsRepository;
import com.cagdas.PeoplistCase.repository.ICandidatesRepository;
import com.cagdas.PeoplistCase.repository.entities.CandidateDetails;
import com.cagdas.PeoplistCase.repository.entities.Candidates;
import com.cagdas.PeoplistCase.repository.entities.enums.Status;
import com.cagdas.PeoplistCase.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidatesService extends ServiceManager<Candidates, Long> {
    private final ICandidatesRepository candidatesRepository;
    private final ICandidateDetailsRepository candidateDetailsRepository;
    private final CandidateDetailsService candidateDetailsService;

    public CandidatesService(ICandidatesRepository candidatesRepository,
                            CandidateDetailsService candidateDetailsService,
                            ICandidateDetailsRepository candidateDetailRepository) {
        super(candidatesRepository);
        this.candidatesRepository = candidatesRepository;
        this.candidateDetailsService = candidateDetailsService;
        this.candidateDetailsRepository = candidateDetailRepository;
    }

    public Candidates save(SaveCandidatesDto saveCandidatesDto) {
        Candidates candidate = ICandidatesMapper.INSTANCE.toCandidates(saveCandidatesDto);
        save(candidate);
        CandidateDetails candidateDetail= CandidateDetails.builder()
                .candidatesId(candidate.getId())
                .build();
        candidateDetailsService.save(candidateDetail);
        return candidate;
    }

    public Candidates update2(UpdateCandidatesDto updateCandidateDto) {
        Candidates candidateUpdate= ICandidatesMapper.INSTANCE.toCandidates(updateCandidateDto);
        Optional<Candidates> candidate = candidatesRepository.findOptionalById(candidateUpdate.getId());
        if (candidate.isPresent()) {
            candidate.get().setNameSurname(candidateUpdate.getNameSurname());
            candidate.get().setPhone(candidateUpdate.getPhone());
            candidate.get().setEmail(candidateUpdate.getEmail());
            candidate.get().setStatus(candidateUpdate.getStatus());
            candidatesRepository.save(candidate.get());
            return candidate.get();
        } else {
            throw new CandidatesServiceExceptions(ErrorType.NOT_UPDATE);
        }

    }

    public Boolean deleteCandidate(Long id) {

        Optional<Candidates> candidate=candidatesRepository.findOptionalById(id);
        Optional<CandidateDetails> candidateDetail= candidateDetailsRepository.findOptionalByCandidatesId(id);
        if (candidate.isPresent()){
            System.out.println("candidate"+candidate);
            delete(candidate.get());

            // candidateDetailRepository.delete(candidateDetail.get());
            return true;
        } else {
            throw new
                    CandidatesServiceExceptions(ErrorType.CANDIDATE_NOT_FOUND);
        }
    }

    public List<Candidates> findAll() {
        return candidatesRepository.findAll();
    }

    public Candidates getById(Long id){
        Optional<Candidates> candidate = candidatesRepository.findById(id);
        if(candidate.isPresent()){
            return candidate.get();
        }else {
            throw new CandidatesServiceExceptions(ErrorType.CANDIDATE_NOT_FOUND);
        }
    }

    public Status getByStatus(Long id) {
        Optional<Candidates> candidate = candidatesRepository.findById(id);
        if(candidate.isPresent()){
            return candidate.get().getStatus();
        }else{
            throw new CandidatesServiceExceptions(ErrorType.CANDIDATE_NOT_FOUND);

        }
    }
}
