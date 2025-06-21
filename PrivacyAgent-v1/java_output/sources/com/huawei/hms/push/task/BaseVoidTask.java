package com.huawei.hms.push.task;

/* loaded from: classes22.dex */
public class BaseVoidTask extends com.huawei.hms.common.internal.TaskApiCall<com.huawei.hms.aaid.task.PushClient, java.lang.Void> {
    public BaseVoidTask(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        super(str, str2, str3);
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public void doExecute(com.huawei.hms.aaid.task.PushClient pushClient, com.huawei.hms.common.internal.ResponseErrorCode responseErrorCode, java.lang.String str, com.huawei.hmf.tasks.TaskCompletionSource<java.lang.Void> taskCompletionSource) {
        if (responseErrorCode.getErrorCode() == 0) {
            com.huawei.hms.support.log.HMSLog.i("BaseVoidTask", "Operate succeed");
            taskCompletionSource.setResult(null);
        } else {
            com.huawei.hms.support.log.HMSLog.e("BaseVoidTask", "Operate failed with ret=" + responseErrorCode.getErrorCode());
            com.huawei.hms.aaid.constant.ErrorEnum fromCode = com.huawei.hms.aaid.constant.ErrorEnum.fromCode(responseErrorCode.getErrorCode());
            if (fromCode != com.huawei.hms.aaid.constant.ErrorEnum.ERROR_UNKNOWN) {
                taskCompletionSource.setException(fromCode.toApiException());
            } else {
                taskCompletionSource.setException(new com.huawei.hms.common.ApiException(new com.huawei.hms.support.api.client.Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
            }
        }
        com.huawei.hms.push.utils.PushBiUtil.reportExit(pushClient.getContext(), getUri(), responseErrorCode);
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getMinApkVersion() {
        return 30000000;
    }
}
