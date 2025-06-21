package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class ViewMainSomatosensoryBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivIndicator;

    @androidx.annotation.NonNull
    public final com.airbnb.lottie.LottieAnimationView ivTemperature;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout n;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout temperatureRoot;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView tvTemperature;

    public ViewMainSomatosensoryBinding(@androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull com.airbnb.lottie.LottieAnimationView lottieAnimationView, @androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout2, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView) {
        this.n = constraintLayout;
        this.ivIndicator = imageView;
        this.ivTemperature = lottieAnimationView;
        this.temperatureRoot = constraintLayout2;
        this.tvTemperature = mJTextView;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ViewMainSomatosensoryBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = moji.com.mjweather.R.id.iv_indicator;
        android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = moji.com.mjweather.R.id.iv_temperature;
            com.airbnb.lottie.LottieAnimationView lottieAnimationView = (com.airbnb.lottie.LottieAnimationView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (lottieAnimationView != null) {
                androidx.constraintlayout.widget.ConstraintLayout constraintLayout = (androidx.constraintlayout.widget.ConstraintLayout) view;
                i = moji.com.mjweather.R.id.tv_temperature;
                com.moji.textview.MJTextView findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (findChildViewById != null) {
                    return new moji.com.mjweather.databinding.ViewMainSomatosensoryBinding(constraintLayout, imageView, lottieAnimationView, constraintLayout, findChildViewById);
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ViewMainSomatosensoryBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ViewMainSomatosensoryBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.view_main_somatosensory, viewGroup, false);
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
