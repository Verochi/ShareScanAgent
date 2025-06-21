package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
public class ba {
    private static android.util.DisplayMetrics a;
    private static float b;

    public static int a(android.content.Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int a(android.content.Context context, int i) {
        try {
            return (int) (i / e(context));
        } catch (java.lang.Exception unused) {
            return i;
        }
    }

    public static android.graphics.Rect a(android.content.Context context) {
        android.util.DisplayMetrics f = f(context);
        try {
            return f.widthPixels > f.heightPixels ? new android.graphics.Rect(0, 0, f.heightPixels, f.widthPixels) : new android.graphics.Rect(0, 0, f.widthPixels, f.heightPixels);
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public static int b(android.content.Context context) {
        return a(context).width();
    }

    public static int b(android.content.Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int b(android.content.Context context, int i) {
        try {
            return (int) (i * e(context));
        } catch (java.lang.Exception unused) {
            return i;
        }
    }

    public static int c(android.content.Context context) {
        return a(context).height();
    }

    public static android.graphics.Rect d(android.content.Context context) {
        android.util.DisplayMetrics f = f(context);
        return new android.graphics.Rect(0, 0, f.widthPixels, f.heightPixels);
    }

    public static float e(android.content.Context context) {
        if (b < 0.01d) {
            b = f(context).density;
        }
        return b;
    }

    public static android.util.DisplayMetrics f(android.content.Context context) {
        try {
            android.util.DisplayMetrics displayMetrics = a;
            if (displayMetrics != null && displayMetrics.widthPixels > 0) {
                return displayMetrics;
            }
            android.util.DisplayMetrics displayMetrics2 = new android.util.DisplayMetrics();
            if (com.baidu.mobads.sdk.internal.bm.a(context).a() >= 17) {
                ((android.view.WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics2);
            } else {
                ((android.view.WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics2);
            }
            a = displayMetrics2;
        } catch (java.lang.Throwable th) {
            a = new android.util.DisplayMetrics();
            com.baidu.mobads.sdk.internal.bt.a().a(th);
        }
        return a;
    }

    public static int g(android.content.Context context) {
        android.content.res.Resources resources = context.getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", "dimen", com.aliyun.vod.log.core.AliyunLogCommon.OPERATION_SYSTEM));
    }
}
