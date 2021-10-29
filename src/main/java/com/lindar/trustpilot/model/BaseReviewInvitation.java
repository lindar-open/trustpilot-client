package com.lindar.trustpilot.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BaseReviewInvitation {

    private String        templateId;
    private LocalDateTime preferredSendTime;
    private String        redirectUri;

}
