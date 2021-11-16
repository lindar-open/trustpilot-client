package com.lindar.trustpilot.exception;

import lombok.Getter;

public class TrustpilotUnauthorizedException extends TrustpilotException {

    @Getter
    private final int statusCode;
    @Getter
    private final String errorCode;

    public TrustpilotUnauthorizedException(String message, int statusCode, String errorCode) {
        super(message);
        this.statusCode = statusCode;
        this.errorCode = errorCode;
    }

}
