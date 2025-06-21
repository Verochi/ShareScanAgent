package com.hihonor.push.sdk.tasks.task;

/* loaded from: classes22.dex */
public class GetPushTokenTask extends com.hihonor.push.sdk.tasks.task.TaskApiCall<com.hihonor.push.framework.aidl.entity.PushTokenResult> {
    public GetPushTokenTask(android.content.Context context, java.lang.String str, com.hihonor.push.framework.aidl.IMessageEntity iMessageEntity) {
        super(context, str, iMessageEntity);
    }

    @Override // com.hihonor.push.sdk.tasks.task.TaskApiCall
    public void doExecute(android.content.Context context, com.hihonor.push.sdk.common.data.ApiException apiException, java.lang.Object obj) {
        if (apiException == null) {
            apiException = com.hihonor.push.sdk.common.data.ErrorEnum.ERROR_UNKNOWN.toApiException();
        } else if (apiException.errorCode == com.hihonor.push.sdk.common.data.ErrorEnum.SUCCESS.statusCode && (obj instanceof com.hihonor.push.framework.aidl.entity.PushTokenResult)) {
            com.hihonor.push.framework.aidl.entity.PushTokenResult pushTokenResult = (com.hihonor.push.framework.aidl.entity.PushTokenResult) obj;
            java.lang.String pushToken = pushTokenResult.getPushToken();
            if (!android.text.TextUtils.isEmpty(pushToken)) {
                com.hihonor.push.sdk.utils.HonorIdUtils.setPushToken(context, pushToken);
                this.mTaskCompletionSource.setResult(pushTokenResult);
                return;
            }
        }
        this.mTaskCompletionSource.setException(apiException);
    }
}
