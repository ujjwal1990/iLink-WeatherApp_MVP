package com.ilink.weather.presenter;

import com.ilink.weather.eventhandlers.GenericErrorEvent;
import com.ilink.weather.eventhandlers.WeatherEvent;
import com.ilink.weather.model.WeatherParent;
import com.ilink.weather.network.WeatherDataManager;
import com.ilink.weather.view.WeatherSuccessView;

import org.greenrobot.eventbus.Subscribe;


public class WeatherPresenter extends PresenterMaster {

    private WeatherSuccessView weatherSuccessView;
    private WeatherDataManager weatherDataManager;

    public WeatherPresenter(WeatherSuccessView weatherSuccessView, WeatherDataManager weatherDataManager) {
        this.weatherSuccessView = weatherSuccessView;
        this.weatherDataManager = weatherDataManager;
    }

    public void getWeatherData(String query) {
        weatherSuccessView.showLoading();
        weatherDataManager.getWeatherDataByCityName(query);
    }

    @Subscribe
    public void onEvent(WeatherEvent weatherEvent) {
        weatherSuccessView.hideLoading();
        weatherSuccessView.showWeatherSuccess(((WeatherParent) weatherEvent.genericResponse).getWeatherDataLists());
    }

    @Subscribe
    public void onEvent(GenericErrorEvent genericErrorEvent) {
        weatherSuccessView.hideLoading();
        weatherSuccessView.showError(genericErrorEvent.errorString);
    }
}
