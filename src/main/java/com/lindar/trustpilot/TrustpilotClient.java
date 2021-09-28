package com.lindar.trustpilot;

import com.lindar.trustpilot.api.AuthenticationResource;
import com.lindar.trustpilot.api.BusinessUnitsPublicResource;
import com.lindar.trustpilot.api.InvitationResource;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class TrustpilotClient {

    private final AuthenticationResource      authenticationResource;
    private final BusinessUnitsPublicResource businessUnitsPublicResource;
    private final InvitationResource          invitationResource;

    public AuthenticationResource authentication() {
        return authenticationResource;
    }

    public BusinessUnitsPublicResource businessUnitsPublic() {
        return businessUnitsPublicResource;
    }

    public InvitationResource invitation() {
        return invitationResource;
    }
}
