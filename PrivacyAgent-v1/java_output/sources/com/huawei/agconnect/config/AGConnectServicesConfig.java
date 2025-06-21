package com.huawei.agconnect.config;

@java.lang.Deprecated
/* loaded from: classes22.dex */
public abstract class AGConnectServicesConfig implements com.huawei.agconnect.AGConnectOptions {
    public static final java.util.Map<java.lang.String, com.huawei.agconnect.config.AGConnectServicesConfig> a = new java.util.HashMap();
    public static final java.lang.Object b = new java.lang.Object();

    public static com.huawei.agconnect.config.AGConnectServicesConfig fromContext(android.content.Context context) {
        android.content.Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        return fromContext(context, context.getPackageName());
    }

    public static com.huawei.agconnect.config.AGConnectServicesConfig fromContext(android.content.Context context, java.lang.String str) {
        com.huawei.agconnect.config.AGConnectServicesConfig aGConnectServicesConfig;
        synchronized (b) {
            java.util.Map<java.lang.String, com.huawei.agconnect.config.AGConnectServicesConfig> map = a;
            aGConnectServicesConfig = map.get(str);
            if (aGConnectServicesConfig == null) {
                aGConnectServicesConfig = new com.huawei.agconnect.config.impl.c(context, str);
                map.put(str, aGConnectServicesConfig);
            }
        }
        return aGConnectServicesConfig;
    }

    public abstract void overlayWith(com.huawei.agconnect.config.LazyInputStream lazyInputStream);

    public abstract void overlayWith(java.io.InputStream inputStream);

    public abstract void setParam(java.lang.String str, java.lang.String str2);

    public abstract void setRoutePolicy(com.huawei.agconnect.AGCRoutePolicy aGCRoutePolicy);
}
