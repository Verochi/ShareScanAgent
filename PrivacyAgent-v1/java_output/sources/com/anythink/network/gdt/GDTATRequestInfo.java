package com.anythink.network.gdt;

@java.lang.Deprecated
/* loaded from: classes12.dex */
public class GDTATRequestInfo extends com.anythink.core.api.ATMediationRequestInfo {
    java.util.HashMap<java.lang.String, java.lang.Object> a;

    public GDTATRequestInfo(java.lang.String str, java.lang.String str2) {
        this.networkFirmId = 8;
        java.util.HashMap<java.lang.String, java.lang.Object> hashMap = new java.util.HashMap<>();
        this.a = hashMap;
        hashMap.put("app_id", str);
        this.a.put("unit_id", str2);
    }

    @Override // com.anythink.core.api.ATMediationRequestInfo
    public java.util.Map<java.lang.String, java.lang.Object> getRequestParamMap() {
        return this.a;
    }

    @Override // com.anythink.core.api.ATMediationRequestInfo
    public void setFormat(java.lang.String str) {
        str.hashCode();
        if (str.equals("4")) {
            this.className = com.anythink.network.gdt.GDTATSplashAdapter.class.getName();
        }
    }
}
