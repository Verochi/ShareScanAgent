package com.igexin.push.core.a.b;

/* loaded from: classes23.dex */
public final class l extends com.igexin.push.core.a.b.a {
    private static final java.lang.String a = com.igexin.push.config.c.a + "_UnBindAliasResultAction";

    @Override // com.igexin.push.core.a.b.a
    public final boolean a(java.lang.Object obj, org.json.JSONObject jSONObject) {
        com.igexin.c.a.c.a.a(a + "|unbind alias result resp data = " + jSONObject, new java.lang.Object[0]);
        try {
            if (!jSONObject.has("action") || !jSONObject.getString("action").equals("response_unbind")) {
                return true;
            }
            com.igexin.push.core.l.a().c(jSONObject.getString("sn"), jSONObject.getString("result"));
            return true;
        } catch (java.lang.Exception e) {
            com.igexin.c.a.c.a.a(e);
            com.igexin.c.a.c.a.a(a + "|" + e.toString(), new java.lang.Object[0]);
            return true;
        }
    }
}
