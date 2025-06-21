package com.huawei.hms.hatool;

/* loaded from: classes22.dex */
public class d1 extends com.huawei.hms.hatool.v {

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.huawei.hms.hatool.y0.values().length];
            a = iArr;
            try {
                iArr[com.huawei.hms.hatool.y0.SN.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                a[com.huawei.hms.hatool.y0.IMEI.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                a[com.huawei.hms.hatool.y0.UDID.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
        }
    }

    public static com.huawei.hms.hatool.e1 a(java.lang.String str, java.lang.String str2) {
        com.huawei.hms.hatool.e1 a2 = com.huawei.hms.hatool.v.a(str, str2);
        com.huawei.hms.hatool.x0 c = com.huawei.hms.hatool.z0.a().c(str, str2);
        a2.g(com.huawei.hms.hatool.z0.a().a(com.huawei.hms.hatool.c.c(str, str2)));
        a2.f(com.huawei.hms.hatool.c.o(str, str2));
        a2.c(com.huawei.hms.hatool.z0.a().f(str, str2));
        int i = com.huawei.hms.hatool.d1.a.a[c.a().ordinal()];
        if (i == 1) {
            a2.d(c.b());
        } else if (i == 2) {
            a2.b(c.b());
        } else if (i == 3) {
            a2.e(c.b());
        }
        return a2;
    }

    public static com.huawei.hms.hatool.f1 a(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        com.huawei.hms.hatool.f1 a2 = com.huawei.hms.hatool.v.a(str, str2, str3, str4);
        java.lang.String a3 = com.huawei.hms.hatool.z0.a().a(com.huawei.hms.hatool.c.c(str2, str3));
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        java.lang.String sha256Encrypt = com.huawei.secure.android.common.encrypt.hash.SHA.sha256Encrypt(com.huawei.hms.hatool.b.f() + a3 + currentTimeMillis);
        a2.f(java.lang.String.valueOf(currentTimeMillis));
        a2.g(sha256Encrypt);
        return a2;
    }

    public static com.huawei.hms.hatool.g1 a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        com.huawei.hms.hatool.g1 a2 = com.huawei.hms.hatool.v.a(str, str2, str3);
        android.util.Pair<java.lang.String, java.lang.String> e = com.huawei.hms.hatool.z0.a().e(str2, str);
        a2.f((java.lang.String) e.first);
        a2.g((java.lang.String) e.second);
        a2.h(com.huawei.hms.hatool.f.b());
        a2.d(com.huawei.hms.hatool.z0.a().d(str2, str));
        return a2;
    }

    public static com.huawei.hms.hatool.C0546r a(java.util.List<com.huawei.hms.hatool.q> list, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        com.huawei.hms.hatool.y.c("hmsSdk", "generate UploadData");
        com.huawei.hms.hatool.C0546r b = com.huawei.hms.hatool.v.b(str, str2);
        if (b == null) {
            return null;
        }
        b.a(a(com.huawei.hms.hatool.x.d().a(), str, str2, str3));
        b.a(a(str, str2));
        b.a(a(str2, str, str4));
        b.a(com.huawei.hms.hatool.c.g(str, str2));
        b.a(list);
        return b;
    }

    public static java.util.Map<java.lang.String, java.lang.String> b(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        java.util.Map<java.lang.String, java.lang.String> c = com.huawei.hms.hatool.v.c(str, str3);
        java.util.Map<java.lang.String, java.lang.String> i = com.huawei.hms.hatool.c.i(str, str2);
        if (i == null) {
            return c;
        }
        c.putAll(i);
        return c;
    }
}
