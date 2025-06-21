package com.huawei.hms.opendevice;

/* loaded from: classes22.dex */
public class k extends com.huawei.hms.common.internal.TaskApiCall<com.huawei.hms.aaid.task.PushClient, java.lang.Void> {
    public com.huawei.hms.aaid.entity.DeleteTokenReq a;

    public k(java.lang.String str, com.huawei.hms.aaid.entity.DeleteTokenReq deleteTokenReq, java.lang.String str2) {
        super(str, com.huawei.hms.utils.JsonUtil.createJsonString(deleteTokenReq), str2);
        this.a = deleteTokenReq;
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void doExecute(com.huawei.hms.aaid.task.PushClient pushClient, com.huawei.hms.common.internal.ResponseErrorCode responseErrorCode, java.lang.String str, com.huawei.hmf.tasks.TaskCompletionSource<java.lang.Void> taskCompletionSource) {
        if (responseErrorCode.getErrorCode() == 0) {
            com.huawei.hms.aaid.constant.ErrorEnum fromCode = com.huawei.hms.aaid.constant.ErrorEnum.fromCode(((com.huawei.hms.aaid.entity.DeleteTokenResp) com.huawei.hms.utils.JsonUtil.jsonToEntity(str, new com.huawei.hms.aaid.entity.DeleteTokenResp())).getRetCode());
            if (fromCode != com.huawei.hms.aaid.constant.ErrorEnum.SUCCESS) {
                taskCompletionSource.setException(fromCode.toApiException());
                return;
            } else {
                taskCompletionSource.setResult(null);
                com.huawei.hms.opendevice.q.a(pushClient.getContext(), getUri(), responseErrorCode);
                return;
            }
        }
        com.huawei.hms.support.log.HMSLog.e(com.huawei.hms.aaid.HmsInstanceId.TAG, "DeleteTokenTask failed, ErrorCode: " + responseErrorCode.getErrorCode());
        com.huawei.hms.aaid.constant.ErrorEnum fromCode2 = com.huawei.hms.aaid.constant.ErrorEnum.fromCode(responseErrorCode.getErrorCode());
        if (fromCode2 != com.huawei.hms.aaid.constant.ErrorEnum.ERROR_UNKNOWN) {
            taskCompletionSource.setException(fromCode2.toApiException());
        } else {
            taskCompletionSource.setException(new com.huawei.hms.common.ApiException(new com.huawei.hms.support.api.client.Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
        }
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getMinApkVersion() {
        return this.a.isMultiSender() ? 50004300 : 30000000;
    }
}
