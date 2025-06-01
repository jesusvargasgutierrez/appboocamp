package com.example.countryapp.Request;

import com.example.countryapp.data.model.Schedules;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApiResponse {
    public boolean success;
    private String message;

    @SerializedName("information")
    private List<Schedules> information;

    public List<Schedules> getInformation() {
        return information;
    }

    public void setInformation(List<Schedules> information) {
        this.information = information;
    }


    public String error;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() { // <- getter correcto
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
