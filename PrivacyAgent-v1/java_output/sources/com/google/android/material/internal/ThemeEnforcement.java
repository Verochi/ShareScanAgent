package com.google.android.material.internal;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes22.dex */
public final class ThemeEnforcement {
    private static final java.lang.String APPCOMPAT_THEME_NAME = "Theme.AppCompat";
    private static final java.lang.String MATERIAL_THEME_NAME = "Theme.MaterialComponents";
    private static final int[] APPCOMPAT_CHECK_ATTRS = {com.google.android.material.R.attr.colorPrimary};
    private static final int[] MATERIAL_CHECK_ATTRS = {com.google.android.material.R.attr.colorPrimaryVariant};

    private ThemeEnforcement() {
    }

    public static void checkAppCompatTheme(@androidx.annotation.NonNull android.content.Context context) {
        checkTheme(context, APPCOMPAT_CHECK_ATTRS, APPCOMPAT_THEME_NAME);
    }

    private static void checkCompatibleTheme(@androidx.annotation.NonNull android.content.Context context, android.util.AttributeSet attributeSet, @androidx.annotation.AttrRes int i, @androidx.annotation.StyleRes int i2) {
        android.content.res.TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.google.android.material.R.styleable.ThemeEnforcement, i, i2);
        boolean z = obtainStyledAttributes.getBoolean(com.google.android.material.R.styleable.ThemeEnforcement_enforceMaterialTheme, false);
        obtainStyledAttributes.recycle();
        if (z) {
            android.util.TypedValue typedValue = new android.util.TypedValue();
            if (!context.getTheme().resolveAttribute(com.google.android.material.R.attr.isMaterialTheme, typedValue, true) || (typedValue.type == 18 && typedValue.data == 0)) {
                checkMaterialTheme(context);
            }
        }
        checkAppCompatTheme(context);
    }

    public static void checkMaterialTheme(@androidx.annotation.NonNull android.content.Context context) {
        checkTheme(context, MATERIAL_CHECK_ATTRS, MATERIAL_THEME_NAME);
    }

    private static void checkTextAppearance(@androidx.annotation.NonNull android.content.Context context, android.util.AttributeSet attributeSet, @androidx.annotation.NonNull @androidx.annotation.StyleableRes int[] iArr, @androidx.annotation.AttrRes int i, @androidx.annotation.StyleRes int i2, @androidx.annotation.Nullable @androidx.annotation.StyleableRes int... iArr2) {
        boolean z;
        android.content.res.TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.google.android.material.R.styleable.ThemeEnforcement, i, i2);
        if (!obtainStyledAttributes.getBoolean(com.google.android.material.R.styleable.ThemeEnforcement_enforceTextAppearance, false)) {
            obtainStyledAttributes.recycle();
            return;
        }
        if (iArr2 == null || iArr2.length == 0) {
            z = obtainStyledAttributes.getResourceId(com.google.android.material.R.styleable.ThemeEnforcement_android_textAppearance, -1) != -1;
        } else {
            z = isCustomTextAppearanceValid(context, attributeSet, iArr, i, i2, iArr2);
        }
        obtainStyledAttributes.recycle();
        if (!z) {
            throw new java.lang.IllegalArgumentException("This component requires that you specify a valid TextAppearance attribute. Update your app theme to inherit from Theme.MaterialComponents (or a descendant).");
        }
    }

    private static void checkTheme(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull int[] iArr, java.lang.String str) {
        if (isTheme(context, iArr)) {
            return;
        }
        throw new java.lang.IllegalArgumentException("The style on this component requires your app theme to be " + str + " (or a descendant).");
    }

    public static boolean isAppCompatTheme(@androidx.annotation.NonNull android.content.Context context) {
        return isTheme(context, APPCOMPAT_CHECK_ATTRS);
    }

    private static boolean isCustomTextAppearanceValid(@androidx.annotation.NonNull android.content.Context context, android.util.AttributeSet attributeSet, @androidx.annotation.NonNull @androidx.annotation.StyleableRes int[] iArr, @androidx.annotation.AttrRes int i, @androidx.annotation.StyleRes int i2, @androidx.annotation.NonNull @androidx.annotation.StyleableRes int... iArr2) {
        android.content.res.TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i, i2);
        for (int i3 : iArr2) {
            if (obtainStyledAttributes.getResourceId(i3, -1) == -1) {
                obtainStyledAttributes.recycle();
                return false;
            }
        }
        obtainStyledAttributes.recycle();
        return true;
    }

    public static boolean isMaterialTheme(@androidx.annotation.NonNull android.content.Context context) {
        return isTheme(context, MATERIAL_CHECK_ATTRS);
    }

    private static boolean isTheme(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull int[] iArr) {
        android.content.res.TypedArray obtainStyledAttributes = context.obtainStyledAttributes(iArr);
        for (int i = 0; i < iArr.length; i++) {
            if (!obtainStyledAttributes.hasValue(i)) {
                obtainStyledAttributes.recycle();
                return false;
            }
        }
        obtainStyledAttributes.recycle();
        return true;
    }

    @androidx.annotation.NonNull
    public static android.content.res.TypedArray obtainStyledAttributes(@androidx.annotation.NonNull android.content.Context context, android.util.AttributeSet attributeSet, @androidx.annotation.NonNull @androidx.annotation.StyleableRes int[] iArr, @androidx.annotation.AttrRes int i, @androidx.annotation.StyleRes int i2, @androidx.annotation.StyleableRes int... iArr2) {
        checkCompatibleTheme(context, attributeSet, i, i2);
        checkTextAppearance(context, attributeSet, iArr, i, i2, iArr2);
        return context.obtainStyledAttributes(attributeSet, iArr, i, i2);
    }

    public static androidx.appcompat.widget.TintTypedArray obtainTintedStyledAttributes(@androidx.annotation.NonNull android.content.Context context, android.util.AttributeSet attributeSet, @androidx.annotation.NonNull @androidx.annotation.StyleableRes int[] iArr, @androidx.annotation.AttrRes int i, @androidx.annotation.StyleRes int i2, @androidx.annotation.StyleableRes int... iArr2) {
        checkCompatibleTheme(context, attributeSet, i, i2);
        checkTextAppearance(context, attributeSet, iArr, i, i2, iArr2);
        return androidx.appcompat.widget.TintTypedArray.obtainStyledAttributes(context, attributeSet, iArr, i, i2);
    }
}
