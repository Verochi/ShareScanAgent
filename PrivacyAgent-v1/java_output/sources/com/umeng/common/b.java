package com.umeng.common;

/* loaded from: classes19.dex */
public final class b {
    private static com.umeng.common.b a;
    private static android.content.Context b;
    private static java.lang.String c;
    private static final java.lang.String d = com.umeng.analytics.pro.ay.b().b(com.umeng.analytics.pro.ay.m);

    public static final class a {
        private static final com.umeng.common.b a = new com.umeng.common.b();

        private a() {
        }
    }

    public static synchronized com.umeng.common.b a(android.content.Context context) {
        com.umeng.common.b bVar;
        synchronized (com.umeng.common.b.class) {
            if (b == null && context != null) {
                b = context.getApplicationContext();
            }
            if (b != null) {
                c = context.getPackageName();
            }
            bVar = com.umeng.common.b.a.a;
        }
        return bVar;
    }

    public static java.lang.String a(android.content.Context context, java.lang.String str, java.lang.String str2) {
        android.content.SharedPreferences sharedPreferences;
        return (context == null || (sharedPreferences = context.getApplicationContext().getSharedPreferences(str, 0)) == null) ? "" : sharedPreferences.getString(str2, "");
    }

    public static void a(android.content.Context context, java.lang.String str) {
        android.content.SharedPreferences.Editor edit = context.getApplicationContext().getSharedPreferences(str, 0).edit();
        edit.remove("debugkey");
        edit.remove(com.umeng.analytics.AnalyticsConfig.RTD_PERIOD);
        edit.remove(com.umeng.analytics.AnalyticsConfig.RTD_START_TIME);
        edit.clear();
        edit.commit();
    }

    public static void a(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        android.content.SharedPreferences sharedPreferences;
        android.content.SharedPreferences.Editor edit;
        if (context == null || (sharedPreferences = context.getApplicationContext().getSharedPreferences(str, 0)) == null || (edit = sharedPreferences.edit()) == null) {
            return;
        }
        edit.putString(str2, str3);
        edit.commit();
    }

    private android.content.SharedPreferences e() {
        android.content.Context context = b;
        if (context == null) {
            return null;
        }
        return context.getSharedPreferences(d + c, 0);
    }

    public void a(int i) {
        android.content.SharedPreferences sharedPreferences = com.umeng.commonsdk.statistics.internal.PreferenceWrapper.getDefault(b);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt("vt", i).commit();
        }
    }

    public void a(java.lang.String str) {
        android.content.SharedPreferences sharedPreferences = com.umeng.commonsdk.statistics.internal.PreferenceWrapper.getDefault(b);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("st", str).commit();
        }
    }

    public void a(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
            return;
        }
        android.content.SharedPreferences.Editor edit = e().edit();
        edit.putString("au_p", str);
        edit.putString("au_u", str2);
        edit.commit();
    }

    public java.lang.String[] a() {
        android.content.SharedPreferences e = e();
        if (e == null) {
            return null;
        }
        java.lang.String string = e.getString("au_p", null);
        java.lang.String string2 = e.getString("au_u", null);
        if (android.text.TextUtils.isEmpty(string) || android.text.TextUtils.isEmpty(string2)) {
            return null;
        }
        return new java.lang.String[]{string, string2};
    }

    public void b() {
        android.content.SharedPreferences e = e();
        if (e != null) {
            e.edit().remove("au_p").remove("au_u").commit();
        }
    }

    public java.lang.String c() {
        android.content.SharedPreferences sharedPreferences = com.umeng.commonsdk.statistics.internal.PreferenceWrapper.getDefault(b);
        if (sharedPreferences != null) {
            return sharedPreferences.getString("st", null);
        }
        return null;
    }

    public int d() {
        android.content.SharedPreferences sharedPreferences = com.umeng.commonsdk.statistics.internal.PreferenceWrapper.getDefault(b);
        if (sharedPreferences != null) {
            return sharedPreferences.getInt("vt", 0);
        }
        return 0;
    }
}
