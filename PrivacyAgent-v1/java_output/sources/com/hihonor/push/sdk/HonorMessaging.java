package com.hihonor.push.sdk;

/* loaded from: classes22.dex */
public class HonorMessaging {
    public android.content.Context a;
    public com.hihonor.push.sdk.g b;

    public HonorMessaging(android.content.Context context) {
        com.hihonor.push.sdk.utils.Preconditions.checkNotNull(context);
        this.a = context.getApplicationContext();
        this.b = com.hihonor.push.sdk.g.a();
    }

    public static com.hihonor.push.sdk.HonorMessaging getInstance(android.content.Context context) {
        return new com.hihonor.push.sdk.HonorMessaging(context);
    }

    public final com.hihonor.push.sdk.tasks.Task<java.lang.Void> a(java.lang.String str) {
        try {
            com.hihonor.push.sdk.tasks.task.VoidTask voidTask = new com.hihonor.push.sdk.tasks.task.VoidTask(this.a, str, null);
            voidTask.setRequestHeader(com.hihonor.push.sdk.tasks.task.HonorTaskHelper.buildRequestHeader(this.a));
            return this.b.a(voidTask);
        } catch (java.lang.Exception e) {
            return com.hihonor.push.sdk.tasks.Tasks.fromException(com.hihonor.push.sdk.tasks.task.HonorTaskHelper.toCastBaseException(e));
        }
    }

    public com.hihonor.push.sdk.tasks.Task<java.util.List<com.hihonor.push.sdk.bean.MessageBoxBean>> getUnreadMessage() {
        try {
            return com.hihonor.push.sdk.tasks.Tasks.callInBackground(new com.hihonor.push.sdk.a(this.a));
        } catch (java.lang.Exception e) {
            return com.hihonor.push.sdk.tasks.Tasks.fromException(com.hihonor.push.sdk.tasks.task.HonorTaskHelper.toCastBaseException(e));
        }
    }

    public com.hihonor.push.sdk.tasks.Task<com.hihonor.push.framework.aidl.entity.BooleanResult> queryPushStatus() {
        try {
            com.hihonor.push.sdk.tasks.task.BooleanTask booleanTask = new com.hihonor.push.sdk.tasks.task.BooleanTask(this.a, com.hihonor.push.sdk.common.data.UpMsgType.QUERY_PUSH_STATUS, null);
            booleanTask.setRequestHeader(com.hihonor.push.sdk.tasks.task.HonorTaskHelper.buildRequestHeader(this.a));
            return this.b.a(booleanTask);
        } catch (java.lang.Exception e) {
            return com.hihonor.push.sdk.tasks.Tasks.fromException(com.hihonor.push.sdk.tasks.task.HonorTaskHelper.toCastBaseException(e));
        }
    }

    public com.hihonor.push.sdk.tasks.Task<java.lang.Void> turnOffPush() {
        return a(com.hihonor.push.sdk.common.data.UpMsgType.TURN_OFF_PUSH);
    }

    public com.hihonor.push.sdk.tasks.Task<java.lang.Void> turnOnPush() {
        return a(com.hihonor.push.sdk.common.data.UpMsgType.TURN_ON_PUSH);
    }
}
