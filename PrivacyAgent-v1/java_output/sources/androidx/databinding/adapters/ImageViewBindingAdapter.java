package androidx.databinding.adapters;

@androidx.databinding.BindingMethods({@androidx.databinding.BindingMethod(attribute = "android:tint", method = "setImageTintList", type = android.widget.ImageView.class), @androidx.databinding.BindingMethod(attribute = "android:tintMode", method = "setImageTintMode", type = android.widget.ImageView.class)})
@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class ImageViewBindingAdapter {
    @androidx.databinding.BindingAdapter({"android:src"})
    public static void setImageDrawable(android.widget.ImageView imageView, android.graphics.drawable.Drawable drawable) {
        imageView.setImageDrawable(drawable);
    }

    @androidx.databinding.BindingAdapter({"android:src"})
    public static void setImageUri(android.widget.ImageView imageView, android.net.Uri uri) {
        imageView.setImageURI(uri);
    }

    @androidx.databinding.BindingAdapter({"android:src"})
    public static void setImageUri(android.widget.ImageView imageView, java.lang.String str) {
        if (str == null) {
            imageView.setImageURI(null);
        } else {
            imageView.setImageURI(android.net.Uri.parse(str));
        }
    }
}
