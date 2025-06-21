package com.sijla.h;

/* loaded from: classes19.dex */
public final class i {
    public static java.lang.String a;

    public static java.lang.String a(android.content.Context context) {
        com.sijla.h.a a2 = com.sijla.h.a.a(context);
        java.lang.String a3 = a2.a("TruthUid");
        if (!android.text.TextUtils.isEmpty(a3)) {
            return a3;
        }
        java.lang.String b = b(context);
        a2.a("TruthUid", b);
        return b;
    }

    public static java.lang.String b(android.content.Context context) {
        if (android.text.TextUtils.isEmpty(a)) {
            e(context);
        }
        return a;
    }

    public static java.lang.String c(android.content.Context context) {
        try {
            return com.sijla.h.a.g.a(com.sijla.h.a.a.p(context) + (android.os.Build.BRAND + android.os.Build.MODEL) + com.sijla.h.a.a.m(context)).toUpperCase();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return com.sijla.h.a.g.a(com.sijla.h.a.a.m(context)).toUpperCase();
        }
    }

    public static java.lang.String d(android.content.Context context) {
        try {
            return com.sijla.h.a.g.a(com.sijla.h.a.a.p(context) + (com.sijla.h.a.a.q() + com.sijla.h.a.a.m() + android.os.Build.BRAND + android.os.Build.CPU_ABI + android.os.Build.DEVICE + android.os.Build.MANUFACTURER + android.os.Build.MODEL + android.os.Build.PRODUCT) + com.sijla.h.a.a.m(context) + com.sijla.h.a.a.p()).toUpperCase();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return com.sijla.h.a.g.a(com.sijla.h.a.a.m(context)).toUpperCase();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static java.lang.String e(android.content.Context context) {
        android.content.SharedPreferences sharedPreferences;
        android.content.SharedPreferences.Editor edit;
        java.lang.String f = f(context);
        try {
            sharedPreferences = context.getSharedPreferences("arch", 0);
            edit = sharedPreferences.edit();
        } catch (java.lang.Exception unused) {
            f = c(context);
        }
        if (com.sijla.h.c.a(f) || 32 != f.length()) {
            f = sharedPreferences.getString("hbuid", "");
            if (com.sijla.h.c.a(f)) {
                f = c(context);
            }
            if (a == null) {
                a = f;
            }
            return f;
        }
        edit.putString("hbuid", f).apply();
        if (a == null) {
        }
        return f;
    }

    private static java.lang.String f(android.content.Context context) {
        java.lang.String str = "";
        if (android.os.Build.VERSION.SDK_INT < 33 && com.sijla.h.a.a.b(context, "android.permission.READ_EXTERNAL_STORAGE") && com.sijla.h.a.a.a()) {
            java.util.Iterator<java.lang.String> it = com.sijla.h.c.c().iterator();
            while (it.hasNext()) {
                try {
                    str = com.sijla.h.c.a(com.sijla.h.c.a(new java.io.File(it.next()))).split("\t")[0];
                } catch (java.lang.Exception unused) {
                }
                if (!android.text.TextUtils.isEmpty(str)) {
                    break;
                }
            }
        }
        return str;
    }
}
