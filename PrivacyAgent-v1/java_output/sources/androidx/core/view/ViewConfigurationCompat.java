package androidx.core.view;

/* loaded from: classes.dex */
public final class ViewConfigurationCompat {
    private static final java.lang.String TAG = "ViewConfigCompat";
    private static java.lang.reflect.Method sGetScaledScrollFactorMethod;

    static {
        if (android.os.Build.VERSION.SDK_INT == 25) {
            try {
                sGetScaledScrollFactorMethod = android.view.ViewConfiguration.class.getDeclaredMethod("getScaledScrollFactor", new java.lang.Class[0]);
            } catch (java.lang.Exception unused) {
            }
        }
    }

    private ViewConfigurationCompat() {
    }

    private static float getLegacyScrollFactor(android.view.ViewConfiguration viewConfiguration, android.content.Context context) {
        java.lang.reflect.Method method;
        if (android.os.Build.VERSION.SDK_INT >= 25 && (method = sGetScaledScrollFactorMethod) != null) {
            try {
                return ((java.lang.Integer) method.invoke(viewConfiguration, new java.lang.Object[0])).intValue();
            } catch (java.lang.Exception unused) {
            }
        }
        android.util.TypedValue typedValue = new android.util.TypedValue();
        if (context.getTheme().resolveAttribute(android.R.attr.listPreferredItemHeight, typedValue, true)) {
            return typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return 0.0f;
    }

    public static float getScaledHorizontalScrollFactor(@androidx.annotation.NonNull android.view.ViewConfiguration viewConfiguration, @androidx.annotation.NonNull android.content.Context context) {
        float scaledHorizontalScrollFactor;
        if (android.os.Build.VERSION.SDK_INT < 26) {
            return getLegacyScrollFactor(viewConfiguration, context);
        }
        scaledHorizontalScrollFactor = viewConfiguration.getScaledHorizontalScrollFactor();
        return scaledHorizontalScrollFactor;
    }

    public static int getScaledHoverSlop(android.view.ViewConfiguration viewConfiguration) {
        int scaledHoverSlop;
        if (android.os.Build.VERSION.SDK_INT < 28) {
            return viewConfiguration.getScaledTouchSlop() / 2;
        }
        scaledHoverSlop = viewConfiguration.getScaledHoverSlop();
        return scaledHoverSlop;
    }

    @java.lang.Deprecated
    public static int getScaledPagingTouchSlop(android.view.ViewConfiguration viewConfiguration) {
        return viewConfiguration.getScaledPagingTouchSlop();
    }

    public static float getScaledVerticalScrollFactor(@androidx.annotation.NonNull android.view.ViewConfiguration viewConfiguration, @androidx.annotation.NonNull android.content.Context context) {
        float scaledVerticalScrollFactor;
        if (android.os.Build.VERSION.SDK_INT < 26) {
            return getLegacyScrollFactor(viewConfiguration, context);
        }
        scaledVerticalScrollFactor = viewConfiguration.getScaledVerticalScrollFactor();
        return scaledVerticalScrollFactor;
    }

    @java.lang.Deprecated
    public static boolean hasPermanentMenuKey(android.view.ViewConfiguration viewConfiguration) {
        return viewConfiguration.hasPermanentMenuKey();
    }

    public static boolean shouldShowMenuShortcutsWhenKeyboardPresent(android.view.ViewConfiguration viewConfiguration, @androidx.annotation.NonNull android.content.Context context) {
        boolean shouldShowMenuShortcutsWhenKeyboardPresent;
        if (android.os.Build.VERSION.SDK_INT >= 28) {
            shouldShowMenuShortcutsWhenKeyboardPresent = viewConfiguration.shouldShowMenuShortcutsWhenKeyboardPresent();
            return shouldShowMenuShortcutsWhenKeyboardPresent;
        }
        android.content.res.Resources resources = context.getResources();
        int identifier = resources.getIdentifier("config_showMenuShortcutsWhenKeyboardPresent", "bool", com.aliyun.vod.log.core.AliyunLogCommon.OPERATION_SYSTEM);
        return identifier != 0 && resources.getBoolean(identifier);
    }
}
