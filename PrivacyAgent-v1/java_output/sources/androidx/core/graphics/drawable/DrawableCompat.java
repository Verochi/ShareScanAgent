package androidx.core.graphics.drawable;

/* loaded from: classes.dex */
public final class DrawableCompat {
    private static final java.lang.String TAG = "DrawableCompat";
    private static java.lang.reflect.Method sGetLayoutDirectionMethod;
    private static boolean sGetLayoutDirectionMethodFetched;
    private static java.lang.reflect.Method sSetLayoutDirectionMethod;
    private static boolean sSetLayoutDirectionMethodFetched;

    private DrawableCompat() {
    }

    public static void applyTheme(@androidx.annotation.NonNull android.graphics.drawable.Drawable drawable, @androidx.annotation.NonNull android.content.res.Resources.Theme theme) {
        drawable.applyTheme(theme);
    }

    public static boolean canApplyTheme(@androidx.annotation.NonNull android.graphics.drawable.Drawable drawable) {
        return drawable.canApplyTheme();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void clearColorFilter(@androidx.annotation.NonNull android.graphics.drawable.Drawable drawable) {
        android.graphics.drawable.DrawableContainer.DrawableContainerState drawableContainerState;
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            drawable.clearColorFilter();
            return;
        }
        drawable.clearColorFilter();
        if (drawable instanceof android.graphics.drawable.InsetDrawable) {
            clearColorFilter(((android.graphics.drawable.InsetDrawable) drawable).getDrawable());
            return;
        }
        if (drawable instanceof androidx.core.graphics.drawable.WrappedDrawable) {
            clearColorFilter(((androidx.core.graphics.drawable.WrappedDrawable) drawable).getWrappedDrawable());
            return;
        }
        if (!(drawable instanceof android.graphics.drawable.DrawableContainer) || (drawableContainerState = (android.graphics.drawable.DrawableContainer.DrawableContainerState) ((android.graphics.drawable.DrawableContainer) drawable).getConstantState()) == null) {
            return;
        }
        int childCount = drawableContainerState.getChildCount();
        for (int i = 0; i < childCount; i++) {
            android.graphics.drawable.Drawable child = drawableContainerState.getChild(i);
            if (child != null) {
                clearColorFilter(child);
            }
        }
    }

    public static int getAlpha(@androidx.annotation.NonNull android.graphics.drawable.Drawable drawable) {
        return drawable.getAlpha();
    }

    public static android.graphics.ColorFilter getColorFilter(@androidx.annotation.NonNull android.graphics.drawable.Drawable drawable) {
        return drawable.getColorFilter();
    }

    public static int getLayoutDirection(@androidx.annotation.NonNull android.graphics.drawable.Drawable drawable) {
        int layoutDirection;
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            layoutDirection = drawable.getLayoutDirection();
            return layoutDirection;
        }
        if (!sGetLayoutDirectionMethodFetched) {
            try {
                java.lang.reflect.Method declaredMethod = android.graphics.drawable.Drawable.class.getDeclaredMethod("getLayoutDirection", new java.lang.Class[0]);
                sGetLayoutDirectionMethod = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (java.lang.NoSuchMethodException unused) {
            }
            sGetLayoutDirectionMethodFetched = true;
        }
        java.lang.reflect.Method method = sGetLayoutDirectionMethod;
        if (method != null) {
            try {
                return ((java.lang.Integer) method.invoke(drawable, new java.lang.Object[0])).intValue();
            } catch (java.lang.Exception unused2) {
                sGetLayoutDirectionMethod = null;
            }
        }
        return 0;
    }

    public static void inflate(@androidx.annotation.NonNull android.graphics.drawable.Drawable drawable, @androidx.annotation.NonNull android.content.res.Resources resources, @androidx.annotation.NonNull org.xmlpull.v1.XmlPullParser xmlPullParser, @androidx.annotation.NonNull android.util.AttributeSet attributeSet, @androidx.annotation.Nullable android.content.res.Resources.Theme theme) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        drawable.inflate(resources, xmlPullParser, attributeSet, theme);
    }

    public static boolean isAutoMirrored(@androidx.annotation.NonNull android.graphics.drawable.Drawable drawable) {
        return drawable.isAutoMirrored();
    }

    @java.lang.Deprecated
    public static void jumpToCurrentState(@androidx.annotation.NonNull android.graphics.drawable.Drawable drawable) {
        drawable.jumpToCurrentState();
    }

    public static void setAutoMirrored(@androidx.annotation.NonNull android.graphics.drawable.Drawable drawable, boolean z) {
        drawable.setAutoMirrored(z);
    }

    public static void setHotspot(@androidx.annotation.NonNull android.graphics.drawable.Drawable drawable, float f, float f2) {
        drawable.setHotspot(f, f2);
    }

    public static void setHotspotBounds(@androidx.annotation.NonNull android.graphics.drawable.Drawable drawable, int i, int i2, int i3, int i4) {
        drawable.setHotspotBounds(i, i2, i3, i4);
    }

    public static boolean setLayoutDirection(@androidx.annotation.NonNull android.graphics.drawable.Drawable drawable, int i) {
        boolean layoutDirection;
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            layoutDirection = drawable.setLayoutDirection(i);
            return layoutDirection;
        }
        if (!sSetLayoutDirectionMethodFetched) {
            try {
                java.lang.reflect.Method declaredMethod = android.graphics.drawable.Drawable.class.getDeclaredMethod("setLayoutDirection", java.lang.Integer.TYPE);
                sSetLayoutDirectionMethod = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (java.lang.NoSuchMethodException unused) {
            }
            sSetLayoutDirectionMethodFetched = true;
        }
        java.lang.reflect.Method method = sSetLayoutDirectionMethod;
        if (method != null) {
            try {
                method.invoke(drawable, java.lang.Integer.valueOf(i));
                return true;
            } catch (java.lang.Exception unused2) {
                sSetLayoutDirectionMethod = null;
            }
        }
        return false;
    }

    public static void setTint(@androidx.annotation.NonNull android.graphics.drawable.Drawable drawable, @androidx.annotation.ColorInt int i) {
        drawable.setTint(i);
    }

    public static void setTintList(@androidx.annotation.NonNull android.graphics.drawable.Drawable drawable, @androidx.annotation.Nullable android.content.res.ColorStateList colorStateList) {
        drawable.setTintList(colorStateList);
    }

    public static void setTintMode(@androidx.annotation.NonNull android.graphics.drawable.Drawable drawable, @androidx.annotation.NonNull android.graphics.PorterDuff.Mode mode) {
        drawable.setTintMode(mode);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T extends android.graphics.drawable.Drawable> T unwrap(@androidx.annotation.NonNull android.graphics.drawable.Drawable drawable) {
        return drawable instanceof androidx.core.graphics.drawable.WrappedDrawable ? (T) ((androidx.core.graphics.drawable.WrappedDrawable) drawable).getWrappedDrawable() : drawable;
    }

    public static android.graphics.drawable.Drawable wrap(@androidx.annotation.NonNull android.graphics.drawable.Drawable drawable) {
        return (android.os.Build.VERSION.SDK_INT < 23 && !(drawable instanceof androidx.core.graphics.drawable.TintAwareDrawable)) ? new androidx.core.graphics.drawable.WrappedDrawableApi21(drawable) : drawable;
    }
}
