package com.amap.api.services.weather;

/* loaded from: classes12.dex */
public class LocalWeatherForecastResult {
    private com.amap.api.services.weather.WeatherSearchQuery a;
    private com.amap.api.services.weather.LocalWeatherForecast b;

    private LocalWeatherForecastResult(com.amap.api.services.weather.WeatherSearchQuery weatherSearchQuery, com.amap.api.services.weather.LocalWeatherForecast localWeatherForecast) {
        this.a = weatherSearchQuery;
        this.b = localWeatherForecast;
    }

    public static com.amap.api.services.weather.LocalWeatherForecastResult createPagedResult(com.amap.api.services.weather.WeatherSearchQuery weatherSearchQuery, com.amap.api.services.weather.LocalWeatherForecast localWeatherForecast) {
        return new com.amap.api.services.weather.LocalWeatherForecastResult(weatherSearchQuery, localWeatherForecast);
    }

    public com.amap.api.services.weather.LocalWeatherForecast getForecastResult() {
        return this.b;
    }

    public com.amap.api.services.weather.WeatherSearchQuery getWeatherForecastQuery() {
        return this.a;
    }
}
