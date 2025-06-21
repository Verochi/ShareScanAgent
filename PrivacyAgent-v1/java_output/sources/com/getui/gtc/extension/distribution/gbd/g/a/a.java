package com.getui.gtc.extension.distribution.gbd.g.a;

/* loaded from: classes22.dex */
public final class a extends com.getui.gtc.extension.distribution.gbd.g.d {
    private static final java.lang.String A = "tag";
    private static final java.lang.String B = "cid";
    private static final java.lang.String C = "appid";
    private static final java.lang.String D = "brand";
    private static final java.lang.String E = "sdk_version";
    private static final java.lang.String F = "app_list";
    private static final java.lang.String G = "getActivePath";
    private static final java.lang.String H = "result";
    private static final java.lang.String I = "data";
    private static final java.lang.String J = "ok";
    private static final java.lang.String y = "GBD_ActiveHttp";
    private static final java.lang.String z = "action";
    private java.lang.String K;

    public a(java.lang.String str) {
        super(com.getui.gtc.extension.distribution.gbd.d.i.a());
        this.l = true;
        this.K = str;
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("action", G);
            jSONObject.put("cid", com.getui.gtc.extension.distribution.gbd.d.c.e);
            jSONObject.put("appid", com.getui.gtc.extension.distribution.gbd.d.c.a);
            jSONObject.put("sdk_version", "GBD-2.10.5.2");
            jSONObject.put("tag", com.getui.gtc.extension.distribution.gbd.d.h.t);
            jSONObject.put(F, this.K);
            this.f = jSONObject.toString().getBytes();
            com.getui.gtc.extension.distribution.gbd.n.j.b(y, "init jsonObject = ".concat(java.lang.String.valueOf(jSONObject)));
            com.getui.gtc.extension.distribution.gbd.n.j.a(y, "init jsonObject = ".concat(java.lang.String.valueOf(jSONObject)));
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
        }
    }

    private void a() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("action", G);
            jSONObject.put("cid", com.getui.gtc.extension.distribution.gbd.d.c.e);
            jSONObject.put("appid", com.getui.gtc.extension.distribution.gbd.d.c.a);
            jSONObject.put("sdk_version", "GBD-2.10.5.2");
            jSONObject.put("tag", com.getui.gtc.extension.distribution.gbd.d.h.t);
            jSONObject.put(F, this.K);
            this.f = jSONObject.toString().getBytes();
            com.getui.gtc.extension.distribution.gbd.n.j.b(y, "init jsonObject = ".concat(java.lang.String.valueOf(jSONObject)));
            com.getui.gtc.extension.distribution.gbd.n.j.a(y, "init jsonObject = ".concat(java.lang.String.valueOf(jSONObject)));
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
        }
    }

    @Override // com.getui.gtc.extension.distribution.gbd.g.d
    public final void a(int i) {
        com.getui.gtc.extension.distribution.gbd.n.j.a(y, "requestFailed ".concat(java.lang.String.valueOf(i)));
    }

    @Override // com.getui.gtc.extension.distribution.gbd.g.d
    public final void a(java.lang.Throwable th) {
        com.getui.gtc.extension.distribution.gbd.n.j.a(th);
    }

    @Override // com.getui.gtc.extension.distribution.gbd.g.d
    public final void a(java.util.Map<java.lang.String, java.util.List<java.lang.String>> map, byte[] bArr) {
        org.json.JSONObject optJSONObject;
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(new java.lang.String(bArr));
            com.getui.gtc.extension.distribution.gbd.n.j.b(y, "parse = ".concat(java.lang.String.valueOf(jSONObject)));
            java.lang.String optString = jSONObject.optString("result");
            java.lang.String optString2 = jSONObject.optString("tag");
            if (!"ok".equalsIgnoreCase(optString) || (optJSONObject = jSONObject.optJSONObject("data")) == null || optJSONObject.length() <= 0) {
                return;
            }
            com.getui.gtc.extension.distribution.gbd.f.a.b.a();
            if (!android.text.TextUtils.isEmpty(optString2) && !com.getui.gtc.extension.distribution.gbd.d.h.t.equals(optString2)) {
                com.getui.gtc.extension.distribution.gbd.d.h.t = optString2;
                com.getui.gtc.extension.distribution.gbd.f.a.b.a(280, com.getui.gtc.extension.distribution.gbd.n.ad.a(optString2.getBytes()));
            }
            java.lang.String jSONObject2 = optJSONObject.toString();
            com.getui.gtc.extension.distribution.gbd.f.a.b.a();
            if (!android.text.TextUtils.isEmpty(jSONObject2)) {
                com.getui.gtc.extension.distribution.gbd.d.h.f325s = jSONObject2;
                com.getui.gtc.extension.distribution.gbd.f.a.b.a(260, com.getui.gtc.extension.distribution.gbd.n.ad.a(jSONObject2.getBytes()));
            }
            com.getui.gtc.extension.distribution.gbd.n.b.a(jSONObject2);
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
        }
    }
}
