package com.anythink.network.adx;

/* loaded from: classes12.dex */
public class AdxATInitManager extends com.anythink.core.api.ATInitMediation {
    private static volatile com.anythink.network.adx.AdxATInitManager a;

    public static com.anythink.network.adx.AdxATInitManager getInstance() {
        if (a == null) {
            synchronized (com.anythink.network.adx.AdxATInitManager.class) {
                if (a == null) {
                    a = new com.anythink.network.adx.AdxATInitManager();
                }
            }
        }
        return a;
    }

    @Override // com.anythink.core.api.ATInitMediation
    public java.lang.String getAdapterVersion() {
        return "UA_6.2.66";
    }

    @Override // com.anythink.core.api.ATInitMediation
    public java.lang.String getNetworkName() {
        return "Adx";
    }

    @Override // com.anythink.core.api.ATInitMediation
    public java.lang.String getNetworkSDKClass() {
        return "com.anythink.core.api.ATSDK";
    }

    @Override // com.anythink.core.api.ATInitMediation
    public java.util.List getResourceStatus() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add("anythink_myoffer_full_screen");
        arrayList.add("anythink_myoffer_splash_ad_layout_asseblem_vertical_port");
        return arrayList;
    }

    @Override // com.anythink.core.api.ATInitMediation
    public void initSDK(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map, com.anythink.core.api.MediationInitCallback mediationInitCallback) {
    }
}
