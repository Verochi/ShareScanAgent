package androidx.transition;

/* loaded from: classes.dex */
class ImageViewUtils {
    private static java.lang.reflect.Field sDrawMatrixField = null;
    private static boolean sDrawMatrixFieldFetched = false;
    private static boolean sTryHiddenAnimateTransform = true;

    private ImageViewUtils() {
    }

    public static void animateTransform(@androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.Nullable android.graphics.Matrix matrix) {
        if (android.os.Build.VERSION.SDK_INT >= 29) {
            imageView.animateTransform(matrix);
            return;
        }
        if (matrix != null) {
            hiddenAnimateTransform(imageView, matrix);
            return;
        }
        android.graphics.drawable.Drawable drawable = imageView.getDrawable();
        if (drawable != null) {
            drawable.setBounds(0, 0, (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight(), (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom());
            imageView.invalidate();
        }
    }

    private static void fetchDrawMatrixField() {
        if (sDrawMatrixFieldFetched) {
            return;
        }
        try {
            java.lang.reflect.Field declaredField = android.widget.ImageView.class.getDeclaredField("mDrawMatrix");
            sDrawMatrixField = declaredField;
            declaredField.setAccessible(true);
        } catch (java.lang.NoSuchFieldException unused) {
        }
        sDrawMatrixFieldFetched = true;
    }

    @androidx.annotation.RequiresApi(21)
    @android.annotation.SuppressLint({"NewApi"})
    private static void hiddenAnimateTransform(@androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.Nullable android.graphics.Matrix matrix) {
        if (sTryHiddenAnimateTransform) {
            try {
                imageView.animateTransform(matrix);
            } catch (java.lang.NoSuchMethodError unused) {
                sTryHiddenAnimateTransform = false;
            }
        }
    }
}
