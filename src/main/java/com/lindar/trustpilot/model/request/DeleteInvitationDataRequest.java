package com.lindar.trustpilot.model.request;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class DeleteInvitationDataRequest {

    private List<String>  customerEmails;
    private LocalDateTime deleteOlderThan;
}
