package com.umeng.commonsdk.internal.utils;

/* loaded from: classes19.dex */
public class j {
    private static final java.lang.String a = com.umeng.analytics.pro.ay.b().b(com.umeng.analytics.pro.ay.r);
    private static final java.lang.String b = "um_common_strength";
    private static final java.lang.String c = "um_common_battery";

    public static java.lang.String a(android.content.Context context) {
        android.content.SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getApplicationContext().getSharedPreferences(a, 0)) == null) {
            return null;
        }
        return sharedPreferences.getString(c, null);
    }

    public static void a(android.content.Context context, java.lang.String str) {
        android.content.SharedPreferences sharedPreferences;
        if (context == null || android.text.TextUtils.isEmpty(str) || (sharedPreferences = context.getApplicationContext().getSharedPreferences(a, 0)) == null) {
            return;
        }
        sharedPreferences.edit().putString(c, str).commit();
    }
}
