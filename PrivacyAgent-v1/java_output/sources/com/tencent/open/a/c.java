package com.tencent.open.a;

/* loaded from: classes19.dex */
public class c {
    private static java.lang.String a;
    private static java.lang.String b;

    public static java.lang.String a() {
        return "";
    }

    public static java.lang.String a(android.content.Context context) {
        if (!android.text.TextUtils.isEmpty(a)) {
            return a;
        }
        if (context == null) {
            return "";
        }
        a = "";
        android.view.WindowManager windowManager = (android.view.WindowManager) context.getSystemService("window");
        if (windowManager != null) {
            a = windowManager.getDefaultDisplay().getWidth() + "x" + windowManager.getDefaultDisplay().getHeight();
        }
        return a;
    }

    public static java.lang.String b() {
        return java.util.Locale.getDefault().getLanguage();
    }

    public static java.lang.String b(android.content.Context context) {
        return "";
    }

    public static java.lang.String c(android.content.Context context) {
        return "";
    }

    public static java.lang.String d(android.content.Context context) {
        return "";
    }

    public static java.lang.String e(android.content.Context context) {
        try {
            if (b == null) {
                android.view.WindowManager windowManager = (android.view.WindowManager) context.getSystemService("window");
                android.util.DisplayMetrics displayMetrics = new android.util.DisplayMetrics();
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("imei=");
                sb.append(b(context));
                sb.append(kotlin.text.Typography.amp);
                sb.append("model=");
                sb.append(android.os.Build.MODEL);
                sb.append(kotlin.text.Typography.amp);
                sb.append("os=");
                sb.append(android.os.Build.VERSION.RELEASE);
                sb.append(kotlin.text.Typography.amp);
                sb.append("apilevel=");
                sb.append(android.os.Build.VERSION.SDK_INT);
                sb.append(kotlin.text.Typography.amp);
                java.lang.String b2 = com.tencent.open.a.a.b(context);
                if (b2 == null) {
                    b2 = "";
                }
                sb.append("network=");
                sb.append(b2);
                sb.append(kotlin.text.Typography.amp);
                sb.append("sdcard=");
                sb.append(android.os.Environment.getExternalStorageState().equals("mounted") ? 1 : 0);
                sb.append(kotlin.text.Typography.amp);
                sb.append("display=");
                sb.append(displayMetrics.widthPixels);
                sb.append('*');
                sb.append(displayMetrics.heightPixels);
                sb.append(kotlin.text.Typography.amp);
                sb.append("manu=");
                sb.append(android.os.Build.MANUFACTURER);
                sb.append("&");
                sb.append("wifi=");
                sb.append(com.tencent.open.a.a.e(context));
                b = sb.toString();
            }
            return b;
        } catch (java.lang.Exception unused) {
            return null;
        }
    }
}
