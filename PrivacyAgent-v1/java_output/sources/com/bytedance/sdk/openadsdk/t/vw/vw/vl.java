package com.bytedance.sdk.openadsdk.t.vw.vw;

/* loaded from: classes22.dex */
public class vl implements com.bytedance.sdk.openadsdk.TTFullScreenVideoAd {
    private final com.bykv.vk.openvk.api.proto.Bridge vw;

    public vl(com.bykv.vk.openvk.api.proto.Bridge bridge) {
        this.vw = bridge == null ? com.bykv.vw.vw.vw.vw.wg.wg : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public long getExpirationTimestamp() {
        return this.vw.values().longValue(130004);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public int getFullVideoAdType() {
        return this.vw.values().intValue(130003);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public int getInteractionType() {
        return this.vw.values().intValue(130001);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public java.util.Map<java.lang.String, java.lang.Object> getMediaExtraInfo() {
        return (java.util.Map) this.vw.values().objectValue(130002, java.util.Map.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void loss(java.lang.Double d, java.lang.String str, java.lang.String str2) {
        com.bykv.vw.vw.vw.vw.wg vw = com.bykv.vw.vw.vw.vw.wg.vw(3);
        vw.vw(0, d);
        vw.vw(1, str);
        vw.vw(2, str2);
        this.vw.call(210102, vw.wg(), java.lang.Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void setAdInteractionListener(com.bytedance.sdk.openadsdk.TTAdInteractionListener tTAdInteractionListener) {
        com.bykv.vw.vw.vw.vw.wg vw = com.bykv.vw.vw.vw.vw.wg.vw(1);
        vw.vw(0, new com.bytedance.sdk.openadsdk.t.vw.wg.vw(tTAdInteractionListener));
        this.vw.call(210104, vw.wg(), java.lang.Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void setDownloadListener(com.bytedance.sdk.openadsdk.TTAppDownloadListener tTAppDownloadListener) {
        com.bykv.vw.vw.vw.vw.wg vw = com.bykv.vw.vw.vw.vw.wg.vw(1);
        vw.vw(0, new com.bytedance.sdk.openadsdk.t.vw.wg.wg(tTAppDownloadListener));
        this.vw.call(130102, vw.wg(), java.lang.Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void setFullScreenVideoAdInteractionListener(com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        com.bykv.vw.vw.vw.vw.wg vw = com.bykv.vw.vw.vw.vw.wg.vw(1);
        vw.vw(0, new com.bytedance.sdk.openadsdk.es.vw.vw.vw.vw(fullScreenVideoAdInteractionListener));
        this.vw.call(130101, vw.wg(), java.lang.Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void setPrice(java.lang.Double d) {
        com.bykv.vw.vw.vw.vw.wg vw = com.bykv.vw.vw.vw.vw.wg.vw(1);
        vw.vw(0, d);
        this.vw.call(210103, vw.wg(), java.lang.Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void setShowDownLoadBar(boolean z) {
        com.bykv.vw.vw.vw.vw.wg vw = com.bykv.vw.vw.vw.vw.wg.vw(1);
        vw.vw(0, z);
        this.vw.call(130105, vw.wg(), java.lang.Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void showFullScreenVideoAd(android.app.Activity activity) {
        com.bykv.vw.vw.vw.vw.wg vw = com.bykv.vw.vw.vw.vw.wg.vw(1);
        vw.vw(0, activity);
        this.vw.call(130103, vw.wg(), java.lang.Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void showFullScreenVideoAd(android.app.Activity activity, com.bytedance.sdk.openadsdk.TTAdConstant.RitScenes ritScenes, java.lang.String str) {
        com.bykv.vw.vw.vw.vw.wg vw = com.bykv.vw.vw.vw.vw.wg.vw(3);
        vw.vw(0, activity);
        vw.vw(1, ritScenes);
        vw.vw(2, str);
        this.vw.call(130104, vw.wg(), java.lang.Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void win(java.lang.Double d) {
        com.bykv.vw.vw.vw.vw.wg vw = com.bykv.vw.vw.vw.vw.wg.vw(1);
        vw.vw(0, d);
        this.vw.call(210101, vw.wg(), java.lang.Void.class);
    }
}
