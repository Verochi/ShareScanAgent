package com.xiaomi.mipush.sdk;

/* loaded from: classes19.dex */
public class b {
    private static volatile com.xiaomi.mipush.sdk.b a;

    /* renamed from: a, reason: collision with other field name */
    private android.content.Context f40a;

    /* renamed from: a, reason: collision with other field name */
    private com.xiaomi.mipush.sdk.b.a f41a;

    /* renamed from: a, reason: collision with other field name */
    java.lang.String f42a;

    /* renamed from: a, reason: collision with other field name */
    private java.util.Map<java.lang.String, com.xiaomi.mipush.sdk.b.a> f43a;

    public static class a {

        /* renamed from: a, reason: collision with other field name */
        private android.content.Context f44a;

        /* renamed from: a, reason: collision with other field name */
        public java.lang.String f45a;
        public java.lang.String b;
        public java.lang.String c;
        public java.lang.String d;
        public java.lang.String e;
        public java.lang.String f;
        public java.lang.String g;
        public java.lang.String h;

        /* renamed from: a, reason: collision with other field name */
        public boolean f46a = true;

        /* renamed from: b, reason: collision with other field name */
        public boolean f47b = false;
        public int a = 1;

        public a(android.content.Context context) {
            this.f44a = context;
        }

        public static com.xiaomi.mipush.sdk.b.a a(android.content.Context context, java.lang.String str) {
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject(str);
                com.xiaomi.mipush.sdk.b.a aVar = new com.xiaomi.mipush.sdk.b.a(context);
                aVar.f45a = jSONObject.getString(com.anythink.expressad.videocommon.e.b.u);
                aVar.b = jSONObject.getString("appToken");
                aVar.c = jSONObject.getString("regId");
                aVar.d = jSONObject.getString("regSec");
                aVar.f = jSONObject.getString("devId");
                aVar.e = jSONObject.getString("vName");
                aVar.f46a = jSONObject.getBoolean("valid");
                aVar.f47b = jSONObject.getBoolean("paused");
                aVar.a = jSONObject.getInt("envType");
                aVar.g = jSONObject.getString("regResource");
                return aVar;
            } catch (java.lang.Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.a(th);
                return null;
            }
        }

        private java.lang.String a() {
            android.content.Context context = this.f44a;
            return com.xiaomi.push.ga.a(context, context.getPackageName());
        }

        public static java.lang.String a(com.xiaomi.mipush.sdk.b.a aVar) {
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                jSONObject.put(com.anythink.expressad.videocommon.e.b.u, aVar.f45a);
                jSONObject.put("appToken", aVar.b);
                jSONObject.put("regId", aVar.c);
                jSONObject.put("regSec", aVar.d);
                jSONObject.put("devId", aVar.f);
                jSONObject.put("vName", aVar.e);
                jSONObject.put("valid", aVar.f46a);
                jSONObject.put("paused", aVar.f47b);
                jSONObject.put("envType", aVar.a);
                jSONObject.put("regResource", aVar.g);
                return jSONObject.toString();
            } catch (java.lang.Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.a(th);
                return null;
            }
        }

        /* renamed from: a, reason: collision with other method in class */
        public void m139a() {
            com.xiaomi.mipush.sdk.b.a(this.f44a).edit().clear().commit();
            this.f45a = null;
            this.b = null;
            this.c = null;
            this.d = null;
            this.f = null;
            this.e = null;
            this.f46a = false;
            this.f47b = false;
            this.h = null;
            this.a = 1;
        }

        public void a(int i) {
            this.a = i;
        }

        public void a(java.lang.String str, java.lang.String str2) {
            this.c = str;
            this.d = str2;
            this.f = com.xiaomi.push.ib.h(this.f44a);
            this.e = a();
            this.f46a = true;
        }

        public void a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
            this.f45a = str;
            this.b = str2;
            this.g = str3;
            android.content.SharedPreferences.Editor edit = com.xiaomi.mipush.sdk.b.a(this.f44a).edit();
            edit.putString(com.anythink.expressad.videocommon.e.b.u, this.f45a);
            edit.putString("appToken", str2);
            edit.putString("regResource", str3);
            edit.commit();
        }

        public void a(boolean z) {
            this.f47b = z;
        }

        /* renamed from: a, reason: collision with other method in class */
        public boolean m140a() {
            return m141a(this.f45a, this.b);
        }

        /* renamed from: a, reason: collision with other method in class */
        public boolean m141a(java.lang.String str, java.lang.String str2) {
            boolean equals = android.text.TextUtils.equals(this.f45a, str);
            boolean equals2 = android.text.TextUtils.equals(this.b, str2);
            boolean z = !android.text.TextUtils.isEmpty(this.c);
            boolean z2 = !android.text.TextUtils.isEmpty(this.d);
            boolean z3 = android.text.TextUtils.equals(this.f, com.xiaomi.push.ib.h(this.f44a)) || android.text.TextUtils.equals(this.f, com.xiaomi.push.ib.g(this.f44a));
            boolean z4 = equals && equals2 && z && z2 && z3;
            if (!z4) {
                com.xiaomi.channel.commonutils.logger.b.f(java.lang.String.format("register invalid, aid=%s;atn=%s;rid=%s;rse=%s;did=%s", java.lang.Boolean.valueOf(equals), java.lang.Boolean.valueOf(equals2), java.lang.Boolean.valueOf(z), java.lang.Boolean.valueOf(z2), java.lang.Boolean.valueOf(z3)));
            }
            return z4;
        }

        public void b() {
            this.f46a = false;
            com.xiaomi.mipush.sdk.b.a(this.f44a).edit().putBoolean("valid", this.f46a).commit();
        }

        public void b(java.lang.String str, java.lang.String str2, java.lang.String str3) {
            this.c = str;
            this.d = str2;
            this.f = com.xiaomi.push.ib.h(this.f44a);
            this.e = a();
            this.f46a = true;
            this.h = str3;
            android.content.SharedPreferences.Editor edit = com.xiaomi.mipush.sdk.b.a(this.f44a).edit();
            edit.putString("regId", str);
            edit.putString("regSec", str2);
            edit.putString("devId", this.f);
            edit.putString("vName", a());
            edit.putBoolean("valid", true);
            edit.putString("appRegion", str3);
            edit.commit();
        }

        public void c(java.lang.String str, java.lang.String str2, java.lang.String str3) {
            this.f45a = str;
            this.b = str2;
            this.g = str3;
        }
    }

    private b(android.content.Context context) {
        this.f40a = context;
        c();
    }

    public static android.content.SharedPreferences a(android.content.Context context) {
        return context.getSharedPreferences("mipush", 0);
    }

    /* renamed from: a, reason: collision with other method in class */
    public static com.xiaomi.mipush.sdk.b m126a(android.content.Context context) {
        if (a == null) {
            synchronized (com.xiaomi.mipush.sdk.b.class) {
                if (a == null) {
                    a = new com.xiaomi.mipush.sdk.b(context);
                }
            }
        }
        return a;
    }

    private void c() {
        this.f41a = new com.xiaomi.mipush.sdk.b.a(this.f40a);
        this.f43a = new java.util.HashMap();
        android.content.SharedPreferences a2 = a(this.f40a);
        this.f41a.f45a = a2.getString(com.anythink.expressad.videocommon.e.b.u, null);
        this.f41a.b = a2.getString("appToken", null);
        this.f41a.c = a2.getString("regId", null);
        this.f41a.d = a2.getString("regSec", null);
        this.f41a.f = a2.getString("devId", null);
        if (!android.text.TextUtils.isEmpty(this.f41a.f) && com.xiaomi.push.ib.a(this.f41a.f)) {
            this.f41a.f = com.xiaomi.push.ib.h(this.f40a);
            a2.edit().putString("devId", this.f41a.f).commit();
        }
        this.f41a.e = a2.getString("vName", null);
        this.f41a.f46a = a2.getBoolean("valid", true);
        this.f41a.f47b = a2.getBoolean("paused", false);
        this.f41a.a = a2.getInt("envType", 1);
        this.f41a.g = a2.getString("regResource", null);
        this.f41a.h = a2.getString("appRegion", null);
    }

    public int a() {
        return this.f41a.a;
    }

    public com.xiaomi.mipush.sdk.b.a a(java.lang.String str) {
        if (this.f43a.containsKey(str)) {
            return this.f43a.get(str);
        }
        java.lang.String concat = "hybrid_app_info_".concat(java.lang.String.valueOf(str));
        android.content.SharedPreferences a2 = a(this.f40a);
        if (!a2.contains(concat)) {
            return null;
        }
        com.xiaomi.mipush.sdk.b.a a3 = com.xiaomi.mipush.sdk.b.a.a(this.f40a, a2.getString(concat, ""));
        this.f43a.put(concat, a3);
        return a3;
    }

    /* renamed from: a, reason: collision with other method in class */
    public java.lang.String m127a() {
        return this.f41a.f45a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m128a() {
        this.f41a.m139a();
    }

    public void a(int i) {
        this.f41a.a(i);
        a(this.f40a).edit().putInt("envType", i).commit();
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m129a(java.lang.String str) {
        android.content.SharedPreferences.Editor edit = a(this.f40a).edit();
        edit.putString("vName", str);
        edit.commit();
        this.f41a.e = str;
    }

    public void a(java.lang.String str, com.xiaomi.mipush.sdk.b.a aVar) {
        this.f43a.put(str, aVar);
        java.lang.String a2 = com.xiaomi.mipush.sdk.b.a.a(aVar);
        a(this.f40a).edit().putString("hybrid_app_info_".concat(java.lang.String.valueOf(str)), a2).commit();
    }

    public void a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        this.f41a.a(str, str2, str3);
    }

    public void a(boolean z) {
        this.f41a.a(z);
        a(this.f40a).edit().putBoolean("paused", z).commit();
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m130a() {
        android.content.Context context = this.f40a;
        return !android.text.TextUtils.equals(com.xiaomi.push.ga.a(context, context.getPackageName()), this.f41a.e);
    }

    public boolean a(java.lang.String str, java.lang.String str2) {
        return this.f41a.m141a(str, str2);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m131a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        com.xiaomi.mipush.sdk.b.a a2 = a(str3);
        return a2 != null && android.text.TextUtils.equals(str, a2.f45a) && android.text.TextUtils.equals(str2, a2.b);
    }

    public java.lang.String b() {
        return this.f41a.b;
    }

    /* renamed from: b, reason: collision with other method in class */
    public void m132b() {
        this.f41a.b();
    }

    public void b(java.lang.String str) {
        this.f43a.remove(str);
        a(this.f40a).edit().remove("hybrid_app_info_".concat(java.lang.String.valueOf(str))).commit();
    }

    public void b(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        this.f41a.b(str, str2, str3);
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m133b() {
        if (this.f41a.m140a()) {
            return true;
        }
        com.xiaomi.channel.commonutils.logger.b.a("Don't send message before initialization succeeded!");
        return false;
    }

    /* renamed from: c, reason: collision with other method in class */
    public java.lang.String m134c() {
        return this.f41a.c;
    }

    /* renamed from: c, reason: collision with other method in class */
    public boolean m135c() {
        return this.f41a.m140a();
    }

    public java.lang.String d() {
        return this.f41a.d;
    }

    /* renamed from: d, reason: collision with other method in class */
    public boolean m136d() {
        return (android.text.TextUtils.isEmpty(this.f41a.f45a) || android.text.TextUtils.isEmpty(this.f41a.b) || android.text.TextUtils.isEmpty(this.f41a.c) || android.text.TextUtils.isEmpty(this.f41a.d)) ? false : true;
    }

    public java.lang.String e() {
        return this.f41a.g;
    }

    /* renamed from: e, reason: collision with other method in class */
    public boolean m137e() {
        return this.f41a.f47b;
    }

    public java.lang.String f() {
        return this.f41a.h;
    }

    /* renamed from: f, reason: collision with other method in class */
    public boolean m138f() {
        return !this.f41a.f46a;
    }
}
