package androidx.core.widget;

/* loaded from: classes.dex */
public final class CompoundButtonCompat {
    private static final java.lang.String TAG = "CompoundButtonCompat";
    private static java.lang.reflect.Field sButtonDrawableField;
    private static boolean sButtonDrawableFieldFetched;

    private CompoundButtonCompat() {
    }

    @androidx.annotation.Nullable
    public static android.graphics.drawable.Drawable getButtonDrawable(@androidx.annotation.NonNull android.widget.CompoundButton compoundButton) {
        android.graphics.drawable.Drawable buttonDrawable;
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            buttonDrawable = compoundButton.getButtonDrawable();
            return buttonDrawable;
        }
        if (!sButtonDrawableFieldFetched) {
            try {
                java.lang.reflect.Field declaredField = android.widget.CompoundButton.class.getDeclaredField("mButtonDrawable");
                sButtonDrawableField = declaredField;
                declaredField.setAccessible(true);
            } catch (java.lang.NoSuchFieldException unused) {
            }
            sButtonDrawableFieldFetched = true;
        }
        java.lang.reflect.Field field = sButtonDrawableField;
        if (field != null) {
            try {
                return (android.graphics.drawable.Drawable) field.get(compoundButton);
            } catch (java.lang.IllegalAccessException unused2) {
                sButtonDrawableField = null;
            }
        }
        return null;
    }

    @androidx.annotation.Nullable
    public static android.content.res.ColorStateList getButtonTintList(@androidx.annotation.NonNull android.widget.CompoundButton compoundButton) {
        return compoundButton.getButtonTintList();
    }

    @androidx.annotation.Nullable
    public static android.graphics.PorterDuff.Mode getButtonTintMode(@androidx.annotation.NonNull android.widget.CompoundButton compoundButton) {
        return compoundButton.getButtonTintMode();
    }

    public static void setButtonTintList(@androidx.annotation.NonNull android.widget.CompoundButton compoundButton, @androidx.annotation.Nullable android.content.res.ColorStateList colorStateList) {
        compoundButton.setButtonTintList(colorStateList);
    }

    public static void setButtonTintMode(@androidx.annotation.NonNull android.widget.CompoundButton compoundButton, @androidx.annotation.Nullable android.graphics.PorterDuff.Mode mode) {
        compoundButton.setButtonTintMode(mode);
    }
}
