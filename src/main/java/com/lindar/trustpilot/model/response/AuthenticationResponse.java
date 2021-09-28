package com.lindar.trustpilot.model.response;

import lombok.Data;

@Data
public class AuthenticationResponse {

    String  accessToken;
    String  refreshToken;
    Integer expiresIn;

}
