package com.igexin.push.core.b;

/* loaded from: classes23.dex */
public final class p extends com.igexin.push.extension.mod.BaseActionBean {
    private long a;

    private long a() {
        return this.a;
    }

    private static com.igexin.push.core.b.p a(java.lang.String str) throws org.json.JSONException {
        long j;
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        com.igexin.push.core.b.p pVar = new com.igexin.push.core.b.p();
        org.json.JSONObject jSONObject = new org.json.JSONObject(str);
        if (jSONObject.has("actionid")) {
            pVar.setActionId(jSONObject.getString("actionid"));
        }
        if (jSONObject.has("type")) {
            pVar.setType(jSONObject.getString("type"));
        }
        if (jSONObject.has(com.anythink.expressad.foundation.d.d.f238s)) {
            pVar.setDoActionId(jSONObject.getString(com.anythink.expressad.foundation.d.d.f238s));
        }
        if (jSONObject.has("delay")) {
            double d = jSONObject.getDouble("delay");
            if (d > 0.0d) {
                j = (long) (d * 1000.0d);
                pVar.a = j;
                return pVar;
            }
        }
        j = 200;
        pVar.a = j;
        return pVar;
    }

    private void a(long j) {
        this.a = j;
    }
}
