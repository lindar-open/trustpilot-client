package com.lindar.trustpilot.model;

import lombok.Data;

import java.time.Instant;

@Data
public class CompanyReply {
    private Instant createdAt;
    private String  text;
    private String  authorBusinessUserName;
}
