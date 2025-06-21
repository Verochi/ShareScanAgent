package com.huawei.hms.common.api;

/* loaded from: classes22.dex */
public class AvailabilityException extends java.lang.Exception {
    private java.lang.String TAG = "AvailabilityException";
    private java.lang.String message = null;

    private com.huawei.hms.api.ConnectionResult generateConnectionResult(int i) {
        com.huawei.hms.support.log.HMSLog.i(this.TAG, "The availability check result is: " + i);
        setMessage(i);
        return new com.huawei.hms.api.ConnectionResult(i);
    }

    private void setMessage(int i) {
        if (i == 21) {
            this.message = "ANDROID_VERSION_UNSUPPORT";
            return;
        }
        if (i == 0) {
            this.message = "success";
            return;
        }
        if (i == 1) {
            this.message = "SERVICE_MISSING";
            return;
        }
        if (i == 2) {
            this.message = "SERVICE_VERSION_UPDATE_REQUIRED";
        } else if (i != 3) {
            this.message = "INTERNAL_ERROR";
        } else {
            this.message = "SERVICE_DISABLED";
        }
    }

    public com.huawei.hms.api.ConnectionResult getConnectionResult(com.huawei.hms.common.HuaweiApi<? extends com.huawei.hms.api.Api.ApiOptions> huaweiApi) {
        if (huaweiApi == null) {
            com.huawei.hms.support.log.HMSLog.e(this.TAG, "The huaweiApi is null.");
            return generateConnectionResult(8);
        }
        return generateConnectionResult(com.huawei.hms.api.HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(huaweiApi.getContext(), 30000000));
    }

    public com.huawei.hms.api.ConnectionResult getConnectionResult(com.huawei.hms.common.api.HuaweiApiCallable huaweiApiCallable) {
        if (huaweiApiCallable == null || huaweiApiCallable.getHuaweiApi() == null) {
            com.huawei.hms.support.log.HMSLog.e(this.TAG, "The huaweiApi is null.");
            return generateConnectionResult(8);
        }
        return generateConnectionResult(com.huawei.hms.api.HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(huaweiApiCallable.getHuaweiApi().getContext(), 30000000));
    }

    @Override // java.lang.Throwable
    public java.lang.String getMessage() {
        return this.message;
    }
}
