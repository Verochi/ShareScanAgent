package com.alimm.tanx.core.ad.ad.splash;

/* loaded from: classes.dex */
public class SplashWebViewUtil extends com.alimm.tanx.core.ad.base.tanxc_if {
    protected com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashExpressAd tanxc_do;
    protected com.alimm.tanx.core.ad.ad.template.rendering.splash.TanxSplashAdView tanxc_if;
    private com.alimm.tanx.core.ad.ad.splash.SplashWebViewUtil.SplashWebInterface tanxc_try;
    protected long tanxc_for = 0;
    protected final long tanxc_int = 500;

    /* renamed from: com.alimm.tanx.core.ad.ad.splash.SplashWebViewUtil$1, reason: invalid class name */
    public class AnonymousClass1 implements com.alimm.tanx.core.bridge.JsBridgeUtil.AdInterface {
        public AnonymousClass1() {
        }

        @Override // com.alimm.tanx.core.bridge.JsBridgeUtil.AdInterface
        public void adClose() {
            com.alimm.tanx.core.utils.LogUtils.d("SplashWebViewUtil", "RewardVideo.notifyClose");
        }

        @Override // com.alimm.tanx.core.bridge.JsBridgeUtil.AdInterface
        public void adSkip(boolean z) {
            com.alimm.tanx.core.utils.LogUtils.d("SplashWebViewUtil", "RewardVideo.notifyAdSkip:" + z);
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.splash.SplashWebViewUtil$2, reason: invalid class name */
    public class AnonymousClass2 implements com.alimm.tanx.core.bridge.JsHandler {
        public AnonymousClass2() {
        }

        @Override // com.alimm.tanx.core.bridge.JsHandler
        public void handler(java.util.AbstractMap<java.lang.String, java.lang.Object> abstractMap, com.alimm.tanx.core.bridge.Callback callback) {
            try {
                com.alimm.tanx.core.utils.LogUtils.d("SplashWebViewUtil", "WebAd.notifyAdExpose");
                abstractMap.get("area");
                com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashExpressAd iTanxSplashExpressAd = com.alimm.tanx.core.ad.ad.splash.SplashWebViewUtil.this.tanxc_do;
                if (iTanxSplashExpressAd != null) {
                    iTanxSplashExpressAd.onResourceLoadSuccess();
                }
                callback.call(true, null);
            } catch (java.lang.Exception e) {
                com.alimm.tanx.core.utils.LogUtils.e("SplashWebViewUtil", e);
            }
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.splash.SplashWebViewUtil$3, reason: invalid class name */
    public class AnonymousClass3 implements com.alimm.tanx.core.bridge.JsHandler {
        public AnonymousClass3() {
        }

        @Override // com.alimm.tanx.core.bridge.JsHandler
        public void handler(java.util.AbstractMap<java.lang.String, java.lang.Object> abstractMap, com.alimm.tanx.core.bridge.Callback callback) {
            try {
                com.alimm.tanx.core.utils.LogUtils.d("SplashWebViewUtil", "WebAd.notifyAdClick");
                long currentTimeMillis = java.lang.System.currentTimeMillis();
                com.alimm.tanx.core.ad.ad.splash.SplashWebViewUtil splashWebViewUtil = com.alimm.tanx.core.ad.ad.splash.SplashWebViewUtil.this;
                if (currentTimeMillis - splashWebViewUtil.tanxc_for < 500) {
                    com.alimm.tanx.core.utils.LogUtils.d("SplashWebViewUtil", "mClickedOnce = true");
                    return;
                }
                splashWebViewUtil.tanxc_for = java.lang.System.currentTimeMillis();
                abstractMap.get("area");
                java.lang.String str = (java.lang.String) abstractMap.get("clickThroughUrl");
                java.lang.String str2 = (java.lang.String) abstractMap.get("deepLinkUrl");
                com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashExpressAd iTanxSplashExpressAd = com.alimm.tanx.core.ad.ad.splash.SplashWebViewUtil.this.tanxc_do;
                if (iTanxSplashExpressAd != null && (iTanxSplashExpressAd instanceof com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_new)) {
                    ((com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_new) iTanxSplashExpressAd).tanxc_do(str, str2, false);
                    if (com.alimm.tanx.core.ad.ad.splash.SplashWebViewUtil.this.tanxc_do.getOnSplashAdListener() != null) {
                        com.alimm.tanx.core.ad.ad.splash.SplashWebViewUtil.this.tanxc_do.getOnSplashAdListener().onAdClicked();
                    }
                }
                callback.call(true, null);
            } catch (java.lang.Exception e) {
                com.alimm.tanx.core.utils.LogUtils.e("SplashWebViewUtil", e);
            }
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.splash.SplashWebViewUtil$4, reason: invalid class name */
    public class AnonymousClass4 implements com.alimm.tanx.core.bridge.JsHandler {
        public AnonymousClass4() {
        }

        @Override // com.alimm.tanx.core.bridge.JsHandler
        public void handler(java.util.AbstractMap<java.lang.String, java.lang.Object> abstractMap, com.alimm.tanx.core.bridge.Callback callback) {
            com.alimm.tanx.core.utils.LogUtils.d("SplashWebViewUtil", "WebAd.notifyError");
            java.lang.Integer num = (java.lang.Integer) abstractMap.get("cmd");
            com.alimm.tanx.core.ad.ad.splash.SplashWebViewUtil.this.tanxc_try.webError(num == null ? -1 : num.intValue(), (java.lang.String) abstractMap.get("msg"));
            callback.call(true, null);
        }
    }

    public interface SplashWebInterface extends com.alimm.tanx.core.bridge.JsBridgeUtil.BaseWebInterface {
    }

    @Override // com.alimm.tanx.core.ad.base.tanxc_if
    public void tanxc_do(android.webkit.WebView webView) {
        super.tanxc_do(webView);
        super.tanxc_do(false);
        this.tanxc_new.register("WebAd.notifyAdExpose", new com.alimm.tanx.core.ad.ad.splash.SplashWebViewUtil.AnonymousClass2());
        this.tanxc_new.register("WebAd.notifyAdClick", new com.alimm.tanx.core.ad.ad.splash.SplashWebViewUtil.AnonymousClass3());
        this.tanxc_new.register("WebAd.notifyError", new com.alimm.tanx.core.ad.ad.splash.SplashWebViewUtil.AnonymousClass4());
    }

    public void tanxc_do(android.widget.LinearLayout linearLayout, com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashExpressAd iTanxSplashExpressAd, com.alimm.tanx.core.ad.ad.template.rendering.splash.TanxSplashAdView tanxSplashAdView, com.alimm.tanx.core.ad.ad.splash.SplashWebViewUtil.SplashWebInterface splashWebInterface) {
        com.alimm.tanx.core.utils.LogUtils.d("SplashWebViewUtil", "init");
        if (iTanxSplashExpressAd == null) {
            return;
        }
        this.tanxc_if = tanxSplashAdView;
        this.tanxc_do = iTanxSplashExpressAd;
        super.tanxc_do(linearLayout, true, iTanxSplashExpressAd.getBidInfo(), iTanxSplashExpressAd.getAdSlot(), splashWebInterface, new com.alimm.tanx.core.ad.ad.splash.SplashWebViewUtil.AnonymousClass1());
        this.tanxc_try = splashWebInterface;
    }

    @Override // com.alimm.tanx.core.ad.base.tanxc_if
    public boolean tanxc_do() {
        return true;
    }
}
