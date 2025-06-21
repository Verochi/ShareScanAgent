package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class ActivityMoreDaysCoverLayoutBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout coverLayout;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.dailydetails.view.DailyDetail360HourView hour360View;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.dailydetails.view.WeatherCurveView indicator;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.dailydetails.view.WeatherCurveScrollView indicatorScrollView;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout n;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.dailydetails.view.DailyDetailWeatherInfoView weatherInfo;

    public ActivityMoreDaysCoverLayoutBinding(@androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout, @androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout2, @androidx.annotation.NonNull com.moji.mjweather.dailydetails.view.DailyDetail360HourView dailyDetail360HourView, @androidx.annotation.NonNull com.moji.mjweather.dailydetails.view.WeatherCurveView weatherCurveView, @androidx.annotation.NonNull com.moji.mjweather.dailydetails.view.WeatherCurveScrollView weatherCurveScrollView, @androidx.annotation.NonNull com.moji.mjweather.dailydetails.view.DailyDetailWeatherInfoView dailyDetailWeatherInfoView) {
        this.n = constraintLayout;
        this.coverLayout = constraintLayout2;
        this.hour360View = dailyDetail360HourView;
        this.indicator = weatherCurveView;
        this.indicatorScrollView = weatherCurveScrollView;
        this.weatherInfo = dailyDetailWeatherInfoView;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ActivityMoreDaysCoverLayoutBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.mjweather.dailydetails.view.WeatherCurveView findChildViewById;
        com.moji.mjweather.dailydetails.view.WeatherCurveScrollView findChildViewById2;
        com.moji.mjweather.dailydetails.view.DailyDetailWeatherInfoView findChildViewById3;
        androidx.constraintlayout.widget.ConstraintLayout constraintLayout = (androidx.constraintlayout.widget.ConstraintLayout) view;
        int i = moji.com.mjweather.R.id.hour_360_view;
        com.moji.mjweather.dailydetails.view.DailyDetail360HourView findChildViewById4 = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (findChildViewById4 == null || (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.indicator))) == null || (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.indicator_scroll_view))) == null || (findChildViewById3 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.weather_info))) == null) {
            throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new moji.com.mjweather.databinding.ActivityMoreDaysCoverLayoutBinding(constraintLayout, constraintLayout, findChildViewById4, findChildViewById, findChildViewById2, findChildViewById3);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ActivityMoreDaysCoverLayoutBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ActivityMoreDaysCoverLayoutBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.activity_more_days_cover_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public androidx.constraintlayout.widget.ConstraintLayout getRoot() {
        return this.n;
    }
}
