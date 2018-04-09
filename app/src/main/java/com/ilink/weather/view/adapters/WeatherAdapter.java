package com.ilink.weather.view.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.ilink.weather.R;
import com.ilink.weather.model.WeatherDataList;
import com.ilink.weather.utils.AppConstants;
import com.ilink.weather.view.holders.WeatherViewHolder;

import java.util.ArrayList;

/**
 * Created by ujjwalbansal on 09/04/18.
 */

public class WeatherAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context mContext;
    ArrayList<WeatherDataList> weatherDataLists;

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    public WeatherAdapter(Context context, ArrayList<WeatherDataList> weatherDataLists) {
        this.mContext = context;
        this.weatherDataLists = weatherDataLists;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.weather_report_list_items, null);
        WeatherViewHolder viewHolder = new WeatherViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof WeatherViewHolder) {
            WeatherDataList weatherObj = weatherDataLists.get(position);
            WeatherViewHolder weatherHolder = (WeatherViewHolder) holder;
            weatherHolder.tvDate.setText(weatherObj.getDtTxt());
            weatherHolder.tvWeatherDesc.setText(weatherObj.getWeather().get(0).getDescription());
            double Celsius = weatherObj.getMain().getTemp() - 273.15;
            weatherHolder.tvTemp.setText("" + Math.ceil(Celsius)+	"\u2103");
            String iconUrl = AppConstants.ICON_BASE_URL + weatherObj.getWeather().get(0).getIcon() + ".png";
            Glide.with(mContext).load(iconUrl).into(weatherHolder.imvIcon);

        }
    }

    @Override
    public int getItemCount() {
        return weatherDataLists.size();
    }
}
