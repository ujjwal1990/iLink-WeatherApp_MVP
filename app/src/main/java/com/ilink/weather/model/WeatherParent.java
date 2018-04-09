
package com.ilink.weather.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.ilink.weather.eventhandlers.GenericResponse;

import java.util.ArrayList;

public class WeatherParent extends GenericResponse{

    @SerializedName("cod")
    @Expose
    private String cod;
    @SerializedName("message")
    @Expose
    private Double message;
    @SerializedName("cnt")
    @Expose
    private Integer cnt;
    @SerializedName("list")
    @Expose
    private ArrayList<WeatherDataList> weatherDataLists = null;
    @SerializedName("city")
    @Expose
    private City city;

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public Double getMessage() {
        return message;
    }

    public void setMessage(Double message) {
        this.message = message;
    }

    public Integer getCnt() {
        return cnt;
    }

    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }

    public ArrayList<WeatherDataList> getWeatherDataLists() {
        return weatherDataLists;
    }

    public void setWeatherDataLists(ArrayList<WeatherDataList> weatherDataLists) {
        this.weatherDataLists = weatherDataLists;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

}
