package com.lindar.trustpilot.model.event.kafka;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.lindar.trustpilot.model.event.BaseEventData;
import lombok.SneakyThrows;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.List;
import java.util.stream.Collectors;

public class TrustpilotEventDeserializer implements Deserializer<List<BaseEventData>> {

    private final ObjectMapper objectMapper = new ObjectMapper()
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .registerModule(new JavaTimeModule());

    @SneakyThrows
    @Override
    public List<BaseEventData> deserialize(String topic, byte[] data) {
        EventContainer container = objectMapper.readValue(data, EventContainer.class);
        return container.getEvents().stream()
                               .map(TrustpilotEvent::getEventData)
                               .collect(Collectors.toList());
    }






}
