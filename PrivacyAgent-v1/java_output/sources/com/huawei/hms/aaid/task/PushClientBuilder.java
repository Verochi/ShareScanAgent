package com.huawei.hms.aaid.task;

/* loaded from: classes22.dex */
public class PushClientBuilder extends com.huawei.hms.common.internal.AbstractClientBuilder<com.huawei.hms.aaid.task.PushClient, com.huawei.hms.api.Api.ApiOptions.NoOptions> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.huawei.hms.common.internal.AbstractClientBuilder
    public com.huawei.hms.aaid.task.PushClient buildClient(android.content.Context context, com.huawei.hms.common.internal.ClientSettings clientSettings, com.huawei.hms.common.internal.BaseHmsClient.OnConnectionFailedListener onConnectionFailedListener, com.huawei.hms.common.internal.BaseHmsClient.ConnectionCallbacks connectionCallbacks) {
        clientSettings.setApiName(java.util.Arrays.asList(com.huawei.hms.api.HuaweiApiAvailability.HMS_API_NAME_PUSH, "Core.API"));
        return new com.huawei.hms.aaid.task.PushClient(context, clientSettings, onConnectionFailedListener, connectionCallbacks);
    }
}
