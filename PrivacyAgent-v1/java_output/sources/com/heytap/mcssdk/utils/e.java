package com.heytap.mcssdk.utils;

/* loaded from: classes22.dex */
public class e {
    private static final java.lang.String a = "shared_msg_sdk";
    private static final java.lang.String b = "hasDefaultChannelCreated";
    private static final java.lang.String c = "lastUpLoadInfoSDKVersionName";
    private static final java.lang.String d = "lastUploadInfoUniqueID";
    private static final java.lang.String e = "decryptTag";
    private android.content.Context f;
    private android.content.SharedPreferences g;
    private java.lang.Object h;

    public static class a {
        static com.heytap.mcssdk.utils.e a = new com.heytap.mcssdk.utils.e(null);

        private a() {
        }
    }

    private e() {
        this.h = new java.lang.Object();
        android.content.Context context = com.heytap.mcssdk.PushService.getInstance().getContext();
        if (context != null) {
            this.f = a(context);
        }
        android.content.Context context2 = this.f;
        if (context2 != null) {
            this.g = context2.getSharedPreferences(a, 0);
        }
    }

    public /* synthetic */ e(com.heytap.mcssdk.utils.e.AnonymousClass1 anonymousClass1) {
        this();
    }

    private android.content.Context a(android.content.Context context) {
        android.content.Context createDeviceProtectedStorageContext;
        boolean a2 = com.heytap.mcssdk.utils.a.a();
        com.heytap.mcssdk.utils.d.b("fbeVersion is " + a2);
        if (!a2 || android.os.Build.VERSION.SDK_INT < 24) {
            return context.getApplicationContext();
        }
        createDeviceProtectedStorageContext = context.createDeviceProtectedStorageContext();
        return createDeviceProtectedStorageContext;
    }

    public static com.heytap.mcssdk.utils.e f() {
        return com.heytap.mcssdk.utils.e.a.a;
    }

    private android.content.SharedPreferences g() {
        android.content.Context context;
        android.content.SharedPreferences sharedPreferences = this.g;
        if (sharedPreferences != null) {
            return sharedPreferences;
        }
        synchronized (this.h) {
            android.content.SharedPreferences sharedPreferences2 = this.g;
            if (sharedPreferences2 != null || (context = this.f) == null) {
                return sharedPreferences2;
            }
            android.content.SharedPreferences sharedPreferences3 = context.getSharedPreferences(a, 0);
            this.g = sharedPreferences3;
            return sharedPreferences3;
        }
    }

    public int a(java.lang.String str, int i) {
        android.content.SharedPreferences g = g();
        return g != null ? g.getInt(str, i) : i;
    }

    public long a(java.lang.String str, long j) {
        android.content.SharedPreferences g = g();
        return g != null ? g.getLong(str, j) : j;
    }

    public void a(java.lang.String str) {
        android.content.SharedPreferences g = g();
        if (g != null) {
            g.edit().putString(d, str).commit();
        }
    }

    public void a(boolean z) {
        android.content.SharedPreferences g = g();
        if (g != null) {
            g.edit().putBoolean(b, z).commit();
        }
    }

    public boolean a() {
        android.content.SharedPreferences g = g();
        if (g != null) {
            return g.getBoolean(b, false);
        }
        return false;
    }

    public void b() {
        android.content.SharedPreferences g = g();
        if (g != null) {
            g.edit().putString(c, com.pushsdk.a.f).commit();
        }
    }

    public void b(java.lang.String str) {
        android.content.SharedPreferences g = g();
        if (g != null) {
            g.edit().putString(e, str).commit();
        }
    }

    public void b(java.lang.String str, int i) {
        android.content.SharedPreferences g = g();
        if (g != null) {
            android.content.SharedPreferences.Editor edit = g.edit();
            edit.putInt(str, i);
            edit.apply();
        }
    }

    public void b(java.lang.String str, long j) {
        android.content.SharedPreferences g = g();
        if (g != null) {
            android.content.SharedPreferences.Editor edit = g.edit();
            edit.putLong(str, j);
            edit.apply();
        }
    }

    public int c(java.lang.String str) {
        android.content.SharedPreferences g = g();
        if (g != null) {
            return g.getInt(str, 0);
        }
        return 0;
    }

    public java.lang.String c() {
        android.content.SharedPreferences g = g();
        return g != null ? g.getString(d, "") : "";
    }

    public long d(java.lang.String str) {
        android.content.SharedPreferences g = g();
        return g != null ? g.getLong(str, com.heytap.mcssdk.constant.a.b.longValue()) : com.heytap.mcssdk.constant.a.b.longValue();
    }

    public java.lang.String d() {
        android.content.SharedPreferences g = g();
        return g != null ? g.getString(c, "") : "";
    }

    public java.lang.String e() {
        android.content.SharedPreferences g = g();
        return g != null ? g.getString(e, "DES") : "DES";
    }
}
