package com.alimm.tanx.core.ad.ad.template.rendering.reward;

/* loaded from: classes.dex */
public class RewardWebViewUtil extends com.alimm.tanx.core.ad.base.tanxc_if {
    private com.alimm.tanx.core.ad.ad.template.rendering.reward.tanxc_new tanxc_do;
    private com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.RewardInterface tanxc_if;
    private java.lang.String tanxc_for = "";
    private java.lang.String tanxc_int = "";
    private long tanxc_try = -1;

    /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil$1, reason: invalid class name */
    public class AnonymousClass1 implements com.alimm.tanx.core.bridge.JsBridgeUtil.AdInterface {
        public AnonymousClass1() {
        }

        @Override // com.alimm.tanx.core.bridge.JsBridgeUtil.AdInterface
        public void adClose() {
            com.alimm.tanx.core.utils.LogUtils.d("RewardWebViewUtil", "RewardVideo.notifyClose");
            com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.this.tanxc_if(1);
        }

        @Override // com.alimm.tanx.core.bridge.JsBridgeUtil.AdInterface
        public void adSkip(boolean z) {
            com.alimm.tanx.core.utils.LogUtils.d("RewardWebViewUtil", "RewardVideo.notifyAdSkip:" + z);
            com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.this.tanxc_if(1);
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil$2, reason: invalid class name */
    public class AnonymousClass2 implements com.alimm.tanx.core.bridge.JsHandler {
        public AnonymousClass2() {
        }

        @Override // com.alimm.tanx.core.bridge.JsHandler
        public void handler(java.util.AbstractMap<java.lang.String, java.lang.Object> abstractMap, com.alimm.tanx.core.bridge.Callback callback) {
            com.alimm.tanx.core.utils.LogUtils.d("RewardWebViewUtil", "WebAd.getPlayerInfo  - currentTime:" + com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.this.tanxc_if.getCurrentTime() + "  totalTime:" + com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.this.tanxc_if.getTotalTime() + "  playState:" + com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.this.tanxc_if.getPlayState());
            java.util.HashMap hashMap = new java.util.HashMap();
            hashMap.put("currentTime", java.lang.Long.valueOf(com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.this.tanxc_if.getCurrentTime()));
            hashMap.put("totalTime", java.lang.Long.valueOf(com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.this.tanxc_if.getTotalTime()));
            hashMap.put("audioState", com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.this.tanxc_do.tanxc_do.mute ? "muted" : "vocal");
            hashMap.put("playState", com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.this.tanxc_if.getPlayState());
            com.alimm.tanx.core.utils.LogUtils.d("RewardWebViewUtil", com.alibaba.fastjson.JSON.toJSONString(hashMap));
            callback.call(true, hashMap);
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil$3, reason: invalid class name */
    public class AnonymousClass3 implements com.alimm.tanx.core.bridge.JsHandler {
        public AnonymousClass3() {
        }

        @Override // com.alimm.tanx.core.bridge.JsHandler
        public void handler(java.util.AbstractMap<java.lang.String, java.lang.Object> abstractMap, com.alimm.tanx.core.bridge.Callback callback) {
            try {
                com.alimm.tanx.core.utils.LogUtils.d("RewardWebViewUtil", "WebAd.notifyAdExpose");
                abstractMap.get("area");
                if (com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.this.tanxc_do != null && com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.this.tanxc_do.tanxc_if != null) {
                    com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.this.tanxc_do.tanxc_if.onResourceLoadSuccess();
                }
                callback.call(true, null);
            } catch (java.lang.Exception e) {
                com.alimm.tanx.core.utils.LogUtils.e("RewardWebViewUtil", e);
            }
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil$4, reason: invalid class name */
    public class AnonymousClass4 implements com.alimm.tanx.core.bridge.JsHandler {
        public AnonymousClass4() {
        }

        @Override // com.alimm.tanx.core.bridge.JsHandler
        public void handler(java.util.AbstractMap<java.lang.String, java.lang.Object> abstractMap, com.alimm.tanx.core.bridge.Callback callback) {
            try {
                com.alimm.tanx.core.utils.LogUtils.d("RewardWebViewUtil", "WebAd.notifyAdClick");
                com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.this.tanxc_if(0);
                com.alimm.tanx.core.utils.LogUtils.d("RewardWebViewUtil", "WebAd.notifyAdClick");
                abstractMap.get("area");
                java.lang.String str = (java.lang.String) abstractMap.get("clickThroughUrl");
                java.lang.String str2 = (java.lang.String) abstractMap.get("deepLinkUrl");
                if (com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.this.tanxc_do != null && com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.this.tanxc_do.tanxc_if != null) {
                    com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.this.tanxc_do.tanxc_if.click(str, str2);
                    if (com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.this.tanxc_do.tanxc_for() != null) {
                        com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.this.tanxc_do.tanxc_for().onAdClicked(null, com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.this.tanxc_do.tanxc_if);
                    }
                }
                callback.call(true, null);
            } catch (java.lang.Exception e) {
                com.alimm.tanx.core.utils.LogUtils.e("RewardWebViewUtil", e);
            }
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil$5, reason: invalid class name */
    public class AnonymousClass5 implements com.alimm.tanx.core.bridge.JsHandler {
        public AnonymousClass5() {
        }

        @Override // com.alimm.tanx.core.bridge.JsHandler
        public void handler(java.util.AbstractMap<java.lang.String, java.lang.Object> abstractMap, com.alimm.tanx.core.bridge.Callback callback) {
            try {
                com.alimm.tanx.core.utils.LogUtils.d("RewardWebViewUtil", "WebAd.setPlayer");
                com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.this.tanxc_if.setPlayer((java.lang.Boolean) abstractMap.get("muted"), (java.lang.Boolean) abstractMap.get("pausing"));
                callback.call(true, null);
            } catch (java.lang.Exception e) {
                com.alimm.tanx.core.utils.LogUtils.e("RewardWebViewUtil", e);
            }
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil$6, reason: invalid class name */
    public class AnonymousClass6 implements com.alimm.tanx.core.bridge.JsHandler {
        public AnonymousClass6() {
        }

        @Override // com.alimm.tanx.core.bridge.JsHandler
        public void handler(java.util.AbstractMap<java.lang.String, java.lang.Object> abstractMap, com.alimm.tanx.core.bridge.Callback callback) {
            com.alimm.tanx.core.utils.LogUtils.d("RewardWebViewUtil", "WebAd.notifyCountDown");
            java.lang.Integer num = (java.lang.Integer) abstractMap.get("totalTime");
            java.lang.Integer num2 = (java.lang.Integer) abstractMap.get("currentTime");
            if (num == null) {
                num = 0;
            }
            if (num2 == null) {
                num2 = 0;
            }
            com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.this.tanxc_if.webNotifyCountDown(num.intValue(), num2.intValue());
            callback.call(true, null);
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil$7, reason: invalid class name */
    public class AnonymousClass7 implements com.alimm.tanx.core.bridge.JsHandler {
        public AnonymousClass7() {
        }

        @Override // com.alimm.tanx.core.bridge.JsHandler
        public void handler(java.util.AbstractMap<java.lang.String, java.lang.Object> abstractMap, com.alimm.tanx.core.bridge.Callback callback) {
            com.alimm.tanx.core.utils.LogUtils.d("RewardWebViewUtil", "WebAd.notifyError");
            java.lang.Integer num = (java.lang.Integer) abstractMap.get("cmd");
            com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.this.tanxc_if.webError(num == null ? -1 : num.intValue(), (java.lang.String) abstractMap.get("msg"));
            callback.call(true, null);
        }
    }

    public interface RewardInterface extends com.alimm.tanx.core.bridge.JsBridgeUtil.BaseWebInterface {
        long getCurrentTime();

        java.lang.String getPlayState();

        long getTotalTime();

        void onScroll(int i, int i2);

        void setPlayer(java.lang.Boolean bool, java.lang.Boolean bool2);

        void webNotifyCountDown(int i, int i2);
    }

    public void tanxc_do(int i) {
        com.alimm.tanx.core.utils.LogUtils.d("RewardWebViewUtil", "audioStateChange - volume：" + i);
        java.util.HashMap hashMap = new java.util.HashMap();
        java.lang.String str = i <= 0 ? "muted" : "vocal";
        if (this.tanxc_for.equals(str)) {
            return;
        }
        hashMap.put("new", str);
        hashMap.put("old", this.tanxc_for);
        this.tanxc_new.postEvent("WebAd.audioStateChange", hashMap);
        this.tanxc_for = str;
    }

    @Override // com.alimm.tanx.core.ad.base.tanxc_if
    public void tanxc_do(android.webkit.WebView webView) {
        super.tanxc_do(webView);
        super.tanxc_do(true);
        this.tanxc_new.register("WebAd.getPlayerInfo", new com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.AnonymousClass2());
        this.tanxc_new.register("WebAd.notifyAdExpose", new com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.AnonymousClass3());
        this.tanxc_new.register("WebAd.notifyAdClick", new com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.AnonymousClass4());
        this.tanxc_new.register("WebAd.setPlayer", new com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.AnonymousClass5());
        this.tanxc_new.register("WebAd.notifyCountDown", new com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.AnonymousClass6());
        this.tanxc_new.register("WebAd.notifyError", new com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.AnonymousClass7());
    }

    public void tanxc_do(android.widget.LinearLayout linearLayout, com.alimm.tanx.core.ad.bean.BidInfo bidInfo, com.alimm.tanx.core.request.TanxAdSlot tanxAdSlot, com.alimm.tanx.core.ad.ad.template.rendering.reward.tanxc_new tanxc_newVar, com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.RewardInterface rewardInterface) {
        com.alimm.tanx.core.utils.LogUtils.d("RewardWebViewUtil", "init");
        super.tanxc_do(linearLayout, true, bidInfo, tanxAdSlot, rewardInterface, new com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.AnonymousClass1());
        this.tanxc_do = tanxc_newVar;
        this.tanxc_if = rewardInterface;
    }

    public void tanxc_do(java.lang.String str) {
        com.alimm.tanx.core.utils.LogUtils.d("RewardWebViewUtil", "playStateChange - nowPlayStateStr：" + str);
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        java.util.HashMap hashMap = new java.util.HashMap();
        if (this.tanxc_int.equals(str)) {
            return;
        }
        hashMap.put("new", str);
        hashMap.put("old", this.tanxc_int);
        this.tanxc_new.postEvent("WebAd.playStateChange", hashMap);
        this.tanxc_int = str;
        if (str == null || !str.equals("end")) {
            return;
        }
        this.tanxc_try = java.lang.System.currentTimeMillis();
    }

    @Override // com.alimm.tanx.core.ad.base.tanxc_if
    public boolean tanxc_do() {
        return true;
    }

    public void tanxc_if(int i) {
        if (this.tanxc_try <= 0) {
            return;
        }
        com.alimm.tanx.core.utils.LogUtils.d("utLog", "utPlayEndClickTime");
        com.alimm.tanx.core.ut.impl.TanxRewardUt.utPlayEndClickTime(this.tanxc_do, java.lang.System.currentTimeMillis() - this.tanxc_try, i);
        this.tanxc_try = -1L;
    }
}
