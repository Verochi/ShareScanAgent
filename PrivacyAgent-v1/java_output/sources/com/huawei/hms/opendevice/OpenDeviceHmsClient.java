package com.huawei.hms.opendevice;

/* loaded from: classes22.dex */
public class OpenDeviceHmsClient extends com.huawei.hms.common.internal.HmsClient {
    public OpenDeviceHmsClient(android.content.Context context, com.huawei.hms.common.internal.ClientSettings clientSettings, com.huawei.hms.common.internal.BaseHmsClient.OnConnectionFailedListener onConnectionFailedListener, com.huawei.hms.common.internal.BaseHmsClient.ConnectionCallbacks connectionCallbacks) {
        super(context, clientSettings, onConnectionFailedListener, connectionCallbacks);
    }

    @Override // com.huawei.hms.common.internal.BaseHmsClient
    public int getMinApkVersion() {
        return 30000000;
    }
}
