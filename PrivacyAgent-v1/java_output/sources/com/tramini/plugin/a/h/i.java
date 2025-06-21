package com.tramini.plugin.a.h;

/* loaded from: classes19.dex */
public final class i {
    public static java.lang.Long a(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.Long l) {
        if (context == null) {
            return 0L;
        }
        try {
            return java.lang.Long.valueOf(context.getSharedPreferences(str, 0).getLong(str2, l.longValue()));
        } catch (java.lang.Error | java.lang.Exception unused) {
            return l;
        }
    }

    private static void a(android.content.Context context, java.lang.String str) {
        if (context == null) {
            return;
        }
        try {
            context.getSharedPreferences(str, 0).edit().clear().apply();
        } catch (java.lang.Error | java.lang.Exception unused) {
        }
    }

    private static void a(android.content.Context context, java.lang.String str, java.lang.String str2, int i) {
        if (context == null) {
            return;
        }
        try {
            android.content.SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
            edit.putInt(str2, i);
            edit.apply();
        } catch (java.lang.Error | java.lang.Exception unused) {
        }
    }

    private static void a(android.content.Context context, java.lang.String str, java.lang.String str2, long j) {
        if (context == null) {
            return;
        }
        try {
            android.content.SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
            edit.putLong(str2, j);
            edit.apply();
        } catch (java.lang.Error | java.lang.Exception unused) {
        }
    }

    public static void a(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (context == null) {
            return;
        }
        try {
            android.content.SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
            edit.putString(str2, java.lang.String.valueOf(str3));
            edit.apply();
        } catch (java.lang.Error | java.lang.Exception unused) {
        }
    }

    private static int b(android.content.Context context, java.lang.String str, java.lang.String str2, int i) {
        if (context == null) {
            return 0;
        }
        try {
            return context.getSharedPreferences(str, 0).getInt(str2, i);
        } catch (java.lang.Error | java.lang.Exception unused) {
            return i;
        }
    }

    public static java.lang.String b(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (context == null) {
            return null;
        }
        try {
            return context.getSharedPreferences(str, 0).getString(str2, str3);
        } catch (java.lang.Error | java.lang.Exception unused) {
            return str3;
        }
    }
}
