package com.bytedance.sdk.openadsdk.u.vw.vw.vw;

/* loaded from: classes22.dex */
public class wg implements com.bykv.vk.openvk.api.proto.Bridge {
    private com.bykv.vk.openvk.api.proto.ValueSet vw = com.bykv.vw.vw.vw.vw.wg.vw;
    private final com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdPlayAgainController wg;

    public wg(com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdPlayAgainController rewardAdPlayAgainController) {
        this.wg = rewardAdPlayAgainController;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, com.bykv.vk.openvk.api.proto.ValueSet valueSet, java.lang.Class<T> cls) {
        if (this.wg != null && i == 122101) {
            this.wg.getPlayAgainCondition(valueSet.intValue(0), new com.bytedance.sdk.openadsdk.v.vw.vw.vw.vw.vw((com.bykv.vk.openvk.api.proto.Bridge) valueSet.objectValue(1, com.bykv.vk.openvk.api.proto.Bridge.class)));
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public com.bykv.vk.openvk.api.proto.ValueSet values() {
        return this.vw;
    }
}
