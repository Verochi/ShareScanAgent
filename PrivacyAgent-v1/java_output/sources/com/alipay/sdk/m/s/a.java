package com.alipay.sdk.m.s;

/* loaded from: classes.dex */
public class a {
    public static final java.lang.String A = "act_info";
    public static final java.lang.String B = "UTF-8";
    public static final java.lang.String C = "new_external_info==";
    public static final java.lang.String m = "\"&";
    public static final java.lang.String n = "&";
    public static final java.lang.String o = "bizcontext=\"";
    public static final java.lang.String p = "bizcontext=";
    public static final java.lang.String q = "\"";
    public static final java.lang.String r = "appkey";

    /* renamed from: s, reason: collision with root package name */
    public static final java.lang.String f86s = "ty";
    public static final java.lang.String t = "sv";
    public static final java.lang.String u = "an";
    public static final java.lang.String v = "setting";
    public static final java.lang.String w = "av";
    public static final java.lang.String x = "sdk_start_time";
    public static final java.lang.String y = "extInfo";
    public static final java.lang.String z = "ap_link_token";
    public java.lang.String a;
    public java.lang.String b;
    public android.content.Context c;
    public final java.lang.String d;
    public final long e;
    public final int f;
    public final java.lang.String g;
    public boolean h = false;
    public boolean i = false;
    public boolean j = false;
    public final android.content.pm.ActivityInfo k;
    public final com.alipay.sdk.m.k.b l;

    /* renamed from: com.alipay.sdk.m.s.a$a, reason: collision with other inner class name */
    public static final class C0043a {
        public static final java.util.HashMap<java.util.UUID, com.alipay.sdk.m.s.a> a = new java.util.HashMap<>();
        public static final java.util.HashMap<java.lang.String, com.alipay.sdk.m.s.a> b = new java.util.HashMap<>();
        public static final java.lang.String c = "i_uuid_b_c";

        public static com.alipay.sdk.m.s.a a(android.content.Intent intent) {
            if (intent == null) {
                return null;
            }
            java.io.Serializable serializableExtra = intent.getSerializableExtra(c);
            if (serializableExtra instanceof java.util.UUID) {
                return a.remove((java.util.UUID) serializableExtra);
            }
            return null;
        }

        public static com.alipay.sdk.m.s.a a(java.lang.String str) {
            if (android.text.TextUtils.isEmpty(str)) {
                return null;
            }
            return b.remove(str);
        }

        public static void a(com.alipay.sdk.m.s.a aVar, android.content.Intent intent) {
            if (aVar == null || intent == null) {
                return;
            }
            java.util.UUID randomUUID = java.util.UUID.randomUUID();
            a.put(randomUUID, aVar);
            intent.putExtra(c, randomUUID);
        }

        public static void a(com.alipay.sdk.m.s.a aVar, java.lang.String str) {
            if (aVar == null || android.text.TextUtils.isEmpty(str)) {
                return;
            }
            b.put(str, aVar);
        }
    }

    public a(android.content.Context context, java.lang.String str, java.lang.String str2) {
        java.lang.String str3;
        this.a = "";
        this.b = "";
        this.c = null;
        boolean isEmpty = android.text.TextUtils.isEmpty(str2);
        this.l = new com.alipay.sdk.m.k.b(context, isEmpty);
        java.lang.String b = b(str, this.b);
        this.d = b;
        this.e = android.os.SystemClock.elapsedRealtime();
        this.f = com.alipay.sdk.m.u.n.g();
        android.content.pm.ActivityInfo a = com.alipay.sdk.m.u.n.a(context);
        this.k = a;
        this.g = str2;
        if (!isEmpty) {
            com.alipay.sdk.m.k.a.a(this, com.alipay.sdk.m.k.b.l, "eptyp", str2 + "|" + b);
            if (a != null) {
                str3 = a.name + "|" + a.launchMode;
            } else {
                str3 = com.igexin.push.core.b.m;
            }
            com.alipay.sdk.m.k.a.a(this, com.alipay.sdk.m.k.b.l, "actInfo", str3);
            com.alipay.sdk.m.k.a.a(this, com.alipay.sdk.m.k.b.l, androidx.core.app.NotificationCompat.CATEGORY_SYSTEM, com.alipay.sdk.m.u.n.a(this));
            com.alipay.sdk.m.k.a.a(this, com.alipay.sdk.m.k.b.l, "sdkv", "5c4d8f1-clean");
        }
        try {
            this.c = context.getApplicationContext();
            android.content.pm.PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            this.a = packageInfo.versionName;
            this.b = packageInfo.packageName;
        } catch (java.lang.Exception e) {
            com.alipay.sdk.m.u.e.a(e);
        }
        if (!isEmpty) {
            com.alipay.sdk.m.k.a.a(this, com.alipay.sdk.m.k.b.l, com.umeng.analytics.pro.bo.aN + com.alipay.sdk.m.u.n.g());
            com.alipay.sdk.m.k.a.a(this, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.Q, "" + android.os.SystemClock.elapsedRealtime());
            com.alipay.sdk.m.k.a.a(context, this, str, this.d);
        }
        if (isEmpty || !com.alipay.sdk.m.m.a.D().s()) {
            return;
        }
        com.alipay.sdk.m.m.a.D().a(this, this.c, true, 2);
    }

    private java.lang.String a(java.lang.String str, java.lang.String str2) {
        return str + a(new org.json.JSONObject()) + str2;
    }

    private java.lang.String a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        java.lang.String[] split = str.split(str2);
        for (int i = 0; i < split.length; i++) {
            if (!android.text.TextUtils.isEmpty(split[i]) && split[i].startsWith(str3)) {
                return split[i];
            }
        }
        return null;
    }

    public static java.util.HashMap<java.lang.String, java.lang.String> a(com.alipay.sdk.m.s.a aVar) {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        if (aVar != null) {
            hashMap.put("sdk_ver", "15.8.11");
            hashMap.put("app_name", aVar.b);
            hashMap.put("token", aVar.d);
            hashMap.put("call_type", aVar.g);
            hashMap.put("ts_api_invoke", java.lang.String.valueOf(aVar.e));
            com.alipay.sdk.m.u.a.a(aVar, hashMap);
        }
        return hashMap;
    }

    private java.lang.String b(java.lang.String str) throws org.json.JSONException {
        return a(new org.json.JSONObject(str));
    }

    public static java.lang.String b(java.lang.String str, java.lang.String str2) {
        try {
            java.util.Locale locale = java.util.Locale.getDefault();
            java.lang.Object[] objArr = new java.lang.Object[4];
            if (str == null) {
                str = "";
            }
            objArr[0] = str;
            if (str2 == null) {
                str2 = "";
            }
            objArr[1] = str2;
            objArr[2] = java.lang.Long.valueOf(java.lang.System.currentTimeMillis());
            objArr[3] = java.util.UUID.randomUUID().toString();
            return java.lang.String.format("EP%s%s_%s", "1", com.alipay.sdk.m.u.n.g(java.lang.String.format(locale, "%s%s%d%s", objArr)), java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
        } catch (java.lang.Throwable unused) {
            return com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER;
        }
    }

    private java.lang.String b(java.lang.String str, java.lang.String str2, java.lang.String str3) throws org.json.JSONException {
        org.json.JSONObject jSONObject;
        java.lang.String substring = str.substring(str2.length());
        boolean z2 = false;
        java.lang.String substring2 = substring.substring(0, substring.length() - str3.length());
        if (substring2.length() >= 2 && substring2.startsWith("\"") && substring2.endsWith("\"")) {
            jSONObject = new org.json.JSONObject(substring2.substring(1, substring2.length() - 1));
            z2 = true;
        } else {
            jSONObject = new org.json.JSONObject(substring2);
        }
        java.lang.String a = a(jSONObject);
        if (z2) {
            a = "\"" + a + "\"";
        }
        return str2 + a + str3;
    }

    private java.lang.String c(java.lang.String str) {
        try {
            java.lang.String a = a(str, "&", p);
            if (android.text.TextUtils.isEmpty(a)) {
                str = str + "&" + a(p, "");
            } else {
                int indexOf = str.indexOf(a);
                str = str.substring(0, indexOf) + b(a, p, "") + str.substring(indexOf + a.length());
            }
        } catch (java.lang.Throwable th) {
            com.alipay.sdk.m.k.a.a(this, com.alipay.sdk.m.k.b.l, "fmt1", th, str);
        }
        return str;
    }

    private java.lang.String d(java.lang.String str) {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str.substring(19));
            jSONObject.put("bizcontext", b(jSONObject.optString("bizcontext")));
            return C + jSONObject.toString();
        } catch (java.lang.Throwable unused) {
            return str;
        }
    }

    private java.lang.String e(java.lang.String str) {
        try {
            java.lang.String a = a(str, m, o);
            if (android.text.TextUtils.isEmpty(a)) {
                return str + "&" + a(o, "\"");
            }
            if (!a.endsWith("\"")) {
                a = a + "\"";
            }
            int indexOf = str.indexOf(a);
            return str.substring(0, indexOf) + b(a, o, "\"") + str.substring(indexOf + a.length());
        } catch (java.lang.Throwable th) {
            com.alipay.sdk.m.k.a.a(this, com.alipay.sdk.m.k.b.l, "fmt2", th, str);
            return str;
        }
    }

    private boolean f(java.lang.String str) {
        return !str.contains(m);
    }

    private org.json.JSONObject g() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put(z, this.d);
        } catch (java.lang.Throwable unused) {
        }
        return jSONObject;
    }

    public static com.alipay.sdk.m.s.a h() {
        return null;
    }

    public android.content.Context a() {
        return this.c;
    }

    public java.lang.String a(java.lang.String str) {
        return android.text.TextUtils.isEmpty(str) ? str : str.startsWith(C) ? d(str) : f(str) ? c(str) : e(str);
    }

    public java.lang.String a(org.json.JSONObject jSONObject) {
        java.lang.String str;
        try {
            if (!jSONObject.has("appkey")) {
                jSONObject.put("appkey", com.alipay.sdk.m.l.a.f);
            }
            if (!jSONObject.has(f86s)) {
                jSONObject.put(f86s, "and_lite");
            }
            if (!jSONObject.has("sv")) {
                jSONObject.put("sv", "h.a.3.8.11");
            }
            if (!jSONObject.has(u)) {
                jSONObject.put(u, this.b);
            }
            if (!jSONObject.has("av")) {
                jSONObject.put("av", this.a);
            }
            if (!jSONObject.has(x)) {
                jSONObject.put(x, java.lang.System.currentTimeMillis());
            }
            if (!jSONObject.has(y)) {
                jSONObject.put(y, g());
            }
            if (!jSONObject.has(A)) {
                if (this.k != null) {
                    str = this.k.name + "|" + this.k.launchMode;
                } else {
                    str = com.igexin.push.core.b.m;
                }
                jSONObject.put(A, str);
            }
            return jSONObject.toString();
        } catch (java.lang.Throwable th) {
            com.alipay.sdk.m.k.a.a(this, com.alipay.sdk.m.k.b.l, "fmt3", th, java.lang.String.valueOf(jSONObject));
            com.alipay.sdk.m.u.e.a(th);
            return jSONObject != null ? jSONObject.toString() : "{}";
        }
    }

    public void a(boolean z2) {
        this.i = z2;
    }

    public java.lang.String b() {
        return this.b;
    }

    public void b(boolean z2) {
        this.h = z2;
    }

    public java.lang.String c() {
        return this.a;
    }

    public void c(boolean z2) {
        this.j = z2;
    }

    public boolean d() {
        return this.i;
    }

    public boolean e() {
        return this.h;
    }

    public boolean f() {
        return this.j;
    }
}
