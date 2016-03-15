package com.red.maks.weatherwarsaw.services;

import com.red.maks.weatherwarsaw.data.Channel;

/**
 * Created by Maks on 3/8/2016.
 */
public interface WeatherServiceCallback {
    void serviceSuccess(Channel channel);

    void serviceFailure(Exception exception);
}
