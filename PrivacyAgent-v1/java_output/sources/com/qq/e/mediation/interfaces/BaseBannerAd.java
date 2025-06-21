package com.qq.e.mediation.interfaces;

@java.lang.Deprecated
/* loaded from: classes19.dex */
public abstract class BaseBannerAd implements com.qq.e.mediation.interfaces.IBaseAd {
    public BaseBannerAd(android.app.Activity activity, java.lang.String str, java.lang.String str2, java.lang.String str3) {
    }

    public abstract void destroy();

    public abstract android.view.View getAdView();

    public abstract boolean isValid();

    public abstract void loadAD();

    @Override // com.qq.e.mediation.interfaces.IBaseAd
    public void sendLossNotification(int i, int i2, java.lang.String str) {
    }

    @Override // com.qq.e.mediation.interfaces.IBaseAd
    public void sendWinNotification(int i) {
    }

    public abstract void setAdListener(com.qq.e.comm.adevent.ADListener aDListener);

    public abstract void setAdSize(int i, int i2);

    @Override // com.qq.e.mediation.interfaces.IBaseAd
    public void setBidECPM(int i) {
    }

    @Override // com.qq.e.mediation.interfaces.IBaseAd
    public void setPayload(java.lang.String str) {
    }

    public abstract void setServerSideVerificationOptions(com.qq.e.ads.rewardvideo.ServerSideVerificationOptions serverSideVerificationOptions);
}
