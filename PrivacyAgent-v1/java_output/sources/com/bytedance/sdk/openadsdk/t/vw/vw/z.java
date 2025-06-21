package com.bytedance.sdk.openadsdk.t.vw.vw;

/* loaded from: classes22.dex */
public class z implements com.bytedance.sdk.openadsdk.TTFeedAd {
    private final com.bykv.vk.openvk.api.proto.Bridge vw;

    public z(com.bykv.vk.openvk.api.proto.Bridge bridge) {
        this.vw = bridge == null ? com.bykv.vw.vw.vw.vw.wg.wg : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void destroy() {
        this.vw.call(140114, com.bykv.vw.vw.vw.vw.wg.vw(0).wg(), java.lang.Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public android.graphics.Bitmap getAdLogo() {
        return (android.graphics.Bitmap) this.vw.values().objectValue(140002, android.graphics.Bitmap.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public android.view.View getAdView() {
        return (android.view.View) this.vw.values().objectValue(140016, android.view.View.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd
    public int getAdViewHeight() {
        return this.vw.values().intValue(160004);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd
    public int getAdViewWidth() {
        return this.vw.values().intValue(160003);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public int getAppCommentNum() {
        return this.vw.values().intValue(140006);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public int getAppScore() {
        return this.vw.values().intValue(140005);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public int getAppSize() {
        return this.vw.values().intValue(140007);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public java.lang.String getButtonText() {
        return (java.lang.String) this.vw.values().objectValue(140018, java.lang.String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public com.bytedance.sdk.openadsdk.ComplianceInfo getComplianceInfo() {
        return new com.bytedance.sdk.openadsdk.t.vw.vw.t((com.bykv.vk.openvk.api.proto.Bridge) this.vw.values().objectValue(140014, com.bykv.vk.openvk.api.proto.Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd
    public com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo getCustomVideo() {
        return new com.bytedance.sdk.openadsdk.x.vw.vw.vw.vw((com.bykv.vk.openvk.api.proto.Bridge) this.vw.values().objectValue(160002, com.bykv.vk.openvk.api.proto.Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public java.lang.String getDescription() {
        return (java.lang.String) this.vw.values().objectValue(140004, java.lang.String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public com.bytedance.sdk.openadsdk.TTAdDislike getDislikeDialog(android.app.Activity activity) {
        com.bykv.vw.vw.vw.vw.wg vw = com.bykv.vw.vw.vw.vw.wg.vw(1);
        vw.vw(0, activity);
        return new com.bytedance.sdk.openadsdk.t.vw.vw.o((com.bykv.vk.openvk.api.proto.Bridge) this.vw.call(140101, vw.wg(), com.bykv.vk.openvk.api.proto.Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public com.bytedance.sdk.openadsdk.TTAdDislike getDislikeDialog(com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        com.bykv.vw.vw.vw.vw.wg vw = com.bykv.vw.vw.vw.vw.wg.vw(1);
        vw.vw(0, tTDislikeDialogAbstract);
        return new com.bytedance.sdk.openadsdk.t.vw.vw.o((com.bykv.vk.openvk.api.proto.Bridge) this.vw.call(140102, vw.wg(), com.bykv.vk.openvk.api.proto.Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public com.bytedance.sdk.openadsdk.DislikeInfo getDislikeInfo() {
        return new com.bytedance.sdk.openadsdk.t.vw.vw.v((com.bykv.vk.openvk.api.proto.Bridge) this.vw.values().objectValue(140013, com.bykv.vk.openvk.api.proto.Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public com.bytedance.sdk.openadsdk.DownloadStatusController getDownloadStatusController() {
        return new com.bytedance.sdk.openadsdk.t.vw.vw.yl((com.bykv.vk.openvk.api.proto.Bridge) this.vw.values().objectValue(140015, com.bykv.vk.openvk.api.proto.Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public com.bytedance.sdk.openadsdk.TTImage getIcon() {
        return new com.bytedance.sdk.openadsdk.t.vw.vw.u((com.bykv.vk.openvk.api.proto.Bridge) this.vw.values().objectValue(140009, com.bykv.vk.openvk.api.proto.Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public java.util.List<com.bytedance.sdk.openadsdk.TTImage> getImageList() {
        java.util.List list = (java.util.List) this.vw.values().objectValue(140010, java.util.List.class);
        if (list == null) {
            list = new java.util.ArrayList(0);
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new com.bytedance.sdk.openadsdk.t.vw.vw.u((com.bykv.vk.openvk.api.proto.Bridge) it.next()));
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public int getImageMode() {
        return this.vw.values().intValue(140012);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public int getInteractionType() {
        return this.vw.values().intValue(140011);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public java.util.Map<java.lang.String, java.lang.Object> getMediaExtraInfo() {
        return (java.util.Map) this.vw.values().objectValue(140017, java.util.Map.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public java.lang.String getSource() {
        return (java.lang.String) this.vw.values().objectValue(140008, java.lang.String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public java.lang.String getTitle() {
        return (java.lang.String) this.vw.values().objectValue(140003, java.lang.String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public com.bytedance.sdk.openadsdk.TTImage getVideoCoverImage() {
        return new com.bytedance.sdk.openadsdk.t.vw.vw.u((com.bykv.vk.openvk.api.proto.Bridge) this.vw.values().objectValue(140001, com.bykv.vk.openvk.api.proto.Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd
    public double getVideoDuration() {
        return this.vw.values().doubleValue(160001);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void loss(java.lang.Double d, java.lang.String str, java.lang.String str2) {
        com.bykv.vw.vw.vw.vw.wg vw = com.bykv.vw.vw.vw.vw.wg.vw(3);
        vw.vw(0, d);
        vw.vw(1, str);
        vw.vw(2, str2);
        this.vw.call(210102, vw.wg(), java.lang.Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void registerViewForInteraction(android.view.ViewGroup viewGroup, android.view.View view, com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener adInteractionListener) {
        com.bykv.vw.vw.vw.vw.wg vw = com.bykv.vw.vw.vw.vw.wg.vw(3);
        vw.vw(0, viewGroup);
        vw.vw(1, view);
        vw.vw(2, new com.bytedance.sdk.openadsdk.z.vw.vw.vw.vw(adInteractionListener));
        this.vw.call(140103, vw.wg(), java.lang.Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void registerViewForInteraction(android.view.ViewGroup viewGroup, java.util.List<android.view.View> list, java.util.List<android.view.View> list2, android.view.View view, com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener adInteractionListener) {
        com.bykv.vw.vw.vw.vw.wg vw = com.bykv.vw.vw.vw.vw.wg.vw(5);
        vw.vw(0, viewGroup);
        vw.vw(1, list);
        vw.vw(2, list2);
        vw.vw(3, view);
        vw.vw(4, new com.bytedance.sdk.openadsdk.z.vw.vw.vw.vw(adInteractionListener));
        this.vw.call(140105, vw.wg(), java.lang.Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void registerViewForInteraction(android.view.ViewGroup viewGroup, java.util.List<android.view.View> list, java.util.List<android.view.View> list2, com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener adInteractionListener) {
        com.bykv.vw.vw.vw.vw.wg vw = com.bykv.vw.vw.vw.vw.wg.vw(4);
        vw.vw(0, viewGroup);
        vw.vw(1, list);
        vw.vw(2, list2);
        vw.vw(3, new com.bytedance.sdk.openadsdk.z.vw.vw.vw.vw(adInteractionListener));
        this.vw.call(140104, vw.wg(), java.lang.Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void registerViewForInteraction(android.view.ViewGroup viewGroup, java.util.List<android.view.View> list, java.util.List<android.view.View> list2, java.util.List<android.view.View> list3, android.view.View view, com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener adInteractionListener) {
        com.bykv.vw.vw.vw.vw.wg vw = com.bykv.vw.vw.vw.vw.wg.vw(6);
        vw.vw(0, viewGroup);
        vw.vw(1, list);
        vw.vw(2, list2);
        vw.vw(3, list3);
        vw.vw(4, view);
        vw.vw(5, new com.bytedance.sdk.openadsdk.z.vw.vw.vw.vw(adInteractionListener));
        this.vw.call(140106, vw.wg(), java.lang.Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void registerViewForInteraction(android.view.ViewGroup viewGroup, java.util.List<android.view.View> list, java.util.List<android.view.View> list2, java.util.List<android.view.View> list3, java.util.List<android.view.View> list4, android.view.View view, com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener adInteractionListener) {
        com.bykv.vw.vw.vw.vw.wg vw = com.bykv.vw.vw.vw.vw.wg.vw(7);
        vw.vw(0, viewGroup);
        vw.vw(1, list);
        vw.vw(2, list2);
        vw.vw(3, list3);
        vw.vw(4, list4);
        vw.vw(5, view);
        vw.vw(6, new com.bytedance.sdk.openadsdk.z.vw.vw.vw.vw(adInteractionListener));
        this.vw.call(140107, vw.wg(), java.lang.Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void render() {
        this.vw.call(140110, com.bykv.vw.vw.vw.vw.wg.vw(0).wg(), java.lang.Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void setActivityForDownloadApp(android.app.Activity activity) {
        com.bykv.vw.vw.vw.vw.wg vw = com.bykv.vw.vw.vw.vw.wg.vw(1);
        vw.vw(0, activity);
        this.vw.call(140109, vw.wg(), java.lang.Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void setAdInteractionListener(com.bytedance.sdk.openadsdk.TTAdInteractionListener tTAdInteractionListener) {
        com.bykv.vw.vw.vw.vw.wg vw = com.bykv.vw.vw.vw.vw.wg.vw(1);
        vw.vw(0, new com.bytedance.sdk.openadsdk.t.vw.wg.vw(tTAdInteractionListener));
        this.vw.call(210104, vw.wg(), java.lang.Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void setDislikeCallback(android.app.Activity activity, com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        com.bykv.vw.vw.vw.vw.wg vw = com.bykv.vw.vw.vw.vw.wg.vw(2);
        vw.vw(0, activity);
        vw.vw(1, new com.bytedance.sdk.openadsdk.kz.vw.vw.vw.vw(dislikeInteractionCallback));
        this.vw.call(140112, vw.wg(), java.lang.Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void setDislikeDialog(com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        com.bykv.vw.vw.vw.vw.wg vw = com.bykv.vw.vw.vw.vw.wg.vw(1);
        vw.vw(0, tTDislikeDialogAbstract);
        this.vw.call(140113, vw.wg(), java.lang.Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void setDownloadListener(com.bytedance.sdk.openadsdk.TTAppDownloadListener tTAppDownloadListener) {
        com.bykv.vw.vw.vw.vw.wg vw = com.bykv.vw.vw.vw.vw.wg.vw(1);
        vw.vw(0, new com.bytedance.sdk.openadsdk.t.vw.wg.wg(tTAppDownloadListener));
        this.vw.call(140108, vw.wg(), java.lang.Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void setExpressRenderListener(com.bytedance.sdk.openadsdk.TTNativeAd.ExpressRenderListener expressRenderListener) {
        com.bykv.vw.vw.vw.vw.wg vw = com.bykv.vw.vw.vw.vw.wg.vw(1);
        vw.vw(0, new com.bytedance.sdk.openadsdk.z.vw.vw.vw.wg(expressRenderListener));
        this.vw.call(140111, vw.wg(), java.lang.Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void setPrice(java.lang.Double d) {
        com.bykv.vw.vw.vw.vw.wg vw = com.bykv.vw.vw.vw.vw.wg.vw(1);
        vw.vw(0, d);
        this.vw.call(210103, vw.wg(), java.lang.Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd
    public void setVideoAdListener(com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener videoAdListener) {
        com.bykv.vw.vw.vw.vw.wg vw = com.bykv.vw.vw.vw.vw.wg.vw(1);
        vw.vw(0, new com.bytedance.sdk.openadsdk.x.vw.vw.wg.vw(videoAdListener));
        this.vw.call(160101, vw.wg(), java.lang.Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd
    public void setVideoRewardListener(com.bytedance.sdk.openadsdk.TTFeedAd.VideoRewardListener videoRewardListener) {
        com.bykv.vw.vw.vw.vw.wg vw = com.bykv.vw.vw.vw.vw.wg.vw(1);
        vw.vw(0, new com.bytedance.sdk.openadsdk.x.vw.vw.wg.wg(videoRewardListener));
        this.vw.call(160102, vw.wg(), java.lang.Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void showInteractionExpressAd(android.app.Activity activity) {
        com.bykv.vw.vw.vw.vw.wg vw = com.bykv.vw.vw.vw.vw.wg.vw(1);
        vw.vw(0, activity);
        this.vw.call(140115, vw.wg(), java.lang.Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd
    public void uploadDislikeEvent(java.lang.String str) {
        com.bykv.vw.vw.vw.vw.wg vw = com.bykv.vw.vw.vw.vw.wg.vw(1);
        vw.vw(0, str);
        this.vw.call(140118, vw.wg(), java.lang.Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void win(java.lang.Double d) {
        com.bykv.vw.vw.vw.vw.wg vw = com.bykv.vw.vw.vw.vw.wg.vw(1);
        vw.vw(0, d);
        this.vw.call(210101, vw.wg(), java.lang.Void.class);
    }
}
