package com.alipay.sdk.m.m;

/* loaded from: classes.dex */
public class b {
    public static final java.lang.String d = "virtualImeiAndImsi";
    public static final java.lang.String e = "virtual_imei";
    public static final java.lang.String f = "virtual_imsi";
    public static volatile com.alipay.sdk.m.m.b g;
    public java.lang.String a;
    public java.lang.String b = "sdk-and-lite";
    public java.lang.String c;

    public b() {
        java.lang.String a = com.alipay.sdk.m.j.a.a();
        if (com.alipay.sdk.m.j.a.b()) {
            return;
        }
        this.b += '_' + a;
    }

    public static java.lang.String a(android.content.Context context) {
        return java.lang.Float.toString(new android.widget.TextView(context).getTextSize());
    }

    public static java.lang.String a(com.alipay.sdk.m.s.a aVar, android.content.Context context, boolean z) {
        if (z) {
            return org.apache.tools.tar.TarConstants.VERSION_POSIX;
        }
        try {
            android.net.wifi.WifiInfo d2 = com.alipay.sdk.m.w.b.d(aVar, context);
            return d2 != null ? d2.getBSSID() : org.apache.tools.tar.TarConstants.VERSION_POSIX;
        } catch (java.lang.Throwable th) {
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "lacking_per_2", th);
            return org.apache.tools.tar.TarConstants.VERSION_POSIX;
        }
    }

    public static synchronized void a(java.lang.String str) {
        synchronized (com.alipay.sdk.m.m.b.class) {
            if (android.text.TextUtils.isEmpty(str)) {
                return;
            }
            android.preference.PreferenceManager.getDefaultSharedPreferences(com.alipay.sdk.m.s.b.d().b()).edit().putString(com.alipay.sdk.m.l.b.i, str).apply();
            com.alipay.sdk.m.l.a.e = str;
        }
    }

    public static synchronized com.alipay.sdk.m.m.b b() {
        com.alipay.sdk.m.m.b bVar;
        synchronized (com.alipay.sdk.m.m.b.class) {
            if (g == null) {
                g = new com.alipay.sdk.m.m.b();
            }
            bVar = g;
        }
        return bVar;
    }

    public static java.lang.String b(android.content.Context context) {
        if (context == null) {
            return "";
        }
        try {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            java.lang.String packageName = context.getPackageName();
            android.content.pm.PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            sb.append("(");
            sb.append(packageName);
            sb.append(com.alipay.sdk.m.u.i.b);
            sb.append(packageInfo.versionCode);
            sb.append(")");
            return sb.toString();
        } catch (java.lang.Exception unused) {
            return "";
        }
    }

    public static java.lang.String b(com.alipay.sdk.m.s.a aVar, android.content.Context context, boolean z) {
        if (z) {
            return "-1";
        }
        try {
            android.net.wifi.WifiInfo d2 = com.alipay.sdk.m.w.b.d(aVar, context);
            return d2 != null ? d2.getSSID() : "-1";
        } catch (java.lang.Throwable th) {
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "lacking_per_1", th);
            return "-1";
        }
    }

    public static java.lang.String c() {
        return java.lang.Long.toHexString(java.lang.System.currentTimeMillis()) + (new java.util.Random().nextInt(9000) + 1000);
    }

    public static java.lang.String d() {
        return "-1;-1";
    }

    public static java.lang.String e() {
        return "1";
    }

    public static java.lang.String f() {
        android.content.Context b = com.alipay.sdk.m.s.b.d().b();
        android.content.SharedPreferences sharedPreferences = b.getSharedPreferences(d, 0);
        java.lang.String string = sharedPreferences.getString(e, null);
        if (!android.text.TextUtils.isEmpty(string)) {
            return string;
        }
        java.lang.String c = android.text.TextUtils.isEmpty(com.alipay.sdk.m.t.a.a(b).d()) ? c() : com.alipay.sdk.m.u.c.b(b).b();
        sharedPreferences.edit().putString(e, c).apply();
        return c;
    }

    public static java.lang.String g() {
        java.lang.String c;
        android.content.Context b = com.alipay.sdk.m.s.b.d().b();
        android.content.SharedPreferences sharedPreferences = b.getSharedPreferences(d, 0);
        java.lang.String string = sharedPreferences.getString(f, null);
        if (!android.text.TextUtils.isEmpty(string)) {
            return string;
        }
        if (android.text.TextUtils.isEmpty(com.alipay.sdk.m.t.a.a(b).d())) {
            java.lang.String c2 = com.alipay.sdk.m.s.b.d().c();
            c = (android.text.TextUtils.isEmpty(c2) || c2.length() < 18) ? c() : c2.substring(3, 18);
        } else {
            c = com.alipay.sdk.m.u.c.b(b).c();
        }
        java.lang.String str = c;
        sharedPreferences.edit().putString(f, str).apply();
        return str;
    }

    public java.lang.String a() {
        return this.c;
    }

    public java.lang.String a(com.alipay.sdk.m.s.a aVar, com.alipay.sdk.m.t.a aVar2, boolean z) {
        android.content.Context b = com.alipay.sdk.m.s.b.d().b();
        com.alipay.sdk.m.u.c b2 = com.alipay.sdk.m.u.c.b(b);
        if (android.text.TextUtils.isEmpty(this.a)) {
            this.a = "Msp/15.8.11 (" + com.alipay.sdk.m.u.n.f() + com.alipay.sdk.m.u.i.b + com.alipay.sdk.m.u.n.e() + com.alipay.sdk.m.u.i.b + com.alipay.sdk.m.u.n.c(b) + com.alipay.sdk.m.u.i.b + com.alipay.sdk.m.u.n.e(b) + com.alipay.sdk.m.u.i.b + com.alipay.sdk.m.u.n.f(b) + com.alipay.sdk.m.u.i.b + a(b);
        }
        java.lang.String b3 = com.alipay.sdk.m.u.c.d(b).b();
        java.lang.String b4 = com.alipay.sdk.m.u.n.b(b);
        java.lang.String e2 = e();
        java.lang.String c = b2.c();
        java.lang.String b5 = b2.b();
        java.lang.String g2 = g();
        java.lang.String f2 = f();
        if (aVar2 != null) {
            this.c = aVar2.c();
        }
        java.lang.String replace = android.os.Build.MANUFACTURER.replace(com.alipay.sdk.m.u.i.b, " ");
        java.lang.String replace2 = android.os.Build.MODEL.replace(com.alipay.sdk.m.u.i.b, " ");
        boolean e3 = com.alipay.sdk.m.s.b.e();
        java.lang.String d2 = b2.d();
        java.lang.String b6 = b(aVar, b, z);
        java.lang.String a = a(aVar, b, z);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(this.a);
        sb.append(com.alipay.sdk.m.u.i.b);
        sb.append(b3);
        sb.append(com.alipay.sdk.m.u.i.b);
        sb.append(b4);
        sb.append(com.alipay.sdk.m.u.i.b);
        sb.append(e2);
        sb.append(com.alipay.sdk.m.u.i.b);
        sb.append(c);
        sb.append(com.alipay.sdk.m.u.i.b);
        sb.append(b5);
        sb.append(com.alipay.sdk.m.u.i.b);
        sb.append(this.c);
        sb.append(com.alipay.sdk.m.u.i.b);
        sb.append(replace);
        sb.append(com.alipay.sdk.m.u.i.b);
        sb.append(replace2);
        sb.append(com.alipay.sdk.m.u.i.b);
        sb.append(e3);
        sb.append(com.alipay.sdk.m.u.i.b);
        sb.append(d2);
        sb.append(com.alipay.sdk.m.u.i.b);
        sb.append(d());
        sb.append(com.alipay.sdk.m.u.i.b);
        sb.append(this.b);
        sb.append(com.alipay.sdk.m.u.i.b);
        sb.append(g2);
        sb.append(com.alipay.sdk.m.u.i.b);
        sb.append(f2);
        sb.append(com.alipay.sdk.m.u.i.b);
        sb.append(b6);
        sb.append(com.alipay.sdk.m.u.i.b);
        sb.append(a);
        if (aVar2 != null) {
            java.lang.String a2 = com.alipay.sdk.m.w.b.a(aVar, b, com.alipay.sdk.m.t.a.a(b).d(), com.alipay.sdk.m.w.b.c(aVar, b));
            if (!android.text.TextUtils.isEmpty(a2)) {
                sb.append(";;;");
                sb.append(a2);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
