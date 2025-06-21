package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class ShopCommentViewPhotosActivityBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout n;

    @androidx.annotation.NonNull
    public final com.moji.titlebar.MJTitleBar photoTitle;

    @androidx.annotation.NonNull
    public final androidx.viewpager.widget.ViewPager vpMallViewPhotos;

    public ShopCommentViewPhotosActivityBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull com.moji.titlebar.MJTitleBar mJTitleBar, @androidx.annotation.NonNull androidx.viewpager.widget.ViewPager viewPager) {
        this.n = linearLayout;
        this.photoTitle = mJTitleBar;
        this.vpMallViewPhotos = viewPager;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ShopCommentViewPhotosActivityBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = moji.com.mjweather.R.id.photo_title;
        com.moji.titlebar.MJTitleBar findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (findChildViewById != null) {
            i = moji.com.mjweather.R.id.vp_mall_view_photos;
            androidx.viewpager.widget.ViewPager viewPager = (androidx.viewpager.widget.ViewPager) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (viewPager != null) {
                return new moji.com.mjweather.databinding.ShopCommentViewPhotosActivityBinding((android.widget.LinearLayout) view, findChildViewById, viewPager);
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ShopCommentViewPhotosActivityBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.ShopCommentViewPhotosActivityBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.shop_comment_view_photos_activity, viewGroup, false);
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
