package com.ilink.weather.network;

import com.ilink.weather.model.WeatherParent;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ujjwalbansal on 08/04/18.
 */
public interface ApiInterface {
    @GET("forecast?")
    Call<WeatherParent> getWeatherDetails(@Query("q") String cityName, @Query("appid") String apiKey);
}
