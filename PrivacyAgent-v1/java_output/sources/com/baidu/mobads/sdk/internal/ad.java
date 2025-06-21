package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
public class ad implements com.baidu.mobads.sdk.internal.g.a {
    private com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener a;

    public ad(com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener feedAdListener) {
        this.a = feedAdListener;
    }

    @Override // com.baidu.mobads.sdk.internal.g.a
    public void a() {
        com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener feedAdListener = this.a;
        if (feedAdListener != null) {
            feedAdListener.onLpClosed();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.g.a
    public void a(int i, java.lang.String str, com.baidu.mobads.sdk.api.NativeResponse nativeResponse) {
        com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener feedAdListener = this.a;
        if (feedAdListener != null) {
            feedAdListener.onNoAd(i, str, nativeResponse);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.g.a
    public void a(com.baidu.mobads.sdk.api.NativeResponse nativeResponse) {
        if (nativeResponse instanceof com.baidu.mobads.sdk.api.XAdNativeResponse) {
            ((com.baidu.mobads.sdk.api.XAdNativeResponse) nativeResponse).onADExposed();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.g.a
    public void a(com.baidu.mobads.sdk.api.NativeResponse nativeResponse, int i) {
        if (nativeResponse instanceof com.baidu.mobads.sdk.api.XAdNativeResponse) {
            ((com.baidu.mobads.sdk.api.XAdNativeResponse) nativeResponse).onADExposureFailed(i);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.g.a
    public void a(java.util.List<com.baidu.mobads.sdk.api.NativeResponse> list) {
        com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener feedAdListener = this.a;
        if (feedAdListener != null) {
            feedAdListener.onNativeLoad(list);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.g.a
    public void b() {
        com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener feedAdListener = this.a;
        if (feedAdListener != null) {
            feedAdListener.onVideoDownloadSuccess();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.g.a
    public void b(int i, java.lang.String str, com.baidu.mobads.sdk.api.NativeResponse nativeResponse) {
        com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener feedAdListener = this.a;
        if (feedAdListener != null) {
            feedAdListener.onNativeFail(i, str, nativeResponse);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.g.a
    public void b(com.baidu.mobads.sdk.api.NativeResponse nativeResponse) {
        com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener feedAdListener = this.a;
        if (feedAdListener != null && (feedAdListener instanceof com.baidu.mobads.sdk.api.BaiduNativeManager.PortraitVideoAdListener)) {
            ((com.baidu.mobads.sdk.api.BaiduNativeManager.PortraitVideoAdListener) feedAdListener).onAdClick();
        } else if (nativeResponse instanceof com.baidu.mobads.sdk.api.XAdNativeResponse) {
            ((com.baidu.mobads.sdk.api.XAdNativeResponse) nativeResponse).onAdClick();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.g.a
    public void c() {
        com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener feedAdListener = this.a;
        if (feedAdListener != null) {
            feedAdListener.onVideoDownloadFailed();
        }
    }
}
