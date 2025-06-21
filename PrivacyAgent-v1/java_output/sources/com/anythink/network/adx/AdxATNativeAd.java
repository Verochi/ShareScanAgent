package com.anythink.network.adx;

/* loaded from: classes12.dex */
public class AdxATNativeAd extends com.anythink.nativead.unitgroup.api.CustomNativeAd {
    com.anythink.basead.d.h a;
    android.content.Context b;
    boolean c;
    boolean d;
    android.view.View e;
    com.anythink.basead.e.e f;

    /* renamed from: com.anythink.network.adx.AdxATNativeAd$1, reason: invalid class name */
    public class AnonymousClass1 extends com.anythink.basead.e.e {
        final /* synthetic */ android.content.Context c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(com.anythink.core.common.f.l lVar, com.anythink.core.common.f.h hVar, android.content.Context context) {
            super(lVar, hVar);
            this.c = context;
        }

        @Override // com.anythink.basead.e.e, com.anythink.basead.e.a
        public final void onAdClick(com.anythink.basead.e.i iVar) {
            super.onAdClick(iVar);
            com.anythink.network.adx.AdxATNativeAd.this.notifyAdClicked();
            if (com.anythink.network.adx.AdxATNativeAd.this.a.a().q() == 67) {
                if (com.anythink.network.adx.AdxATNativeAd.this.a.a(true, false)) {
                    com.anythink.core.common.d.c.a(this.c).a(com.anythink.network.adx.AdxATNativeAd.this.a.a().s(), 1, 0);
                }
                if (com.anythink.network.adx.AdxATNativeAd.this.a.a(false, false)) {
                    com.anythink.core.common.d.b.a(this.c).a(com.anythink.network.adx.AdxATNativeAd.this.a.a().s(), 1, 0);
                }
            }
        }

        @Override // com.anythink.basead.e.a
        public final void onAdClosed() {
            com.anythink.network.adx.AdxATNativeAd.this.notifyAdDislikeClick();
        }

        @Override // com.anythink.basead.e.e, com.anythink.basead.e.a
        public final void onAdShow(com.anythink.basead.e.i iVar) {
            super.onAdShow(iVar);
            com.anythink.network.adx.AdxATNativeAd.this.notifyAdImpression();
            if (com.anythink.network.adx.AdxATNativeAd.this.a.a().q() == 67) {
                if (com.anythink.network.adx.AdxATNativeAd.this.a.a(true, true)) {
                    com.anythink.core.common.d.c.a(this.c).a(com.anythink.network.adx.AdxATNativeAd.this.a.a().s(), 0, 1);
                }
                if (com.anythink.network.adx.AdxATNativeAd.this.a.a(false, true)) {
                    com.anythink.core.common.d.b.a(this.c).a(com.anythink.network.adx.AdxATNativeAd.this.a.a().s(), 0, 1);
                }
            }
        }

        @Override // com.anythink.basead.e.a
        public final void onDeeplinkCallback(boolean z) {
            com.anythink.network.adx.AdxATNativeAd.this.notifyDeeplinkCallback(z);
        }

        @Override // com.anythink.basead.e.a
        public final void onShowFailed(com.anythink.basead.c.e eVar) {
        }
    }

    /* renamed from: com.anythink.network.adx.AdxATNativeAd$2, reason: invalid class name */
    public class AnonymousClass2 implements com.anythink.basead.ui.BaseMediaATView.a {
        public AnonymousClass2() {
        }

        @Override // com.anythink.basead.ui.BaseMediaATView.a
        public final void onClickCloseView() {
            com.anythink.network.adx.AdxATNativeAd.this.notifyAdDislikeClick();
        }
    }

    public AdxATNativeAd(android.content.Context context, com.anythink.basead.d.h hVar, boolean z, boolean z2) {
        this.b = context.getApplicationContext();
        this.a = hVar;
        setNetworkInfoMap(com.anythink.basead.b.a(hVar.a()));
        com.anythink.network.adx.AdxATNativeAd.AnonymousClass1 anonymousClass1 = new com.anythink.network.adx.AdxATNativeAd.AnonymousClass1(this.a.a(), null, context);
        this.f = anonymousClass1;
        this.a.a(anonymousClass1);
        this.c = z;
        this.d = z2;
        int t = this.a.t();
        if (t == 1) {
            this.mAdSourceType = "1";
        } else if (t == 2) {
            this.mAdSourceType = "2";
        }
        if (this.a.o()) {
            return;
        }
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
        if (this.e == null) {
            this.e = this.a.a(this.b, this.d, new com.anythink.network.adx.AdxATNativeAd.AnonymousClass2());
        }
        return this.e;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public android.view.ViewGroup getCustomAdContainer() {
        if (this.a == null || this.c) {
            return null;
        }
        return new com.anythink.basead.ui.OwnNativeATView(this.b);
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public boolean isNativeExpress() {
        return this.a.o();
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void onPause() {
        com.anythink.basead.d.h hVar = this.a;
        if (hVar != null) {
            hVar.s();
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void onResume() {
        com.anythink.basead.d.h hVar = this.a;
        if (hVar != null) {
            hVar.r();
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void prepare(android.view.View view, com.anythink.nativead.api.ATNativePrepareInfo aTNativePrepareInfo) {
        com.anythink.basead.e.e eVar = this.f;
        if (eVar != null) {
            eVar.updateTrackingInfo(getDetail());
        }
        this.a.r();
        if (this.c || this.a == null) {
            return;
        }
        java.util.List<android.view.View> clickViewList = aTNativePrepareInfo.getClickViewList();
        if (clickViewList == null || clickViewList.size() <= 0) {
            this.a.a(view);
        } else {
            this.a.a(view, clickViewList);
        }
    }
}
