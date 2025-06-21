package com.hihonor.push.sdk.tasks.task;

/* loaded from: classes22.dex */
public abstract class TaskApiCall<TResult> {
    private final java.lang.String TAG = getClass().getSimpleName();
    private final java.lang.String eventType;
    private final com.hihonor.push.sdk.d mConnectionManagerKey;
    private final android.content.Context mContext;
    private final com.hihonor.push.framework.aidl.IMessageEntity mRequestBody;
    private com.hihonor.push.framework.aidl.entity.RequestHeader mRequestHeader;
    public com.hihonor.push.sdk.tasks.TaskCompletionSource<TResult> mTaskCompletionSource;

    public TaskApiCall(android.content.Context context, java.lang.String str, com.hihonor.push.framework.aidl.IMessageEntity iMessageEntity) {
        this.mContext = context;
        this.eventType = str;
        this.mRequestBody = iMessageEntity;
        this.mConnectionManagerKey = com.hihonor.push.sdk.d.a(str);
    }

    private java.lang.Class<TResult> getResponseType() {
        java.lang.reflect.Type type;
        java.lang.reflect.Type genericSuperclass = getClass().getGenericSuperclass();
        if (genericSuperclass == null || (type = ((java.lang.reflect.ParameterizedType) genericSuperclass).getActualTypeArguments()[0]) == null) {
            return null;
        }
        return (java.lang.Class) type;
    }

    public abstract void doExecute(android.content.Context context, com.hihonor.push.sdk.common.data.ApiException apiException, java.lang.Object obj);

    public com.hihonor.push.sdk.d getConnectionManagerKey() {
        return this.mConnectionManagerKey;
    }

    public android.content.Context getContext() {
        return this.mContext;
    }

    public java.lang.String getEventType() {
        return this.eventType;
    }

    public com.hihonor.push.framework.aidl.IMessageEntity getRequestBody() {
        return this.mRequestBody;
    }

    public com.hihonor.push.framework.aidl.entity.RequestHeader getRequestHeader() {
        return this.mRequestHeader;
    }

    public TResult newResponseInstance() {
        try {
            java.lang.Class<TResult> responseType = getResponseType();
            if (responseType == null || android.text.TextUtils.equals("java.lang.Void", responseType.getName())) {
                return null;
            }
            return responseType.newInstance();
        } catch (java.lang.Exception e) {
            com.hihonor.push.sdk.common.logger.Logger.e("In newResponseInstance, instancing exception." + e.getMessage());
        }
        return null;
    }

    public final void onResponse(android.content.Context context, com.hihonor.push.sdk.common.data.ApiException apiException, java.lang.Object obj) {
        if (this.mTaskCompletionSource != null) {
            doExecute(context, apiException, obj);
            return;
        }
        com.hihonor.push.sdk.common.logger.Logger.e(this.TAG, "This Task has been canceled, uri:" + this.eventType);
    }

    public void setRequestHeader(com.hihonor.push.framework.aidl.entity.RequestHeader requestHeader) {
        this.mRequestHeader = requestHeader;
    }

    public void setTaskCompletionSource(com.hihonor.push.sdk.tasks.TaskCompletionSource<TResult> taskCompletionSource) {
        this.mTaskCompletionSource = taskCompletionSource;
    }
}
