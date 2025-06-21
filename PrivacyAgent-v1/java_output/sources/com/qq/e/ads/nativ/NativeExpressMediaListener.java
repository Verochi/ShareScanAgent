package com.qq.e.ads.nativ;

/* loaded from: classes19.dex */
public interface NativeExpressMediaListener {
    void onVideoCached(com.qq.e.ads.nativ.NativeExpressADView nativeExpressADView);

    void onVideoComplete(com.qq.e.ads.nativ.NativeExpressADView nativeExpressADView);

    void onVideoError(com.qq.e.ads.nativ.NativeExpressADView nativeExpressADView, com.qq.e.comm.util.AdError adError);

    void onVideoInit(com.qq.e.ads.nativ.NativeExpressADView nativeExpressADView);

    void onVideoLoading(com.qq.e.ads.nativ.NativeExpressADView nativeExpressADView);

    void onVideoPageClose(com.qq.e.ads.nativ.NativeExpressADView nativeExpressADView);

    void onVideoPageOpen(com.qq.e.ads.nativ.NativeExpressADView nativeExpressADView);

    void onVideoPause(com.qq.e.ads.nativ.NativeExpressADView nativeExpressADView);

    void onVideoReady(com.qq.e.ads.nativ.NativeExpressADView nativeExpressADView, long j);

    void onVideoStart(com.qq.e.ads.nativ.NativeExpressADView nativeExpressADView);
}
