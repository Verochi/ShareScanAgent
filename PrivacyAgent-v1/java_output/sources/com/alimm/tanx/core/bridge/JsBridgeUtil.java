package com.alimm.tanx.core.bridge;

/* loaded from: classes.dex */
public class JsBridgeUtil implements com.alimm.tanx.core.utils.NotConfused {
    public static final java.lang.String TAG = "JsBridgeUtil";
    private com.alimm.tanx.core.bridge.JsBridgeUtil.AdInterface adInterface;
    private com.alimm.tanx.core.bridge.JsBridgeUtil.BaseWebInterface baseWebInterface;
    private com.alimm.tanx.core.bridge.JsBridgeBean jsBridgeBean;

    /* renamed from: com.alimm.tanx.core.bridge.JsBridgeUtil$1, reason: invalid class name */
    public class AnonymousClass1 implements com.alimm.tanx.core.bridge.JsHandler {
        final /* synthetic */ boolean tanxc_do;

        public AnonymousClass1(boolean z) {
            this.tanxc_do = z;
        }

        @Override // com.alimm.tanx.core.bridge.JsHandler
        public void handler(java.util.AbstractMap<java.lang.String, java.lang.Object> abstractMap, com.alimm.tanx.core.bridge.Callback callback) {
            com.alimm.tanx.core.utils.LogUtils.d(com.alimm.tanx.core.bridge.JsBridgeUtil.TAG, "WebAd.isShowWebBar");
            java.util.HashMap hashMap = new java.util.HashMap();
            hashMap.put("showWebBarSwitch", java.lang.Boolean.valueOf(this.tanxc_do));
            callback.call(true, hashMap);
        }
    }

    /* renamed from: com.alimm.tanx.core.bridge.JsBridgeUtil$10, reason: invalid class name */
    public class AnonymousClass10 implements com.alimm.tanx.core.bridge.JsHandler {
        public AnonymousClass10() {
        }

        @Override // com.alimm.tanx.core.bridge.JsHandler
        public void handler(java.util.AbstractMap<java.lang.String, java.lang.Object> abstractMap, com.alimm.tanx.core.bridge.Callback callback) {
            com.alimm.tanx.core.utils.LogUtils.d(com.alimm.tanx.core.bridge.JsBridgeUtil.TAG, "Reward.notifyError");
            java.lang.Integer num = (java.lang.Integer) abstractMap.get("cmd");
            com.alimm.tanx.core.bridge.JsBridgeUtil.this.baseWebInterface.webError(num == null ? -1 : num.intValue(), (java.lang.String) abstractMap.get("msg"));
            callback.call(true, null);
        }
    }

    /* renamed from: com.alimm.tanx.core.bridge.JsBridgeUtil$2, reason: invalid class name */
    public class AnonymousClass2 implements com.alimm.tanx.core.bridge.JsHandler {
        public AnonymousClass2() {
        }

        @Override // com.alimm.tanx.core.bridge.JsHandler
        public void handler(java.util.AbstractMap<java.lang.String, java.lang.Object> abstractMap, com.alimm.tanx.core.bridge.Callback callback) {
            try {
                com.alimm.tanx.core.utils.LogUtils.d(com.alimm.tanx.core.bridge.JsBridgeUtil.TAG, "RewardVideo.submitFeedback");
                java.lang.String str = (java.lang.String) abstractMap.get("interactType");
                java.lang.String str2 = (java.lang.String) abstractMap.get("interactDesc");
                if (com.alimm.tanx.core.bridge.JsBridgeUtil.this.jsBridgeBean != null) {
                    com.alimm.tanx.core.ad.event.track.interaction.InteractionUpload.getInstance().uploadInteraction(com.alimm.tanx.core.bridge.JsBridgeUtil.this.jsBridgeBean.getEventTrack(), str, str2);
                }
                callback.call(true, null);
            } catch (java.lang.Exception e) {
                com.alimm.tanx.core.utils.LogUtils.e(com.alimm.tanx.core.bridge.JsBridgeUtil.TAG, e);
            }
        }
    }

    /* renamed from: com.alimm.tanx.core.bridge.JsBridgeUtil$3, reason: invalid class name */
    public class AnonymousClass3 implements com.alimm.tanx.core.bridge.JsHandler {
        public AnonymousClass3() {
        }

        @Override // com.alimm.tanx.core.bridge.JsHandler
        public void handler(java.util.AbstractMap<java.lang.String, java.lang.Object> abstractMap, com.alimm.tanx.core.bridge.Callback callback) {
            com.alimm.tanx.core.utils.LogUtils.d(com.alimm.tanx.core.bridge.JsBridgeUtil.TAG, "Core.getSDKInfo");
            java.util.HashMap hashMap = new java.util.HashMap();
            hashMap.put("version", com.alimm.tanx.core.SdkConstant.getSdkVersion());
            callback.call(true, hashMap);
        }
    }

    /* renamed from: com.alimm.tanx.core.bridge.JsBridgeUtil$4, reason: invalid class name */
    public class AnonymousClass4 implements com.alimm.tanx.core.bridge.JsHandler {
        public AnonymousClass4() {
        }

        @Override // com.alimm.tanx.core.bridge.JsHandler
        public void handler(java.util.AbstractMap<java.lang.String, java.lang.Object> abstractMap, com.alimm.tanx.core.bridge.Callback callback) {
            com.alimm.tanx.core.utils.LogUtils.d(com.alimm.tanx.core.bridge.JsBridgeUtil.TAG, "WebAd.notifyWebDidMount");
            if (com.alimm.tanx.core.bridge.JsBridgeUtil.this.baseWebInterface != null) {
                com.alimm.tanx.core.utils.LogUtils.d(com.alimm.tanx.core.bridge.JsBridgeUtil.TAG, "baseWebInterface!=null");
                com.alimm.tanx.core.bridge.JsBridgeUtil.this.baseWebInterface.h5NotifyDrawSuccess();
            }
        }
    }

    /* renamed from: com.alimm.tanx.core.bridge.JsBridgeUtil$5, reason: invalid class name */
    public class AnonymousClass5 implements com.alimm.tanx.core.bridge.JsHandler {
        public AnonymousClass5() {
        }

        @Override // com.alimm.tanx.core.bridge.JsHandler
        public void handler(java.util.AbstractMap<java.lang.String, java.lang.Object> abstractMap, com.alimm.tanx.core.bridge.Callback callback) {
            com.alimm.tanx.core.bridge.JsBridgeUtil.this.track(abstractMap, callback);
        }
    }

    /* renamed from: com.alimm.tanx.core.bridge.JsBridgeUtil$6, reason: invalid class name */
    public class AnonymousClass6 implements com.alimm.tanx.core.bridge.JsHandler {
        public AnonymousClass6() {
        }

        @Override // com.alimm.tanx.core.bridge.JsHandler
        public void handler(java.util.AbstractMap<java.lang.String, java.lang.Object> abstractMap, com.alimm.tanx.core.bridge.Callback callback) {
            java.util.HashMap hashMap = new java.util.HashMap();
            com.alibaba.fastjson.JSONObject jSONObject = null;
            try {
                com.alimm.tanx.core.utils.LogUtils.d(com.alimm.tanx.core.bridge.JsBridgeUtil.TAG, "RewardVideo.getAd");
                e = null;
                jSONObject = (com.alimm.tanx.core.bridge.JsBridgeUtil.this.jsBridgeBean == null || android.text.TextUtils.isEmpty(com.alimm.tanx.core.bridge.JsBridgeUtil.this.jsBridgeBean.getRawJsonStr())) ? null : com.alibaba.fastjson.JSON.parseObject(com.alimm.tanx.core.bridge.JsBridgeUtil.this.jsBridgeBean.getRawJsonStr());
            } catch (java.lang.Exception e) {
                e = e;
                com.alimm.tanx.core.utils.LogUtils.e(com.alimm.tanx.core.bridge.JsBridgeUtil.TAG, e);
            }
            if (jSONObject != null) {
                hashMap.put(com.umeng.analytics.pro.bo.aC, jSONObject);
            } else {
                hashMap.put("code", -1);
                java.lang.String stackTraceMessage = com.alimm.tanx.core.utils.LogUtils.getStackTraceMessage(e);
                if (com.alimm.tanx.core.bridge.JsBridgeUtil.this.jsBridgeBean != null) {
                    stackTraceMessage = stackTraceMessage + "  \n jsBridgeBean:" + com.alimm.tanx.core.bridge.JsBridgeUtil.this.jsBridgeBean.getRawJsonStr();
                }
                hashMap.put("msg", stackTraceMessage);
            }
            callback.call(true, hashMap);
        }
    }

    /* renamed from: com.alimm.tanx.core.bridge.JsBridgeUtil$7, reason: invalid class name */
    public class AnonymousClass7 implements com.alimm.tanx.core.bridge.JsHandler {
        public AnonymousClass7() {
        }

        @Override // com.alimm.tanx.core.bridge.JsHandler
        public void handler(java.util.AbstractMap<java.lang.String, java.lang.Object> abstractMap, com.alimm.tanx.core.bridge.Callback callback) {
            com.alimm.tanx.core.utils.LogUtils.d(com.alimm.tanx.core.bridge.JsBridgeUtil.TAG, "Core.getNetType");
            java.util.HashMap hashMap = new java.util.HashMap();
            hashMap.put("netType", com.alimm.tanx.core.utils.NetWorkUtil.getNetworkType(com.alimm.tanx.core.TanxCoreSdk.getApplication()).getMsg());
            com.alimm.tanx.core.utils.LogUtils.d(com.alimm.tanx.core.bridge.JsBridgeUtil.TAG, com.alibaba.fastjson.JSON.toJSONString(hashMap));
            callback.call(true, hashMap);
        }
    }

    /* renamed from: com.alimm.tanx.core.bridge.JsBridgeUtil$8, reason: invalid class name */
    public class AnonymousClass8 implements com.alimm.tanx.core.bridge.JsHandler {
        public AnonymousClass8() {
        }

        @Override // com.alimm.tanx.core.bridge.JsHandler
        public void handler(java.util.AbstractMap<java.lang.String, java.lang.Object> abstractMap, com.alimm.tanx.core.bridge.Callback callback) {
            com.alimm.tanx.core.utils.LogUtils.d(com.alimm.tanx.core.bridge.JsBridgeUtil.TAG, "RewardVideo.notifyClose");
            if (com.alimm.tanx.core.bridge.JsBridgeUtil.this.adInterface != null) {
                com.alimm.tanx.core.bridge.JsBridgeUtil.this.adInterface.adClose();
            }
            com.alimm.tanx.core.bridge.JsBridgeUtil.this.baseWebInterface.adClose();
            callback.call(true, null);
        }
    }

    /* renamed from: com.alimm.tanx.core.bridge.JsBridgeUtil$9, reason: invalid class name */
    public class AnonymousClass9 implements com.alimm.tanx.core.bridge.JsHandler {
        public AnonymousClass9() {
        }

        @Override // com.alimm.tanx.core.bridge.JsHandler
        public void handler(java.util.AbstractMap<java.lang.String, java.lang.Object> abstractMap, com.alimm.tanx.core.bridge.Callback callback) {
            com.alimm.tanx.core.utils.LogUtils.d(com.alimm.tanx.core.bridge.JsBridgeUtil.TAG, "RewardVideo.notifyAdSkip");
            java.lang.Boolean bool = (java.lang.Boolean) abstractMap.get("needClose");
            if (bool == null) {
                bool = java.lang.Boolean.TRUE;
            }
            if (com.alimm.tanx.core.bridge.JsBridgeUtil.this.adInterface != null) {
                com.alimm.tanx.core.bridge.JsBridgeUtil.this.adInterface.adSkip(bool.booleanValue());
            }
            com.alimm.tanx.core.bridge.JsBridgeUtil.this.baseWebInterface.adSkip(bool.booleanValue());
            callback.call(true, null);
        }
    }

    public interface AdInterface {
        void adClose();

        void adSkip(boolean z);
    }

    public interface BaseWebInterface {
        void adClose();

        void adSkip(boolean z);

        void h5NotifyDrawSuccess();

        void webDrawStatus(boolean z);

        void webError(int i, java.lang.String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void track(java.util.AbstractMap<java.lang.String, java.lang.Object> abstractMap, com.alimm.tanx.core.bridge.Callback callback) {
        try {
            com.alimm.tanx.core.utils.LogUtils.d(TAG, "RewardVideo.track");
            com.alibaba.fastjson.JSONObject jSONObject = (com.alibaba.fastjson.JSONObject) abstractMap.get("event");
            com.alimm.tanx.core.ut.bean.UtItemH5Bean utItemH5Bean = (com.alimm.tanx.core.ut.bean.UtItemH5Bean) com.alibaba.fastjson.JSON.parseObject(jSONObject != null ? jSONObject.toJSONString() : "", com.alimm.tanx.core.ut.bean.UtItemH5Bean.class);
            java.lang.Boolean bool = (java.lang.Boolean) abstractMap.get("needTemplateId");
            java.lang.Boolean bool2 = (java.lang.Boolean) abstractMap.get("needCreativeId");
            java.lang.Boolean bool3 = (java.lang.Boolean) abstractMap.get("needOpenType");
            java.lang.Boolean bool4 = (java.lang.Boolean) abstractMap.get("needClickUrl");
            if (utItemH5Bean != null) {
                com.alimm.tanx.core.bridge.JsBridgeBean jsBridgeBean = this.jsBridgeBean;
                if (jsBridgeBean != null) {
                    utItemH5Bean.pid = jsBridgeBean.getPid();
                    utItemH5Bean.reqId = this.jsBridgeBean.getReqId();
                }
                if (android.text.TextUtils.isEmpty(utItemH5Bean.page)) {
                    utItemH5Bean.page = utItemH5Bean.arg1;
                }
                if (this.jsBridgeBean != null) {
                    if (utItemH5Bean.args == null) {
                        utItemH5Bean.args = new java.util.HashMap();
                    }
                    if (bool == null || bool.booleanValue()) {
                        utItemH5Bean.args.put(com.alimm.tanx.core.ad.event.track.expose.ExposeManager.UtArgsNames.templateId, this.jsBridgeBean.getTemplateId());
                    }
                    if (bool2 == null || bool2.booleanValue()) {
                        utItemH5Bean.args.put("creative_id", this.jsBridgeBean.getCreativeId());
                    }
                    if (bool3 != null && bool3.booleanValue()) {
                        utItemH5Bean.args.put("openType", java.lang.Integer.valueOf(this.jsBridgeBean.getOpenType()));
                    }
                    if (bool4 != null && bool4.booleanValue()) {
                        utItemH5Bean.args.put(com.qq.e.comm.constants.Constants.KEYS.EXPOSED_CLICK_URL_KEY, this.jsBridgeBean.getDeepLinkUrl());
                    }
                }
                com.alimm.tanx.core.ut.impl.TanxBaseUt.h5Ut(utItemH5Bean);
            } else {
                com.alimm.tanx.core.utils.LogUtils.e(TAG, "Core.track  接收到H5埋点对象为空");
            }
            callback.call(true, null);
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e(TAG, e);
        }
    }

    public void initJsBridge(com.alimm.tanx.core.bridge.TanxJsBridge tanxJsBridge, com.alimm.tanx.core.bridge.JsBridgeBean jsBridgeBean, com.alimm.tanx.core.bridge.JsBridgeUtil.BaseWebInterface baseWebInterface, com.alimm.tanx.core.bridge.JsBridgeUtil.AdInterface adInterface) {
        if (tanxJsBridge == null) {
            com.alimm.tanx.core.utils.LogUtils.d(TAG, "jsBridge注册失败，tanxJsBridge为空");
            return;
        }
        this.jsBridgeBean = jsBridgeBean;
        this.baseWebInterface = baseWebInterface;
        this.adInterface = adInterface;
        tanxJsBridge.register("Core.getSdkInfo", new com.alimm.tanx.core.bridge.JsBridgeUtil.AnonymousClass3());
        tanxJsBridge.register("WebAd.notifyWebDidMount", new com.alimm.tanx.core.bridge.JsBridgeUtil.AnonymousClass4());
        tanxJsBridge.register("WebAd.track", new com.alimm.tanx.core.bridge.JsBridgeUtil.AnonymousClass5());
        tanxJsBridge.register("WebAd.getAd", new com.alimm.tanx.core.bridge.JsBridgeUtil.AnonymousClass6());
        tanxJsBridge.register("Core.getNetType", new com.alimm.tanx.core.bridge.JsBridgeUtil.AnonymousClass7());
        tanxJsBridge.register("WebAd.notifyClose", new com.alimm.tanx.core.bridge.JsBridgeUtil.AnonymousClass8());
        tanxJsBridge.register("WebAd.notifyAdSkip", new com.alimm.tanx.core.bridge.JsBridgeUtil.AnonymousClass9());
        tanxJsBridge.register("WebAd.notifyError", new com.alimm.tanx.core.bridge.JsBridgeUtil.AnonymousClass10());
        tanxJsBridge.register("WebAd.submitFeedback", new com.alimm.tanx.core.bridge.JsBridgeUtil.AnonymousClass2());
    }

    public void setShowWebBar(com.alimm.tanx.core.bridge.TanxJsBridge tanxJsBridge, boolean z) {
        if (tanxJsBridge == null) {
            com.alimm.tanx.core.utils.LogUtils.d(TAG, "setShowWebBar过程jsBridge注册失败，tanxJsBridge为空");
        } else {
            tanxJsBridge.register("WebAd.isShowWebBar", new com.alimm.tanx.core.bridge.JsBridgeUtil.AnonymousClass1(z));
        }
    }
}
