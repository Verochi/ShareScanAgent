package com.huawei.agconnect;

/* loaded from: classes22.dex */
public abstract class AGConnectInstance {
    public static com.huawei.agconnect.AGConnectInstance buildInstance(com.huawei.agconnect.AGConnectOptions aGConnectOptions) {
        return com.huawei.agconnect.core.a.b.a(aGConnectOptions);
    }

    public static com.huawei.agconnect.AGConnectInstance getInstance() {
        return com.huawei.agconnect.core.a.b.a();
    }

    public static com.huawei.agconnect.AGConnectInstance getInstance(java.lang.String str) {
        return com.huawei.agconnect.core.a.b.a(str);
    }

    public static synchronized void initialize(android.content.Context context) {
        synchronized (com.huawei.agconnect.AGConnectInstance.class) {
            com.huawei.agconnect.core.a.b.a(context);
        }
    }

    public static synchronized void initialize(android.content.Context context, com.huawei.agconnect.AGConnectOptionsBuilder aGConnectOptionsBuilder) {
        synchronized (com.huawei.agconnect.AGConnectInstance.class) {
            com.huawei.agconnect.core.a.b.a(context, aGConnectOptionsBuilder);
        }
    }

    public abstract android.content.Context getContext();

    public abstract java.lang.String getIdentifier();

    public abstract com.huawei.agconnect.AGConnectOptions getOptions();

    public abstract <T> T getService(java.lang.Class<? super T> cls);
}
