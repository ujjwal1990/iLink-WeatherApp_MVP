package com.ilink.weather.eventhandlers;


public class WeatherEvent {
    public GenericResponse genericResponse;

    public WeatherEvent(GenericResponse genericResponse) {
        this.genericResponse = genericResponse;
    }
}
