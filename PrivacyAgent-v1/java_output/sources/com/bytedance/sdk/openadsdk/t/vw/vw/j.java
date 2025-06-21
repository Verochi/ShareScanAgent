package com.bytedance.sdk.openadsdk.t.vw.vw;

/* loaded from: classes22.dex */
public class j implements com.bytedance.sdk.openadsdk.TTRewardVideoAd {
    private final com.bykv.vk.openvk.api.proto.Bridge vw;

    public j(com.bykv.vk.openvk.api.proto.Bridge bridge) {
        this.vw = bridge == null ? com.bykv.vw.vw.vw.vw.wg.wg : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public long getExpirationTimestamp() {
        return this.vw.values().longValue(120004);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public int getInteractionType() {
        return this.vw.values().intValue(120001);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public java.util.Map<java.lang.String, java.lang.Object> getMediaExtraInfo() {
        return (java.util.Map) this.vw.values().objectValue(120002, java.util.Map.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public int getRewardVideoAdType() {
        return this.vw.values().intValue(120003);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void loss(java.lang.Double d, java.lang.String str, java.lang.String str2) {
        com.bykv.vw.vw.vw.vw.wg vw = com.bykv.vw.vw.vw.vw.wg.vw(3);
        vw.vw(0, d);
        vw.vw(1, str);
        vw.vw(2, str2);
        this.vw.call(210102, vw.wg(), java.lang.Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void setAdInteractionListener(com.bytedance.sdk.openadsdk.TTAdInteractionListener tTAdInteractionListener) {
        com.bykv.vw.vw.vw.vw.wg vw = com.bykv.vw.vw.vw.vw.wg.vw(1);
        vw.vw(0, new com.bytedance.sdk.openadsdk.t.vw.wg.vw(tTAdInteractionListener));
        this.vw.call(210104, vw.wg(), java.lang.Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void setDownloadListener(com.bytedance.sdk.openadsdk.TTAppDownloadListener tTAppDownloadListener) {
        com.bykv.vw.vw.vw.vw.wg vw = com.bykv.vw.vw.vw.vw.wg.vw(1);
        vw.vw(0, new com.bytedance.sdk.openadsdk.t.vw.wg.wg(tTAppDownloadListener));
        this.vw.call(120104, vw.wg(), java.lang.Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void setPrice(java.lang.Double d) {
        com.bykv.vw.vw.vw.vw.wg vw = com.bykv.vw.vw.vw.vw.wg.vw(1);
        vw.vw(0, d);
        this.vw.call(210103, vw.wg(), java.lang.Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void setRewardAdInteractionListener(com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        com.bykv.vw.vw.vw.vw.wg vw = com.bykv.vw.vw.vw.vw.wg.vw(1);
        vw.vw(0, new com.bytedance.sdk.openadsdk.u.vw.vw.vw.vw(rewardAdInteractionListener));
        this.vw.call(120101, vw.wg(), java.lang.Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void setRewardPlayAgainController(com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdPlayAgainController rewardAdPlayAgainController) {
        com.bykv.vw.vw.vw.vw.wg vw = com.bykv.vw.vw.vw.vw.wg.vw(1);
        vw.vw(0, new com.bytedance.sdk.openadsdk.u.vw.vw.vw.wg(rewardAdPlayAgainController));
        this.vw.call(120103, vw.wg(), java.lang.Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void setRewardPlayAgainInteractionListener(com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        com.bykv.vw.vw.vw.vw.wg vw = com.bykv.vw.vw.vw.vw.wg.vw(1);
        vw.vw(0, new com.bytedance.sdk.openadsdk.u.vw.vw.vw.vw(rewardAdInteractionListener));
        this.vw.call(120102, vw.wg(), java.lang.Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void setShowDownLoadBar(boolean z) {
        com.bykv.vw.vw.vw.vw.wg vw = com.bykv.vw.vw.vw.vw.wg.vw(1);
        vw.vw(0, z);
        this.vw.call(120107, vw.wg(), java.lang.Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void showRewardVideoAd(android.app.Activity activity) {
        com.bykv.vw.vw.vw.vw.wg vw = com.bykv.vw.vw.vw.vw.wg.vw(1);
        vw.vw(0, activity);
        this.vw.call(120105, vw.wg(), java.lang.Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void showRewardVideoAd(android.app.Activity activity, com.bytedance.sdk.openadsdk.TTAdConstant.RitScenes ritScenes, java.lang.String str) {
        com.bykv.vw.vw.vw.vw.wg vw = com.bykv.vw.vw.vw.vw.wg.vw(3);
        vw.vw(0, activity);
        vw.vw(1, ritScenes);
        vw.vw(2, str);
        this.vw.call(120106, vw.wg(), java.lang.Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void win(java.lang.Double d) {
        com.bykv.vw.vw.vw.vw.wg vw = com.bykv.vw.vw.vw.vw.wg.vw(1);
        vw.vw(0, d);
        this.vw.call(210101, vw.wg(), java.lang.Void.class);
    }
}
