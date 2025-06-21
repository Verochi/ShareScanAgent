package com.xiaomi.push;

/* loaded from: classes19.dex */
public class iz {
    private static volatile com.xiaomi.push.iz a;
    private android.content.Context b;
    private android.os.Handler c = new android.os.Handler(android.os.Looper.getMainLooper());
    private java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.String>> d = new java.util.HashMap();

    private iz(android.content.Context context) {
        this.b = context;
    }

    public static com.xiaomi.push.iz a(android.content.Context context) {
        if (a == null) {
            synchronized (com.xiaomi.push.iz.class) {
                if (a == null) {
                    a = new com.xiaomi.push.iz(context);
                }
            }
        }
        return a;
    }

    private synchronized java.lang.String a(java.lang.String str, java.lang.String str2) {
        if (this.d != null && !android.text.TextUtils.isEmpty(str)) {
            if (!android.text.TextUtils.isEmpty(str2)) {
                try {
                    java.util.Map<java.lang.String, java.lang.String> map = this.d.get(str);
                    if (map == null) {
                        return "";
                    }
                    return map.get(str2);
                } catch (java.lang.Throwable unused) {
                    return "";
                }
            }
        }
        return "";
    }

    private synchronized void c(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (this.d == null) {
            this.d = new java.util.HashMap();
        }
        java.util.Map<java.lang.String, java.lang.String> map = this.d.get(str);
        if (map == null) {
            map = new java.util.HashMap<>();
        }
        map.put(str2, str3);
        this.d.put(str, map);
    }

    public final synchronized void a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        c(str, str2, str3);
        this.c.post(new com.xiaomi.push.ja(this, str, str2, str3));
    }

    public final synchronized java.lang.String b(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        java.lang.String a2 = a(str, str2);
        if (!android.text.TextUtils.isEmpty(a2)) {
            return a2;
        }
        return this.b.getSharedPreferences(str, 4).getString(str2, str3);
    }
}
