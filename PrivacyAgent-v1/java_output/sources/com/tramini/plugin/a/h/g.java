package com.tramini.plugin.a.h;

/* loaded from: classes19.dex */
public final class g {
    public static java.lang.String a(com.tramini.plugin.b.b bVar) {
        com.tramini.plugin.a.d.c cVar;
        java.util.concurrent.ConcurrentHashMap<java.lang.String, com.tramini.plugin.a.d.c> f = bVar.f();
        if (f == null) {
            return "";
        }
        for (java.lang.String str : f.keySet()) {
            if (!android.text.TextUtils.isEmpty(str) && (cVar = f.get(str)) != null && !android.text.TextUtils.isEmpty(cVar.a) && cVar.a.startsWith(com.alipay.sdk.m.l.a.q)) {
                return str;
            }
        }
        return "";
    }

    private static void a(java.lang.String str, java.lang.String str2) {
        int length = 2001 - str.length();
        while (str2.length() > length) {
            str2.substring(0, length);
            str2 = str2.substring(length);
        }
    }
}
