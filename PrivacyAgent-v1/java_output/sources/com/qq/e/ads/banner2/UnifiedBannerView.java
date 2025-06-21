package com.qq.e.ads.banner2;

@android.annotation.SuppressLint({"ViewConstructor"})
/* loaded from: classes19.dex */
public class UnifiedBannerView extends android.widget.FrameLayout implements com.qq.e.comm.compliance.ApkDownloadComplianceInterface, com.qq.e.comm.pi.IBidding, com.qq.e.comm.pi.NFBI, com.qq.e.comm.pi.IReward {
    final com.qq.e.ads.banner2.UnifiedBannerAD a;

    public UnifiedBannerView(android.app.Activity activity, java.lang.String str, com.qq.e.ads.banner2.UnifiedBannerADListener unifiedBannerADListener) {
        this(activity, str, unifiedBannerADListener, null);
    }

    public UnifiedBannerView(android.app.Activity activity, java.lang.String str, com.qq.e.ads.banner2.UnifiedBannerADListener unifiedBannerADListener, java.util.Map map) {
        super(activity);
        this.a = new com.qq.e.ads.banner2.UnifiedBannerAD(activity, this, str, unifiedBannerADListener);
        a();
    }

    public UnifiedBannerView(android.app.Activity activity, java.lang.String str, com.qq.e.ads.banner2.UnifiedBannerADListener unifiedBannerADListener, java.util.Map map, java.lang.String str2) {
        super(activity);
        if (android.text.TextUtils.isEmpty(str2)) {
            com.qq.e.comm.util.GDTLogger.e(com.qq.e.ads.banner2.UnifiedBannerView.class.getSimpleName() + "构造函数中 token 参数不可为空");
        }
        this.a = new com.qq.e.ads.banner2.UnifiedBannerAD(activity, this, str, str2, unifiedBannerADListener);
        a();
    }

    private void a() {
        setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -2));
    }

    public void destroy() {
        this.a.destroy();
    }

    public java.lang.String getAdNetWorkName() {
        return this.a.getAdNetWorkName();
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public java.lang.String getApkInfoUrl() {
        return this.a.getApkInfoUrl();
    }

    public int getECPM() {
        return this.a.getECPM();
    }

    public java.lang.String getECPMLevel() {
        return this.a.getECPMLevel();
    }

    public java.util.Map<java.lang.String, java.lang.Object> getExtraInfo() {
        return this.a.getExtraInfo();
    }

    public boolean isValid() {
        return this.a.isValid();
    }

    public void loadAD() {
        this.a.loadAD();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.a.onWindowFocusChanged(z);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendLossNotification(int i, int i2, java.lang.String str) {
        this.a.sendLossNotification(i, i2, str);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendLossNotification(java.util.Map<java.lang.String, java.lang.Object> map) {
        this.a.sendLossNotification(map);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendWinNotification(int i) {
        this.a.sendWinNotification(i);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendWinNotification(java.util.Map<java.lang.String, java.lang.Object> map) {
        this.a.sendWinNotification(map);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void setBidECPM(int i) {
        this.a.setBidECPM(i);
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(com.qq.e.comm.compliance.DownloadConfirmListener downloadConfirmListener) {
        this.a.setDownloadConfirmListener(downloadConfirmListener);
    }

    public void setLoadAdParams(com.qq.e.comm.constants.LoadAdParams loadAdParams) {
        this.a.setLoadAdParams(loadAdParams);
    }

    @Override // com.qq.e.comm.pi.NFBI
    public void setNegativeFeedbackListener(com.qq.e.comm.listeners.NegativeFeedbackListener negativeFeedbackListener) {
        this.a.setNegativeFeedbackListener(negativeFeedbackListener);
    }

    public void setRefresh(int i) {
        this.a.c(i);
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setRewardListener(com.qq.e.comm.listeners.ADRewardListener aDRewardListener) {
        this.a.setRewardListener(aDRewardListener);
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setServerSideVerificationOptions(com.qq.e.ads.rewardvideo.ServerSideVerificationOptions serverSideVerificationOptions) {
        this.a.setServerSideVerificationOptions(serverSideVerificationOptions);
    }
}
