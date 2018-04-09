package com.ilink.weather.view;


import com.ilink.weather.model.WeatherDataList;

import java.util.ArrayList;

public interface WeatherSuccessView extends ViewMaster {
    void showWeatherSuccess(ArrayList<WeatherDataList> weatherDataList);
}
