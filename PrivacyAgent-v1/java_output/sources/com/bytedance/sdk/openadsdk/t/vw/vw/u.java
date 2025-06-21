package com.bytedance.sdk.openadsdk.t.vw.vw;

/* loaded from: classes22.dex */
public class u extends com.bytedance.sdk.openadsdk.TTImage {
    private final com.bykv.vk.openvk.api.proto.Bridge vw;

    public u(com.bykv.vk.openvk.api.proto.Bridge bridge) {
        this.vw = bridge == null ? com.bykv.vw.vw.vw.vw.wg.wg : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.TTImage
    public double getDuration() {
        return this.vw.values().doubleValue(230004);
    }

    @Override // com.bytedance.sdk.openadsdk.TTImage
    public int getHeight() {
        return this.vw.values().intValue(230002);
    }

    @Override // com.bytedance.sdk.openadsdk.TTImage
    public java.lang.String getImageUrl() {
        return (java.lang.String) this.vw.values().objectValue(230003, java.lang.String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTImage
    public int getWidth() {
        return this.vw.values().intValue(230001);
    }

    @Override // com.bytedance.sdk.openadsdk.TTImage
    public boolean isValid() {
        return this.vw.values().booleanValue(230005);
    }
}
