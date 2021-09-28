package com.lindar.trustpilot.model.response;

import com.lindar.trustpilot.model.BusinessUnitName;
import com.lindar.trustpilot.model.NumberOfReviews;
import com.lindar.trustpilot.model.Score;
import com.lindar.trustpilot.model.Link;
import lombok.Data;

import java.util.List;

@Data
public class FindBusinessUnitResponse {

    private List<Link>                  links;
    private String                      id;
    private String                      displayName;
    private BusinessUnitName            name;
    private String                      websiteUrl;
    private String          country;
    private NumberOfReviews numberOfReviews;
    private String          status;
    private Score   score;
    private Boolean badFit;

}
