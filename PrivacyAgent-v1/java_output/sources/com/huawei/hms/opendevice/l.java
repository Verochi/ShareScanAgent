package com.huawei.hms.opendevice;

/* loaded from: classes22.dex */
public class l extends com.huawei.hms.common.internal.TaskApiCall<com.huawei.hms.aaid.task.PushClient, com.huawei.hms.aaid.entity.TokenResult> {
    public android.content.Context a;
    public com.huawei.hms.aaid.entity.TokenReq b;

    public l(java.lang.String str, com.huawei.hms.aaid.entity.TokenReq tokenReq, android.content.Context context, java.lang.String str2) {
        super(str, com.huawei.hms.utils.JsonUtil.createJsonString(tokenReq), str2);
        this.a = context;
        this.b = tokenReq;
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void doExecute(com.huawei.hms.aaid.task.PushClient pushClient, com.huawei.hms.common.internal.ResponseErrorCode responseErrorCode, java.lang.String str, com.huawei.hmf.tasks.TaskCompletionSource<com.huawei.hms.aaid.entity.TokenResult> taskCompletionSource) {
        if (responseErrorCode.getErrorCode() != 0) {
            com.huawei.hms.support.log.HMSLog.e(com.huawei.hms.aaid.HmsInstanceId.TAG, "TokenTask failed, ErrorCode:" + responseErrorCode.getErrorCode());
            a(responseErrorCode, taskCompletionSource);
        } else {
            com.huawei.hms.aaid.entity.TokenResp tokenResp = (com.huawei.hms.aaid.entity.TokenResp) com.huawei.hms.utils.JsonUtil.jsonToEntity(str, new com.huawei.hms.aaid.entity.TokenResp());
            com.huawei.hms.aaid.constant.ErrorEnum fromCode = com.huawei.hms.aaid.constant.ErrorEnum.fromCode(tokenResp.getRetCode());
            if (fromCode != com.huawei.hms.aaid.constant.ErrorEnum.SUCCESS) {
                taskCompletionSource.setException(fromCode.toApiException());
                com.huawei.hms.support.log.HMSLog.e(com.huawei.hms.aaid.HmsInstanceId.TAG, "TokenTask failed, StatusCode:" + fromCode.getExternalCode());
            } else {
                com.huawei.hms.aaid.entity.TokenResult tokenResult = new com.huawei.hms.aaid.entity.TokenResult();
                tokenResult.setToken(tokenResp.getToken());
                tokenResult.setBelongId(tokenResp.getBelongId());
                tokenResult.setRetCode(com.huawei.hms.aaid.constant.ErrorEnum.fromCode(tokenResp.getRetCode()).getExternalCode());
                taskCompletionSource.setResult(tokenResult);
                java.lang.String token = tokenResp.getToken();
                if (android.text.TextUtils.isEmpty(token)) {
                    com.huawei.hms.support.log.HMSLog.i(com.huawei.hms.aaid.HmsInstanceId.TAG, "GetTokenTask receive a empty token, please check HmsMessageService.onNewToken receive result.");
                    com.huawei.hms.opendevice.q.a(pushClient.getContext(), getUri(), responseErrorCode);
                    return;
                } else {
                    a(token, this.b.getSubjectId());
                    com.huawei.hms.opendevice.n.a(this.a, token);
                }
            }
        }
        com.huawei.hms.opendevice.q.a(pushClient.getContext(), getUri(), responseErrorCode);
    }

    public final void a(com.huawei.hms.common.internal.ResponseErrorCode responseErrorCode, com.huawei.hmf.tasks.TaskCompletionSource<com.huawei.hms.aaid.entity.TokenResult> taskCompletionSource) {
        com.huawei.hms.aaid.constant.ErrorEnum fromCode = com.huawei.hms.aaid.constant.ErrorEnum.fromCode(responseErrorCode.getErrorCode());
        if (fromCode != com.huawei.hms.aaid.constant.ErrorEnum.ERROR_UNKNOWN) {
            taskCompletionSource.setException(fromCode.toApiException());
        } else {
            taskCompletionSource.setException(new com.huawei.hms.common.ApiException(new com.huawei.hms.support.api.client.Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
        }
    }

    public final void a(java.lang.String str, java.lang.String str2) {
        if (com.huawei.hms.opendevice.i.a(this.a).b(str2).equals(str)) {
            return;
        }
        com.huawei.hms.support.log.HMSLog.i(com.huawei.hms.aaid.HmsInstanceId.TAG, "receive a token, refresh the local token");
        com.huawei.hms.opendevice.i.a(this.a).b(str2, str);
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getMinApkVersion() {
        return this.b.isMultiSender() ? 50004300 : 30000000;
    }
}
