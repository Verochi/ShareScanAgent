package com.umeng.commonsdk.utils;

/* loaded from: classes19.dex */
public class c {
    private static final java.lang.String b = "lastReqTime";
    private static final int c = 48;
    private static final int d = 1;
    private static final int e = 720;
    private static final java.lang.String f = "iss";
    private static final java.lang.String g = "sinr";
    private static final java.lang.String h = "clean";
    private static boolean i;
    private static int j;
    private static final java.lang.String a = com.umeng.analytics.pro.ay.b().b(com.umeng.analytics.pro.ay.z);
    private static java.lang.Object k = new java.lang.Object();

    static {
        i = false;
        j = e;
        android.content.Context appContext = com.umeng.commonsdk.service.UMGlobalContext.getAppContext();
        if (appContext != null) {
            java.lang.String imprintProperty = com.umeng.commonsdk.framework.UMEnvelopeBuild.imprintProperty(appContext, f, "");
            if (android.text.TextUtils.isEmpty(imprintProperty) || !"1".equals(imprintProperty)) {
                return;
            }
            synchronized (k) {
                i = true;
            }
            java.lang.String imprintProperty2 = com.umeng.commonsdk.framework.UMEnvelopeBuild.imprintProperty(appContext, g, "");
            if (android.text.TextUtils.isEmpty(imprintProperty)) {
                j = 48;
                return;
            }
            try {
                j = a(java.lang.Integer.parseInt(imprintProperty2));
            } catch (java.lang.Throwable unused) {
                j = 48;
            }
        }
    }

    private static int a(int i2) {
        if (i2 > e) {
            return e;
        }
        if (i2 < 1) {
            return 1;
        }
        return i2;
    }

    public static int a(android.content.Context context) {
        int i2;
        synchronized (k) {
            i2 = j;
        }
        return i2;
    }

    public static void a(android.content.Context context, long j2) {
        android.content.SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(a, 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong(b, j2).commit();
        }
    }

    public static boolean a() {
        boolean z;
        synchronized (k) {
            z = i;
        }
        return z;
    }

    public static boolean a(long j2, long j3, int i2) {
        java.util.Date date = new java.util.Date(j3);
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.setTime(new java.util.Date(j2));
        calendar.add(10, i2);
        return date.after(calendar.getTime());
    }

    public static long b(android.content.Context context) {
        android.content.SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(a, 0);
        if (sharedPreferences != null) {
            return sharedPreferences.getLong(b, 0L);
        }
        return 0L;
    }

    public static void c(android.content.Context context) {
        android.content.SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(a, 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean(h, true).commit();
        }
    }

    public static void d(android.content.Context context) {
        android.content.SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(a, 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean(h, false).commit();
        }
    }

    public static boolean e(android.content.Context context) {
        android.content.SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(a, 0);
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean(h, false);
        }
        return false;
    }
}
