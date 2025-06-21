package com.huawei.hms.push;

/* loaded from: classes22.dex */
public class HmsProfile {
    public static final int CUSTOM_PROFILE = 2;
    public static final int HUAWEI_PROFILE = 1;
    public static final java.lang.String a = "HmsProfile";
    public android.content.Context b;
    public com.huawei.hms.common.HuaweiApi<com.huawei.hms.api.Api.ApiOptions.NoOptions> c;

    public HmsProfile(android.content.Context context) {
        this.b = null;
        com.huawei.hms.common.internal.Preconditions.checkNotNull(context);
        this.b = context;
        com.huawei.hms.common.HuaweiApi<com.huawei.hms.api.Api.ApiOptions.NoOptions> huaweiApi = new com.huawei.hms.common.HuaweiApi<>(context, (com.huawei.hms.api.Api<com.huawei.hms.api.Api.ApiOptions>) new com.huawei.hms.api.Api(com.huawei.hms.api.HuaweiApiAvailability.HMS_API_NAME_PUSH), (com.huawei.hms.api.Api.ApiOptions) null, new com.huawei.hms.aaid.task.PushClientBuilder());
        this.c = huaweiApi;
        huaweiApi.setKitSdkVersion(60500300);
    }

    public static java.lang.String a(android.content.Context context) {
        return com.huawei.agconnect.config.AGConnectServicesConfig.fromContext(context).getString("client/project_id");
    }

    public static com.huawei.hms.push.HmsProfile getInstance(android.content.Context context) {
        return new com.huawei.hms.push.HmsProfile(context);
    }

    public final com.huawei.hmf.tasks.Task<java.lang.Void> a(int i, java.lang.String str, int i2, java.lang.String str2) {
        if (!isSupportProfile()) {
            com.huawei.hmf.tasks.TaskCompletionSource taskCompletionSource = new com.huawei.hmf.tasks.TaskCompletionSource();
            taskCompletionSource.setException(com.huawei.hms.aaid.constant.ErrorEnum.ERROR_OPERATION_NOT_SUPPORTED.toApiException());
            return taskCompletionSource.getTask();
        }
        if (!android.text.TextUtils.isEmpty(str)) {
            java.lang.String a2 = a(this.b);
            if (android.text.TextUtils.isEmpty(a2)) {
                com.huawei.hms.support.log.HMSLog.i(a, "agc connect services config missing project id.");
                com.huawei.hmf.tasks.TaskCompletionSource taskCompletionSource2 = new com.huawei.hmf.tasks.TaskCompletionSource();
                taskCompletionSource2.setException(com.huawei.hms.aaid.constant.ErrorEnum.ERROR_MISSING_PROJECT_ID.toApiException());
                return taskCompletionSource2.getTask();
            }
            if (str.equals(a2)) {
                str = "";
            }
        }
        com.huawei.hms.support.api.entity.push.ProfileReq profileReq = new com.huawei.hms.support.api.entity.push.ProfileReq();
        if (i == 0) {
            profileReq.setOperation(0);
            profileReq.setType(i2);
        } else {
            profileReq.setOperation(1);
        }
        java.lang.String reportEntry = com.huawei.hms.push.utils.PushBiUtil.reportEntry(this.b, com.huawei.hms.support.api.entity.push.PushNaming.PUSH_PROFILE);
        try {
            profileReq.setSubjectId(str);
            profileReq.setProfileId(com.huawei.secure.android.common.encrypt.hash.SHA.sha256Encrypt(str2));
            profileReq.setPkgName(this.b.getPackageName());
            return this.c.doWrite(new com.huawei.hms.push.task.ProfileTask(com.huawei.hms.support.api.entity.push.PushNaming.PUSH_PROFILE, com.huawei.hms.utils.JsonUtil.createJsonString(profileReq), reportEntry));
        } catch (java.lang.Exception e) {
            if (e.getCause() instanceof com.huawei.hms.common.ApiException) {
                com.huawei.hmf.tasks.TaskCompletionSource taskCompletionSource3 = new com.huawei.hmf.tasks.TaskCompletionSource();
                com.huawei.hms.common.ApiException apiException = (com.huawei.hms.common.ApiException) e.getCause();
                taskCompletionSource3.setException(apiException);
                com.huawei.hms.push.utils.PushBiUtil.reportExit(this.b, com.huawei.hms.support.api.entity.push.PushNaming.PUSH_PROFILE, reportEntry, apiException.getStatusCode());
                return taskCompletionSource3.getTask();
            }
            com.huawei.hmf.tasks.TaskCompletionSource taskCompletionSource4 = new com.huawei.hmf.tasks.TaskCompletionSource();
            android.content.Context context = this.b;
            com.huawei.hms.aaid.constant.ErrorEnum errorEnum = com.huawei.hms.aaid.constant.ErrorEnum.ERROR_INTERNAL_ERROR;
            com.huawei.hms.push.utils.PushBiUtil.reportExit(context, com.huawei.hms.support.api.entity.push.PushNaming.PUSH_PROFILE, reportEntry, errorEnum);
            taskCompletionSource4.setException(errorEnum.toApiException());
            return taskCompletionSource4.getTask();
        }
    }

    public com.huawei.hmf.tasks.Task<java.lang.Void> addProfile(int i, java.lang.String str) {
        return addProfile("", i, str);
    }

    public com.huawei.hmf.tasks.Task<java.lang.Void> addProfile(java.lang.String str, int i, java.lang.String str2) {
        if (i != 1 && i != 2) {
            com.huawei.hms.support.log.HMSLog.i(a, "add profile type undefined.");
            com.huawei.hmf.tasks.TaskCompletionSource taskCompletionSource = new com.huawei.hmf.tasks.TaskCompletionSource();
            taskCompletionSource.setException(com.huawei.hms.aaid.constant.ErrorEnum.ERROR_PUSH_ARGUMENTS_INVALID.toApiException());
            return taskCompletionSource.getTask();
        }
        if (!android.text.TextUtils.isEmpty(str2)) {
            return a(0, str, i, str2);
        }
        com.huawei.hms.support.log.HMSLog.i(a, "add profile params is empty.");
        com.huawei.hmf.tasks.TaskCompletionSource taskCompletionSource2 = new com.huawei.hmf.tasks.TaskCompletionSource();
        taskCompletionSource2.setException(com.huawei.hms.aaid.constant.ErrorEnum.ERROR_PUSH_ARGUMENTS_INVALID.toApiException());
        return taskCompletionSource2.getTask();
    }

    public final boolean b(android.content.Context context) {
        return com.huawei.hms.push.s.b(context) >= 110001400;
    }

    public com.huawei.hmf.tasks.Task<java.lang.Void> deleteProfile(java.lang.String str) {
        return deleteProfile("", str);
    }

    public com.huawei.hmf.tasks.Task<java.lang.Void> deleteProfile(java.lang.String str, java.lang.String str2) {
        if (!android.text.TextUtils.isEmpty(str2)) {
            return a(1, str, -1, str2);
        }
        com.huawei.hms.support.log.HMSLog.e(a, "del profile params is empty.");
        com.huawei.hmf.tasks.TaskCompletionSource taskCompletionSource = new com.huawei.hmf.tasks.TaskCompletionSource();
        taskCompletionSource.setException(com.huawei.hms.aaid.constant.ErrorEnum.ERROR_PUSH_ARGUMENTS_INVALID.toApiException());
        return taskCompletionSource.getTask();
    }

    public boolean isSupportProfile() {
        if (!com.huawei.hms.push.s.d(this.b)) {
            return true;
        }
        if (com.huawei.hms.push.s.c()) {
            com.huawei.hms.support.log.HMSLog.i(a, "current EMUI version below 9.1, not support profile operation.");
            return false;
        }
        if (b(this.b)) {
            return true;
        }
        com.huawei.hms.support.log.HMSLog.i(a, "current HwPushService.apk version below 11.0.1.400,please upgrade your HwPushService.apk version.");
        return false;
    }
}
