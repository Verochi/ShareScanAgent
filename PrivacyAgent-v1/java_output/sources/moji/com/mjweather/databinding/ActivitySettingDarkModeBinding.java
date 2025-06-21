package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class ActivitySettingDarkModeBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final com.moji.mjweather.setting.view.DarkModeContainerView mContentView;

    @androidx.annotation.NonNull
    public final android.widget.ImageView mDarkCheckIconView;

    @androidx.annotation.NonNull
    public final android.view.View mDarkClickView;

    @androidx.annotation.NonNull
    public final android.widget.ImageView mDarkImageView;

    @androidx.annotation.NonNull
    public final android.widget.TextView mDarkTextView;

    @androidx.annotation.NonNull
    public final com.airbnb.lottie.LottieAnimationView mDayAnimView;

    @androidx.annotation.NonNull
    public final android.widget.ToggleButton mFollowSystemSwitchView;

    @androidx.annotation.NonNull
    public final android.widget.TextView mFollowSystemTextView;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout mFollowSystemView;

    @androidx.annotation.NonNull
    public final android.widget.ImageView mLightCheckIconView;

    @androidx.annotation.NonNull
    public final android.view.View mLightClickView;

    @androidx.annotation.NonNull
    public final android.widget.ImageView mLightImageView;

    @androidx.annotation.NonNull
    public final android.widget.TextView mLightTextView;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout mManualView;

    @androidx.annotation.NonNull
    public final android.widget.ImageView mMaskView;

    @androidx.annotation.NonNull
    public final com.airbnb.lottie.LottieAnimationView mNightAnimView;

    @androidx.annotation.NonNull
    public final android.widget.TextView mSummaryView;

    @androidx.annotation.NonNull
    public final com.moji.titlebar.MJTitleBar mTitleBar;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.setting.view.DarkModeContainerView n;

    public ActivitySettingDarkModeBinding(@androidx.annotation.NonNull com.moji.mjweather.setting.view.DarkModeContainerView darkModeContainerView, @androidx.annotation.NonNull com.moji.mjweather.setting.view.DarkModeContainerView darkModeContainerView2, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull android.widget.ImageView imageView2, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull com.airbnb.lottie.LottieAnimationView lottieAnimationView, @androidx.annotation.NonNull android.widget.ToggleButton toggleButton, @androidx.annotation.NonNull android.widget.TextView textView2, @androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout, @androidx.annotation.NonNull android.widget.ImageView imageView3, @androidx.annotation.NonNull android.view.View view2, @androidx.annotation.NonNull android.widget.ImageView imageView4, @androidx.annotation.NonNull android.widget.TextView textView3, @androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout2, @androidx.annotation.NonNull android.widget.ImageView imageView5, @androidx.annotation.NonNull com.airbnb.lottie.LottieAnimationView lottieAnimationView2, @androidx.annotation.NonNull android.widget.TextView textView4, @androidx.annotation.NonNull com.moji.titlebar.MJTitleBar mJTitleBar) {
        this.n = darkModeContainerView;
        this.mContentView = darkModeContainerView2;
        this.mDarkCheckIconView = imageView;
        this.mDarkClickView = view;
        this.mDarkImageView = imageView2;
        this.mDarkTextView = textView;
        this.mDayAnimView = lottieAnimationView;
        this.mFollowSystemSwitchView = toggleButton;
        this.mFollowSystemTextView = textView2;
        this.mFollowSystemView = constraintLayout;
        this.mLightCheckIconView = imageView3;
        this.mLightClickView = view2;
        this.mLightImageView = imageView4;
        this.mLightTextView = textView3;
        this.mManualView = constraintLayout2;
        this.mMaskView = imageView5;
        this.mNightAnimView = lottieAnimationView2;
        this.mSummaryView = textView4;
        this.mTitleBar = mJTitleBar;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ActivitySettingDarkModeBinding bind(@androidx.annotation.NonNull android.view.View view) {
        android.view.View findChildViewById;
        android.view.View findChildViewById2;
        com.moji.titlebar.MJTitleBar findChildViewById3;
        com.moji.mjweather.setting.view.DarkModeContainerView darkModeContainerView = (com.moji.mjweather.setting.view.DarkModeContainerView) view;
        int i = moji.com.mjweather.R.id.mDarkCheckIconView;
        android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (imageView != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.mDarkClickView))) != null) {
            i = moji.com.mjweather.R.id.mDarkImageView;
            android.widget.ImageView imageView2 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = moji.com.mjweather.R.id.mDarkTextView;
                android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = moji.com.mjweather.R.id.mDayAnimView;
                    com.airbnb.lottie.LottieAnimationView lottieAnimationView = (com.airbnb.lottie.LottieAnimationView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (lottieAnimationView != null) {
                        i = moji.com.mjweather.R.id.mFollowSystemSwitchView;
                        android.widget.ToggleButton toggleButton = (android.widget.ToggleButton) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (toggleButton != null) {
                            i = moji.com.mjweather.R.id.mFollowSystemTextView;
                            android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (textView2 != null) {
                                i = moji.com.mjweather.R.id.mFollowSystemView;
                                androidx.constraintlayout.widget.ConstraintLayout constraintLayout = (androidx.constraintlayout.widget.ConstraintLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                if (constraintLayout != null) {
                                    i = moji.com.mjweather.R.id.mLightCheckIconView;
                                    android.widget.ImageView imageView3 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                    if (imageView3 != null && (findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.mLightClickView))) != null) {
                                        i = moji.com.mjweather.R.id.mLightImageView;
                                        android.widget.ImageView imageView4 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                        if (imageView4 != null) {
                                            i = moji.com.mjweather.R.id.mLightTextView;
                                            android.widget.TextView textView3 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                            if (textView3 != null) {
                                                i = moji.com.mjweather.R.id.mManualView;
                                                androidx.constraintlayout.widget.ConstraintLayout constraintLayout2 = (androidx.constraintlayout.widget.ConstraintLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                if (constraintLayout2 != null) {
                                                    i = moji.com.mjweather.R.id.mMaskView;
                                                    android.widget.ImageView imageView5 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                    if (imageView5 != null) {
                                                        i = moji.com.mjweather.R.id.mNightAnimView;
                                                        com.airbnb.lottie.LottieAnimationView lottieAnimationView2 = (com.airbnb.lottie.LottieAnimationView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                        if (lottieAnimationView2 != null) {
                                                            i = moji.com.mjweather.R.id.mSummaryView;
                                                            android.widget.TextView textView4 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                            if (textView4 != null && (findChildViewById3 = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.mTitleBar))) != null) {
                                                                return new moji.com.mjweather.databinding.ActivitySettingDarkModeBinding(darkModeContainerView, darkModeContainerView, imageView, findChildViewById, imageView2, textView, lottieAnimationView, toggleButton, textView2, constraintLayout, imageView3, findChildViewById2, imageView4, textView3, constraintLayout2, imageView5, lottieAnimationView2, textView4, findChildViewById3);
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
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ActivitySettingDarkModeBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ActivitySettingDarkModeBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.activity_setting_dark_mode, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public com.moji.mjweather.setting.view.DarkModeContainerView getRoot() {
        return this.n;
    }
}
