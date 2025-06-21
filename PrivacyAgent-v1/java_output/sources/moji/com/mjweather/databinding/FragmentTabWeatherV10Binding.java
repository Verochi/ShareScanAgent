package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class FragmentTabWeatherV10Binding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final com.moji.mjweather.weather.view.WeatherViewPager areaWeatherRecycle;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.weather.avatar.TabAvatarView bgAvatarView;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout bottomPopRootView;

    @androidx.annotation.NonNull
    public final com.moji.mjad.view.DragFloatButton dfbWeatherButton;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivAdBgSignClick;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivNewBgTagClick;

    @androidx.annotation.NonNull
    public final com.moji.imageview.MJImageView ivWeatherBg;

    @androidx.annotation.NonNull
    public final com.moji.imageview.MJImageView ivWeatherBgBlur;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.weather.view.WeatherPullToFreshContainer n;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.weather.view.WeatherPullToFreshContainer refreshContainer;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.weather.view.WeatherV10TitleBar titleBar;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout vOpBack;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.weather.view.SceneRootView weatherBg;

    public FragmentTabWeatherV10Binding(@androidx.annotation.NonNull com.moji.mjweather.weather.view.WeatherPullToFreshContainer weatherPullToFreshContainer, @androidx.annotation.NonNull com.moji.mjweather.weather.view.WeatherViewPager weatherViewPager, @androidx.annotation.NonNull com.moji.mjweather.weather.avatar.TabAvatarView tabAvatarView, @androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull com.moji.mjad.view.DragFloatButton dragFloatButton, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.ImageView imageView2, @androidx.annotation.NonNull com.moji.imageview.MJImageView mJImageView, @androidx.annotation.NonNull com.moji.imageview.MJImageView mJImageView2, @androidx.annotation.NonNull com.moji.mjweather.weather.view.WeatherPullToFreshContainer weatherPullToFreshContainer2, @androidx.annotation.NonNull com.moji.mjweather.weather.view.WeatherV10TitleBar weatherV10TitleBar, @androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout, @androidx.annotation.NonNull com.moji.mjweather.weather.view.SceneRootView sceneRootView) {
        this.n = weatherPullToFreshContainer;
        this.areaWeatherRecycle = weatherViewPager;
        this.bgAvatarView = tabAvatarView;
        this.bottomPopRootView = linearLayout;
        this.dfbWeatherButton = dragFloatButton;
        this.ivAdBgSignClick = imageView;
        this.ivNewBgTagClick = imageView2;
        this.ivWeatherBg = mJImageView;
        this.ivWeatherBgBlur = mJImageView2;
        this.refreshContainer = weatherPullToFreshContainer2;
        this.titleBar = weatherV10TitleBar;
        this.vOpBack = constraintLayout;
        this.weatherBg = sceneRootView;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.FragmentTabWeatherV10Binding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.mjweather.weather.avatar.TabAvatarView findChildViewById;
        com.moji.mjad.view.DragFloatButton findChildViewById2;
        com.moji.imageview.MJImageView findChildViewById3;
        com.moji.imageview.MJImageView findChildViewById4;
        com.moji.mjweather.weather.view.SceneRootView findChildViewById5;
        int i = moji.com.mjweather.R.id.area_weather_recycle;
        com.moji.mjweather.weather.view.WeatherViewPager findChildViewById6 = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (findChildViewById6 != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.bg_avatar_view))) != null) {
            i = moji.com.mjweather.R.id.bottomPopRootView;
            android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (linearLayout != null && (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.dfb_weather_button))) != null) {
                i = moji.com.mjweather.R.id.iv_ad_bg_sign_click;
                android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = moji.com.mjweather.R.id.iv_new_bg_tag_click;
                    android.widget.ImageView imageView2 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (imageView2 != null && (findChildViewById3 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.iv_weather_bg))) != null && (findChildViewById4 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.iv_weather_bg_blur))) != null) {
                        com.moji.mjweather.weather.view.WeatherPullToFreshContainer weatherPullToFreshContainer = (com.moji.mjweather.weather.view.WeatherPullToFreshContainer) view;
                        i = moji.com.mjweather.R.id.title_bar;
                        com.moji.mjweather.weather.view.WeatherV10TitleBar findChildViewById7 = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (findChildViewById7 != null) {
                            i = moji.com.mjweather.R.id.vOpBack;
                            androidx.constraintlayout.widget.ConstraintLayout constraintLayout = (androidx.constraintlayout.widget.ConstraintLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (constraintLayout != null && (findChildViewById5 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.weather_bg))) != null) {
                                return new moji.com.mjweather.databinding.FragmentTabWeatherV10Binding(weatherPullToFreshContainer, findChildViewById6, findChildViewById, linearLayout, findChildViewById2, imageView, imageView2, findChildViewById3, findChildViewById4, weatherPullToFreshContainer, findChildViewById7, constraintLayout, findChildViewById5);
                            }
                        }
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.FragmentTabWeatherV10Binding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.FragmentTabWeatherV10Binding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.fragment_tab_weather_v10, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public com.moji.mjweather.weather.view.WeatherPullToFreshContainer getRoot() {
        return this.n;
    }
}
