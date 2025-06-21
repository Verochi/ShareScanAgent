package com.alipay.apmobilesecuritysdk.b;

/* loaded from: classes.dex */
public final class a {
    public static com.alipay.apmobilesecuritysdk.b.a b = new com.alipay.apmobilesecuritysdk.b.a();
    public int a = 0;

    public static com.alipay.apmobilesecuritysdk.b.a a() {
        return b;
    }

    public static java.lang.String a(java.lang.String str, java.lang.String str2) {
        return str + str2;
    }

    public final void a(int i) {
        this.a = i;
    }

    public final int b() {
        return this.a;
    }

    public final java.lang.String c() {
        java.lang.String str;
        java.lang.String a = com.alipay.sdk.m.d0.d.a();
        if (com.alipay.sdk.m.z.a.b(a)) {
            return a;
        }
        int i = this.a;
        if (i == 1) {
            str = "://mobilegw.stable.alipay.net/mgw.htm";
        } else {
            if (i == 2) {
                return "https://mobilegwpre.alipay.com/mgw.htm";
            }
            if (i == 3) {
                str = "://mobilegw-1-64.test.alipay.net/mgw.htm";
            } else {
                if (i != 4) {
                    return "https://mobilegw.alipay.com/mgw.htm";
                }
                str = "://mobilegw.aaa.alipay.net/mgw.htm";
            }
        }
        return a(com.alipay.sdk.m.l.a.q, str);
    }
}
