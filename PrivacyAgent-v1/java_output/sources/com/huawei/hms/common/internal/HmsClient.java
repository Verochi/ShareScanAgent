package com.huawei.hms.common.internal;

/* loaded from: classes22.dex */
public abstract class HmsClient extends com.huawei.hms.common.internal.BaseHmsClient implements com.huawei.hms.common.internal.AnyClient {
    private static final java.lang.String TAG = "HmsClient";

    public static class BaseAdapterCallBack implements com.huawei.hms.adapter.BaseAdapter.BaseCallBack {
        private final com.huawei.hms.common.internal.AnyClient.CallBack callback;
        private final java.lang.ref.WeakReference<com.huawei.hms.common.internal.HmsClient> hmsClient;

        public BaseAdapterCallBack(com.huawei.hms.common.internal.HmsClient hmsClient, com.huawei.hms.common.internal.AnyClient.CallBack callBack) {
            this.callback = callBack;
            this.hmsClient = new java.lang.ref.WeakReference<>(hmsClient);
        }

        private void doCallback(java.lang.String str, java.lang.String str2) {
            com.huawei.hms.common.internal.ResponseHeader responseHeader = new com.huawei.hms.common.internal.ResponseHeader();
            if (!responseHeader.fromJson(str)) {
                this.callback.onCallback(new com.huawei.hms.common.internal.ResponseHeader(1, com.huawei.hms.support.api.entity.core.CommonCode.ErrorCode.ARGUMENTS_INVALID, "response header json error"), new org.json.JSONObject().toString());
                return;
            }
            com.huawei.hms.support.log.HMSLog.i(com.huawei.hms.common.internal.HmsClient.TAG, "receive msg " + responseHeader);
            updateSessionId(responseHeader.getSessionId());
            this.callback.onCallback(responseHeader, str2);
        }

        private void doCallback(java.lang.String str, java.lang.String str2, android.os.Parcelable parcelable) {
            com.huawei.hms.common.internal.ResponseHeader responseHeader = new com.huawei.hms.common.internal.ResponseHeader();
            if (!responseHeader.fromJson(str)) {
                this.callback.onCallback(new com.huawei.hms.common.internal.ResponseHeader(1, com.huawei.hms.support.api.entity.core.CommonCode.ErrorCode.ARGUMENTS_INVALID, "response header json error"), new org.json.JSONObject().toString());
                return;
            }
            responseHeader.setParcelable(parcelable);
            com.huawei.hms.support.log.HMSLog.i(com.huawei.hms.common.internal.HmsClient.TAG, "receive msg " + responseHeader);
            updateSessionId(responseHeader.getSessionId());
            this.callback.onCallback(responseHeader, str2);
        }

        private void updateSessionId(java.lang.String str) {
            com.huawei.hms.common.internal.HmsClient hmsClient = this.hmsClient.get();
            if (hmsClient != null) {
                hmsClient.updateSessionId(str);
            }
        }

        @Override // com.huawei.hms.adapter.BaseAdapter.BaseCallBack
        public void onComplete(java.lang.String str, java.lang.String str2, android.os.Parcelable parcelable) {
            if (parcelable == null) {
                doCallback(str, str2);
            } else {
                doCallback(str, str2, parcelable);
            }
        }

        @Override // com.huawei.hms.adapter.BaseAdapter.BaseCallBack
        public void onError(java.lang.String str) {
            com.huawei.hms.common.internal.ResponseWrap responseWrap = new com.huawei.hms.common.internal.ResponseWrap(new com.huawei.hms.common.internal.ResponseHeader());
            if (!responseWrap.fromJson(str)) {
                this.callback.onCallback(new com.huawei.hms.common.internal.ResponseHeader(1, com.huawei.hms.support.api.entity.core.CommonCode.ErrorCode.ARGUMENTS_INVALID, "response header json error"), new org.json.JSONObject().toString());
                return;
            }
            com.huawei.hms.support.log.HMSLog.i(com.huawei.hms.common.internal.HmsClient.TAG, "receive msg " + responseWrap);
            com.huawei.hms.common.internal.ResponseHeader responseHeader = responseWrap.getResponseHeader();
            updateSessionId(responseHeader.getSessionId());
            this.callback.onCallback(responseHeader, responseWrap.getBody());
        }
    }

    public HmsClient(android.content.Context context, com.huawei.hms.common.internal.ClientSettings clientSettings, com.huawei.hms.common.internal.BaseHmsClient.OnConnectionFailedListener onConnectionFailedListener, com.huawei.hms.common.internal.BaseHmsClient.ConnectionCallbacks connectionCallbacks) {
        super(context, clientSettings, onConnectionFailedListener, connectionCallbacks);
    }

    @Override // com.huawei.hms.common.internal.AnyClient
    public void post(com.huawei.hms.core.aidl.IMessageEntity iMessageEntity, java.lang.String str, com.huawei.hms.common.internal.AnyClient.CallBack callBack) {
        if (callBack == null) {
            com.huawei.hms.support.log.HMSLog.e(TAG, "callback is invalid, discard.");
            return;
        }
        if (!(iMessageEntity instanceof com.huawei.hms.common.internal.RequestHeader) || str == null) {
            com.huawei.hms.support.log.HMSLog.e(TAG, "arguments is invalid.");
            callBack.onCallback(new com.huawei.hms.common.internal.ResponseHeader(1, com.huawei.hms.support.api.entity.core.CommonCode.ErrorCode.ARGUMENTS_INVALID, "Args is invalid"), new org.json.JSONObject().toString());
            return;
        }
        if (!isConnected()) {
            com.huawei.hms.support.log.HMSLog.i(TAG, "No connection now, the connection status:" + getConnectionStatus());
            if (getConnectionStatus() != 6) {
                com.huawei.hms.support.log.HMSLog.e(TAG, "post failed for not connected.");
                callBack.onCallback(new com.huawei.hms.common.internal.ResponseHeader(1, com.huawei.hms.support.api.entity.core.CommonCode.ErrorCode.INTERNAL_ERROR, "Not Connected"), new org.json.JSONObject().toString());
                return;
            } else {
                com.huawei.hms.support.log.HMSLog.i(TAG, "in timeout-disconnect status, need to bind again.");
                bindCoreService();
            }
        }
        com.huawei.hms.common.internal.RequestHeader requestHeader = (com.huawei.hms.common.internal.RequestHeader) iMessageEntity;
        com.huawei.hms.support.log.HMSLog.i(TAG, "post msg " + requestHeader);
        android.app.Activity cpActivity = getClientSettings().getCpActivity();
        boolean z = cpActivity == null;
        if (z) {
            com.huawei.hms.support.log.HMSLog.i(TAG, "Activity is null for " + getClientSettings().getAppID());
        }
        (z ? new com.huawei.hms.adapter.BaseAdapter(this) : new com.huawei.hms.adapter.BaseAdapter(this, cpActivity)).baseRequest(requestHeader.toJson(), str, requestHeader.getParcelable(), new com.huawei.hms.common.internal.HmsClient.BaseAdapterCallBack(this, callBack));
    }

    public void updateSessionId(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(this.sessionId)) {
            this.sessionId = str;
        }
    }
}
