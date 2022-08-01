package com.lindar.trustpilot.model.event;

import lombok.Data;

import java.time.Instant;

@Data
public class TrustpilotServiceReviewWriteData extends TrustpilotBaseEventData {
    private int      stars;
    private String   title;
    private String   text;
    private String   referenceId;
    private Instant  createdAt;
    private Boolean  isVerified;
    private Consumer consumer;

    @Data
    public static class Consumer {
        private String id;
        private String name;
    }
}
