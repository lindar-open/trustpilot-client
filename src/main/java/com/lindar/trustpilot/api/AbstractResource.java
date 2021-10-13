package com.lindar.trustpilot.api;

import com.lindar.trustpilot.exception.TrustpilotException;
import com.lindar.trustpilot.exception.TrustpilotUnauthorizedException;
import com.lindar.trustpilot.exception.TrustpilotUnexpectedErrorException;
import com.lindar.wellrested.WellRestedRequest;
import com.lindar.wellrested.vo.WellRestedResponse;
import lindar.acolyte.util.UrlAcolyte;
import lombok.Data;

import java.util.Map;

abstract class AbstractResource {

    private final String DEFAULT_URL = "https://api.trustpilot.com/v1/";

    protected String baseUrl;

    public AbstractResource(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public AbstractResource() {
        this.baseUrl = DEFAULT_URL;
    }


    final protected WellRestedResponse doOAuthTokenPostRequest(String accessToken, String resourcePath, Object jsonContent) throws TrustpilotException {
        return validateResponse(buildOAuthTokenRequest(accessToken, resourcePath).post().jsonContent(jsonContent).submit());
    }

    final protected WellRestedResponse doOAuthTokenGetRequest(String accessToken, String resourcePath) throws TrustpilotException {
        return validateResponse(buildOAuthTokenRequest(accessToken, resourcePath).get().submit());
    }

    final protected WellRestedResponse doBasicAuthPostRequest(String apiKey, String apiSecret, String resourcePath, Map<String, String> formParams) throws TrustpilotException {
        return validateResponse(buildBasicAuthRequest(apiKey, apiSecret, resourcePath).post().formParams(formParams).submit());
    }

    final protected WellRestedResponse doApiKeyGetRequest(String apiKey, String resourcePath) throws TrustpilotException {
        return validateResponse(buildApiKeyRequest(apiKey, resourcePath).get().submit());
    }

    final protected WellRestedResponse doUnAuthPostRequest(String resourcePath, Map<String, String> formParams) throws TrustpilotException {
        return validateResponse(buildUnAuthRequest(resourcePath).post().formParams(formParams).submit());
    }


    private WellRestedRequest buildOAuthTokenRequest(String accessToken, String resourcePath) {
        return WellRestedRequest.builder().url(UrlAcolyte.safeConcat(baseUrl, resourcePath)).addGlobalHeader("Authorization", "Bearer " + accessToken).build();
    }

    private WellRestedRequest buildBasicAuthRequest(String apiKey, String apiSecret, String resourcePath) {
        return WellRestedRequest.builder().url(UrlAcolyte.safeConcat(baseUrl, resourcePath)).addAuthorizationGlobalHeader(apiKey, apiSecret).build();
    }

    private WellRestedRequest buildApiKeyRequest(String apiKey, String resourcePath) {
        return WellRestedRequest.builder().url(UrlAcolyte.safeConcat(baseUrl, resourcePath)).addGlobalHeader("apikey", apiKey).build();
    }

    private WellRestedRequest buildUnAuthRequest(String resourcePath) {
        return WellRestedRequest.builder().url(UrlAcolyte.safeConcat(baseUrl, resourcePath)).build();
    }

    private WellRestedResponse validateResponse(WellRestedResponse response) throws TrustpilotException {
        if (response.isValid()) return response;

        if (response.getStatusCode() == 401) {
            ErrorResponse errorResponse = response.fromJson().castTo(ErrorResponse.class);
            throw new TrustpilotUnauthorizedException(response.getStatusCode(), errorResponse.getFault().getDetail().getErrorcode(), errorResponse.getFault().getFaultstring());
        }
        throw new TrustpilotUnexpectedErrorException(response.getStatusCode(), response.getServerResponse());
    }

    @Data
    private class ErrorResponse {

        private Fault fault;

        @Data
        public class Fault {

            private String faultstring;
            private Detail detail;

            @Data
            public class Detail {
                private String errorcode;
            }

        }

    }

}
