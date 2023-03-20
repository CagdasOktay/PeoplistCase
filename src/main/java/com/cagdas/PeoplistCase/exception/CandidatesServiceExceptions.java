package com.cagdas.PeoplistCase.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;



@Getter

public class CandidatesServiceExceptions extends RuntimeException {
    private final ErrorType errorType;

    public CandidatesServiceExceptions(ErrorType errorType) {
        super(errorType.getMessage());
        this.errorType = errorType;
    }

    public CandidatesServiceExceptions(ErrorType errorType, String message) {
        super(message);
        this.errorType = errorType;
    }
}

