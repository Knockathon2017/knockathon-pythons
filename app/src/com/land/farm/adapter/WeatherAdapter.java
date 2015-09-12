package com.land.farm.adapter;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.land.farm.R;
import com.land.farm.models.Weather;

import java.util.ArrayList;

public class WeatherAdapter extends ArrayAdapter<Weather> {

    protected ArrayList<Weather> _weather;
    private Activity _myContext;

    public WeatherAdapter(Context context, int resourceId, ArrayList<Weather> weather) {
        super(context, resourceId, weather);

        _myContext = (Activity) context;
        _weather = weather;

    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = _myContext.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.adapter_ticker, null);

        if (_weather.get(position) != null) {
            TextView tempView = (TextView) rowView.findViewById(R.id.tempView);
            TextView pressureView = (TextView) rowView.findViewById(R.id.pressureView);
            
            tempView.setText(_weather.get(position).temperature);
            pressureView.setText(_weather.get(position).pressure);
        }

        return rowView;
    }
}
