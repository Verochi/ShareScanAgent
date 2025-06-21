package com.huawei.agconnect.core;

/* loaded from: classes22.dex */
public interface ServiceRegistrar {
    java.util.List<com.huawei.agconnect.core.Service> getServices(android.content.Context context);

    void initialize(android.content.Context context);
}
