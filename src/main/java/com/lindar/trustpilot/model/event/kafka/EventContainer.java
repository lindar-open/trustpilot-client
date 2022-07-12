package com.lindar.trustpilot.model.event.kafka;

import lombok.Data;

import java.util.List;

import static java.util.Collections.emptyList;

@Data
class EventContainer {
    private List<TrustpilotEvent> events;

    List<TrustpilotEvent> getEvents() {
        return events != null ? events : emptyList();
    }
}
