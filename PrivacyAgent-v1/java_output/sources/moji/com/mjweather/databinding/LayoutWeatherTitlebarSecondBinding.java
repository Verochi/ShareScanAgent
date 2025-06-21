package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class LayoutWeatherTitlebarSecondBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final com.moji.imageview.MJImageView ivFeedBack;

    @androidx.annotation.NonNull
    public final com.moji.imageview.MJImageView ivLocation;

    @androidx.annotation.NonNull
    public final com.moji.imageview.MJImageView ivMore1;

    @androidx.annotation.NonNull
    public final com.moji.imageview.MJImageView ivMore2;

    @androidx.annotation.NonNull
    public final com.moji.imageview.MJImageView ivThirdWeatherIcon;

    @androidx.annotation.NonNull
    public final com.moji.imageview.MJImageView ivTodayWeatherIcon;

    @androidx.annotation.NonNull
    public final com.moji.imageview.MJImageView ivTomorrowWeatherIcon;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout llLayout;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout moreLayout;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout n;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.weather.view.StatusBarImageView statusBar;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout thirdLayout;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout todayLayout;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout tomorrowLayout;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView tvCityName;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView tvThird;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView tvTodayTemperature;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView tvTomorrow;

    @androidx.annotation.NonNull
    public final android.view.View vSeat;

    @androidx.annotation.NonNull
    public final android.view.View verticalLine1;

    @androidx.annotation.NonNull
    public final android.view.View verticalLine2;

    @androidx.annotation.NonNull
    public final android.view.View verticalLine3;

    public LayoutWeatherTitlebarSecondBinding(@androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout, @androidx.annotation.NonNull com.moji.imageview.MJImageView mJImageView, @androidx.annotation.NonNull com.moji.imageview.MJImageView mJImageView2, @androidx.annotation.NonNull com.moji.imageview.MJImageView mJImageView3, @androidx.annotation.NonNull com.moji.imageview.MJImageView mJImageView4, @androidx.annotation.NonNull com.moji.imageview.MJImageView mJImageView5, @androidx.annotation.NonNull com.moji.imageview.MJImageView mJImageView6, @androidx.annotation.NonNull com.moji.imageview.MJImageView mJImageView7, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout2, @androidx.annotation.NonNull com.moji.mjweather.weather.view.StatusBarImageView statusBarImageView, @androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout3, @androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout4, @androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout5, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView2, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView3, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView4, @androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull android.view.View view2, @androidx.annotation.NonNull android.view.View view3, @androidx.annotation.NonNull android.view.View view4) {
        this.n = constraintLayout;
        this.ivFeedBack = mJImageView;
        this.ivLocation = mJImageView2;
        this.ivMore1 = mJImageView3;
        this.ivMore2 = mJImageView4;
        this.ivThirdWeatherIcon = mJImageView5;
        this.ivTodayWeatherIcon = mJImageView6;
        this.ivTomorrowWeatherIcon = mJImageView7;
        this.llLayout = linearLayout;
        this.moreLayout = constraintLayout2;
        this.statusBar = statusBarImageView;
        this.thirdLayout = constraintLayout3;
        this.todayLayout = constraintLayout4;
        this.tomorrowLayout = constraintLayout5;
        this.tvCityName = mJTextView;
        this.tvThird = mJTextView2;
        this.tvTodayTemperature = mJTextView3;
        this.tvTomorrow = mJTextView4;
        this.vSeat = view;
        this.verticalLine1 = view2;
        this.verticalLine2 = view3;
        this.verticalLine3 = view4;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.LayoutWeatherTitlebarSecondBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.imageview.MJImageView findChildViewById;
        com.moji.imageview.MJImageView findChildViewById2;
        com.moji.imageview.MJImageView findChildViewById3;
        com.moji.imageview.MJImageView findChildViewById4;
        com.moji.imageview.MJImageView findChildViewById5;
        com.moji.imageview.MJImageView findChildViewById6;
        com.moji.mjweather.weather.view.StatusBarImageView findChildViewById7;
        com.moji.textview.MJTextView findChildViewById8;
        com.moji.textview.MJTextView findChildViewById9;
        com.moji.textview.MJTextView findChildViewById10;
        com.moji.textview.MJTextView findChildViewById11;
        android.view.View findChildViewById12;
        android.view.View findChildViewById13;
        android.view.View findChildViewById14;
        android.view.View findChildViewById15;
        int i = moji.com.mjweather.R.id.iv_feed_back;
        com.moji.imageview.MJImageView findChildViewById16 = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (findChildViewById16 != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.iv_location))) != null && (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.iv_more_1))) != null && (findChildViewById3 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.iv_more_2))) != null && (findChildViewById4 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.iv_third_weather_icon))) != null && (findChildViewById5 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.iv_today_weather_icon))) != null && (findChildViewById6 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.iv_tomorrow_weather_icon))) != null) {
            i = moji.com.mjweather.R.id.ll_layout;
            android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                i = moji.com.mjweather.R.id.more_layout;
                androidx.constraintlayout.widget.ConstraintLayout constraintLayout = (androidx.constraintlayout.widget.ConstraintLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (constraintLayout != null && (findChildViewById7 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.status_bar))) != null) {
                    i = moji.com.mjweather.R.id.third_layout;
                    androidx.constraintlayout.widget.ConstraintLayout constraintLayout2 = (androidx.constraintlayout.widget.ConstraintLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (constraintLayout2 != null) {
                        i = moji.com.mjweather.R.id.today_layout;
                        androidx.constraintlayout.widget.ConstraintLayout constraintLayout3 = (androidx.constraintlayout.widget.ConstraintLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (constraintLayout3 != null) {
                            i = moji.com.mjweather.R.id.tomorrow_layout;
                            androidx.constraintlayout.widget.ConstraintLayout constraintLayout4 = (androidx.constraintlayout.widget.ConstraintLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (constraintLayout4 != null && (findChildViewById8 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.tv_city_name))) != null && (findChildViewById9 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.tv_third))) != null && (findChildViewById10 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.tv_today_temperature))) != null && (findChildViewById11 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.tv_tomorrow))) != null && (findChildViewById12 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.v_seat))) != null && (findChildViewById13 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.vertical_line_1))) != null && (findChildViewById14 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.vertical_line_2))) != null && (findChildViewById15 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.vertical_line_3))) != null) {
                                return new moji.com.mjweather.databinding.LayoutWeatherTitlebarSecondBinding((androidx.constraintlayout.widget.ConstraintLayout) view, findChildViewById16, findChildViewById, findChildViewById2, findChildViewById3, findChildViewById4, findChildViewById5, findChildViewById6, linearLayout, constraintLayout, findChildViewById7, constraintLayout2, constraintLayout3, constraintLayout4, findChildViewById8, findChildViewById9, findChildViewById10, findChildViewById11, findChildViewById12, findChildViewById13, findChildViewById14, findChildViewById15);
                            }
                        }
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.LayoutWeatherTitlebarSecondBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.LayoutWeatherTitlebarSecondBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.layout_weather_titlebar_second, viewGroup, false);
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
