package com.lindar.trustpilot.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true) @Data
public class ServiceReviewInvitation extends BaseReviewInvitation{

    private List<String>  tags;

}
