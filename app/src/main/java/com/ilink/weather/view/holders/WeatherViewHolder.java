package com.ilink.weather.view.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ilink.weather.R;

/**
 * Created by ujjwalbansal on 09/04/18.
 */

public class WeatherViewHolder extends RecyclerView.ViewHolder {
    public ImageView imvIcon;
    public TextView tvWeatherDesc;
    public TextView tvTemp;
    public TextView tvDate;

    public WeatherViewHolder(View itemView) {
        super(itemView);
        imvIcon = itemView.findViewById(R.id.imv_weather_icon);
        tvWeatherDesc = itemView.findViewById(R.id.tv_weather_desc);
        tvTemp = itemView.findViewById(R.id.tv_temp);
        tvDate = itemView.findViewById(R.id.tv_date);
    }
}
