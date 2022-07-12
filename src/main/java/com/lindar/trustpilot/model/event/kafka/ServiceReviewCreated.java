package com.lindar.trustpilot.model.event.kafka;

import com.lindar.trustpilot.model.event.ServiceReviewCreatedData;
import lombok.Data;

@Data
class ServiceReviewCreated extends TrustpilotEvent {
    private ServiceReviewCreatedData eventData;
}
