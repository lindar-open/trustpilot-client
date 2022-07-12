package com.lindar.trustpilot.model.event;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;

@Data
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    property = "eventName")
@JsonSubTypes({
    @Type(value = ServiceReviewCreatedEvent.class, name = "service-review-created"),
})
public class TrustpilotEvent {
    private String eventName;
}
