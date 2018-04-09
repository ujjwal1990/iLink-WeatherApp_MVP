package com.ilink.weather.eventhandlers;


import com.ilink.weather.model.WeatherParent;

public class GenericResponse {

    private String responseCode;
    private String errorMessage;
    private String responseDescription;
    private int operationStatus;
    private WeatherParent responseData;

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getResponseDescription() {
        return responseDescription;
    }

    public void setResponseDescription(String responseDescription) {
        this.responseDescription = responseDescription;
    }

    public int getOperationStatus() {
        return operationStatus;
    }

    public void setOperationStatus(int operationStatus) {
        this.operationStatus = operationStatus;
    }

    public WeatherParent getResponseData() {
        return responseData;
    }

    public void setResponseData(WeatherParent genericResponse) {
        this.responseData = genericResponse;
    }
}
