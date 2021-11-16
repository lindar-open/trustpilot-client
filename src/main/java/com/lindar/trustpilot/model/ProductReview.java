package com.lindar.trustpilot.model;

import lombok.Data;

@Data
public class ProductReview {

    private String sku;
    private String name;
    private String mpn;
    private String brand;
    private String imageUrl;
    private String productUrl;
    private String gtin;
    private String productCategoryGoogleId;

}
