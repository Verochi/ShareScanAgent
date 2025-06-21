package com.anythink.network.baidu;

@java.lang.Deprecated
/* loaded from: classes12.dex */
public class BaiduATRequestInfo extends com.anythink.core.api.ATMediationRequestInfo {
    java.util.HashMap<java.lang.String, java.lang.Object> a;

    public BaiduATRequestInfo(java.lang.String str, java.lang.String str2) {
        this.networkFirmId = 22;
        java.util.HashMap<java.lang.String, java.lang.Object> hashMap = new java.util.HashMap<>();
        this.a = hashMap;
        hashMap.put("app_id", str);
        this.a.put("ad_place_id", str2);
    }

    @Override // com.anythink.core.api.ATMediationRequestInfo
    public java.util.Map<java.lang.String, java.lang.Object> getRequestParamMap() {
        return this.a;
    }

    @Override // com.anythink.core.api.ATMediationRequestInfo
    public void setFormat(java.lang.String str) {
        str.hashCode();
        if (str.equals("4")) {
            this.className = com.anythink.network.baidu.BaiduATSplashAdapter.class.getName();
        }
    }
}
