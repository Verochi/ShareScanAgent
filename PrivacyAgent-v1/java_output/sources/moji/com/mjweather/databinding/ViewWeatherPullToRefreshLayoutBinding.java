package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class ViewWeatherPullToRefreshLayoutBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout n;

    @androidx.annotation.NonNull
    public final com.airbnb.lottie.LottieAnimationView pullToRefreshDot;

    @androidx.annotation.NonNull
    public final com.airbnb.lottie.LottieAnimationView pullToRefreshLottie;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView pullToRefreshText;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout refreshContainer;

    public ViewWeatherPullToRefreshLayoutBinding(@androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout, @androidx.annotation.NonNull com.airbnb.lottie.LottieAnimationView lottieAnimationView, @androidx.annotation.NonNull com.airbnb.lottie.LottieAnimationView lottieAnimationView2, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView, @androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout2) {
        this.n = constraintLayout;
        this.pullToRefreshDot = lottieAnimationView;
        this.pullToRefreshLottie = lottieAnimationView2;
        this.pullToRefreshText = mJTextView;
        this.refreshContainer = constraintLayout2;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ViewWeatherPullToRefreshLayoutBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.textview.MJTextView findChildViewById;
        int i = moji.com.mjweather.R.id.pull_to_refresh_dot;
        com.airbnb.lottie.LottieAnimationView lottieAnimationView = (com.airbnb.lottie.LottieAnimationView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (lottieAnimationView != null) {
            i = moji.com.mjweather.R.id.pull_to_refresh_lottie;
            com.airbnb.lottie.LottieAnimationView lottieAnimationView2 = (com.airbnb.lottie.LottieAnimationView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (lottieAnimationView2 != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.pull_to_refresh_text))) != null) {
                androidx.constraintlayout.widget.ConstraintLayout constraintLayout = (androidx.constraintlayout.widget.ConstraintLayout) view;
                return new moji.com.mjweather.databinding.ViewWeatherPullToRefreshLayoutBinding(constraintLayout, lottieAnimationView, lottieAnimationView2, findChildViewById, constraintLayout);
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ViewWeatherPullToRefreshLayoutBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ViewWeatherPullToRefreshLayoutBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.view_weather_pull_to_refresh_layout, viewGroup, false);
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
