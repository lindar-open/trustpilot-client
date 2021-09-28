package com.lindar.trustpilot.model;

import lombok.Data;

@Data
public class NumberOfReviews {

    private Integer total;
    private Integer usedForTrustScoreCalculation;
    private Integer oneStar;
    private Integer twoStars;
    private Integer tothreeStarstal;
    private Integer fourStars;
    private Integer fiveStars;

}
