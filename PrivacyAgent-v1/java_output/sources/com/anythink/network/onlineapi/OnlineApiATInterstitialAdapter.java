package com.anythink.network.onlineapi;

/* loaded from: classes12.dex */
public class OnlineApiATInterstitialAdapter extends com.anythink.interstitial.unitgroup.api.CustomInterstitialAdapter {
    com.anythink.core.common.f.m a;
    com.anythink.basead.d.d b;
    java.lang.String c;
    java.util.Map<java.lang.String, java.lang.Object> d;

    /* renamed from: com.anythink.network.onlineapi.OnlineApiATInterstitialAdapter$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.basead.e.j {
        public AnonymousClass1() {
        }

        @Override // com.anythink.basead.e.a
        public final void onAdClick(com.anythink.basead.e.i iVar) {
            com.anythink.core.common.f.h trackingInfo = com.anythink.network.onlineapi.OnlineApiATInterstitialAdapter.this.getTrackingInfo();
            if (trackingInfo != null) {
                trackingInfo.B(iVar.a);
                trackingInfo.C(iVar.b);
            }
            if (com.anythink.network.onlineapi.OnlineApiATInterstitialAdapter.this.mImpressListener != null) {
                com.anythink.network.onlineapi.OnlineApiATInterstitialAdapter.this.mImpressListener.onInterstitialAdClicked();
            }
        }

        @Override // com.anythink.basead.e.a
        public final void onAdClosed() {
            if (com.anythink.network.onlineapi.OnlineApiATInterstitialAdapter.this.mImpressListener != null) {
                com.anythink.network.onlineapi.OnlineApiATInterstitialAdapter.this.mImpressListener.onInterstitialAdClose();
            }
        }

        @Override // com.anythink.basead.e.a
        public final void onAdShow(com.anythink.basead.e.i iVar) {
            if (com.anythink.network.onlineapi.OnlineApiATInterstitialAdapter.this.mImpressListener != null) {
                com.anythink.network.onlineapi.OnlineApiATInterstitialAdapter.this.mImpressListener.onInterstitialAdShow();
            }
        }

        @Override // com.anythink.basead.e.a
        public final void onDeeplinkCallback(boolean z) {
            if (com.anythink.network.onlineapi.OnlineApiATInterstitialAdapter.this.mImpressListener != null) {
                com.anythink.network.onlineapi.OnlineApiATInterstitialAdapter.this.mImpressListener.onDeeplinkCallback(z);
            }
        }

        @Override // com.anythink.basead.e.j
        public final void onRewarded() {
        }

        @Override // com.anythink.basead.e.a
        public final void onShowFailed(com.anythink.basead.c.e eVar) {
            if (com.anythink.network.onlineapi.OnlineApiATInterstitialAdapter.this.mImpressListener != null) {
                com.anythink.network.onlineapi.OnlineApiATInterstitialAdapter.this.mImpressListener.onInterstitialAdVideoError(eVar.a(), eVar.b());
            }
        }

        @Override // com.anythink.basead.e.j
        public final void onVideoAdPlayEnd() {
            if (com.anythink.network.onlineapi.OnlineApiATInterstitialAdapter.this.mImpressListener != null) {
                com.anythink.network.onlineapi.OnlineApiATInterstitialAdapter.this.mImpressListener.onInterstitialAdVideoEnd();
            }
        }

        @Override // com.anythink.basead.e.j
        public final void onVideoAdPlayStart() {
            if (com.anythink.network.onlineapi.OnlineApiATInterstitialAdapter.this.mImpressListener != null) {
                com.anythink.network.onlineapi.OnlineApiATInterstitialAdapter.this.mImpressListener.onInterstitialAdVideoStart();
            }
        }
    }

    /* renamed from: com.anythink.network.onlineapi.OnlineApiATInterstitialAdapter$2, reason: invalid class name */
    public class AnonymousClass2 implements com.anythink.basead.e.c {
        public AnonymousClass2() {
        }

        @Override // com.anythink.basead.e.c
        public final void onAdCacheLoaded() {
            com.anythink.network.onlineapi.OnlineApiATInterstitialAdapter onlineApiATInterstitialAdapter = com.anythink.network.onlineapi.OnlineApiATInterstitialAdapter.this;
            onlineApiATInterstitialAdapter.d = com.anythink.basead.b.a(onlineApiATInterstitialAdapter.b);
            if (com.anythink.network.onlineapi.OnlineApiATInterstitialAdapter.this.mLoadListener != null) {
                com.anythink.network.onlineapi.OnlineApiATInterstitialAdapter.this.mLoadListener.onAdCacheLoaded(new com.anythink.core.api.BaseAd[0]);
            }
        }

        @Override // com.anythink.basead.e.c
        public final void onAdDataLoaded() {
            if (com.anythink.network.onlineapi.OnlineApiATInterstitialAdapter.this.mLoadListener != null) {
                com.anythink.network.onlineapi.OnlineApiATInterstitialAdapter.this.mLoadListener.onAdDataLoaded();
            }
        }

        @Override // com.anythink.basead.e.c
        public final void onAdLoadFailed(com.anythink.basead.c.e eVar) {
            if (com.anythink.network.onlineapi.OnlineApiATInterstitialAdapter.this.mLoadListener != null) {
                com.anythink.network.onlineapi.OnlineApiATInterstitialAdapter.this.mLoadListener.onAdLoadError(eVar.a(), eVar.b());
            }
        }
    }

    private void a(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map) {
        java.lang.Object obj;
        java.lang.Object obj2;
        this.c = map.get("unit_id") != null ? map.get("unit_id").toString() : "";
        int parseInt = (!map.containsKey("v_m") || (obj2 = map.get("v_m")) == null) ? 0 : java.lang.Integer.parseInt(obj2.toString());
        int parseInt2 = (!map.containsKey("s_c_t") || (obj = map.get("s_c_t")) == null) ? -1 : java.lang.Integer.parseInt(obj.toString());
        this.a = (com.anythink.core.common.f.m) map.get(com.anythink.core.common.b.h.o.a);
        com.anythink.basead.d.d dVar = new com.anythink.basead.d.d(context, com.anythink.basead.d.b.EnumC0136b.ONLINE_API_OFFER_REQUEST_TYPE, this.a);
        this.b = dVar;
        dVar.a(new com.anythink.basead.d.c.a().a(parseInt).b(parseInt2).a());
        java.lang.String stringFromMap = com.anythink.core.api.ATInitMediation.getStringFromMap(map, "unit_type");
        if (android.text.TextUtils.isEmpty(stringFromMap)) {
            return;
        }
        this.b.a(stringFromMap);
    }

    public void destory() {
        com.anythink.basead.d.d dVar = this.b;
        if (dVar != null) {
            dVar.b();
            this.b = null;
        }
    }

    public java.util.Map<java.lang.String, java.lang.Object> getNetworkInfoMap() {
        return this.d;
    }

    public java.lang.String getNetworkName() {
        return "";
    }

    public java.lang.String getNetworkPlacementId() {
        return this.c;
    }

    public java.lang.String getNetworkSDKVersion() {
        return "";
    }

    public boolean initNetworkObjectByPlacementId(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2) {
        a(context, map);
        return true;
    }

    public boolean isAdReady() {
        com.anythink.basead.d.d dVar = this.b;
        boolean z = dVar != null && dVar.c();
        if (z && this.d == null) {
            this.d = com.anythink.basead.b.a(this.b);
        }
        return z;
    }

    public void loadCustomNetworkAd(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2) {
        a(context, map);
        this.b.a(new com.anythink.network.onlineapi.OnlineApiATInterstitialAdapter.AnonymousClass2());
    }

    public void show(android.app.Activity activity) {
        int g = com.anythink.core.common.o.e.g(activity);
        java.util.HashMap hashMap = new java.util.HashMap(1);
        hashMap.put("extra_scenario", this.mScenario);
        hashMap.put(com.anythink.basead.f.c.j, java.lang.Integer.valueOf(g));
        this.b.a(new com.anythink.network.onlineapi.OnlineApiATInterstitialAdapter.AnonymousClass1());
        com.anythink.basead.d.d dVar = this.b;
        if (dVar != null) {
            dVar.a(activity, hashMap);
        }
    }
}
