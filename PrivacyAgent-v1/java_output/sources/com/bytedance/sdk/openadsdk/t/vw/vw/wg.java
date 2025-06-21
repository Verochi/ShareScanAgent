package com.bytedance.sdk.openadsdk.t.vw.vw;

/* loaded from: classes22.dex */
public class wg implements com.bytedance.sdk.openadsdk.CSJSplashAd {
    private final com.bykv.vk.openvk.api.proto.Bridge vw;

    public wg(com.bykv.vk.openvk.api.proto.Bridge bridge) {
        this.vw = bridge == null ? com.bykv.vw.vw.vw.vw.wg.wg : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public int getInteractionType() {
        return this.vw.values().intValue(110004);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public java.util.Map<java.lang.String, java.lang.Object> getMediaExtraInfo() {
        return (java.util.Map) this.vw.values().objectValue(110005, java.util.Map.class);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public android.view.View getSplashCardView() {
        return (android.view.View) this.vw.values().objectValue(110003, android.view.View.class);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public int[] getSplashClickEyeSizeToDp() {
        return (int[]) this.vw.values().objectValue(110006, int[].class);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public android.view.View getSplashClickEyeView() {
        return (android.view.View) this.vw.values().objectValue(110002, android.view.View.class);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public android.view.View getSplashView() {
        return (android.view.View) this.vw.values().objectValue(110001, android.view.View.class);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public void hideSkipButton() {
        this.vw.call(110101, com.bykv.vw.vw.vw.vw.wg.vw(0).wg(), java.lang.Void.class);
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

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public void setDownloadListener(com.bytedance.sdk.openadsdk.TTAppDownloadListener tTAppDownloadListener) {
        com.bykv.vw.vw.vw.vw.wg vw = com.bykv.vw.vw.vw.vw.wg.vw(1);
        vw.vw(0, new com.bytedance.sdk.openadsdk.t.vw.wg.wg(tTAppDownloadListener));
        this.vw.call(110102, vw.wg(), java.lang.Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void setPrice(java.lang.Double d) {
        com.bykv.vw.vw.vw.vw.wg vw = com.bykv.vw.vw.vw.vw.wg.vw(1);
        vw.vw(0, d);
        this.vw.call(210103, vw.wg(), java.lang.Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public void setSplashAdListener(com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener splashAdListener) {
        com.bykv.vw.vw.vw.vw.wg vw = com.bykv.vw.vw.vw.vw.wg.vw(1);
        vw.vw(0, new com.bytedance.sdk.openadsdk.wg.vw.vw.vw.vw(splashAdListener));
        this.vw.call(110103, vw.wg(), java.lang.Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public void setSplashCardListener(com.bytedance.sdk.openadsdk.CSJSplashAd.SplashCardListener splashCardListener) {
        com.bykv.vw.vw.vw.vw.wg vw = com.bykv.vw.vw.vw.vw.wg.vw(1);
        vw.vw(0, new com.bytedance.sdk.openadsdk.wg.vw.vw.vw.wg(splashCardListener));
        this.vw.call(110106, vw.wg(), java.lang.Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public void setSplashClickEyeListener(com.bytedance.sdk.openadsdk.CSJSplashAd.SplashClickEyeListener splashClickEyeListener) {
        com.bykv.vw.vw.vw.vw.wg vw = com.bykv.vw.vw.vw.vw.wg.vw(1);
        vw.vw(0, new com.bytedance.sdk.openadsdk.wg.vw.vw.vw.t(splashClickEyeListener));
        this.vw.call(110105, vw.wg(), java.lang.Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public void showSplashCardView(android.view.ViewGroup viewGroup, android.app.Activity activity) {
        com.bykv.vw.vw.vw.vw.wg vw = com.bykv.vw.vw.vw.vw.wg.vw(2);
        vw.vw(0, viewGroup);
        vw.vw(1, activity);
        this.vw.call(110109, vw.wg(), java.lang.Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public void showSplashClickEyeView(android.view.ViewGroup viewGroup) {
        com.bykv.vw.vw.vw.vw.wg vw = com.bykv.vw.vw.vw.vw.wg.vw(1);
        vw.vw(0, viewGroup);
        this.vw.call(110107, vw.wg(), java.lang.Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public void showSplashView(android.view.ViewGroup viewGroup) {
        com.bykv.vw.vw.vw.vw.wg vw = com.bykv.vw.vw.vw.vw.wg.vw(1);
        vw.vw(0, viewGroup);
        this.vw.call(110108, vw.wg(), java.lang.Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public void startClickEye() {
        this.vw.call(110104, com.bykv.vw.vw.vw.vw.wg.vw(0).wg(), java.lang.Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void win(java.lang.Double d) {
        com.bykv.vw.vw.vw.vw.wg vw = com.bykv.vw.vw.vw.vw.wg.vw(1);
        vw.vw(0, d);
        this.vw.call(210101, vw.wg(), java.lang.Void.class);
    }
}
