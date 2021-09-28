package com.lindar.trustpilot.api;

import com.lindar.trustpilot.model.request.CreateInvitationsRequest;
import com.lindar.trustpilot.model.request.DeleteInvitationDataRequest;
import com.lindar.trustpilot.model.request.GenerateServiceReviewInvitationLinkRequest;
import com.lindar.trustpilot.model.response.GenerateServiceReviewInvitationLinkResponse;
import com.lindar.trustpilot.model.response.GetInvitationTemplatesResponse;
import com.lindar.wellrested.WellRestedRequest;
import com.lindar.wellrested.vo.WellRestedResponse;

public class InvitationResource extends AbstractResource {

    private final String BASE_URL = "https://invitations-api.trustpilot.com/v1/";

    public WellRestedResponse createInvitations(String businessUnitId, String accessToken, CreateInvitationsRequest createInvitationsRequest) {
        String path = String.format("private/business-units/%s/email-invitations", businessUnitId);
        return WellRestedRequest.builder().url(BASE_URL + path).addGlobalHeader("Authorization", "Bearer " + accessToken).build().post().jsonContent(createInvitationsRequest).submit();
    }

    public WellRestedResponse deleteInvitationData(String businessUnitId, String accessToken, DeleteInvitationDataRequest deleteInvitationDataRequest) {
        String path = String.format("private/business-units/%s/invitation-data/delete", businessUnitId);
        return WellRestedRequest.builder().url(BASE_URL + path).addGlobalHeader("Authorization", "Bearer " + accessToken).build().post().jsonContent(deleteInvitationDataRequest).submit();
    }

    public GenerateServiceReviewInvitationLinkResponse generateServiceReviewInvitationLinkResponse(String businessUnitId, String accessToken, GenerateServiceReviewInvitationLinkRequest generateServiceReviewInvitationLinkRequest) {
        String path = String.format("private/business-units/%s/invitation-links", businessUnitId);
        return WellRestedRequest.builder().url(BASE_URL + path).addGlobalHeader("Authorization", "Bearer " + accessToken).build().post().jsonContent(generateServiceReviewInvitationLinkRequest)
                                .submit().fromJson().castTo(GenerateServiceReviewInvitationLinkResponse.class);
    }

    public GetInvitationTemplatesResponse getTemplates(String businessUnitId, String accessToken) {
        String path = String.format("private/business-units/%s/templates", businessUnitId);
        return WellRestedRequest.builder().url(BASE_URL + path).addGlobalHeader("Authorization", "Bearer " + accessToken).build().get().submit().fromJson().castTo(
                GetInvitationTemplatesResponse.class);
    }

}
