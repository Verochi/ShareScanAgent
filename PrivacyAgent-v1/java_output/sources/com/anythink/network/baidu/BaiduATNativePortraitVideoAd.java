package com.anythink.network.baidu;

/* loaded from: classes12.dex */
public class BaiduATNativePortraitVideoAd extends com.anythink.network.baidu.BaiduATNativeAd {
    com.baidu.mobads.sdk.api.BaiduNativeManager e;
    com.baidu.mobads.sdk.api.RequestParameters f;
    boolean g;
    private com.baidu.mobads.sdk.api.FeedPortraitVideoView h;
    private android.content.Context i;

    /* renamed from: com.anythink.network.baidu.BaiduATNativePortraitVideoAd$1, reason: invalid class name */
    public class AnonymousClass1 implements com.baidu.mobads.sdk.api.BaiduNativeManager.PortraitVideoAdListener {
        final /* synthetic */ com.anythink.network.baidu.BaiduATNativePortraitVideoAd.LoadCallbackListener a;

        public AnonymousClass1(com.anythink.network.baidu.BaiduATNativePortraitVideoAd.LoadCallbackListener loadCallbackListener) {
            this.a = loadCallbackListener;
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.PortraitVideoAdListener
        public final void onAdClick() {
            com.anythink.network.baidu.BaiduATNativePortraitVideoAd.this.notifyAdClicked();
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public final void onLpClosed() {
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public final void onNativeFail(int i, java.lang.String str, com.baidu.mobads.sdk.api.NativeResponse nativeResponse) {
            this.a.onFail(java.lang.String.valueOf(i), str);
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public final void onNativeLoad(java.util.List<com.baidu.mobads.sdk.api.NativeResponse> list) {
            if (list == null || list.size() <= 0) {
                this.a.onFail("", "callback onNativeLoad but no ad");
                return;
            }
            com.baidu.mobads.sdk.api.NativeResponse nativeResponse = list.get(0);
            com.anythink.network.baidu.BaiduATNativePortraitVideoAd baiduATNativePortraitVideoAd = com.anythink.network.baidu.BaiduATNativePortraitVideoAd.this;
            baiduATNativePortraitVideoAd.a(baiduATNativePortraitVideoAd.i, nativeResponse);
            this.a.onSuccess(nativeResponse, com.anythink.network.baidu.BaiduATNativePortraitVideoAd.this);
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public final void onNoAd(int i, java.lang.String str, com.baidu.mobads.sdk.api.NativeResponse nativeResponse) {
            this.a.onFail(java.lang.String.valueOf(i), str);
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public final void onVideoDownloadFailed() {
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public final void onVideoDownloadSuccess() {
        }
    }

    /* renamed from: com.anythink.network.baidu.BaiduATNativePortraitVideoAd$2, reason: invalid class name */
    public class AnonymousClass2 implements com.baidu.mobads.sdk.api.IFeedPortraitListener {
        public AnonymousClass2() {
        }

        @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
        public final void pauseBtnClick() {
        }

        @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
        public final void playCompletion() {
            com.anythink.network.baidu.BaiduATNativePortraitVideoAd.this.notifyAdVideoEnd();
        }

        @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
        public final void playError() {
            com.anythink.network.baidu.BaiduATNativePortraitVideoAd.this.notifyAdVideoVideoPlayFail("", "BaiduATNativePortraitVideoAd video play error");
        }

        @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
        public final void playPause() {
        }

        @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
        public final void playRenderingStart() {
            com.anythink.network.baidu.BaiduATNativePortraitVideoAd.this.notifyAdVideoStart();
        }

        @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
        public final void playResume() {
        }
    }

    public interface LoadCallbackListener {
        void onFail(java.lang.String str, java.lang.String str2);

        void onSuccess(com.baidu.mobads.sdk.api.NativeResponse nativeResponse, com.anythink.nativead.unitgroup.api.CustomNativeAd customNativeAd);
    }

    public BaiduATNativePortraitVideoAd(android.content.Context context, com.baidu.mobads.sdk.api.BaiduNativeManager baiduNativeManager, com.baidu.mobads.sdk.api.RequestParameters requestParameters, boolean z) {
        this.i = context;
        this.e = baiduNativeManager;
        this.f = requestParameters;
        this.g = z;
    }

    @Override // com.anythink.network.baidu.BaiduATNativeAd, com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void destroy() {
        super.destroy();
        com.baidu.mobads.sdk.api.FeedPortraitVideoView feedPortraitVideoView = this.h;
        if (feedPortraitVideoView != null) {
            feedPortraitVideoView.stop();
            this.h = null;
        }
    }

    @Override // com.anythink.network.baidu.BaiduATNativeAd, com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a, com.anythink.core.api.IATThirdPartyMaterial
    public android.view.View getAdMediaView(java.lang.Object... objArr) {
        if (this.a == null) {
            return null;
        }
        if (this.h == null) {
            com.baidu.mobads.sdk.api.FeedPortraitVideoView feedPortraitVideoView = new com.baidu.mobads.sdk.api.FeedPortraitVideoView(this.b);
            this.h = feedPortraitVideoView;
            feedPortraitVideoView.setAdData(this.a);
            this.h.setVideoMute(this.d);
            this.h.setFeedPortraitListener(new com.anythink.network.baidu.BaiduATNativePortraitVideoAd.AnonymousClass2());
        }
        return this.h;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.IATThirdPartyMaterial
    public double getVideoProgress() {
        if (this.h != null) {
            return r0.getCurrentPosition() / 1000.0d;
        }
        return 0.0d;
    }

    public void load(com.anythink.network.baidu.BaiduATNativePortraitVideoAd.LoadCallbackListener loadCallbackListener) {
        this.e.loadPortraitVideoAd(this.f, (com.baidu.mobads.sdk.api.BaiduNativeManager.PortraitVideoAdListener) new com.anythink.network.baidu.BaiduATNativePortraitVideoAd.AnonymousClass1(loadCallbackListener));
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void pauseVideo() {
        super.pauseVideo();
        com.baidu.mobads.sdk.api.FeedPortraitVideoView feedPortraitVideoView = this.h;
        if (feedPortraitVideoView != null) {
            feedPortraitVideoView.pause();
        }
    }

    @Override // com.anythink.network.baidu.BaiduATNativeAd, com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void prepare(android.view.View view, com.anythink.nativead.api.ATNativePrepareInfo aTNativePrepareInfo) {
        com.baidu.mobads.sdk.api.FeedPortraitVideoView feedPortraitVideoView;
        super.prepare(view, aTNativePrepareInfo);
        if (!this.g || (feedPortraitVideoView = this.h) == null) {
            return;
        }
        feedPortraitVideoView.play();
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void resumeVideo() {
        super.resumeVideo();
        com.baidu.mobads.sdk.api.FeedPortraitVideoView feedPortraitVideoView = this.h;
        if (feedPortraitVideoView != null) {
            feedPortraitVideoView.resume();
        }
    }

    @Override // com.anythink.network.baidu.BaiduATNativeAd, com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void setVideoMute(boolean z) {
        super.setVideoMute(z);
        com.baidu.mobads.sdk.api.FeedPortraitVideoView feedPortraitVideoView = this.h;
        if (feedPortraitVideoView != null) {
            feedPortraitVideoView.setVideoMute(z);
        }
    }
}
