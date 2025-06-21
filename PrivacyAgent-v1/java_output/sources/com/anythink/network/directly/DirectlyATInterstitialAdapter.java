package com.anythink.network.directly;

/* loaded from: classes12.dex */
public class DirectlyATInterstitialAdapter extends com.anythink.network.adx.AdxATInterstitialAdapter {
    private int d = 0;

    public void fixDirectlyInterstitial() {
        com.anythink.core.common.f.l f;
        com.anythink.basead.d.d dVar = this.b;
        if (dVar == null || (f = dVar.f()) == null) {
            return;
        }
        f.f(this.d == 0 ? 2 : 1);
        com.anythink.core.common.f.ai aiVar = (com.anythink.core.common.f.ai) f;
        if (aiVar.ae() == 5 && this.d == 0) {
            aiVar.n(3);
        }
    }

    @Override // com.anythink.network.adx.AdxATInterstitialAdapter
    public java.lang.String getNetworkName() {
        return "Directly";
    }

    @Override // com.anythink.network.adx.AdxATInterstitialAdapter
    public void loadCustomNetworkAd(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2) {
        java.lang.Object obj;
        if (map.containsKey("unit_type") && (obj = map.get("unit_type")) != null) {
            this.d = java.lang.Integer.parseInt(obj.toString());
        }
        super.loadCustomNetworkAd(context, map, map2);
    }

    @Override // com.anythink.network.adx.AdxATInterstitialAdapter
    public void show(android.app.Activity activity) {
        fixDirectlyInterstitial();
        super.show(activity);
    }
}
