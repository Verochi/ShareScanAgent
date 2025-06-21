package com.alimm.tanx.core.ad.ad.template.rendering.table.screen;

/* loaded from: classes.dex */
public class TableScreenWebViewUtil extends com.alimm.tanx.core.ad.base.tanxc_if {
    private com.alimm.tanx.core.ad.ad.template.rendering.table.screen.tanxc_if tanxc_for;
    private com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenWebViewUtil.TableScreenInterface tanxc_int;
    protected long tanxc_do = 0;
    protected final long tanxc_if = 500;

    /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenWebViewUtil$1, reason: invalid class name */
    public class AnonymousClass1 implements com.alimm.tanx.core.bridge.JsBridgeUtil.AdInterface {
        public AnonymousClass1() {
        }

        @Override // com.alimm.tanx.core.bridge.JsBridgeUtil.AdInterface
        public void adClose() {
            com.alimm.tanx.core.utils.LogUtils.d("TableScreenWebViewUtil", "RewardVideo.notifyClose");
        }

        @Override // com.alimm.tanx.core.bridge.JsBridgeUtil.AdInterface
        public void adSkip(boolean z) {
            com.alimm.tanx.core.utils.LogUtils.d("TableScreenWebViewUtil", "RewardVideo.notifyAdSkip:" + z);
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenWebViewUtil$2, reason: invalid class name */
    public class AnonymousClass2 implements com.alimm.tanx.core.bridge.JsHandler {
        public AnonymousClass2() {
        }

        @Override // com.alimm.tanx.core.bridge.JsHandler
        public void handler(java.util.AbstractMap<java.lang.String, java.lang.Object> abstractMap, com.alimm.tanx.core.bridge.Callback callback) {
            try {
                com.alimm.tanx.core.utils.LogUtils.d("TableScreenWebViewUtil", "WebAd.notifyAdExpose");
                abstractMap.get("area");
                if (com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenWebViewUtil.this.tanxc_for != null && com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenWebViewUtil.this.tanxc_for.tanxc_do != null) {
                    com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenWebViewUtil.this.tanxc_for.tanxc_do.onResourceLoadSuccess();
                }
                callback.call(true, null);
            } catch (java.lang.Exception e) {
                com.alimm.tanx.core.utils.LogUtils.e("TableScreenWebViewUtil", e);
            }
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenWebViewUtil$3, reason: invalid class name */
    public class AnonymousClass3 implements com.alimm.tanx.core.bridge.JsHandler {
        public AnonymousClass3() {
        }

        @Override // com.alimm.tanx.core.bridge.JsHandler
        public void handler(java.util.AbstractMap<java.lang.String, java.lang.Object> abstractMap, com.alimm.tanx.core.bridge.Callback callback) {
            try {
                com.alimm.tanx.core.utils.LogUtils.d("TableScreenWebViewUtil", "WebAd.notifyAdClick");
                long currentTimeMillis = java.lang.System.currentTimeMillis();
                com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenWebViewUtil tableScreenWebViewUtil = com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenWebViewUtil.this;
                if (currentTimeMillis - tableScreenWebViewUtil.tanxc_do < 500) {
                    com.alimm.tanx.core.utils.LogUtils.d("TableScreenWebViewUtil", "mClickedOnce = true");
                    return;
                }
                tableScreenWebViewUtil.tanxc_do = java.lang.System.currentTimeMillis();
                abstractMap.get("area");
                java.lang.String str = (java.lang.String) abstractMap.get("clickThroughUrl");
                java.lang.String str2 = (java.lang.String) abstractMap.get("deepLinkUrl");
                if (com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenWebViewUtil.this.tanxc_for != null && com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenWebViewUtil.this.tanxc_for.tanxc_do != null) {
                    com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenWebViewUtil.this.tanxc_for.tanxc_do.click(str, str2);
                    if (com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenWebViewUtil.this.tanxc_for.tanxc_for() != null) {
                        com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenWebViewUtil.this.tanxc_for.tanxc_for().onAdClicked(null, com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenWebViewUtil.this.tanxc_for.tanxc_do);
                    }
                }
                callback.call(true, null);
            } catch (java.lang.Exception e) {
                com.alimm.tanx.core.utils.LogUtils.e("TableScreenWebViewUtil", e);
            }
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenWebViewUtil$4, reason: invalid class name */
    public class AnonymousClass4 implements com.alimm.tanx.core.bridge.JsHandler {
        public AnonymousClass4() {
        }

        @Override // com.alimm.tanx.core.bridge.JsHandler
        public void handler(java.util.AbstractMap<java.lang.String, java.lang.Object> abstractMap, com.alimm.tanx.core.bridge.Callback callback) {
            com.alimm.tanx.core.utils.LogUtils.d("TableScreenWebViewUtil", "WebAd.notifyError");
            java.lang.Integer num = (java.lang.Integer) abstractMap.get("cmd");
            com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenWebViewUtil.this.tanxc_int.webError(num == null ? -1 : num.intValue(), (java.lang.String) abstractMap.get("msg"));
            callback.call(true, null);
        }
    }

    public interface TableScreenInterface extends com.alimm.tanx.core.bridge.JsBridgeUtil.BaseWebInterface {
    }

    @Override // com.alimm.tanx.core.ad.base.tanxc_if
    public void tanxc_do(android.webkit.WebView webView) {
        super.tanxc_do(webView);
        super.tanxc_do(true);
        this.tanxc_new.register("WebAd.notifyAdExpose", new com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenWebViewUtil.AnonymousClass2());
        this.tanxc_new.register("WebAd.notifyAdClick", new com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenWebViewUtil.AnonymousClass3());
        this.tanxc_new.register("WebAd.notifyError", new com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenWebViewUtil.AnonymousClass4());
    }

    public void tanxc_do(android.widget.LinearLayout linearLayout, com.alimm.tanx.core.ad.bean.BidInfo bidInfo, com.alimm.tanx.core.request.TanxAdSlot tanxAdSlot, com.alimm.tanx.core.ad.ad.template.rendering.table.screen.tanxc_if tanxc_ifVar, com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenWebViewUtil.TableScreenInterface tableScreenInterface) {
        com.alimm.tanx.core.utils.LogUtils.d("TableScreenWebViewUtil", "init");
        super.tanxc_do(linearLayout, true, bidInfo, tanxAdSlot, tableScreenInterface, new com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenWebViewUtil.AnonymousClass1());
        this.tanxc_for = tanxc_ifVar;
        this.tanxc_int = tableScreenInterface;
    }

    @Override // com.alimm.tanx.core.ad.base.tanxc_if
    public boolean tanxc_do() {
        return true;
    }
}
