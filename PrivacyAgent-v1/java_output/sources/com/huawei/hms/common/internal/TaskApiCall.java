package com.huawei.hms.common.internal;

/* loaded from: classes22.dex */
public abstract class TaskApiCall<ClientT extends com.huawei.hms.common.internal.AnyClient, ResultT> {
    private static final java.lang.String TAG = "TaskApiCall";
    private int apiLevel;
    private final java.lang.String mRequestJson;
    private final java.lang.String mUri;
    private android.os.Parcelable parcelable;
    private com.huawei.hmf.tasks.CancellationToken token;
    private java.lang.String transactionId;

    @java.lang.Deprecated
    public TaskApiCall(java.lang.String str, java.lang.String str2) {
        this.apiLevel = 1;
        this.mUri = str;
        this.mRequestJson = str2;
        this.parcelable = null;
        this.transactionId = null;
    }

    public TaskApiCall(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        this.apiLevel = 1;
        this.mUri = str;
        this.mRequestJson = str2;
        this.parcelable = null;
        this.transactionId = str3;
    }

    public TaskApiCall(java.lang.String str, java.lang.String str2, java.lang.String str3, int i) {
        this.mUri = str;
        this.mRequestJson = str2;
        this.parcelable = null;
        this.transactionId = str3;
        this.apiLevel = i;
    }

    public abstract void doExecute(ClientT clientt, com.huawei.hms.common.internal.ResponseErrorCode responseErrorCode, java.lang.String str, com.huawei.hmf.tasks.TaskCompletionSource<ResultT> taskCompletionSource);

    public int getApiLevel() {
        return this.apiLevel;
    }

    @java.lang.Deprecated
    public int getMinApkVersion() {
        return 30000000;
    }

    public android.os.Parcelable getParcelable() {
        return this.parcelable;
    }

    public java.lang.String getRequestJson() {
        return this.mRequestJson;
    }

    public com.huawei.hmf.tasks.CancellationToken getToken() {
        return this.token;
    }

    public java.lang.String getTransactionId() {
        return this.transactionId;
    }

    public java.lang.String getUri() {
        return this.mUri;
    }

    public final void onResponse(ClientT clientt, com.huawei.hms.common.internal.ResponseErrorCode responseErrorCode, java.lang.String str, com.huawei.hmf.tasks.TaskCompletionSource<ResultT> taskCompletionSource) {
        com.huawei.hmf.tasks.CancellationToken cancellationToken = this.token;
        if (cancellationToken != null && cancellationToken.isCancellationRequested()) {
            com.huawei.hms.support.log.HMSLog.i(TAG, "This Task has been canceled, uri:" + this.mUri + ", transactionId:" + this.transactionId);
            return;
        }
        com.huawei.hms.support.log.HMSLog.i(TAG, "doExecute, uri:" + this.mUri + ", errorCode:" + responseErrorCode.getErrorCode() + ", transactionId:" + this.transactionId);
        doExecute(clientt, responseErrorCode, str, taskCompletionSource);
    }

    public void setApiLevel(int i) {
        this.apiLevel = i;
    }

    public void setParcelable(android.os.Parcelable parcelable) {
        this.parcelable = parcelable;
    }

    public void setToken(com.huawei.hmf.tasks.CancellationToken cancellationToken) {
        this.token = cancellationToken;
    }

    public void setTransactionId(java.lang.String str) {
        this.transactionId = str;
    }
}
