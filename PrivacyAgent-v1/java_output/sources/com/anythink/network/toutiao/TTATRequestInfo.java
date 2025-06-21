package com.anythink.network.toutiao;

@java.lang.Deprecated
/* loaded from: classes12.dex */
public class TTATRequestInfo extends com.anythink.core.api.ATMediationRequestInfo {
    java.util.HashMap<java.lang.String, java.lang.Object> a;

    public TTATRequestInfo(java.lang.String str, java.lang.String str2, boolean z) {
        this.networkFirmId = 15;
        java.util.HashMap<java.lang.String, java.lang.Object> hashMap = new java.util.HashMap<>();
        this.a = hashMap;
        hashMap.put("app_id", str);
        this.a.put("slot_id", str2);
        this.a.put("personalized_template", z ? "1" : "0");
    }

    @Override // com.anythink.core.api.ATMediationRequestInfo
    public java.util.Map<java.lang.String, java.lang.Object> getRequestParamMap() {
        return this.a;
    }

    @Override // com.anythink.core.api.ATMediationRequestInfo
    public void setFormat(java.lang.String str) {
        str.hashCode();
        if (str.equals("4")) {
            this.className = com.anythink.network.toutiao.TTATSplashAdapter.class.getName();
        }
    }
}
