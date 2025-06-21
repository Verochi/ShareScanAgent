package com.sijla.b;

/* loaded from: classes19.dex */
public final class g {
    public static com.sijla.c.a a = null;
    public static java.lang.String b = "";
    public static java.lang.String c = "";
    public static java.lang.String d = "";
    public static com.sijla.callback.QtCallBack e = null;
    public static int f = -1;
    private static java.lang.String g = "";
    private static boolean h = true;
    private static com.sijla.b.m i = null;
    private static boolean j = false;
    private static boolean k = true;
    private static android.content.Context l;
    private static android.content.BroadcastReceiver m = new com.sijla.b.j();
    private static long n = 0;
    private static long o = 0;
    private static java.lang.String p = "";

    public static java.lang.String a() {
        return g;
    }

    public static void a(android.app.Application application) {
        if (k) {
            l = application;
            if (j) {
                return;
            }
            j = true;
            com.sijla.a.a.a(new com.sijla.b.h(application));
        }
    }

    public static void a(android.app.Application application, long j2) {
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        if (j2 > 0) {
            long j3 = o;
            if (j3 == 0 || java.lang.Math.abs(currentTimeMillis - j3) > 2000) {
                o = currentTimeMillis;
                if (h) {
                    java.lang.String str = com.sijla.c.a.d() + " 使用时长 " + j2 + " 秒 process:" + com.sijla.h.a.a.c();
                    a(com.sijla.h.a.a.i(application) + "到后台:" + str, 1);
                }
                com.sijla.f.c.a(application, j2, e);
                a((android.content.Context) application, j2);
            }
        }
    }

    public static void a(android.app.Application application, java.lang.String str, java.lang.String str2, boolean z, com.sijla.callback.QtCallBack qtCallBack) {
        try {
            l = application;
            try {
                b = com.sijla.h.a.a.l(application);
                com.sijla.h.a.a.a((android.content.Context) application, true);
                com.sijla.h.a.a.b((android.content.Context) application, true);
                com.sijla.h.i.b(application);
                com.sijla.h.a.a.g(application);
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
            a = com.sijla.c.a.a();
            p = com.sijla.h.c.d(application);
            if (str == null) {
                str = "";
            }
            c = str;
            if (android.text.TextUtils.isEmpty(str2)) {
                d = "";
            } else {
                d = str2;
            }
            k = z;
            if (qtCallBack != null) {
                e = qtCallBack;
            }
        } catch (java.lang.Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static /* synthetic */ void a(android.app.Application application, boolean z) {
        if (h) {
            a(com.sijla.h.a.a.i(application) + "到前台:" + com.sijla.c.a.d(), 1);
        }
        com.sijla.h.a.a.t(application);
        com.sijla.h.a.a.g(application);
        com.sijla.f.c.a(application, 0L, e);
        if (z) {
            a((android.content.Context) application, 0L);
        }
    }

    public static void a(android.content.Context context) {
        l = context;
    }

    private static void a(android.content.Context context, long j2) {
        boolean z = 0 == j2;
        android.content.Intent intent = new android.content.Intent();
        intent.putExtra("dur", j2);
        intent.setPackage(context.getPackageName());
        intent.setAction(z ? com.sijla.h.a.a.b(context) : com.sijla.h.a.a.c(context));
        com.sijla.f.a.a(context, intent);
    }

    public static void a(android.content.Context context, java.lang.String str) {
        com.sijla.a.a.a(new com.sijla.b.l(context, str));
    }

    public static void a(java.lang.String str) {
        g = str;
    }

    public static void a(java.lang.String str, int i2) {
    }

    public static void a(boolean z) {
        h = z;
    }

    public static android.content.Context b() {
        android.app.Application d2;
        if (l == null && (d2 = d()) != null) {
            l = d2.getApplicationContext();
        }
        return l;
    }

    public static void b(android.app.Application application) {
        try {
            if (i == null) {
                i = new com.sijla.b.m(application);
            }
            i.a();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public static void b(android.content.Context context) {
        try {
            android.content.IntentFilter intentFilter = new android.content.IntentFilter();
            intentFilter.addAction(com.sijla.h.a.a.a(context));
            try {
                context.unregisterReceiver(m);
            } catch (java.lang.Throwable unused) {
            }
            context.registerReceiver(m, intentFilter);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public static void b(java.lang.String str) {
        a(str, 1);
    }

    public static java.lang.String c() {
        return p;
    }

    public static void c(android.app.Application application) {
        if (java.lang.Math.abs(java.lang.System.currentTimeMillis() - n) >= 1000) {
            n = java.lang.System.currentTimeMillis();
            com.sijla.a.a.a(new com.sijla.b.k(application));
        }
    }

    public static void c(android.content.Context context) {
        try {
            if (com.sijla.h.c.a(d(context))) {
                com.sijla.h.j.a(context, "insid", com.sijla.h.a.g.a(java.lang.System.currentTimeMillis() + context.getPackageName() + com.sijla.h.c.e()));
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    private static android.app.Application d() {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("android.app.ActivityThread");
            java.lang.reflect.Method declaredMethod = cls.getDeclaredMethod("currentActivityThread", new java.lang.Class[0]);
            java.lang.reflect.Field declaredField = cls.getDeclaredField("mInitialApplication");
            declaredField.setAccessible(true);
            return (android.app.Application) declaredField.get(declaredMethod.invoke(null, new java.lang.Object[0]));
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static java.lang.String d(android.content.Context context) {
        try {
            return (java.lang.String) com.sijla.h.j.b(context, "insid", "");
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static void e(android.content.Context context) {
        try {
            if (((java.lang.Boolean) com.sijla.h.j.b(context, "isFirstRun", java.lang.Boolean.TRUE)).booleanValue()) {
                com.sijla.h.c.b(context);
                com.sijla.h.j.a(context, "FirstRunTime", java.lang.Long.valueOf(java.lang.System.currentTimeMillis() / 1000));
                com.sijla.h.j.a(context, "isFirstRun", java.lang.Boolean.FALSE);
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public static java.util.List<com.sijla.e.c> f(android.content.Context context) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        try {
            arrayList.add(new com.sijla.e.d(context));
            arrayList.add(new com.sijla.e.f(context));
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
        return arrayList;
    }
}
