package com.umeng.commonsdk.statistics.common;

/* loaded from: classes19.dex */
public final class d {
    private static com.umeng.commonsdk.statistics.common.d a;
    private static android.content.Context b;
    private static java.lang.String c;
    private static final java.lang.String d = com.umeng.analytics.pro.ay.b().b(com.umeng.analytics.pro.ay.m);

    public d(android.content.Context context) {
    }

    public static synchronized com.umeng.commonsdk.statistics.common.d a(android.content.Context context) {
        com.umeng.commonsdk.statistics.common.d dVar;
        synchronized (com.umeng.commonsdk.statistics.common.d.class) {
            b = context.getApplicationContext();
            c = context.getPackageName();
            if (a == null) {
                a = new com.umeng.commonsdk.statistics.common.d(context);
            }
            dVar = a;
        }
        return dVar;
    }

    private android.content.SharedPreferences f() {
        return b.getSharedPreferences(d + c, 0);
    }

    public int a() {
        android.content.SharedPreferences sharedPreferences = com.umeng.commonsdk.statistics.internal.PreferenceWrapper.getDefault(b);
        if (sharedPreferences != null) {
            return sharedPreferences.getInt("vt", 0);
        }
        return 0;
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
        android.content.SharedPreferences.Editor edit = f().edit();
        edit.putString("au_p", str);
        edit.putString("au_u", str2);
        edit.commit();
    }

    public java.lang.String b() {
        android.content.SharedPreferences sharedPreferences = com.umeng.commonsdk.statistics.internal.PreferenceWrapper.getDefault(b);
        if (sharedPreferences != null) {
            return sharedPreferences.getString("st", null);
        }
        return null;
    }

    public boolean c() {
        return com.umeng.commonsdk.framework.UMFrUtils.envelopeFileNumber(b) > 0;
    }

    public java.lang.String[] d() {
        try {
            android.content.SharedPreferences f = f();
            java.lang.String string = f.getString("au_p", null);
            java.lang.String string2 = f.getString("au_u", null);
            if (string != null && string2 != null) {
                return new java.lang.String[]{string, string2};
            }
        } catch (java.lang.Exception unused) {
        }
        return null;
    }

    public void e() {
        f().edit().remove("au_p").remove("au_u").commit();
    }
}
