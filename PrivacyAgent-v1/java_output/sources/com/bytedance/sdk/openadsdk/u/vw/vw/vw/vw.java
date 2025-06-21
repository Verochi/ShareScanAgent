package com.bytedance.sdk.openadsdk.u.vw.vw.vw;

/* loaded from: classes22.dex */
public class vw implements com.bykv.vk.openvk.api.proto.Bridge {
    private com.bykv.vk.openvk.api.proto.ValueSet vw = com.bykv.vw.vw.vw.vw.wg.vw;
    private final com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener wg;

    public vw(com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        this.wg = rewardAdInteractionListener;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x005e, code lost:
    
        return null;
     */
    @Override // com.bykv.vk.openvk.api.proto.Caller
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T> T call(int i, com.bykv.vk.openvk.api.proto.ValueSet valueSet, java.lang.Class<T> cls) {
        com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this.wg;
        if (rewardAdInteractionListener != null) {
            switch (i) {
                case 121101:
                    rewardAdInteractionListener.onAdShow();
                    break;
                case 121102:
                    rewardAdInteractionListener.onAdVideoBarClick();
                    break;
                case 121103:
                    rewardAdInteractionListener.onAdClose();
                    break;
                case 121104:
                    rewardAdInteractionListener.onVideoComplete();
                    break;
                case 121105:
                    rewardAdInteractionListener.onVideoError();
                    break;
                case 121106:
                    this.wg.onRewardVerify(valueSet.booleanValue(0), valueSet.intValue(1), (java.lang.String) valueSet.objectValue(2, java.lang.String.class), valueSet.intValue(3), (java.lang.String) valueSet.objectValue(4, java.lang.String.class));
                    break;
                case 121107:
                    this.wg.onRewardArrived(valueSet.booleanValue(0), valueSet.intValue(1), (android.os.Bundle) valueSet.objectValue(2, android.os.Bundle.class));
                    break;
                case 121108:
                    rewardAdInteractionListener.onSkippedVideo();
                    break;
            }
        } else {
            return null;
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public com.bykv.vk.openvk.api.proto.ValueSet values() {
        return this.vw;
    }
}
