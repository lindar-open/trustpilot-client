package com.lindar.trustpilot;

import com.lindar.trustpilot.api.AuthenticationResource;
import com.lindar.trustpilot.api.BusinessUnitsPublicResource;
import com.lindar.trustpilot.api.InvitationResource;
import com.lindar.trustpilot.api.ServiceReviewResource;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TrustpilotClient {

    private final AuthenticationResource      authenticationResource;
    private final BusinessUnitsPublicResource businessUnitsPublicResource;
    private final InvitationResource          invitationResource;
    private final ServiceReviewResource       serviceReviewResource;

    public TrustpilotClient() {
        authenticationResource = new AuthenticationResource();
        businessUnitsPublicResource = new BusinessUnitsPublicResource();
        invitationResource = new InvitationResource();
        serviceReviewResource = new ServiceReviewResource();
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
