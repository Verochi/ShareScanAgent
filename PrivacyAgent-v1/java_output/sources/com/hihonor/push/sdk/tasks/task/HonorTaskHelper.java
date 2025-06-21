package com.hihonor.push.sdk.tasks.task;

/* loaded from: classes22.dex */
public class HonorTaskHelper {
    public static com.hihonor.push.sdk.tasks.task.GetPushTokenTask buildPushTokenTask(android.content.Context context, com.hihonor.push.framework.aidl.IMessageEntity iMessageEntity) throws com.hihonor.push.sdk.common.data.ApiException {
        com.hihonor.push.sdk.tasks.task.GetPushTokenTask getPushTokenTask = new com.hihonor.push.sdk.tasks.task.GetPushTokenTask(context, com.hihonor.push.sdk.common.data.UpMsgType.REQUEST_PUSH_TOKEN, iMessageEntity);
        getPushTokenTask.setRequestHeader(buildRequestHeader(context));
        return getPushTokenTask;
    }

    public static com.hihonor.push.framework.aidl.entity.RequestHeader buildRequestHeader(android.content.Context context) throws com.hihonor.push.sdk.common.data.ApiException {
        java.lang.String checkPushAppId = com.hihonor.push.sdk.utils.HonorChecker.checkPushAppId(context);
        java.lang.String checkPushCertFingerprint = com.hihonor.push.sdk.utils.HonorChecker.checkPushCertFingerprint(context);
        java.lang.String pushToken = com.hihonor.push.sdk.utils.HonorIdUtils.getPushToken(context);
        com.hihonor.push.framework.aidl.entity.RequestHeader requestHeader = new com.hihonor.push.framework.aidl.entity.RequestHeader();
        requestHeader.setPackageName(context.getPackageName());
        requestHeader.setAppId(checkPushAppId);
        requestHeader.setCertificateFingerprint(checkPushCertFingerprint);
        requestHeader.setPushToken(pushToken);
        requestHeader.setAAID(com.hihonor.push.sdk.utils.HonorIdUtils.getAAID(context));
        requestHeader.setSdkVersion(60004200);
        return requestHeader;
    }

    public static com.hihonor.push.sdk.tasks.task.DeletePushTokenTask getDeletePushToken(android.content.Context context, com.hihonor.push.framework.aidl.IMessageEntity iMessageEntity) throws com.hihonor.push.sdk.common.data.ApiException {
        com.hihonor.push.sdk.tasks.task.DeletePushTokenTask deletePushTokenTask = new com.hihonor.push.sdk.tasks.task.DeletePushTokenTask(context, com.hihonor.push.sdk.common.data.UpMsgType.UNREGISTER_PUSH_TOKEN, iMessageEntity);
        deletePushTokenTask.setRequestHeader(buildRequestHeader(context));
        return deletePushTokenTask;
    }

    public static com.hihonor.push.sdk.common.data.ApiException toCastBaseException(java.lang.Exception exc) {
        return exc.getCause() instanceof com.hihonor.push.sdk.common.data.ApiException ? (com.hihonor.push.sdk.common.data.ApiException) exc.getCause() : exc instanceof com.hihonor.push.sdk.common.data.ApiException ? (com.hihonor.push.sdk.common.data.ApiException) exc : new com.hihonor.push.sdk.common.data.ApiException(-1, exc.getMessage());
    }
}
