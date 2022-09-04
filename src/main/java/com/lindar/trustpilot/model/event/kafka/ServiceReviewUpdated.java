package com.lindar.trustpilot.model.event.kafka;

import com.lindar.trustpilot.model.event.TrustpilotServiceReviewUpdatedData;
import lombok.Data;

@Data
public class ServiceReviewUpdated extends TrustpilotEvent<TrustpilotServiceReviewUpdatedData>{
}
