package com.google.android.material.resources;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes22.dex */
public class MaterialAttributes {
    @androidx.annotation.Nullable
    public static android.util.TypedValue resolve(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.AttrRes int i) {
        android.util.TypedValue typedValue = new android.util.TypedValue();
        if (context.getTheme().resolveAttribute(i, typedValue, true)) {
            return typedValue;
        }
        return null;
    }

    public static boolean resolveBoolean(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.AttrRes int i, boolean z) {
        android.util.TypedValue resolve = resolve(context, i);
        return (resolve == null || resolve.type != 18) ? z : resolve.data != 0;
    }

    public static boolean resolveBooleanOrThrow(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.AttrRes int i, @androidx.annotation.NonNull java.lang.String str) {
        return resolveOrThrow(context, i, str) != 0;
    }

    @androidx.annotation.Px
    public static int resolveDimension(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.AttrRes int i, @androidx.annotation.DimenRes int i2) {
        android.util.TypedValue resolve = resolve(context, i);
        return (int) ((resolve == null || resolve.type != 5) ? context.getResources().getDimension(i2) : resolve.getDimension(context.getResources().getDisplayMetrics()));
    }

    public static int resolveInteger(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.AttrRes int i, int i2) {
        android.util.TypedValue resolve = resolve(context, i);
        return (resolve == null || resolve.type != 16) ? i2 : resolve.data;
    }

    @androidx.annotation.Px
    public static int resolveMinimumAccessibleTouchTarget(@androidx.annotation.NonNull android.content.Context context) {
        return resolveDimension(context, com.google.android.material.R.attr.minTouchTargetSize, com.google.android.material.R.dimen.mtrl_min_touch_target_size);
    }

    public static int resolveOrThrow(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.AttrRes int i, @androidx.annotation.NonNull java.lang.String str) {
        android.util.TypedValue resolve = resolve(context, i);
        if (resolve != null) {
            return resolve.data;
        }
        throw new java.lang.IllegalArgumentException(java.lang.String.format("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", str, context.getResources().getResourceName(i)));
    }

    public static int resolveOrThrow(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.AttrRes int i) {
        return resolveOrThrow(view.getContext(), i, view.getClass().getCanonicalName());
    }
}
