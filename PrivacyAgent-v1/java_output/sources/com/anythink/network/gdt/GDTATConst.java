package com.anythink.network.gdt;

/* loaded from: classes12.dex */
public class GDTATConst {
    public static final java.lang.String AD_HEIGHT = "gdtad_height";
    public static final int NETWORK_FIRM_ID = 8;
    protected static final java.lang.String a = "299";

    public static class DEBUGGER_CONFIG {
        public static final int GDT_INTERSTITIAL = 1;
        public static final int GDT_INTERSTITIAL_FULL_SCREEN = 2;
        public static final int GDT_NATIVE_DRAW_SELF_RENDER = 4;
        public static final int GDT_NATIVE_DRAW_TEMPLATE = 3;
        public static final int GDT_NATIVE_SELF_RENDER = 2;
        public static final int GDT_NATIVE_TEMPLATE = 1;
        public static final int GDT_NETWORK = 8;
    }

    public static java.lang.String getNetworkVersion() {
        try {
            return com.qq.e.comm.managers.status.SDKStatus.getIntegrationSDKVersion();
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }
}
