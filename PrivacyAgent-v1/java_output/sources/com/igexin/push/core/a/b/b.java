package com.igexin.push.core.a.b;

/* loaded from: classes23.dex */
public final class b extends com.igexin.push.core.a.b.a {
    private static final java.lang.String a = com.igexin.push.config.c.a + "_BindAliasResultAction";

    @Override // com.igexin.push.core.a.b.a
    public final boolean a(java.lang.Object obj, org.json.JSONObject jSONObject) {
        com.igexin.c.a.c.a.b(a, "bind alias result resp data = ".concat(java.lang.String.valueOf(jSONObject)));
        try {
            if (!jSONObject.has("action") || !jSONObject.getString("action").equals("response_bind")) {
                return true;
            }
            com.igexin.push.core.l.a().b(jSONObject.getString("sn"), jSONObject.getString("result"));
            return true;
        } catch (java.lang.Exception e) {
            com.igexin.c.a.c.a.a(e);
            return true;
        }
    }
}
