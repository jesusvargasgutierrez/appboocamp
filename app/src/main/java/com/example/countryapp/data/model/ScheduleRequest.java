package com.example.countryapp.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

public class ScheduleRequest {
    @SerializedName("_token")
    private String token;

    @SerializedName("EndpointName")
    private String endpointName;

    @SerializedName("where")
    private List<Map<String, Object>> where;

    public ScheduleRequest(String token, String endpointName, List<Map<String, Object>> where) {
        this.token = token;
        this.endpointName = endpointName;
        this.where = where;
    }
}
