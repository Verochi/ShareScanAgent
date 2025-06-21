package com.igexin.c.a.c;

/* loaded from: classes22.dex */
public class a {
    private static volatile com.igexin.c.a.c.a b;
    private static final java.util.List<java.lang.String> c = new java.util.ArrayList();
    public volatile com.getui.gtc.base.log.Logger a;

    private a() {
        try {
            this.a = new com.getui.gtc.base.log.Logger(com.getui.gtc.base.GtcProvider.context());
            this.a.setGlobalTag("gtsdk");
            this.a.setLogcatEnable(false);
            this.a.setLogFileNameSuffix("GTSDK");
            this.a.setStackOffset(1);
            this.a.setFileEnableProperty("sdk.debug");
            java.util.List<java.lang.String> list = c;
            list.add(com.igexin.c.a.d.g.h);
            list.add("ScheduleQueue");
        } catch (java.lang.Throwable unused) {
        }
    }

    public static com.igexin.c.a.c.a a() {
        if (b == null) {
            synchronized (com.igexin.c.a.c.a.class) {
                if (b == null) {
                    b = new com.igexin.c.a.c.a();
                }
            }
        }
        return b;
    }

    public static void a(java.lang.String str, java.lang.String str2) {
        try {
            if (a().a == null || str == null || c.contains(str)) {
                return;
            }
            a().a.e(str + "|" + str2);
        } catch (java.lang.Throwable unused) {
        }
    }

    public static void a(java.lang.String str, java.lang.Object... objArr) {
        try {
            if (a().a != null) {
                if (objArr.length > 0) {
                    str = java.lang.String.format(str, objArr);
                }
                a().a.filelog(1, null, str, null);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public static void a(java.lang.Throwable th) {
        try {
            if (a().a != null) {
                a().a.e(th);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public static void a(boolean z) {
        try {
            com.igexin.push.config.e.a(java.lang.Boolean.valueOf(z));
            if (a().a != null) {
                a().a.setLogcatEnable(false);
                a().a.setFileEnableProperty("sdk.debug");
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    private static com.getui.gtc.base.log.Logger b() {
        return a().a;
    }

    public static void b(java.lang.String str, java.lang.String str2) {
        try {
            if (a().a == null || str == null || c.contains(str)) {
                return;
            }
            a().a.d(str + "|" + str2);
        } catch (java.lang.Throwable unused) {
        }
    }

    private static void c(java.lang.String str, java.lang.String str2) {
        try {
            if (a().a == null || str == null || c.contains(str)) {
                return;
            }
            a().a.logcat(2, null, str2, null);
        } catch (java.lang.Throwable unused) {
        }
    }

    private static void d(java.lang.String str, java.lang.String str2) {
        try {
            if (a().a == null || str == null || c.contains(str)) {
                return;
            }
            a().a.logcat(3, null, str2, null);
        } catch (java.lang.Throwable unused) {
        }
    }

    private static void e(java.lang.String str, java.lang.String str2) {
        try {
            if (a().a == null || str == null || c.contains(str)) {
                return;
            }
            a().a.logcat(4, null, str2, null);
        } catch (java.lang.Throwable unused) {
        }
    }
}
