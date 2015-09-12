package com.land.farm.interfaces;


import com.land.farm.models.Weather;

import java.util.ArrayList;

public interface WeatherCallback {
    void onSuccess(ArrayList<Weather> result);

}
