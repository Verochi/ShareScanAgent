package com.huawei.hms.opendevice;

/* loaded from: classes22.dex */
public class OpenDeviceTaskApiCall extends com.huawei.hms.common.internal.TaskApiCall<com.huawei.hms.opendevice.OpenDeviceHmsClient, com.huawei.hms.support.api.opendevice.OdidResult> {
    public OpenDeviceTaskApiCall(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        super(str, str2, str3);
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public void doExecute(com.huawei.hms.opendevice.OpenDeviceHmsClient openDeviceHmsClient, com.huawei.hms.common.internal.ResponseErrorCode responseErrorCode, java.lang.String str, com.huawei.hmf.tasks.TaskCompletionSource<com.huawei.hms.support.api.opendevice.OdidResult> taskCompletionSource) {
        if (responseErrorCode == null) {
            taskCompletionSource.setException(new com.huawei.hms.common.ApiException(new com.huawei.hms.support.api.client.Status(1)));
            return;
        }
        com.huawei.hms.support.hianalytics.HiAnalyticsClient.reportExit(openDeviceHmsClient.getContext(), getUri(), getTransactionId(), responseErrorCode.getStatusCode(), responseErrorCode.getErrorCode(), 60300305);
        if (responseErrorCode.getErrorCode() != 0) {
            com.huawei.hms.support.log.HMSLog.i("OpenDeviceTaskApiCall", "onResult, returnCode: " + responseErrorCode.getErrorCode());
            taskCompletionSource.setException(new com.huawei.hms.common.ApiException(new com.huawei.hms.support.api.client.Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
            return;
        }
        com.huawei.hms.support.log.HMSLog.i("OpenDeviceTaskApiCall", "onResult, success");
        com.huawei.hms.support.api.entity.opendevice.OdidResp odidResp = new com.huawei.hms.support.api.entity.opendevice.OdidResp();
        com.huawei.hms.utils.JsonUtil.jsonToEntity(str, odidResp);
        com.huawei.hms.support.api.opendevice.OdidResult odidResult = new com.huawei.hms.support.api.opendevice.OdidResult();
        odidResult.setId(odidResp.getId());
        odidResult.setStatus(new com.huawei.hms.support.api.client.Status(0));
        taskCompletionSource.setResult(odidResult);
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getApiLevel() {
        return 2;
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getMinApkVersion() {
        return 50002300;
    }
}
