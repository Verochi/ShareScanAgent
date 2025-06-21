package com.hihonor.push.sdk.tasks.task;

/* loaded from: classes22.dex */
public class VoidTask extends com.hihonor.push.sdk.tasks.task.TaskApiCall<java.lang.Void> {
    public VoidTask(android.content.Context context, java.lang.String str, com.hihonor.push.framework.aidl.IMessageEntity iMessageEntity) {
        super(context, str, iMessageEntity);
    }

    @Override // com.hihonor.push.sdk.tasks.task.TaskApiCall
    public void doExecute(android.content.Context context, com.hihonor.push.sdk.common.data.ApiException apiException, java.lang.Object obj) {
        if (apiException == null) {
            apiException = com.hihonor.push.sdk.common.data.ErrorEnum.ERROR_UNKNOWN.toApiException();
        } else if (apiException.errorCode == com.hihonor.push.sdk.common.data.ErrorEnum.SUCCESS.statusCode) {
            this.mTaskCompletionSource.setResult(null);
            return;
        }
        this.mTaskCompletionSource.setException(apiException);
    }
}
