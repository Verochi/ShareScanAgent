package com.anythink.network.toutiao;

/* loaded from: classes12.dex */
public class TTATNativeExpressAd extends com.anythink.nativead.unitgroup.api.CustomNativeAd {
    private static final java.lang.String h = "TTATNativeExpressAd";
    com.bytedance.sdk.openadsdk.TTNativeExpressAd a;
    android.content.Context b;
    java.lang.String c;
    double d;
    double e;
    boolean f = false;
    android.view.View g;

    /* renamed from: com.anythink.network.toutiao.TTATNativeExpressAd$1, reason: invalid class name */
    public class AnonymousClass1 implements com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener {
        public AnonymousClass1() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
        public final void onClickRetry() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
        public final void onProgressUpdate(long j, long j2) {
            if (com.anythink.network.toutiao.TTATNativeExpressAd.this.getVideoDuration() == 0.0d) {
                com.anythink.network.toutiao.TTATNativeExpressAd.this.setVideoDuration(j2 / 1000.0d);
            }
            com.anythink.network.toutiao.TTATNativeExpressAd tTATNativeExpressAd = com.anythink.network.toutiao.TTATNativeExpressAd.this;
            double d = j / 1000.0d;
            tTATNativeExpressAd.d = d;
            tTATNativeExpressAd.notifyAdVideoPlayProgress((int) d);
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
        public final void onVideoAdComplete() {
            com.anythink.network.toutiao.TTATNativeExpressAd.this.notifyAdVideoEnd();
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
        public final void onVideoAdContinuePlay() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
        public final void onVideoAdPaused() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
        public final void onVideoAdStartPlay() {
            com.anythink.network.toutiao.TTATNativeExpressAd.this.notifyAdVideoStart();
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
        public final void onVideoError(int i, int i2) {
            java.lang.String unused = com.anythink.network.toutiao.TTATNativeExpressAd.h;
            java.lang.String.format("onVideoError, errorCode: %d, errorMsg: %s", java.lang.Integer.valueOf(i), java.lang.String.valueOf(i2));
            com.anythink.network.toutiao.TTATNativeExpressAd.this.notifyAdVideoVideoPlayFail(java.lang.String.valueOf(i), java.lang.String.valueOf(i2));
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
        public final void onVideoLoad() {
        }
    }

    /* renamed from: com.anythink.network.toutiao.TTATNativeExpressAd$2, reason: invalid class name */
    public class AnonymousClass2 implements com.bytedance.sdk.openadsdk.TTAppDownloadListener {
        public AnonymousClass2() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onDownloadActive(long j, long j2, java.lang.String str, java.lang.String str2) {
            com.anythink.network.toutiao.TTATNativeExpressAd tTATNativeExpressAd = com.anythink.network.toutiao.TTATNativeExpressAd.this;
            if (tTATNativeExpressAd.f) {
                if (((com.anythink.nativead.unitgroup.a) tTATNativeExpressAd).mDownloadListener == null || !(((com.anythink.nativead.unitgroup.a) com.anythink.network.toutiao.TTATNativeExpressAd.this).mDownloadListener instanceof com.anythink.china.api.CustomAdapterDownloadListener)) {
                    return;
                }
                ((com.anythink.china.api.CustomAdapterDownloadListener) ((com.anythink.nativead.unitgroup.a) com.anythink.network.toutiao.TTATNativeExpressAd.this).mDownloadListener).onDownloadUpdate(j, j2, str, str2);
                return;
            }
            tTATNativeExpressAd.f = true;
            if (((com.anythink.nativead.unitgroup.a) tTATNativeExpressAd).mDownloadListener == null || !(((com.anythink.nativead.unitgroup.a) com.anythink.network.toutiao.TTATNativeExpressAd.this).mDownloadListener instanceof com.anythink.china.api.CustomAdapterDownloadListener)) {
                return;
            }
            ((com.anythink.china.api.CustomAdapterDownloadListener) ((com.anythink.nativead.unitgroup.a) com.anythink.network.toutiao.TTATNativeExpressAd.this).mDownloadListener).onDownloadStart(j, j2, str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onDownloadFailed(long j, long j2, java.lang.String str, java.lang.String str2) {
            if (((com.anythink.nativead.unitgroup.a) com.anythink.network.toutiao.TTATNativeExpressAd.this).mDownloadListener == null || !(((com.anythink.nativead.unitgroup.a) com.anythink.network.toutiao.TTATNativeExpressAd.this).mDownloadListener instanceof com.anythink.china.api.CustomAdapterDownloadListener)) {
                return;
            }
            ((com.anythink.china.api.CustomAdapterDownloadListener) ((com.anythink.nativead.unitgroup.a) com.anythink.network.toutiao.TTATNativeExpressAd.this).mDownloadListener).onDownloadFail(j, j2, str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onDownloadFinished(long j, java.lang.String str, java.lang.String str2) {
            if (((com.anythink.nativead.unitgroup.a) com.anythink.network.toutiao.TTATNativeExpressAd.this).mDownloadListener == null || !(((com.anythink.nativead.unitgroup.a) com.anythink.network.toutiao.TTATNativeExpressAd.this).mDownloadListener instanceof com.anythink.china.api.CustomAdapterDownloadListener)) {
                return;
            }
            ((com.anythink.china.api.CustomAdapterDownloadListener) ((com.anythink.nativead.unitgroup.a) com.anythink.network.toutiao.TTATNativeExpressAd.this).mDownloadListener).onDownloadFinish(j, str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onDownloadPaused(long j, long j2, java.lang.String str, java.lang.String str2) {
            if (((com.anythink.nativead.unitgroup.a) com.anythink.network.toutiao.TTATNativeExpressAd.this).mDownloadListener == null || !(((com.anythink.nativead.unitgroup.a) com.anythink.network.toutiao.TTATNativeExpressAd.this).mDownloadListener instanceof com.anythink.china.api.CustomAdapterDownloadListener)) {
                return;
            }
            ((com.anythink.china.api.CustomAdapterDownloadListener) ((com.anythink.nativead.unitgroup.a) com.anythink.network.toutiao.TTATNativeExpressAd.this).mDownloadListener).onDownloadPause(j, j2, str, str2);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onIdle() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
        public final void onInstalled(java.lang.String str, java.lang.String str2) {
            if (((com.anythink.nativead.unitgroup.a) com.anythink.network.toutiao.TTATNativeExpressAd.this).mDownloadListener == null || !(((com.anythink.nativead.unitgroup.a) com.anythink.network.toutiao.TTATNativeExpressAd.this).mDownloadListener instanceof com.anythink.china.api.CustomAdapterDownloadListener)) {
                return;
            }
            ((com.anythink.china.api.CustomAdapterDownloadListener) ((com.anythink.nativead.unitgroup.a) com.anythink.network.toutiao.TTATNativeExpressAd.this).mDownloadListener).onInstalled(str, str2);
        }
    }

    /* renamed from: com.anythink.network.toutiao.TTATNativeExpressAd$3, reason: invalid class name */
    public class AnonymousClass3 implements com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback {
        public AnonymousClass3() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
        public final void onCancel() {
        }

        @java.lang.Deprecated
        public final void onRefuse() {
        }

        @java.lang.Deprecated
        public final void onSelected(int i, java.lang.String str) {
            com.anythink.network.toutiao.TTATNativeExpressAd.this.notifyAdDislikeClick();
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
        public final void onSelected(int i, java.lang.String str, boolean z) {
            com.anythink.network.toutiao.TTATNativeExpressAd.this.notifyAdDislikeClick();
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
        public final void onShow() {
        }
    }

    /* renamed from: com.anythink.network.toutiao.TTATNativeExpressAd$4, reason: invalid class name */
    public class AnonymousClass4 implements com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener {
        public AnonymousClass4() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public final void onAdClicked(android.view.View view, int i) {
            com.anythink.network.toutiao.TTATNativeExpressAd.this.notifyAdClicked();
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public final void onAdShow(android.view.View view, int i) {
            java.lang.String unused = com.anythink.network.toutiao.TTATNativeExpressAd.h;
            com.anythink.network.toutiao.TTATNativeExpressAd.this.notifyAdImpression();
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public final void onRenderFail(android.view.View view, java.lang.String str, int i) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public final void onRenderSuccess(android.view.View view, float f, float f2) {
        }
    }

    public TTATNativeExpressAd(android.content.Context context, java.lang.String str, com.bytedance.sdk.openadsdk.TTNativeExpressAd tTNativeExpressAd, boolean z, boolean z2, float f, float f2) {
        this.b = context.getApplicationContext();
        this.c = str;
        this.a = tTNativeExpressAd;
        java.util.HashMap hashMap = new java.util.HashMap();
        if (f > 0.0f) {
            hashMap.put("express_width", java.lang.Float.valueOf(f));
        }
        if (f2 > 0.0f) {
            hashMap.put("express_height", java.lang.Float.valueOf(f2));
        }
        if (this.a.getMediaExtraInfo() != null) {
            hashMap.putAll(this.a.getMediaExtraInfo());
        }
        setNetworkInfoMap(hashMap);
        setAdData(z);
        com.bytedance.sdk.openadsdk.TTNativeExpressAd tTNativeExpressAd2 = this.a;
        if (tTNativeExpressAd2 != null) {
            tTNativeExpressAd2.setExpressInteractionListener(new com.anythink.network.toutiao.TTATNativeExpressAd.AnonymousClass4());
        }
    }

    private void a(android.app.Activity activity) {
        com.bytedance.sdk.openadsdk.TTNativeExpressAd tTNativeExpressAd = this.a;
        if (tTNativeExpressAd == null) {
            return;
        }
        tTNativeExpressAd.setDislikeCallback(activity, new com.anythink.network.toutiao.TTATNativeExpressAd.AnonymousClass3());
    }

    private void b() {
        com.bytedance.sdk.openadsdk.TTNativeExpressAd tTNativeExpressAd = this.a;
        if (tTNativeExpressAd == null) {
            return;
        }
        tTNativeExpressAd.setExpressInteractionListener(new com.anythink.network.toutiao.TTATNativeExpressAd.AnonymousClass4());
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void clear(android.view.View view) {
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void destroy() {
        this.g = null;
        com.bytedance.sdk.openadsdk.TTNativeExpressAd tTNativeExpressAd = this.a;
        if (tTNativeExpressAd != null) {
            tTNativeExpressAd.setExpressInteractionListener((com.bytedance.sdk.openadsdk.TTNativeExpressAd.AdInteractionListener) null);
            this.a.destroy();
            this.a = null;
        }
        this.b = null;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.IATThirdPartyMaterial
    public android.graphics.Bitmap getAdLogo() {
        return null;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a, com.anythink.core.api.IATThirdPartyMaterial
    public android.view.View getAdMediaView(java.lang.Object... objArr) {
        com.bytedance.sdk.openadsdk.TTNativeExpressAd tTNativeExpressAd;
        try {
            if (this.g == null && (tTNativeExpressAd = this.a) != null) {
                this.g = tTNativeExpressAd.getExpressAdView();
            }
            return this.g;
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.IATThirdPartyMaterial
    public double getVideoProgress() {
        return this.d;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public boolean isNativeExpress() {
        return true;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void prepare(android.view.View view, com.anythink.nativead.api.ATNativePrepareInfo aTNativePrepareInfo) {
        if (view == null || !(view.getContext() instanceof android.app.Activity)) {
            return;
        }
        android.app.Activity activity = (android.app.Activity) view.getContext();
        com.bytedance.sdk.openadsdk.TTNativeExpressAd tTNativeExpressAd = this.a;
        if (tTNativeExpressAd != null) {
            tTNativeExpressAd.setDislikeCallback(activity, new com.anythink.network.toutiao.TTATNativeExpressAd.AnonymousClass3());
        }
    }

    public void setAdData(boolean z) {
        this.a.setCanInterruptVideoPlay(z);
        int i = this.a.getInteractionType() == 4 ? 1 : 0;
        if (this.a.getInteractionType() == 3) {
            i = 3;
        }
        if (this.a.getInteractionType() == 2) {
            i = 2;
        }
        setNativeInteractionType(i);
        this.a.setVideoAdListener(new com.anythink.network.toutiao.TTATNativeExpressAd.AnonymousClass1());
        this.a.setDownloadListener(new com.anythink.network.toutiao.TTATNativeExpressAd.AnonymousClass2());
        int imageMode = this.a.getImageMode();
        if (imageMode != 2 && imageMode != 3 && imageMode != 4) {
            if (imageMode == 5 || imageMode == 15) {
                this.mAdSourceType = "1";
                return;
            } else if (imageMode != 16) {
                return;
            }
        }
        this.mAdSourceType = "2";
    }
}
