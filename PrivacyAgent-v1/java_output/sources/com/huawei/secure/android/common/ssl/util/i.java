package com.huawei.secure.android.common.ssl.util;

/* loaded from: classes22.dex */
public class i {
    public static android.content.SharedPreferences a;

    public static int a(java.lang.String str, int i, android.content.Context context) {
        return b(context).getInt(str, i);
    }

    public static long a(java.lang.String str, long j, android.content.Context context) {
        return b(context).getLong(str, j);
    }

    public static java.lang.String a(java.lang.String str, java.lang.String str2, android.content.Context context) {
        return b(context).getString(str, str2);
    }

    public static void a(android.content.Context context) {
        b(context).edit().clear().apply();
    }

    public static void a(java.lang.String str, android.content.Context context) {
        b(context).edit().remove(str).apply();
    }

    public static synchronized android.content.SharedPreferences b(android.content.Context context) {
        android.content.SharedPreferences sharedPreferences;
        android.content.Context createDeviceProtectedStorageContext;
        synchronized (com.huawei.secure.android.common.ssl.util.i.class) {
            if (a == null) {
                if (android.os.Build.VERSION.SDK_INT >= 24) {
                    createDeviceProtectedStorageContext = context.createDeviceProtectedStorageContext();
                    a = createDeviceProtectedStorageContext.getSharedPreferences("aegis", 0);
                } else {
                    a = context.getApplicationContext().getSharedPreferences("aegis", 0);
                }
            }
            sharedPreferences = a;
        }
        return sharedPreferences;
    }

    public static void b(java.lang.String str, int i, android.content.Context context) {
        b(context).edit().putInt(str, i).apply();
    }

    public static void b(java.lang.String str, long j, android.content.Context context) {
        b(context).edit().putLong(str, j).apply();
    }

    public static void b(java.lang.String str, java.lang.String str2, android.content.Context context) {
        b(context).edit().putString(str, str2).apply();
    }
}
