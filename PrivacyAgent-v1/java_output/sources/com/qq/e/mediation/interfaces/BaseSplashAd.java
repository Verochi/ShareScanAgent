package com.qq.e.mediation.interfaces;

@java.lang.Deprecated
/* loaded from: classes19.dex */
public abstract class BaseSplashAd implements com.qq.e.mediation.interfaces.IBaseAd {
    public static final int DEFAULT_PRIORITY = -1;

    public BaseSplashAd(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3) {
    }

    public abstract void fetchAdOnly();

    public abstract void fetchFullScreenAdOnly();

    public int getAdapterPriority() {
        return -1;
    }

    public abstract java.lang.String getECPMLevel();

    public abstract android.graphics.Bitmap getZoomOutBitmap();

    public abstract boolean isValid();

    @Override // com.qq.e.mediation.interfaces.IBaseAd
    public void sendLossNotification(int i, int i2, java.lang.String str) {
    }

    @Override // com.qq.e.mediation.interfaces.IBaseAd
    public void sendWinNotification(int i) {
    }

    public abstract void setADListener(com.qq.e.comm.adevent.ADListener aDListener);

    @Override // com.qq.e.mediation.interfaces.IBaseAd
    public void setBidECPM(int i) {
    }

    public abstract void setDeveloperLogo(int i);

    public abstract void setDeveloperLogo(byte[] bArr);

    public abstract void setFetchDelay(int i);

    public abstract void setLoadAdParams(com.qq.e.comm.constants.LoadAdParams loadAdParams);

    @Override // com.qq.e.mediation.interfaces.IBaseAd
    public void setPayload(java.lang.String str) {
    }

    public abstract void setServerSideVerificationOptions(com.qq.e.ads.rewardvideo.ServerSideVerificationOptions serverSideVerificationOptions);

    public abstract void setSkipView(android.view.View view);

    public abstract void setSupportZoomOut(boolean z);

    public abstract void showAd(android.view.ViewGroup viewGroup);

    public abstract void showFullScreenAd(android.view.ViewGroup viewGroup);

    public abstract void zoomOutAnimationFinish();
}
