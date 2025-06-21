package com.huawei.hms.opendevice;

/* loaded from: classes22.dex */
public class OpenDeviceClientImpl extends com.huawei.hms.common.HuaweiApi<com.huawei.hms.opendevice.OpenDeviceOptions> implements com.huawei.hms.opendevice.OpenDeviceClient {
    public static final com.huawei.hms.opendevice.OpenDeviceHmsClientBuilder a = new com.huawei.hms.opendevice.OpenDeviceHmsClientBuilder();
    public static final com.huawei.hms.api.Api<com.huawei.hms.opendevice.OpenDeviceOptions> b = new com.huawei.hms.api.Api<>(com.huawei.hms.api.HuaweiApiAvailability.HMS_API_NAME_OD);
    public static com.huawei.hms.opendevice.OpenDeviceOptions c = new com.huawei.hms.opendevice.OpenDeviceOptions();

    public OpenDeviceClientImpl(android.content.Context context) {
        super(context, b, c, a);
        super.setKitSdkVersion(60300305);
    }

    @Override // com.huawei.hms.opendevice.OpenDeviceClient
    public com.huawei.hmf.tasks.Task<com.huawei.hms.support.api.opendevice.OdidResult> getOdid() {
        return doWrite(new com.huawei.hms.opendevice.OpenDeviceTaskApiCall(com.huawei.hms.support.api.entity.opendevice.HuaweiOpendeviceNaming.getOdid, com.huawei.hms.utils.JsonUtil.createJsonString(null), com.huawei.hms.support.hianalytics.HiAnalyticsClient.reportEntry(getContext(), com.huawei.hms.support.api.entity.opendevice.HuaweiOpendeviceNaming.getOdid, 60300305)));
    }
}
