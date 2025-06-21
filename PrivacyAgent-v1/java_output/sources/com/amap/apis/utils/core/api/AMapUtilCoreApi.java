package com.amap.apis.utils.core.api;

/* loaded from: classes12.dex */
public class AMapUtilCoreApi {
    public static com.amap.apis.utils.core.api.NetProxy a = null;
    public static boolean b = true;

    public static boolean getCollectIPEnable() {
        return b;
    }

    public static com.amap.apis.utils.core.api.NetProxy getNetProxy() {
        return a;
    }

    public static void setCollectIPEnable(boolean z) {
        b = z;
    }

    public static void setCollectInfoEnable(boolean z) {
        com.loc.p.a(z);
    }

    public static void setNetProxy(com.amap.apis.utils.core.api.NetProxy netProxy) {
        a = netProxy;
    }
}
