package com.anythink.network.myoffer;

/* loaded from: classes12.dex */
public class MyOfferATAdapter extends com.anythink.nativead.unitgroup.api.CustomNativeAdapter {
    com.anythink.basead.f.e a;
    com.anythink.core.common.f.m b;
    private java.lang.String c = "";
    private boolean d = false;

    /* renamed from: com.anythink.network.myoffer.MyOfferATAdapter$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.basead.e.c {
        final /* synthetic */ android.content.Context a;

        public AnonymousClass1(android.content.Context context) {
            this.a = context;
        }

        @Override // com.anythink.basead.e.c
        public final void onAdCacheLoaded() {
            if (((com.anythink.core.api.ATBaseAdAdapter) com.anythink.network.myoffer.MyOfferATAdapter.this).mLoadListener != null) {
                ((com.anythink.core.api.ATBaseAdAdapter) com.anythink.network.myoffer.MyOfferATAdapter.this).mLoadListener.onAdCacheLoaded(new com.anythink.network.myoffer.MyOfferATNativeAd(this.a, com.anythink.network.myoffer.MyOfferATAdapter.this.a));
            }
        }

        @Override // com.anythink.basead.e.c
        public final void onAdDataLoaded() {
        }

        @Override // com.anythink.basead.e.c
        public final void onAdLoadFailed(com.anythink.basead.c.e eVar) {
            if (((com.anythink.core.api.ATBaseAdAdapter) com.anythink.network.myoffer.MyOfferATAdapter.this).mLoadListener != null) {
                ((com.anythink.core.api.ATBaseAdAdapter) com.anythink.network.myoffer.MyOfferATAdapter.this).mLoadListener.onAdLoadError(eVar.a(), eVar.b());
            }
        }
    }

    private void a(android.content.Context context) {
        this.a = new com.anythink.basead.f.e(context, this.b, this.c, this.d);
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void destory() {
        com.anythink.basead.f.e eVar = this.a;
        if (eVar != null) {
            eVar.a((com.anythink.basead.e.a) null);
            this.a = null;
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public com.anythink.core.api.BaseAd getBaseAdObject(android.content.Context context) {
        com.anythink.basead.f.e eVar = this.a;
        if (eVar == null || !eVar.a()) {
            return null;
        }
        return new com.anythink.network.myoffer.MyOfferATNativeAd(context, this.a);
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public java.lang.String getNetworkName() {
        return "MyOffer";
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public java.lang.String getNetworkPlacementId() {
        return this.c;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public java.lang.String getNetworkSDKVersion() {
        return com.anythink.core.common.o.h.a();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public boolean initNetworkObjectByPlacementId(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2) {
        if (map.containsKey("my_oid")) {
            this.c = map.get("my_oid").toString();
        }
        if (map.containsKey(com.anythink.core.common.b.h.o.a)) {
            this.b = (com.anythink.core.common.f.m) map.get(com.anythink.core.common.b.h.o.a);
        }
        if (map.containsKey(com.anythink.core.common.r.b)) {
            this.d = ((java.lang.Boolean) map.get(com.anythink.core.common.r.b)).booleanValue();
        }
        this.a = new com.anythink.basead.f.e(context, this.b, this.c, this.d);
        return true;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void loadCustomNetworkAd(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2) {
        if (map.containsKey("my_oid")) {
            this.c = map.get("my_oid").toString();
        }
        if (map.containsKey(com.anythink.core.common.b.h.o.a)) {
            this.b = (com.anythink.core.common.f.m) map.get(com.anythink.core.common.b.h.o.a);
        }
        this.a = new com.anythink.basead.f.e(context, this.b, this.c, this.d);
        this.a.a(new com.anythink.network.myoffer.MyOfferATAdapter.AnonymousClass1(context.getApplicationContext()));
    }
}
