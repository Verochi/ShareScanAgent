package moji.com.mjweatherservicebase.databinding;

/* loaded from: classes20.dex */
public final class ActivitySkiImagePreviewBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final com.moji.imageview.TouchImageView mImageView;

    @androidx.annotation.NonNull
    public final android.widget.FrameLayout n;

    public ActivitySkiImagePreviewBinding(@androidx.annotation.NonNull android.widget.FrameLayout frameLayout, @androidx.annotation.NonNull com.moji.imageview.TouchImageView touchImageView) {
        this.n = frameLayout;
        this.mImageView = touchImageView;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweatherservicebase.databinding.ActivitySkiImagePreviewBinding bind(@androidx.annotation.NonNull android.view.View view) {
        int i = moji.com.mjweatherservicebase.R.id.mImageView;
        com.moji.imageview.TouchImageView findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (findChildViewById != null) {
            return new moji.com.mjweatherservicebase.databinding.ActivitySkiImagePreviewBinding((android.widget.FrameLayout) view, findChildViewById);
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweatherservicebase.databinding.ActivitySkiImagePreviewBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweatherservicebase.databinding.ActivitySkiImagePreviewBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweatherservicebase.R.layout.activity_ski_image_preview, viewGroup, false);
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
