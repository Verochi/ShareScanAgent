package com.anythink.network.myoffer;

/* loaded from: classes12.dex */
public class MyOfferATNativeAd extends com.anythink.nativead.unitgroup.api.CustomNativeAd {
    com.anythink.basead.f.e a;
    android.content.Context b;
    android.view.View c;

    /* renamed from: com.anythink.network.myoffer.MyOfferATNativeAd$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.basead.e.a {
        public AnonymousClass1() {
        }

        @Override // com.anythink.basead.e.a
        public final void onAdClick(com.anythink.basead.e.i iVar) {
            com.anythink.core.common.f.h detail = com.anythink.network.myoffer.MyOfferATNativeAd.this.getDetail();
            if (detail != null) {
                detail.B(iVar.a);
                detail.C(iVar.b);
            }
            com.anythink.network.myoffer.MyOfferATNativeAd.this.notifyAdClicked();
        }

        @Override // com.anythink.basead.e.a
        public final void onAdClosed() {
        }

        @Override // com.anythink.basead.e.a
        public final void onAdShow(com.anythink.basead.e.i iVar) {
            com.anythink.network.myoffer.MyOfferATNativeAd.this.notifyAdImpression();
        }

        @Override // com.anythink.basead.e.a
        public final void onDeeplinkCallback(boolean z) {
        }

        @Override // com.anythink.basead.e.a
        public final void onShowFailed(com.anythink.basead.c.e eVar) {
        }
    }

    public MyOfferATNativeAd(android.content.Context context, com.anythink.basead.f.e eVar) {
        this.b = context.getApplicationContext();
        this.a = eVar;
        eVar.a(new com.anythink.network.myoffer.MyOfferATNativeAd.AnonymousClass1());
        setNetworkInfoMap(com.anythink.basead.b.a(this.a.e()));
        setAdChoiceIconUrl(this.a.j());
        setTitle(this.a.b());
        setDescriptionText(this.a.f());
        setIconImageUrl(this.a.h());
        setMainImageUrl(this.a.i());
        setCallToActionText(this.a.g());
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void clear(android.view.View view) {
        com.anythink.basead.f.e eVar = this.a;
        if (eVar != null) {
            eVar.l();
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void destroy() {
        com.anythink.basead.f.e eVar = this.a;
        if (eVar != null) {
            eVar.a((com.anythink.basead.e.a) null);
            this.a.m();
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a, com.anythink.core.api.IATThirdPartyMaterial
    public android.view.View getAdMediaView(java.lang.Object... objArr) {
        if (this.c == null) {
            this.c = com.anythink.basead.f.e.k();
        }
        return this.c;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void prepare(android.view.View view, com.anythink.nativead.api.ATNativePrepareInfo aTNativePrepareInfo) {
        if (this.a != null) {
            java.util.List<android.view.View> clickViewList = aTNativePrepareInfo.getClickViewList();
            if (clickViewList == null || clickViewList.size() <= 0) {
                this.a.a(view);
            } else {
                this.a.a(view, clickViewList);
            }
        }
    }
}
