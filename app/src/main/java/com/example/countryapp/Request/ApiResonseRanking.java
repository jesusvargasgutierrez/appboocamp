package com.example.countryapp.Request;

import com.example.countryapp.data.model.Rankings;
import com.example.countryapp.data.model.Schedules;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApiResonseRanking {
    public boolean success;
    private String message;

    @SerializedName("information")
    private List<Rankings> information;

    public List<Rankings> getInformation() {
        return information;
    }

    public void setInformation(List<Rankings> information) {
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
