package com.lindar.trustpilot.api;

import com.lindar.trustpilot.model.response.FindBusinessUnitResponse;
import com.lindar.wellrested.WellRestedRequest;

import java.util.HashMap;
import java.util.Map;

public class BusinessUnitsPublicResource extends AbstractResource {

    private final String BUSINESS_UNITS = "business-units/";

    private final String BUSINESS_UNITS_FIND = BUSINESS_UNITS + "find";

    public FindBusinessUnitResponse findBusinessUnit(String apiKey, String businessUnitName) {
        Map<String, String>  parameters = new HashMap<>();
        parameters.put("name", businessUnitName);
        return WellRestedRequest.builder().url(BASE_URL + BUSINESS_UNITS_FIND).addGlobalHeader("apikey", apiKey).build().get().submit().fromJson().castTo(
                FindBusinessUnitResponse.class);
    }

}
