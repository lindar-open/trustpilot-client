package com.lindar.trustpilot.model.event.kafka;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.lindar.trustpilot.model.event.TrustpilotBaseEventData;
import lombok.Data;

@Data
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "eventName",
        defaultImpl = TrustpilotEvent.class
)
@JsonSubTypes({
        @Type(value = ServiceReviewCreated.class, name = "service-review-created"),
        @Type(value = ServiceReviewDeleted.class, name = "service-review-deleted"),
})
class TrustpilotEvent {
    private String eventName;

    TrustpilotBaseEventData getEventData() {
        return new TrustpilotBaseEventData();
    }
}
