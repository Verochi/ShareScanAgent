package com.anythink.network.baidu;

/* loaded from: classes12.dex */
public class BaiduATConst {
    public static final int NETWORK_FIRM_ID = 22;
    public static final java.lang.String STYLE_BUILDER = "baidu_style_builder";

    public static class DEBUGGER_CONFIG {
        public static final int BAIDU_INTERSTITIAL_FULL_SCREEN = 2;
        public static final int BAIDU_INTERSTITIAL_TEMPLATE = 3;
        public static final int BAIDU_NATIVE_SELF_RENDER = 1;
        public static final int BAIDU_NATIVE_TEMPLATE = 2;
        public static final int BAIDU_NETWORK = 22;
    }

    public static java.lang.String getNetworkVersion() {
        try {
            return com.baidu.mobads.sdk.api.AdSettings.getSDKVersion();
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }
}
