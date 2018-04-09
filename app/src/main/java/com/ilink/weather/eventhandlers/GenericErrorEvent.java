package com.ilink.weather.eventhandlers;



public class GenericErrorEvent {

    public String errorString;

    public GenericErrorEvent(String errorString) {
        this.errorString = errorString;
    }
}
