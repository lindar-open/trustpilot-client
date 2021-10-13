package com.lindar.trustpilot.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TrustpilotUnexpectedErrorException extends TrustpilotException{

    private final int statusCode;
    private final String errorMessage;

}
