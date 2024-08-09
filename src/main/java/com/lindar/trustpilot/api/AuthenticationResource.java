package com.lindar.trustpilot.api;

import com.lindar.trustpilot.exception.TrustpilotException;
import com.lindar.trustpilot.model.response.AuthenticationResponse;
import com.lindar.wellrested.vo.Result;
import com.lindar.wellrested.vo.ResultBuilder;
import com.lindar.wellrested.vo.WellRestedResponse;

import java.util.HashMap;
import java.util.Map;

public class AuthenticationResource extends AbstractResource {

    private final String OAUTH_BUSINESS = "oauth/oauth-business-users-for-applications/";

    private final String OAUTH_BUSINESS_ACCESS_TOKEN         = OAUTH_BUSINESS + "accesstoken";
    private final String OAUTH_BUSINESS_REFRESH_TOKEN        = OAUTH_BUSINESS + "refresh";
    private final String OAUTH_BUSINESS_REVOKE_REFRESH_TOKEN = OAUTH_BUSINESS + "revoke";

    public AuthenticationResource(String baseUrl) {
        super(baseUrl);
    }

    public Result<AuthenticationResponse> requestAccessToken(String apiKey, String apiSecret, String trustpilotUsername, String trustpilotPassword) throws TrustpilotException {
        Map<String, String> formParams = new HashMap<>();
        formParams.put("grant_type", "password");
        formParams.put("username", trustpilotUsername);
        formParams.put("password", trustpilotPassword);
        WellRestedResponse response = doBasicAuthPostRequest(apiKey, apiSecret, OAUTH_BUSINESS_ACCESS_TOKEN, formParams);
        return ResultBuilder.successful(response.fromJson().castTo(AuthenticationResponse.class));
    }

    public Result<AuthenticationResponse> refreshAccessToken(String apiKey, String apiSecret, String refreshToken) throws TrustpilotException {
        Map<String, String> formParams = new HashMap<>();
        formParams.put("grant_type", "refresh_token");
        formParams.put("refresh_token", refreshToken);
        WellRestedResponse response = doBasicAuthPostRequest(apiKey, apiSecret, OAUTH_BUSINESS_REFRESH_TOKEN, formParams);
        return ResultBuilder.successful(response.fromJson().castTo(AuthenticationResponse.class));
    }

    public Result<Void> revokeRefreshToken(String refreshToken) throws TrustpilotException {
        Map<String, String> formParams = new HashMap<>();
        formParams.put("token", refreshToken);
        WellRestedResponse response = doUnAuthPostRequest(OAUTH_BUSINESS_REVOKE_REFRESH_TOKEN, formParams);
        return ResultBuilder.successfulWithoutData(response.getServerResponse());
    }

}
