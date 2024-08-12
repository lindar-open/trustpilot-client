package com.lindar.trustpilot.api;

import com.lindar.trustpilot.exception.TrustpilotException;
import com.lindar.trustpilot.model.response.GetServiceReviewDetailResponse;
import com.lindar.wellrested.vo.Result;
import com.lindar.wellrested.vo.ResultBuilder;
import com.lindar.wellrested.vo.WellRestedResponse;

public class ServiceReviewResource extends AbstractResource {

    private static final String SERVICE_REVIEWS = "reviews/";

    public ServiceReviewResource(String baseUrl) {
        super(baseUrl);
    }

    public Result<GetServiceReviewDetailResponse> getReviewDetails(String apiKey, String serviceReviewId) throws TrustpilotException {
        WellRestedResponse response = doApiKeyGetRequest(apiKey, SERVICE_REVIEWS + serviceReviewId);
        return ResultBuilder.successful(response.fromJson().castTo(GetServiceReviewDetailResponse.class));
    }
}
