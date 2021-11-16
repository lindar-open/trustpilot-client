package com.lindar.trustpilot.api;

import com.lindar.trustpilot.exception.TrustpilotException;
import com.lindar.trustpilot.model.request.CreateInvitationsRequest;
import com.lindar.trustpilot.model.request.DeleteInvitationDataRequest;
import com.lindar.trustpilot.model.request.GenerateServiceReviewInvitationLinkRequest;
import com.lindar.trustpilot.model.response.GenerateServiceReviewInvitationLinkResponse;
import com.lindar.trustpilot.model.response.GetInvitationTemplatesResponse;
import com.lindar.wellrested.vo.Result;
import com.lindar.wellrested.vo.ResultBuilder;
import com.lindar.wellrested.vo.WellRestedResponse;

public class InvitationResource extends AbstractResource {

    public InvitationResource() {
        super("https://invitations-api.trustpilot.com/v1/");
    }

    public Result<Void> createInvitations(String accessToken, String businessUnitId, CreateInvitationsRequest createInvitationsRequest) throws TrustpilotException {
        String resourcePath = String.format("private/business-units/%s/email-invitations", businessUnitId);
        WellRestedResponse response = doOAuthTokenPostRequest(accessToken, resourcePath, createInvitationsRequest);
        return ResultBuilder.successfulWithoutData(response.getServerResponse());
    }

    public Result<Void> deleteInvitationData(String accessToken, String businessUnitId, DeleteInvitationDataRequest deleteInvitationDataRequest) throws TrustpilotException {
        String resourcePath = String.format("private/business-units/%s/invitation-data/delete", businessUnitId);
        WellRestedResponse response = doOAuthTokenPostRequest(accessToken, resourcePath, deleteInvitationDataRequest);
        return ResultBuilder.successfulWithoutData(response.getServerResponse());
    }

    public Result<GenerateServiceReviewInvitationLinkResponse> generateServiceReviewInvitationLinkResponse(String accessToken, String businessUnitId, GenerateServiceReviewInvitationLinkRequest generateServiceReviewInvitationLinkRequest) throws TrustpilotException {
        String resourcePath = String.format("private/business-units/%s/invitation-links", businessUnitId);
        WellRestedResponse response = doOAuthTokenPostRequest(accessToken, resourcePath, generateServiceReviewInvitationLinkRequest);
        GenerateServiceReviewInvitationLinkResponse sendInvitationsResponse = response.fromJson().castTo(GenerateServiceReviewInvitationLinkResponse.class);
        return ResultBuilder.successful(sendInvitationsResponse);
    }

    public Result<GetInvitationTemplatesResponse> getTemplates(String accessToken, String businessUnitId) throws TrustpilotException {
        String resourcePath = String.format("private/business-units/%s/templates", businessUnitId);
        WellRestedResponse response = doOAuthTokenGetRequest(accessToken, resourcePath);
        GetInvitationTemplatesResponse templatesResponse = response.fromJson().castTo(GetInvitationTemplatesResponse.class);
        return ResultBuilder.successful(templatesResponse);
    }

}
