package com.anythink.network.toutiao;

/* loaded from: classes12.dex */
public class TTATConst {
    public static final java.lang.String AD_LOAD_TYPE = "tt_ad_load_type";
    public static final java.lang.String NATIVE_AD_IMAGE_HEIGHT = "tt_image_height";
    public static final java.lang.String NATIVE_AD_INTERRUPT_VIDEOPLAY = "tt_can_interrupt_video";
    public static final java.lang.String NATIVE_AD_VIDEOPLAY_BTN_BITMAP = "tt_video_play_btn_bitmap";
    public static final java.lang.String NATIVE_AD_VIDEOPLAY_BTN_SIZE = "tt_video_play_btn_SIZE";
    public static final int NETWORK_FIRM_ID = 15;
    static java.lang.String a;
    public static boolean hasRequestPermission;

    public static class DEBUGGER_CONFIG {
        public static final int TT_INTERSTITIAL = 3;
        public static final int TT_NATIVE_DRAW_SELF_RENDER = 202;
        public static final int TT_NATIVE_DRAW_TEMPLATE = 201;
        public static final int TT_NATIVE_SELF_RENDER = 102;
        public static final int TT_NATIVE_TEMPLATE = 101;
        public static final int TT_NETWORK = 15;
    }

    public static java.lang.String getNetworkVersion() {
        java.lang.String str = a;
        if (str != null) {
            return str;
        }
        try {
            java.lang.String sDKVersion = com.bytedance.sdk.openadsdk.TTAdSdk.getAdManager().getSDKVersion();
            a = sDKVersion;
            return sDKVersion;
        } catch (java.lang.Throwable unused) {
            a = "";
            return "";
        }
    }
}
