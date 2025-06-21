package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class WeatherPageLoadingViewBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final com.moji.mjweather.weather.view.WeatherStatusSkeletonBottomView bottomView;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.weather.view.FirstPageSpace firstPageSpace;

    @androidx.annotation.NonNull
    public final com.airbnb.lottie.LottieAnimationView lottieView;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout n;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.weather.view.HomeTitleBarLayout titleBarLayout;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvMessage;

    public WeatherPageLoadingViewBinding(@androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout, @androidx.annotation.NonNull com.moji.mjweather.weather.view.WeatherStatusSkeletonBottomView weatherStatusSkeletonBottomView, @androidx.annotation.NonNull com.moji.mjweather.weather.view.FirstPageSpace firstPageSpace, @androidx.annotation.NonNull com.airbnb.lottie.LottieAnimationView lottieAnimationView, @androidx.annotation.NonNull com.moji.mjweather.weather.view.HomeTitleBarLayout homeTitleBarLayout, @androidx.annotation.NonNull android.widget.TextView textView) {
        this.n = constraintLayout;
        this.bottomView = weatherStatusSkeletonBottomView;
        this.firstPageSpace = firstPageSpace;
        this.lottieView = lottieAnimationView;
        this.titleBarLayout = homeTitleBarLayout;
        this.tvMessage = textView;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.WeatherPageLoadingViewBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.mjweather.weather.view.FirstPageSpace findChildViewById;
        com.moji.mjweather.weather.view.HomeTitleBarLayout findChildViewById2;
        int i = moji.com.mjweather.R.id.bottom_view;
        com.moji.mjweather.weather.view.WeatherStatusSkeletonBottomView findChildViewById3 = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (findChildViewById3 != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.firstPageSpace))) != null) {
            i = moji.com.mjweather.R.id.lottie_view;
            com.airbnb.lottie.LottieAnimationView lottieAnimationView = (com.airbnb.lottie.LottieAnimationView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (lottieAnimationView != null && (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.titleBarLayout))) != null) {
                i = moji.com.mjweather.R.id.tv_message;
                android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    return new moji.com.mjweather.databinding.WeatherPageLoadingViewBinding((androidx.constraintlayout.widget.ConstraintLayout) view, findChildViewById3, findChildViewById, lottieAnimationView, findChildViewById2, textView);
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.WeatherPageLoadingViewBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.WeatherPageLoadingViewBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.weather_page_loading_view, viewGroup, false);
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
