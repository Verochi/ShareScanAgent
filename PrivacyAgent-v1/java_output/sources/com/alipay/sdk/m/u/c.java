package com.alipay.sdk.m.u;

/* loaded from: classes.dex */
public class c {
    public static final java.lang.String b = "00:00:00:00:00:00";
    public static com.alipay.sdk.m.u.c c;
    public java.lang.String a;

    public c(android.content.Context context) {
        try {
            try {
                java.lang.String macAddress = com.alipay.sdk.m.w.b.d(null, context).getMacAddress();
                this.a = macAddress;
                if (!android.text.TextUtils.isEmpty(macAddress)) {
                    return;
                }
            } catch (java.lang.Exception e) {
                com.alipay.sdk.m.u.e.a(e);
                if (!android.text.TextUtils.isEmpty(this.a)) {
                    return;
                }
            }
            this.a = b;
        } catch (java.lang.Throwable th) {
            if (android.text.TextUtils.isEmpty(this.a)) {
                this.a = b;
            }
            throw th;
        }
    }

    public static java.lang.String a(android.content.Context context) {
        return b(context).a().substring(0, 8);
    }

    public static com.alipay.sdk.m.u.c b(android.content.Context context) {
        if (c == null) {
            c = new com.alipay.sdk.m.u.c(context);
        }
        return c;
    }

    public static java.lang.String c(android.content.Context context) {
        if (context == null) {
            return "";
        }
        try {
            return context.getResources().getConfiguration().locale.toString();
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }

    public static com.alipay.sdk.m.u.g d(android.content.Context context) {
        try {
            android.net.NetworkInfo a = com.alipay.sdk.m.w.b.a(null, context);
            return (a == null || a.getType() != 0) ? (a == null || a.getType() != 1) ? com.alipay.sdk.m.u.g.NONE : com.alipay.sdk.m.u.g.WIFI : com.alipay.sdk.m.u.g.a(a.getSubtype());
        } catch (java.lang.Exception unused) {
            return com.alipay.sdk.m.u.g.NONE;
        }
    }

    public java.lang.String a() {
        java.lang.String str = b() + "|";
        java.lang.String c2 = c();
        if (android.text.TextUtils.isEmpty(c2)) {
            return str + "000000000000000";
        }
        return str + c2;
    }

    public java.lang.String b() {
        return "000000000000000";
    }

    public java.lang.String c() {
        return "000000000000000";
    }

    public java.lang.String d() {
        return this.a;
    }
}
