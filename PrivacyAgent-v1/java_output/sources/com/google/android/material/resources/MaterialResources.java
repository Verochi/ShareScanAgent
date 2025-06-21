package com.google.android.material.resources;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes22.dex */
public class MaterialResources {
    private static final float FONT_SCALE_1_3 = 1.3f;
    private static final float FONT_SCALE_2_0 = 2.0f;

    private MaterialResources() {
    }

    @androidx.annotation.Nullable
    public static android.content.res.ColorStateList getColorStateList(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.content.res.TypedArray typedArray, @androidx.annotation.StyleableRes int i) {
        int resourceId;
        android.content.res.ColorStateList colorStateList;
        return (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0 || (colorStateList = androidx.appcompat.content.res.AppCompatResources.getColorStateList(context, resourceId)) == null) ? typedArray.getColorStateList(i) : colorStateList;
    }

    @androidx.annotation.Nullable
    public static android.content.res.ColorStateList getColorStateList(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull androidx.appcompat.widget.TintTypedArray tintTypedArray, @androidx.annotation.StyleableRes int i) {
        int resourceId;
        android.content.res.ColorStateList colorStateList;
        return (!tintTypedArray.hasValue(i) || (resourceId = tintTypedArray.getResourceId(i, 0)) == 0 || (colorStateList = androidx.appcompat.content.res.AppCompatResources.getColorStateList(context, resourceId)) == null) ? tintTypedArray.getColorStateList(i) : colorStateList;
    }

    public static int getDimensionPixelSize(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.content.res.TypedArray typedArray, @androidx.annotation.StyleableRes int i, int i2) {
        android.util.TypedValue typedValue = new android.util.TypedValue();
        if (!typedArray.getValue(i, typedValue) || typedValue.type != 2) {
            return typedArray.getDimensionPixelSize(i, i2);
        }
        android.content.res.TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{typedValue.data});
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, i2);
        obtainStyledAttributes.recycle();
        return dimensionPixelSize;
    }

    @androidx.annotation.Nullable
    public static android.graphics.drawable.Drawable getDrawable(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.content.res.TypedArray typedArray, @androidx.annotation.StyleableRes int i) {
        int resourceId;
        android.graphics.drawable.Drawable drawable;
        return (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0 || (drawable = androidx.appcompat.content.res.AppCompatResources.getDrawable(context, resourceId)) == null) ? typedArray.getDrawable(i) : drawable;
    }

    @androidx.annotation.StyleableRes
    public static int getIndexWithValue(@androidx.annotation.NonNull android.content.res.TypedArray typedArray, @androidx.annotation.StyleableRes int i, @androidx.annotation.StyleableRes int i2) {
        return typedArray.hasValue(i) ? i : i2;
    }

    @androidx.annotation.Nullable
    public static com.google.android.material.resources.TextAppearance getTextAppearance(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.content.res.TypedArray typedArray, @androidx.annotation.StyleableRes int i) {
        int resourceId;
        if (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0) {
            return null;
        }
        return new com.google.android.material.resources.TextAppearance(context, resourceId);
    }

    public static boolean isFontScaleAtLeast1_3(@androidx.annotation.NonNull android.content.Context context) {
        return context.getResources().getConfiguration().fontScale >= FONT_SCALE_1_3;
    }

    public static boolean isFontScaleAtLeast2_0(@androidx.annotation.NonNull android.content.Context context) {
        return context.getResources().getConfiguration().fontScale >= 2.0f;
    }
}
