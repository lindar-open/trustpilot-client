package com.lindar.trustpilot.model.response;

import lombok.Data;

import java.util.List;

@Data
public class AuthenticationResponse {

    private String       refreshTokenExpiresIn;
    private String       refreshTokenStatus;
    private String       apiProductList;
    private String       appEnduser;
    private List<String> apiProductListJson;
    private String       organizationName;
    private String       tokenType;
    private String       issuedAt;
    private String       clientId;
    private String       accessToken;
    private String       refreshToken;
    private String       applicationName;
    private String       scope;
    private String       refreshTokenIssuedAt;
    private String       expiresIn;
    private String       refreshCount;
    private String       status;

}
