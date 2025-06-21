package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class HomepageWeatherItemTodayTomorrowFor10Binding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final com.moji.shadow.ShadowLayout clTwoDaysForecast;

    @androidx.annotation.NonNull
    public final android.view.View divider;

    @androidx.annotation.NonNull
    public final com.airbnb.lottie.LottieAnimationView lottieSlideAnim;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout moreInfo;

    @androidx.annotation.NonNull
    public final android.view.View n;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.weather.view.TwoDaysForecastItemViewFor10 todayView;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.weather.view.TwoDaysForecastItemViewFor10 tomorrowView;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvMore1;

    @androidx.annotation.NonNull
    public final com.moji.imageview.MJImageView tvMore2;

    public HomepageWeatherItemTodayTomorrowFor10Binding(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull com.moji.shadow.ShadowLayout shadowLayout, @androidx.annotation.NonNull android.view.View view2, @androidx.annotation.NonNull com.airbnb.lottie.LottieAnimationView lottieAnimationView, @androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout, @androidx.annotation.NonNull com.moji.mjweather.weather.view.TwoDaysForecastItemViewFor10 twoDaysForecastItemViewFor10, @androidx.annotation.NonNull com.moji.mjweather.weather.view.TwoDaysForecastItemViewFor10 twoDaysForecastItemViewFor102, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull com.moji.imageview.MJImageView mJImageView) {
        this.n = view;
        this.clTwoDaysForecast = shadowLayout;
        this.divider = view2;
        this.lottieSlideAnim = lottieAnimationView;
        this.moreInfo = constraintLayout;
        this.todayView = twoDaysForecastItemViewFor10;
        this.tomorrowView = twoDaysForecastItemViewFor102;
        this.tvMore1 = textView;
        this.tvMore2 = mJImageView;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.HomepageWeatherItemTodayTomorrowFor10Binding bind(@androidx.annotation.NonNull android.view.View view) {
        android.view.View findChildViewById;
        com.moji.mjweather.weather.view.TwoDaysForecastItemViewFor10 findChildViewById2;
        com.moji.mjweather.weather.view.TwoDaysForecastItemViewFor10 findChildViewById3;
        com.moji.imageview.MJImageView findChildViewById4;
        int i = moji.com.mjweather.R.id.cl_two_days_forecast;
        com.moji.shadow.ShadowLayout findChildViewById5 = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (findChildViewById5 != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.divider))) != null) {
            i = moji.com.mjweather.R.id.lottie_slide_anim;
            com.airbnb.lottie.LottieAnimationView lottieAnimationView = (com.airbnb.lottie.LottieAnimationView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (lottieAnimationView != null) {
                i = moji.com.mjweather.R.id.moreInfo;
                androidx.constraintlayout.widget.ConstraintLayout constraintLayout = (androidx.constraintlayout.widget.ConstraintLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (constraintLayout != null && (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.todayView))) != null && (findChildViewById3 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.tomorrowView))) != null) {
                    i = moji.com.mjweather.R.id.tv_more_1;
                    android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (textView != null && (findChildViewById4 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.tv_more_2))) != null) {
                        return new moji.com.mjweather.databinding.HomepageWeatherItemTodayTomorrowFor10Binding(view, findChildViewById5, findChildViewById, lottieAnimationView, constraintLayout, findChildViewById2, findChildViewById3, textView, findChildViewById4);
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.HomepageWeatherItemTodayTomorrowFor10Binding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.NonNull android.view.ViewGroup viewGroup) {
        if (viewGroup == null) {
            throw new java.lang.NullPointerException("parent");
        }
        layoutInflater.inflate(moji.com.mjweather.R.layout.homepage_weather_item_today_tomorrow_for_10, viewGroup);
        return bind(viewGroup);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public android.view.View getRoot() {
        return this.n;
    }
}
