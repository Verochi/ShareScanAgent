package com.bytedance.sdk.openadsdk.z.vw.vw.vw;

/* loaded from: classes22.dex */
public class wg implements com.bykv.vk.openvk.api.proto.Bridge {
    private com.bykv.vk.openvk.api.proto.ValueSet vw = com.bykv.vw.vw.vw.vw.wg.vw;
    private final com.bytedance.sdk.openadsdk.TTNativeAd.ExpressRenderListener wg;

    public wg(com.bytedance.sdk.openadsdk.TTNativeAd.ExpressRenderListener expressRenderListener) {
        this.wg = expressRenderListener;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, com.bykv.vk.openvk.api.proto.ValueSet valueSet, java.lang.Class<T> cls) {
        if (this.wg != null && i == 142101) {
            this.wg.onRenderSuccess((android.view.View) valueSet.objectValue(0, android.view.View.class), valueSet.floatValue(1), valueSet.floatValue(2), valueSet.booleanValue(3));
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public com.bykv.vk.openvk.api.proto.ValueSet values() {
        return this.vw;
    }
}
