package com.alipay.sdk.m.l0;

/* loaded from: classes.dex */
public class d {
    public static java.lang.String a() {
        int currentTimeMillis = (int) (java.lang.System.currentTimeMillis() / 1000);
        int nanoTime = (int) java.lang.System.nanoTime();
        int nextInt = new java.util.Random().nextInt();
        int nextInt2 = new java.util.Random().nextInt();
        byte[] a = com.alipay.sdk.m.l0.c.a(currentTimeMillis);
        byte[] a2 = com.alipay.sdk.m.l0.c.a(nanoTime);
        byte[] a3 = com.alipay.sdk.m.l0.c.a(nextInt);
        byte[] a4 = com.alipay.sdk.m.l0.c.a(nextInt2);
        byte[] bArr = new byte[16];
        java.lang.System.arraycopy(a, 0, bArr, 0, 4);
        java.lang.System.arraycopy(a2, 0, bArr, 4, 4);
        java.lang.System.arraycopy(a3, 0, bArr, 8, 4);
        java.lang.System.arraycopy(a4, 0, bArr, 12, 4);
        return com.alipay.sdk.m.l0.b.c(bArr, 2);
    }

    public static java.lang.String a(android.content.Context context) {
        java.lang.String b = com.alipay.sdk.m.l0.f.m12a((java.lang.String) null) ? b() : null;
        return com.alipay.sdk.m.l0.f.m12a(b) ? a() : b;
    }

    public static java.lang.String b() {
        java.lang.String a = com.alipay.sdk.m.l0.g.a("ro.aliyun.clouduuid", "");
        if (android.text.TextUtils.isEmpty(a)) {
            a = com.alipay.sdk.m.l0.g.a("ro.sys.aliyun.clouduuid", "");
        }
        return android.text.TextUtils.isEmpty(a) ? c() : a;
    }

    public static java.lang.String b(android.content.Context context) {
        return "";
    }

    public static java.lang.String c() {
        try {
            return (java.lang.String) java.lang.Class.forName("com.yunos.baseservice.clouduuid.CloudUUID").getMethod("getCloudUUID", new java.lang.Class[0]).invoke(null, new java.lang.Object[0]);
        } catch (java.lang.Exception unused) {
            return "";
        }
    }
}
