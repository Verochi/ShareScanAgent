package com.huawei.hms.push;

/* loaded from: classes22.dex */
public class HmsConsent {
    public com.huawei.hms.common.HuaweiApi<com.huawei.hms.api.Api.ApiOptions.NoOptions> a;
    public android.content.Context b;

    public HmsConsent(android.content.Context context) {
        com.huawei.hms.common.internal.Preconditions.checkNotNull(context);
        this.b = context;
        com.huawei.hms.common.HuaweiApi<com.huawei.hms.api.Api.ApiOptions.NoOptions> huaweiApi = new com.huawei.hms.common.HuaweiApi<>(context, (com.huawei.hms.api.Api<com.huawei.hms.api.Api.ApiOptions>) new com.huawei.hms.api.Api(com.huawei.hms.api.HuaweiApiAvailability.HMS_API_NAME_PUSH), (com.huawei.hms.api.Api.ApiOptions) null, new com.huawei.hms.aaid.task.PushClientBuilder());
        this.a = huaweiApi;
        huaweiApi.setKitSdkVersion(60500300);
    }

    public static com.huawei.hms.push.HmsConsent getInstance(android.content.Context context) {
        return new com.huawei.hms.push.HmsConsent(context);
    }

    public final com.huawei.hmf.tasks.Task<java.lang.Void> a(boolean z) {
        com.huawei.hmf.tasks.TaskCompletionSource taskCompletionSource;
        int externalCode;
        java.lang.String reportEntry = com.huawei.hms.push.utils.PushBiUtil.reportEntry(this.b, com.huawei.hms.support.api.entity.push.PushNaming.PUSH_CONSENT);
        try {
            if (!com.huawei.hms.push.s.d(this.b)) {
                throw com.huawei.hms.aaid.constant.ErrorEnum.ERROR_OPERATION_NOT_SUPPORTED.toApiException();
            }
            com.huawei.hms.support.api.entity.push.EnableConsentReq enableConsentReq = new com.huawei.hms.support.api.entity.push.EnableConsentReq();
            enableConsentReq.setPackageName(this.b.getPackageName());
            enableConsentReq.setEnable(z);
            return this.a.doWrite(new com.huawei.hms.push.task.ConsentTask(com.huawei.hms.support.api.entity.push.PushNaming.PUSH_CONSENT, com.huawei.hms.utils.JsonUtil.createJsonString(enableConsentReq), reportEntry));
        } catch (com.huawei.hms.common.ApiException e) {
            com.huawei.hmf.tasks.TaskCompletionSource taskCompletionSource2 = new com.huawei.hmf.tasks.TaskCompletionSource();
            taskCompletionSource2.setException(e);
            externalCode = e.getStatusCode();
            taskCompletionSource = taskCompletionSource2;
            com.huawei.hms.push.utils.PushBiUtil.reportExit(this.b, com.huawei.hms.support.api.entity.push.PushNaming.PUSH_CONSENT, reportEntry, externalCode);
            return taskCompletionSource.getTask();
        } catch (java.lang.Exception unused) {
            taskCompletionSource = new com.huawei.hmf.tasks.TaskCompletionSource();
            com.huawei.hms.aaid.constant.ErrorEnum errorEnum = com.huawei.hms.aaid.constant.ErrorEnum.ERROR_INTERNAL_ERROR;
            taskCompletionSource.setException(errorEnum.toApiException());
            externalCode = errorEnum.getExternalCode();
            com.huawei.hms.push.utils.PushBiUtil.reportExit(this.b, com.huawei.hms.support.api.entity.push.PushNaming.PUSH_CONSENT, reportEntry, externalCode);
            return taskCompletionSource.getTask();
        }
    }

    public com.huawei.hmf.tasks.Task<java.lang.Void> consentOff() {
        return a(false);
    }

    public com.huawei.hmf.tasks.Task<java.lang.Void> consentOn() {
        return a(true);
    }
}
