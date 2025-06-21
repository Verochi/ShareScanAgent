package com.huawei.hms.aaid;

@java.lang.Deprecated
/* loaded from: classes22.dex */
public class HmsInstanceIdEx {
    public static final java.lang.String TAG = "HmsInstanceIdEx";
    public android.content.Context a;
    public com.huawei.hms.aaid.utils.PushPreferences b;
    public com.huawei.hms.common.HuaweiApi<com.huawei.hms.api.Api.ApiOptions.NoOptions> c;

    public HmsInstanceIdEx(android.content.Context context) {
        this.b = null;
        this.a = context;
        this.b = new com.huawei.hms.aaid.utils.PushPreferences(context, "aaid");
        com.huawei.hms.common.HuaweiApi<com.huawei.hms.api.Api.ApiOptions.NoOptions> huaweiApi = new com.huawei.hms.common.HuaweiApi<>(context, (com.huawei.hms.api.Api<com.huawei.hms.api.Api.ApiOptions>) new com.huawei.hms.api.Api(com.huawei.hms.api.HuaweiApiAvailability.HMS_API_NAME_PUSH), (com.huawei.hms.api.Api.ApiOptions) null, new com.huawei.hms.aaid.task.PushClientBuilder());
        this.c = huaweiApi;
        huaweiApi.setKitSdkVersion(60300305);
    }

    public static com.huawei.hms.aaid.HmsInstanceIdEx getInstance(android.content.Context context) {
        com.huawei.hms.common.internal.Preconditions.checkNotNull(context);
        return new com.huawei.hms.aaid.HmsInstanceIdEx(context);
    }

    public final com.huawei.hmf.tasks.Task<com.huawei.hms.aaid.entity.TokenResult> a(java.lang.Exception exc) {
        com.huawei.hmf.tasks.TaskCompletionSource taskCompletionSource = new com.huawei.hmf.tasks.TaskCompletionSource();
        taskCompletionSource.setException(exc);
        return taskCompletionSource.getTask();
    }

    public final java.lang.String a(java.lang.String str) {
        return "creationTime" + str;
    }

    public void deleteAAID(java.lang.String str) throws com.huawei.hms.common.ApiException {
        if (str == null) {
            throw com.huawei.hms.aaid.constant.ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
        }
        try {
            if (this.b.containsKey(str)) {
                this.b.removeKey(str);
                this.b.removeKey(a(str));
            }
        } catch (java.lang.RuntimeException unused) {
            throw com.huawei.hms.aaid.constant.ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
        } catch (java.lang.Exception unused2) {
            throw com.huawei.hms.aaid.constant.ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
        }
    }

    public java.lang.String getAAId(java.lang.String str) throws com.huawei.hms.common.ApiException {
        if (str == null) {
            throw com.huawei.hms.aaid.constant.ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
        }
        try {
            if (this.b.containsKey(str)) {
                return this.b.getString(str);
            }
            java.lang.String uuid = java.util.UUID.randomUUID().toString();
            this.b.saveString(str, uuid);
            this.b.saveLong(a(str), java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
            return uuid;
        } catch (java.lang.RuntimeException unused) {
            throw com.huawei.hms.aaid.constant.ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
        } catch (java.lang.Exception unused2) {
            throw com.huawei.hms.aaid.constant.ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
        }
    }

    public long getCreationTime(java.lang.String str) throws com.huawei.hms.common.ApiException {
        if (str == null) {
            throw com.huawei.hms.aaid.constant.ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
        }
        try {
            if (!this.b.containsKey(a(str))) {
                getAAId(str);
            }
            return this.b.getLong(a(str));
        } catch (java.lang.RuntimeException unused) {
            throw com.huawei.hms.aaid.constant.ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
        } catch (java.lang.Exception unused2) {
            throw com.huawei.hms.aaid.constant.ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
        }
    }

    public com.huawei.hmf.tasks.Task<com.huawei.hms.aaid.entity.TokenResult> getToken() {
        if (com.huawei.hms.aaid.plugin.ProxyCenter.getProxy() != null) {
            try {
                com.huawei.hms.support.log.HMSLog.i(TAG, "use proxy get token, please check HmsMessageService.onNewToken receive result.");
                com.huawei.hms.aaid.plugin.ProxyCenter.getProxy().getToken(this.a, null, null);
                com.huawei.hmf.tasks.TaskCompletionSource taskCompletionSource = new com.huawei.hmf.tasks.TaskCompletionSource();
                taskCompletionSource.setResult(new com.huawei.hms.aaid.entity.TokenResult());
                return taskCompletionSource.getTask();
            } catch (com.huawei.hms.common.ApiException e) {
                return a(e);
            } catch (java.lang.Exception unused) {
                return a(com.huawei.hms.aaid.constant.ErrorEnum.ERROR_INTERNAL_ERROR.toApiException());
            }
        }
        java.lang.String a = com.huawei.hms.opendevice.q.a(this.a, "push.gettoken");
        try {
            com.huawei.hms.aaid.entity.TokenReq b = com.huawei.hms.opendevice.o.b(this.a, null, null);
            b.setAaid(com.huawei.hms.aaid.HmsInstanceId.getInstance(this.a).getId());
            return this.c.doWrite(new com.huawei.hms.opendevice.l("push.gettoken", b, this.a, a));
        } catch (java.lang.RuntimeException unused2) {
            android.content.Context context = this.a;
            com.huawei.hms.aaid.constant.ErrorEnum errorEnum = com.huawei.hms.aaid.constant.ErrorEnum.ERROR_INTERNAL_ERROR;
            com.huawei.hms.opendevice.q.a(context, "push.gettoken", a, errorEnum);
            return a(errorEnum.toApiException());
        } catch (java.lang.Exception unused3) {
            android.content.Context context2 = this.a;
            com.huawei.hms.aaid.constant.ErrorEnum errorEnum2 = com.huawei.hms.aaid.constant.ErrorEnum.ERROR_INTERNAL_ERROR;
            com.huawei.hms.opendevice.q.a(context2, "push.gettoken", a, errorEnum2);
            return a(errorEnum2.toApiException());
        }
    }
}
