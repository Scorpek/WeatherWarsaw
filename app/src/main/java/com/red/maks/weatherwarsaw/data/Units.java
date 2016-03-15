package com.red.maks.weatherwarsaw.data;

import org.json.JSONObject;

/**
 * Created by Maks on 3/8/2016.
 */
public class Units implements JSONPopulator
{
    private String temperature;

    public String getTemperature() {
        return temperature;
    }

    @Override
    public void populate(JSONObject data) {

        temperature = data.optString("temperature");

    }
}
