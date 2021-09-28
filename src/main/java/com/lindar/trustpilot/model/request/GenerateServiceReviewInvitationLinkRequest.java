package com.lindar.trustpilot.model.request;

import lombok.Data;

import java.util.List;

@Data
public class GenerateServiceReviewInvitationLinkRequest {

    private String       locationId;
    private String       referenceId;
    private String       email;
    private String       name;
    private String       locale;
    private List<String> tags;
    private String       redirectUri;

}
