package com.anythink.network.myoffer;

/* loaded from: classes12.dex */
public class MyOfferATBannerAdapter extends com.anythink.banner.unitgroup.api.CustomBannerAdapter {
    java.lang.String a;
    com.anythink.core.common.f.m b;
    java.util.Map<java.lang.String, java.lang.Object> c;
    private com.anythink.basead.f.b d;
    private android.view.View e;
    private boolean f = false;

    /* renamed from: com.anythink.network.myoffer.MyOfferATBannerAdapter$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.basead.e.c {
        public AnonymousClass1() {
        }

        @Override // com.anythink.basead.e.c
        public final void onAdCacheLoaded() {
            com.anythink.network.myoffer.MyOfferATBannerAdapter myOfferATBannerAdapter = com.anythink.network.myoffer.MyOfferATBannerAdapter.this;
            myOfferATBannerAdapter.e = myOfferATBannerAdapter.d.b();
            com.anythink.network.myoffer.MyOfferATBannerAdapter myOfferATBannerAdapter2 = com.anythink.network.myoffer.MyOfferATBannerAdapter.this;
            myOfferATBannerAdapter2.c = com.anythink.basead.b.a(myOfferATBannerAdapter2.d);
            if (com.anythink.network.myoffer.MyOfferATBannerAdapter.this.mLoadListener != null) {
                if (com.anythink.network.myoffer.MyOfferATBannerAdapter.this.e != null) {
                    com.anythink.network.myoffer.MyOfferATBannerAdapter.this.mLoadListener.onAdCacheLoaded(new com.anythink.core.api.BaseAd[0]);
                } else {
                    com.anythink.network.myoffer.MyOfferATBannerAdapter.this.mLoadListener.onAdLoadError("", "MyOffer bannerView = null");
                }
            }
        }

        @Override // com.anythink.basead.e.c
        public final void onAdDataLoaded() {
        }

        @Override // com.anythink.basead.e.c
        public final void onAdLoadFailed(com.anythink.basead.c.e eVar) {
            if (com.anythink.network.myoffer.MyOfferATBannerAdapter.this.mLoadListener != null) {
                com.anythink.network.myoffer.MyOfferATBannerAdapter.this.mLoadListener.onAdLoadError(eVar.a(), eVar.b());
            }
        }
    }

    /* renamed from: com.anythink.network.myoffer.MyOfferATBannerAdapter$2, reason: invalid class name */
    public class AnonymousClass2 implements com.anythink.basead.e.a {
        public AnonymousClass2() {
        }

        @Override // com.anythink.basead.e.a
        public final void onAdClick(com.anythink.basead.e.i iVar) {
            com.anythink.core.common.f.h trackingInfo = com.anythink.network.myoffer.MyOfferATBannerAdapter.this.getTrackingInfo();
            if (trackingInfo != null) {
                trackingInfo.B(iVar.a);
                trackingInfo.C(iVar.b);
            }
            if (com.anythink.network.myoffer.MyOfferATBannerAdapter.this.mImpressionEventListener != null) {
                com.anythink.network.myoffer.MyOfferATBannerAdapter.this.mImpressionEventListener.onBannerAdClicked();
            }
        }

        @Override // com.anythink.basead.e.a
        public final void onAdClosed() {
            if (com.anythink.network.myoffer.MyOfferATBannerAdapter.this.mImpressionEventListener != null) {
                com.anythink.network.myoffer.MyOfferATBannerAdapter.this.mImpressionEventListener.onBannerAdClose();
            }
        }

        @Override // com.anythink.basead.e.a
        public final void onAdShow(com.anythink.basead.e.i iVar) {
            if (com.anythink.network.myoffer.MyOfferATBannerAdapter.this.mImpressionEventListener != null) {
                com.anythink.network.myoffer.MyOfferATBannerAdapter.this.mImpressionEventListener.onBannerAdShow();
            }
        }

        @Override // com.anythink.basead.e.a
        public final void onDeeplinkCallback(boolean z) {
        }

        @Override // com.anythink.basead.e.a
        public final void onShowFailed(com.anythink.basead.c.e eVar) {
        }
    }

    private void a(android.content.Context context) {
        com.anythink.basead.f.b bVar = new com.anythink.basead.f.b(context, this.b, this.a, this.f);
        this.d = bVar;
        bVar.a(new com.anythink.network.myoffer.MyOfferATBannerAdapter.AnonymousClass2());
    }

    public void destory() {
        this.e = null;
        com.anythink.basead.f.b bVar = this.d;
        if (bVar != null) {
            bVar.a((com.anythink.basead.e.a) null);
            this.d.c();
            this.d = null;
        }
    }

    public android.view.View getBannerView() {
        com.anythink.basead.f.b bVar;
        if (this.e == null && (bVar = this.d) != null && bVar.a()) {
            this.e = this.d.b();
            if (this.c == null) {
                this.c = com.anythink.basead.b.a(this.d);
            }
        }
        return this.e;
    }

    public java.util.Map<java.lang.String, java.lang.Object> getNetworkInfoMap() {
        return this.c;
    }

    public java.lang.String getNetworkName() {
        return "MyOffer";
    }

    public java.lang.String getNetworkPlacementId() {
        return this.a;
    }

    public java.lang.String getNetworkSDKVersion() {
        return com.anythink.core.common.o.h.a();
    }

    public boolean initNetworkObjectByPlacementId(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2) {
        if (map.containsKey("my_oid")) {
            this.a = map.get("my_oid").toString();
        }
        if (map.containsKey(com.anythink.core.common.b.h.o.a)) {
            this.b = (com.anythink.core.common.f.m) map.get(com.anythink.core.common.b.h.o.a);
        }
        if (map.containsKey(com.anythink.core.common.r.b)) {
            this.f = ((java.lang.Boolean) map.get(com.anythink.core.common.r.b)).booleanValue();
        }
        a(context);
        return true;
    }

    public void loadCustomNetworkAd(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2) {
        if (map.containsKey("my_oid")) {
            this.a = map.get("my_oid").toString();
        }
        if (map.containsKey(com.anythink.core.common.b.h.o.a)) {
            this.b = (com.anythink.core.common.f.m) map.get(com.anythink.core.common.b.h.o.a);
        }
        a(context);
        this.d.a(new com.anythink.network.myoffer.MyOfferATBannerAdapter.AnonymousClass1());
    }
}
