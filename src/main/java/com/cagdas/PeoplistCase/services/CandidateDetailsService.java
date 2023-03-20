package com.cagdas.PeoplistCase.services;

import com.cagdas.PeoplistCase.dto.request.DeleteCandidateDetailsDto;
import com.cagdas.PeoplistCase.dto.request.SaveCandidateDetailsDto;
import com.cagdas.PeoplistCase.dto.request.UpdateCandidateDetailsDto;
import com.cagdas.PeoplistCase.exception.CandidatesServiceExceptions;
import com.cagdas.PeoplistCase.exception.ErrorType;
import com.cagdas.PeoplistCase.mapper.ICandidatesMapper;
import com.cagdas.PeoplistCase.repository.ICandidateDetailsRepository;
import com.cagdas.PeoplistCase.repository.ICandidatesRepository;
import com.cagdas.PeoplistCase.repository.entities.CandidateDetails;
import com.cagdas.PeoplistCase.repository.entities.Candidates;
import com.cagdas.PeoplistCase.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateDetailsService extends ServiceManager<CandidateDetails, Long> {
    private final ICandidateDetailsRepository candidateDetailsRepository;
    private final ICandidatesRepository candidatesRepository;

    public CandidateDetailsService(ICandidateDetailsRepository candidateDetailRepository,
                                  ICandidatesRepository candidateRepository) {
        super(candidateDetailRepository);
        this.candidateDetailsRepository = candidateDetailRepository;
        this.candidatesRepository = candidateRepository;
    }

    public CandidateDetails save(SaveCandidateDetailsDto saveCandidateDetailsDto) {
        Optional<Candidates> candidate = candidatesRepository.findOptionalById(saveCandidateDetailsDto.getCandidateId());
        CandidateDetails candidateDetails = ICandidatesMapper.INSTANCE.toCandidateDetail(saveCandidateDetailsDto);
        if (candidate.isPresent()) {
            return candidateDetailsRepository.save(candidateDetails);

        } else {
            throw new CandidatesServiceExceptions(ErrorType.CANDIDATE_NOT_FOUND);
        }

    }

    public CandidateDetails update(UpdateCandidateDetailsDto updateCandidateDetailsDto) {
        Optional<CandidateDetails> candidateDetails = candidateDetailsRepository.findOptionalByCandidatesId(updateCandidateDetailsDto.getCandidatesId());
        //CandidateDetail candidateDetail = ICandidateMapper.INSTANCE.toCandidateDetail(updateCandidateDetailDto);
        if (candidateDetails.isPresent()) {
            candidateDetails.get().setContent(updateCandidateDetailsDto.getContent());
            candidateDetails.get().setDate(updateCandidateDetailsDto.getDate());
            candidateDetails.get().setType(updateCandidateDetailsDto.getType());
            candidateDetails.get().setCandidateResponded(updateCandidateDetailsDto.isCandidateResponded());
            return candidateDetailsRepository.save(candidateDetails.get());
        } else {
            throw new CandidatesServiceExceptions(ErrorType.CANDIDATEDETAIL_NOT_FOUND);
        }
    }

    public Boolean delete(DeleteCandidateDetailsDto deleteCandidateDetailsDto) {
        Optional<CandidateDetails> candidateDetail = candidateDetailsRepository
                .findOptionalById(deleteCandidateDetailsDto.getId());
        if (candidateDetail.isPresent()) {
            delete(candidateDetail.get());
            return true;
        } else {
            throw new CandidatesServiceExceptions(ErrorType.CANDIDATEDETAIL_NOT_FOUND);
        }
    }

    public List<CandidateDetails> findAll() {
        return candidateDetailsRepository.findAll();
    }

    public CandidateDetails getById(Long id) {
        Optional<CandidateDetails> candidateDetail = candidateDetailsRepository.findById(id);
        if (candidateDetail.isPresent()) {
            return candidateDetail.get();
        } else {
            throw new CandidatesServiceExceptions(ErrorType.CANDIDATE_NOT_FOUND);
        }
    }
}
