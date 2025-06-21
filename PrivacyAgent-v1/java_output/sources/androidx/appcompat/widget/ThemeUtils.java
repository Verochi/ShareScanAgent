package androidx.appcompat.widget;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class ThemeUtils {
    private static final java.lang.String TAG = "ThemeUtils";
    private static final java.lang.ThreadLocal<android.util.TypedValue> TL_TYPED_VALUE = new java.lang.ThreadLocal<>();
    static final int[] DISABLED_STATE_SET = {-16842910};
    static final int[] FOCUSED_STATE_SET = {android.R.attr.state_focused};
    static final int[] ACTIVATED_STATE_SET = {android.R.attr.state_activated};
    static final int[] PRESSED_STATE_SET = {android.R.attr.state_pressed};
    static final int[] CHECKED_STATE_SET = {android.R.attr.state_checked};
    static final int[] SELECTED_STATE_SET = {android.R.attr.state_selected};
    static final int[] NOT_PRESSED_OR_FOCUSED_STATE_SET = {-16842919, -16842908};
    static final int[] EMPTY_STATE_SET = new int[0];
    private static final int[] TEMP_ARRAY = new int[1];

    private ThemeUtils() {
    }

    public static void checkAppCompatTheme(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull android.content.Context context) {
        android.content.res.TypedArray obtainStyledAttributes = context.obtainStyledAttributes(androidx.appcompat.R.styleable.AppCompatTheme);
        try {
            if (!obtainStyledAttributes.hasValue(androidx.appcompat.R.styleable.AppCompatTheme_windowActionBar)) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("View ");
                sb.append(view.getClass());
                sb.append(" is an AppCompat widget that can only be used with a Theme.AppCompat theme (or descendant).");
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @androidx.annotation.NonNull
    public static android.content.res.ColorStateList createDisabledStateList(int i, int i2) {
        return new android.content.res.ColorStateList(new int[][]{DISABLED_STATE_SET, EMPTY_STATE_SET}, new int[]{i2, i});
    }

    public static int getDisabledThemeAttrColor(@androidx.annotation.NonNull android.content.Context context, int i) {
        android.content.res.ColorStateList themeAttrColorStateList = getThemeAttrColorStateList(context, i);
        if (themeAttrColorStateList != null && themeAttrColorStateList.isStateful()) {
            return themeAttrColorStateList.getColorForState(DISABLED_STATE_SET, themeAttrColorStateList.getDefaultColor());
        }
        android.util.TypedValue typedValue = getTypedValue();
        context.getTheme().resolveAttribute(android.R.attr.disabledAlpha, typedValue, true);
        return getThemeAttrColor(context, i, typedValue.getFloat());
    }

    public static int getThemeAttrColor(@androidx.annotation.NonNull android.content.Context context, int i) {
        int[] iArr = TEMP_ARRAY;
        iArr[0] = i;
        androidx.appcompat.widget.TintTypedArray obtainStyledAttributes = androidx.appcompat.widget.TintTypedArray.obtainStyledAttributes(context, (android.util.AttributeSet) null, iArr);
        try {
            return obtainStyledAttributes.getColor(0, 0);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static int getThemeAttrColor(@androidx.annotation.NonNull android.content.Context context, int i, float f) {
        return androidx.core.graphics.ColorUtils.setAlphaComponent(getThemeAttrColor(context, i), java.lang.Math.round(android.graphics.Color.alpha(r0) * f));
    }

    @androidx.annotation.Nullable
    public static android.content.res.ColorStateList getThemeAttrColorStateList(@androidx.annotation.NonNull android.content.Context context, int i) {
        int[] iArr = TEMP_ARRAY;
        iArr[0] = i;
        androidx.appcompat.widget.TintTypedArray obtainStyledAttributes = androidx.appcompat.widget.TintTypedArray.obtainStyledAttributes(context, (android.util.AttributeSet) null, iArr);
        try {
            return obtainStyledAttributes.getColorStateList(0);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private static android.util.TypedValue getTypedValue() {
        java.lang.ThreadLocal<android.util.TypedValue> threadLocal = TL_TYPED_VALUE;
        android.util.TypedValue typedValue = threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        android.util.TypedValue typedValue2 = new android.util.TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }
}
