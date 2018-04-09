package com.ilink.weather.view.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.ilink.weather.utils.GeneralUtils;
import com.ilink.weather.view.ViewMaster;


public abstract class BaseFragment extends Fragment implements ViewMaster {

    abstract void initialize();

    abstract void initializePresenter();

    ProgressBar progressBar;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        progressBar = new ProgressBar(getActivity());
        initializePresenter();
    }

    @Override
    public void showLoading() {
        GeneralUtils.showProgressBar(getActivity(), "");
    }

    @Override
    public void hideLoading() {
        GeneralUtils.dismissProgressBar(getActivity());
    }

    @Override
    public void showError(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }
}
