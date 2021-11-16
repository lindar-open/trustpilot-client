package com.lindar.trustpilot.exception;

import lombok.Getter;

public class TrustpilotUnexpectedErrorException extends TrustpilotException {

    @Getter
    private final int statusCode;

    public TrustpilotUnexpectedErrorException(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

}
