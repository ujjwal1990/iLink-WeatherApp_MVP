package com.ilink.weather.view;


public interface ViewMaster {
    void showLoading();
    void hideLoading();
    void showError(String message);
}
