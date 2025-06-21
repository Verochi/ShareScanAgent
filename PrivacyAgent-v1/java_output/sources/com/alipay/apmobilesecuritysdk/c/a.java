package com.alipay.apmobilesecuritysdk.c;

/* loaded from: classes.dex */
public final class a {
    public static synchronized void a(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        synchronized (com.alipay.apmobilesecuritysdk.c.a.class) {
            com.alipay.sdk.m.c0.a b = b(context, str, str2, str3);
            com.alipay.sdk.m.c0.d.a(context.getFilesDir().getAbsolutePath() + "/log/ap", new java.text.SimpleDateFormat("yyyyMMdd").format(java.util.Calendar.getInstance().getTime()) + com.anythink.china.common.a.a.f, b.toString());
        }
    }

    public static synchronized void a(java.lang.String str) {
        synchronized (com.alipay.apmobilesecuritysdk.c.a.class) {
            com.alipay.sdk.m.c0.d.a(str);
        }
    }

    public static synchronized void a(java.lang.Throwable th) {
        synchronized (com.alipay.apmobilesecuritysdk.c.a.class) {
            com.alipay.sdk.m.c0.d.a(th);
        }
    }

    public static com.alipay.sdk.m.c0.a b(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        java.lang.String str4;
        try {
            str4 = context.getPackageName();
        } catch (java.lang.Throwable unused) {
            str4 = "";
        }
        return new com.alipay.sdk.m.c0.a(android.os.Build.MODEL, str4, "APPSecuritySDK-ALIPAYSDK", "3.4.0.202206130311", str, str2, str3);
    }
}
