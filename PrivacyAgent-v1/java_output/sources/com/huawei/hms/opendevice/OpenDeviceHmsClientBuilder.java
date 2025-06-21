package com.huawei.hms.opendevice;

/* loaded from: classes22.dex */
public class OpenDeviceHmsClientBuilder extends com.huawei.hms.common.internal.AbstractClientBuilder<com.huawei.hms.opendevice.OpenDeviceHmsClient, com.huawei.hms.opendevice.OpenDeviceOptions> {
    @Override // com.huawei.hms.common.internal.AbstractClientBuilder
    public com.huawei.hms.opendevice.OpenDeviceHmsClient buildClient(android.content.Context context, com.huawei.hms.common.internal.ClientSettings clientSettings, com.huawei.hms.common.internal.BaseHmsClient.OnConnectionFailedListener onConnectionFailedListener, com.huawei.hms.common.internal.BaseHmsClient.ConnectionCallbacks connectionCallbacks) {
        return new com.huawei.hms.opendevice.OpenDeviceHmsClient(context, clientSettings, onConnectionFailedListener, connectionCallbacks);
    }
}
