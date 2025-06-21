package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
public class bm {
    public static final java.lang.String a = "mobads_builds";
    public static final java.lang.String b = "brand_period";
    public static final java.lang.String c = "version_period";
    public static final long d = 604800000;
    public static final long e = 172800000;
    public static final java.lang.String f = "sdk_int";
    public static final java.lang.String g = "sdk";
    public static final java.lang.String h = "release";
    public static final java.lang.String i = "model";
    public static final java.lang.String j = "brand";
    public static final java.lang.String k = "netopera";
    public static final java.lang.String l = "tags";
    private int m;
    private java.lang.String n;
    private java.lang.String o;
    private java.lang.String p;
    private java.lang.String q;
    private java.lang.String r;

    /* renamed from: s, reason: collision with root package name */
    private java.lang.String f296s;
    private android.content.Context t;
    private android.content.SharedPreferences u;

    public static class a {
        private static final com.baidu.mobads.sdk.internal.bm a = new com.baidu.mobads.sdk.internal.bm(null);

        private a() {
        }
    }

    private bm() {
        this.m = 0;
        this.n = "";
        this.o = "";
        this.p = "";
        this.q = "";
        this.r = "";
        this.f296s = "";
    }

    public /* synthetic */ bm(com.baidu.mobads.sdk.internal.bn bnVar) {
        this();
    }

    public static com.baidu.mobads.sdk.internal.bm a(android.content.Context context) {
        com.baidu.mobads.sdk.internal.bm.a.a.b(context);
        return com.baidu.mobads.sdk.internal.bm.a.a;
    }

    private java.lang.String a(java.lang.String str) {
        try {
            return this.u.getString(str, "");
        } catch (java.lang.Throwable th) {
            com.baidu.mobads.sdk.internal.bt.a().c(th.getMessage());
            return "";
        }
    }

    @android.annotation.TargetApi(9)
    private void a(java.lang.String str, int i2) {
        try {
            android.content.SharedPreferences.Editor k2 = k();
            k2.putInt(str, i2);
            k2.apply();
        } catch (java.lang.Throwable th) {
            com.baidu.mobads.sdk.internal.bt.a().c(th.getMessage());
        }
    }

    @android.annotation.TargetApi(9)
    private void a(java.lang.String str, java.lang.Long l2) {
        try {
            android.content.SharedPreferences.Editor k2 = k();
            k2.putLong(str, l2.longValue());
            k2.apply();
        } catch (java.lang.Throwable th) {
            com.baidu.mobads.sdk.internal.bt.a().c(th.getMessage());
        }
    }

    @android.annotation.TargetApi(9)
    private void a(java.lang.String str, java.lang.String str2) {
        try {
            android.content.SharedPreferences.Editor k2 = k();
            k2.putString(str, str2);
            k2.apply();
        } catch (java.lang.Throwable th) {
            com.baidu.mobads.sdk.internal.bt.a().c(th.getMessage());
        }
    }

    private java.lang.Long b(java.lang.String str) {
        try {
            return java.lang.Long.valueOf(this.u.getLong(str, 0L));
        } catch (java.lang.Throwable th) {
            com.baidu.mobads.sdk.internal.bt.a().c(th.getMessage());
            return 0L;
        }
    }

    private int c(java.lang.String str) {
        try {
            return this.u.getInt(str, 0);
        } catch (java.lang.Throwable th) {
            com.baidu.mobads.sdk.internal.bt.a().c(th.getMessage());
            return 0;
        }
    }

    private void h() {
        i();
        j();
    }

    private void i() {
        try {
            if (java.lang.System.currentTimeMillis() > b(b).longValue()) {
                this.p = android.os.Build.MODEL;
                this.q = android.os.Build.BRAND;
                this.r = ((android.telephony.TelephonyManager) this.t.getSystemService(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE)).getNetworkOperator();
                this.f296s = android.os.Build.TAGS;
                a("model", this.p);
                a("brand", this.q);
                a(k, this.r);
                a(l, this.f296s);
                a(b, java.lang.Long.valueOf(java.lang.System.currentTimeMillis() + 604800000));
            } else {
                this.p = a("model");
                this.q = a("brand");
                this.r = a(k);
                this.f296s = a(l);
            }
        } catch (java.lang.Throwable th) {
            com.baidu.mobads.sdk.internal.bt.a().c(th.getMessage());
        }
    }

    private void j() {
        try {
            if (java.lang.System.currentTimeMillis() > b(c).longValue()) {
                int i2 = android.os.Build.VERSION.SDK_INT;
                this.m = i2;
                this.n = android.os.Build.VERSION.SDK;
                this.o = android.os.Build.VERSION.RELEASE;
                a(f, i2);
                a("sdk", this.n);
                a("release", this.o);
                a(c, java.lang.Long.valueOf(java.lang.System.currentTimeMillis() + e));
            } else {
                this.m = c(f);
                this.n = a("sdk");
                this.o = a("release");
            }
        } catch (java.lang.Throwable th) {
            com.baidu.mobads.sdk.internal.bt.a().c(th.getMessage());
        }
    }

    private android.content.SharedPreferences.Editor k() {
        return this.u.edit();
    }

    public int a() {
        if (this.m == 0) {
            this.m = android.os.Build.VERSION.SDK_INT;
        }
        return this.m;
    }

    public java.lang.String b() {
        if (android.text.TextUtils.isEmpty(this.n)) {
            this.n = android.os.Build.VERSION.SDK;
        }
        return this.n;
    }

    public void b(android.content.Context context) {
        if (this.t != null || context == null) {
            if (com.baidu.mobads.sdk.internal.bm.a.a == null) {
                com.baidu.mobads.sdk.internal.bb.a(context);
                return;
            }
            return;
        }
        android.content.Context applicationContext = context.getApplicationContext();
        this.t = applicationContext;
        try {
            if (this.u == null) {
                this.u = applicationContext.getSharedPreferences(a, 0);
                h();
            }
        } catch (java.lang.Throwable th) {
            com.baidu.mobads.sdk.internal.bt.a().c(th.getMessage());
        }
    }

    public java.lang.String c() {
        return this.o;
    }

    public java.lang.String d() {
        return this.p;
    }

    public java.lang.String e() {
        return this.q;
    }

    public java.lang.String f() {
        return this.r;
    }

    public java.lang.String g() {
        return this.f296s;
    }
}
