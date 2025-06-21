package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class HomepageWeatherItemTodayTomorrowBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.view.View divider;

    @androidx.annotation.NonNull
    public final android.view.View n;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.weather.view.TwoDaysForecastItemView todayView;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.weather.view.TwoDaysForecastItemView tomorrowView;

    public HomepageWeatherItemTodayTomorrowBinding(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull android.view.View view2, @androidx.annotation.NonNull com.moji.mjweather.weather.view.TwoDaysForecastItemView twoDaysForecastItemView, @androidx.annotation.NonNull com.moji.mjweather.weather.view.TwoDaysForecastItemView twoDaysForecastItemView2) {
        this.n = view;
        this.divider = view2;
        this.todayView = twoDaysForecastItemView;
        this.tomorrowView = twoDaysForecastItemView2;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.HomepageWeatherItemTodayTomorrowBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.mjweather.weather.view.TwoDaysForecastItemView findChildViewById;
        com.moji.mjweather.weather.view.TwoDaysForecastItemView findChildViewById2;
        int i = moji.com.mjweather.R.id.divider;
        android.view.View findChildViewById3 = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (findChildViewById3 == null || (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.todayView))) == null || (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.tomorrowView))) == null) {
            throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new moji.com.mjweather.databinding.HomepageWeatherItemTodayTomorrowBinding(view, findChildViewById3, findChildViewById, findChildViewById2);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.HomepageWeatherItemTodayTomorrowBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.NonNull android.view.ViewGroup viewGroup) {
        if (viewGroup == null) {
            throw new java.lang.NullPointerException("parent");
        }
        layoutInflater.inflate(moji.com.mjweather.R.layout.homepage_weather_item_today_tomorrow, viewGroup);
        return bind(viewGroup);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public android.view.View getRoot() {
        return this.n;
    }
}
