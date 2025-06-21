package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class ViewMainSomatosensoryS5Binding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final com.moji.imageview.MJImageView ivIndicator;

    @androidx.annotation.NonNull
    public final com.airbnb.lottie.LottieAnimationView ivTemperature;

    @androidx.annotation.NonNull
    public final androidx.constraintlayout.widget.ConstraintLayout n;

    @androidx.annotation.NonNull
    public final com.moji.textview.MJTextView tvTemperature;

    public ViewMainSomatosensoryS5Binding(@androidx.annotation.NonNull androidx.constraintlayout.widget.ConstraintLayout constraintLayout, @androidx.annotation.NonNull com.moji.imageview.MJImageView mJImageView, @androidx.annotation.NonNull com.airbnb.lottie.LottieAnimationView lottieAnimationView, @androidx.annotation.NonNull com.moji.textview.MJTextView mJTextView) {
        this.n = constraintLayout;
        this.ivIndicator = mJImageView;
        this.ivTemperature = lottieAnimationView;
        this.tvTemperature = mJTextView;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ViewMainSomatosensoryS5Binding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.textview.MJTextView findChildViewById;
        int i = moji.com.mjweather.R.id.iv_indicator;
        com.moji.imageview.MJImageView findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (findChildViewById2 != null) {
            i = moji.com.mjweather.R.id.iv_temperature;
            com.airbnb.lottie.LottieAnimationView lottieAnimationView = (com.airbnb.lottie.LottieAnimationView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (lottieAnimationView != null && (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.tv_temperature))) != null) {
                return new moji.com.mjweather.databinding.ViewMainSomatosensoryS5Binding((androidx.constraintlayout.widget.ConstraintLayout) view, findChildViewById2, lottieAnimationView, findChildViewById);
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ViewMainSomatosensoryS5Binding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ViewMainSomatosensoryS5Binding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.view_main_somatosensory_s5, viewGroup, false);
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
