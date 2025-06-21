package com.bytedance.sdk.openadsdk.t.vw.wg;

/* loaded from: classes22.dex */
public class vw implements com.bykv.vk.openvk.api.proto.Bridge {
    private com.bykv.vk.openvk.api.proto.ValueSet vw = com.bykv.vw.vw.vw.vw.wg.vw;
    private final com.bytedance.sdk.openadsdk.TTAdInteractionListener wg;

    public vw(com.bytedance.sdk.openadsdk.TTAdInteractionListener tTAdInteractionListener) {
        this.wg = tTAdInteractionListener;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, com.bykv.vk.openvk.api.proto.ValueSet valueSet, java.lang.Class<T> cls) {
        if (this.wg != null && i == 100101) {
            this.wg.onAdEvent(valueSet.intValue(0), (java.util.Map) valueSet.objectValue(1, java.util.Map.class));
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public com.bykv.vk.openvk.api.proto.ValueSet values() {
        return this.vw;
    }
}
