package com.anythink.network.baidu;

/* loaded from: classes12.dex */
public class BaiduATNativeExpressFeedAd extends com.anythink.nativead.unitgroup.api.CustomNativeAd {
    private final android.content.Context a;
    private final com.baidu.mobads.sdk.api.ExpressResponse b;
    private android.widget.FrameLayout c;

    /* renamed from: com.anythink.network.baidu.BaiduATNativeExpressFeedAd$1, reason: invalid class name */
    public class AnonymousClass1 implements com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener {
        public AnonymousClass1() {
        }

        @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
        public final void onAdClick() {
            com.anythink.network.baidu.BaiduATNativeExpressFeedAd.this.notifyAdClicked();
        }

        @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
        public final void onAdExposed() {
            com.anythink.network.baidu.BaiduATNativeExpressFeedAd.this.notifyAdImpression();
        }

        @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
        public final void onAdRenderFail(android.view.View view, java.lang.String str, int i) {
        }

        @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
        public final void onAdRenderSuccess(android.view.View view, float f, float f2) {
        }

        @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
        public final void onAdUnionClick() {
        }
    }

    /* renamed from: com.anythink.network.baidu.BaiduATNativeExpressFeedAd$2, reason: invalid class name */
    public class AnonymousClass2 implements com.baidu.mobads.sdk.api.ExpressResponse.ExpressDislikeListener {
        public AnonymousClass2() {
        }

        @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressDislikeListener
        public final void onDislikeItemClick(java.lang.String str) {
            com.anythink.network.baidu.BaiduATNativeExpressFeedAd.this.notifyAdDislikeClick();
        }

        @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressDislikeListener
        public final void onDislikeWindowClose() {
        }

        @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressDislikeListener
        public final void onDislikeWindowShow() {
        }
    }

    public BaiduATNativeExpressFeedAd(android.content.Context context, com.baidu.mobads.sdk.api.ExpressResponse expressResponse) {
        this.a = context;
        this.b = expressResponse;
        this.c = new android.widget.FrameLayout(context);
        int adActionType = expressResponse.getAdActionType();
        int i = 2;
        if (adActionType != 1) {
            if (adActionType != 2) {
                i = 3;
                if (adActionType != 3) {
                    i = 0;
                }
            } else {
                i = 1;
            }
        }
        setNativeInteractionType(i);
    }

    private void a(com.baidu.mobads.sdk.api.ExpressResponse expressResponse) {
        expressResponse.setInteractionListener(new com.anythink.network.baidu.BaiduATNativeExpressFeedAd.AnonymousClass1());
        expressResponse.setAdDislikeListener(new com.anythink.network.baidu.BaiduATNativeExpressFeedAd.AnonymousClass2());
        expressResponse.render();
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void destroy() {
        super.destroy();
        android.widget.FrameLayout frameLayout = this.c;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
            this.c = null;
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a, com.anythink.core.api.IATThirdPartyMaterial
    public android.view.View getAdMediaView(java.lang.Object... objArr) {
        android.widget.FrameLayout frameLayout = this.c;
        if (frameLayout != null) {
            return frameLayout;
        }
        return null;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public boolean isNativeExpress() {
        return true;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void prepare(android.view.View view, com.anythink.nativead.api.ATNativePrepareInfo aTNativePrepareInfo) {
        com.baidu.mobads.sdk.api.ExpressResponse expressResponse = this.b;
        if (expressResponse == null) {
            return;
        }
        expressResponse.setInteractionListener(new com.anythink.network.baidu.BaiduATNativeExpressFeedAd.AnonymousClass1());
        expressResponse.setAdDislikeListener(new com.anythink.network.baidu.BaiduATNativeExpressFeedAd.AnonymousClass2());
        expressResponse.render();
        android.view.View expressAdView = this.b.getExpressAdView();
        if (this.c == null) {
            this.c = new android.widget.FrameLayout(this.a);
        }
        if (this.c.getChildCount() > 0) {
            this.c.removeAllViews();
        }
        if (expressAdView != null) {
            android.view.ViewParent parent = expressAdView.getParent();
            if (parent instanceof android.view.ViewGroup) {
                ((android.view.ViewGroup) parent).removeView(expressAdView);
            }
            this.c.addView(expressAdView);
        }
    }
}
