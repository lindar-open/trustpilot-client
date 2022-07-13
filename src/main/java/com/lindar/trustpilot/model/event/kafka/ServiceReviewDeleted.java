package com.lindar.trustpilot.model.event.kafka;

import com.lindar.trustpilot.model.event.TrustpilotServiceReviewDeletedData;
import lombok.Data;

@Data
public class ServiceReviewDeleted extends TrustpilotEvent {
    private TrustpilotServiceReviewDeletedData eventData;
}
