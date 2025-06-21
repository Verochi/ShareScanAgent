package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class MeBannerItemBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final com.moji.imageview.RoundCornerImageView mask;

    @androidx.annotation.NonNull
    public final android.widget.FrameLayout n;

    @androidx.annotation.NonNull
    public final com.moji.imageview.RoundCornerImageView tabMeWelfareIv;

    public MeBannerItemBinding(@androidx.annotation.NonNull android.widget.FrameLayout frameLayout, @androidx.annotation.NonNull com.moji.imageview.RoundCornerImageView roundCornerImageView, @androidx.annotation.NonNull com.moji.imageview.RoundCornerImageView roundCornerImageView2) {
        this.n = frameLayout;
        this.mask = roundCornerImageView;
        this.tabMeWelfareIv = roundCornerImageView2;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.MeBannerItemBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.imageview.RoundCornerImageView findChildViewById;
        int i = moji.com.mjweather.R.id.mask;
        com.moji.imageview.RoundCornerImageView findChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (findChildViewById2 == null || (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweather.R.id.tab_me_welfare_iv))) == null) {
            throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new moji.com.mjweather.databinding.MeBannerItemBinding((android.widget.FrameLayout) view, findChildViewById2, findChildViewById);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.MeBannerItemBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.MeBannerItemBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.me_banner_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public android.widget.FrameLayout getRoot() {
        return this.n;
    }
}
