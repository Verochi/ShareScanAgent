package com.alipay.sdk.m.a0;

/* loaded from: classes.dex */
public final class a {
    public static com.alipay.sdk.m.a0.a a = new com.alipay.sdk.m.a0.a();

    public static com.alipay.sdk.m.a0.a a() {
        return a;
    }

    public static java.lang.String a(android.content.Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16).versionName;
        } catch (java.lang.Exception unused) {
            return "0.0.0";
        }
    }
}
