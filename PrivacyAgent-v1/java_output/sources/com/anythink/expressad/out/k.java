package com.anythink.expressad.out;

/* loaded from: classes12.dex */
public class k implements com.anythink.expressad.e.b {
    public static final int a = 6;
    public static final int b = 7;
    public static final int c = 8;
    private static java.lang.String d = "CustomInfoManager";
    private static volatile com.anythink.expressad.out.k e;
    private java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String> f = new java.util.concurrent.ConcurrentHashMap<>();

    private k() {
    }

    public static com.anythink.expressad.out.k a() {
        if (e == null) {
            synchronized (com.anythink.expressad.out.k.class) {
                if (e == null) {
                    e = new com.anythink.expressad.out.k();
                }
            }
        }
        return e;
    }

    private java.lang.String a(java.lang.String str, int i) {
        if (android.text.TextUtils.isEmpty(str)) {
            return "";
        }
        if (i == 6) {
            return this.f.get(str + "_bid");
        }
        if (i != 7) {
            return i != 8 ? "" : this.f.get(str);
        }
        return this.f.get(str + "_bidload");
    }

    private void a(java.lang.String str, int i, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str) || str2 == null) {
            return;
        }
        java.lang.String a2 = com.anythink.expressad.foundation.h.j.a(str2);
        if (i == 6) {
            this.f.put(str + "_bid", a2);
            return;
        }
        if (i != 7) {
            if (i != 8) {
                return;
            }
            this.f.put(str, a2);
        } else {
            this.f.put(str + "_bidload", a2);
        }
    }

    public final java.lang.String a(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            android.net.Uri parse = android.net.Uri.parse(str2);
            if (parse != null) {
                java.lang.String host = parse.getHost();
                java.lang.String path = parse.getPath();
                if (!android.text.TextUtils.isEmpty(host) && host.contains("hb") && !android.text.TextUtils.isEmpty(path) && path.contains("bid")) {
                    return a(str, 6);
                }
                if (!android.text.TextUtils.isEmpty(host) && host.contains("hb") && !android.text.TextUtils.isEmpty(path) && path.contains("load")) {
                    return a(str, 7);
                }
                if (!android.text.TextUtils.isEmpty(path) && path.contains(com.anythink.expressad.foundation.g.a.j)) {
                    return a(str, 8);
                }
            }
        } catch (java.lang.Throwable unused) {
        }
        return "";
    }
}
