package com.huawei.hms.opendevice;

/* loaded from: classes22.dex */
public class OpenDevice {
    public static com.huawei.hms.opendevice.OpenDeviceClient getOpenDeviceClient(android.content.Context context) {
        com.huawei.hms.utils.Checker.assertNonNull(context);
        return new com.huawei.hms.opendevice.OpenDeviceClientImpl(context);
    }
}
