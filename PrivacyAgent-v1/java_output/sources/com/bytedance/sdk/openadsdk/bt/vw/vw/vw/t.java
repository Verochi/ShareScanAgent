package com.bytedance.sdk.openadsdk.bt.vw.vw.vw;

/* loaded from: classes22.dex */
public class t implements com.bykv.vk.openvk.api.proto.Bridge {
    private com.bykv.vk.openvk.api.proto.ValueSet vw = com.bykv.vw.vw.vw.vw.wg.vw;
    private final com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener wg;

    public t(com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener) {
        this.wg = fullScreenVideoAdListener;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0045, code lost:
    
        return null;
     */
    @Override // com.bykv.vk.openvk.api.proto.Caller
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T> T call(int i, com.bykv.vk.openvk.api.proto.ValueSet valueSet, java.lang.Class<T> cls) {
        com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener = this.wg;
        if (fullScreenVideoAdListener != null) {
            switch (i) {
                case 132101:
                    this.wg.onError(valueSet.intValue(0), (java.lang.String) valueSet.objectValue(1, java.lang.String.class));
                    break;
                case 132102:
                    this.wg.onFullScreenVideoAdLoad(new com.bytedance.sdk.openadsdk.t.vw.vw.vl((com.bykv.vk.openvk.api.proto.Bridge) valueSet.objectValue(0, com.bykv.vk.openvk.api.proto.Bridge.class)));
                    break;
                case 132103:
                    this.wg.onFullScreenVideoCached(new com.bytedance.sdk.openadsdk.t.vw.vw.vl((com.bykv.vk.openvk.api.proto.Bridge) valueSet.objectValue(0, com.bykv.vk.openvk.api.proto.Bridge.class)));
                    break;
                case 132104:
                    fullScreenVideoAdListener.onFullScreenVideoCached();
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
