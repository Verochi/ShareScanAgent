package com.anythink.network.onlineapi;

/* loaded from: classes12.dex */
public class OnlineApiATBannerAdapter extends com.anythink.banner.unitgroup.api.CustomBannerAdapter {
    com.anythink.core.common.f.m a;
    java.lang.String b;
    java.util.Map<java.lang.String, java.lang.Object> c;
    private com.anythink.basead.d.a d;
    private android.view.View e;

    /* renamed from: com.anythink.network.onlineapi.OnlineApiATBannerAdapter$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.basead.e.c {
        public AnonymousClass1() {
        }

        @Override // com.anythink.basead.e.c
        public final void onAdCacheLoaded() {
            com.anythink.network.onlineapi.OnlineApiATBannerAdapter onlineApiATBannerAdapter = com.anythink.network.onlineapi.OnlineApiATBannerAdapter.this;
            onlineApiATBannerAdapter.e = onlineApiATBannerAdapter.d.a();
            if (com.anythink.network.onlineapi.OnlineApiATBannerAdapter.this.mLoadListener != null) {
                if (com.anythink.network.onlineapi.OnlineApiATBannerAdapter.this.e != null) {
                    com.anythink.network.onlineapi.OnlineApiATBannerAdapter.this.mLoadListener.onAdCacheLoaded(new com.anythink.core.api.BaseAd[0]);
                } else {
                    com.anythink.network.onlineapi.OnlineApiATBannerAdapter.this.mLoadListener.onAdLoadError("", "Online bannerView = null");
                }
            }
        }

        @Override // com.anythink.basead.e.c
        public final void onAdDataLoaded() {
            if (com.anythink.network.onlineapi.OnlineApiATBannerAdapter.this.mLoadListener != null) {
                com.anythink.network.onlineapi.OnlineApiATBannerAdapter.this.mLoadListener.onAdDataLoaded();
            }
        }

        @Override // com.anythink.basead.e.c
        public final void onAdLoadFailed(com.anythink.basead.c.e eVar) {
            if (com.anythink.network.onlineapi.OnlineApiATBannerAdapter.this.mLoadListener != null) {
                com.anythink.network.onlineapi.OnlineApiATBannerAdapter.this.mLoadListener.onAdLoadError(eVar.a(), eVar.b());
            }
        }
    }

    /* renamed from: com.anythink.network.onlineapi.OnlineApiATBannerAdapter$2, reason: invalid class name */
    public class AnonymousClass2 implements com.anythink.basead.e.a {
        public AnonymousClass2() {
        }

        @Override // com.anythink.basead.e.a
        public final void onAdClick(com.anythink.basead.e.i iVar) {
            com.anythink.core.common.f.h trackingInfo = com.anythink.network.onlineapi.OnlineApiATBannerAdapter.this.getTrackingInfo();
            if (trackingInfo != null) {
                trackingInfo.B(iVar.a);
                trackingInfo.C(iVar.b);
            }
            if (com.anythink.network.onlineapi.OnlineApiATBannerAdapter.this.mImpressionEventListener != null) {
                com.anythink.network.onlineapi.OnlineApiATBannerAdapter.this.mImpressionEventListener.onBannerAdClicked();
            }
        }

        @Override // com.anythink.basead.e.a
        public final void onAdClosed() {
            if (com.anythink.network.onlineapi.OnlineApiATBannerAdapter.this.mImpressionEventListener != null) {
                com.anythink.network.onlineapi.OnlineApiATBannerAdapter.this.mImpressionEventListener.onBannerAdClose();
            }
        }

        @Override // com.anythink.basead.e.a
        public final void onAdShow(com.anythink.basead.e.i iVar) {
            if (com.anythink.network.onlineapi.OnlineApiATBannerAdapter.this.mImpressionEventListener != null) {
                com.anythink.network.onlineapi.OnlineApiATBannerAdapter.this.mImpressionEventListener.onBannerAdShow();
            }
        }

        @Override // com.anythink.basead.e.a
        public final void onDeeplinkCallback(boolean z) {
            if (com.anythink.network.onlineapi.OnlineApiATBannerAdapter.this.mImpressionEventListener != null) {
                com.anythink.network.onlineapi.OnlineApiATBannerAdapter.this.mImpressionEventListener.onDeeplinkCallback(z);
            }
        }

        @Override // com.anythink.basead.e.a
        public final void onShowFailed(com.anythink.basead.c.e eVar) {
        }
    }

    private void a(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map) {
        java.lang.Object obj;
        java.lang.Object obj2;
        this.b = map.get("unit_id") != null ? map.get("unit_id").toString() : "";
        int parseInt = (!map.containsKey("close_button") || (obj2 = map.get("close_button")) == null) ? 0 : java.lang.Integer.parseInt(obj2.toString());
        java.lang.String obj3 = (!map.containsKey(com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE) || (obj = map.get(com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE)) == null) ? com.anythink.core.common.f.n.a : obj.toString();
        com.anythink.core.common.f.m mVar = (com.anythink.core.common.f.m) map.get(com.anythink.core.common.b.h.o.a);
        this.a = mVar;
        com.anythink.basead.d.a aVar = new com.anythink.basead.d.a(context, com.anythink.basead.d.b.EnumC0136b.ONLINE_API_OFFER_REQUEST_TYPE, mVar);
        this.d = aVar;
        aVar.a(new com.anythink.basead.d.c.a().c(parseInt).b(obj3).a());
        this.d.a(new com.anythink.network.onlineapi.OnlineApiATBannerAdapter.AnonymousClass2());
    }

    public void destory() {
        this.e = null;
        com.anythink.basead.d.a aVar = this.d;
        if (aVar != null) {
            aVar.a((com.anythink.basead.e.a) null);
            this.d.b();
            this.d = null;
        }
    }

    public android.view.View getBannerView() {
        com.anythink.basead.d.a aVar;
        if (this.e == null && (aVar = this.d) != null && aVar.c()) {
            this.e = this.d.a();
        }
        if (this.c == null) {
            this.c = com.anythink.basead.b.a(this.d);
        }
        return this.e;
    }

    public java.util.Map<java.lang.String, java.lang.Object> getNetworkInfoMap() {
        return this.c;
    }

    public java.lang.String getNetworkName() {
        return "";
    }

    public java.lang.String getNetworkPlacementId() {
        return this.b;
    }

    public java.lang.String getNetworkSDKVersion() {
        return "";
    }

    public void loadCustomNetworkAd(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2) {
        java.lang.Object obj;
        java.lang.Object obj2;
        this.b = map.get("unit_id") != null ? map.get("unit_id").toString() : "";
        int parseInt = (!map.containsKey("close_button") || (obj2 = map.get("close_button")) == null) ? 0 : java.lang.Integer.parseInt(obj2.toString());
        java.lang.String obj3 = (!map.containsKey(com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE) || (obj = map.get(com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE)) == null) ? com.anythink.core.common.f.n.a : obj.toString();
        com.anythink.core.common.f.m mVar = (com.anythink.core.common.f.m) map.get(com.anythink.core.common.b.h.o.a);
        this.a = mVar;
        com.anythink.basead.d.a aVar = new com.anythink.basead.d.a(context, com.anythink.basead.d.b.EnumC0136b.ONLINE_API_OFFER_REQUEST_TYPE, mVar);
        this.d = aVar;
        aVar.a(new com.anythink.basead.d.c.a().c(parseInt).b(obj3).a());
        this.d.a(new com.anythink.network.onlineapi.OnlineApiATBannerAdapter.AnonymousClass2());
        this.d.a(new com.anythink.network.onlineapi.OnlineApiATBannerAdapter.AnonymousClass1());
    }
}
