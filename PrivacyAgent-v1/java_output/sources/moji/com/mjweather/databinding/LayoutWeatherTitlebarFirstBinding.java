package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class LayoutWeatherTitlebarFirstBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.TextView areaNameTv;

    @androidx.annotation.NonNull
    public final android.view.View cityNameClickLayout;

    @androidx.annotation.NonNull
    public final com.moji.imageview.MJImageView ivAbnormalArrowIcon;

    @androidx.annotation.NonNull
    public final com.moji.imageview.MJImageView ivAddCity;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivStatusIcon;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout llStatus;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout n;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout rlAbnormalArrowLayout;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout rlCityName;

    @androidx.annotation.NonNull
    public final com.moji.imageview.MJImageView shareIv;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.weather.view.StatusBarImageView statusBar;

    @androidx.annotation.NonNull
    public final android.widget.TextView statusText;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.weather.view.WeatherPageCircleIndicator vpiIndicator;

    public LayoutWeatherTitlebarFirstBinding(@androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull com.moji.imageview.MJImageView mJImageView, @androidx.annotation.NonNull com.moji.imageview.MJImageView mJImageView2, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout, @androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout2, @androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout3, @androidx.annotation.NonNull com.moji.imageview.MJImageView mJImageView3, @androidx.annotation.NonNull com.moji.mjweather.weather.view.StatusBarImageView statusBarImageView, @androidx.annotation.NonNull android.widget.TextView textView2, @androidx.annotation.NonNull com.moji.mjweather.weather.view.WeatherPageCircleIndicator weatherPageCircleIndicator) {
        this.n = constraintLayout;
        this.areaNameTv = textView;
        this.cityNameClickLayout = view;
        this.ivAbnormalArrowIcon = mJImageView;
        this.ivAddCity = mJImageView2;
        this.ivStatusIcon = imageView;
        this.llStatus = relativeLayout;
        this.rlAbnormalArrowLayout = relativeLayout2;
        this.rlCityName = relativeLayout3;
        this.shareIv = mJImageView3;
        this.statusBar = statusBarImageView;
        this.statusText = textView2;
        this.vpiIndicator = weatherPageCircleIndicator;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.LayoutWeatherTitlebarFirstBinding bind(@androidx.annotation.NonNull android.view.View view) {
        android.view.View findChildViewById;
        com.moji.imageview.MJImageView findChildViewById2;
        com.moji.imageview.MJImageView findChildViewById3;
        com.moji.imageview.MJImageView findChildViewById4;
        com.moji.mjweather.weather.view.StatusBarImageView findChildViewById5;
        com.moji.mjweather.weather.view.WeatherPageCircleIndicator findChildViewById6;
        int i = moji.com.mjweather.R.id.area_name_tv;
        android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (textView != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.city_name_click_layout))) != null && (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.iv_abnormal_arrow_icon))) != null && (findChildViewById3 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.iv_add_city))) != null) {
            i = moji.com.mjweather.R.id.iv_status_icon;
            android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = moji.com.mjweather.R.id.ll_status;
                android.widget.RelativeLayout relativeLayout = (android.widget.RelativeLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (relativeLayout != null) {
                    i = moji.com.mjweather.R.id.rl_abnormal_arrow_layout;
                    android.widget.RelativeLayout relativeLayout2 = (android.widget.RelativeLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (relativeLayout2 != null) {
                        i = moji.com.mjweather.R.id.rl_city_name;
                        android.widget.RelativeLayout relativeLayout3 = (android.widget.RelativeLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (relativeLayout3 != null && (findChildViewById4 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.share_iv))) != null && (findChildViewById5 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.status_bar))) != null) {
                            i = moji.com.mjweather.R.id.status_text;
                            android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (textView2 != null && (findChildViewById6 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.vpi_indicator))) != null) {
                                return new moji.com.mjweather.databinding.LayoutWeatherTitlebarFirstBinding((androidx.constraintlayout.widget.ConstraintLayout) view, textView, findChildViewById, findChildViewById2, findChildViewById3, imageView, relativeLayout, relativeLayout2, relativeLayout3, findChildViewById4, findChildViewById5, textView2, findChildViewById6);
                            }
                        }
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.LayoutWeatherTitlebarFirstBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.LayoutWeatherTitlebarFirstBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.layout_weather_titlebar_first, viewGroup, false);
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
