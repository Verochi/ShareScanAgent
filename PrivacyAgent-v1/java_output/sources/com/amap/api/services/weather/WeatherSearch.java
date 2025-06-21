package com.amap.api.services.weather;

/* loaded from: classes12.dex */
public class WeatherSearch {
    private com.amap.api.services.interfaces.IWeatherSearch a;

    public interface OnWeatherSearchListener {
        void onWeatherForecastSearched(com.amap.api.services.weather.LocalWeatherForecastResult localWeatherForecastResult, int i);

        void onWeatherLiveSearched(com.amap.api.services.weather.LocalWeatherLiveResult localWeatherLiveResult, int i);
    }

    public WeatherSearch(android.content.Context context) throws com.amap.api.services.core.AMapException {
        this.a = null;
        try {
            this.a = new com.amap.api.col.s.bg(context);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            if (e instanceof com.amap.api.services.core.AMapException) {
                throw ((com.amap.api.services.core.AMapException) e);
            }
        }
    }

    public com.amap.api.services.weather.WeatherSearchQuery getQuery() {
        com.amap.api.services.interfaces.IWeatherSearch iWeatherSearch = this.a;
        if (iWeatherSearch != null) {
            return iWeatherSearch.getQuery();
        }
        return null;
    }

    public void searchWeatherAsyn() {
        com.amap.api.services.interfaces.IWeatherSearch iWeatherSearch = this.a;
        if (iWeatherSearch != null) {
            iWeatherSearch.searchWeatherAsyn();
        }
    }

    public void setOnWeatherSearchListener(com.amap.api.services.weather.WeatherSearch.OnWeatherSearchListener onWeatherSearchListener) {
        com.amap.api.services.interfaces.IWeatherSearch iWeatherSearch = this.a;
        if (iWeatherSearch != null) {
            iWeatherSearch.setOnWeatherSearchListener(onWeatherSearchListener);
        }
    }

    public void setQuery(com.amap.api.services.weather.WeatherSearchQuery weatherSearchQuery) {
        com.amap.api.services.interfaces.IWeatherSearch iWeatherSearch = this.a;
        if (iWeatherSearch != null) {
            iWeatherSearch.setQuery(weatherSearchQuery);
        }
    }
}
