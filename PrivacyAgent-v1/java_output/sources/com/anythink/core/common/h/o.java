package com.anythink.core.common.h;

/* loaded from: classes12.dex */
public class o extends com.anythink.core.common.h.a {
    public static final int a = 1;
    public static final int b = 2;
    public static final int c = 3;
    public static final int d = 4;
    public static final int e = 5;
    public static final int f = 6;
    public static final int g = 7;
    public static final int h = 8;
    public static final int i = 9;
    public static final int j = 10;
    public static final int k = 11;
    public static final int l = 12;
    public static final int p = 13;
    public static final int q = 15;
    public static final int r = 16;

    /* renamed from: s, reason: collision with root package name */
    public static final int f178s = 18;
    public static final int t = 19;
    public static final int u = 20;
    public static final int v = 21;
    private static final java.lang.String x = "o";
    private java.util.List<com.anythink.core.common.f.i> B;
    private com.anythink.core.common.f.i C;
    private int D;
    private android.content.Context y;
    boolean w = false;
    private java.lang.String z = com.anythink.core.common.b.o.a().o();
    private java.lang.String A = com.anythink.core.common.b.o.a().p();

    public o(android.content.Context context, int i2, java.util.List<com.anythink.core.common.f.i> list) {
        this.y = context;
        this.D = i2;
        this.B = list;
    }

    private void a(org.json.JSONObject jSONObject) {
        if (!this.w || jSONObject == null) {
            return;
        }
        try {
            jSONObject.put(com.anythink.core.common.h.c.U, 1);
        } catch (org.json.JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.anythink.core.common.h.a
    public final int a() {
        return 1;
    }

    @Override // com.anythink.core.common.h.a
    public final java.lang.Object a(java.lang.Object obj) {
        return obj;
    }

    @Override // com.anythink.core.common.h.a
    public final void a(com.anythink.core.api.AdError adError) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        java.util.Map<java.lang.String, java.lang.String> c2 = c();
        if (c2 != null) {
            try {
                for (java.lang.String str : c2.keySet()) {
                    jSONObject.put(str, c2.get(str));
                }
            } catch (java.lang.Exception unused) {
            }
        }
        java.lang.String jSONObject2 = jSONObject.toString();
        this.w = true;
        java.lang.String g2 = g();
        this.w = false;
        com.anythink.core.common.t.a().a(1, b(), jSONObject2, g2, com.anythink.core.common.f.u.a(1000));
    }

    @Override // com.anythink.core.common.h.a
    public final boolean a(int i2) {
        return false;
    }

    @Override // com.anythink.core.common.h.a
    public final java.lang.String b() {
        com.anythink.core.common.f.i iVar = this.C;
        if (iVar != null) {
            return iVar.b.an;
        }
        com.anythink.core.common.h.a();
        return com.anythink.core.common.h.j();
    }

    @Override // com.anythink.core.common.h.a
    public final void b(com.anythink.core.api.AdError adError) {
        java.util.List<com.anythink.core.common.f.i> list = this.B;
        com.anythink.core.common.n.c.a("tk", adError.getPlatformCode(), adError.getPlatformMSG(), b(), (java.lang.String) null, java.lang.String.valueOf(list != null ? list.size() : 1), "0");
    }

    @Override // com.anythink.core.common.h.a
    public final java.util.Map<java.lang.String, java.lang.String> c() {
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put("Content-Encoding", "gzip");
        hashMap.put("Content-Type", "application/json;charset=utf-8");
        return hashMap;
    }

    @Override // com.anythink.core.common.h.a
    public final byte[] d() {
        return com.anythink.core.common.h.a.b(g());
    }

    @Override // com.anythink.core.common.h.a
    public final org.json.JSONObject e() {
        org.json.JSONObject e2 = super.e();
        org.json.JSONObject f2 = super.f();
        try {
            e2.put("app_id", this.z);
            e2.put(com.anythink.core.common.h.c.T, this.D);
            java.util.Iterator<java.lang.String> keys = f2.keys();
            while (keys.hasNext()) {
                java.lang.String next = keys.next();
                e2.put(next, f2.opt(next));
            }
            java.util.Map<java.lang.String, java.lang.Object> l2 = com.anythink.core.common.b.o.a().l();
            if (l2 != null && l2.size() > 0) {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                for (java.lang.String str : l2.keySet()) {
                    java.lang.Object obj = l2.get(str);
                    if (obj != null) {
                        jSONObject.put(str, obj.toString());
                    }
                }
                e2.put("custom", jSONObject);
            }
        } catch (java.lang.Throwable unused) {
        }
        return e2;
    }

    @Override // com.anythink.core.common.h.a
    public final java.lang.String g() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        java.lang.String a2 = com.anythink.core.common.o.d.a(e().toString());
        org.json.JSONArray jSONArray = new org.json.JSONArray();
        java.util.List<com.anythink.core.common.f.i> list = this.B;
        if (list != null) {
            java.util.Iterator<com.anythink.core.common.f.i> it = list.iterator();
            while (it.hasNext()) {
                org.json.JSONObject a3 = it.next().a();
                a(a3);
                jSONArray.put(a3);
            }
        } else {
            com.anythink.core.common.f.i iVar = this.C;
            if (iVar != null) {
                org.json.JSONObject a4 = iVar.a();
                a(a4);
                jSONArray.put(a4);
            }
        }
        java.lang.String a5 = com.anythink.core.common.o.d.a(jSONArray.toString());
        java.lang.String c2 = com.anythink.core.common.o.g.c(this.A + "api_ver=1.0&common=" + a2 + "&data=" + a5);
        try {
            jSONObject.put("common", a2);
            jSONObject.put("data", a5);
            jSONObject.put(com.anythink.core.common.h.c.O, "1.0");
            jSONObject.put("sign", c2);
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    @Override // com.anythink.core.common.h.a
    public final java.lang.String h() {
        return this.z;
    }

    @Override // com.anythink.core.common.h.a
    public final android.content.Context i() {
        return this.y;
    }

    @Override // com.anythink.core.common.h.a
    public final java.lang.String j() {
        return this.A;
    }

    @Override // com.anythink.core.common.h.a
    public final java.util.Map<java.lang.String, java.lang.Object> k() {
        return null;
    }

    @Override // com.anythink.core.common.h.a
    public final int l() {
        return 6;
    }

    @Override // com.anythink.core.common.h.a
    public final boolean o() {
        return true;
    }
}
