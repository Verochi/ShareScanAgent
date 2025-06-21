package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class WeatherPageV10StatusViewBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final com.moji.mjweather.weather.view.WeatherStatusSkeletonBottomView bottomView;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout clErrorAndLoadingInfo;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout clErrorInfo;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout clLoadingInfo;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout clLoadingInfoBlack;

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivIcon;

    @androidx.annotation.NonNull
    public final com.airbnb.lottie.LottieAnimationView lottieView;

    @androidx.annotation.NonNull
    public final com.airbnb.lottie.LottieAnimationView lottieViewBlack;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout n;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvActionView;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvErrorMessage;

    @androidx.annotation.NonNull
    public final android.widget.TextView tvLoadingMessage;

    public WeatherPageV10StatusViewBinding(@androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout, @androidx.annotation.NonNull com.moji.mjweather.weather.view.WeatherStatusSkeletonBottomView weatherStatusSkeletonBottomView, @androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout2, @androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout3, @androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout4, @androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout5, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull com.airbnb.lottie.LottieAnimationView lottieAnimationView, @androidx.annotation.NonNull com.airbnb.lottie.LottieAnimationView lottieAnimationView2, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.widget.TextView textView2, @androidx.annotation.NonNull android.widget.TextView textView3) {
        this.n = constraintLayout;
        this.bottomView = weatherStatusSkeletonBottomView;
        this.clErrorAndLoadingInfo = constraintLayout2;
        this.clErrorInfo = constraintLayout3;
        this.clLoadingInfo = constraintLayout4;
        this.clLoadingInfoBlack = constraintLayout5;
        this.ivIcon = imageView;
        this.lottieView = lottieAnimationView;
        this.lottieViewBlack = lottieAnimationView2;
        this.tvActionView = textView;
        this.tvErrorMessage = textView2;
        this.tvLoadingMessage = textView3;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.WeatherPageV10StatusViewBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = moji.com.mjweather.R.id.bottom_view;
        com.moji.mjweather.weather.view.WeatherStatusSkeletonBottomView findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (findChildViewById != null) {
            i = moji.com.mjweather.R.id.cl_error_and_loading_info;
            androidx.constraintlayout.widget.ConstraintLayout constraintLayout = (androidx.constraintlayout.widget.ConstraintLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (constraintLayout != null) {
                i = moji.com.mjweather.R.id.cl_error_info;
                androidx.constraintlayout.widget.ConstraintLayout constraintLayout2 = (androidx.constraintlayout.widget.ConstraintLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (constraintLayout2 != null) {
                    i = moji.com.mjweather.R.id.cl_loading_info;
                    androidx.constraintlayout.widget.ConstraintLayout constraintLayout3 = (androidx.constraintlayout.widget.ConstraintLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (constraintLayout3 != null) {
                        i = moji.com.mjweather.R.id.cl_loading_info_black;
                        androidx.constraintlayout.widget.ConstraintLayout constraintLayout4 = (androidx.constraintlayout.widget.ConstraintLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (constraintLayout4 != null) {
                            i = moji.com.mjweather.R.id.iv_icon;
                            android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (imageView != null) {
                                i = moji.com.mjweather.R.id.lottie_view;
                                com.airbnb.lottie.LottieAnimationView lottieAnimationView = (com.airbnb.lottie.LottieAnimationView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                if (lottieAnimationView != null) {
                                    i = moji.com.mjweather.R.id.lottie_view_black;
                                    com.airbnb.lottie.LottieAnimationView lottieAnimationView2 = (com.airbnb.lottie.LottieAnimationView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                    if (lottieAnimationView2 != null) {
                                        i = moji.com.mjweather.R.id.tv_action_view;
                                        android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                        if (textView != null) {
                                            i = moji.com.mjweather.R.id.tv_error_message;
                                            android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                            if (textView2 != null) {
                                                i = moji.com.mjweather.R.id.tv_loading_message;
                                                android.widget.TextView textView3 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                if (textView3 != null) {
                                                    return new moji.com.mjweather.databinding.WeatherPageV10StatusViewBinding((androidx.constraintlayout.widget.ConstraintLayout) view, findChildViewById, constraintLayout, constraintLayout2, constraintLayout3, constraintLayout4, imageView, lottieAnimationView, lottieAnimationView2, textView, textView2, textView3);
                                                }
                                            }
                                        }
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
    public static moji.com.mjweather.databinding.WeatherPageV10StatusViewBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.WeatherPageV10StatusViewBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.weather_page_v10_status_view, viewGroup, false);
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
