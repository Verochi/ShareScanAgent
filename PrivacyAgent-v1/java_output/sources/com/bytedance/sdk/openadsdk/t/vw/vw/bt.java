package com.bytedance.sdk.openadsdk.t.vw.vw;

/* loaded from: classes22.dex */
public class bt implements com.bytedance.sdk.openadsdk.PersonalizationPrompt {
    private final com.bykv.vk.openvk.api.proto.Bridge vw;

    public bt(com.bykv.vk.openvk.api.proto.Bridge bridge) {
        this.vw = bridge == null ? com.bykv.vw.vw.vw.vw.wg.wg : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.PersonalizationPrompt
    public java.lang.String getName() {
        return (java.lang.String) this.vw.values().objectValue(242002, java.lang.String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.PersonalizationPrompt
    public java.lang.String getUrl() {
        return (java.lang.String) this.vw.values().objectValue(242001, java.lang.String.class);
    }
}
