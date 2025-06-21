package com.igexin.sdk.router.site;

/* loaded from: classes23.dex */
public class InitSite extends com.igexin.sdk.router.boatman.receive.Site<org.json.JSONObject, org.json.JSONObject> {
    @Override // com.igexin.sdk.router.boatman.receive.Site
    public java.lang.String getTag() {
        return "tag_extension_init";
    }

    @Override // com.igexin.sdk.router.boatman.receive.Site
    public org.json.JSONObject onArrived(org.json.JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            jSONObject.put("cid", com.igexin.push.core.e.A);
            jSONObject.put("deviceId", com.igexin.push.core.e.H);
            jSONObject.put("userPushService", com.igexin.push.h.o.b(com.igexin.push.core.e.l, "uis", ""));
        } catch (org.json.JSONException e) {
            com.igexin.c.a.c.a.a(e);
        }
        return jSONObject;
    }

    @Override // com.igexin.sdk.router.boatman.receive.Site
    public void onArrived(org.json.JSONObject jSONObject, com.igexin.sdk.router.boatman.receive.IBoatResult<org.json.JSONObject> iBoatResult) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("cid", com.igexin.push.core.e.A);
            jSONObject.put("deviceId", com.igexin.push.core.e.H);
            jSONObject.put("userPushService", com.igexin.push.h.o.b(com.igexin.push.core.e.l, com.igexin.push.h.o.b, ""));
            iBoatResult.onResult(jSONObject);
        } catch (org.json.JSONException e) {
            com.igexin.c.a.c.a.a(e);
        }
    }
}
