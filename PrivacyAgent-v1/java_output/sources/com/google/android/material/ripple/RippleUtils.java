package com.google.android.material.ripple;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes22.dex */
public class RippleUtils {

    @androidx.annotation.VisibleForTesting
    static final java.lang.String TRANSPARENT_DEFAULT_COLOR_WARNING = "Use a non-transparent color for the default color as it will be used to finish ripple animations.";
    public static final boolean USE_FRAMEWORK_RIPPLE = true;
    private static final int[] PRESSED_STATE_SET = {android.R.attr.state_pressed};
    private static final int[] HOVERED_FOCUSED_STATE_SET = {android.R.attr.state_hovered, android.R.attr.state_focused};
    private static final int[] FOCUSED_STATE_SET = {android.R.attr.state_focused};
    private static final int[] HOVERED_STATE_SET = {android.R.attr.state_hovered};
    private static final int[] SELECTED_PRESSED_STATE_SET = {android.R.attr.state_selected, android.R.attr.state_pressed};
    private static final int[] SELECTED_HOVERED_FOCUSED_STATE_SET = {android.R.attr.state_selected, android.R.attr.state_hovered, android.R.attr.state_focused};
    private static final int[] SELECTED_FOCUSED_STATE_SET = {android.R.attr.state_selected, android.R.attr.state_focused};
    private static final int[] SELECTED_HOVERED_STATE_SET = {android.R.attr.state_selected, android.R.attr.state_hovered};
    private static final int[] SELECTED_STATE_SET = {android.R.attr.state_selected};
    private static final int[] ENABLED_PRESSED_STATE_SET = {android.R.attr.state_enabled, android.R.attr.state_pressed};

    @androidx.annotation.VisibleForTesting
    static final java.lang.String LOG_TAG = com.google.android.material.ripple.RippleUtils.class.getSimpleName();

    private RippleUtils() {
    }

    @androidx.annotation.NonNull
    public static android.content.res.ColorStateList convertToRippleDrawableColor(@androidx.annotation.Nullable android.content.res.ColorStateList colorStateList) {
        if (USE_FRAMEWORK_RIPPLE) {
            return new android.content.res.ColorStateList(new int[][]{SELECTED_STATE_SET, android.util.StateSet.NOTHING}, new int[]{getColorForState(colorStateList, SELECTED_PRESSED_STATE_SET), getColorForState(colorStateList, PRESSED_STATE_SET)});
        }
        int[] iArr = SELECTED_PRESSED_STATE_SET;
        int[] iArr2 = SELECTED_HOVERED_FOCUSED_STATE_SET;
        int[] iArr3 = SELECTED_FOCUSED_STATE_SET;
        int[] iArr4 = SELECTED_HOVERED_STATE_SET;
        int[] iArr5 = PRESSED_STATE_SET;
        int[] iArr6 = HOVERED_FOCUSED_STATE_SET;
        int[] iArr7 = FOCUSED_STATE_SET;
        int[] iArr8 = HOVERED_STATE_SET;
        return new android.content.res.ColorStateList(new int[][]{iArr, iArr2, iArr3, iArr4, SELECTED_STATE_SET, iArr5, iArr6, iArr7, iArr8, android.util.StateSet.NOTHING}, new int[]{getColorForState(colorStateList, iArr), getColorForState(colorStateList, iArr2), getColorForState(colorStateList, iArr3), getColorForState(colorStateList, iArr4), 0, getColorForState(colorStateList, iArr5), getColorForState(colorStateList, iArr6), getColorForState(colorStateList, iArr7), getColorForState(colorStateList, iArr8), 0});
    }

    @androidx.annotation.ColorInt
    @android.annotation.TargetApi(21)
    private static int doubleAlpha(@androidx.annotation.ColorInt int i) {
        return androidx.core.graphics.ColorUtils.setAlphaComponent(i, java.lang.Math.min(android.graphics.Color.alpha(i) * 2, 255));
    }

    @androidx.annotation.ColorInt
    private static int getColorForState(@androidx.annotation.Nullable android.content.res.ColorStateList colorStateList, int[] iArr) {
        int colorForState = colorStateList != null ? colorStateList.getColorForState(iArr, colorStateList.getDefaultColor()) : 0;
        return USE_FRAMEWORK_RIPPLE ? doubleAlpha(colorForState) : colorForState;
    }

    @androidx.annotation.NonNull
    public static android.content.res.ColorStateList sanitizeRippleDrawableColor(@androidx.annotation.Nullable android.content.res.ColorStateList colorStateList) {
        if (colorStateList == null) {
            return android.content.res.ColorStateList.valueOf(0);
        }
        int i = android.os.Build.VERSION.SDK_INT;
        if (i >= 22 && i <= 27 && android.graphics.Color.alpha(colorStateList.getDefaultColor()) == 0) {
            android.graphics.Color.alpha(colorStateList.getColorForState(ENABLED_PRESSED_STATE_SET, 0));
        }
        return colorStateList;
    }

    public static boolean shouldDrawRippleCompat(@androidx.annotation.NonNull int[] iArr) {
        boolean z = false;
        boolean z2 = false;
        for (int i : iArr) {
            if (i == 16842910) {
                z = true;
            } else if (i == 16842908 || i == 16842919 || i == 16843623) {
                z2 = true;
            }
        }
        return z && z2;
    }
}
