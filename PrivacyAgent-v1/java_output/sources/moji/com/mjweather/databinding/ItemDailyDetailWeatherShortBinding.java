package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class ItemDailyDetailWeatherShortBinding implements androidx.viewbinding.ViewBinding {

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
    public final android.widget.FrameLayout layoutTip;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout n;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView tvTimeInfo;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.dailydetails.view.DailyDetailAutoLineView tvWeatherWind;

    public ItemDailyDetailWeatherShortBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull androidx.appcompat.widget.AppCompatTextView appCompatTextView, @androidx.annotation.NonNull androidx.appcompat.widget.AppCompatTextView appCompatTextView2, @androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull androidx.appcompat.widget.AppCompatImageView appCompatImageView, @androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout, @androidx.annotation.NonNull android.widget.FrameLayout frameLayout, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView, @androidx.annotation.NonNull com.moji.mjweather.dailydetails.view.DailyDetailAutoLineView dailyDetailAutoLineView) {
        this.n = linearLayout;
        this.dailyDetailDu = appCompatTextView;
        this.dailyDetailTemp = appCompatTextView2;
        this.ivTip = view;
        this.ivWeatherIcon = appCompatImageView;
        this.layoutBaseWeather = constraintLayout;
        this.layoutTip = frameLayout;
        this.tvTimeInfo = mJTextView;
        this.tvWeatherWind = dailyDetailAutoLineView;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ItemDailyDetailWeatherShortBinding bind(@androidx.annotation.NonNull android.view.View view) {
        android.view.View findChildViewById;
        com.moji.textview.MJTextView findChildViewById2;
        com.moji.mjweather.dailydetails.view.DailyDetailAutoLineView findChildViewById3;
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
                    if (constraintLayout != null) {
                        i = moji.com.mjweather.R.id.layout_tip;
                        android.widget.FrameLayout frameLayout = (android.widget.FrameLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (frameLayout != null && (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.tv_time_info))) != null && (findChildViewById3 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.tv_weather_wind))) != null) {
                            return new moji.com.mjweather.databinding.ItemDailyDetailWeatherShortBinding((android.widget.LinearLayout) view, appCompatTextView, appCompatTextView2, findChildViewById, appCompatImageView, constraintLayout, frameLayout, findChildViewById2, findChildViewById3);
                        }
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ItemDailyDetailWeatherShortBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ItemDailyDetailWeatherShortBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.item_daily_detail_weather_short, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public android.widget.LinearLayout getRoot() {
        return this.n;
    }
}
