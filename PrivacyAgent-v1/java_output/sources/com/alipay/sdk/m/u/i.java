package com.alipay.sdk.m.u;

/* loaded from: classes.dex */
public class i {
    public static final java.lang.String a = "pref_trade_token";
    public static final java.lang.String b = ";";
    public static final java.lang.String c = "result={";
    public static final java.lang.String d = "}";
    public static final java.lang.String e = "trade_token=\"";
    public static final java.lang.String f = "\"";
    public static final java.lang.String g = "trade_token=";

    public static java.lang.String a(com.alipay.sdk.m.s.a aVar, android.content.Context context) {
        java.lang.String a2 = com.alipay.sdk.m.u.j.a(aVar, context, a, "");
        com.alipay.sdk.m.u.e.b(com.alipay.sdk.m.l.a.z, "get trade token: " + a2);
        return a2;
    }

    public static java.lang.String a(java.lang.String str) {
        java.lang.String str2 = null;
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        java.lang.String[] split = str.split(b);
        for (int i = 0; i < split.length; i++) {
            if (split[i].startsWith(c) && split[i].endsWith(d)) {
                java.lang.String[] split2 = split[i].substring(8, r3.length() - 1).split("&");
                int i2 = 0;
                while (true) {
                    if (i2 >= split2.length) {
                        break;
                    }
                    if (split2[i2].startsWith(e) && split2[i2].endsWith("\"")) {
                        str2 = split2[i2].substring(13, r1.length() - 1);
                        break;
                    }
                    if (split2[i2].startsWith(g)) {
                        str2 = split2[i2].substring(12);
                        break;
                    }
                    i2++;
                }
            }
        }
        return str2;
    }

    public static void a(com.alipay.sdk.m.s.a aVar, android.content.Context context, java.lang.String str) {
        try {
            java.lang.String a2 = a(str);
            com.alipay.sdk.m.u.e.b(com.alipay.sdk.m.l.a.z, "trade token: " + a2);
            if (android.text.TextUtils.isEmpty(a2)) {
                return;
            }
            com.alipay.sdk.m.u.j.b(aVar, context, a, a2);
        } catch (java.lang.Throwable th) {
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.I, th);
            com.alipay.sdk.m.u.e.a(th);
        }
    }
}
