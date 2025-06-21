package com.igexin.push.core.a.b;

import com.igexin.push.config.a.AnonymousClass5;

/* loaded from: classes23.dex */
public final class c extends com.igexin.push.core.a.b.a {
    private static final java.lang.String a = "BlockClientAction";

    @Override // com.igexin.push.core.a.b.a
    public final boolean a(java.lang.Object obj, org.json.JSONObject jSONObject) {
        try {
            if (jSONObject.has("action") && jSONObject.getString("action").equals("block_client") && jSONObject.has("duration")) {
                long j = jSONObject.getLong("duration") * 1000;
                long currentTimeMillis = java.lang.System.currentTimeMillis();
                if (j != 0) {
                    com.igexin.push.config.d.d = currentTimeMillis + j;
                    com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) com.igexin.push.config.a.a().new AnonymousClass5(), false, true);
                    com.igexin.push.g.e.a().d();
                }
            }
        } catch (java.lang.Exception e) {
            com.igexin.c.a.c.a.a(e);
        }
        return true;
    }
}
