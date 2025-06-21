package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class LayoutHomeGuideBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final com.airbnb.lottie.LottieAnimationView lottieStep1;

    @androidx.annotation.NonNull
    public final com.moji.mjweather.guide.HomeGuideStep2View lottieStep2;

    @androidx.annotation.NonNull
    public final android.view.View n;

    public LayoutHomeGuideBinding(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull com.airbnb.lottie.LottieAnimationView lottieAnimationView, @androidx.annotation.NonNull com.moji.mjweather.guide.HomeGuideStep2View homeGuideStep2View) {
        this.n = view;
        this.lottieStep1 = lottieAnimationView;
        this.lottieStep2 = homeGuideStep2View;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.LayoutHomeGuideBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.mjweather.guide.HomeGuideStep2View findChildViewById;
        int i = moji.com.mjweather.R.id.lottie_step1;
        com.airbnb.lottie.LottieAnimationView lottieAnimationView = (com.airbnb.lottie.LottieAnimationView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (lottieAnimationView == null || (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.lottie_step2))) == null) {
            throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new moji.com.mjweather.databinding.LayoutHomeGuideBinding(view, lottieAnimationView, findChildViewById);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.LayoutHomeGuideBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.NonNull android.view.ViewGroup viewGroup) {
        if (viewGroup == null) {
            throw new java.lang.NullPointerException("parent");
        }
        layoutInflater.inflate(moji.com.mjweather.R.layout.layout_home_guide, viewGroup);
        return bind(viewGroup);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public android.view.View getRoot() {
        return this.n;
    }
}
