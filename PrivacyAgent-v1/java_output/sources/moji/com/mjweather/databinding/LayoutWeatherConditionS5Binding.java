package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class LayoutWeatherConditionS5Binding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final com.moji.weathersence.SceneClickFrameLayout animationClick;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.weather.view.MainAQIView aqiView;

    @androidx.annotation.NonNull
    public final android.widget.Space avatarRightLine;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.weather.avatar.AvatarView avatarView;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.weather.avatar.InvisibleAvatarView avatarViewPlaceHolder;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.weather.view.MainRainDropView bottomRainDropAnimView;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.weather.view.MainConditionView conditionView;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.weather.view.MainFeedbackView feedbackView;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.weather.view.MainSomatosensoryView feelView;

    @androidx.annotation.NonNull
    public final android.view.View n;

    @androidx.annotation.NonNull
    public final com.moji.card.view.topbanner.OpCardTopContainerView topBannerView;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.weather.view.MainVoiceView voiceView;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.weather.view.MainWarnView warnView;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.weather.view.MainWindHumidityView windHumidityView;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.weather.window.WindowView window;

    public LayoutWeatherConditionS5Binding(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull com.moji.weathersence.SceneClickFrameLayout sceneClickFrameLayout, @androidx.annotation.NonNull com.moji.mjweather.weather.view.MainAQIView mainAQIView, @androidx.annotation.NonNull android.widget.Space space, @androidx.annotation.NonNull com.moji.mjweather.weather.avatar.AvatarView avatarView, @androidx.annotation.NonNull com.moji.mjweather.weather.avatar.InvisibleAvatarView invisibleAvatarView, @androidx.annotation.NonNull com.moji.mjweather.weather.view.MainRainDropView mainRainDropView, @androidx.annotation.NonNull com.moji.mjweather.weather.view.MainConditionView mainConditionView, @androidx.annotation.NonNull com.moji.mjweather.weather.view.MainFeedbackView mainFeedbackView, @androidx.annotation.NonNull com.moji.mjweather.weather.view.MainSomatosensoryView mainSomatosensoryView, @androidx.annotation.NonNull com.moji.card.view.topbanner.OpCardTopContainerView opCardTopContainerView, @androidx.annotation.NonNull com.moji.mjweather.weather.view.MainVoiceView mainVoiceView, @androidx.annotation.NonNull com.moji.mjweather.weather.view.MainWarnView mainWarnView, @androidx.annotation.NonNull com.moji.mjweather.weather.view.MainWindHumidityView mainWindHumidityView, @androidx.annotation.NonNull com.moji.mjweather.weather.window.WindowView windowView) {
        this.n = view;
        this.animationClick = sceneClickFrameLayout;
        this.aqiView = mainAQIView;
        this.avatarRightLine = space;
        this.avatarView = avatarView;
        this.avatarViewPlaceHolder = invisibleAvatarView;
        this.bottomRainDropAnimView = mainRainDropView;
        this.conditionView = mainConditionView;
        this.feedbackView = mainFeedbackView;
        this.feelView = mainSomatosensoryView;
        this.topBannerView = opCardTopContainerView;
        this.voiceView = mainVoiceView;
        this.warnView = mainWarnView;
        this.windHumidityView = mainWindHumidityView;
        this.window = windowView;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.LayoutWeatherConditionS5Binding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.mjweather.weather.view.MainAQIView findChildViewById;
        com.moji.mjweather.weather.avatar.AvatarView findChildViewById2;
        com.moji.mjweather.weather.avatar.InvisibleAvatarView findChildViewById3;
        com.moji.mjweather.weather.view.MainRainDropView findChildViewById4;
        com.moji.mjweather.weather.view.MainConditionView findChildViewById5;
        com.moji.mjweather.weather.view.MainFeedbackView findChildViewById6;
        com.moji.mjweather.weather.view.MainSomatosensoryView findChildViewById7;
        com.moji.card.view.topbanner.OpCardTopContainerView findChildViewById8;
        com.moji.mjweather.weather.view.MainVoiceView findChildViewById9;
        com.moji.mjweather.weather.view.MainWarnView findChildViewById10;
        com.moji.mjweather.weather.view.MainWindHumidityView findChildViewById11;
        com.moji.mjweather.weather.window.WindowView findChildViewById12;
        int i = moji.com.mjweather.R.id.animation_click;
        com.moji.weathersence.SceneClickFrameLayout findChildViewById13 = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (findChildViewById13 != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.aqiView))) != null) {
            i = moji.com.mjweather.R.id.avatarRightLine;
            android.widget.Space space = (android.widget.Space) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (space != null && (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.avatar_view))) != null && (findChildViewById3 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.avatar_view_place_holder))) != null && (findChildViewById4 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.bottomRainDropAnimView))) != null && (findChildViewById5 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.conditionView))) != null && (findChildViewById6 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.feedbackView))) != null && (findChildViewById7 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.feelView))) != null && (findChildViewById8 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.topBannerView))) != null && (findChildViewById9 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.voiceView))) != null && (findChildViewById10 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.warnView))) != null && (findChildViewById11 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.windHumidityView))) != null && (findChildViewById12 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.window))) != null) {
                return new moji.com.mjweather.databinding.LayoutWeatherConditionS5Binding(view, findChildViewById13, findChildViewById, space, findChildViewById2, findChildViewById3, findChildViewById4, findChildViewById5, findChildViewById6, findChildViewById7, findChildViewById8, findChildViewById9, findChildViewById10, findChildViewById11, findChildViewById12);
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.LayoutWeatherConditionS5Binding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.NonNull android.view.ViewGroup viewGroup) {
        if (viewGroup == null) {
            throw new java.lang.NullPointerException("parent");
        }
        layoutInflater.inflate(moji.com.mjweather.R.layout.layout_weather_condition_s5, viewGroup);
        return bind(viewGroup);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public android.view.View getRoot() {
        return this.n;
    }
}
