package com.sensorsdata.sf.ui.utils;

/* loaded from: classes19.dex */
public class SizeUtil {
    private static final int BASE_SIZE = 375;
    private static int[] screen_size = new int[2];

    public static int dip2px(android.content.Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private static void getDisplayMetrics(android.content.Context context) {
        android.view.WindowManager windowManager = (android.view.WindowManager) context.getSystemService("window");
        android.util.DisplayMetrics displayMetrics = new android.util.DisplayMetrics();
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        }
        int[] iArr = screen_size;
        iArr[0] = displayMetrics.widthPixels;
        iArr[1] = displayMetrics.heightPixels;
    }

    public static int getScreenHeight(android.content.Context context) {
        if (screen_size[1] == 0) {
            getDisplayMetrics(context);
        }
        return screen_size[1];
    }

    public static int getScreenWidth(android.content.Context context) {
        if (screen_size[0] == 0) {
            getDisplayMetrics(context);
        }
        return screen_size[0];
    }

    public static int px2dip(android.content.Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int realSize(android.content.Context context, java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return (int) ((java.lang.Double.parseDouble(str.replace("px", "")) * getScreenWidth(context)) / 375.0d);
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
            return 0;
        }
    }
}
