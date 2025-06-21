package com.huawei.hms.api;

/* loaded from: classes22.dex */
public class HuaweiServicesRepairableException extends com.huawei.hms.api.UserRecoverableException {
    private final int statusCode;

    public HuaweiServicesRepairableException(int i, java.lang.String str, android.content.Intent intent) {
        super(str, intent);
        this.statusCode = i;
    }

    public int getConnectionStatusCode() {
        return this.statusCode;
    }
}
