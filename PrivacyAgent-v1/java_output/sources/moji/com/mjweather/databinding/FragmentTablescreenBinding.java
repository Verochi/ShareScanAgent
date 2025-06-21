package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class FragmentTablescreenBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.view.ViewStub firstPermissionLayoutStub;

    @androidx.annotation.NonNull
    public final android.widget.RelativeLayout n;

    @androidx.annotation.NonNull
    public final com.moji.mjad.splash.view.SplashAdView savSplashAd;

    public FragmentTablescreenBinding(@androidx.annotation.NonNull android.widget.RelativeLayout relativeLayout, @androidx.annotation.NonNull android.view.ViewStub viewStub, @androidx.annotation.NonNull com.moji.mjad.splash.view.SplashAdView splashAdView) {
        this.n = relativeLayout;
        this.firstPermissionLayoutStub = viewStub;
        this.savSplashAd = splashAdView;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.FragmentTablescreenBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.mjad.splash.view.SplashAdView findChildViewById;
        int i = moji.com.mjweather.R.id.first_permission_layout_stub;
        android.view.ViewStub viewStub = (android.view.ViewStub) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (viewStub == null || (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.sav_splash_ad))) == null) {
            throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new moji.com.mjweather.databinding.FragmentTablescreenBinding((android.widget.RelativeLayout) view, viewStub, findChildViewById);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.FragmentTablescreenBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.FragmentTablescreenBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.fragment_tablescreen, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public android.widget.RelativeLayout getRoot() {
        return this.n;
    }
}
