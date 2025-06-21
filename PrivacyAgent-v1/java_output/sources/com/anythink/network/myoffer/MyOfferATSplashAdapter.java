package com.anythink.network.myoffer;

/* loaded from: classes12.dex */
public class MyOfferATSplashAdapter extends com.anythink.splashad.unitgroup.api.CustomSplashAdapter {
    java.lang.String a;
    com.anythink.basead.f.g b;
    com.anythink.core.common.f.m c;
    java.util.Map<java.lang.String, java.lang.Object> d;

    /* renamed from: com.anythink.network.myoffer.MyOfferATSplashAdapter$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.basead.e.c {
        public AnonymousClass1() {
        }

        @Override // com.anythink.basead.e.c
        public final void onAdCacheLoaded() {
            if (((com.anythink.core.api.ATBaseAdAdapter) com.anythink.network.myoffer.MyOfferATSplashAdapter.this).mLoadListener != null) {
                ((com.anythink.core.api.ATBaseAdAdapter) com.anythink.network.myoffer.MyOfferATSplashAdapter.this).mLoadListener.onAdCacheLoaded(new com.anythink.core.api.BaseAd[0]);
            }
        }

        @Override // com.anythink.basead.e.c
        public final void onAdDataLoaded() {
        }

        @Override // com.anythink.basead.e.c
        public final void onAdLoadFailed(com.anythink.basead.c.e eVar) {
            if (((com.anythink.core.api.ATBaseAdAdapter) com.anythink.network.myoffer.MyOfferATSplashAdapter.this).mLoadListener != null) {
                ((com.anythink.core.api.ATBaseAdAdapter) com.anythink.network.myoffer.MyOfferATSplashAdapter.this).mLoadListener.onAdLoadError(eVar.a(), eVar.b());
            }
        }
    }

    /* renamed from: com.anythink.network.myoffer.MyOfferATSplashAdapter$2, reason: invalid class name */
    public class AnonymousClass2 implements com.anythink.basead.e.a {
        public AnonymousClass2() {
        }

        @Override // com.anythink.basead.e.a
        public final void onAdClick(com.anythink.basead.e.i iVar) {
            com.anythink.core.common.f.h trackingInfo = com.anythink.network.myoffer.MyOfferATSplashAdapter.this.getTrackingInfo();
            if (trackingInfo != null) {
                trackingInfo.B(iVar.a);
                trackingInfo.C(iVar.b);
            }
            if (((com.anythink.splashad.unitgroup.api.CustomSplashAdapter) com.anythink.network.myoffer.MyOfferATSplashAdapter.this).mImpressionListener != null) {
                ((com.anythink.splashad.unitgroup.api.CustomSplashAdapter) com.anythink.network.myoffer.MyOfferATSplashAdapter.this).mImpressionListener.onSplashAdClicked();
            }
        }

        @Override // com.anythink.basead.e.a
        public final void onAdClosed() {
            if (((com.anythink.splashad.unitgroup.api.CustomSplashAdapter) com.anythink.network.myoffer.MyOfferATSplashAdapter.this).mImpressionListener != null) {
                ((com.anythink.splashad.unitgroup.api.CustomSplashAdapter) com.anythink.network.myoffer.MyOfferATSplashAdapter.this).mImpressionListener.onSplashAdDismiss();
            }
        }

        @Override // com.anythink.basead.e.a
        public final void onAdShow(com.anythink.basead.e.i iVar) {
            if (((com.anythink.splashad.unitgroup.api.CustomSplashAdapter) com.anythink.network.myoffer.MyOfferATSplashAdapter.this).mImpressionListener != null) {
                ((com.anythink.splashad.unitgroup.api.CustomSplashAdapter) com.anythink.network.myoffer.MyOfferATSplashAdapter.this).mImpressionListener.onSplashAdShow();
            }
        }

        @Override // com.anythink.basead.e.a
        public final void onDeeplinkCallback(boolean z) {
        }

        @Override // com.anythink.basead.e.a
        public final void onShowFailed(com.anythink.basead.c.e eVar) {
            if (((com.anythink.splashad.unitgroup.api.CustomSplashAdapter) com.anythink.network.myoffer.MyOfferATSplashAdapter.this).mImpressionListener != null) {
                ((com.anythink.splashad.unitgroup.api.CustomSplashAdapter) com.anythink.network.myoffer.MyOfferATSplashAdapter.this).mImpressionListener.onSplashAdShowFail(com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.adShowError, eVar.a(), eVar.b()));
            }
        }
    }

    private void a(android.content.Context context) {
        com.anythink.basead.f.g gVar = new com.anythink.basead.f.g(context, this.c, this.a);
        this.b = gVar;
        gVar.a(new com.anythink.network.myoffer.MyOfferATSplashAdapter.AnonymousClass2());
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void destory() {
        com.anythink.basead.f.g gVar = this.b;
        if (gVar != null) {
            gVar.f();
            this.b = null;
        }
        this.c = null;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public java.util.Map<java.lang.String, java.lang.Object> getNetworkInfoMap() {
        return this.d;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public java.lang.String getNetworkName() {
        return "MyOffer";
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public java.lang.String getNetworkPlacementId() {
        return this.a;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public java.lang.String getNetworkSDKVersion() {
        return com.anythink.core.common.o.h.a();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public boolean isAdReady() {
        com.anythink.basead.f.g gVar = this.b;
        boolean z = gVar != null && gVar.a();
        if (z && this.d == null) {
            this.d = com.anythink.basead.b.a(this.b);
        }
        return z;
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashAdapter
    public boolean isSupportCustomSkipView() {
        return true;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void loadCustomNetworkAd(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2) {
        if (map.containsKey("my_oid")) {
            this.a = map.get("my_oid").toString();
        }
        if (map.containsKey(com.anythink.core.common.b.h.o.a)) {
            this.c = (com.anythink.core.common.f.m) map.get(com.anythink.core.common.b.h.o.a);
        }
        com.anythink.basead.f.g gVar = new com.anythink.basead.f.g(context, this.c, this.a);
        this.b = gVar;
        gVar.a(new com.anythink.network.myoffer.MyOfferATSplashAdapter.AnonymousClass2());
        this.b.a(new com.anythink.network.myoffer.MyOfferATSplashAdapter.AnonymousClass1());
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashAdapter
    public void show(android.app.Activity activity, android.view.ViewGroup viewGroup) {
        if (this.b != null) {
            if (isCustomSkipView()) {
                this.b.b();
            }
            this.b.a(viewGroup);
        }
    }
}
