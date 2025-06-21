package com.huawei.hms.push.task;

/* loaded from: classes22.dex */
public class SendUpStreamTask extends com.huawei.hms.common.internal.TaskApiCall<com.huawei.hms.aaid.task.PushClient, com.huawei.hms.push.task.BaseVoidTask> {
    public java.lang.String a;
    public java.lang.String b;

    public SendUpStreamTask(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5) {
        super(str, str2, str3);
        this.a = str4;
        this.b = str5;
    }

    public final void a(com.huawei.hms.aaid.task.PushClient pushClient, com.huawei.hms.common.internal.ResponseErrorCode responseErrorCode) {
        com.huawei.hms.support.log.HMSLog.i("SendUpStreamTask", "receive upstream, msgId :" + this.b + " , packageName = " + this.a + " , errorCode = " + responseErrorCode.getErrorCode());
        android.content.Intent intent = new android.content.Intent("com.huawei.push.action.MESSAGING_EVENT");
        intent.setPackage(this.a);
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putString("message_id", this.b);
        bundle.putInt("error", responseErrorCode.getErrorCode());
        if (com.huawei.hms.aaid.constant.ErrorEnum.SUCCESS.getInternalCode() == responseErrorCode.getErrorCode()) {
            bundle.putString("message_type", "sent_message");
        } else {
            bundle.putString("message_type", "send_error");
        }
        if (new com.huawei.hms.push.h().a(pushClient.getContext(), bundle, intent)) {
            com.huawei.hms.support.log.HMSLog.i("SendUpStreamTask", "receive upstream, start service success");
            com.huawei.hms.push.utils.PushBiUtil.reportExit(pushClient.getContext(), getUri(), responseErrorCode);
        } else {
            com.huawei.hms.support.log.HMSLog.w("SendUpStreamTask", "receive upstream, start service failed");
            com.huawei.hms.push.utils.PushBiUtil.reportExit(pushClient.getContext(), getUri(), responseErrorCode.getTransactionId(), com.huawei.hms.aaid.constant.ErrorEnum.ERROR_BIND_SERVICE_SELF_MAPPING);
        }
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public void doExecute(com.huawei.hms.aaid.task.PushClient pushClient, com.huawei.hms.common.internal.ResponseErrorCode responseErrorCode, java.lang.String str, com.huawei.hmf.tasks.TaskCompletionSource<com.huawei.hms.push.task.BaseVoidTask> taskCompletionSource) {
        if (responseErrorCode.getErrorCode() == 0) {
            com.huawei.hms.support.log.HMSLog.i("SendUpStreamTask", "send up stream task,Operate succeed");
            taskCompletionSource.setResult(null);
        } else {
            com.huawei.hms.support.log.HMSLog.e("SendUpStreamTask", "send up stream task,Operate failed with ret=" + responseErrorCode.getErrorCode());
            com.huawei.hms.aaid.constant.ErrorEnum fromCode = com.huawei.hms.aaid.constant.ErrorEnum.fromCode(responseErrorCode.getErrorCode());
            if (fromCode != com.huawei.hms.aaid.constant.ErrorEnum.ERROR_UNKNOWN) {
                taskCompletionSource.setException(fromCode.toApiException());
            } else {
                taskCompletionSource.setException(new com.huawei.hms.common.ApiException(new com.huawei.hms.support.api.client.Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
            }
        }
        a(pushClient, responseErrorCode);
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getMinApkVersion() {
        return 40003000;
    }
}
