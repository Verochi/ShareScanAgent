package com.qq.e.mediation.interfaces;

@java.lang.Deprecated
/* loaded from: classes19.dex */
public abstract class BaseNativeExpressAd implements com.qq.e.mediation.interfaces.IBaseAd {
    public static final int DEFAULT_PRIORITY = -1;

    public BaseNativeExpressAd(android.content.Context context, com.qq.e.ads.nativ.ADSize aDSize, java.lang.String str, java.lang.String str2, java.lang.String str3) {
    }

    public int getAdapterPriority() {
        return -1;
    }

    public abstract void loadAD(int i);

    public abstract void loadAD(int i, com.qq.e.comm.constants.LoadAdParams loadAdParams);

    @Override // com.qq.e.mediation.interfaces.IBaseAd
    public void sendLossNotification(int i, int i2, java.lang.String str) {
    }

    @Override // com.qq.e.mediation.interfaces.IBaseAd
    public void sendWinNotification(int i) {
    }

    public abstract void setAdListener(com.qq.e.comm.adevent.ADListener aDListener);

    @Override // com.qq.e.mediation.interfaces.IBaseAd
    public void setBidECPM(int i) {
    }

    public abstract void setECPMLevel(java.lang.String str);

    public abstract void setMaxVideoDuration(int i);

    public abstract void setMinVideoDuration(int i);

    @Override // com.qq.e.mediation.interfaces.IBaseAd
    public void setPayload(java.lang.String str) {
    }

    public abstract void setServerSideVerificationOptions(com.qq.e.ads.rewardvideo.ServerSideVerificationOptions serverSideVerificationOptions);

    public abstract void setVideoOption(com.qq.e.ads.cfg.VideoOption videoOption);
}
