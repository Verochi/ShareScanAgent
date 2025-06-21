package com.alipay.sdk.m.s;

/* loaded from: classes.dex */
public class b {
    public static com.alipay.sdk.m.s.b b;
    public android.content.Context a;

    public static com.alipay.sdk.m.s.b d() {
        if (b == null) {
            b = new com.alipay.sdk.m.s.b();
        }
        return b;
    }

    public static boolean e() {
        java.lang.String[] strArr = {"/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su", "/su/bin/su"};
        for (int i = 0; i < 10; i++) {
            if (new java.io.File(strArr[i]).exists()) {
                return true;
            }
        }
        return false;
    }

    public com.alipay.sdk.m.m.b a() {
        return com.alipay.sdk.m.m.b.b();
    }

    public void a(android.content.Context context) {
        com.alipay.sdk.m.m.b.b();
        this.a = context.getApplicationContext();
    }

    public android.content.Context b() {
        return this.a;
    }

    public java.lang.String c() {
        return com.alipay.sdk.m.w.b.c(null, this.a);
    }
}
