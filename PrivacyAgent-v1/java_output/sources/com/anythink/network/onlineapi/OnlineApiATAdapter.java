package com.anythink.network.onlineapi;

/* loaded from: classes12.dex */
public class OnlineApiATAdapter extends com.anythink.nativead.unitgroup.api.CustomNativeAdapter {
    com.anythink.basead.d.e a;
    com.anythink.core.common.f.m b;
    java.lang.String c;

    /* renamed from: com.anythink.network.onlineapi.OnlineApiATAdapter$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.basead.e.d {
        final /* synthetic */ int a;
        final /* synthetic */ int b;
        final /* synthetic */ android.content.Context c;

        public AnonymousClass1(int i, int i2, android.content.Context context) {
            this.a = i;
            this.b = i2;
            this.c = context;
        }

        @Override // com.anythink.basead.e.d
        public final void onNativeAdLoadError(com.anythink.basead.c.e eVar) {
            if (((com.anythink.core.api.ATBaseAdAdapter) com.anythink.network.onlineapi.OnlineApiATAdapter.this).mLoadListener != null) {
                ((com.anythink.core.api.ATBaseAdAdapter) com.anythink.network.onlineapi.OnlineApiATAdapter.this).mLoadListener.onAdLoadError(eVar.a(), eVar.b());
            }
        }

        @Override // com.anythink.basead.e.d
        public final void onNativeAdLoaded(com.anythink.basead.d.h... hVarArr) {
            com.anythink.network.onlineapi.OnlineApiATNativeAd[] onlineApiATNativeAdArr = new com.anythink.network.onlineapi.OnlineApiATNativeAd[hVarArr.length];
            for (int i = 0; i < hVarArr.length; i++) {
                hVarArr[i].a(this.a, this.b);
                onlineApiATNativeAdArr[i] = new com.anythink.network.onlineapi.OnlineApiATNativeAd(this.c, hVarArr[i]);
            }
            if (((com.anythink.core.api.ATBaseAdAdapter) com.anythink.network.onlineapi.OnlineApiATAdapter.this).mLoadListener != null) {
                ((com.anythink.core.api.ATBaseAdAdapter) com.anythink.network.onlineapi.OnlineApiATAdapter.this).mLoadListener.onAdCacheLoaded(onlineApiATNativeAdArr);
            }
        }
    }

    private void a(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map) {
        this.c = map.get("unit_id") != null ? map.get("unit_id").toString() : "";
        com.anythink.core.common.f.m mVar = (com.anythink.core.common.f.m) map.get(com.anythink.core.common.b.h.o.a);
        this.b = mVar;
        this.a = new com.anythink.basead.d.e(context, com.anythink.basead.d.b.EnumC0136b.ONLINE_API_OFFER_REQUEST_TYPE, mVar, false);
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void destory() {
        if (this.a != null) {
            this.a = null;
        }
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

    /* JADX WARN: Removed duplicated region for block: B:11:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0066  */
    @Override // com.anythink.core.api.ATBaseAdAdapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void loadCustomNetworkAd(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2) {
        int i;
        int parseInt;
        int i2;
        int i3;
        this.c = map.get("unit_id") != null ? map.get("unit_id").toString() : "";
        com.anythink.core.common.f.m mVar = (com.anythink.core.common.f.m) map.get(com.anythink.core.common.b.h.o.a);
        this.b = mVar;
        this.a = new com.anythink.basead.d.e(context, com.anythink.basead.d.b.EnumC0136b.ONLINE_API_OFFER_REQUEST_TYPE, mVar, false);
        int i4 = -1;
        if (map2 != null) {
            try {
                i = java.lang.Integer.parseInt(map2.get(com.anythink.core.api.ATAdConst.KEY.AD_WIDTH).toString());
            } catch (java.lang.Throwable unused) {
                i = -1;
            }
            try {
                parseInt = java.lang.Integer.parseInt(map2.get(com.anythink.core.api.ATAdConst.KEY.AD_HEIGHT).toString());
                i4 = i;
            } catch (java.lang.Throwable unused2) {
                i4 = i;
            }
            i2 = context.getResources().getDisplayMetrics().widthPixels;
            i3 = context.getResources().getDisplayMetrics().heightPixels;
            if (i4 <= 0) {
                i4 = java.lang.Math.min(i2, i3);
            }
            if (parseInt <= 0) {
                parseInt = (i4 * 3) / 4;
            }
            if (i4 <= i2) {
                i2 = i4;
            }
            if (parseInt <= i3) {
                i3 = parseInt;
            }
            this.a.a(new com.anythink.network.onlineapi.OnlineApiATAdapter.AnonymousClass1(i2, i3, context.getApplicationContext()));
        }
        parseInt = -1;
        i2 = context.getResources().getDisplayMetrics().widthPixels;
        i3 = context.getResources().getDisplayMetrics().heightPixels;
        if (i4 <= 0) {
        }
        if (parseInt <= 0) {
        }
        if (i4 <= i2) {
        }
        if (parseInt <= i3) {
        }
        this.a.a(new com.anythink.network.onlineapi.OnlineApiATAdapter.AnonymousClass1(i2, i3, context.getApplicationContext()));
    }
}
