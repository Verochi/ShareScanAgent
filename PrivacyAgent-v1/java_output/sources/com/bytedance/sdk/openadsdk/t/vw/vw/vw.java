package com.bytedance.sdk.openadsdk.t.vw.vw;

/* loaded from: classes22.dex */
public class vw extends com.bytedance.sdk.openadsdk.CSJAdError {
    private final com.bykv.vk.openvk.api.proto.Bridge vw;

    public vw(com.bykv.vk.openvk.api.proto.Bridge bridge) {
        this.vw = bridge == null ? com.bykv.vw.vw.vw.vw.wg.wg : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.CSJAdError
    public int getCode() {
        return this.vw.values().intValue(263001);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJAdError
    public java.lang.String getMsg() {
        return (java.lang.String) this.vw.values().objectValue(263002, java.lang.String.class);
    }
}
