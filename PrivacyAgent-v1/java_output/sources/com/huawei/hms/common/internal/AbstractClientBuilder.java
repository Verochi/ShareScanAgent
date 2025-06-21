package com.huawei.hms.common.internal;

/* loaded from: classes22.dex */
public abstract class AbstractClientBuilder<TClient extends com.huawei.hms.common.internal.AnyClient, TOption> {
    public abstract TClient buildClient(android.content.Context context, com.huawei.hms.common.internal.ClientSettings clientSettings, com.huawei.hms.common.internal.BaseHmsClient.OnConnectionFailedListener onConnectionFailedListener, com.huawei.hms.common.internal.BaseHmsClient.ConnectionCallbacks connectionCallbacks);
}
