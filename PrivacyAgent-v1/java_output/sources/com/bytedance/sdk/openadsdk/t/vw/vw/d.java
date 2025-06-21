package com.bytedance.sdk.openadsdk.t.vw.vw;

/* loaded from: classes22.dex */
public class d implements com.bytedance.sdk.openadsdk.TTNativeExpressAd {
    private final com.bykv.vk.openvk.api.proto.Bridge vw;

    public d(com.bykv.vk.openvk.api.proto.Bridge bridge) {
        this.vw = bridge == null ? com.bykv.vw.vw.vw.vw.wg.wg : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void destroy() {
        this.vw.call(150105, com.bykv.vw.vw.vw.vw.wg.vw(0).wg(), java.lang.Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public com.bytedance.sdk.openadsdk.TTAdDislike getDislikeDialog(android.app.Activity activity) {
        com.bykv.vw.vw.vw.vw.wg vw = com.bykv.vw.vw.vw.vw.wg.vw(1);
        vw.vw(0, activity);
        return new com.bytedance.sdk.openadsdk.t.vw.vw.o((com.bykv.vk.openvk.api.proto.Bridge) this.vw.call(150108, vw.wg(), com.bykv.vk.openvk.api.proto.Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public com.bytedance.sdk.openadsdk.DislikeInfo getDislikeInfo() {
        return new com.bytedance.sdk.openadsdk.t.vw.vw.v((com.bykv.vk.openvk.api.proto.Bridge) this.vw.values().objectValue(150003, com.bykv.vk.openvk.api.proto.Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public android.view.View getExpressAdView() {
        return (android.view.View) this.vw.values().objectValue(150001, android.view.View.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public int getImageMode() {
        return this.vw.values().intValue(150002);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public int getInteractionType() {
        return this.vw.values().intValue(150004);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public java.util.Map<java.lang.String, java.lang.Object> getMediaExtraInfo() {
        return (java.util.Map) this.vw.values().objectValue(150005, java.util.Map.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void loss(java.lang.Double d, java.lang.String str, java.lang.String str2) {
        com.bykv.vw.vw.vw.vw.wg vw = com.bykv.vw.vw.vw.vw.wg.vw(3);
        vw.vw(0, d);
        vw.vw(1, str);
        vw.vw(2, str2);
        this.vw.call(210102, vw.wg(), java.lang.Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void render() {
        this.vw.call(150104, com.bykv.vw.vw.vw.vw.wg.vw(0).wg(), java.lang.Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void setAdInteractionListener(com.bytedance.sdk.openadsdk.TTAdInteractionListener tTAdInteractionListener) {
        com.bykv.vw.vw.vw.vw.wg vw = com.bykv.vw.vw.vw.vw.wg.vw(1);
        vw.vw(0, new com.bytedance.sdk.openadsdk.t.vw.wg.vw(tTAdInteractionListener));
        this.vw.call(210104, vw.wg(), java.lang.Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setCanInterruptVideoPlay(boolean z) {
        com.bykv.vw.vw.vw.vw.wg vw = com.bykv.vw.vw.vw.vw.wg.vw(1);
        vw.vw(0, z);
        this.vw.call(150112, vw.wg(), java.lang.Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setDislikeCallback(android.app.Activity activity, com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        com.bykv.vw.vw.vw.vw.wg vw = com.bykv.vw.vw.vw.vw.wg.vw(2);
        vw.vw(0, activity);
        vw.vw(1, new com.bytedance.sdk.openadsdk.kz.vw.vw.vw.vw(dislikeInteractionCallback));
        this.vw.call(150106, vw.wg(), java.lang.Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setDislikeDialog(com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        com.bykv.vw.vw.vw.vw.wg vw = com.bykv.vw.vw.vw.vw.wg.vw(1);
        vw.vw(0, tTDislikeDialogAbstract);
        this.vw.call(150107, vw.wg(), java.lang.Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setDownloadListener(com.bytedance.sdk.openadsdk.TTAppDownloadListener tTAppDownloadListener) {
        com.bykv.vw.vw.vw.vw.wg vw = com.bykv.vw.vw.vw.vw.wg.vw(1);
        vw.vw(0, new com.bytedance.sdk.openadsdk.t.vw.wg.wg(tTAppDownloadListener));
        this.vw.call(150103, vw.wg(), java.lang.Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setExpressInteractionListener(com.bytedance.sdk.openadsdk.TTNativeExpressAd.AdInteractionListener adInteractionListener) {
        com.bykv.vw.vw.vw.vw.wg vw = com.bykv.vw.vw.vw.vw.wg.vw(1);
        vw.vw(0, new com.bytedance.sdk.openadsdk.vl.vw.vw.vw.vw(adInteractionListener));
        this.vw.call(150102, vw.wg(), java.lang.Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setExpressInteractionListener(com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener) {
        com.bykv.vw.vw.vw.vw.wg vw = com.bykv.vw.vw.vw.vw.wg.vw(1);
        vw.vw(0, new com.bytedance.sdk.openadsdk.vl.vw.vw.vw.wg(expressAdInteractionListener));
        this.vw.call(150101, vw.wg(), java.lang.Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void setPrice(java.lang.Double d) {
        com.bykv.vw.vw.vw.vw.wg vw = com.bykv.vw.vw.vw.vw.wg.vw(1);
        vw.vw(0, d);
        this.vw.call(210103, vw.wg(), java.lang.Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setSlideIntervalTime(int i) {
        com.bykv.vw.vw.vw.vw.wg vw = com.bykv.vw.vw.vw.vw.wg.vw(1);
        vw.vw(0, i);
        this.vw.call(150110, vw.wg(), java.lang.Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setVideoAdListener(com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener expressVideoAdListener) {
        com.bykv.vw.vw.vw.vw.wg vw = com.bykv.vw.vw.vw.vw.wg.vw(1);
        vw.vw(0, new com.bytedance.sdk.openadsdk.vl.vw.vw.vw.t(expressVideoAdListener));
        this.vw.call(150111, vw.wg(), java.lang.Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void showInteractionExpressAd(android.app.Activity activity) {
        com.bykv.vw.vw.vw.vw.wg vw = com.bykv.vw.vw.vw.vw.wg.vw(1);
        vw.vw(0, activity);
        this.vw.call(150109, vw.wg(), java.lang.Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void uploadDislikeEvent(java.lang.String str) {
        com.bykv.vw.vw.vw.vw.wg vw = com.bykv.vw.vw.vw.vw.wg.vw(1);
        vw.vw(0, str);
        this.vw.call(150114, vw.wg(), java.lang.Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void win(java.lang.Double d) {
        com.bykv.vw.vw.vw.vw.wg vw = com.bykv.vw.vw.vw.vw.wg.vw(1);
        vw.vw(0, d);
        this.vw.call(210101, vw.wg(), java.lang.Void.class);
    }
}
