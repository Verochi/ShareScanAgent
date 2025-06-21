package com.huawei.hms.aaid;

/* loaded from: classes22.dex */
public class HmsInstanceId {
    public static final java.lang.String TAG = "HmsInstanceId";
    public android.content.Context a;
    public com.huawei.hms.aaid.utils.PushPreferences b;
    public com.huawei.hms.common.HuaweiApi<com.huawei.hms.api.Api.ApiOptions.NoOptions> c;

    public HmsInstanceId(android.content.Context context) {
        this.a = context.getApplicationContext();
        this.b = new com.huawei.hms.aaid.utils.PushPreferences(context, "aaid");
        com.huawei.hms.common.HuaweiApi<com.huawei.hms.api.Api.ApiOptions.NoOptions> huaweiApi = new com.huawei.hms.common.HuaweiApi<>(context, (com.huawei.hms.api.Api<com.huawei.hms.api.Api.ApiOptions>) new com.huawei.hms.api.Api(com.huawei.hms.api.HuaweiApiAvailability.HMS_API_NAME_PUSH), (com.huawei.hms.api.Api.ApiOptions) null, new com.huawei.hms.aaid.task.PushClientBuilder());
        this.c = huaweiApi;
        huaweiApi.setKitSdkVersion(60300305);
    }

    public static com.huawei.hms.aaid.HmsInstanceId getInstance(android.content.Context context) {
        com.huawei.hms.common.internal.Preconditions.checkNotNull(context);
        com.huawei.hms.opendevice.c.c(context);
        return new com.huawei.hms.aaid.HmsInstanceId(context);
    }

    public final java.lang.String a(com.huawei.hms.aaid.entity.TokenReq tokenReq, int i) throws com.huawei.hms.common.ApiException {
        if (com.huawei.hms.aaid.plugin.ProxyCenter.getProxy() != null) {
            com.huawei.hms.support.log.HMSLog.i(TAG, "use proxy get token, please check HmsMessageService.onNewToken receive result.");
            com.huawei.hms.aaid.plugin.ProxyCenter.getProxy().getToken(this.a, tokenReq.getSubjectId(), null);
            return null;
        }
        a(tokenReq.getSubjectId());
        java.lang.String a = com.huawei.hms.opendevice.q.a(this.a, "push.gettoken");
        try {
            java.lang.String str = TAG;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("getToken req :");
            sb.append(tokenReq.toString());
            com.huawei.hms.support.log.HMSLog.d(str, sb.toString());
            com.huawei.hms.opendevice.l lVar = new com.huawei.hms.opendevice.l("push.gettoken", tokenReq, this.a, a);
            lVar.setApiLevel(i);
            return ((com.huawei.hms.aaid.entity.TokenResult) com.huawei.hmf.tasks.Tasks.await(this.c.doWrite(lVar))).getToken();
        } catch (java.lang.Exception e) {
            if (e.getCause() instanceof com.huawei.hms.common.ApiException) {
                com.huawei.hms.common.ApiException apiException = (com.huawei.hms.common.ApiException) e.getCause();
                com.huawei.hms.opendevice.q.a(this.a, "push.gettoken", a, apiException.getStatusCode());
                throw apiException;
            }
            android.content.Context context = this.a;
            com.huawei.hms.aaid.constant.ErrorEnum errorEnum = com.huawei.hms.aaid.constant.ErrorEnum.ERROR_INTERNAL_ERROR;
            com.huawei.hms.opendevice.q.a(context, "push.gettoken", a, errorEnum);
            throw errorEnum.toApiException();
        }
    }

    public final void a() throws com.huawei.hms.common.ApiException {
        if (com.huawei.hms.aaid.utils.BaseUtils.getProxyInit(this.a) && com.huawei.hms.aaid.plugin.ProxyCenter.getProxy() == null && !com.huawei.hms.aaid.utils.BaseUtils.isMainProc(this.a)) {
            com.huawei.hms.support.log.HMSLog.e(TAG, "Operations in child processes are not supported.");
            throw com.huawei.hms.aaid.constant.ErrorEnum.ERROR_OPER_IN_CHILD_PROCESS.toApiException();
        }
    }

    public final void a(com.huawei.hms.aaid.entity.DeleteTokenReq deleteTokenReq, int i) throws com.huawei.hms.common.ApiException {
        java.lang.String subjectId = deleteTokenReq.getSubjectId();
        if (com.huawei.hms.aaid.plugin.ProxyCenter.getProxy() != null) {
            com.huawei.hms.support.log.HMSLog.i(TAG, "use proxy delete token");
            com.huawei.hms.aaid.plugin.ProxyCenter.getProxy().deleteToken(this.a, subjectId, null);
            return;
        }
        java.lang.String a = com.huawei.hms.opendevice.q.a(this.a, "push.deletetoken");
        try {
            java.lang.String b = com.huawei.hms.opendevice.i.a(this.a).b(subjectId);
            if (deleteTokenReq.isMultiSender() && (android.text.TextUtils.isEmpty(b) || b.equals(com.huawei.hms.opendevice.i.a(this.a).b(null)))) {
                com.huawei.hms.opendevice.i.a(this.a).removeKey(subjectId);
                com.huawei.hms.support.log.HMSLog.i(TAG, "The local subject token is null");
                return;
            }
            deleteTokenReq.setToken(b);
            com.huawei.hms.opendevice.k kVar = new com.huawei.hms.opendevice.k("push.deletetoken", deleteTokenReq, a);
            kVar.setApiLevel(i);
            com.huawei.hmf.tasks.Tasks.await(this.c.doWrite(kVar));
            com.huawei.hms.opendevice.i.a(this.a).c(subjectId);
        } catch (java.lang.Exception e) {
            if (e.getCause() instanceof com.huawei.hms.common.ApiException) {
                com.huawei.hms.common.ApiException apiException = (com.huawei.hms.common.ApiException) e.getCause();
                com.huawei.hms.opendevice.q.a(this.a, "push.deletetoken", a, apiException.getStatusCode());
                throw apiException;
            }
            android.content.Context context = this.a;
            com.huawei.hms.aaid.constant.ErrorEnum errorEnum = com.huawei.hms.aaid.constant.ErrorEnum.ERROR_INTERNAL_ERROR;
            com.huawei.hms.opendevice.q.a(context, "push.deletetoken", a, errorEnum);
            throw errorEnum.toApiException();
        }
    }

    public final void a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        if (!com.huawei.hms.opendevice.p.e(this.a)) {
            com.huawei.hms.opendevice.i.a(this.a).removeKey("subjectId");
            return;
        }
        java.lang.String string = com.huawei.hms.opendevice.i.a(this.a).getString("subjectId");
        if (android.text.TextUtils.isEmpty(string)) {
            com.huawei.hms.opendevice.i.a(this.a).saveString("subjectId", str);
            return;
        }
        if (string.contains(str)) {
            return;
        }
        com.huawei.hms.opendevice.i.a(this.a).saveString("subjectId", string + "," + str);
    }

    public final void b() throws com.huawei.hms.common.ApiException {
        if (android.os.Looper.getMainLooper() == android.os.Looper.myLooper()) {
            throw com.huawei.hms.aaid.constant.ErrorEnum.ERROR_MAIN_THREAD.toApiException();
        }
    }

    public void deleteAAID() throws com.huawei.hms.common.ApiException {
        b();
        try {
            if (this.b.containsKey("aaid")) {
                this.b.removeKey("aaid");
                this.b.removeKey("creationTime");
                if (com.huawei.hms.opendevice.o.e(this.a)) {
                    if (com.huawei.hms.aaid.plugin.ProxyCenter.getProxy() != null) {
                        com.huawei.hms.support.log.HMSLog.i(TAG, "use proxy delete all token after delete AaId.");
                        com.huawei.hms.aaid.plugin.ProxyCenter.getProxy().deleteAllToken(this.a);
                        return;
                    }
                    com.huawei.hms.aaid.entity.DeleteTokenReq b = com.huawei.hms.opendevice.o.b(this.a);
                    b.setDeleteType(1);
                    b.setMultiSender(false);
                    a(b, 1);
                    com.huawei.hms.aaid.utils.BaseUtils.deleteAllTokenCache(this.a);
                }
            }
        } catch (com.huawei.hms.common.ApiException e) {
            throw e;
        } catch (java.lang.Exception unused) {
            throw com.huawei.hms.aaid.constant.ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
        }
    }

    public void deleteToken(java.lang.String str) throws com.huawei.hms.common.ApiException {
        b();
        a();
        if (android.text.TextUtils.isEmpty(str)) {
            throw com.huawei.hms.aaid.constant.ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
        }
        java.lang.String d = com.huawei.hms.opendevice.o.d(this.a);
        if (android.text.TextUtils.isEmpty(d)) {
            throw com.huawei.hms.aaid.constant.ErrorEnum.ERROR_MISSING_PROJECT_ID.toApiException();
        }
        if (str.equals(d)) {
            deleteToken(null, null);
            return;
        }
        com.huawei.hms.aaid.entity.DeleteTokenReq a = com.huawei.hms.opendevice.o.a(this.a, str);
        a.setMultiSender(true);
        a(a, 2);
    }

    public void deleteToken(java.lang.String str, java.lang.String str2) throws com.huawei.hms.common.ApiException {
        b();
        a();
        com.huawei.hms.aaid.entity.DeleteTokenReq a = com.huawei.hms.opendevice.o.a(this.a, str, str2);
        a.setMultiSender(false);
        a(a, 1);
    }

    public com.huawei.hmf.tasks.Task<com.huawei.hms.aaid.entity.AAIDResult> getAAID() {
        try {
            return com.huawei.hmf.tasks.Tasks.callInBackground(new com.huawei.hms.opendevice.j(this.a.getApplicationContext()));
        } catch (java.lang.Exception unused) {
            com.huawei.hmf.tasks.TaskCompletionSource taskCompletionSource = new com.huawei.hmf.tasks.TaskCompletionSource();
            taskCompletionSource.setException(com.huawei.hms.aaid.constant.ErrorEnum.ERROR_INTERNAL_ERROR.toApiException());
            return taskCompletionSource.getTask();
        }
    }

    public long getCreationTime() {
        try {
            if (!this.b.containsKey("creationTime")) {
                getAAID();
            }
            return this.b.getLong("creationTime");
        } catch (java.lang.Exception unused) {
            return 0L;
        }
    }

    public java.lang.String getId() {
        return com.huawei.hms.opendevice.o.c(this.a);
    }

    @java.lang.Deprecated
    public java.lang.String getToken() {
        try {
            return getToken(null, null);
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public java.lang.String getToken(java.lang.String str) throws com.huawei.hms.common.ApiException {
        b();
        a();
        if (android.text.TextUtils.isEmpty(str)) {
            throw com.huawei.hms.aaid.constant.ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
        }
        java.lang.String d = com.huawei.hms.opendevice.o.d(this.a);
        if (android.text.TextUtils.isEmpty(d)) {
            throw com.huawei.hms.aaid.constant.ErrorEnum.ERROR_MISSING_PROJECT_ID.toApiException();
        }
        if (str.equals(d)) {
            return getToken(null, null);
        }
        com.huawei.hms.aaid.entity.TokenReq b = com.huawei.hms.opendevice.o.b(this.a, str);
        b.setAaid(getId());
        b.setMultiSender(true);
        return a(b, 2);
    }

    public java.lang.String getToken(java.lang.String str, java.lang.String str2) throws com.huawei.hms.common.ApiException {
        b();
        a();
        com.huawei.hms.aaid.entity.TokenReq b = com.huawei.hms.opendevice.o.b(this.a, null, str2);
        b.setAaid(getId());
        b.setMultiSender(false);
        com.huawei.hms.opendevice.i.a(this.a).saveString(this.a.getPackageName(), "1");
        return a(b, 1);
    }
}
