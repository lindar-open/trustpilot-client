package com.lindar.trustpilot.api;

import com.lindar.trustpilot.exception.TrustpilotException;
import com.lindar.trustpilot.model.response.FindBusinessUnitResponse;
import com.lindar.wellrested.vo.Result;
import com.lindar.wellrested.vo.ResultBuilder;
import com.lindar.wellrested.vo.WellRestedResponse;
import lindar.acolyte.util.UrlAcolyte;

public class BusinessUnitsPublicResource extends AbstractResource {

    private final String BUSINESS_UNITS = "business-units/";

    private final String BUSINESS_UNITS_FIND = BUSINESS_UNITS + "find";

    public Result<FindBusinessUnitResponse> findBusinessUnit(String apiKey, String businessUnitName) throws TrustpilotException {
        WellRestedResponse response = doApiKeyGetRequest(apiKey, UrlAcolyte.addParam(BUSINESS_UNITS_FIND, "name", businessUnitName));
        return ResultBuilder.successful(response.fromJson().castTo(FindBusinessUnitResponse.class));
    }

}
