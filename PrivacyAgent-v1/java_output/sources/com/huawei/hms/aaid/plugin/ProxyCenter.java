package com.huawei.hms.aaid.plugin;

/* loaded from: classes22.dex */
public class ProxyCenter {
    public com.huawei.hms.aaid.plugin.PushProxy proxy;

    public static class a {
        public static com.huawei.hms.aaid.plugin.ProxyCenter a = new com.huawei.hms.aaid.plugin.ProxyCenter();
    }

    public static com.huawei.hms.aaid.plugin.ProxyCenter getInstance() {
        return com.huawei.hms.aaid.plugin.ProxyCenter.a.a;
    }

    public static com.huawei.hms.aaid.plugin.PushProxy getProxy() {
        return getInstance().proxy;
    }

    public static void register(com.huawei.hms.aaid.plugin.PushProxy pushProxy) {
        getInstance().proxy = pushProxy;
    }
}
