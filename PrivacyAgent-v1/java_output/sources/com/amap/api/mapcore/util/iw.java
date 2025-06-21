package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class iw {
    public static int a(android.content.Context context, java.lang.String str, java.lang.String str2) {
        try {
            return context.getSharedPreferences(str, 0).getInt(str2, 200);
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.it.a(th, "SpUtil", "getPrefsInt");
            return 200;
        }
    }

    public static java.lang.String a(android.content.Context context) {
        return context == null ? com.alipay.sdk.m.u.c.b : a(context, "pref", "smac", com.alipay.sdk.m.u.c.b);
    }

    private static java.lang.String a(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        try {
            return context.getSharedPreferences(str, 0).getString(str2, str3);
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.it.a(th, "SpUtil", "getPrefsInt");
            return str3;
        }
    }

    public static void a(android.content.Context context, java.lang.String str) {
        if (context == null || android.text.TextUtils.isEmpty(str)) {
            return;
        }
        android.content.SharedPreferences.Editor b = b(context, "pref");
        a(b, "smac", str);
        a(b);
    }

    private static void a(android.content.SharedPreferences.Editor editor) {
        if (editor == null) {
            return;
        }
        editor.apply();
    }

    private static void a(android.content.SharedPreferences.Editor editor, java.lang.String str, java.lang.String str2) {
        try {
            editor.putString(str, str2);
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.it.a(th, "SpUtil", "setPrefsStr");
        }
    }

    private static android.content.SharedPreferences.Editor b(android.content.Context context, java.lang.String str) {
        return context.getSharedPreferences(str, 0).edit();
    }

    public static boolean b(android.content.Context context, java.lang.String str, java.lang.String str2) {
        try {
            return context.getSharedPreferences(str, 0).getBoolean(str2, true);
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.it.a(th, "SpUtil", "getPrefsBoolean");
            return true;
        }
    }
}
