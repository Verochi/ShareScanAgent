package com.alipay.sdk.m.b0;

/* loaded from: classes.dex */
public final class e {
    public static java.lang.String a(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        return context.getSharedPreferences(str, 0).getString(str2, str3);
    }

    public static void a(android.content.Context context, java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map) {
        android.content.SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
        if (edit != null) {
            for (java.lang.String str2 : map.keySet()) {
                edit.putString(str2, map.get(str2));
            }
            edit.commit();
        }
    }
}
