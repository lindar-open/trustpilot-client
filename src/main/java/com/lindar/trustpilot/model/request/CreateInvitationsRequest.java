package com.lindar.trustpilot.model.request;

import com.lindar.trustpilot.model.ProductReviewInvitation;
import com.lindar.trustpilot.model.ServiceReviewInvitation;
import lombok.Data;

@Data
public class CreateInvitationsRequest {

    private String replyTo;
    private String locale;
    private String senderName;
    private String senderEmail;
    private String locationId;
    private String referenceNumber;
    private String consumerName;
    private String consumerEmail;

    private ServiceReviewInvitation serviceReviewInvitation;
    private ProductReviewInvitation productReviewInvitation;


}
