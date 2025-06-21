package com.amap.api.services.interfaces;

/* loaded from: classes12.dex */
public interface IWeatherSearch {
    com.amap.api.services.weather.WeatherSearchQuery getQuery();

    void searchWeatherAsyn();

    void setOnWeatherSearchListener(com.amap.api.services.weather.WeatherSearch.OnWeatherSearchListener onWeatherSearchListener);

    void setQuery(com.amap.api.services.weather.WeatherSearchQuery weatherSearchQuery);
}
