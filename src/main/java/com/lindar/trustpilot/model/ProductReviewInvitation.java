package com.lindar.trustpilot.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true) @Data
public class ProductReviewInvitation extends BaseReviewInvitation{

    private List<ProductReview> products;
    private List<String>        productSkus;

}
