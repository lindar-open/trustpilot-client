package com.lindar.trustpilot.model;

import lombok.Data;

@Data
public class InvitationTemplate {

    private String  id;
    private String  name;
    private Boolean isDefaultTemplate;
    private String  locale;
    private String  type;

}
