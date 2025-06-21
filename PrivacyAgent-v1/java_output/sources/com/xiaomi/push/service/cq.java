package com.xiaomi.push.service;

/* loaded from: classes19.dex */
public final class cq {
    private static com.xiaomi.push.service.cq e;
    android.content.Context a;
    java.util.List<java.lang.String> b = new java.util.ArrayList();
    final java.util.List<java.lang.String> c = new java.util.ArrayList();
    final java.util.List<java.lang.String> d = new java.util.ArrayList();

    private cq(android.content.Context context) {
        android.content.Context applicationContext = context.getApplicationContext();
        this.a = applicationContext;
        if (applicationContext == null) {
            this.a = context;
        }
        android.content.SharedPreferences sharedPreferences = this.a.getSharedPreferences("mipush_app_info", 0);
        for (java.lang.String str : sharedPreferences.getString("unregistered_pkg_names", "").split(",")) {
            if (android.text.TextUtils.isEmpty(str)) {
                this.b.add(str);
            }
        }
        for (java.lang.String str2 : sharedPreferences.getString("disable_push_pkg_names", "").split(",")) {
            if (!android.text.TextUtils.isEmpty(str2)) {
                this.c.add(str2);
            }
        }
        for (java.lang.String str3 : sharedPreferences.getString("disable_push_pkg_names_cache", "").split(",")) {
            if (!android.text.TextUtils.isEmpty(str3)) {
                this.d.add(str3);
            }
        }
    }

    public static com.xiaomi.push.service.cq a(android.content.Context context) {
        if (e == null) {
            e = new com.xiaomi.push.service.cq(context);
        }
        return e;
    }

    public final boolean a(java.lang.String str) {
        boolean contains;
        synchronized (this.b) {
            contains = this.b.contains(str);
        }
        return contains;
    }

    public final boolean b(java.lang.String str) {
        boolean contains;
        synchronized (this.c) {
            contains = this.c.contains(str);
        }
        return contains;
    }

    public final boolean c(java.lang.String str) {
        boolean contains;
        synchronized (this.d) {
            contains = this.d.contains(str);
        }
        return contains;
    }

    public final void d(java.lang.String str) {
        synchronized (this.c) {
            if (this.c.contains(str)) {
                this.c.remove(str);
                this.a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names", com.xiaomi.push.ao.a(this.c, ",")).commit();
            }
        }
    }

    public final void e(java.lang.String str) {
        synchronized (this.d) {
            if (this.d.contains(str)) {
                this.d.remove(str);
                this.a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names_cache", com.xiaomi.push.ao.a(this.d, ",")).commit();
            }
        }
    }
}
