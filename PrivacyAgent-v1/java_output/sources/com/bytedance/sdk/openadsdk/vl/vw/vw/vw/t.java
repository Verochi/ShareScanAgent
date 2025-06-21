package com.bytedance.sdk.openadsdk.vl.vw.vw.vw;

/* loaded from: classes22.dex */
public class t implements com.bykv.vk.openvk.api.proto.Bridge {
    private com.bykv.vk.openvk.api.proto.ValueSet vw = com.bykv.vw.vw.vw.vw.wg.vw;
    private final com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener wg;

    public t(com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener expressVideoAdListener) {
        this.wg = expressVideoAdListener;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003f, code lost:
    
        return null;
     */
    @Override // com.bykv.vk.openvk.api.proto.Caller
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T> T call(int i, com.bykv.vk.openvk.api.proto.ValueSet valueSet, java.lang.Class<T> cls) {
        com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener expressVideoAdListener = this.wg;
        if (expressVideoAdListener != null) {
            switch (i) {
                case 152101:
                    expressVideoAdListener.onVideoLoad();
                    break;
                case 152102:
                    this.wg.onVideoError(valueSet.intValue(0), valueSet.intValue(1));
                    break;
                case 152103:
                    expressVideoAdListener.onVideoAdStartPlay();
                    break;
                case 152104:
                    expressVideoAdListener.onVideoAdPaused();
                    break;
                case 152105:
                    expressVideoAdListener.onVideoAdContinuePlay();
                    break;
                case 152106:
                    this.wg.onProgressUpdate(valueSet.longValue(0), valueSet.longValue(1));
                    break;
                case 152107:
                    expressVideoAdListener.onVideoAdComplete();
                    break;
                case 152108:
                    expressVideoAdListener.onClickRetry();
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
