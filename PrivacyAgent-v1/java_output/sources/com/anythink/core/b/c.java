package com.anythink.core.b;

/* loaded from: classes12.dex */
public final class c extends com.anythink.core.b.e {
    java.lang.String a;
    java.util.List<com.anythink.core.common.f.au> b;
    java.util.List<com.anythink.core.common.f.au> c;
    boolean d;
    boolean e;

    public c(com.anythink.core.common.f.a aVar, java.util.List<com.anythink.core.common.f.au> list) {
        super(aVar);
        this.a = com.anythink.core.common.o.h.a(aVar.b, this.n, this.o, aVar.f, 0).toString();
        com.anythink.core.common.p.h hVar = aVar.y;
        this.b = hVar != null ? hVar.a() : null;
        this.c = list != null ? new java.util.ArrayList(list) : null;
    }

    private void a(java.lang.String str, java.lang.String str2) {
        java.lang.String str3;
        boolean z;
        java.lang.Boolean bool;
        int b = com.anythink.core.common.v.a(this.f.b).b(this.f.e);
        com.anythink.core.common.f.ap apVar = this.f.w;
        if (apVar != null) {
            bool = apVar.c();
            str3 = this.f.w.a();
            z = this.f.w.b();
        } else {
            str3 = "";
            z = true;
            bool = null;
        }
        com.anythink.core.common.f.a aVar = this.f;
        com.anythink.core.common.f.h hVar = aVar.f167s;
        int i = aVar.c.d;
        int i2 = aVar.t;
        boolean z2 = this.d;
        boolean z3 = this.e;
        boolean a = com.anythink.core.common.o.i.a(aVar.b);
        com.anythink.core.common.f.k kVar = new com.anythink.core.common.f.k(hVar.ae(), null);
        kVar.a = "1004684";
        kVar.b = hVar.ad();
        kVar.d = hVar.ac();
        kVar.k = java.lang.String.valueOf(i);
        kVar.m = java.lang.String.valueOf(b);
        kVar.n = java.lang.String.valueOf(hVar.ae());
        kVar.o = z ? "1" : "2";
        kVar.p = java.lang.String.valueOf(i2);
        if (!android.text.TextUtils.isEmpty(str2)) {
            kVar.q = str2;
        }
        if (!android.text.TextUtils.isEmpty(str)) {
            kVar.r = str;
        }
        kVar.f171s = bool == null ? "0" : bool.booleanValue() ? "1" : "2";
        kVar.t = str3;
        kVar.u = z2 ? "1" : "2";
        kVar.v = z3 ? "1" : "2";
        kVar.w = java.lang.String.valueOf(i);
        kVar.x = a ? "1" : "2";
        com.anythink.core.common.n.c.b(kVar);
    }

    private void a(org.json.JSONArray jSONArray) {
        java.util.List<com.anythink.core.common.f.au> list = this.c;
        if (list != null) {
            java.util.Iterator<com.anythink.core.common.f.au> it = list.iterator();
            while (it.hasNext()) {
                java.util.List<com.anythink.core.common.f.ay.a> a = com.anythink.core.common.o.v.a(this.o, it.next());
                if (a != null && a.size() > 0) {
                    java.util.Iterator<com.anythink.core.common.f.ay.a> it2 = a.iterator();
                    while (it2.hasNext()) {
                        jSONArray.put(it2.next().a());
                    }
                }
            }
        }
        java.util.List<com.anythink.core.common.f.au> list2 = this.b;
        if (list2 != null) {
            java.util.Iterator<com.anythink.core.common.f.au> it3 = list2.iterator();
            while (it3.hasNext()) {
                java.util.List<com.anythink.core.common.f.ay.a> a2 = com.anythink.core.common.o.v.a(this.o, it3.next());
                if (a2 != null && a2.size() > 0) {
                    java.util.Iterator<com.anythink.core.common.f.ay.a> it4 = a2.iterator();
                    while (it4.hasNext()) {
                        jSONArray.put(it4.next().a());
                    }
                }
            }
        }
    }

    private void b(org.json.JSONArray jSONArray) {
        com.anythink.core.common.p.h hVar = this.f.y;
        java.util.List<com.anythink.core.common.f.au> a = hVar != null ? hVar.a() : null;
        if (a != null) {
            int size = a.size();
            for (int i = 0; i < size; i++) {
                com.anythink.core.common.f.au auVar = a.get(i);
                if (!auVar.Z()) {
                    try {
                        org.json.JSONObject jSONObject = new org.json.JSONObject();
                        jSONObject.put("ad_source_id", auVar.u());
                        jSONObject.put(com.anythink.core.c.b.d.a.h, auVar.y());
                        com.anythink.core.common.f.q M = auVar.M();
                        if (M != null) {
                            jSONObject.put("tp_bid_id", M.g);
                        }
                        jSONObject.put(com.anythink.core.common.j.ao, auVar.af());
                        jSONArray.put(jSONObject);
                    } catch (java.lang.Throwable th) {
                        th.printStackTrace();
                    }
                }
            }
        }
    }

    private java.lang.String f() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put(com.alipay.sdk.m.x.d.w, this.f.f167s.K());
        } catch (java.lang.Throwable unused) {
        }
        return jSONObject.toString();
    }

    @Override // com.anythink.core.b.e, com.anythink.core.b.d
    public final void a(com.anythink.core.common.f.au auVar, com.anythink.core.common.f.o oVar, long j) {
        super.a(auVar, oVar, j);
    }

    @Override // com.anythink.core.b.e
    public final void a(java.util.List<org.json.JSONObject> list, com.anythink.core.common.h.k kVar) {
        java.lang.String str;
        boolean z;
        java.lang.String str2;
        java.lang.Boolean bool;
        org.json.JSONArray jSONArray = new org.json.JSONArray();
        org.json.JSONArray jSONArray2 = new org.json.JSONArray();
        b(jSONArray2);
        a(jSONArray);
        com.anythink.core.b.a.b bVar = new com.anythink.core.b.a.b();
        bVar.a = this.a;
        bVar.b = jSONArray2.toString();
        bVar.f = this.f.n.a().aC();
        java.lang.String jSONArray3 = jSONArray.length() > 0 ? jSONArray.toString() : "";
        com.anythink.core.common.f.ay ayVar = this.f.v;
        if (ayVar != null) {
            str = ayVar.a().toString();
            bVar.d = str;
        } else {
            str = "";
        }
        bVar.e = jSONArray3;
        bVar.g = this.f.n.a().q();
        bVar.h = f();
        com.anythink.core.common.f.p pVar = this.f.x;
        bVar.i = pVar != null ? pVar.f() : "";
        int b = com.anythink.core.common.v.a(this.f.b).b(this.f.e);
        com.anythink.core.common.f.ap apVar = this.f.w;
        if (apVar != null) {
            bool = apVar.c();
            str2 = this.f.w.a();
            z = this.f.w.b();
        } else {
            z = true;
            str2 = "";
            bool = null;
        }
        com.anythink.core.common.f.a aVar = this.f;
        com.anythink.core.common.f.h hVar = aVar.f167s;
        int i = aVar.c.d;
        int i2 = aVar.t;
        boolean z2 = this.d;
        boolean z3 = this.e;
        boolean a = com.anythink.core.common.o.i.a(aVar.b);
        com.anythink.core.common.f.k kVar2 = new com.anythink.core.common.f.k(hVar.ae(), null);
        kVar2.a = "1004684";
        kVar2.b = hVar.ad();
        kVar2.d = hVar.ac();
        kVar2.k = java.lang.String.valueOf(i);
        kVar2.m = java.lang.String.valueOf(b);
        kVar2.n = java.lang.String.valueOf(hVar.ae());
        kVar2.o = z ? "1" : "2";
        kVar2.p = java.lang.String.valueOf(i2);
        if (!android.text.TextUtils.isEmpty(jSONArray3)) {
            kVar2.q = jSONArray3;
        }
        if (!android.text.TextUtils.isEmpty(str)) {
            kVar2.r = str;
        }
        kVar2.f171s = bool == null ? "0" : bool.booleanValue() ? "1" : "2";
        kVar2.t = str2;
        kVar2.u = z2 ? "1" : "2";
        kVar2.v = z3 ? "1" : "2";
        kVar2.w = java.lang.String.valueOf(i);
        kVar2.x = a ? "1" : "2";
        com.anythink.core.common.n.c.b(kVar2);
        com.anythink.core.b.a.a aVar2 = new com.anythink.core.b.a.a(this.p, this.o, this.n, list, 0, this.f.n.a());
        aVar2.a(bVar);
        aVar2.a(0, kVar);
    }

    @Override // com.anythink.core.b.e
    public final synchronized void a(java.util.List<org.json.JSONObject> list, java.util.Map<java.lang.String, com.anythink.core.common.f.au> map) {
        super.a(list, map);
        com.anythink.core.common.v.a(this.f.b).a(this.f.e);
        this.d = false;
        this.e = false;
        try {
            java.util.Iterator<java.util.Map.Entry<java.lang.String, com.anythink.core.common.f.au>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                try {
                    com.anythink.core.common.f.au value = it.next().getValue();
                    if (value.d() == 66) {
                        this.d = true;
                    } else if (value.d() == 6) {
                        this.e = true;
                    }
                } catch (java.lang.Throwable unused) {
                }
            }
        } catch (java.lang.Throwable unused2) {
        }
    }

    @Override // com.anythink.core.b.e
    public final java.lang.String b() {
        return this.f.l;
    }
}
