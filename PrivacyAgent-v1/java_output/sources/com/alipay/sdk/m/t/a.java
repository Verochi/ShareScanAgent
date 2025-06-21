package com.alipay.sdk.m.t;

/* loaded from: classes.dex */
public class a {
    public static final java.lang.String g = "alipay_tid_storage";
    public static final java.lang.String h = "tidinfo";
    public static final java.lang.String i = "tid";
    public static final java.lang.String j = "client_key";
    public static final java.lang.String k = "timestamp";
    public static final java.lang.String l = "vimei";
    public static final java.lang.String m = "vimsi";
    public static android.content.Context n;
    public static com.alipay.sdk.m.t.a o;
    public java.lang.String a;
    public java.lang.String b;
    public long c;
    public java.lang.String d;
    public java.lang.String e;
    public boolean f = false;

    /* renamed from: com.alipay.sdk.m.t.a$a, reason: collision with other inner class name */
    public static class C0044a {
        public static java.lang.String a() {
            java.lang.String str;
            try {
                str = com.alipay.sdk.m.t.a.n.getApplicationContext().getPackageName();
            } catch (java.lang.Throwable th) {
                com.alipay.sdk.m.u.e.a(th);
                str = "";
            }
            return (str + "0000000000000000000000000000").substring(0, 24);
        }

        public static java.lang.String a(java.lang.String str, java.lang.String str2, boolean z) {
            if (com.alipay.sdk.m.t.a.n == null) {
                return null;
            }
            java.lang.String string = com.alipay.sdk.m.t.a.n.getSharedPreferences(str, 0).getString(str2, null);
            if (!android.text.TextUtils.isEmpty(string) && z) {
                string = com.alipay.sdk.m.n.e.a(a(), string, string);
                if (android.text.TextUtils.isEmpty(string)) {
                    com.alipay.sdk.m.u.e.b(com.alipay.sdk.m.l.a.z, "tid_str: pref failed");
                }
            }
            com.alipay.sdk.m.u.e.b(com.alipay.sdk.m.l.a.z, "tid_str: from local");
            return string;
        }

        public static void a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
            a(str, str2, str3, true);
        }

        public static void a(java.lang.String str, java.lang.String str2, java.lang.String str3, boolean z) {
            if (com.alipay.sdk.m.t.a.n == null) {
                return;
            }
            android.content.SharedPreferences sharedPreferences = com.alipay.sdk.m.t.a.n.getSharedPreferences(str, 0);
            if (z) {
                java.lang.String a = a();
                java.lang.String b = com.alipay.sdk.m.n.e.b(a, str3, str3);
                if (android.text.TextUtils.isEmpty(b)) {
                    java.lang.String.format("LocalPreference::putLocalPreferences failed %s，%s", str3, a);
                }
                str3 = b;
            }
            sharedPreferences.edit().putString(str2, str3).apply();
        }

        public static boolean a(java.lang.String str, java.lang.String str2) {
            if (com.alipay.sdk.m.t.a.n == null) {
                return false;
            }
            return com.alipay.sdk.m.t.a.n.getSharedPreferences(str, 0).contains(str2);
        }

        public static void b(java.lang.String str, java.lang.String str2) {
            if (com.alipay.sdk.m.t.a.n == null) {
                return;
            }
            com.alipay.sdk.m.t.a.n.getSharedPreferences(str, 0).edit().remove(str2).apply();
        }

        public static boolean c(java.lang.String str, java.lang.String str2) {
            if (com.alipay.sdk.m.t.a.n == null) {
                return false;
            }
            return com.alipay.sdk.m.t.a.n.getSharedPreferences(str, 0).contains(str2);
        }

        public static java.lang.String d(java.lang.String str, java.lang.String str2) {
            return a(str, str2, true);
        }
    }

    public static synchronized com.alipay.sdk.m.t.a a(android.content.Context context) {
        com.alipay.sdk.m.t.a aVar;
        synchronized (com.alipay.sdk.m.t.a.class) {
            if (o == null) {
                o = new com.alipay.sdk.m.t.a();
            }
            if (n == null) {
                o.b(context);
            }
            aVar = o;
        }
        return aVar;
    }

    private void a(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.Long l2) {
        if (a(str, str2, str3, str4)) {
            return;
        }
        this.a = str;
        this.b = str2;
        this.d = str3;
        this.e = str4;
        if (l2 == null) {
            this.c = java.lang.System.currentTimeMillis();
        } else {
            this.c = l2.longValue();
        }
        n();
    }

    private boolean a(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        return android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2) || android.text.TextUtils.isEmpty(str3) || android.text.TextUtils.isEmpty(str4);
    }

    private void b(android.content.Context context) {
        if (context != null) {
            n = context.getApplicationContext();
        }
        if (this.f) {
            return;
        }
        this.f = true;
        l();
    }

    private java.lang.String k() {
        return java.lang.Long.toHexString(java.lang.System.currentTimeMillis()) + (new java.util.Random().nextInt(9000) + 1000);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0072  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void l() {
        java.lang.String str;
        java.lang.String str2;
        java.lang.String str3;
        java.lang.String str4;
        java.lang.String a;
        java.lang.Long valueOf = java.lang.Long.valueOf(java.lang.System.currentTimeMillis());
        java.lang.String str5 = null;
        try {
            a = com.alipay.sdk.m.t.a.C0044a.a(g, h, true);
        } catch (java.lang.Exception e) {
            e = e;
            str = null;
            str2 = null;
        }
        if (!android.text.TextUtils.isEmpty(a)) {
            org.json.JSONObject jSONObject = new org.json.JSONObject(a);
            str = jSONObject.optString("tid", "");
            try {
                str2 = jSONObject.optString(j, "");
                try {
                    valueOf = java.lang.Long.valueOf(jSONObject.optLong("timestamp", java.lang.System.currentTimeMillis()));
                    str3 = jSONObject.optString(l, "");
                } catch (java.lang.Exception e2) {
                    e = e2;
                    str3 = null;
                }
            } catch (java.lang.Exception e3) {
                e = e3;
                str2 = null;
                str3 = str2;
                com.alipay.sdk.m.u.e.a(e);
                str4 = str5;
                str5 = str;
                com.alipay.sdk.m.u.e.b(com.alipay.sdk.m.l.a.z, "tid_str: load");
                if (!a(str5, str2, str3, str4)) {
                }
            }
            try {
                str5 = jSONObject.optString(m, "");
            } catch (java.lang.Exception e4) {
                e = e4;
                com.alipay.sdk.m.u.e.a(e);
                str4 = str5;
                str5 = str;
                com.alipay.sdk.m.u.e.b(com.alipay.sdk.m.l.a.z, "tid_str: load");
                if (!a(str5, str2, str3, str4)) {
                }
            }
            str4 = str5;
            str5 = str;
            com.alipay.sdk.m.u.e.b(com.alipay.sdk.m.l.a.z, "tid_str: load");
            if (!a(str5, str2, str3, str4)) {
                m();
                return;
            }
            this.a = str5;
            this.b = str2;
            this.c = valueOf.longValue();
            this.d = str3;
            this.e = str4;
            return;
        }
        str4 = null;
        str2 = null;
        str3 = null;
        com.alipay.sdk.m.u.e.b(com.alipay.sdk.m.l.a.z, "tid_str: load");
        if (!a(str5, str2, str3, str4)) {
        }
    }

    private void m() {
        this.a = "";
        this.b = b();
        this.c = java.lang.System.currentTimeMillis();
        this.d = k();
        this.e = k();
        com.alipay.sdk.m.t.a.C0044a.b(g, h);
    }

    private void n() {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("tid", this.a);
            jSONObject.put(j, this.b);
            jSONObject.put("timestamp", this.c);
            jSONObject.put(l, this.d);
            jSONObject.put(m, this.e);
            com.alipay.sdk.m.t.a.C0044a.a(g, h, jSONObject.toString(), true);
        } catch (java.lang.Exception e) {
            com.alipay.sdk.m.u.e.a(e);
        }
    }

    private void o() {
    }

    public void a() {
        com.alipay.sdk.m.u.e.b(com.alipay.sdk.m.l.a.z, "tid_str: del");
        m();
    }

    public void a(java.lang.String str, java.lang.String str2) {
        com.alipay.sdk.m.u.e.b(com.alipay.sdk.m.l.a.z, "tid_str: save");
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
            return;
        }
        this.a = str;
        this.b = str2;
        this.c = java.lang.System.currentTimeMillis();
        n();
        o();
    }

    public java.lang.String b() {
        java.lang.String hexString = java.lang.Long.toHexString(java.lang.System.currentTimeMillis());
        return hexString.length() > 10 ? hexString.substring(hexString.length() - 10) : hexString;
    }

    public java.lang.String c() {
        return this.b;
    }

    public java.lang.String d() {
        return this.a;
    }

    public java.lang.Long e() {
        return java.lang.Long.valueOf(this.c);
    }

    public java.lang.String f() {
        return this.d;
    }

    public java.lang.String g() {
        return this.e;
    }

    public boolean h() {
        return i();
    }

    public boolean i() {
        return android.text.TextUtils.isEmpty(this.a) || android.text.TextUtils.isEmpty(this.b) || android.text.TextUtils.isEmpty(this.d) || android.text.TextUtils.isEmpty(this.e);
    }
}
