package com.qq.e.comm.managers.status;

/* loaded from: classes19.dex */
public class SDKStatus {
    public static final int SDK_CHANNEL = 101;
    public static final java.lang.String SDK_EX1 = "";
    public static final java.lang.String SDK_EX2 = "";
    public static final int STUB_IDENTITY = 1;
    public static final boolean isNoPlugin = false;

    public static final int getBuildInPluginVersion() {
        return 1480;
    }

    public static final java.lang.String getIntegrationSDKVersion() {
        return "4.610." + getBuildInPluginVersion();
    }

    public static final int getPluginVersion() {
        if (com.qq.e.comm.managers.a.b().d()) {
            return com.qq.e.comm.managers.a.b().c().getPluginVersion();
        }
        return 0;
    }

    public static final java.lang.String getSDKVersion() {
        return "4.610";
    }
}
