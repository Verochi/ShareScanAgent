package com.bytedance.sdk.openadsdk.es.vw.vw.vw;

/* loaded from: classes22.dex */
public class vw implements com.bykv.vk.openvk.api.proto.Bridge {
    private com.bykv.vk.openvk.api.proto.ValueSet vw = com.bykv.vw.vw.vw.vw.wg.vw;
    private final com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener wg;

    public vw(com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        this.wg = fullScreenVideoAdInteractionListener;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x001d, code lost:
    
        return null;
     */
    @Override // com.bykv.vk.openvk.api.proto.Caller
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T> T call(int i, com.bykv.vk.openvk.api.proto.ValueSet valueSet, java.lang.Class<T> cls) {
        com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener = this.wg;
        if (fullScreenVideoAdInteractionListener != null) {
            switch (i) {
                case 131101:
                    fullScreenVideoAdInteractionListener.onAdShow();
                    break;
                case 131102:
                    fullScreenVideoAdInteractionListener.onAdVideoBarClick();
                    break;
                case 131103:
                    fullScreenVideoAdInteractionListener.onAdClose();
                    break;
                case 131104:
                    fullScreenVideoAdInteractionListener.onVideoComplete();
                    break;
                case 131105:
                    fullScreenVideoAdInteractionListener.onSkippedVideo();
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
