package com.google.android.material.color;

/* loaded from: classes22.dex */
public class MaterialColors {
    public static final float ALPHA_DISABLED = 0.38f;
    public static final float ALPHA_DISABLED_LOW = 0.12f;
    public static final float ALPHA_FULL = 1.0f;
    public static final float ALPHA_LOW = 0.32f;
    public static final float ALPHA_MEDIUM = 0.54f;

    private MaterialColors() {
    }

    @androidx.annotation.ColorInt
    public static int compositeARGBWithAlpha(@androidx.annotation.ColorInt int i, @androidx.annotation.IntRange(from = 0, to = 255) int i2) {
        return androidx.core.graphics.ColorUtils.setAlphaComponent(i, (android.graphics.Color.alpha(i) * i2) / 255);
    }

    @androidx.annotation.ColorInt
    public static int getColor(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.AttrRes int i, @androidx.annotation.ColorInt int i2) {
        android.util.TypedValue resolve = com.google.android.material.resources.MaterialAttributes.resolve(context, i);
        return resolve != null ? resolve.data : i2;
    }

    @androidx.annotation.ColorInt
    public static int getColor(android.content.Context context, @androidx.annotation.AttrRes int i, java.lang.String str) {
        return com.google.android.material.resources.MaterialAttributes.resolveOrThrow(context, i, str);
    }

    @androidx.annotation.ColorInt
    public static int getColor(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.AttrRes int i) {
        return com.google.android.material.resources.MaterialAttributes.resolveOrThrow(view, i);
    }

    @androidx.annotation.ColorInt
    public static int getColor(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.AttrRes int i, @androidx.annotation.ColorInt int i2) {
        return getColor(view.getContext(), i, i2);
    }

    public static boolean isColorLight(@androidx.annotation.ColorInt int i) {
        return i != 0 && androidx.core.graphics.ColorUtils.calculateLuminance(i) > 0.5d;
    }

    @androidx.annotation.ColorInt
    public static int layer(@androidx.annotation.ColorInt int i, @androidx.annotation.ColorInt int i2) {
        return androidx.core.graphics.ColorUtils.compositeColors(i2, i);
    }

    @androidx.annotation.ColorInt
    public static int layer(@androidx.annotation.ColorInt int i, @androidx.annotation.ColorInt int i2, @androidx.annotation.FloatRange(from = 0.0d, to = 1.0d) float f) {
        return layer(i, androidx.core.graphics.ColorUtils.setAlphaComponent(i2, java.lang.Math.round(android.graphics.Color.alpha(i2) * f)));
    }

    @androidx.annotation.ColorInt
    public static int layer(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.AttrRes int i, @androidx.annotation.AttrRes int i2) {
        return layer(view, i, i2, 1.0f);
    }

    @androidx.annotation.ColorInt
    public static int layer(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.AttrRes int i, @androidx.annotation.AttrRes int i2, @androidx.annotation.FloatRange(from = 0.0d, to = 1.0d) float f) {
        return layer(getColor(view, i), getColor(view, i2), f);
    }
}
