package com.anythink.network.baidu;

/* loaded from: classes12.dex */
public class BaiduATNativeExpressAd extends com.anythink.nativead.unitgroup.api.CustomNativeAd {
    com.anythink.network.baidu.impression.BDImpressionTracker a;
    private com.baidu.mobads.sdk.api.NativeResponse b;
    private com.baidu.mobads.sdk.api.FeedNativeView c;
    private com.baidu.mobads.sdk.api.StyleParams d;
    private android.content.Context e;
    private android.widget.FrameLayout f;

    /* renamed from: com.anythink.network.baidu.BaiduATNativeExpressAd$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {

        /* renamed from: com.anythink.network.baidu.BaiduATNativeExpressAd$1$1, reason: invalid class name and collision with other inner class name */
        public class C02351 implements com.baidu.mobads.sdk.api.NativeResponse.AdDislikeListener {
            public C02351() {
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdDislikeListener
            public final void onDislikeItemClick(java.lang.String str) {
                com.anythink.network.baidu.BaiduATNativeExpressAd.this.notifyAdDislikeClick();
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdDislikeListener
            public final void onDislikeWindowClose() {
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdDislikeListener
            public final void onDislikeWindowShow() {
            }
        }

        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ((com.baidu.mobads.sdk.api.XAdNativeResponse) com.anythink.network.baidu.BaiduATNativeExpressAd.this.b).setAdDislikeListener(new com.anythink.network.baidu.BaiduATNativeExpressAd.AnonymousClass1.C02351());
        }
    }

    /* renamed from: com.anythink.network.baidu.BaiduATNativeExpressAd$2, reason: invalid class name */
    public class AnonymousClass2 implements com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener {
        public AnonymousClass2() {
        }

        @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
        public final void onADExposed() {
            com.anythink.network.baidu.impression.BDImpressionTracker bDImpressionTracker = com.anythink.network.baidu.BaiduATNativeExpressAd.this.a;
            if (bDImpressionTracker != null) {
                bDImpressionTracker.clear();
                com.anythink.network.baidu.BaiduATNativeExpressAd.this.a = null;
            }
            com.anythink.network.baidu.BaiduATNativeExpressAd.this.notifyAdImpression();
        }

        @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
        public final void onADExposureFailed(int i) {
        }

        @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
        public final void onADStatusChanged() {
        }

        @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
        public final void onAdClick() {
            com.anythink.network.baidu.BaiduATNativeExpressAd.this.notifyAdClicked();
        }

        @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
        public final void onAdUnionClick() {
        }
    }

    /* renamed from: com.anythink.network.baidu.BaiduATNativeExpressAd$3, reason: invalid class name */
    public class AnonymousClass3 extends com.anythink.network.baidu.impression.BDImpressionController {
        public AnonymousClass3() {
        }

        @Override // com.anythink.network.baidu.impression.BDImpressionController, com.anythink.network.baidu.impression.BDImpressionInterface
        public final void recordImpression(android.view.View view) {
            try {
                if (com.anythink.network.baidu.BaiduATNativeExpressAd.this.b == null || view == null) {
                    return;
                }
                com.anythink.network.baidu.BaiduATNativeExpressAd.this.b.recordImpression(view);
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    public BaiduATNativeExpressAd(android.content.Context context, com.baidu.mobads.sdk.api.NativeResponse nativeResponse, com.baidu.mobads.sdk.api.StyleParams styleParams) {
        this.e = context.getApplicationContext();
        this.f = new android.widget.FrameLayout(this.e);
        this.b = nativeResponse;
        this.d = styleParams;
        this.a = new com.anythink.network.baidu.impression.BDImpressionTracker(this.e, 50);
    }

    private java.util.List<android.view.View> a(android.view.View view) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (!(view instanceof android.view.ViewGroup) || view == this.f) {
            arrayList.add(view);
        } else {
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                arrayList.addAll(a(viewGroup.getChildAt(i)));
            }
        }
        return arrayList;
    }

    private void a(android.content.Context context) {
        if (this.c == null) {
            com.baidu.mobads.sdk.api.FeedNativeView feedNativeView = new com.baidu.mobads.sdk.api.FeedNativeView(context);
            this.c = feedNativeView;
            feedNativeView.setAdData((com.baidu.mobads.sdk.api.XAdNativeResponse) this.b);
            this.c.changeViewLayoutParams(this.d);
            new android.os.Handler(android.os.Looper.getMainLooper()).post(new com.anythink.network.baidu.BaiduATNativeExpressAd.AnonymousClass1());
            this.f.addView(this.c);
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void destroy() {
        super.destroy();
        this.f = null;
        this.d = null;
        com.anythink.network.baidu.impression.BDImpressionTracker bDImpressionTracker = this.a;
        if (bDImpressionTracker != null) {
            bDImpressionTracker.clear();
            this.a = null;
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a, com.anythink.core.api.IATThirdPartyMaterial
    public android.view.View getAdMediaView(java.lang.Object... objArr) {
        android.widget.FrameLayout frameLayout = this.f;
        if (frameLayout != null) {
            return frameLayout;
        }
        return null;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.IATThirdPartyMaterial
    public int getNativeExpressHeight() {
        com.baidu.mobads.sdk.api.FeedNativeView feedNativeView = this.c;
        if (feedNativeView != null) {
            return feedNativeView.getAdContainerHeight();
        }
        return 0;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.IATThirdPartyMaterial
    public int getNativeExpressWidth() {
        com.baidu.mobads.sdk.api.FeedNativeView feedNativeView = this.c;
        if (feedNativeView != null) {
            return feedNativeView.getAdContainerWidth();
        }
        return 0;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd
    public void impressionTrack(android.view.View view) {
        com.baidu.mobads.sdk.api.NativeResponse nativeResponse = this.b;
        if (nativeResponse == null || view == null) {
            return;
        }
        nativeResponse.recordImpression(view);
        notifyAdImpression();
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public boolean isNativeExpress() {
        return true;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void prepare(android.view.View view, com.anythink.nativead.api.ATNativePrepareInfo aTNativePrepareInfo) {
        java.util.List<android.view.View> creativeClickViewList;
        android.content.Context context = view != null ? view.getContext() : this.e;
        if (this.c == null) {
            com.baidu.mobads.sdk.api.FeedNativeView feedNativeView = new com.baidu.mobads.sdk.api.FeedNativeView(context);
            this.c = feedNativeView;
            feedNativeView.setAdData((com.baidu.mobads.sdk.api.XAdNativeResponse) this.b);
            this.c.changeViewLayoutParams(this.d);
            new android.os.Handler(android.os.Looper.getMainLooper()).post(new com.anythink.network.baidu.BaiduATNativeExpressAd.AnonymousClass1());
            this.f.addView(this.c);
        }
        java.util.List<android.view.View> clickViewList = aTNativePrepareInfo.getClickViewList();
        if (clickViewList == null || clickViewList.size() == 0) {
            clickViewList = a(view);
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if ((aTNativePrepareInfo instanceof com.anythink.nativead.api.ATNativePrepareExInfo) && (creativeClickViewList = ((com.anythink.nativead.api.ATNativePrepareExInfo) aTNativePrepareInfo).getCreativeClickViewList()) != null) {
            arrayList.addAll(creativeClickViewList);
        }
        ((com.baidu.mobads.sdk.api.XAdNativeResponse) this.b).registerViewForInteraction(view, clickViewList, arrayList, new com.anythink.network.baidu.BaiduATNativeExpressAd.AnonymousClass2());
        try {
            com.anythink.network.baidu.impression.BDImpressionTracker bDImpressionTracker = this.a;
            if (bDImpressionTracker != null) {
                bDImpressionTracker.addView(view, new com.anythink.network.baidu.BaiduATNativeExpressAd.AnonymousClass3());
            }
        } catch (java.lang.Throwable unused) {
        }
    }
}
