package com.hihonor.push.sdk;

/* loaded from: classes22.dex */
public class HonorInstanceId {
    public android.content.Context a;
    public com.hihonor.push.sdk.g b;

    public HonorInstanceId(android.content.Context context) {
        com.hihonor.push.sdk.utils.Preconditions.checkNotNull(context);
        this.a = context.getApplicationContext();
        this.b = com.hihonor.push.sdk.g.a();
    }

    public static com.hihonor.push.sdk.HonorInstanceId getInstance(android.content.Context context) {
        return new com.hihonor.push.sdk.HonorInstanceId(context);
    }

    public void deletePushToken() throws com.hihonor.push.sdk.common.data.ApiException {
        try {
            com.hihonor.push.sdk.utils.HonorChecker.checkNotRunInMainThread();
            com.hihonor.push.sdk.tasks.Tasks.await(this.b.a(com.hihonor.push.sdk.tasks.task.HonorTaskHelper.getDeletePushToken(this.a, null)));
            com.hihonor.push.sdk.utils.HonorIdUtils.setPushToken(this.a, null);
        } catch (java.lang.Exception e) {
            throw com.hihonor.push.sdk.tasks.task.HonorTaskHelper.toCastBaseException(e);
        }
    }

    public com.hihonor.push.sdk.tasks.Task<java.lang.Void> deletePushTokenTask() {
        try {
            return this.b.a(com.hihonor.push.sdk.tasks.task.HonorTaskHelper.getDeletePushToken(this.a, null));
        } catch (java.lang.Exception e) {
            return com.hihonor.push.sdk.tasks.Tasks.fromException(com.hihonor.push.sdk.tasks.task.HonorTaskHelper.toCastBaseException(e));
        }
    }

    public java.lang.String getAAID() {
        return com.hihonor.push.sdk.utils.HonorIdUtils.getAAID(this.a);
    }

    public java.lang.String getPushToken() throws com.hihonor.push.sdk.common.data.ApiException {
        try {
            com.hihonor.push.sdk.utils.HonorChecker.checkNotRunInMainThread();
            return ((com.hihonor.push.framework.aidl.entity.PushTokenResult) com.hihonor.push.sdk.tasks.Tasks.await(this.b.a(com.hihonor.push.sdk.tasks.task.HonorTaskHelper.buildPushTokenTask(this.a, null)))).getPushToken();
        } catch (java.lang.Exception e) {
            throw com.hihonor.push.sdk.tasks.task.HonorTaskHelper.toCastBaseException(e);
        }
    }

    public com.hihonor.push.sdk.tasks.Task<com.hihonor.push.framework.aidl.entity.PushTokenResult> getPushTokenTask() {
        try {
            return this.b.a(com.hihonor.push.sdk.tasks.task.HonorTaskHelper.buildPushTokenTask(this.a, null));
        } catch (java.lang.Exception e) {
            return com.hihonor.push.sdk.tasks.Tasks.fromException(com.hihonor.push.sdk.tasks.task.HonorTaskHelper.toCastBaseException(e));
        }
    }

    public void setAutoInitEnabled(boolean z) {
        android.content.Context context = this.a;
        com.hihonor.push.sdk.utils.PushPreferences honorPushPreferences = com.hihonor.push.sdk.utils.HonorIdUtils.getHonorPushPreferences(context);
        boolean z2 = honorPushPreferences.getBoolean("key_auto_init");
        honorPushPreferences.saveBoolean("key_auto_init", z);
        if (!z || z2) {
            return;
        }
        com.hihonor.push.sdk.b.a(context);
    }
}
