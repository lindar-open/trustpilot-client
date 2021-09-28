package com.lindar.trustpilot.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ServiceReviewInvitation {

    private String        templateId;
    private LocalDateTime preferredSendTime;
    private String        redirectUri;
    private List<String>  tags;

}
