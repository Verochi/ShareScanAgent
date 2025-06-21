package com.jd.ad.sdk.fdt.utils;

/* loaded from: classes23.dex */
public class ScreenUtils {
    private ScreenUtils() {
    }

    public static float dip2px(android.content.Context context, float f) {
        if (context == null) {
            context = com.jd.ad.sdk.jad_fq.jad_cp.jad_an();
        }
        return context == null ? f : (f * context.getResources().getDisplayMetrics().density) + 0.5f;
    }

    public static int getDensityDpi(android.content.Context context) {
        if (context == null) {
            context = com.jd.ad.sdk.jad_fq.jad_cp.jad_an();
        }
        if (context == null) {
            return -1;
        }
        return getDisplay(context).densityDpi;
    }

    public static int getDimSize() {
        return android.content.res.Resources.getSystem().getConfiguration().screenLayout & 15;
    }

    public static int getDirection(android.content.Context context) {
        if (context == null) {
            return 0;
        }
        return context.getResources().getConfiguration().orientation;
    }

    public static android.util.DisplayMetrics getDisplay(android.content.Context context) {
        if (context == null) {
            context = com.jd.ad.sdk.jad_fq.jad_cp.jad_an();
        }
        if (context == null) {
            return null;
        }
        return context.getResources().getDisplayMetrics();
    }

    public static int getPhoneHeight(android.content.Context context) {
        if (context == null) {
            context = com.jd.ad.sdk.jad_fq.jad_cp.jad_an();
        }
        if (context == null) {
            return -1;
        }
        return getDisplay(context).heightPixels;
    }

    public static int getPhoneWidth(android.content.Context context) {
        if (context == null) {
            context = com.jd.ad.sdk.jad_fq.jad_cp.jad_an();
        }
        if (context == null) {
            return -1;
        }
        return getDisplay(context).widthPixels;
    }

    public static int getScreenDensity() {
        int i = android.content.res.Resources.getSystem().getDisplayMetrics().densityDpi;
        if (i == 0) {
            return 1;
        }
        if (i < 140) {
            return 0;
        }
        return i > 200 ? 2 : 1;
    }

    public static int getScreenDpi(@androidx.annotation.NonNull android.content.Context context) {
        android.view.WindowManager windowManager;
        try {
            windowManager = (android.view.WindowManager) context.getSystemService("window");
        } catch (java.lang.SecurityException e) {
            e.printStackTrace();
            windowManager = null;
        }
        if (windowManager == null) {
            return 1;
        }
        android.util.DisplayMetrics displayMetrics = new android.util.DisplayMetrics();
        windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.densityDpi;
    }

    public static int getScreenSize() {
        int i = android.content.res.Resources.getSystem().getConfiguration().screenLayout & 15;
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                i2 = 3;
                if (i != 3) {
                    i2 = 4;
                    if (i != 4) {
                        return 0;
                    }
                }
            }
        }
        return i2;
    }

    public static int[] getScreenSize(@androidx.annotation.NonNull android.content.Context context) {
        android.view.WindowManager windowManager;
        int[] iArr = new int[2];
        try {
            windowManager = (android.view.WindowManager) context.getSystemService("window");
        } catch (java.lang.SecurityException e) {
            e.printStackTrace();
            windowManager = null;
        }
        if (windowManager == null) {
            return iArr;
        }
        android.util.DisplayMetrics displayMetrics = new android.util.DisplayMetrics();
        windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        iArr[0] = i;
        iArr[1] = i2;
        return iArr;
    }

    public static float getShowHeight(android.content.Context context, float f, float f2) {
        if (context == null) {
            context = com.jd.ad.sdk.jad_fq.jad_cp.jad_an();
        }
        if (context == null) {
            return f2;
        }
        float dip2px = dip2px(context, f);
        float dip2px2 = dip2px(context, f2);
        float phoneWidth = getPhoneWidth(context);
        return dip2px > phoneWidth ? (dip2px2 * phoneWidth) / phoneWidth : dip2px2;
    }

    public static int getXdpi(android.content.Context context) {
        if (context == null) {
            context = com.jd.ad.sdk.jad_fq.jad_cp.jad_an();
        }
        if (context == null) {
            return -1;
        }
        return (int) getDisplay(context).xdpi;
    }

    public static int getYdpi(android.content.Context context) {
        if (context == null) {
            context = com.jd.ad.sdk.jad_fq.jad_cp.jad_an();
        }
        if (context == null) {
            return -1;
        }
        return (int) getDisplay(context).ydpi;
    }

    public static int px2dip(android.content.Context context, float f) {
        if (context == null) {
            context = com.jd.ad.sdk.jad_fq.jad_cp.jad_an();
        }
        if (context == null) {
            return -1;
        }
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
