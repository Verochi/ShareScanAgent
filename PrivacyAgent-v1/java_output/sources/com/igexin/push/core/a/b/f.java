package com.igexin.push.core.a.b;

/* loaded from: classes23.dex */
public final class f extends com.igexin.push.core.a.b.a {
    private static final java.lang.String a = com.igexin.push.config.c.a + "_QueryTagResultAction";

    @Override // com.igexin.push.core.a.b.a
    public final boolean a(java.lang.Object obj, org.json.JSONObject jSONObject) {
        com.igexin.c.a.c.a.a(a + "|query tag result resp data = " + jSONObject, new java.lang.Object[0]);
        try {
            if (!jSONObject.has("action") || !jSONObject.getString("action").equals("query_tag_result")) {
                return true;
            }
            java.lang.String string = jSONObject.getString(com.baidu.mobads.sdk.internal.bm.l);
            com.igexin.push.core.l.a().a(jSONObject.getString("sn"), jSONObject.getString("error_code"), jSONObject.getString(com.baidu.mobads.sdk.internal.bm.l));
            if (android.text.TextUtils.isEmpty(string)) {
                string = "none";
            }
            com.igexin.push.core.e.f.a().e(string);
            return true;
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return true;
        }
    }
}
