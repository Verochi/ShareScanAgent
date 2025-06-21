package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class ItemDailyDetailWeatherBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final androidx.appcompat.widget.AppCompatTextView dailyDetailDu;

    @androidx.annotation.NonNull
    public final androidx.appcompat.widget.AppCompatTextView dailyDetailTemp;

    @androidx.annotation.NonNull
    public final android.view.View ivTip;

    @androidx.annotation.NonNull
    public final androidx.appcompat.widget.AppCompatImageView ivWeatherIcon;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout layoutBaseWeather;

    @androidx.annotation.NonNull
    public final moji.com.mjweather.databinding.ItemDailyDetailWeather2Binding layoutBlueSky;

    @androidx.annotation.NonNull
    public final moji.com.mjweather.databinding.ItemDailyDetailWeather2Binding layoutHumidity;

    @androidx.annotation.NonNull
    public final android.widget.FrameLayout layoutOtherWeather;

    @androidx.annotation.NonNull
    public final moji.com.mjweather.databinding.ItemDailyDetailWeather2Binding layoutPressure;

    @androidx.annotation.NonNull
    public final android.widget.FrameLayout layoutTip;

    @androidx.annotation.NonNull
    public final moji.com.mjweather.databinding.ItemDailyDetailWeather2Binding layoutUltraviolet;

    @androidx.annotation.NonNull
    public final android.widget.FrameLayout n;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView tvTimeInfo;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.dailydetails.view.DailyDetailAutoLineView tvWeatherWind;

    @androidx.annotation.NonNull
    public final android.widget.FrameLayout weatherDetail;

    public ItemDailyDetailWeatherBinding(@androidx.annotation.NonNull android.widget.FrameLayout frameLayout, @androidx.annotation.NonNull androidx.appcompat.widget.AppCompatTextView appCompatTextView, @androidx.annotation.NonNull androidx.appcompat.widget.AppCompatTextView appCompatTextView2, @androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull androidx.appcompat.widget.AppCompatImageView appCompatImageView, @androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout, @androidx.annotation.NonNull moji.com.mjweather.databinding.ItemDailyDetailWeather2Binding itemDailyDetailWeather2Binding, @androidx.annotation.NonNull moji.com.mjweather.databinding.ItemDailyDetailWeather2Binding itemDailyDetailWeather2Binding2, @androidx.annotation.NonNull android.widget.FrameLayout frameLayout2, @androidx.annotation.NonNull moji.com.mjweather.databinding.ItemDailyDetailWeather2Binding itemDailyDetailWeather2Binding3, @androidx.annotation.NonNull android.widget.FrameLayout frameLayout3, @androidx.annotation.NonNull moji.com.mjweather.databinding.ItemDailyDetailWeather2Binding itemDailyDetailWeather2Binding4, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView, @androidx.annotation.NonNull com.moji.mjweather.dailydetails.view.DailyDetailAutoLineView dailyDetailAutoLineView, @androidx.annotation.NonNull android.widget.FrameLayout frameLayout4) {
        this.n = frameLayout;
        this.dailyDetailDu = appCompatTextView;
        this.dailyDetailTemp = appCompatTextView2;
        this.ivTip = view;
        this.ivWeatherIcon = appCompatImageView;
        this.layoutBaseWeather = constraintLayout;
        this.layoutBlueSky = itemDailyDetailWeather2Binding;
        this.layoutHumidity = itemDailyDetailWeather2Binding2;
        this.layoutOtherWeather = frameLayout2;
        this.layoutPressure = itemDailyDetailWeather2Binding3;
        this.layoutTip = frameLayout3;
        this.layoutUltraviolet = itemDailyDetailWeather2Binding4;
        this.tvTimeInfo = mJTextView;
        this.tvWeatherWind = dailyDetailAutoLineView;
        this.weatherDetail = frameLayout4;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ItemDailyDetailWeatherBinding bind(@androidx.annotation.NonNull android.view.View view) {
        android.view.View findChildViewById;
        android.view.View findChildViewById2;
        android.view.View findChildViewById3;
        android.view.View findChildViewById4;
        com.moji.mjweather.dailydetails.view.DailyDetailAutoLineView findChildViewById5;
        int i = moji.com.mjweather.R.id.daily_detail_du;
        androidx.appcompat.widget.AppCompatTextView appCompatTextView = (androidx.appcompat.widget.AppCompatTextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (appCompatTextView != null) {
            i = moji.com.mjweather.R.id.daily_detail_temp;
            androidx.appcompat.widget.AppCompatTextView appCompatTextView2 = (androidx.appcompat.widget.AppCompatTextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (appCompatTextView2 != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.iv_tip))) != null) {
                i = moji.com.mjweather.R.id.iv_weather_icon;
                androidx.appcompat.widget.AppCompatImageView appCompatImageView = (androidx.appcompat.widget.AppCompatImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (appCompatImageView != null) {
                    i = moji.com.mjweather.R.id.layout_base_weather;
                    androidx.constraintlayout.widget.ConstraintLayout constraintLayout = (androidx.constraintlayout.widget.ConstraintLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (constraintLayout != null && (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.layout_blue_sky))) != null) {
                        moji.com.mjweather.databinding.ItemDailyDetailWeather2Binding bind = moji.com.mjweather.databinding.ItemDailyDetailWeather2Binding.bind(findChildViewById2);
                        i = moji.com.mjweather.R.id.layout_humidity;
                        android.view.View findChildViewById6 = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (findChildViewById6 != null) {
                            moji.com.mjweather.databinding.ItemDailyDetailWeather2Binding bind2 = moji.com.mjweather.databinding.ItemDailyDetailWeather2Binding.bind(findChildViewById6);
                            i = moji.com.mjweather.R.id.layout_other_weather;
                            android.widget.FrameLayout frameLayout = (android.widget.FrameLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (frameLayout != null && (findChildViewById3 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.layout_pressure))) != null) {
                                moji.com.mjweather.databinding.ItemDailyDetailWeather2Binding bind3 = moji.com.mjweather.databinding.ItemDailyDetailWeather2Binding.bind(findChildViewById3);
                                i = moji.com.mjweather.R.id.layout_tip;
                                android.widget.FrameLayout frameLayout2 = (android.widget.FrameLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                if (frameLayout2 != null && (findChildViewById4 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.layout_ultraviolet))) != null) {
                                    moji.com.mjweather.databinding.ItemDailyDetailWeather2Binding bind4 = moji.com.mjweather.databinding.ItemDailyDetailWeather2Binding.bind(findChildViewById4);
                                    i = moji.com.mjweather.R.id.tv_time_info;
                                    com.moji.textview.MJTextView findChildViewById7 = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                    if (findChildViewById7 != null && (findChildViewById5 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.tv_weather_wind))) != null) {
                                        android.widget.FrameLayout frameLayout3 = (android.widget.FrameLayout) view;
                                        return new moji.com.mjweather.databinding.ItemDailyDetailWeatherBinding(frameLayout3, appCompatTextView, appCompatTextView2, findChildViewById, appCompatImageView, constraintLayout, bind, bind2, frameLayout, bind3, frameLayout2, bind4, findChildViewById7, findChildViewById5, frameLayout3);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ItemDailyDetailWeatherBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ItemDailyDetailWeatherBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.item_daily_detail_weather, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public android.widget.FrameLayout getRoot() {
        return this.n;
    }
}
