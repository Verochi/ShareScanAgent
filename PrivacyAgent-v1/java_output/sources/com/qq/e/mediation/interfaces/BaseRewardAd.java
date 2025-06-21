package com.qq.e.mediation.interfaces;

@java.lang.Deprecated
/* loaded from: classes19.dex */
public abstract class BaseRewardAd implements com.qq.e.mediation.interfaces.IBaseAd {
    public static final int DEFAULT_PRIORITY = -1;
    private com.qq.e.comm.constants.LoadAdParams a = null;

    public BaseRewardAd(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3) {
    }

    public int getAdapterPriority() {
        return -1;
    }

    public abstract java.lang.String getECPMLevel();

    @java.lang.Deprecated
    public abstract long getExpireTimestamp();

    public com.qq.e.comm.constants.LoadAdParams getLoadAdParams() {
        return this.a;
    }

    public int getRewardAdType() {
        return 0;
    }

    public abstract int getVideoDuration();

    public abstract boolean hasShown();

    public abstract boolean isValid();

    public abstract void loadAD();

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

    public void setLoadAdParams(com.qq.e.comm.constants.LoadAdParams loadAdParams) {
        this.a = loadAdParams;
    }

    @Override // com.qq.e.mediation.interfaces.IBaseAd
    public void setPayload(java.lang.String str) {
    }

    public abstract void setServerSideVerificationOptions(com.qq.e.ads.rewardvideo.ServerSideVerificationOptions serverSideVerificationOptions);

    public abstract void setVolumeOn(boolean z);

    public abstract void showAD();

    public void showAD(android.app.Activity activity) {
        showAD();
    }
}
