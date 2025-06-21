package com.bytedance.sdk.openadsdk.x.vw.vw.vw;

/* loaded from: classes22.dex */
public class vw implements com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo {
    private final com.bykv.vk.openvk.api.proto.Bridge vw;

    public vw(com.bykv.vk.openvk.api.proto.Bridge bridge) {
        this.vw = bridge == null ? com.bykv.vw.vw.vw.vw.wg.wg : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public java.lang.String getVideoUrl() {
        return (java.lang.String) this.vw.call(162101, com.bykv.vw.vw.vw.vw.wg.vw(0).wg(), java.lang.String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoAutoStart() {
        this.vw.call(162107, com.bykv.vw.vw.vw.vw.wg.vw(0).wg(), java.lang.Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoBreak(long j) {
        com.bykv.vw.vw.vw.vw.wg vw = com.bykv.vw.vw.vw.vw.wg.vw(1);
        vw.vw(0, j);
        this.vw.call(162106, vw.wg(), java.lang.Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoContinue(long j) {
        com.bykv.vw.vw.vw.vw.wg vw = com.bykv.vw.vw.vw.vw.wg.vw(1);
        vw.vw(0, j);
        this.vw.call(162104, vw.wg(), java.lang.Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoError(long j, int i, int i2) {
        com.bykv.vw.vw.vw.vw.wg vw = com.bykv.vw.vw.vw.vw.wg.vw(3);
        vw.vw(0, j);
        vw.vw(1, i);
        vw.vw(2, i2);
        this.vw.call(162109, vw.wg(), java.lang.Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoFinish() {
        this.vw.call(162105, com.bykv.vw.vw.vw.vw.wg.vw(0).wg(), java.lang.Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoPause(long j) {
        com.bykv.vw.vw.vw.vw.wg vw = com.bykv.vw.vw.vw.vw.wg.vw(1);
        vw.vw(0, j);
        this.vw.call(162103, vw.wg(), java.lang.Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoStart() {
        this.vw.call(162102, com.bykv.vw.vw.vw.vw.wg.vw(0).wg(), java.lang.Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoStartError(int i, int i2) {
        com.bykv.vw.vw.vw.vw.wg vw = com.bykv.vw.vw.vw.vw.wg.vw(2);
        vw.vw(0, i);
        vw.vw(1, i2);
        this.vw.call(162108, vw.wg(), java.lang.Void.class);
    }
}
