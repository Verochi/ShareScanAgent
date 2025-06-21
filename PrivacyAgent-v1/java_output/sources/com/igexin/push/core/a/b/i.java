package com.igexin.push.core.a.b;

/* loaded from: classes23.dex */
public final class i extends com.igexin.push.core.a.b.a {
    private static final java.lang.String a = "ResponseDeviceidAction";

    @Override // com.igexin.push.core.a.b.a
    public final boolean a(java.lang.Object obj, org.json.JSONObject jSONObject) {
        try {
            if (!jSONObject.has("action") || !jSONObject.getString("action").equals("response_deviceid")) {
                return true;
            }
            com.igexin.push.core.e.f.a().a(jSONObject.getString("deviceid"));
            if (com.igexin.push.core.e.H == null) {
                return true;
            }
            com.igexin.push.core.a.b.d().i();
            return true;
        } catch (java.lang.Exception e) {
            com.igexin.c.a.c.a.a(e);
            return true;
        }
    }
}
