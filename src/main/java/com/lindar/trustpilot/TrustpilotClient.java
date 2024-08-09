package com.lindar.trustpilot;

import com.lindar.trustpilot.api.AuthenticationResource;
import com.lindar.trustpilot.api.BusinessUnitsPublicResource;
import com.lindar.trustpilot.api.InvitationResource;
import com.lindar.trustpilot.api.ServiceReviewResource;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

@Slf4j
public class TrustpilotClient {

    private static final String DEFAULT_URL = "https://api.trustpilot.com/v1/";
    private static final String INVITATIONS_DEFAULT_URL = "https://invitations-api.trustpilot.com/v1/";

    private final AuthenticationResource      authenticationResource;
    private final BusinessUnitsPublicResource businessUnitsPublicResource;
    private final InvitationResource          invitationResource;
    private final ServiceReviewResource       serviceReviewResource;

    public TrustpilotClient() {
        this(null, null);
    }
    public TrustpilotClient(String baseUrl, String invitationsBaseUrl) {
        baseUrl = StringUtils.isEmpty(baseUrl) ? DEFAULT_URL : baseUrl;
        invitationsBaseUrl = StringUtils.isEmpty(invitationsBaseUrl) ? INVITATIONS_DEFAULT_URL : invitationsBaseUrl;
        authenticationResource = new AuthenticationResource(baseUrl);
        businessUnitsPublicResource = new BusinessUnitsPublicResource(baseUrl);
        invitationResource = new InvitationResource(invitationsBaseUrl);
        serviceReviewResource = new ServiceReviewResource(baseUrl);
    }

    public AuthenticationResource authentication() {
        return authenticationResource;
    }

    public BusinessUnitsPublicResource businessUnitsPublic() {
        return businessUnitsPublicResource;
    }

    public InvitationResource invitation() {
        return invitationResource;
    }

    public ServiceReviewResource serviceReview() {
        return serviceReviewResource;
    }
}
