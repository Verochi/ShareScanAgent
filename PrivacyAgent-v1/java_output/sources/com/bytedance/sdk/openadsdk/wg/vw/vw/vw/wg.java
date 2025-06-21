package com.bytedance.sdk.openadsdk.wg.vw.vw.vw;

/* loaded from: classes22.dex */
public class wg implements com.bykv.vk.openvk.api.proto.Bridge {
    private com.bykv.vk.openvk.api.proto.ValueSet vw = com.bykv.vw.vw.vw.vw.wg.vw;
    private final com.bytedance.sdk.openadsdk.CSJSplashAd.SplashCardListener wg;

    public wg(com.bytedance.sdk.openadsdk.CSJSplashAd.SplashCardListener splashCardListener) {
        this.wg = splashCardListener;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0025, code lost:
    
        return null;
     */
    @Override // com.bykv.vk.openvk.api.proto.Caller
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T> T call(int i, com.bykv.vk.openvk.api.proto.ValueSet valueSet, java.lang.Class<T> cls) {
        com.bytedance.sdk.openadsdk.CSJSplashAd.SplashCardListener splashCardListener = this.wg;
        if (splashCardListener != null) {
            switch (i) {
                case 112102:
                    splashCardListener.onSplashCardClick();
                    break;
                case 112103:
                    splashCardListener.onSplashCardClose();
                    break;
                case 121201:
                    this.wg.onSplashCardReadyToShow(new com.bytedance.sdk.openadsdk.t.vw.vw.wg((com.bykv.vk.openvk.api.proto.Bridge) valueSet.objectValue(0, com.bykv.vk.openvk.api.proto.Bridge.class)));
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
