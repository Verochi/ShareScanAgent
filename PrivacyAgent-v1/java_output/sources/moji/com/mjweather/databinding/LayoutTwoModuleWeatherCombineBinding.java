package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class LayoutTwoModuleWeatherCombineBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout contentLayout;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivDay2Select;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivHour24Select;

    @androidx.annotation.NonNull
    public final com.airbnb.lottie.LottieAnimationView lottieMinute;

    @androidx.annotation.NonNull
    public final android.view.View lottieMinuteBg;

    @androidx.annotation.NonNull
    public final android.view.View n;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.weather.view.MainShortViewS5 shortView;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout tabLayout;

    @androidx.annotation.NonNull
    public final android.view.View tabLayoutBackground;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView tvDay2Tab;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView tvHour24Tab;

    @androidx.annotation.NonNull
    public final android.view.View vSpace1;

    @androidx.annotation.NonNull
    public final android.view.View viewDay2Bg;

    public LayoutTwoModuleWeatherCombineBinding(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.ImageView imageView2, @androidx.annotation.NonNull com.airbnb.lottie.LottieAnimationView lottieAnimationView, @androidx.annotation.NonNull android.view.View view2, @androidx.annotation.NonNull com.moji.mjweather.weather.view.MainShortViewS5 mainShortViewS5, @androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout, @androidx.annotation.NonNull android.view.View view3, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView2, @androidx.annotation.NonNull android.view.View view4, @androidx.annotation.NonNull android.view.View view5) {
        this.n = view;
        this.contentLayout = relativeLayout;
        this.ivDay2Select = imageView;
        this.ivHour24Select = imageView2;
        this.lottieMinute = lottieAnimationView;
        this.lottieMinuteBg = view2;
        this.shortView = mainShortViewS5;
        this.tabLayout = constraintLayout;
        this.tabLayoutBackground = view3;
        this.tvDay2Tab = mJTextView;
        this.tvHour24Tab = mJTextView2;
        this.vSpace1 = view4;
        this.viewDay2Bg = view5;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.LayoutTwoModuleWeatherCombineBinding bind(@androidx.annotation.NonNull android.view.View view) {
        android.view.View findChildViewById;
        com.moji.mjweather.weather.view.MainShortViewS5 findChildViewById2;
        android.view.View findChildViewById3;
        com.moji.textview.MJTextView findChildViewById4;
        com.moji.textview.MJTextView findChildViewById5;
        android.view.View findChildViewById6;
        android.view.View findChildViewById7;
        int i = moji.com.mjweather.R.id.content_layout;
        android.widget.RelativeLayout relativeLayout = (android.widget.RelativeLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (relativeLayout != null) {
            i = moji.com.mjweather.R.id.iv_day2_select;
            android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = moji.com.mjweather.R.id.iv_hour24_select;
                android.widget.ImageView imageView2 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (imageView2 != null) {
                    i = moji.com.mjweather.R.id.lottie_minute;
                    com.airbnb.lottie.LottieAnimationView lottieAnimationView = (com.airbnb.lottie.LottieAnimationView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (lottieAnimationView != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.lottie_minute_bg))) != null && (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.shortView))) != null) {
                        i = moji.com.mjweather.R.id.tab_layout;
                        androidx.constraintlayout.widget.ConstraintLayout constraintLayout = (androidx.constraintlayout.widget.ConstraintLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (constraintLayout != null && (findChildViewById3 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.tab_layout_background))) != null && (findChildViewById4 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.tv_day2_tab))) != null && (findChildViewById5 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.tv_hour24_tab))) != null && (findChildViewById6 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.v_space_1))) != null && (findChildViewById7 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.view_day2_bg))) != null) {
                            return new moji.com.mjweather.databinding.LayoutTwoModuleWeatherCombineBinding(view, relativeLayout, imageView, imageView2, lottieAnimationView, findChildViewById, findChildViewById2, constraintLayout, findChildViewById3, findChildViewById4, findChildViewById5, findChildViewById6, findChildViewById7);
                        }
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.LayoutTwoModuleWeatherCombineBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.NonNull android.view.ViewGroup viewGroup) {
        if (viewGroup == null) {
            throw new java.lang.NullPointerException("parent");
        }
        layoutInflater.inflate(moji.com.mjweather.R.layout.layout_two_module_weather_combine, viewGroup);
        return bind(viewGroup);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public android.view.View getRoot() {
        return this.n;
    }
}
