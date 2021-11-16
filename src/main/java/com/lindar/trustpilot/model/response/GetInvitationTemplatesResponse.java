package com.lindar.trustpilot.model.response;

import com.lindar.trustpilot.model.InvitationTemplate;
import lombok.Data;

import java.util.List;

@Data
public class GetInvitationTemplatesResponse {

    private List<InvitationTemplate> templates;

}
