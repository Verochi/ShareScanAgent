package com.google.android.material.dialog;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes22.dex */
public class MaterialDialogs {
    private MaterialDialogs() {
    }

    @androidx.annotation.NonNull
    public static android.graphics.Rect getDialogBackgroundInsets(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.AttrRes int i, int i2) {
        android.content.res.TypedArray obtainStyledAttributes = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(context, null, com.google.android.material.R.styleable.MaterialAlertDialog, i, i2, new int[0]);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.MaterialAlertDialog_backgroundInsetStart, context.getResources().getDimensionPixelSize(com.google.android.material.R.dimen.mtrl_alert_dialog_background_inset_start));
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.MaterialAlertDialog_backgroundInsetTop, context.getResources().getDimensionPixelSize(com.google.android.material.R.dimen.mtrl_alert_dialog_background_inset_top));
        int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.MaterialAlertDialog_backgroundInsetEnd, context.getResources().getDimensionPixelSize(com.google.android.material.R.dimen.mtrl_alert_dialog_background_inset_end));
        int dimensionPixelSize4 = obtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.MaterialAlertDialog_backgroundInsetBottom, context.getResources().getDimensionPixelSize(com.google.android.material.R.dimen.mtrl_alert_dialog_background_inset_bottom));
        obtainStyledAttributes.recycle();
        if (context.getResources().getConfiguration().getLayoutDirection() == 1) {
            dimensionPixelSize3 = dimensionPixelSize;
            dimensionPixelSize = dimensionPixelSize3;
        }
        return new android.graphics.Rect(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize3, dimensionPixelSize4);
    }

    @androidx.annotation.NonNull
    public static android.graphics.drawable.InsetDrawable insetDrawable(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable, @androidx.annotation.NonNull android.graphics.Rect rect) {
        return new android.graphics.drawable.InsetDrawable(drawable, rect.left, rect.top, rect.right, rect.bottom);
    }
}
