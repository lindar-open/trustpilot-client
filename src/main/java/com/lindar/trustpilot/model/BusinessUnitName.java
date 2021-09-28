package com.lindar.trustpilot.model;

import lombok.Data;

import java.util.List;

@Data
public class BusinessUnitName {

    private String       identifying;
    private List<String> referring;

}
