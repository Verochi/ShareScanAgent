package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class MeBannerAdItemBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final com.moji.mjad.common.view.CommonAdView adView;

    @androidx.annotation.NonNull
    public final com.moji.mjad.common.view.CommonAdView n;

    public MeBannerAdItemBinding(@androidx.annotation.NonNull com.moji.mjad.common.view.CommonAdView commonAdView, @androidx.annotation.NonNull com.moji.mjad.common.view.CommonAdView commonAdView2) {
        this.n = commonAdView;
        this.adView = commonAdView2;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.MeBannerAdItemBinding bind(@androidx.annotation.NonNull android.view.View view) {
        if (view == null) {
            throw new java.lang.NullPointerException("rootView");
        }
        com.moji.mjad.common.view.CommonAdView commonAdView = (com.moji.mjad.common.view.CommonAdView) view;
        return new moji.com.mjweather.databinding.MeBannerAdItemBinding(commonAdView, commonAdView);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.MeBannerAdItemBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.MeBannerAdItemBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.me_banner_ad_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public com.moji.mjad.common.view.CommonAdView getRoot() {
        return this.n;
    }
}
