package com.bytedance.sdk.openadsdk.o.vw.vw.vw;

/* loaded from: classes22.dex */
public class vw implements com.bykv.vk.openvk.api.proto.Bridge {
    private com.bykv.vk.openvk.api.proto.ValueSet vw = com.bykv.vw.vw.vw.vw.wg.vw;
    private final com.bytedance.sdk.openadsdk.TTDrawFeedAd.DrawVideoListener wg;

    public vw(com.bytedance.sdk.openadsdk.TTDrawFeedAd.DrawVideoListener drawVideoListener) {
        this.wg = drawVideoListener;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0011, code lost:
    
        return null;
     */
    @Override // com.bykv.vk.openvk.api.proto.Caller
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T> T call(int i, com.bykv.vk.openvk.api.proto.ValueSet valueSet, java.lang.Class<T> cls) {
        com.bytedance.sdk.openadsdk.TTDrawFeedAd.DrawVideoListener drawVideoListener = this.wg;
        if (drawVideoListener != null) {
            switch (i) {
                case 171101:
                    drawVideoListener.onClick();
                    break;
                case 171102:
                    drawVideoListener.onClickRetry();
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
