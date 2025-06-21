package com.huawei.hms.framework.network.grs.e;

/* loaded from: classes22.dex */
public class c {
    private static final java.lang.String b = "c";
    private static final java.util.Map<java.lang.String, com.huawei.hms.framework.common.PLSharedPreferences> c = new java.util.concurrent.ConcurrentHashMap(16);
    private final com.huawei.hms.framework.common.PLSharedPreferences a;

    public c(android.content.Context context, java.lang.String str) {
        java.lang.String packageName = context.getPackageName();
        com.huawei.hms.framework.common.Logger.d(b, "get pkgname from context is{%s}", packageName);
        java.util.Map<java.lang.String, com.huawei.hms.framework.common.PLSharedPreferences> map = c;
        if (map.containsKey(str + packageName)) {
            this.a = map.get(str + packageName);
        } else {
            com.huawei.hms.framework.common.PLSharedPreferences pLSharedPreferences = new com.huawei.hms.framework.common.PLSharedPreferences(context, str + packageName);
            this.a = pLSharedPreferences;
            map.put(str + packageName, pLSharedPreferences);
        }
        a(context);
    }

    private void a(android.content.Context context) {
        java.lang.String str = b;
        com.huawei.hms.framework.common.Logger.i(str, "ContextHolder.getAppContext() from GRS is:" + com.huawei.hms.framework.common.ContextHolder.getAppContext());
        if (com.huawei.hms.framework.common.ContextHolder.getAppContext() != null) {
            context = com.huawei.hms.framework.common.ContextHolder.getAppContext();
        }
        try {
            java.lang.String l = java.lang.Long.toString(context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).versionCode);
            java.lang.String a = a("version", "");
            if (l.equals(a)) {
                return;
            }
            com.huawei.hms.framework.common.Logger.i(str, "app version changed! old version{%s} and new version{%s}", a, l);
            b();
            b("version", l);
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            com.huawei.hms.framework.common.Logger.w(b, "get app version failed and catch NameNotFoundException");
        }
    }

    public java.lang.String a(java.lang.String str, java.lang.String str2) {
        java.lang.String string;
        com.huawei.hms.framework.common.PLSharedPreferences pLSharedPreferences = this.a;
        if (pLSharedPreferences == null) {
            return str2;
        }
        synchronized (pLSharedPreferences) {
            string = this.a.getString(str, str2);
        }
        return string;
    }

    public java.util.Map<java.lang.String, ?> a() {
        java.util.Map<java.lang.String, ?> all;
        com.huawei.hms.framework.common.PLSharedPreferences pLSharedPreferences = this.a;
        if (pLSharedPreferences == null) {
            return new java.util.HashMap();
        }
        synchronized (pLSharedPreferences) {
            all = this.a.getAll();
        }
        return all;
    }

    public void a(java.lang.String str) {
        com.huawei.hms.framework.common.PLSharedPreferences pLSharedPreferences = this.a;
        if (pLSharedPreferences == null) {
            return;
        }
        synchronized (pLSharedPreferences) {
            this.a.remove(str);
        }
    }

    public void b() {
        com.huawei.hms.framework.common.PLSharedPreferences pLSharedPreferences = this.a;
        if (pLSharedPreferences == null) {
            return;
        }
        synchronized (pLSharedPreferences) {
            this.a.clear();
        }
    }

    public void b(java.lang.String str, java.lang.String str2) {
        com.huawei.hms.framework.common.PLSharedPreferences pLSharedPreferences = this.a;
        if (pLSharedPreferences == null) {
            return;
        }
        synchronized (pLSharedPreferences) {
            this.a.putString(str, str2);
        }
    }
}
