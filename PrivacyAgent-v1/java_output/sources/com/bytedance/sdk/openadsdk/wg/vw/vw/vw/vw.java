package com.bytedance.sdk.openadsdk.wg.vw.vw.vw;

/* loaded from: classes22.dex */
public class vw implements com.bykv.vk.openvk.api.proto.Bridge {
    private com.bykv.vk.openvk.api.proto.ValueSet vw = com.bykv.vw.vw.vw.vw.wg.vw;
    private final com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener wg;

    public vw(com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener splashAdListener) {
        this.wg = splashAdListener;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0044, code lost:
    
        return null;
     */
    @Override // com.bykv.vk.openvk.api.proto.Caller
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T> T call(int i, com.bykv.vk.openvk.api.proto.ValueSet valueSet, java.lang.Class<T> cls) {
        if (this.wg != null) {
            switch (i) {
                case 111101:
                    this.wg.onSplashAdShow(new com.bytedance.sdk.openadsdk.t.vw.vw.wg((com.bykv.vk.openvk.api.proto.Bridge) valueSet.objectValue(0, com.bykv.vk.openvk.api.proto.Bridge.class)));
                    break;
                case 111102:
                    this.wg.onSplashAdClick(new com.bytedance.sdk.openadsdk.t.vw.vw.wg((com.bykv.vk.openvk.api.proto.Bridge) valueSet.objectValue(0, com.bykv.vk.openvk.api.proto.Bridge.class)));
                    break;
                case 111103:
                    this.wg.onSplashAdClose(new com.bytedance.sdk.openadsdk.t.vw.vw.wg((com.bykv.vk.openvk.api.proto.Bridge) valueSet.objectValue(0, com.bykv.vk.openvk.api.proto.Bridge.class)), valueSet.intValue(1));
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
