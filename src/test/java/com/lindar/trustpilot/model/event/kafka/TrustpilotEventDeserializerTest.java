package com.lindar.trustpilot.model.event.kafka;

import com.lindar.trustpilot.model.event.TrustpilotServiceReviewCreatedData;
import com.lindar.trustpilot.model.event.TrustpilotBaseEventData;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Scanner;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.assertj.core.api.Assertions.assertThat;

public class TrustpilotEventDeserializerTest {

    private String payload = new Scanner(this.getClass().getClassLoader().getResourceAsStream("trustpilot-review-events.json"), "UTF-8")
            .useDelimiter("\\Z").next();

    private TrustpilotEventDeserializer deserializer = new TrustpilotEventDeserializer();

    @Test
    public void testDeserializer() {
        List<TrustpilotBaseEventData> events = deserializer.deserialize("none", payload.getBytes(UTF_8));

        assertThat(events).hasSize(2);
        assertThat(events).hasOnlyElementsOfType(TrustpilotBaseEventData.class);
        assertThat(events).areAtMost(1, instanceOf(TrustpilotServiceReviewCreatedData.class));
    }

    private Condition instanceOf(Class aClass) {
        return new Condition(){
            @Override public boolean matches(Object value) {
                return aClass == value.getClass();
            }
        };
    }

}
