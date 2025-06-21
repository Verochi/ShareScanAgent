package com.anythink.network.adx;

/* loaded from: classes12.dex */
public class AdxATInterstitialAdapter extends com.anythink.interstitial.unitgroup.api.CustomInterstitialAdapter {
    protected com.anythink.core.common.f.m a;
    protected com.anythink.basead.d.d b;
    java.util.Map<java.lang.String, java.lang.Object> c;

    /* renamed from: com.anythink.network.adx.AdxATInterstitialAdapter$1, reason: invalid class name */
    public class AnonymousClass1 extends com.anythink.basead.e.f {
        public AnonymousClass1(com.anythink.core.common.f.l lVar, com.anythink.core.common.f.h hVar) {
            super(lVar, hVar);
        }

        @Override // com.anythink.basead.e.f, com.anythink.basead.e.a
        public final void onAdClick(com.anythink.basead.e.i iVar) {
            super.onAdClick(iVar);
            if (com.anythink.network.adx.AdxATInterstitialAdapter.this.mImpressListener != null) {
                com.anythink.network.adx.AdxATInterstitialAdapter.this.mImpressListener.onInterstitialAdClicked();
            }
        }

        @Override // com.anythink.basead.e.a
        public final void onAdClosed() {
            if (com.anythink.network.adx.AdxATInterstitialAdapter.this.mImpressListener != null) {
                com.anythink.network.adx.AdxATInterstitialAdapter.this.mImpressListener.onInterstitialAdClose();
            }
        }

        @Override // com.anythink.basead.e.f, com.anythink.basead.e.a
        public final void onAdShow(com.anythink.basead.e.i iVar) {
            super.onAdShow(iVar);
            if (com.anythink.network.adx.AdxATInterstitialAdapter.this.mImpressListener != null) {
                com.anythink.network.adx.AdxATInterstitialAdapter.this.mImpressListener.onInterstitialAdShow();
            }
        }

        @Override // com.anythink.basead.e.a
        public final void onDeeplinkCallback(boolean z) {
            if (com.anythink.network.adx.AdxATInterstitialAdapter.this.mImpressListener != null) {
                com.anythink.network.adx.AdxATInterstitialAdapter.this.mImpressListener.onDeeplinkCallback(z);
            }
        }

        @Override // com.anythink.basead.e.j
        public final void onRewarded() {
        }

        @Override // com.anythink.basead.e.a
        public final void onShowFailed(com.anythink.basead.c.e eVar) {
            if (com.anythink.network.adx.AdxATInterstitialAdapter.this.mImpressListener != null) {
                com.anythink.network.adx.AdxATInterstitialAdapter.this.mImpressListener.onInterstitialAdVideoError(eVar.a(), eVar.b());
            }
        }

        @Override // com.anythink.basead.e.j
        public final void onVideoAdPlayEnd() {
            if (com.anythink.network.adx.AdxATInterstitialAdapter.this.mImpressListener != null) {
                com.anythink.network.adx.AdxATInterstitialAdapter.this.mImpressListener.onInterstitialAdVideoEnd();
            }
        }

        @Override // com.anythink.basead.e.j
        public final void onVideoAdPlayStart() {
            if (com.anythink.network.adx.AdxATInterstitialAdapter.this.mImpressListener != null) {
                com.anythink.network.adx.AdxATInterstitialAdapter.this.mImpressListener.onInterstitialAdVideoStart();
            }
        }
    }

    /* renamed from: com.anythink.network.adx.AdxATInterstitialAdapter$2, reason: invalid class name */
    public class AnonymousClass2 implements com.anythink.basead.e.c {
        public AnonymousClass2() {
        }

        @Override // com.anythink.basead.e.c
        public final void onAdCacheLoaded() {
            com.anythink.network.adx.AdxATInterstitialAdapter adxATInterstitialAdapter = com.anythink.network.adx.AdxATInterstitialAdapter.this;
            adxATInterstitialAdapter.c = com.anythink.basead.b.a(adxATInterstitialAdapter.b);
            if (com.anythink.network.adx.AdxATInterstitialAdapter.this.mLoadListener != null) {
                com.anythink.network.adx.AdxATInterstitialAdapter.this.mLoadListener.onAdCacheLoaded(new com.anythink.core.api.BaseAd[0]);
            }
        }

        @Override // com.anythink.basead.e.c
        public final void onAdDataLoaded() {
            if (com.anythink.network.adx.AdxATInterstitialAdapter.this.mLoadListener != null) {
                com.anythink.network.adx.AdxATInterstitialAdapter.this.mLoadListener.onAdDataLoaded();
            }
        }

        @Override // com.anythink.basead.e.c
        public final void onAdLoadFailed(com.anythink.basead.c.e eVar) {
            if (com.anythink.network.adx.AdxATInterstitialAdapter.this.mLoadListener != null) {
                com.anythink.network.adx.AdxATInterstitialAdapter.this.mLoadListener.onAdLoadError(eVar.a(), eVar.b());
            }
        }
    }

    private void a(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map) {
        java.lang.Object obj;
        java.lang.Object obj2;
        java.lang.Object obj3;
        int parseInt = (!map.containsKey("v_m") || (obj3 = map.get("v_m")) == null) ? 0 : java.lang.Integer.parseInt(obj3.toString());
        int parseInt2 = (!map.containsKey("s_c_t") || (obj2 = map.get("s_c_t")) == null) ? -1 : java.lang.Integer.parseInt(obj2.toString());
        this.a = (com.anythink.core.common.f.m) map.get(com.anythink.core.common.b.h.o.a);
        this.b = new com.anythink.basead.d.d(context, com.anythink.basead.d.b.EnumC0136b.ADX_OFFER_REQUEST_TYPE, this.a);
        this.b.a(new com.anythink.basead.d.c.a().a((!map.containsKey("inter_type") || (obj = map.get("inter_type")) == null) ? "1" : obj.toString()).a(parseInt).b(parseInt2).a());
    }

    public void destory() {
        com.anythink.basead.d.d dVar = this.b;
        if (dVar != null) {
            dVar.b();
            this.b = null;
        }
    }

    public void getBidRequestInfo(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2, com.anythink.core.api.ATBidRequestInfoListener aTBidRequestInfoListener) {
        com.anythink.core.common.f.m mVar = (com.anythink.core.common.f.m) map.get(com.anythink.core.common.b.h.o.a);
        com.anythink.network.adx.AdxBidRequestInfo adxBidRequestInfo = new com.anythink.network.adx.AdxBidRequestInfo(context, mVar != null ? mVar.b : "");
        adxBidRequestInfo.fillInterstitial(map);
        if (aTBidRequestInfoListener != null) {
            aTBidRequestInfoListener.onSuccess(adxBidRequestInfo);
        }
    }

    public java.util.Map<java.lang.String, java.lang.Object> getNetworkInfoMap() {
        return this.c;
    }

    public java.lang.String getNetworkName() {
        return com.anythink.network.adx.AdxATInitManager.getInstance().getNetworkName();
    }

    public java.lang.String getNetworkPlacementId() {
        com.anythink.core.common.f.m mVar = this.a;
        return mVar != null ? mVar.b : "";
    }

    public java.lang.String getNetworkSDKVersion() {
        return "";
    }

    public boolean initNetworkObjectByPlacementId(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2) {
        a(context, map);
        com.anythink.basead.d.d dVar = this.b;
        if (dVar == null || dVar.c()) {
            return true;
        }
        this.b.d();
        return true;
    }

    public boolean isAdReady() {
        com.anythink.basead.d.d dVar = this.b;
        boolean z = dVar != null && dVar.c();
        if (z && this.c == null) {
            this.c = com.anythink.basead.b.a(this.b);
        }
        return z;
    }

    public void loadCustomNetworkAd(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2) {
        a(context, map);
        this.b.a(new com.anythink.network.adx.AdxATInterstitialAdapter.AnonymousClass2());
    }

    public void show(android.app.Activity activity) {
        int g = com.anythink.core.common.o.e.g(activity);
        java.util.HashMap hashMap = new java.util.HashMap(1);
        hashMap.put("extra_scenario", this.mScenario);
        hashMap.put(com.anythink.basead.f.c.j, java.lang.Integer.valueOf(g));
        com.anythink.basead.d.d dVar = this.b;
        dVar.a(new com.anythink.network.adx.AdxATInterstitialAdapter.AnonymousClass1(dVar.f(), getTrackingInfo()));
        com.anythink.basead.d.d dVar2 = this.b;
        if (dVar2 != null) {
            dVar2.a(activity, hashMap);
        }
    }
}
