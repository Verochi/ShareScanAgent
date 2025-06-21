package com.alimm.tanx.core.ad.ad.template.rendering.feed;

/* loaded from: classes.dex */
public class FeedWebViewUtil extends com.alimm.tanx.core.ad.base.tanxc_if {
    protected com.alimm.tanx.core.ad.ITanxAd tanxc_do;
    protected com.alimm.tanx.core.ad.view.TanxAdView tanxc_if;
    private com.alimm.tanx.core.ad.ad.template.rendering.feed.FeedWebViewUtil.FeedWebInterface tanxc_try;
    protected long tanxc_for = 0;
    protected final long tanxc_int = 500;

    /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.feed.FeedWebViewUtil$1, reason: invalid class name */
    public class AnonymousClass1 implements com.alimm.tanx.core.bridge.JsBridgeUtil.AdInterface {
        public AnonymousClass1() {
        }

        @Override // com.alimm.tanx.core.bridge.JsBridgeUtil.AdInterface
        public void adClose() {
            com.alimm.tanx.core.utils.LogUtils.d("FeedWebViewUtil", "RewardVideo.notifyClose");
        }

        @Override // com.alimm.tanx.core.bridge.JsBridgeUtil.AdInterface
        public void adSkip(boolean z) {
            com.alimm.tanx.core.utils.LogUtils.d("FeedWebViewUtil", "RewardVideo.notifyAdSkip:" + z);
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.feed.FeedWebViewUtil$2, reason: invalid class name */
    public class AnonymousClass2 implements com.alimm.tanx.core.bridge.JsHandler {
        public AnonymousClass2() {
        }

        @Override // com.alimm.tanx.core.bridge.JsHandler
        public void handler(java.util.AbstractMap<java.lang.String, java.lang.Object> abstractMap, com.alimm.tanx.core.bridge.Callback callback) {
            try {
                com.alimm.tanx.core.utils.LogUtils.d("FeedWebViewUtil", "WebAd.notifyAdExpose");
                abstractMap.get("area");
                com.alimm.tanx.core.ad.ITanxAd iTanxAd = com.alimm.tanx.core.ad.ad.template.rendering.feed.FeedWebViewUtil.this.tanxc_do;
                if (iTanxAd != null) {
                    iTanxAd.onResourceLoadSuccess();
                }
                callback.call(true, null);
            } catch (java.lang.Exception e) {
                com.alimm.tanx.core.utils.LogUtils.e("FeedWebViewUtil", e);
            }
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.feed.FeedWebViewUtil$3, reason: invalid class name */
    public class AnonymousClass3 implements com.alimm.tanx.core.bridge.JsHandler {
        public AnonymousClass3() {
        }

        @Override // com.alimm.tanx.core.bridge.JsHandler
        public void handler(java.util.AbstractMap<java.lang.String, java.lang.Object> abstractMap, com.alimm.tanx.core.bridge.Callback callback) {
            try {
                com.alimm.tanx.core.utils.LogUtils.d("FeedWebViewUtil", "WebAd.notifyAdClick");
                long currentTimeMillis = java.lang.System.currentTimeMillis();
                com.alimm.tanx.core.ad.ad.template.rendering.feed.FeedWebViewUtil feedWebViewUtil = com.alimm.tanx.core.ad.ad.template.rendering.feed.FeedWebViewUtil.this;
                if (currentTimeMillis - feedWebViewUtil.tanxc_for < 500) {
                    com.alimm.tanx.core.utils.LogUtils.d("FeedWebViewUtil", "mClickedOnce = true");
                    return;
                }
                feedWebViewUtil.tanxc_for = java.lang.System.currentTimeMillis();
                abstractMap.get("area");
                abstractMap.get("clickThroughUrl");
                abstractMap.get("deepLinkUrl");
                com.alimm.tanx.core.ad.ad.template.rendering.feed.FeedWebViewUtil feedWebViewUtil2 = com.alimm.tanx.core.ad.ad.template.rendering.feed.FeedWebViewUtil.this;
                com.alimm.tanx.core.ad.ITanxAd iTanxAd = feedWebViewUtil2.tanxc_do;
                if (iTanxAd != null && (iTanxAd instanceof com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd)) {
                    ((com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd) iTanxAd).click(feedWebViewUtil2.tanxc_if);
                }
                callback.call(true, null);
            } catch (java.lang.Exception e) {
                com.alimm.tanx.core.utils.LogUtils.e("FeedWebViewUtil", e);
            }
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.feed.FeedWebViewUtil$4, reason: invalid class name */
    public class AnonymousClass4 implements com.alimm.tanx.core.bridge.JsHandler {
        public AnonymousClass4() {
        }

        @Override // com.alimm.tanx.core.bridge.JsHandler
        public void handler(java.util.AbstractMap<java.lang.String, java.lang.Object> abstractMap, com.alimm.tanx.core.bridge.Callback callback) {
            com.alimm.tanx.core.utils.LogUtils.d("FeedWebViewUtil", "WebAd.notifyError");
            java.lang.Integer num = (java.lang.Integer) abstractMap.get("cmd");
            com.alimm.tanx.core.ad.ad.template.rendering.feed.FeedWebViewUtil.this.tanxc_try.webError(num == null ? -1 : num.intValue(), (java.lang.String) abstractMap.get("msg"));
            callback.call(true, null);
        }
    }

    public interface FeedWebInterface extends com.alimm.tanx.core.bridge.JsBridgeUtil.BaseWebInterface {
    }

    @Override // com.alimm.tanx.core.ad.base.tanxc_if
    public void tanxc_do(android.webkit.WebView webView) {
        super.tanxc_do(webView);
        super.tanxc_do(false);
        this.tanxc_new.register("WebAd.notifyAdExpose", new com.alimm.tanx.core.ad.ad.template.rendering.feed.FeedWebViewUtil.AnonymousClass2());
        this.tanxc_new.register("WebAd.notifyAdClick", new com.alimm.tanx.core.ad.ad.template.rendering.feed.FeedWebViewUtil.AnonymousClass3());
        this.tanxc_new.register("WebAd.notifyError", new com.alimm.tanx.core.ad.ad.template.rendering.feed.FeedWebViewUtil.AnonymousClass4());
    }

    public void tanxc_do(android.widget.LinearLayout linearLayout, boolean z, com.alimm.tanx.core.ad.ITanxAd iTanxAd, com.alimm.tanx.core.ad.view.TanxAdView tanxAdView, com.alimm.tanx.core.ad.ad.template.rendering.feed.FeedWebViewUtil.FeedWebInterface feedWebInterface) {
        com.alimm.tanx.core.utils.LogUtils.d("FeedWebViewUtil", "init");
        if (iTanxAd == null) {
            return;
        }
        this.tanxc_if = tanxAdView;
        this.tanxc_do = iTanxAd;
        super.tanxc_do(linearLayout, z, iTanxAd.getBidInfo(), iTanxAd.getAdSlot(), feedWebInterface, new com.alimm.tanx.core.ad.ad.template.rendering.feed.FeedWebViewUtil.AnonymousClass1());
        this.tanxc_try = feedWebInterface;
    }

    @Override // com.alimm.tanx.core.ad.base.tanxc_if
    public boolean tanxc_do() {
        return false;
    }
}
