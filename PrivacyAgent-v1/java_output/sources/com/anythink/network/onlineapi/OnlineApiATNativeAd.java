package com.anythink.network.onlineapi;

/* loaded from: classes12.dex */
public class OnlineApiATNativeAd extends com.anythink.nativead.unitgroup.api.CustomNativeAd {
    com.anythink.basead.d.h a;
    android.content.Context b;
    android.view.View c;

    /* renamed from: com.anythink.network.onlineapi.OnlineApiATNativeAd$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.basead.e.a {
        public AnonymousClass1() {
        }

        @Override // com.anythink.basead.e.a
        public final void onAdClick(com.anythink.basead.e.i iVar) {
            com.anythink.core.common.f.h detail = com.anythink.network.onlineapi.OnlineApiATNativeAd.this.getDetail();
            if (detail != null) {
                detail.B(iVar.a);
                detail.C(iVar.b);
            }
            com.anythink.network.onlineapi.OnlineApiATNativeAd.this.notifyAdClicked();
        }

        @Override // com.anythink.basead.e.a
        public final void onAdClosed() {
        }

        @Override // com.anythink.basead.e.a
        public final void onAdShow(com.anythink.basead.e.i iVar) {
            com.anythink.network.onlineapi.OnlineApiATNativeAd.this.notifyAdImpression();
        }

        @Override // com.anythink.basead.e.a
        public final void onDeeplinkCallback(boolean z) {
            com.anythink.network.onlineapi.OnlineApiATNativeAd.this.notifyDeeplinkCallback(z);
        }

        @Override // com.anythink.basead.e.a
        public final void onShowFailed(com.anythink.basead.c.e eVar) {
        }
    }

    public OnlineApiATNativeAd(android.content.Context context, com.anythink.basead.d.h hVar) {
        this.b = context.getApplicationContext();
        this.a = hVar;
        hVar.a(new com.anythink.network.onlineapi.OnlineApiATNativeAd.AnonymousClass1());
        setNetworkInfoMap(com.anythink.basead.b.a(this.a.a()));
        setAdChoiceIconUrl(this.a.g());
        setTitle(this.a.b());
        setDescriptionText(this.a.c());
        setIconImageUrl(this.a.e());
        setMainImageUrl(this.a.f());
        setCallToActionText(this.a.d());
        if (this.a.n()) {
            setAdAppInfo(new com.anythink.network.adx.AdxAppDownloadInfo(this.a));
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void clear(android.view.View view) {
        com.anythink.basead.d.h hVar = this.a;
        if (hVar != null) {
            hVar.p();
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void destroy() {
        com.anythink.basead.d.h hVar = this.a;
        if (hVar != null) {
            hVar.a((com.anythink.basead.e.a) null);
            this.a.q();
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a, com.anythink.core.api.IATThirdPartyMaterial
    public android.view.View getAdMediaView(java.lang.Object... objArr) {
        if (this.c == null) {
            this.c = this.a.a(this.b, false, (com.anythink.basead.ui.BaseMediaATView.a) null);
        }
        return this.c;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public android.view.ViewGroup getCustomAdContainer() {
        if (this.a != null) {
            return new com.anythink.basead.ui.OwnNativeATView(this.b);
        }
        return null;
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
