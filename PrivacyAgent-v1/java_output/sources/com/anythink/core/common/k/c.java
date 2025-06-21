package com.anythink.core.common.k;

/* loaded from: classes12.dex */
public final class c extends com.anythink.core.common.h.a {
    private android.content.Context b;
    private int c;
    private java.lang.String f;
    private com.anythink.core.common.f.h g;
    private com.anythink.core.d.e h;
    private java.lang.String i;
    private java.lang.String j;
    boolean a = false;
    private java.lang.String d = com.anythink.core.common.b.o.a().o();
    private java.lang.String e = com.anythink.core.common.b.o.a().p();

    /* renamed from: com.anythink.core.common.k.c$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.core.common.k.c cVar = com.anythink.core.common.k.c.this;
            cVar.a(0, ((com.anythink.core.common.h.a) cVar).m);
        }
    }

    public c(android.content.Context context, int i, java.lang.String str, com.anythink.core.common.f.h hVar, com.anythink.core.d.e eVar, java.lang.String str2, java.lang.String str3) {
        this.b = context;
        this.c = i;
        this.g = hVar;
        this.h = eVar;
        this.i = str2;
        this.j = str3;
        this.f = str;
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
    }

    @Override // com.anythink.core.common.h.a
    public final boolean a(int i) {
        return false;
    }

    @Override // com.anythink.core.common.h.a
    public final java.lang.String b() {
        com.anythink.core.common.h.a();
        return com.anythink.core.common.h.i();
    }

    @Override // com.anythink.core.common.h.a
    public final void b(com.anythink.core.api.AdError adError) {
        try {
            if (com.anythink.core.api.ErrorCode.httpStatuException.equals(adError.getCode())) {
                com.anythink.core.common.n.c.a(this.i, this.j, this.g, this.h, adError.getPlatformCode(), adError.getPlatformMSG());
            } else if (this.a) {
                com.anythink.core.common.n.c.a(this.i, this.j, this.g, this.h, adError.getPlatformCode(), adError.getPlatformMSG());
            } else {
                this.a = true;
                com.anythink.core.common.o.b.b.a().a((java.lang.Runnable) new com.anythink.core.common.k.c.AnonymousClass1(), 5000L);
            }
        } catch (java.lang.Throwable unused) {
        }
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
        org.json.JSONObject e = super.e();
        org.json.JSONObject f = super.f();
        try {
            e.put("app_id", this.d);
            java.util.Iterator<java.lang.String> keys = f.keys();
            while (keys.hasNext()) {
                java.lang.String next = keys.next();
                e.put(next, f.opt(next));
            }
            java.util.Map<java.lang.String, java.lang.Object> l = com.anythink.core.common.b.o.a().l();
            if (l != null && l.size() > 0) {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                for (java.lang.String str : l.keySet()) {
                    java.lang.Object obj = l.get(str);
                    if (obj != null) {
                        jSONObject.put(str, obj.toString());
                    }
                }
                e.put("custom", jSONObject);
            }
        } catch (java.lang.Throwable unused) {
        }
        return e;
    }

    @Override // com.anythink.core.common.h.a
    public final java.lang.String g() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        java.lang.String a = com.anythink.core.common.o.d.a(e().toString());
        java.lang.String c = com.anythink.core.common.o.g.c(this.e + "api_ver=2.0&common=" + a + "&data=" + this.f + "&ss_a=" + this.c);
        try {
            jSONObject.put("common", a);
            jSONObject.put("ss_a", this.c);
            jSONObject.put("data", this.f);
            jSONObject.put(com.anythink.core.common.h.c.O, "2.0");
            jSONObject.put("sign", c);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    @Override // com.anythink.core.common.h.a
    public final java.lang.String h() {
        return this.d;
    }

    @Override // com.anythink.core.common.h.a
    public final android.content.Context i() {
        return this.b;
    }

    @Override // com.anythink.core.common.h.a
    public final java.lang.String j() {
        return this.e;
    }

    @Override // com.anythink.core.common.h.a
    public final java.util.Map<java.lang.String, java.lang.Object> k() {
        return null;
    }

    @Override // com.anythink.core.common.h.a
    public final java.lang.String m() {
        return "2.0";
    }
}
