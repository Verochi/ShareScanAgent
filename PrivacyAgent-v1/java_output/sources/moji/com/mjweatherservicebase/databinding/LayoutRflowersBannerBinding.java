package moji.com.mjweatherservicebase.databinding;

/* loaded from: classes20.dex */
public final class LayoutRflowersBannerBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.ImageView mImageView;

    @androidx.annotation.NonNull
    public final android.widget.FrameLayout n;

    public LayoutRflowersBannerBinding(@androidx.annotation.NonNull android.widget.FrameLayout frameLayout, @androidx.annotation.NonNull android.widget.ImageView imageView) {
        this.n = frameLayout;
        this.mImageView = imageView;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweatherservicebase.databinding.LayoutRflowersBannerBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = moji.com.mjweatherservicebase.R.id.mImageView;
        android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            return new moji.com.mjweatherservicebase.databinding.LayoutRflowersBannerBinding((android.widget.FrameLayout) view, imageView);
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweatherservicebase.databinding.LayoutRflowersBannerBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweatherservicebase.databinding.LayoutRflowersBannerBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweatherservicebase.R.layout.layout_rflowers_banner, viewGroup, false);
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
