package com.ilink.weather.view.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ilink.weather.R;
import com.ilink.weather.model.WeatherDataList;
import com.ilink.weather.network.WeatherDataManager;
import com.ilink.weather.presenter.WeatherPresenter;
import com.ilink.weather.utils.GeneralUtils;
import com.ilink.weather.view.WeatherSuccessView;
import com.ilink.weather.view.adapters.WeatherAdapter;

import java.util.ArrayList;

/**
 * Created by ujjwalbansal on 09/04/18.
 */

public class WeatherListFragment extends BaseFragment implements View.OnClickListener, WeatherSuccessView {

    private View rootView;
    RecyclerView rvWeatherList;
    EditText edtCityName;
    Button btnSearch;
    private WeatherPresenter weatherPresenter;

    /***
     * used to pass values in bundle from one fargment to another
     * @return
     */
    public static WeatherListFragment newInstance() {
        Bundle args = new Bundle();
        WeatherListFragment fragment = new WeatherListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        rootView = inflater.inflate(R.layout.fragment_weather, container, false);
        initialize();
        return rootView;
    }

    @Override
    void initializePresenter() {
        weatherPresenter = new WeatherPresenter(this, new WeatherDataManager());
        weatherPresenter.registerEventBus();
    }

    @Override
    void initialize() {
        rvWeatherList = rootView.findViewById(R.id.rv_weather_details);
        edtCityName = rootView.findViewById(R.id.edt_city_name);
        btnSearch = rootView.findViewById(R.id.btn_search);

        LinearLayoutManager llmanager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        rvWeatherList.setLayoutManager(llmanager);
        DividerItemDecoration mDividerItemDecoration = new DividerItemDecoration(rvWeatherList.getContext(),
                llmanager.getOrientation());
        rvWeatherList.addItemDecoration(mDividerItemDecoration);
        btnSearch.setOnClickListener(this);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        weatherPresenter.unRegisterEventBus();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_search:
                GeneralUtils.hideKeyBoard(getActivity(), edtCityName);
                String cityQuery = edtCityName.getText().toString();
                if (cityQuery != null && !cityQuery.isEmpty())
                    weatherPresenter.getWeatherData(cityQuery);
                else
                    Toast.makeText(getActivity(), getString(R.string.city_name), Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void showWeatherSuccess(ArrayList<WeatherDataList> weatherDataList) {
        Log.i("", "" + weatherDataList);
        rvWeatherList.setAdapter(new WeatherAdapter(getActivity(), weatherDataList));
    }
}
