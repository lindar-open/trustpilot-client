package com.lindar.trustpilot.model.response;

import lombok.Data;

import java.util.List;

@Data
public class AuthenticationResponse {

    private String       refreshTokenExpiresIn;
    private String       refreshTokenStatus;
    private String       appEnduser;
    private String       issuedAt;
    private String       clientId;
    private String       accessToken;
    private String       refreshToken;
    private String       refreshTokenIssuedAt;
    private String       expiresIn;
}
