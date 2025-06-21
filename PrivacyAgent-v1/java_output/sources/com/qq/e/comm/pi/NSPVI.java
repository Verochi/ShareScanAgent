package com.qq.e.comm.pi;

/* loaded from: classes19.dex */
public interface NSPVI extends com.qq.e.comm.pi.LADI {
    void fetchAdOnly();

    void fetchAndShowIn(android.view.ViewGroup viewGroup);

    void fetchFullScreenAdOnly();

    void fetchFullScreenAndShowIn(android.view.ViewGroup viewGroup);

    java.lang.String getAdNetWorkName();

    @java.lang.Deprecated
    android.graphics.Bitmap getZoomOutBitmap();

    void preload();

    void setAdListener(com.qq.e.comm.adevent.ADListener aDListener);

    void setDeveloperLogo(int i);

    void setDeveloperLogo(byte[] bArr);

    void setFetchDelay(int i);

    void setLoadAdParams(com.qq.e.comm.constants.LoadAdParams loadAdParams);

    void setServerSideVerificationOptions(com.qq.e.ads.rewardvideo.ServerSideVerificationOptions serverSideVerificationOptions);

    @java.lang.Deprecated
    void setSkipView(android.view.View view);

    @java.lang.Deprecated
    void setSupportZoomOut(boolean z);

    void showAd(android.view.ViewGroup viewGroup);

    void showFullScreenAd(android.view.ViewGroup viewGroup);

    @java.lang.Deprecated
    void zoomOutAnimationFinish();
}
