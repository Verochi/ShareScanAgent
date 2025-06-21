package com.getui.gtc.extension.distribution.gbd.g.a;

/* loaded from: classes22.dex */
public final class f extends com.getui.gtc.extension.distribution.gbd.g.d {
    private static final java.lang.String A = "cid";
    private static final java.lang.String B = "appid";
    private static final java.lang.String C = "pkgs";
    private static final java.lang.String y = "GBD_GSSHP";
    private static final java.lang.String z = "action";

    public f() {
        super(com.getui.gtc.extension.distribution.gbd.d.i.a());
        this.l = true;
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("action", "fetchus");
            jSONObject.put("cid", com.getui.gtc.extension.distribution.gbd.d.c.e);
            jSONObject.put("appid", com.getui.gtc.extension.distribution.gbd.d.c.a);
            jSONObject.put(C, com.getui.gtc.extension.distribution.gbd.n.l.u());
            this.f = jSONObject.toString().getBytes();
            com.getui.gtc.extension.distribution.gbd.n.j.b(y, "init jsonObject = ".concat(java.lang.String.valueOf(jSONObject)));
        } catch (java.lang.Exception e) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(e);
        }
    }

    private void a() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("action", "fetchus");
            jSONObject.put("cid", com.getui.gtc.extension.distribution.gbd.d.c.e);
            jSONObject.put("appid", com.getui.gtc.extension.distribution.gbd.d.c.a);
            jSONObject.put(C, com.getui.gtc.extension.distribution.gbd.n.l.u());
            this.f = jSONObject.toString().getBytes();
            com.getui.gtc.extension.distribution.gbd.n.j.b(y, "init jsonObject = ".concat(java.lang.String.valueOf(jSONObject)));
        } catch (java.lang.Exception e) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(e);
        }
    }

    @Override // com.getui.gtc.extension.distribution.gbd.g.d
    public final void a(java.util.Map<java.lang.String, java.util.List<java.lang.String>> map, byte[] bArr) {
        if (bArr != null) {
            try {
                if (com.getui.gtc.extension.distribution.gbd.f.a.c.b == null) {
                    com.getui.gtc.extension.distribution.gbd.f.a.c.b = new com.getui.gtc.extension.distribution.gbd.f.a.c();
                }
                com.getui.gtc.extension.distribution.gbd.f.a.c cVar = com.getui.gtc.extension.distribution.gbd.f.a.c.b;
                try {
                    org.json.JSONObject jSONObject = new org.json.JSONObject(new java.lang.String(bArr));
                    com.getui.gtc.extension.distribution.gbd.n.j.b("GBD_SPM", "parseServiceConfig : ".concat(java.lang.String.valueOf(jSONObject)));
                    com.getui.gtc.extension.distribution.gbd.n.j.a("GBD_SPM", "parseServiceConfig : ".concat(java.lang.String.valueOf(jSONObject)));
                    if (jSONObject.has("result") && jSONObject.has("services")) {
                        java.lang.String string = jSONObject.getString("services");
                        if (android.text.TextUtils.isEmpty(string)) {
                            return;
                        }
                        android.content.SharedPreferences.Editor edit = cVar.a.edit();
                        edit.putString("sp_guard_services", com.getui.gtc.extension.distribution.gbd.n.e.a(com.getui.gtc.extension.distribution.gbd.n.t.b(string.getBytes("UTF-8"), com.getui.gtc.extension.distribution.gbd.d.g.V), 0));
                        edit.apply();
                    }
                } catch (java.lang.Throwable th) {
                    com.getui.gtc.extension.distribution.gbd.n.j.a(th);
                }
            } catch (java.lang.Throwable th2) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(th2);
            }
        }
    }
}
