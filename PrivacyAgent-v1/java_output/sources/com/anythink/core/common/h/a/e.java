package com.anythink.core.common.h.a;

/* loaded from: classes12.dex */
public final class e extends com.anythink.core.common.h.a.c {
    java.util.List<com.anythink.core.common.f.i> a;
    boolean b;
    private final java.lang.String c = com.anythink.core.common.h.a.e.class.getSimpleName();

    public e(java.util.List<com.anythink.core.common.f.i> list) {
        this.a = list;
    }

    private java.lang.String a(boolean z) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        org.json.JSONObject h = super.h();
        org.json.JSONObject i = super.i();
        try {
            h.put("app_id", com.anythink.core.common.b.o.a().o());
            h.put(com.anythink.core.common.h.c.T, this.i);
            h.put(com.anythink.core.common.h.c.V, this.j);
            java.util.Iterator<java.lang.String> keys = i.keys();
            while (keys.hasNext()) {
                java.lang.String next = keys.next();
                h.put(next, i.opt(next));
            }
            java.util.Map<java.lang.String, java.lang.Object> l = com.anythink.core.common.b.o.a().l();
            if (l != null && l.size() > 0) {
                org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                for (java.lang.String str : l.keySet()) {
                    java.lang.Object obj = l.get(str);
                    if (obj != null) {
                        jSONObject2.put(str, obj.toString());
                    }
                }
                h.put("custom", jSONObject2);
            }
        } catch (java.lang.Throwable unused) {
        }
        java.lang.String a = com.anythink.core.common.o.d.a(h.toString());
        org.json.JSONArray jSONArray = new org.json.JSONArray();
        java.util.List<com.anythink.core.common.f.i> list = this.a;
        if (list != null) {
            java.util.Iterator<com.anythink.core.common.f.i> it = list.iterator();
            while (it.hasNext()) {
                org.json.JSONObject a2 = it.next().a();
                if (z && a2 != null) {
                    try {
                        a2.put(com.anythink.core.common.h.c.U, 1);
                    } catch (org.json.JSONException e) {
                        e.printStackTrace();
                    }
                }
                jSONArray.put(a2);
            }
        }
        java.lang.String a3 = com.anythink.core.common.o.d.a(jSONArray.toString());
        java.lang.String c = com.anythink.core.common.o.g.c(com.anythink.core.common.b.o.a().p() + "api_ver=1.0&common=" + a + "&data=" + a3);
        try {
            jSONObject.put("common", a);
            jSONObject.put("data", a3);
            jSONObject.put(com.anythink.core.common.h.c.O, "1.0");
            jSONObject.put("sign", c);
        } catch (java.lang.Exception unused2) {
        }
        return jSONObject.toString();
    }

    @Override // com.anythink.core.common.h.a.c
    public final void a(java.lang.String str, java.lang.String str2, java.lang.String str3, int i) {
        if (this.b) {
            return;
        }
        java.lang.String str4 = str3 + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + i;
        java.util.List<com.anythink.core.common.f.i> list = this.a;
        com.anythink.core.common.n.c.a("tk", str, str2, str4, (java.lang.String) null, java.lang.String.valueOf(list != null ? list.size() : 0), "1");
        com.anythink.core.common.t.a().a(3, "", "", a(true), com.anythink.core.common.f.u.a(1000));
    }

    @Override // com.anythink.core.common.h.a.c
    public final int c() {
        return 1;
    }

    @Override // com.anythink.core.common.h.a.c
    public final int d() {
        return 3;
    }

    @Override // com.anythink.core.common.h.a.c
    public final byte[] e() {
        java.util.List<com.anythink.core.common.f.i> list = this.a;
        return (list == null || list.size() <= 0) ? new byte[0] : com.anythink.core.common.h.a.c.a(a(false));
    }

    @Override // com.anythink.core.common.h.a.c
    public final boolean f() {
        return this.b;
    }

    @Override // com.anythink.core.common.h.a.c
    public final int g() {
        return 6;
    }
}
