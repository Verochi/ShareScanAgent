package com.bytedance.sdk.openadsdk.x.vw.vw.wg;

/* loaded from: classes22.dex */
public class wg implements com.bykv.vk.openvk.api.proto.Bridge {
    private com.bykv.vk.openvk.api.proto.ValueSet vw = com.bykv.vw.vw.vw.vw.wg.vw;
    private final com.bytedance.sdk.openadsdk.TTFeedAd.VideoRewardListener wg;

    public wg(com.bytedance.sdk.openadsdk.TTFeedAd.VideoRewardListener videoRewardListener) {
        this.wg = videoRewardListener;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, com.bykv.vk.openvk.api.proto.ValueSet valueSet, java.lang.Class<T> cls) {
        if (this.wg != null && i == 163101) {
            this.wg.onFeedRewardCountDown(valueSet.intValue(0));
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public com.bykv.vk.openvk.api.proto.ValueSet values() {
        return this.vw;
    }
}
