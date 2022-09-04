package com.lindar.trustpilot.model.response;

import com.lindar.trustpilot.model.CompanyReply;
import com.lindar.trustpilot.model.event.TrustpilotServiceReviewCreatedData;
import lombok.Data;

import javax.swing.text.View;

@Data
public class GetServiceReviewDetailResponse extends TrustpilotServiceReviewCreatedData {
    private String source;
    private int numberOfLikes;
    private boolean countsTowardsTrustScore;
    private String reviewVerificationLevel;
    private CompanyReply companyReply;
}
