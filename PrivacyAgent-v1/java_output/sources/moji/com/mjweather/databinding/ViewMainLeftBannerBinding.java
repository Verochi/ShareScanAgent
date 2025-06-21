package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class ViewMainLeftBannerBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final com.moji.mjweather.weather.ViewFlipper mFlipperView;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout n;

    public ViewMainLeftBannerBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull com.moji.mjweather.weather.ViewFlipper viewFlipper) {
        this.n = linearLayout;
        this.mFlipperView = viewFlipper;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ViewMainLeftBannerBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = moji.com.mjweather.R.id.mFlipperView;
        com.moji.mjweather.weather.ViewFlipper findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (findChildViewById != null) {
            return new moji.com.mjweather.databinding.ViewMainLeftBannerBinding((android.widget.LinearLayout) view, findChildViewById);
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ViewMainLeftBannerBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ViewMainLeftBannerBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.view_main_left_banner, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public android.widget.LinearLayout getRoot() {
        return this.n;
    }
}
