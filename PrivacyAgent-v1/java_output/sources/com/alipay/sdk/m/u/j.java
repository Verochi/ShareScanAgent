package com.alipay.sdk.m.u;

/* loaded from: classes.dex */
public class j {
    public static java.lang.String a;

    public static java.lang.String a(android.content.Context context) {
        java.lang.String str;
        if (android.text.TextUtils.isEmpty(a)) {
            try {
                str = context.getApplicationContext().getPackageName();
            } catch (java.lang.Throwable th) {
                com.alipay.sdk.m.u.e.a(th);
                str = "";
            }
            a = (str + "0000000000000000000000000000").substring(0, 24);
        }
        return a;
    }

    public static synchronized java.lang.String a(com.alipay.sdk.m.s.a aVar, android.content.Context context, java.lang.String str, java.lang.String str2) {
        java.lang.String str3;
        synchronized (com.alipay.sdk.m.u.j.class) {
            try {
                java.lang.String string = android.preference.PreferenceManager.getDefaultSharedPreferences(context).getString(str, str2);
                str3 = android.text.TextUtils.isEmpty(string) ? null : com.alipay.sdk.m.n.e.a(a(context), string, str);
                if (!android.text.TextUtils.isEmpty(string) && android.text.TextUtils.isEmpty(str3)) {
                    com.alipay.sdk.m.k.a.b(aVar, com.alipay.sdk.m.k.b.m, com.alipay.sdk.m.k.b.F, java.lang.String.format("%s,%s", str, string));
                }
            } catch (java.lang.Exception e) {
                com.alipay.sdk.m.u.e.a(e);
            }
        }
        return str3;
    }

    public static synchronized boolean a(android.content.Context context, java.lang.String str) {
        boolean z;
        synchronized (com.alipay.sdk.m.u.j.class) {
            try {
                z = android.preference.PreferenceManager.getDefaultSharedPreferences(context).contains(str);
            } catch (java.lang.Throwable th) {
                com.alipay.sdk.m.u.e.a(th);
                z = false;
            }
        }
        return z;
    }

    public static synchronized void b(android.content.Context context, java.lang.String str) {
        synchronized (com.alipay.sdk.m.u.j.class) {
            try {
                android.preference.PreferenceManager.getDefaultSharedPreferences(context).edit().remove(str).apply();
            } catch (java.lang.Throwable th) {
                com.alipay.sdk.m.u.e.a(th);
            }
        }
    }

    public static synchronized void b(com.alipay.sdk.m.s.a aVar, android.content.Context context, java.lang.String str, java.lang.String str2) {
        synchronized (com.alipay.sdk.m.u.j.class) {
            try {
                java.lang.String b = com.alipay.sdk.m.n.e.b(a(context), str2, str);
                if (!android.text.TextUtils.isEmpty(str2) && android.text.TextUtils.isEmpty(b)) {
                    com.alipay.sdk.m.k.a.b(aVar, com.alipay.sdk.m.k.b.m, com.alipay.sdk.m.k.b.G, java.lang.String.format("%s,%s", str, str2));
                }
                android.preference.PreferenceManager.getDefaultSharedPreferences(context).edit().putString(str, b).apply();
            } catch (java.lang.Throwable th) {
                com.alipay.sdk.m.u.e.a(th);
            }
        }
    }
}
