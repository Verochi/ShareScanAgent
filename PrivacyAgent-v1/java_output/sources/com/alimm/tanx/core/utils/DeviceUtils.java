package com.alimm.tanx.core.utils;

/* loaded from: classes.dex */
public class DeviceUtils implements com.alimm.tanx.core.utils.NotConfused {
    private static final java.lang.String TAG = "DeviceUtils";

    public static android.graphics.Point getAppWindowSize(@androidx.annotation.NonNull android.content.Context context) {
        android.graphics.Point point = new android.graphics.Point();
        new android.util.DisplayMetrics();
        try {
            ((android.view.WindowManager) context.getSystemService("window")).getDefaultDisplay().getSize(point);
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.d(TAG, "getAppWindowSize size failed.", e);
        }
        com.alimm.tanx.core.utils.LogUtils.d(TAG, "getAppWindowSize: appWindowSize = " + point);
        return point;
    }

    public static int getNavigationBarHeight(@androidx.annotation.NonNull android.content.Context context) {
        android.content.res.Resources resources = context.getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", "dimen", com.aliyun.vod.log.core.AliyunLogCommon.OPERATION_SYSTEM));
    }

    public static int getRealHeight(android.content.Context context) {
        android.view.Display defaultDisplay = ((android.view.WindowManager) context.getSystemService("window")).getDefaultDisplay();
        android.util.DisplayMetrics displayMetrics = new android.util.DisplayMetrics();
        try {
            java.lang.Class.forName("android.view.Display").getMethod("getRealMetrics", android.util.DisplayMetrics.class).invoke(defaultDisplay, displayMetrics);
            return displayMetrics.heightPixels;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int getRealWidth(android.content.Context context) {
        android.view.Display defaultDisplay = ((android.view.WindowManager) context.getSystemService("window")).getDefaultDisplay();
        android.util.DisplayMetrics displayMetrics = new android.util.DisplayMetrics();
        try {
            java.lang.Class.forName("android.view.Display").getMethod("getRealMetrics", android.util.DisplayMetrics.class).invoke(defaultDisplay, displayMetrics);
            return displayMetrics.widthPixels;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int getStatusBarHeight(@androidx.annotation.NonNull android.content.Context context) {
        if (context == null) {
            return 50;
        }
        android.content.res.Resources resources = context.getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", "dimen", com.aliyun.vod.log.core.AliyunLogCommon.OPERATION_SYSTEM));
    }

    public static boolean isHuaweiDevice() {
        java.lang.String lowerCase = android.os.Build.BRAND.toLowerCase();
        return !android.text.TextUtils.isEmpty(lowerCase) && (lowerCase.contains(com.igexin.assist.util.AssistUtils.BRAND_HW) || lowerCase.contains(com.igexin.assist.util.AssistUtils.BRAND_HON));
    }

    public static boolean isNavigationBarShow(@androidx.annotation.NonNull android.content.Context context) {
        if (isXiaomiDevice()) {
            return android.provider.Settings.Global.getInt(context.getContentResolver(), "force_fsg_nav_bar", 0) == 0;
        }
        if (isHuaweiDevice()) {
            return android.provider.Settings.Global.getInt(context.getContentResolver(), "navigationbar_is_min", 0) == 0;
        }
        if (isVivoDevice()) {
            return android.provider.Settings.Secure.getInt(context.getContentResolver(), "navigation_gesture_on", 0) == 0;
        }
        android.view.Display defaultDisplay = ((android.view.WindowManager) context.getSystemService("window")).getDefaultDisplay();
        android.graphics.Point point = new android.graphics.Point();
        android.graphics.Point point2 = new android.graphics.Point();
        defaultDisplay.getSize(point);
        defaultDisplay.getRealSize(point2);
        com.alimm.tanx.core.utils.LogUtils.d(TAG, "isNavigationBarShow: sY = " + point.y + ", rY = " + point2.y);
        int i = point2.y;
        int i2 = point.y;
        return i != i2 && java.lang.Math.abs(i - i2) >= getNavigationBarHeight(context);
    }

    public static boolean isOppoDevice() {
        java.lang.String lowerCase = android.os.Build.BRAND.toLowerCase();
        return !android.text.TextUtils.isEmpty(lowerCase) && lowerCase.contains(com.igexin.assist.util.AssistUtils.BRAND_OPPO);
    }

    public static boolean isSamsungDevice() {
        java.lang.String lowerCase = android.os.Build.BRAND.toLowerCase();
        return !android.text.TextUtils.isEmpty(lowerCase) && lowerCase.contains("samsung");
    }

    public static boolean isVivoDevice() {
        java.lang.String lowerCase = android.os.Build.BRAND.toLowerCase();
        return !android.text.TextUtils.isEmpty(lowerCase) && lowerCase.contains(com.igexin.assist.util.AssistUtils.BRAND_VIVO);
    }

    public static boolean isXiaomiDevice() {
        java.lang.String lowerCase = android.os.Build.BRAND.toLowerCase();
        return !android.text.TextUtils.isEmpty(lowerCase) && lowerCase.contains(com.igexin.assist.util.AssistUtils.BRAND_XIAOMI);
    }
}
