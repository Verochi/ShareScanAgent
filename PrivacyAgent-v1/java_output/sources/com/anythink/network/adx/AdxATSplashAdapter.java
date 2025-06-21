package com.anythink.network.adx;

/* loaded from: classes12.dex */
public class AdxATSplashAdapter extends com.anythink.splashad.unitgroup.api.CustomSplashAdapter {
    com.anythink.basead.d.g a;
    com.anythink.core.common.f.m b;
    java.util.Map<java.lang.String, java.lang.Object> c;

    /* renamed from: com.anythink.network.adx.AdxATSplashAdapter$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.basead.e.c {
        public AnonymousClass1() {
        }

        @Override // com.anythink.basead.e.c
        public final void onAdCacheLoaded() {
            com.anythink.network.adx.AdxATSplashAdapter adxATSplashAdapter = com.anythink.network.adx.AdxATSplashAdapter.this;
            adxATSplashAdapter.c = com.anythink.basead.b.a(adxATSplashAdapter.a);
            if (((com.anythink.core.api.ATBaseAdAdapter) com.anythink.network.adx.AdxATSplashAdapter.this).mLoadListener != null) {
                ((com.anythink.core.api.ATBaseAdAdapter) com.anythink.network.adx.AdxATSplashAdapter.this).mLoadListener.onAdCacheLoaded(new com.anythink.core.api.BaseAd[0]);
            }
        }

        @Override // com.anythink.basead.e.c
        public final void onAdDataLoaded() {
            if (((com.anythink.core.api.ATBaseAdAdapter) com.anythink.network.adx.AdxATSplashAdapter.this).mLoadListener != null) {
                ((com.anythink.core.api.ATBaseAdAdapter) com.anythink.network.adx.AdxATSplashAdapter.this).mLoadListener.onAdDataLoaded();
            }
        }

        @Override // com.anythink.basead.e.c
        public final void onAdLoadFailed(com.anythink.basead.c.e eVar) {
            if (((com.anythink.core.api.ATBaseAdAdapter) com.anythink.network.adx.AdxATSplashAdapter.this).mLoadListener != null) {
                ((com.anythink.core.api.ATBaseAdAdapter) com.anythink.network.adx.AdxATSplashAdapter.this).mLoadListener.onAdLoadError(eVar.a(), eVar.b());
            }
        }
    }

    /* renamed from: com.anythink.network.adx.AdxATSplashAdapter$2, reason: invalid class name */
    public class AnonymousClass2 extends com.anythink.basead.e.e {
        public AnonymousClass2(com.anythink.core.common.f.l lVar, com.anythink.core.common.f.h hVar) {
            super(lVar, hVar);
        }

        @Override // com.anythink.basead.e.e, com.anythink.basead.e.a
        public final void onAdClick(com.anythink.basead.e.i iVar) {
            super.onAdClick(iVar);
            if (((com.anythink.splashad.unitgroup.api.CustomSplashAdapter) com.anythink.network.adx.AdxATSplashAdapter.this).mImpressionListener != null) {
                ((com.anythink.splashad.unitgroup.api.CustomSplashAdapter) com.anythink.network.adx.AdxATSplashAdapter.this).mImpressionListener.onSplashAdClicked();
            }
        }

        @Override // com.anythink.basead.e.a
        public final void onAdClosed() {
            if (((com.anythink.splashad.unitgroup.api.CustomSplashAdapter) com.anythink.network.adx.AdxATSplashAdapter.this).mImpressionListener != null) {
                ((com.anythink.splashad.unitgroup.api.CustomSplashAdapter) com.anythink.network.adx.AdxATSplashAdapter.this).mImpressionListener.onSplashAdDismiss();
            }
        }

        @Override // com.anythink.basead.e.e, com.anythink.basead.e.a
        public final void onAdShow(com.anythink.basead.e.i iVar) {
            super.onAdShow(iVar);
            if (((com.anythink.splashad.unitgroup.api.CustomSplashAdapter) com.anythink.network.adx.AdxATSplashAdapter.this).mImpressionListener != null) {
                ((com.anythink.splashad.unitgroup.api.CustomSplashAdapter) com.anythink.network.adx.AdxATSplashAdapter.this).mImpressionListener.onSplashAdShow();
            }
        }

        @Override // com.anythink.basead.e.a
        public final void onDeeplinkCallback(boolean z) {
            if (((com.anythink.splashad.unitgroup.api.CustomSplashAdapter) com.anythink.network.adx.AdxATSplashAdapter.this).mImpressionListener != null) {
                ((com.anythink.splashad.unitgroup.api.CustomSplashAdapter) com.anythink.network.adx.AdxATSplashAdapter.this).mImpressionListener.onDeeplinkCallback(z);
            }
        }

        @Override // com.anythink.basead.e.a
        public final void onShowFailed(com.anythink.basead.c.e eVar) {
            com.anythink.network.adx.AdxATSplashAdapter.o(com.anythink.network.adx.AdxATSplashAdapter.this);
            if (((com.anythink.splashad.unitgroup.api.CustomSplashAdapter) com.anythink.network.adx.AdxATSplashAdapter.this).mImpressionListener != null) {
                ((com.anythink.splashad.unitgroup.api.CustomSplashAdapter) com.anythink.network.adx.AdxATSplashAdapter.this).mImpressionListener.onSplashAdShowFail(com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.adShowError, eVar.a(), eVar.b()));
                ((com.anythink.splashad.unitgroup.api.CustomSplashAdapter) com.anythink.network.adx.AdxATSplashAdapter.this).mImpressionListener.onSplashAdDismiss();
            }
        }
    }

    private void a(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map) {
        java.lang.Object obj;
        int parseInt;
        java.lang.Object obj2;
        java.lang.Object obj3;
        int i = 1;
        int parseInt2 = (!map.containsKey("orientation") || (obj3 = map.get("orientation")) == null) ? 1 : java.lang.Integer.parseInt(obj3.toString());
        int parseInt3 = (!map.containsKey(com.anythink.expressad.d.a.b.dk) || (obj2 = map.get(com.anythink.expressad.d.a.b.dk)) == null) ? 5 : java.lang.Integer.parseInt(obj2.toString()) * 1000;
        if (map.containsKey("allows_skip") && (obj = map.get("allows_skip")) != null && (parseInt = java.lang.Integer.parseInt(obj.toString())) != 0) {
            i = parseInt == 1 ? 0 : parseInt;
        }
        com.anythink.core.common.f.m mVar = (com.anythink.core.common.f.m) map.get(com.anythink.core.common.b.h.o.a);
        this.b = mVar;
        com.anythink.basead.d.g gVar = new com.anythink.basead.d.g(context, com.anythink.basead.d.b.EnumC0136b.ADX_OFFER_REQUEST_TYPE, mVar);
        this.a = gVar;
        gVar.a(new com.anythink.basead.d.c.a().d(parseInt2).e(parseInt3).f(i).a());
    }

    public static /* synthetic */ int o(com.anythink.network.adx.AdxATSplashAdapter adxATSplashAdapter) {
        adxATSplashAdapter.mDismissType = 99;
        return 99;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void destory() {
        com.anythink.basead.d.g gVar = this.a;
        if (gVar != null) {
            gVar.b();
            this.a = null;
        }
        this.b = null;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void getBidRequestInfo(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2, com.anythink.core.api.ATBidRequestInfoListener aTBidRequestInfoListener) {
        com.anythink.core.common.f.m mVar = (com.anythink.core.common.f.m) map.get(com.anythink.core.common.b.h.o.a);
        com.anythink.network.adx.AdxBidRequestInfo adxBidRequestInfo = new com.anythink.network.adx.AdxBidRequestInfo(context, mVar != null ? mVar.b : "");
        adxBidRequestInfo.fillSplashData();
        if (aTBidRequestInfoListener != null) {
            aTBidRequestInfoListener.onSuccess(adxBidRequestInfo);
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public java.util.Map<java.lang.String, java.lang.Object> getNetworkInfoMap() {
        return this.c;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public java.lang.String getNetworkName() {
        return com.anythink.network.adx.AdxATInitManager.getInstance().getNetworkName();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public java.lang.String getNetworkPlacementId() {
        com.anythink.core.common.f.m mVar = this.b;
        return mVar != null ? mVar.b : "";
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public java.lang.String getNetworkSDKVersion() {
        return "";
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public boolean initNetworkObjectByPlacementId(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2) {
        a(context, map);
        com.anythink.basead.d.g gVar = this.a;
        if (gVar == null || gVar.c()) {
            return true;
        }
        this.a.d();
        return true;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public boolean isAdReady() {
        com.anythink.basead.d.g gVar = this.a;
        boolean z = gVar != null && gVar.c();
        if (z && this.c == null) {
            this.c = com.anythink.basead.b.a(this.a);
        }
        return z;
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashAdapter
    public boolean isSupportCustomSkipView() {
        com.anythink.basead.d.g gVar = this.a;
        return gVar != null && gVar.g();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void loadCustomNetworkAd(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2) {
        a(context, map);
        this.a.a(new com.anythink.network.adx.AdxATSplashAdapter.AnonymousClass1());
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashAdapter
    public void show(android.app.Activity activity, android.view.ViewGroup viewGroup) {
        com.anythink.basead.d.g gVar = this.a;
        if (gVar != null) {
            gVar.a(new com.anythink.network.adx.AdxATSplashAdapter.AnonymousClass2(gVar.f(), getTrackingInfo()));
            if (isCustomSkipView()) {
                this.a.a();
            }
            this.a.a(viewGroup);
        }
    }
}
