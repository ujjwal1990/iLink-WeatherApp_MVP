package com.ilink.weather.network;

import android.util.Log;

import com.ilink.weather.eventhandlers.GenericErrorEvent;
import com.ilink.weather.eventhandlers.WeatherEvent;
import com.ilink.weather.model.WeatherParent;
import com.ilink.weather.utils.AppConstants;

import org.greenrobot.eventbus.EventBus;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ujjwalbansal on 09/04/18.
 */

public class WeatherDataManager {
    public void getWeatherDataByCityName(String cityName) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<WeatherParent> call = apiService.getWeatherDetails(cityName, AppConstants.API_KEY);
        call.enqueue(new Callback<WeatherParent>() {
            @Override
            public void onResponse(Call<WeatherParent> call, Response<WeatherParent> response) {
                if (response != null && response.isSuccessful()) {
                    EventBus.getDefault().post(new WeatherEvent(response.body()));
                } else {
                    if (response != null && response.body() != null)
                        EventBus.getDefault().post(new GenericErrorEvent(response.body().getErrorMessage()));
                    else
                        EventBus.getDefault().post(new GenericErrorEvent(""+response));
                }
            }

            @Override
            public void onFailure(Call<WeatherParent> call, Throwable t) {
                Log.d(AppConstants.API_TAG, "getWeatherData - onError " + t.getMessage());
                EventBus.getDefault().post(new GenericErrorEvent(t.toString()));
            }
        });
    }
}
