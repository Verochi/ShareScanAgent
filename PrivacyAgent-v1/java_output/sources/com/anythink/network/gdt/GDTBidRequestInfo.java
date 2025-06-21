package com.anythink.network.gdt;

/* loaded from: classes12.dex */
public class GDTBidRequestInfo extends com.anythink.core.api.ATBidRequestInfo {
    java.lang.String a;
    org.json.JSONObject b = new org.json.JSONObject();

    public GDTBidRequestInfo(java.util.Map<java.lang.String, java.lang.Object> map) {
        try {
            java.lang.String obj = map.get("app_id").toString();
            java.lang.String obj2 = map.get("unit_id").toString();
            java.util.HashMap hashMap = new java.util.HashMap();
            com.anythink.network.gdt.GDTATInitManager.getInstance();
            com.anythink.network.gdt.GDTATInitManager.a(hashMap, map);
            this.a = com.qq.e.comm.managers.GDTAdSdk.getGDTAdManger().getBuyerId(hashMap);
            this.b.put("app_id", obj);
            this.b.put("unit_id", obj2);
            this.b.put(com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BUYERUID, this.a);
            this.b.put(com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.SDK_INFO, com.qq.e.comm.managers.GDTAdSdk.getGDTAdManger().getSDKInfo(obj2));
        } catch (java.lang.Throwable unused) {
        }
    }

    public boolean isValid() {
        return !android.text.TextUtils.isEmpty(this.a);
    }

    @Override // com.anythink.core.api.ATBidRequestInfo
    public org.json.JSONObject toRequestJSONObject() {
        return this.b;
    }
}
