package com.anythink.core.b.a;

/* loaded from: classes12.dex */
public final class a extends com.anythink.core.common.h.a {
    public static final int a = 0;
    public static final int b = 1;
    public static final java.lang.String c = "ex_pkg";
    private int I;
    java.lang.String d;
    java.lang.String e;
    java.lang.String f;
    java.lang.String g;
    java.lang.String h;
    java.lang.String i;
    java.lang.String j;
    java.lang.String k;
    int l;
    int p;
    int q;
    java.lang.String r;

    /* renamed from: s, reason: collision with root package name */
    java.lang.String f157s;
    java.lang.String t;
    java.lang.String u;
    private int v;
    private final java.lang.String w = com.anythink.core.d.e.a.j;
    private final java.lang.String x = "request_id";
    private final java.lang.String y = "ch_info";
    private final java.lang.String z = "wf";
    private final java.lang.String A = "np";
    private final java.lang.String B = "hb_size";
    private final java.lang.String C = "last_wf";
    private final java.lang.String D = "co";
    private final java.lang.String E = com.anythink.core.d.e.a.T;
    private final java.lang.String F = "debug";
    private final java.lang.String G = "sdk_ext";
    private final java.lang.String H = "last_win";

    public a(java.lang.String str, java.lang.String str2, java.lang.String str3, java.util.List<org.json.JSONObject> list, int i, com.anythink.core.d.e eVar) {
        this.I = 0;
        this.d = str3;
        this.g = str;
        this.h = str2;
        this.v = i;
        org.json.JSONArray jSONArray = new org.json.JSONArray();
        java.util.Iterator<org.json.JSONObject> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        this.e = com.anythink.core.common.o.d.a(jSONArray.toString().getBytes());
        if (eVar != null) {
            this.l = eVar.Y();
            this.p = eVar.an();
            this.I = eVar.aN();
        }
    }

    private void d(int i) {
        this.q = i;
    }

    @Override // com.anythink.core.common.h.a
    public final int a() {
        return 1;
    }

    @Override // com.anythink.core.common.h.a
    public final java.lang.Object a(java.lang.Object obj) {
        try {
            return new org.json.JSONObject(obj.toString());
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    @Override // com.anythink.core.common.h.a
    public final void a(int i, java.lang.Object obj) {
        super.a(i, obj);
    }

    @Override // com.anythink.core.common.h.a
    public final void a(com.anythink.core.api.AdError adError) {
    }

    public final void a(com.anythink.core.b.a.b bVar) {
        java.lang.String str = bVar.a;
        if (str != null) {
            this.f = com.anythink.core.common.o.d.a(str.getBytes());
        }
        this.q = bVar.f;
        if (!android.text.TextUtils.isEmpty(bVar.b) && !android.text.TextUtils.equals("[]", bVar.b)) {
            this.i = com.anythink.core.common.o.d.a(bVar.b.getBytes());
        }
        if (!android.text.TextUtils.isEmpty(bVar.c) && !android.text.TextUtils.equals("[]", bVar.c)) {
            this.j = com.anythink.core.common.o.d.a(bVar.c.getBytes());
        }
        if (!android.text.TextUtils.isEmpty(bVar.d) && !android.text.TextUtils.equals("[]", bVar.d)) {
            this.r = com.anythink.core.common.o.d.a(bVar.d.getBytes());
        }
        if (!android.text.TextUtils.isEmpty(bVar.e) && !android.text.TextUtils.equals("[]", bVar.e)) {
            this.f157s = com.anythink.core.common.o.d.a(bVar.e.getBytes());
        }
        this.t = "";
        if (!android.text.TextUtils.isEmpty(bVar.g)) {
            this.t = com.anythink.core.common.o.d.a(bVar.g.getBytes());
        }
        if (!android.text.TextUtils.isEmpty(bVar.h)) {
            this.k = com.anythink.core.common.o.d.a(bVar.h.getBytes());
        }
        if (android.text.TextUtils.isEmpty(bVar.i) || android.text.TextUtils.equals("{}", bVar.i)) {
            return;
        }
        this.u = com.anythink.core.common.o.d.a(bVar.i.getBytes());
    }

    @Override // com.anythink.core.common.h.a
    public final boolean a(int i) {
        return false;
    }

    @Override // com.anythink.core.common.h.a
    public final java.lang.String b() {
        return this.g;
    }

    @Override // com.anythink.core.common.h.a
    public final void b(com.anythink.core.api.AdError adError) {
    }

    @Override // com.anythink.core.common.h.a
    public final java.util.Map<java.lang.String, java.lang.String> c() {
        java.util.HashMap hashMap = new java.util.HashMap();
        if (this.v == 0) {
            hashMap.put(com.google.common.net.HttpHeaders.ACCEPT_ENCODING, "gzip");
        }
        hashMap.put("Content-Type", "application/json;charset=utf-8");
        return hashMap;
    }

    @Override // com.anythink.core.common.h.a
    public final byte[] d() {
        return g().getBytes();
    }

    @Override // com.anythink.core.common.h.a
    public final org.json.JSONObject e() {
        com.anythink.core.d.e b2;
        org.json.JSONObject aH;
        org.json.JSONObject a2;
        org.json.JSONObject e = super.e();
        try {
            e.put("app_id", com.anythink.core.common.b.o.a().o());
            e.put("pl_id", this.h);
            e.put("session_id", com.anythink.core.common.b.o.a().g(this.h));
            e.put("t_g_id", this.l);
            e.put("gro_id", this.p);
            java.lang.String y = com.anythink.core.common.b.o.a().y();
            if (!android.text.TextUtils.isEmpty(y)) {
                e.put("sy_id", y);
            }
            java.lang.String z = com.anythink.core.common.b.o.a().z();
            if (android.text.TextUtils.isEmpty(z)) {
                com.anythink.core.common.b.o.a().k(com.anythink.core.common.b.o.a().x());
                e.put("bk_id", com.anythink.core.common.b.o.a().x());
            } else {
                e.put("bk_id", z);
            }
            if (com.anythink.core.common.b.o.a().b() != null) {
                e.put("deny", com.anythink.core.common.o.e.p(com.anythink.core.common.b.o.a().f()));
            }
            if (this.v == 0) {
                e.put("misk_spt", com.anythink.core.common.o.a().c());
                com.anythink.core.common.o.a();
                e.put("misk_pt_det", com.anythink.core.common.o.b());
            }
            e.put(com.anythink.core.common.h.c.ap, com.anythink.core.common.l.a().c());
            org.json.JSONObject a3 = com.anythink.core.common.h.c.a(this.h);
            if (a3 != null) {
                e.put("customs", a3);
            }
            com.anythink.core.common.h.c.a(e);
            com.anythink.core.d.f a4 = com.anythink.core.d.f.a(com.anythink.core.common.b.o.a().f());
            java.lang.String str = this.h;
            if (!android.text.TextUtils.isEmpty(str)) {
                try {
                    if (!android.text.TextUtils.isEmpty(str) && (b2 = a4.b(str)) != null && (aH = b2.aH()) != null) {
                        e.put(com.anythink.core.d.e.a.ab, aH);
                    }
                } catch (java.lang.Exception unused) {
                }
            }
            if (this.I > 0 && (a2 = com.anythink.core.c.b.a().a(this.h, this.I)) != null) {
                e.put(com.anythink.core.common.h.c.av, a2);
            }
        } catch (java.lang.Exception unused2) {
        }
        return e;
    }

    @Override // com.anythink.core.common.h.a
    public final org.json.JSONObject f() {
        org.json.JSONObject f = super.f();
        try {
            if (com.anythink.core.common.b.o.a().b() != null) {
                f.put("btts", com.anythink.core.common.o.e.g());
            }
        } catch (org.json.JSONException unused) {
        }
        return f;
    }

    @Override // com.anythink.core.common.h.a
    public final java.lang.String g() {
        java.util.HashMap hashMap = new java.util.HashMap();
        java.lang.String a2 = com.anythink.core.common.o.d.a(e().toString());
        java.lang.String a3 = com.anythink.core.common.o.d.a(f().toString());
        hashMap.put("p", a2);
        hashMap.put(com.anythink.core.common.h.c.X, a3);
        hashMap.put(com.anythink.core.d.e.a.j, this.e);
        hashMap.put("request_id", this.d);
        int i = this.q;
        if (i > 0) {
            hashMap.put("hb_size", java.lang.Integer.valueOf(i));
        }
        if (this.v == 0) {
            if (!android.text.TextUtils.isEmpty(this.f)) {
                hashMap.put("ch_info", this.f);
            }
            if (!android.text.TextUtils.isEmpty(this.i)) {
                hashMap.put("wf", this.i);
            }
            if (!android.text.TextUtils.isEmpty(this.j)) {
                hashMap.put("np", this.j);
            }
            if (!android.text.TextUtils.isEmpty(this.r)) {
                hashMap.put("last_wf", this.r);
            }
            if (!android.text.TextUtils.isEmpty(this.f157s)) {
                hashMap.put("co", this.f157s);
            }
            hashMap.put(com.anythink.core.d.e.a.T, this.t);
            if (com.anythink.core.common.b.o.a().k() != null) {
                hashMap.put(c, com.anythink.core.common.o.d.a(com.anythink.core.common.b.o.a().k().toString()));
            }
            if (com.anythink.core.common.b.o.a().A() && com.anythink.core.common.b.o.a().u()) {
                hashMap.put("debug", 1);
            }
            if (!android.text.TextUtils.isEmpty(this.k)) {
                hashMap.put("sdk_ext", this.k);
            }
            if (!android.text.TextUtils.isEmpty(this.u)) {
                hashMap.put("last_win", this.u);
            }
        }
        java.util.Set<java.lang.String> keySet = hashMap.keySet();
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            for (java.lang.String str : keySet) {
                jSONObject.put(str, hashMap.get(str));
            }
            return jSONObject.toString();
        } catch (java.lang.Exception unused) {
            return null;
        } catch (java.lang.OutOfMemoryError unused2) {
            java.lang.System.gc();
            return null;
        }
    }

    @Override // com.anythink.core.common.h.a
    public final java.lang.String h() {
        return null;
    }

    @Override // com.anythink.core.common.h.a
    public final android.content.Context i() {
        return null;
    }

    @Override // com.anythink.core.common.h.a
    public final java.lang.String j() {
        return null;
    }

    @Override // com.anythink.core.common.h.a
    public final java.util.Map<java.lang.String, java.lang.Object> k() {
        return null;
    }

    @Override // com.anythink.core.common.h.a
    public final int l() {
        return 54;
    }
}
