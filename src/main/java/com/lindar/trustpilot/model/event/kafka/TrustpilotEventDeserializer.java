package com.lindar.trustpilot.model.event.kafka;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.lindar.trustpilot.model.event.TrustpilotEvent;
import lombok.Data;
import lombok.SneakyThrows;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.List;

public class TrustpilotEventDeserializer implements Deserializer<List<TrustpilotEvent>> {

    private final ObjectMapper objectMapper = new ObjectMapper()
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .registerModule(new JavaTimeModule());

    @SneakyThrows
    @Override
    public List<TrustpilotEvent> deserialize(String topic, byte[] data) {
        EventContainer container = objectMapper.readValue(data, EventContainer.class);
        return container.events;
    }

    @Data
    private static class EventContainer {
        private List<TrustpilotEvent> events;
    }
}
