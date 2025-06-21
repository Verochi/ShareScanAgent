package androidx.core.widget;

/* loaded from: classes.dex */
public class ImageViewCompat {
    private ImageViewCompat() {
    }

    @androidx.annotation.Nullable
    public static android.content.res.ColorStateList getImageTintList(@androidx.annotation.NonNull android.widget.ImageView imageView) {
        return imageView.getImageTintList();
    }

    @androidx.annotation.Nullable
    public static android.graphics.PorterDuff.Mode getImageTintMode(@androidx.annotation.NonNull android.widget.ImageView imageView) {
        return imageView.getImageTintMode();
    }

    public static void setImageTintList(@androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.Nullable android.content.res.ColorStateList colorStateList) {
        android.graphics.drawable.Drawable drawable;
        int i = android.os.Build.VERSION.SDK_INT;
        imageView.setImageTintList(colorStateList);
        if (i != 21 || (drawable = imageView.getDrawable()) == null || imageView.getImageTintList() == null) {
            return;
        }
        if (drawable.isStateful()) {
            drawable.setState(imageView.getDrawableState());
        }
        imageView.setImageDrawable(drawable);
    }

    public static void setImageTintMode(@androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.Nullable android.graphics.PorterDuff.Mode mode) {
        android.graphics.drawable.Drawable drawable;
        int i = android.os.Build.VERSION.SDK_INT;
        imageView.setImageTintMode(mode);
        if (i != 21 || (drawable = imageView.getDrawable()) == null || imageView.getImageTintList() == null) {
            return;
        }
        if (drawable.isStateful()) {
            drawable.setState(imageView.getDrawableState());
        }
        imageView.setImageDrawable(drawable);
    }
}
