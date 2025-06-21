package com.bytedance.sdk.openadsdk.wg.vw.vw.vw;

/* loaded from: classes22.dex */
public class t implements com.bykv.vk.openvk.api.proto.Bridge {
    private com.bykv.vk.openvk.api.proto.ValueSet vw = com.bykv.vw.vw.vw.vw.wg.vw;
    private final com.bytedance.sdk.openadsdk.CSJSplashAd.SplashClickEyeListener wg;

    public t(com.bytedance.sdk.openadsdk.CSJSplashAd.SplashClickEyeListener splashClickEyeListener) {
        this.wg = splashClickEyeListener;
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
        com.bytedance.sdk.openadsdk.CSJSplashAd.SplashClickEyeListener splashClickEyeListener = this.wg;
        if (splashClickEyeListener != null) {
            switch (i) {
                case 113101:
                    this.wg.onSplashClickEyeReadyToShow(new com.bytedance.sdk.openadsdk.t.vw.vw.wg((com.bykv.vk.openvk.api.proto.Bridge) valueSet.objectValue(0, com.bykv.vk.openvk.api.proto.Bridge.class)));
                    break;
                case 113102:
                    splashClickEyeListener.onSplashClickEyeClick();
                    break;
                case 113103:
                    splashClickEyeListener.onSplashClickEyeClose();
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
