package com.huawei.hms.hatool;

/* loaded from: classes22.dex */
public abstract class a1 {
    public final com.huawei.hms.hatool.x0 a(int i) {
        java.lang.String str;
        if (i != 0) {
            str = f();
            if (!android.text.TextUtils.isEmpty(str)) {
                return new com.huawei.hms.hatool.x0(com.huawei.hms.hatool.y0.UDID, str);
            }
        } else {
            str = "";
        }
        return new com.huawei.hms.hatool.x0(com.huawei.hms.hatool.y0.EMPTY, str);
    }

    public com.huawei.hms.hatool.x0 a(android.content.Context context) {
        java.lang.String c = c();
        if (!android.text.TextUtils.isEmpty(c)) {
            return new com.huawei.hms.hatool.x0(com.huawei.hms.hatool.y0.UDID, c);
        }
        java.lang.String a = a();
        if (!android.text.TextUtils.isEmpty(a)) {
            return new com.huawei.hms.hatool.x0(com.huawei.hms.hatool.y0.IMEI, a);
        }
        boolean e = e();
        java.lang.String b = b();
        return !android.text.TextUtils.isEmpty(b) ? e ? new com.huawei.hms.hatool.x0(com.huawei.hms.hatool.y0.SN, b) : new com.huawei.hms.hatool.x0(com.huawei.hms.hatool.y0.UDID, a(b)) : e ? a(d()) : b(d());
    }

    public abstract java.lang.String a();

    public abstract java.lang.String a(java.lang.String str);

    public final com.huawei.hms.hatool.x0 b(int i) {
        java.lang.String str;
        if ((i & 4) != 0) {
            str = f();
            if (!android.text.TextUtils.isEmpty(str)) {
                return new com.huawei.hms.hatool.x0(com.huawei.hms.hatool.y0.UDID, str);
            }
        } else {
            str = "";
        }
        return new com.huawei.hms.hatool.x0(com.huawei.hms.hatool.y0.EMPTY, str);
    }

    public abstract java.lang.String b();

    public abstract java.lang.String c();

    public abstract int d();

    public final boolean e() {
        com.huawei.hms.hatool.l b = com.huawei.hms.hatool.i.c().b();
        if (android.text.TextUtils.isEmpty(b.l())) {
            b.h(com.huawei.hms.hatool.f.a());
        }
        return !android.text.TextUtils.isEmpty(b.l());
    }

    public final java.lang.String f() {
        com.huawei.hms.hatool.l b = com.huawei.hms.hatool.i.c().b();
        if (android.text.TextUtils.isEmpty(b.i())) {
            b.e(com.huawei.hms.hatool.b1.c());
        }
        return b.i();
    }
}
