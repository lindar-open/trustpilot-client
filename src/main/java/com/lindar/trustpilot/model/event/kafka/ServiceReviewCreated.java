package com.lindar.trustpilot.model.event.kafka;

import com.lindar.trustpilot.model.event.TrustpilotServiceReviewCreatedData;
import lombok.Data;

@Data
class ServiceReviewCreated extends TrustpilotEvent {
    private TrustpilotServiceReviewCreatedData eventData;
}
