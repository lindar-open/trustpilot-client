package com.lindar.trustpilot.exception;

import lombok.Getter;

public class TrustpilotBadRequestException extends TrustpilotException {

    @Getter
    private final int    statusCode;
    @Getter
    private final String errorCode;

    public TrustpilotBadRequestException(String message, int statusCode, String errorCode) {
        super(message);
        this.statusCode = statusCode;
        this.errorCode = errorCode;
    }

}
