package com.example.countryapp.Request;

public class ApiResponse {
    public boolean success;
    private String message;

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
