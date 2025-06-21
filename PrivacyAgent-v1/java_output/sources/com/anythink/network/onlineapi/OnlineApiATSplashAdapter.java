package com.anythink.network.onlineapi;

/* loaded from: classes12.dex */
public class OnlineApiATSplashAdapter extends com.anythink.splashad.unitgroup.api.CustomSplashAdapter {
    com.anythink.basead.d.g a;
    com.anythink.core.common.f.m b;
    java.lang.String c;
    java.util.Map<java.lang.String, java.lang.Object> d;

    /* renamed from: com.anythink.network.onlineapi.OnlineApiATSplashAdapter$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.basead.e.c {
        public AnonymousClass1() {
        }

        @Override // com.anythink.basead.e.c
        public final void onAdCacheLoaded() {
            com.anythink.network.onlineapi.OnlineApiATSplashAdapter onlineApiATSplashAdapter = com.anythink.network.onlineapi.OnlineApiATSplashAdapter.this;
            onlineApiATSplashAdapter.d = com.anythink.basead.b.a(onlineApiATSplashAdapter.a);
            if (((com.anythink.core.api.ATBaseAdAdapter) com.anythink.network.onlineapi.OnlineApiATSplashAdapter.this).mLoadListener != null) {
                ((com.anythink.core.api.ATBaseAdAdapter) com.anythink.network.onlineapi.OnlineApiATSplashAdapter.this).mLoadListener.onAdCacheLoaded(new com.anythink.core.api.BaseAd[0]);
            }
        }

        @Override // com.anythink.basead.e.c
        public final void onAdDataLoaded() {
            if (((com.anythink.core.api.ATBaseAdAdapter) com.anythink.network.onlineapi.OnlineApiATSplashAdapter.this).mLoadListener != null) {
                ((com.anythink.core.api.ATBaseAdAdapter) com.anythink.network.onlineapi.OnlineApiATSplashAdapter.this).mLoadListener.onAdDataLoaded();
            }
        }

        @Override // com.anythink.basead.e.c
        public final void onAdLoadFailed(com.anythink.basead.c.e eVar) {
            if (((com.anythink.core.api.ATBaseAdAdapter) com.anythink.network.onlineapi.OnlineApiATSplashAdapter.this).mLoadListener != null) {
                ((com.anythink.core.api.ATBaseAdAdapter) com.anythink.network.onlineapi.OnlineApiATSplashAdapter.this).mLoadListener.onAdLoadError(eVar.a(), eVar.b());
            }
        }
    }

    /* renamed from: com.anythink.network.onlineapi.OnlineApiATSplashAdapter$2, reason: invalid class name */
    public class AnonymousClass2 implements com.anythink.basead.e.a {
        public AnonymousClass2() {
        }

        @Override // com.anythink.basead.e.a
        public final void onAdClick(com.anythink.basead.e.i iVar) {
            com.anythink.core.common.f.h trackingInfo = com.anythink.network.onlineapi.OnlineApiATSplashAdapter.this.getTrackingInfo();
            if (trackingInfo != null) {
                trackingInfo.B(iVar.a);
                trackingInfo.C(iVar.b);
            }
            if (((com.anythink.splashad.unitgroup.api.CustomSplashAdapter) com.anythink.network.onlineapi.OnlineApiATSplashAdapter.this).mImpressionListener != null) {
                ((com.anythink.splashad.unitgroup.api.CustomSplashAdapter) com.anythink.network.onlineapi.OnlineApiATSplashAdapter.this).mImpressionListener.onSplashAdClicked();
            }
        }

        @Override // com.anythink.basead.e.a
        public final void onAdClosed() {
            if (((com.anythink.splashad.unitgroup.api.CustomSplashAdapter) com.anythink.network.onlineapi.OnlineApiATSplashAdapter.this).mImpressionListener != null) {
                ((com.anythink.splashad.unitgroup.api.CustomSplashAdapter) com.anythink.network.onlineapi.OnlineApiATSplashAdapter.this).mImpressionListener.onSplashAdDismiss();
            }
        }

        @Override // com.anythink.basead.e.a
        public final void onAdShow(com.anythink.basead.e.i iVar) {
            if (((com.anythink.splashad.unitgroup.api.CustomSplashAdapter) com.anythink.network.onlineapi.OnlineApiATSplashAdapter.this).mImpressionListener != null) {
                ((com.anythink.splashad.unitgroup.api.CustomSplashAdapter) com.anythink.network.onlineapi.OnlineApiATSplashAdapter.this).mImpressionListener.onSplashAdShow();
            }
        }

        @Override // com.anythink.basead.e.a
        public final void onDeeplinkCallback(boolean z) {
            if (((com.anythink.splashad.unitgroup.api.CustomSplashAdapter) com.anythink.network.onlineapi.OnlineApiATSplashAdapter.this).mImpressionListener != null) {
                ((com.anythink.splashad.unitgroup.api.CustomSplashAdapter) com.anythink.network.onlineapi.OnlineApiATSplashAdapter.this).mImpressionListener.onDeeplinkCallback(z);
            }
        }

        @Override // com.anythink.basead.e.a
        public final void onShowFailed(com.anythink.basead.c.e eVar) {
            if (((com.anythink.splashad.unitgroup.api.CustomSplashAdapter) com.anythink.network.onlineapi.OnlineApiATSplashAdapter.this).mImpressionListener != null) {
                ((com.anythink.splashad.unitgroup.api.CustomSplashAdapter) com.anythink.network.onlineapi.OnlineApiATSplashAdapter.this).mImpressionListener.onSplashAdShowFail(com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.adShowError, eVar.a(), eVar.b()));
            }
        }
    }

    private void a(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map) {
        java.lang.Object obj;
        int parseInt;
        java.lang.Object obj2;
        java.lang.Object obj3;
        this.c = map.get("unit_id") != null ? map.get("unit_id").toString() : "";
        int i = 1;
        int parseInt2 = (!map.containsKey("orientation") || (obj3 = map.get("orientation")) == null) ? 1 : java.lang.Integer.parseInt(obj3.toString());
        int parseInt3 = (!map.containsKey(com.anythink.expressad.d.a.b.dk) || (obj2 = map.get(com.anythink.expressad.d.a.b.dk)) == null) ? 5 : java.lang.Integer.parseInt(obj2.toString()) * 1000;
        if (map.containsKey("allows_skip") && (obj = map.get("allows_skip")) != null && (parseInt = java.lang.Integer.parseInt(obj.toString())) != 0) {
            i = parseInt == 1 ? 0 : parseInt;
        }
        com.anythink.core.common.f.m mVar = (com.anythink.core.common.f.m) map.get(com.anythink.core.common.b.h.o.a);
        this.b = mVar;
        com.anythink.basead.d.g gVar = new com.anythink.basead.d.g(context, com.anythink.basead.d.b.EnumC0136b.ONLINE_API_OFFER_REQUEST_TYPE, mVar);
        this.a = gVar;
        gVar.a(new com.anythink.basead.d.c.a().d(parseInt2).e(parseInt3).f(i).a());
        this.a.a(new com.anythink.network.onlineapi.OnlineApiATSplashAdapter.AnonymousClass2());
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
    public java.util.Map<java.lang.String, java.lang.Object> getNetworkInfoMap() {
        return this.d;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public java.lang.String getNetworkName() {
        return "";
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public java.lang.String getNetworkPlacementId() {
        return this.c;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public java.lang.String getNetworkSDKVersion() {
        return "";
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public boolean isAdReady() {
        com.anythink.basead.d.g gVar = this.a;
        boolean z = gVar != null && gVar.c();
        if (z && this.d == null) {
            this.d = com.anythink.basead.b.a(this.a);
        }
        return z;
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashAdapter
    public boolean isSupportCustomSkipView() {
        return true;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void loadCustomNetworkAd(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2) {
        java.lang.Object obj;
        int parseInt;
        java.lang.Object obj2;
        java.lang.Object obj3;
        this.c = map.get("unit_id") != null ? map.get("unit_id").toString() : "";
        int i = 1;
        int parseInt2 = (!map.containsKey("orientation") || (obj3 = map.get("orientation")) == null) ? 1 : java.lang.Integer.parseInt(obj3.toString());
        int parseInt3 = (!map.containsKey(com.anythink.expressad.d.a.b.dk) || (obj2 = map.get(com.anythink.expressad.d.a.b.dk)) == null) ? 5 : java.lang.Integer.parseInt(obj2.toString()) * 1000;
        if (map.containsKey("allows_skip") && (obj = map.get("allows_skip")) != null && (parseInt = java.lang.Integer.parseInt(obj.toString())) != 0) {
            i = parseInt == 1 ? 0 : parseInt;
        }
        com.anythink.core.common.f.m mVar = (com.anythink.core.common.f.m) map.get(com.anythink.core.common.b.h.o.a);
        this.b = mVar;
        com.anythink.basead.d.g gVar = new com.anythink.basead.d.g(context, com.anythink.basead.d.b.EnumC0136b.ONLINE_API_OFFER_REQUEST_TYPE, mVar);
        this.a = gVar;
        gVar.a(new com.anythink.basead.d.c.a().d(parseInt2).e(parseInt3).f(i).a());
        this.a.a(new com.anythink.network.onlineapi.OnlineApiATSplashAdapter.AnonymousClass2());
        this.a.a(new com.anythink.network.onlineapi.OnlineApiATSplashAdapter.AnonymousClass1());
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashAdapter
    public void show(android.app.Activity activity, android.view.ViewGroup viewGroup) {
        if (this.a != null) {
            if (isCustomSkipView()) {
                this.a.a();
            }
            this.a.a(viewGroup);
        }
    }
}
