package com.aliyun.svideo.common.utils;

/* loaded from: classes.dex */
public class ScreenUtils {
    public static int getDisplayHeight(android.app.Activity activity) {
        android.graphics.Rect rect = new android.graphics.Rect();
        if (activity == null) {
            return 0;
        }
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        return rect.bottom - rect.top;
    }

    public static int getHeight(android.content.Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int getNavigationHeight(android.content.Context context) {
        android.content.res.Resources resources;
        int identifier;
        if (context != null && (identifier = (resources = context.getResources()).getIdentifier("navigation_bar_height", "dimen", com.aliyun.vod.log.core.AliyunLogCommon.OPERATION_SYSTEM)) > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static int getRealHeight(android.content.Context context) {
        android.view.Display defaultDisplay = ((android.view.WindowManager) context.getSystemService("window")).getDefaultDisplay();
        android.util.DisplayMetrics displayMetrics = new android.util.DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static int getRealWidth(android.content.Context context) {
        android.view.Display defaultDisplay = ((android.view.WindowManager) context.getSystemService("window")).getDefaultDisplay();
        android.util.DisplayMetrics displayMetrics = new android.util.DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static android.graphics.Point getScreenPoint(android.content.Context context) {
        android.graphics.Point point = new android.graphics.Point();
        android.util.DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        point.x = displayMetrics.widthPixels;
        point.y = displayMetrics.heightPixels;
        return point;
    }

    public static int getStatusBarHeight(android.content.Context context) {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("com.android.internal.R$dimen");
            return context.getResources().getDimensionPixelSize(((java.lang.Integer) cls.getField("status_bar_height").get(cls.newInstance())).intValue());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int getWidth(android.content.Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static boolean isInLeft(android.content.Context context, int i) {
        return i < getWidth(context) / 2;
    }

    public static boolean isInRight(android.content.Context context, int i) {
        return i > getWidth(context) / 2;
    }
}
