package com.bytedance.sdk.openadsdk;

/* loaded from: classes31.dex */
public final class TTAdSdk {
    public static final java.lang.String BRANCH = "v6200";
    public static final java.lang.String BUILT_IN_PLUGIN_NAME = "com.byted.pangle";
    public static final java.lang.String C_H = "18ffad7";
    public static final int EXT_API_VERSION_CODE = 999;
    public static final boolean INCLUDE_LIVE = true;
    public static final java.lang.String INITIALIZER_CLASS_NAME = "com.bytedance.sdk.openadsdk.core.AdSdkInitializerHolder";
    public static final boolean IS_BOOST = false;
    public static final boolean IS_P = true;
    public static final java.lang.String LIVE_PLUGIN_PACKAGE_NAME = "com.byted.live.lite";
    public static final boolean ONLY_API = false;
    public static final int SDK_VERSION_CODE = 6219;
    public static final java.lang.String SDK_VERSION_NAME = "6.2.1.9";
    public static final java.lang.String S_C = "main";
    private static final com.bytedance.sdk.openadsdk.api.vw vw = new com.bytedance.sdk.openadsdk.api.plugin.kz();
    private static volatile com.bytedance.sdk.openadsdk.TTAdConfig wg;

    /* renamed from: com.bytedance.sdk.openadsdk.TTAdSdk$1, reason: invalid class name */
    /* loaded from: classes22.dex */
    public static class AnonymousClass1 implements com.bytedance.sdk.openadsdk.CodeGroupRitObject {
        final /* synthetic */ long vw;
        final /* synthetic */ com.bytedance.sdk.openadsdk.TTCodeGroupRit.TTCodeGroupRitListener wg;

        public AnonymousClass1(long j, com.bytedance.sdk.openadsdk.TTCodeGroupRit.TTCodeGroupRitListener tTCodeGroupRitListener) {
            this.vw = j;
            this.wg = tTCodeGroupRitListener;
        }

        @Override // com.bytedance.sdk.openadsdk.CodeGroupRitObject
        public long getCodeGroupId() {
            return this.vw;
        }

        @Override // com.bytedance.sdk.openadsdk.CodeGroupRitObject
        public com.bytedance.sdk.openadsdk.TTCodeGroupRit.TTCodeGroupRitListener getListener() {
            return this.wg;
        }
    }

    /* loaded from: classes22.dex */
    public interface Callback extends com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback {
    }

    @java.lang.Deprecated
    /* loaded from: classes22.dex */
    public interface InitCallback {
        void fail(int i, java.lang.String str);

        void success();
    }

    public static com.bytedance.sdk.openadsdk.TTAdManager getAdManager() {
        com.bytedance.sdk.openadsdk.api.vw vwVar = vw;
        if (vwVar != null) {
            return vwVar.wg();
        }
        return null;
    }

    public static void getCodeGroupRit(long j, com.bytedance.sdk.openadsdk.TTCodeGroupRit.TTCodeGroupRitListener tTCodeGroupRitListener) {
        com.bytedance.sdk.openadsdk.api.vw vwVar = vw;
        if (vwVar != null) {
            vwVar.wg().register(new com.bytedance.sdk.openadsdk.TTAdSdk.AnonymousClass1(j, tTCodeGroupRitListener));
        } else if (tTCodeGroupRitListener != null) {
            tTCodeGroupRitListener.onFail(4100, "please init sdk first!");
        }
    }

    public static boolean init(android.content.Context context, com.bytedance.sdk.openadsdk.TTAdConfig tTAdConfig) {
        wg = tTAdConfig;
        vw(context, wg);
        return true;
    }

    @java.lang.Deprecated
    public static boolean isInitSuccess() {
        com.bytedance.sdk.openadsdk.api.vw vwVar = vw;
        if (vwVar != null) {
            return vwVar.vw();
        }
        return false;
    }

    public static boolean isOnePointFiveAdType(com.bytedance.sdk.openadsdk.TTNativeExpressAd tTNativeExpressAd) {
        java.util.Map<java.lang.String, java.lang.Object> mediaExtraInfo;
        if (tTNativeExpressAd == null) {
            mediaExtraInfo = null;
        } else {
            try {
                mediaExtraInfo = tTNativeExpressAd.getMediaExtraInfo();
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        if (mediaExtraInfo == null || !mediaExtraInfo.containsKey("_tt_ad_type_onepointfive")) {
            return false;
        }
        return ((java.lang.Boolean) mediaExtraInfo.get("_tt_ad_type_onepointfive")).booleanValue();
    }

    public static boolean isSdkReady() {
        com.bytedance.sdk.openadsdk.api.vw vwVar = vw;
        if (vwVar != null) {
            return vwVar.vw();
        }
        return false;
    }

    public static void start(com.bytedance.sdk.openadsdk.TTAdSdk.Callback callback) {
        vw(wg, "TTAdConfig is null, please exec TTAdSdk.init before TTAdSdk.start.");
        com.bytedance.sdk.openadsdk.api.vw vwVar = vw;
        if (vwVar == null) {
            callback.fail(4100, "Load initializer failed");
        } else {
            vwVar.vw(com.bytedance.sdk.openadsdk.TTAppContextHolder.getContext(), wg, callback);
        }
    }

    public static void updateAdConfig(com.bytedance.sdk.openadsdk.TTAdConfig tTAdConfig) {
        com.bytedance.sdk.openadsdk.api.vw.t wg2;
        if (tTAdConfig == null || (wg2 = vw.wg()) == null) {
            return;
        }
        android.os.Bundle bundle = new android.os.Bundle();
        if (!android.text.TextUtils.isEmpty(tTAdConfig.getData())) {
            bundle.putString("extra_data", tTAdConfig.getData());
        }
        if (!android.text.TextUtils.isEmpty(tTAdConfig.getKeywords())) {
            bundle.putString("keywords", tTAdConfig.getKeywords());
        }
        if (bundle.keySet().isEmpty()) {
            return;
        }
        wg2.getExtra(com.bykv.vk.openvk.api.proto.ValueSet.class, bundle);
    }

    public static void updateConfigAuth(com.bytedance.sdk.openadsdk.TTAdConfig tTAdConfig) {
        java.lang.Object obj;
        if (tTAdConfig == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.live.wg.vw().vw(tTAdConfig.getInjectionAuth());
        java.util.Map<java.lang.String, java.lang.Object> initExtra = tTAdConfig.getInitExtra();
        if (initExtra == null || (obj = initExtra.get(com.bytedance.sdk.openadsdk.TTAdConstant.KEY_INIT_FOR_LIVE)) == null || !(obj instanceof java.util.Map)) {
            return;
        }
        com.bytedance.sdk.openadsdk.live.wg.vw().vw((java.util.Map<java.lang.String, java.lang.String>) obj);
    }

    public static void updatePaid(boolean z) {
        com.bytedance.sdk.openadsdk.api.vw.t wg2 = vw.wg();
        if (wg2 == null) {
            return;
        }
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putBoolean("is_paid", z);
        if (bundle.keySet().isEmpty()) {
            return;
        }
        wg2.getExtra(com.bykv.vk.openvk.api.proto.ValueSet.class, bundle);
    }

    private static void vw(android.content.Context context, com.bytedance.sdk.openadsdk.TTAdConfig tTAdConfig) {
        if (tTAdConfig != null && tTAdConfig.isDebug()) {
            com.bytedance.sdk.openadsdk.api.t.vw();
        }
        if (android.os.Looper.getMainLooper() != android.os.Looper.myLooper()) {
            com.bytedance.sdk.openadsdk.api.t.vw("Wrong Thread ! Please exec TTAdSdk.init in main thread.");
        }
        vw(context, "Context is null, please check.");
        vw(tTAdConfig, "TTAdConfig is null, please check.");
        com.bytedance.sdk.openadsdk.TTAppContextHolder.setContext(context);
        updateConfigAuth(tTAdConfig);
    }

    private static void vw(java.lang.Object obj, java.lang.String str) {
        if (obj == null) {
            throw new java.lang.IllegalArgumentException(str);
        }
    }
}
