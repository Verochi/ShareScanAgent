package moji.com.mjweatherservicebase.databinding;

/* loaded from: classes20.dex */
public final class LayoutRflowersShareBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.ImageView mListImage;

    @androidx.annotation.NonNull
    public final android.widget.ImageView mMapBg;

    @androidx.annotation.NonNull
    public final android.widget.ImageView mMapImage;

    @androidx.annotation.NonNull
    public final android.widget.ImageView mShareTitle;

    @androidx.annotation.NonNull
    public final android.widget.LinearLayout n;

    public LayoutRflowersShareBinding(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.widget.ImageView imageView2, @androidx.annotation.NonNull android.widget.ImageView imageView3, @androidx.annotation.NonNull android.widget.ImageView imageView4) {
        this.n = linearLayout;
        this.mListImage = imageView;
        this.mMapBg = imageView2;
        this.mMapImage = imageView3;
        this.mShareTitle = imageView4;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweatherservicebase.databinding.LayoutRflowersShareBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = moji.com.mjweatherservicebase.R.id.mListImage;
        android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = moji.com.mjweatherservicebase.R.id.mMapBg;
            android.widget.ImageView imageView2 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = moji.com.mjweatherservicebase.R.id.mMapImage;
                android.widget.ImageView imageView3 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (imageView3 != null) {
                    i = moji.com.mjweatherservicebase.R.id.mShareTitle;
                    android.widget.ImageView imageView4 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (imageView4 != null) {
                        return new moji.com.mjweatherservicebase.databinding.LayoutRflowersShareBinding((android.widget.LinearLayout) view, imageView, imageView2, imageView3, imageView4);
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweatherservicebase.databinding.LayoutRflowersShareBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweatherservicebase.databinding.LayoutRflowersShareBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweatherservicebase.R.layout.layout_rflowers_share, viewGroup, false);
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
