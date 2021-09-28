package com.lindar.trustpilot.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ProductReviewInvitation {

    private String              templateId;
    private LocalDateTime       preferredSendTime;
    private String              redirectUri;
    private List<ProductReview> products;
    private List<String>        productSkus;

}
