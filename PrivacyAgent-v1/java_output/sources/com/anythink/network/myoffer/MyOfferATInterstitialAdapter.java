package com.anythink.network.myoffer;

/* loaded from: classes12.dex */
public class MyOfferATInterstitialAdapter extends com.anythink.interstitial.unitgroup.api.CustomInterstitialAdapter {
    com.anythink.core.common.f.m a;
    java.util.Map<java.lang.String, java.lang.Object> b;
    private com.anythink.basead.f.d d;
    private java.lang.String c = "";
    private boolean e = false;

    /* renamed from: com.anythink.network.myoffer.MyOfferATInterstitialAdapter$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.basead.e.c {
        public AnonymousClass1() {
        }

        @Override // com.anythink.basead.e.c
        public final void onAdCacheLoaded() {
            com.anythink.network.myoffer.MyOfferATInterstitialAdapter myOfferATInterstitialAdapter = com.anythink.network.myoffer.MyOfferATInterstitialAdapter.this;
            myOfferATInterstitialAdapter.b = com.anythink.basead.b.a(myOfferATInterstitialAdapter.d);
            if (com.anythink.network.myoffer.MyOfferATInterstitialAdapter.this.mLoadListener != null) {
                com.anythink.network.myoffer.MyOfferATInterstitialAdapter.this.mLoadListener.onAdCacheLoaded(new com.anythink.core.api.BaseAd[0]);
            }
        }

        @Override // com.anythink.basead.e.c
        public final void onAdDataLoaded() {
        }

        @Override // com.anythink.basead.e.c
        public final void onAdLoadFailed(com.anythink.basead.c.e eVar) {
            if (com.anythink.network.myoffer.MyOfferATInterstitialAdapter.this.mLoadListener != null) {
                com.anythink.network.myoffer.MyOfferATInterstitialAdapter.this.mLoadListener.onAdLoadError(eVar.a(), eVar.b());
            }
        }
    }

    /* renamed from: com.anythink.network.myoffer.MyOfferATInterstitialAdapter$2, reason: invalid class name */
    public class AnonymousClass2 implements com.anythink.basead.e.j {
        public AnonymousClass2() {
        }

        @Override // com.anythink.basead.e.a
        public final void onAdClick(com.anythink.basead.e.i iVar) {
            com.anythink.core.common.f.h trackingInfo = com.anythink.network.myoffer.MyOfferATInterstitialAdapter.this.getTrackingInfo();
            if (trackingInfo != null) {
                trackingInfo.B(iVar.a);
                trackingInfo.C(iVar.b);
            }
            if (com.anythink.network.myoffer.MyOfferATInterstitialAdapter.this.mImpressListener != null) {
                com.anythink.network.myoffer.MyOfferATInterstitialAdapter.this.mImpressListener.onInterstitialAdClicked();
            }
        }

        @Override // com.anythink.basead.e.a
        public final void onAdClosed() {
            if (com.anythink.network.myoffer.MyOfferATInterstitialAdapter.this.mImpressListener != null) {
                com.anythink.network.myoffer.MyOfferATInterstitialAdapter.this.mImpressListener.onInterstitialAdClose();
            }
        }

        @Override // com.anythink.basead.e.a
        public final void onAdShow(com.anythink.basead.e.i iVar) {
            if (com.anythink.network.myoffer.MyOfferATInterstitialAdapter.this.mImpressListener != null) {
                com.anythink.network.myoffer.MyOfferATInterstitialAdapter.this.mImpressListener.onInterstitialAdShow();
            }
        }

        @Override // com.anythink.basead.e.a
        public final void onDeeplinkCallback(boolean z) {
        }

        @Override // com.anythink.basead.e.j
        public final void onRewarded() {
        }

        @Override // com.anythink.basead.e.a
        public final void onShowFailed(com.anythink.basead.c.e eVar) {
            if (com.anythink.network.myoffer.MyOfferATInterstitialAdapter.this.mImpressListener != null) {
                com.anythink.network.myoffer.MyOfferATInterstitialAdapter.this.mImpressListener.onInterstitialAdVideoError(eVar.a(), eVar.b());
            }
        }

        @Override // com.anythink.basead.e.j
        public final void onVideoAdPlayEnd() {
            if (com.anythink.network.myoffer.MyOfferATInterstitialAdapter.this.mImpressListener != null) {
                com.anythink.network.myoffer.MyOfferATInterstitialAdapter.this.mImpressListener.onInterstitialAdVideoEnd();
            }
        }

        @Override // com.anythink.basead.e.j
        public final void onVideoAdPlayStart() {
            if (com.anythink.network.myoffer.MyOfferATInterstitialAdapter.this.mImpressListener != null) {
                com.anythink.network.myoffer.MyOfferATInterstitialAdapter.this.mImpressListener.onInterstitialAdVideoStart();
            }
        }
    }

    private void a(android.content.Context context) {
        this.d = new com.anythink.basead.f.d(context, this.a, this.c, this.e);
    }

    public void destory() {
        com.anythink.basead.f.d dVar = this.d;
        if (dVar != null) {
            dVar.a((com.anythink.basead.e.j) null);
            this.d = null;
        }
    }

    public java.util.Map<java.lang.String, java.lang.Object> getNetworkInfoMap() {
        return this.b;
    }

    public java.lang.String getNetworkName() {
        return "MyOffer";
    }

    public java.lang.String getNetworkPlacementId() {
        return this.c;
    }

    public java.lang.String getNetworkSDKVersion() {
        return com.anythink.core.common.o.h.a();
    }

    public boolean initNetworkObjectByPlacementId(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2) {
        if (map.containsKey("my_oid")) {
            this.c = map.get("my_oid").toString();
        }
        if (map.containsKey(com.anythink.core.common.b.h.o.a)) {
            this.a = (com.anythink.core.common.f.m) map.get(com.anythink.core.common.b.h.o.a);
        }
        if (map.containsKey(com.anythink.core.common.r.b)) {
            this.e = ((java.lang.Boolean) map.get(com.anythink.core.common.r.b)).booleanValue();
        }
        a(context);
        return true;
    }

    public boolean isAdReady() {
        com.anythink.basead.f.d dVar = this.d;
        boolean z = dVar != null && dVar.a();
        if (z && this.b == null) {
            this.b = com.anythink.basead.b.a(this.d);
        }
        return z;
    }

    public void loadCustomNetworkAd(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2) {
        if (map.containsKey("my_oid")) {
            this.c = map.get("my_oid").toString();
        }
        if (map.containsKey(com.anythink.core.common.b.h.o.a)) {
            this.a = (com.anythink.core.common.f.m) map.get(com.anythink.core.common.b.h.o.a);
        }
        a(context);
        this.d.a(new com.anythink.network.myoffer.MyOfferATInterstitialAdapter.AnonymousClass1());
    }

    public void show(android.app.Activity activity) {
        if (isAdReady()) {
            java.util.HashMap hashMap = new java.util.HashMap(1);
            int g = com.anythink.core.common.o.e.g(activity);
            hashMap.put(com.anythink.basead.f.c.h, this.a.d);
            hashMap.put("extra_scenario", this.mScenario);
            hashMap.put(com.anythink.basead.f.c.j, java.lang.Integer.valueOf(g));
            this.d.a(new com.anythink.network.myoffer.MyOfferATInterstitialAdapter.AnonymousClass2());
            this.d.a(activity, hashMap);
        }
    }
}
