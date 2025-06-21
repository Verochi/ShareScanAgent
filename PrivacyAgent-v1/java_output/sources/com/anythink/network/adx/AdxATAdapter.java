package com.anythink.network.adx;

/* loaded from: classes12.dex */
public class AdxATAdapter extends com.anythink.nativead.unitgroup.api.CustomNativeAdapter {
    com.anythink.basead.d.e a;
    com.anythink.core.common.f.m b;
    boolean c;
    boolean d;
    java.lang.String e;
    int f;
    int g;
    private boolean h;

    /* renamed from: com.anythink.network.adx.AdxATAdapter$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.basead.e.d {
        final /* synthetic */ android.content.Context a;

        public AnonymousClass1(android.content.Context context) {
            this.a = context;
        }

        @Override // com.anythink.basead.e.d
        public final void onNativeAdLoadError(com.anythink.basead.c.e eVar) {
            if (((com.anythink.core.api.ATBaseAdAdapter) com.anythink.network.adx.AdxATAdapter.this).mLoadListener != null) {
                ((com.anythink.core.api.ATBaseAdAdapter) com.anythink.network.adx.AdxATAdapter.this).mLoadListener.onAdLoadError(eVar.a(), eVar.b());
            }
        }

        @Override // com.anythink.basead.e.d
        public final void onNativeAdLoaded(com.anythink.basead.d.h... hVarArr) {
            com.anythink.network.adx.AdxATNativeAd[] adxATNativeAdArr = new com.anythink.network.adx.AdxATNativeAd[hVarArr.length];
            for (int i = 0; i < hVarArr.length; i++) {
                com.anythink.basead.d.h hVar = hVarArr[i];
                com.anythink.network.adx.AdxATAdapter adxATAdapter = com.anythink.network.adx.AdxATAdapter.this;
                hVar.a(adxATAdapter.f, adxATAdapter.g);
                hVar.a(com.anythink.network.adx.AdxATAdapter.this.d);
                hVar.a(com.anythink.network.adx.AdxATAdapter.this.e);
                adxATNativeAdArr[i] = new com.anythink.network.adx.AdxATNativeAd(this.a.getApplicationContext(), hVar, com.anythink.network.adx.AdxATAdapter.this.h, com.anythink.network.adx.AdxATAdapter.this.c);
            }
            if (((com.anythink.core.api.ATBaseAdAdapter) com.anythink.network.adx.AdxATAdapter.this).mLoadListener != null) {
                ((com.anythink.core.api.ATBaseAdAdapter) com.anythink.network.adx.AdxATAdapter.this).mLoadListener.onAdCacheLoaded(adxATNativeAdArr);
            }
        }
    }

    private void a(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2) {
        int i;
        int i2;
        this.h = android.text.TextUtils.equals("1", com.anythink.core.api.ATInitMediation.getStringFromMap(map, "layout_type"));
        com.anythink.core.common.f.m mVar = (com.anythink.core.common.f.m) map.get(com.anythink.core.common.b.h.o.a);
        this.b = mVar;
        this.a = new com.anythink.basead.d.e(context, com.anythink.basead.d.b.EnumC0136b.ADX_OFFER_REQUEST_TYPE, mVar, this.h);
        this.c = android.text.TextUtils.equals("0", com.anythink.core.api.ATInitMediation.getStringFromMap(map, "close_button", "0"));
        this.d = android.text.TextUtils.equals("0", com.anythink.core.api.ATInitMediation.getStringFromMap(map, "v_m", "0"));
        this.e = com.anythink.core.api.ATInitMediation.getStringFromMap(map, "video_autoplay", "1");
        if (map2 != null) {
            i = com.anythink.core.api.ATInitMediation.getIntFromMap(map2, com.anythink.core.api.ATAdConst.KEY.AD_WIDTH);
            i2 = com.anythink.core.api.ATInitMediation.getIntFromMap(map2, com.anythink.core.api.ATAdConst.KEY.AD_HEIGHT);
        } else {
            i = -1;
            i2 = -1;
        }
        int i3 = context.getResources().getDisplayMetrics().widthPixels;
        int i4 = context.getResources().getDisplayMetrics().heightPixels;
        if (i <= 0) {
            i = java.lang.Math.min(i3, i4);
        }
        if (i2 <= 0) {
            i2 = (i * 3) / 4;
        }
        if (i <= i3) {
            i3 = i;
        }
        if (i2 <= i4) {
            i4 = i2;
        }
        this.f = i3;
        this.g = i4;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void destory() {
        if (this.a != null) {
            this.a = null;
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public com.anythink.core.api.BaseAd getBaseAdObject(android.content.Context context) {
        com.anythink.basead.d.e eVar = this.a;
        if (eVar == null || !eVar.c()) {
            return null;
        }
        com.anythink.basead.d.h a = this.a.a();
        a.a(this.f, this.g);
        a.a(this.d);
        a.a(this.e);
        com.anythink.network.adx.AdxATNativeAd adxATNativeAd = new com.anythink.network.adx.AdxATNativeAd(context.getApplicationContext(), a, this.h, this.c);
        adxATNativeAd.setNetworkInfoMap(com.anythink.basead.b.a(this.a.f()));
        return adxATNativeAd;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void getBidRequestInfo(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2, com.anythink.core.api.ATBidRequestInfoListener aTBidRequestInfoListener) {
        com.anythink.core.common.f.m mVar = (com.anythink.core.common.f.m) map.get(com.anythink.core.common.b.h.o.a);
        com.anythink.network.adx.AdxBidRequestInfo adxBidRequestInfo = new com.anythink.network.adx.AdxBidRequestInfo(context, mVar != null ? mVar.b : "");
        boolean equals = android.text.TextUtils.equals("1", com.anythink.core.api.ATInitMediation.getStringFromMap(map, "layout_type"));
        this.h = equals;
        if (equals) {
            adxBidRequestInfo.fillAdAcceptType();
        }
        if (aTBidRequestInfoListener != null) {
            aTBidRequestInfoListener.onSuccess(adxBidRequestInfo);
        }
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
        a(context, map, map2);
        com.anythink.basead.d.e eVar = this.a;
        if (eVar == null || eVar.c()) {
            return true;
        }
        this.a.d();
        return true;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void loadCustomNetworkAd(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2) {
        a(context, map, map2);
        this.a.a(new com.anythink.network.adx.AdxATAdapter.AnonymousClass1(context));
    }
}
