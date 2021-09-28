package com.lindar.trustpilot.api;

import com.lindar.trustpilot.model.response.AuthenticationResponse;
import com.lindar.wellrested.WellRestedRequest;
import com.lindar.wellrested.vo.WellRestedResponse;

import java.util.HashMap;
import java.util.Map;

public class AuthenticationResource extends AbstractResource {

    private final String OAUTH_BUSINESS                      = "oauth/oauth-business-users-for-applications/";

    private final String OAUTH_BUSINESS_ACCESS_TOKEN         = OAUTH_BUSINESS + "accesstoken";
    private final String OAUTH_BUSINESS_REFRESH_TOKEN        = OAUTH_BUSINESS + "refresh";
    private final String OAUTH_BUSINESS_REVOKE_REFRESH_TOKEN = OAUTH_BUSINESS + "revoke";

    public AuthenticationResponse requestAccessToken(String apiKey, String apiSecret, String trustpilotUsername, String trustpilotPassword) {
        Map<String, String> formParams = new HashMap<>();
        formParams.put("grant_type", "password");
        formParams.put("username", trustpilotUsername);
        formParams.put("password", trustpilotPassword);
        WellRestedResponse wellRestedResponse = WellRestedRequest.builder().url(BASE_URL + OAUTH_BUSINESS_ACCESS_TOKEN).addAuthorizationGlobalHeader(apiKey, apiSecret).build().post().formParams(
                formParams).submit();

        return wellRestedResponse.fromJson().castTo(AuthenticationResponse.class);
    }

    public AuthenticationResponse refreshAccessToken(String apiKey, String apiSecret, String refreshToken) {
        Map<String, String> formParams = new HashMap<>();
        formParams.put("grant_type", "refresh_token");
        formParams.put("refresh_token", refreshToken);
        WellRestedResponse wellRestedResponse = WellRestedRequest.builder().url(BASE_URL + OAUTH_BUSINESS_REFRESH_TOKEN).addAuthorizationGlobalHeader(apiKey, apiSecret).build().post().formParams(
                formParams).submit();

        return wellRestedResponse.fromJson().castTo(AuthenticationResponse.class);
    }

    public WellRestedResponse revokeRefreshToken(String refreshToken) {
        Map<String, String> formParams = new HashMap<>();
        formParams.put("token", refreshToken);
        return WellRestedRequest.builder().url(BASE_URL + OAUTH_BUSINESS_REVOKE_REFRESH_TOKEN).build().post().formParams(formParams).submit();
    }

}
