package com.lindar.trustpilot.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TrustpilotUnauthorizedException extends TrustpilotException {

    private final int statusCode;
    private final String errorCode;
    private final String errorMessage;

}
