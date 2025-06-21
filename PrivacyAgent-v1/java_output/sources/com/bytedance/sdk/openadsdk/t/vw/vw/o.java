package com.bytedance.sdk.openadsdk.t.vw.vw;

/* loaded from: classes22.dex */
public class o implements com.bytedance.sdk.openadsdk.TTAdDislike {
    private final com.bykv.vk.openvk.api.proto.Bridge vw;

    public o(com.bykv.vk.openvk.api.proto.Bridge bridge) {
        this.vw = bridge == null ? com.bykv.vw.vw.vw.vw.wg.wg : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public boolean isShow() {
        return ((java.lang.Boolean) this.vw.call(240105, com.bykv.vw.vw.vw.vw.wg.vw(0).wg(), java.lang.Boolean.TYPE)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void resetDislikeStatus() {
        this.vw.call(240104, com.bykv.vw.vw.vw.vw.wg.vw(0).wg(), java.lang.Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void setDislikeInteractionCallback(com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        com.bykv.vw.vw.vw.vw.wg vw = com.bykv.vw.vw.vw.vw.wg.vw(1);
        vw.vw(0, new com.bytedance.sdk.openadsdk.kz.vw.vw.vw.vw(dislikeInteractionCallback));
        this.vw.call(240102, vw.wg(), java.lang.Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void setDislikeSource(java.lang.String str) {
        com.bykv.vw.vw.vw.vw.wg vw = com.bykv.vw.vw.vw.vw.wg.vw(1);
        vw.vw(0, str);
        this.vw.call(240103, vw.wg(), java.lang.Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void showDislikeDialog() {
        this.vw.call(240101, com.bykv.vw.vw.vw.vw.wg.vw(0).wg(), java.lang.Void.class);
    }
}
