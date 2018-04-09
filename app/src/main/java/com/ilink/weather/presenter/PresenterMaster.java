package com.ilink.weather.presenter;

import android.util.Log;

import com.ilink.weather.utils.AppConstants;

import org.greenrobot.eventbus.EventBus;

public class PresenterMaster {
    public void registerEventBus() {
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
            Log.d(AppConstants.EVENT_LOG_TAG, "Event Bus Registered for " + this);
        }
    }

    public void unRegisterEventBus() {
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
            Log.d(AppConstants.EVENT_LOG_TAG, "Event Bus Un-Registered for " + this);
        }
    }
}