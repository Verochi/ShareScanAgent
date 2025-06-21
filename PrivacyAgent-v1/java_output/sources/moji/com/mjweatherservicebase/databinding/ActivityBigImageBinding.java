package moji.com.mjweatherservicebase.databinding;

/* loaded from: classes20.dex */
public final class ActivityBigImageBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.ImageView ivClose;

    @androidx.annotation.NonNull
    public final com.moji.imageview.TouchImageView ivPreImage;

    @androidx.annotation.NonNull
    public final android.widget.FrameLayout n;

    public ActivityBigImageBinding(@androidx.annotation.NonNull android.widget.FrameLayout frameLayout, @androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull com.moji.imageview.TouchImageView touchImageView) {
        this.n = frameLayout;
        this.ivClose = imageView;
        this.ivPreImage = touchImageView;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweatherservicebase.databinding.ActivityBigImageBinding bind(@androidx.annotation.NonNull android.view.View view) {
        com.moji.imageview.TouchImageView findChildViewById;
        int i = moji.com.mjweatherservicebase.R.id.ivClose;
        android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (imageView == null || (findChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = moji.com.mjweatherservicebase.R.id.ivPreImage))) == null) {
            throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new moji.com.mjweatherservicebase.databinding.ActivityBigImageBinding((android.widget.FrameLayout) view, imageView, findChildViewById);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweatherservicebase.databinding.ActivityBigImageBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweatherservicebase.databinding.ActivityBigImageBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweatherservicebase.R.layout.activity_big_image, viewGroup, false);
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
