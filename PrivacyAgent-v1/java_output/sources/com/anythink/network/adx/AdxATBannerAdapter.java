package com.anythink.network.adx;

/* loaded from: classes12.dex */
public class AdxATBannerAdapter extends com.anythink.banner.unitgroup.api.CustomBannerAdapter {
    com.anythink.core.common.f.m a;
    java.util.Map<java.lang.String, java.lang.Object> b;
    private com.anythink.basead.d.a c;
    private android.view.View d;

    /* renamed from: com.anythink.network.adx.AdxATBannerAdapter$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.basead.e.c {

        /* renamed from: com.anythink.network.adx.AdxATBannerAdapter$1$1, reason: invalid class name and collision with other inner class name */
        public class C02341 extends com.anythink.basead.e.e {
            public C02341(com.anythink.core.common.f.l lVar, com.anythink.core.common.f.h hVar) {
                super(lVar, hVar);
            }

            @Override // com.anythink.basead.e.e, com.anythink.basead.e.a
            public final void onAdClick(com.anythink.basead.e.i iVar) {
                super.onAdClick(iVar);
                if (com.anythink.network.adx.AdxATBannerAdapter.this.mImpressionEventListener != null) {
                    com.anythink.network.adx.AdxATBannerAdapter.this.mImpressionEventListener.onBannerAdClicked();
                }
            }

            @Override // com.anythink.basead.e.a
            public final void onAdClosed() {
                if (com.anythink.network.adx.AdxATBannerAdapter.this.mImpressionEventListener != null) {
                    com.anythink.network.adx.AdxATBannerAdapter.this.mImpressionEventListener.onBannerAdClose();
                }
            }

            @Override // com.anythink.basead.e.e, com.anythink.basead.e.a
            public final void onAdShow(com.anythink.basead.e.i iVar) {
                super.onAdShow(iVar);
                if (com.anythink.network.adx.AdxATBannerAdapter.this.mImpressionEventListener != null) {
                    com.anythink.network.adx.AdxATBannerAdapter.this.mImpressionEventListener.onBannerAdShow();
                }
            }

            @Override // com.anythink.basead.e.a
            public final void onDeeplinkCallback(boolean z) {
                if (com.anythink.network.adx.AdxATBannerAdapter.this.mImpressionEventListener != null) {
                    com.anythink.network.adx.AdxATBannerAdapter.this.mImpressionEventListener.onDeeplinkCallback(z);
                }
            }

            @Override // com.anythink.basead.e.a
            public final void onShowFailed(com.anythink.basead.c.e eVar) {
            }
        }

        public AnonymousClass1() {
        }

        @Override // com.anythink.basead.e.c
        public final void onAdCacheLoaded() {
            if (com.anythink.network.adx.AdxATBannerAdapter.this.c == null || com.anythink.network.adx.AdxATBannerAdapter.this.mLoadListener == null) {
                return;
            }
            com.anythink.network.adx.AdxATBannerAdapter adxATBannerAdapter = com.anythink.network.adx.AdxATBannerAdapter.this;
            adxATBannerAdapter.b = com.anythink.basead.b.a(adxATBannerAdapter.c);
            com.anythink.network.adx.AdxATBannerAdapter.this.c.a(new com.anythink.network.adx.AdxATBannerAdapter.AnonymousClass1.C02341(com.anythink.network.adx.AdxATBannerAdapter.this.c.f(), com.anythink.network.adx.AdxATBannerAdapter.this.getTrackingInfo()));
            com.anythink.network.adx.AdxATBannerAdapter adxATBannerAdapter2 = com.anythink.network.adx.AdxATBannerAdapter.this;
            adxATBannerAdapter2.d = adxATBannerAdapter2.c.a();
            if (com.anythink.network.adx.AdxATBannerAdapter.this.d != null) {
                com.anythink.network.adx.AdxATBannerAdapter.this.mLoadListener.onAdCacheLoaded(new com.anythink.core.api.BaseAd[0]);
            } else {
                com.anythink.network.adx.AdxATBannerAdapter.this.mLoadListener.onAdLoadError("", "Adx bannerView = null");
            }
        }

        @Override // com.anythink.basead.e.c
        public final void onAdDataLoaded() {
            if (com.anythink.network.adx.AdxATBannerAdapter.this.mLoadListener != null) {
                com.anythink.network.adx.AdxATBannerAdapter.this.mLoadListener.onAdDataLoaded();
            }
        }

        @Override // com.anythink.basead.e.c
        public final void onAdLoadFailed(com.anythink.basead.c.e eVar) {
            if (com.anythink.network.adx.AdxATBannerAdapter.this.mLoadListener != null) {
                com.anythink.network.adx.AdxATBannerAdapter.this.mLoadListener.onAdLoadError(eVar.a(), eVar.b());
            }
        }
    }

    /* renamed from: com.anythink.network.adx.AdxATBannerAdapter$2, reason: invalid class name */
    public class AnonymousClass2 extends com.anythink.basead.e.e {
        public AnonymousClass2(com.anythink.core.common.f.l lVar, com.anythink.core.common.f.h hVar) {
            super(lVar, hVar);
        }

        @Override // com.anythink.basead.e.e, com.anythink.basead.e.a
        public final void onAdClick(com.anythink.basead.e.i iVar) {
            super.onAdClick(iVar);
            if (com.anythink.network.adx.AdxATBannerAdapter.this.mImpressionEventListener != null) {
                com.anythink.network.adx.AdxATBannerAdapter.this.mImpressionEventListener.onBannerAdClicked();
            }
        }

        @Override // com.anythink.basead.e.a
        public final void onAdClosed() {
            if (com.anythink.network.adx.AdxATBannerAdapter.this.mImpressionEventListener != null) {
                com.anythink.network.adx.AdxATBannerAdapter.this.mImpressionEventListener.onBannerAdClose();
            }
        }

        @Override // com.anythink.basead.e.e, com.anythink.basead.e.a
        public final void onAdShow(com.anythink.basead.e.i iVar) {
            super.onAdShow(iVar);
            if (com.anythink.network.adx.AdxATBannerAdapter.this.mImpressionEventListener != null) {
                com.anythink.network.adx.AdxATBannerAdapter.this.mImpressionEventListener.onBannerAdShow();
            }
        }

        @Override // com.anythink.basead.e.a
        public final void onDeeplinkCallback(boolean z) {
            if (com.anythink.network.adx.AdxATBannerAdapter.this.mImpressionEventListener != null) {
                com.anythink.network.adx.AdxATBannerAdapter.this.mImpressionEventListener.onDeeplinkCallback(z);
            }
        }

        @Override // com.anythink.basead.e.a
        public final void onShowFailed(com.anythink.basead.c.e eVar) {
        }
    }

    /* renamed from: com.anythink.network.adx.AdxATBannerAdapter$3, reason: invalid class name */
    public class AnonymousClass3 implements com.anythink.basead.d.b.a {

        /* renamed from: com.anythink.network.adx.AdxATBannerAdapter$3$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.network.adx.AdxATBannerAdapter adxATBannerAdapter = com.anythink.network.adx.AdxATBannerAdapter.this;
                adxATBannerAdapter.d = adxATBannerAdapter.c.a();
            }
        }

        public AnonymousClass3() {
        }

        @Override // com.anythink.basead.d.b.a
        public final void onAdCacheLoaded() {
            com.anythink.network.adx.AdxATBannerAdapter.this.postOnMainThread(new com.anythink.network.adx.AdxATBannerAdapter.AnonymousClass3.AnonymousClass1());
        }
    }

    private void a(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2) {
        java.lang.Object obj;
        java.lang.Object obj2;
        int i = 0;
        int parseInt = (!map.containsKey("close_button") || (obj2 = map.get("close_button")) == null) ? 0 : java.lang.Integer.parseInt(obj2.toString());
        java.lang.String obj3 = (!map.containsKey(com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE) || (obj = map.get(com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE)) == null) ? com.anythink.core.common.f.n.a : obj.toString();
        if (map2 != null && map2.containsKey(com.anythink.core.api.ATAdConst.KEY.AD_HEIGHT)) {
            try {
                i = (int) java.lang.Double.parseDouble(map2.get(com.anythink.core.api.ATAdConst.KEY.AD_HEIGHT).toString());
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
        com.anythink.core.common.f.m mVar = (com.anythink.core.common.f.m) map.get(com.anythink.core.common.b.h.o.a);
        this.a = mVar;
        com.anythink.basead.d.a aVar = new com.anythink.basead.d.a(context, com.anythink.basead.d.b.EnumC0136b.ADX_OFFER_REQUEST_TYPE, mVar);
        this.c = aVar;
        aVar.a(new com.anythink.basead.d.c.a().c(parseInt).b(obj3).g(i).a());
    }

    public void destory() {
        this.d = null;
        com.anythink.basead.d.a aVar = this.c;
        if (aVar != null) {
            aVar.a((com.anythink.basead.e.a) null);
            this.c.b();
            this.c = null;
        }
    }

    public android.view.View getBannerView() {
        com.anythink.basead.d.a aVar = this.c;
        if (aVar != null && this.b == null) {
            this.b = com.anythink.basead.b.a(aVar);
        }
        return this.d;
    }

    public void getBidRequestInfo(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2, com.anythink.core.api.ATBidRequestInfoListener aTBidRequestInfoListener) {
        com.anythink.core.common.f.m mVar = (com.anythink.core.common.f.m) map.get(com.anythink.core.common.b.h.o.a);
        com.anythink.network.adx.AdxBidRequestInfo adxBidRequestInfo = new com.anythink.network.adx.AdxBidRequestInfo(context, mVar != null ? mVar.b : "");
        adxBidRequestInfo.fillBannerData(map);
        if (aTBidRequestInfoListener != null) {
            aTBidRequestInfoListener.onSuccess(adxBidRequestInfo);
        }
    }

    public java.util.Map<java.lang.String, java.lang.Object> getNetworkInfoMap() {
        return this.b;
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
        a(context, map, map2);
        com.anythink.basead.d.a aVar = this.c;
        if (aVar == null) {
            return true;
        }
        aVar.a(new com.anythink.network.adx.AdxATBannerAdapter.AnonymousClass2(aVar.f(), getTrackingInfo()));
        this.c.a(new com.anythink.network.adx.AdxATBannerAdapter.AnonymousClass3());
        return true;
    }

    public void loadCustomNetworkAd(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2) {
        a(context, map, map2);
        this.c.a(new com.anythink.network.adx.AdxATBannerAdapter.AnonymousClass1());
    }
}
