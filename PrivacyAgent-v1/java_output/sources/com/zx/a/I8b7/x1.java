package com.zx.a.I8b7;

/* loaded from: classes19.dex */
public class x1 {
    public static java.lang.String a(android.content.Context context) throws java.lang.Exception {
        java.lang.String str;
        if (!android.text.TextUtils.isEmpty(com.zx.a.I8b7.m3.f)) {
            return com.zx.a.I8b7.m3.f.trim();
        }
        if (context == null) {
            throw new java.lang.RuntimeException("context not provided, cannot be null");
        }
        try {
            str = b(context).getString("ZX_APPID");
        } catch (java.lang.Exception e) {
            com.zx.a.I8b7.r2.a(e);
            str = null;
        }
        if (android.text.TextUtils.isEmpty(str)) {
            if (com.zx.a.I8b7.m3.e == null) {
                d(context);
            }
            if (!(!android.text.TextUtils.isEmpty(com.zx.a.I8b7.m3.e))) {
                throw new java.lang.IllegalStateException("ZX_APPID not found");
            }
            str = a(c(context));
        }
        return str.trim();
    }

    @com.zx.module.annotation.Java2C.Method2C
    public static native java.lang.String a(java.lang.String str) throws java.security.NoSuchAlgorithmException, java.security.InvalidKeyException;

    public static org.json.JSONArray a() {
        android.os.Bundle b;
        org.json.JSONArray jSONArray = new org.json.JSONArray();
        try {
            b = b(com.zx.a.I8b7.m3.a);
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
            com.zx.a.I8b7.r2.a(e);
        }
        if (b == null) {
            return jSONArray;
        }
        for (java.lang.String str : b.keySet()) {
            if (str.startsWith("ZX_APPID_")) {
                java.lang.String string = b.getString(str);
                if (!android.text.TextUtils.isEmpty(string)) {
                    jSONArray.put(string);
                }
            }
        }
        return jSONArray;
    }

    public static android.os.Bundle b(android.content.Context context) throws android.content.pm.PackageManager.NameNotFoundException {
        if (com.zx.a.I8b7.m3.J == null) {
            com.zx.a.I8b7.m3.J = com.zx.a.I8b7.w3.c(context.getApplicationContext()).getApplicationInfo(c(context), 128).metaData;
        }
        return com.zx.a.I8b7.m3.J;
    }

    @com.zx.module.annotation.Java2C.Method2C
    private static native java.lang.String b();

    public static java.lang.String c(android.content.Context context) {
        if (android.text.TextUtils.isEmpty(com.zx.a.I8b7.m3.g)) {
            com.zx.a.I8b7.m3.g = context.getPackageName();
        }
        return com.zx.a.I8b7.m3.g;
    }

    public static void d(android.content.Context context) {
        try {
            com.zx.a.I8b7.m3.e = b(context).getString("ZX_CHANNEL_ID");
            com.zx.a.I8b7.r2.a("initChannelId: , channelId = '" + com.zx.a.I8b7.m3.e + "'");
        } catch (java.lang.Exception e) {
            com.zx.a.I8b7.r2.a(e);
        }
    }
}
