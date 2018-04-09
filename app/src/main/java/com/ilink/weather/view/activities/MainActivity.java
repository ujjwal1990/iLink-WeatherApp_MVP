package com.ilink.weather.view.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ilink.weather.R;
import com.ilink.weather.view.fragments.WeatherListFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.container_fragment, WeatherListFragment.newInstance()).commit();

    }
}

