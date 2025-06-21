package com.huawei.hms.common;

/* loaded from: classes22.dex */
public class HuaweiApi<TOption extends com.huawei.hms.api.Api.ApiOptions> {
    private static final java.lang.String TAG = "HuaweiApi";
    private java.lang.String innerHmsPkg;
    private boolean isUseInnerHms;
    private java.lang.ref.WeakReference<android.app.Activity> mActivity;
    private java.lang.String mAppID;
    private com.huawei.hms.common.internal.AbstractClientBuilder<?, TOption> mClientBuilder;
    private android.content.Context mContext;
    private java.lang.String mHostAppid;
    private android.content.Context mHostContext;
    private int mKitSdkVersion;
    private TOption mOption;
    private com.huawei.hms.support.api.client.SubAppInfo mSubAppInfo;
    private com.huawei.hms.common.internal.RequestManager requestManager;
    private int apiLevel = 1;
    private boolean isFirstReqSent = false;

    /* renamed from: com.huawei.hms.common.HuaweiApi$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ com.huawei.hms.common.HuaweiApi val$api;
        final /* synthetic */ com.huawei.hmf.tasks.TaskCompletionSource val$taskCompletionSource;

        public AnonymousClass1(com.huawei.hms.common.HuaweiApi huaweiApi, com.huawei.hmf.tasks.TaskCompletionSource taskCompletionSource) {
            this.val$api = huaweiApi;
            this.val$taskCompletionSource = taskCompletionSource;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.huawei.hms.common.HuaweiApi.this.innerDisconnect(this.val$api, this.val$taskCompletionSource);
        }
    }

    public static class RequestHandler<OptionsT extends com.huawei.hms.api.Api.ApiOptions> implements com.huawei.hms.common.internal.BaseHmsClient.ConnectionCallbacks, com.huawei.hms.common.internal.BaseHmsClient.OnConnectionFailedListener {
        private final com.huawei.hms.common.HuaweiApi<OptionsT> mApi;
        private final com.huawei.hms.common.internal.AnyClient mClient;
        private com.huawei.hms.common.internal.ResolveClientBean mResolveClientBean;
        public final java.util.Queue<com.huawei.hms.common.HuaweiApi.TaskApiCallbackWrapper> callbackWaitQueue = new java.util.LinkedList();
        private final java.util.Queue<com.huawei.hms.common.HuaweiApi.TaskApiCallbackWrapper> callbackRunQueue = new java.util.LinkedList();
        private com.huawei.hms.api.ConnectionResult mConnectionResult = null;

        /* renamed from: com.huawei.hms.common.HuaweiApi$RequestHandler$1, reason: invalid class name */
        public class AnonymousClass1 implements com.huawei.hms.common.internal.AnyClient.CallBack {
            private java.util.concurrent.atomic.AtomicBoolean isFirstRsp = new java.util.concurrent.atomic.AtomicBoolean(true);
            final /* synthetic */ com.huawei.hms.common.internal.TaskApiCallWrapper val$req;

            public AnonymousClass1(com.huawei.hms.common.internal.TaskApiCallWrapper taskApiCallWrapper) {
                this.val$req = taskApiCallWrapper;
            }

            @Override // com.huawei.hms.common.internal.AnyClient.CallBack
            public void onCallback(com.huawei.hms.core.aidl.IMessageEntity iMessageEntity, java.lang.String str) {
                if (!(iMessageEntity instanceof com.huawei.hms.common.internal.ResponseHeader)) {
                    com.huawei.hms.support.log.HMSLog.e(com.huawei.hms.common.HuaweiApi.TAG, "header is not instance of ResponseHeader");
                    return;
                }
                com.huawei.hms.common.internal.ResponseHeader responseHeader = (com.huawei.hms.common.internal.ResponseHeader) iMessageEntity;
                if (responseHeader.getErrorCode() == 11) {
                    com.huawei.hms.common.HuaweiApi.RequestHandler.this.disconnect();
                    com.huawei.hms.support.log.HMSLog.i(com.huawei.hms.common.HuaweiApi.TAG, "unbind service");
                }
                if (!android.text.TextUtils.isEmpty(responseHeader.getResolution())) {
                    com.huawei.hms.support.log.HMSLog.e(com.huawei.hms.common.HuaweiApi.TAG, "Response has resolution: " + responseHeader.getResolution());
                }
                if (this.isFirstRsp.compareAndSet(true, false)) {
                    com.huawei.hms.support.hianalytics.b.a(com.huawei.hms.common.HuaweiApi.RequestHandler.this.mApi.getContext(), responseHeader, java.lang.String.valueOf(com.huawei.hms.common.HuaweiApi.RequestHandler.this.mApi.getKitSdkVersion()));
                }
                this.val$req.getTaskApiCall().onResponse(com.huawei.hms.common.HuaweiApi.RequestHandler.this.mClient, responseHeader, str, this.val$req.getTaskCompletionSource());
            }
        }

        /* renamed from: com.huawei.hms.common.HuaweiApi$RequestHandler$2, reason: invalid class name */
        public class AnonymousClass2 implements com.huawei.hms.common.internal.AnyClient.CallBack {
            final /* synthetic */ com.huawei.hms.common.HuaweiApi.TaskApiCallbackWrapper val$callbackWrapper;
            final /* synthetic */ com.huawei.hms.common.internal.RequestHeader val$requestHeader;

            /* renamed from: com.huawei.hms.common.HuaweiApi$RequestHandler$2$1, reason: invalid class name */
            public class AnonymousClass1 implements java.lang.Runnable {
                public AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    com.huawei.hms.common.HuaweiApi.RequestHandler.this.callbackRunQueue.remove(com.huawei.hms.common.HuaweiApi.RequestHandler.AnonymousClass2.this.val$callbackWrapper);
                }
            }

            public AnonymousClass2(com.huawei.hms.common.HuaweiApi.TaskApiCallbackWrapper taskApiCallbackWrapper, com.huawei.hms.common.internal.RequestHeader requestHeader) {
                this.val$callbackWrapper = taskApiCallbackWrapper;
                this.val$requestHeader = requestHeader;
            }

            @Override // com.huawei.hms.common.internal.AnyClient.CallBack
            public void onCallback(com.huawei.hms.core.aidl.IMessageEntity iMessageEntity, java.lang.String str) {
                com.huawei.hms.common.internal.AnyClient.CallBack callBack = this.val$callbackWrapper.getCallBack();
                if (callBack != null) {
                    callBack.onCallback(iMessageEntity, str);
                }
                com.huawei.hms.common.internal.RequestManager.removeReqByTransId(this.val$requestHeader.getTransactionId());
                com.huawei.hms.common.internal.RequestManager.getHandler().post(new com.huawei.hms.common.HuaweiApi.RequestHandler.AnonymousClass2.AnonymousClass1());
            }
        }

        /* renamed from: com.huawei.hms.common.HuaweiApi$RequestHandler$3, reason: invalid class name */
        public class AnonymousClass3 implements java.lang.Runnable {
            final /* synthetic */ com.huawei.hms.api.ConnectionResult val$result;

            public AnonymousClass3(com.huawei.hms.api.ConnectionResult connectionResult) {
                this.val$result = connectionResult;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.huawei.hms.common.HuaweiApi.RequestHandler.this.innerConnectionFailed(this.val$result);
            }
        }

        /* renamed from: com.huawei.hms.common.HuaweiApi$RequestHandler$4, reason: invalid class name */
        public class AnonymousClass4 implements java.lang.Runnable {
            public AnonymousClass4() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.huawei.hms.common.HuaweiApi.RequestHandler.this.innerConnected();
            }
        }

        /* renamed from: com.huawei.hms.common.HuaweiApi$RequestHandler$5, reason: invalid class name */
        public class AnonymousClass5 implements java.lang.Runnable {
            public AnonymousClass5() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.huawei.hms.common.HuaweiApi.RequestHandler.this.innerConnectionSuspended();
            }
        }

        public RequestHandler(com.huawei.hms.common.HuaweiApi<OptionsT> huaweiApi) {
            this.mApi = huaweiApi;
            this.mClient = huaweiApi.getClient(com.huawei.hms.common.internal.RequestManager.getHandler().getLooper(), this);
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0046 A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private java.lang.String errorReason(com.huawei.hms.api.ConnectionResult connectionResult) {
            if (!com.huawei.hms.utils.Util.isAvailableLibExist(this.mApi.getContext())) {
                int errorCode = connectionResult.getErrorCode();
                if (errorCode != -1) {
                    if (errorCode != 8) {
                        if (errorCode == 10) {
                            return "application configuration error, please developer check configuration";
                        }
                    }
                    return "internal error";
                }
                return "get update result, but has other error codes";
            }
            int errorCode2 = connectionResult.getErrorCode();
            if (errorCode2 != -1) {
                if (errorCode2 == 3) {
                    return "HuaWei Mobile Service is disabled";
                }
                if (errorCode2 != 8) {
                    if (errorCode2 != 10) {
                        if (errorCode2 == 13) {
                            return "update cancelled";
                        }
                        if (errorCode2 == 21) {
                            return "device is too old to be support";
                        }
                        switch (errorCode2) {
                            case 25:
                                return "failed to get update result";
                            case 26:
                                return "update failed, because no activity incoming, can't pop update page";
                            case 27:
                                return "there is already an update popup at the front desk, but it hasn't been clicked or it is not effective for a while";
                            default:
                                return "unknown errorReason";
                        }
                    }
                    return "application configuration error, please developer check configuration";
                }
                return "internal error";
            }
            return "get update result, but has other error codes";
        }

        private java.lang.String getTransactionId(java.lang.String str, java.lang.String str2) {
            return android.text.TextUtils.isEmpty(str) ? com.huawei.hms.common.internal.TransactionIdCreater.getId(this.mApi.getAppID(), str2) : str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void innerConnected() {
            this.mConnectionResult = null;
            this.callbackRunQueue.clear();
            java.util.Iterator<com.huawei.hms.common.HuaweiApi.TaskApiCallbackWrapper> it = this.callbackWaitQueue.iterator();
            while (it.hasNext()) {
                postMessage(it.next());
            }
            this.callbackWaitQueue.clear();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void innerConnectionFailed(com.huawei.hms.api.ConnectionResult connectionResult) {
            this.mConnectionResult = connectionResult;
            java.util.Iterator<com.huawei.hms.common.HuaweiApi.TaskApiCallbackWrapper> it = this.callbackWaitQueue.iterator();
            boolean z = true;
            while (it.hasNext()) {
                com.huawei.hms.common.internal.TaskApiCallWrapper apiCallWrapper = it.next().getApiCallWrapper();
                com.huawei.hms.common.internal.ResponseHeader responseHeader = new com.huawei.hms.common.internal.ResponseHeader(1, com.huawei.hms.support.api.entity.core.CommonCode.ErrorCode.CLIENT_API_INVALID, "Connection Failed:" + errorReason(connectionResult) + "(" + connectionResult.getErrorCode() + ")");
                responseHeader.setTransactionId(apiCallWrapper.getTaskApiCall().getTransactionId());
                com.huawei.hms.support.hianalytics.b.a(this.mApi.getContext(), responseHeader, java.lang.String.valueOf(this.mApi.getKitSdkVersion()));
                if (this.mConnectionResult.getResolution() != null && z) {
                    responseHeader.setParcelable(this.mConnectionResult.getResolution());
                    if (com.huawei.hms.utils.Util.isAvailableLibExist(this.mApi.getContext()) && this.mConnectionResult.getErrorCode() == 26) {
                        responseHeader.setResolution(com.huawei.hms.support.api.entity.core.CommonCode.Resolution.HAS_RESOLUTION);
                    }
                    z = false;
                }
                int errorCode = this.mConnectionResult.getErrorCode();
                if (errorCode == 30 || errorCode == 31) {
                    responseHeader.setErrorCode(errorCode);
                }
                apiCallWrapper.getTaskApiCall().onResponse(this.mClient, responseHeader, null, apiCallWrapper.getTaskCompletionSource());
            }
            this.callbackWaitQueue.clear();
            this.callbackRunQueue.clear();
            this.mConnectionResult = null;
            this.mClient.disconnect();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void innerConnectionSuspended() {
            com.huawei.hms.support.log.HMSLog.i(com.huawei.hms.common.HuaweiApi.TAG, "wait queue size = " + this.callbackWaitQueue.size());
            com.huawei.hms.support.log.HMSLog.i(com.huawei.hms.common.HuaweiApi.TAG, "run queue size = " + this.callbackRunQueue.size());
            java.util.Iterator<com.huawei.hms.common.HuaweiApi.TaskApiCallbackWrapper> it = this.callbackWaitQueue.iterator();
            while (it.hasNext()) {
                sendConnectionSuspended(it.next());
            }
            java.util.Iterator<com.huawei.hms.common.HuaweiApi.TaskApiCallbackWrapper> it2 = this.callbackRunQueue.iterator();
            while (it2.hasNext()) {
                sendConnectionSuspended(it2.next());
            }
            this.callbackWaitQueue.clear();
            this.callbackRunQueue.clear();
            this.mConnectionResult = null;
            this.mClient.disconnect();
        }

        private void sendConnectionSuspended(com.huawei.hms.common.HuaweiApi.TaskApiCallbackWrapper taskApiCallbackWrapper) {
            com.huawei.hms.common.internal.TaskApiCallWrapper apiCallWrapper = taskApiCallbackWrapper.getApiCallWrapper();
            com.huawei.hms.common.internal.ResponseHeader responseHeader = new com.huawei.hms.common.internal.ResponseHeader(1, com.huawei.hms.support.api.entity.core.CommonCode.ErrorCode.CLIENT_API_INVALID, "Connection Suspended");
            responseHeader.setTransactionId(apiCallWrapper.getTaskApiCall().getTransactionId());
            apiCallWrapper.getTaskApiCall().onResponse(this.mClient, responseHeader, null, apiCallWrapper.getTaskCompletionSource());
        }

        private com.huawei.hms.common.HuaweiApi.TaskApiCallbackWrapper wrapperRequest(com.huawei.hms.common.internal.TaskApiCallWrapper taskApiCallWrapper) {
            return new com.huawei.hms.common.HuaweiApi.TaskApiCallbackWrapper(taskApiCallWrapper, new com.huawei.hms.common.HuaweiApi.RequestHandler.AnonymousClass1(taskApiCallWrapper));
        }

        public synchronized void connect(int i, com.huawei.hms.common.HuaweiApi.TaskApiCallbackWrapper taskApiCallbackWrapper) {
            if (this.mClient.isConnected()) {
                com.huawei.hms.support.log.HMSLog.d(com.huawei.hms.common.HuaweiApi.TAG, "client is connected");
                return;
            }
            if (this.mClient.isConnecting()) {
                com.huawei.hms.support.log.HMSLog.d(com.huawei.hms.common.HuaweiApi.TAG, "client is isConnecting");
                return;
            }
            if (this.mApi.getActivity() != null) {
                if (this.mResolveClientBean == null) {
                    this.mResolveClientBean = new com.huawei.hms.common.internal.ResolveClientBean(this.mClient, i);
                }
                if (com.huawei.hms.common.internal.BindResolveClients.getInstance().isClientRegistered(this.mResolveClientBean)) {
                    com.huawei.hms.support.log.HMSLog.i(com.huawei.hms.common.HuaweiApi.TAG, "mResolveClientBean has already register, return!");
                    return;
                }
                com.huawei.hms.common.internal.BindResolveClients.getInstance().register(this.mResolveClientBean);
            }
            this.mClient.connect(i);
        }

        public void disconnect() {
            this.mClient.disconnect();
        }

        public com.huawei.hms.common.internal.AnyClient getClient() {
            return this.mClient;
        }

        @Override // com.huawei.hms.common.internal.BaseHmsClient.ConnectionCallbacks
        public void onConnected() {
            com.huawei.hms.support.log.HMSLog.i(com.huawei.hms.common.HuaweiApi.TAG, "onConnected");
            com.huawei.hms.common.internal.BindResolveClients.getInstance().unRegister(this.mResolveClientBean);
            this.mResolveClientBean = null;
            com.huawei.hms.common.internal.RequestManager.getHandler().post(new com.huawei.hms.common.HuaweiApi.RequestHandler.AnonymousClass4());
        }

        @Override // com.huawei.hms.common.internal.BaseHmsClient.OnConnectionFailedListener
        public void onConnectionFailed(com.huawei.hms.api.ConnectionResult connectionResult) {
            com.huawei.hms.support.log.HMSLog.i(com.huawei.hms.common.HuaweiApi.TAG, "onConnectionFailed");
            com.huawei.hms.common.internal.BindResolveClients.getInstance().unRegister(this.mResolveClientBean);
            this.mResolveClientBean = null;
            com.huawei.hms.common.internal.RequestManager.getHandler().post(new com.huawei.hms.common.HuaweiApi.RequestHandler.AnonymousClass3(connectionResult));
        }

        @Override // com.huawei.hms.common.internal.BaseHmsClient.ConnectionCallbacks
        public void onConnectionSuspended(int i) {
            com.huawei.hms.support.log.HMSLog.i(com.huawei.hms.common.HuaweiApi.TAG, "onConnectionSuspended");
            com.huawei.hms.common.internal.BindResolveClients.getInstance().unRegister(this.mResolveClientBean);
            this.mResolveClientBean = null;
            com.huawei.hms.common.internal.RequestManager.getHandler().post(new com.huawei.hms.common.HuaweiApi.RequestHandler.AnonymousClass5());
        }

        public void postMessage(com.huawei.hms.common.HuaweiApi.TaskApiCallbackWrapper taskApiCallbackWrapper) {
            com.huawei.hms.common.internal.RequestManager.addToConnectedReqMap(taskApiCallbackWrapper.getApiCallWrapper().getTaskApiCall().getTransactionId(), this);
            this.callbackRunQueue.add(taskApiCallbackWrapper);
            java.lang.String uri = taskApiCallbackWrapper.getApiCallWrapper().getTaskApiCall().getUri();
            java.lang.String packageName = (((com.huawei.hms.common.HuaweiApi) this.mApi).mHostContext == null ? this.mApi.getContext() : ((com.huawei.hms.common.HuaweiApi) this.mApi).mHostContext).getPackageName();
            if (((com.huawei.hms.common.HuaweiApi) this.mApi).mHostContext != null) {
                com.huawei.hms.common.HuaweiApi<OptionsT> huaweiApi = this.mApi;
                huaweiApi.setHostAppId(((com.huawei.hms.common.HuaweiApi) huaweiApi).mHostContext);
            }
            com.huawei.hms.common.internal.RequestHeader requestHeader = new com.huawei.hms.common.internal.RequestHeader();
            requestHeader.setSrvName(uri.split("\\.")[0]);
            requestHeader.setApiName(uri);
            requestHeader.setAppID(this.mApi.getAppID() + "|" + this.mApi.getSubAppID());
            requestHeader.setPkgName(packageName);
            requestHeader.setSessionId(this.mClient.getSessionId());
            com.huawei.hms.common.internal.TaskApiCall taskApiCall = taskApiCallbackWrapper.getApiCallWrapper().getTaskApiCall();
            requestHeader.setTransactionId(getTransactionId(taskApiCall.getTransactionId(), uri));
            requestHeader.setParcelable(taskApiCall.getParcelable());
            requestHeader.setKitSdkVersion(this.mApi.getKitSdkVersion());
            requestHeader.setApiLevel(java.lang.Math.max(this.mApi.getApiLevel(), taskApiCall.getApiLevel()));
            this.mClient.post(requestHeader, taskApiCall.getRequestJson(), new com.huawei.hms.common.HuaweiApi.RequestHandler.AnonymousClass2(taskApiCallbackWrapper, requestHeader));
        }

        public void sendRequest(com.huawei.hms.common.internal.TaskApiCallWrapper taskApiCallWrapper) {
            com.huawei.hms.support.log.HMSLog.i(com.huawei.hms.common.HuaweiApi.TAG, "sendRequest");
            com.huawei.hms.common.HuaweiApi.TaskApiCallbackWrapper wrapperRequest = wrapperRequest(taskApiCallWrapper);
            if (this.mClient.isConnected()) {
                com.huawei.hms.support.log.HMSLog.i(com.huawei.hms.common.HuaweiApi.TAG, "isConnected:true.");
                com.huawei.hms.adapter.BinderAdapter adapter = ((com.huawei.hms.common.internal.BaseHmsClient) this.mClient).getAdapter();
                adapter.updateDelayTask();
                ((com.huawei.hms.common.internal.HmsClient) this.mClient).setService(com.huawei.hms.core.aidl.IAIDLInvoke.Stub.asInterface(adapter.getServiceBinder()));
                postMessage(wrapperRequest);
                return;
            }
            com.huawei.hms.support.log.HMSLog.i(com.huawei.hms.common.HuaweiApi.TAG, "isConnected:false.");
            this.callbackWaitQueue.add(wrapperRequest);
            com.huawei.hms.api.ConnectionResult connectionResult = this.mConnectionResult;
            if (connectionResult == null || connectionResult.getErrorCode() == 0) {
                com.huawei.hms.common.internal.RequestManager.addRequestToQueue(this);
                java.lang.Object obj = this.mClient;
                if (obj instanceof com.huawei.hms.common.internal.BaseHmsClient) {
                    ((com.huawei.hms.common.internal.BaseHmsClient) obj).setInternalRequest(this);
                }
                connect(taskApiCallWrapper.getTaskApiCall().getMinApkVersion(), wrapperRequest);
                return;
            }
            com.huawei.hms.support.log.HMSLog.i(com.huawei.hms.common.HuaweiApi.TAG, "onConnectionFailed, ErrorCode:" + this.mConnectionResult.getErrorCode());
            onConnectionFailed(this.mConnectionResult);
        }
    }

    public static class RequestRunnable<OptionsT extends com.huawei.hms.api.Api.ApiOptions> implements java.lang.Runnable {
        private final com.huawei.hms.common.HuaweiApi<OptionsT> mApi;
        private final com.huawei.hms.common.internal.TaskApiCallWrapper mTaskApiCallWrapper;

        public RequestRunnable(com.huawei.hms.common.HuaweiApi<OptionsT> huaweiApi, com.huawei.hms.common.internal.TaskApiCallWrapper taskApiCallWrapper) {
            this.mApi = huaweiApi;
            this.mTaskApiCallWrapper = taskApiCallWrapper;
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0056 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0062  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0066  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void notifyCpException(com.huawei.hms.common.HuaweiApi.RequestHandler requestHandler, java.lang.Exception exc) {
            java.lang.RuntimeException e;
            com.huawei.hms.common.internal.AnyClient anyClient;
            java.lang.String str;
            com.huawei.hms.common.internal.ResponseHeader responseHeader;
            com.huawei.hmf.tasks.TaskCompletionSource taskCompletionSource;
            com.huawei.hms.common.internal.TaskApiCall taskApiCall = null;
            try {
                anyClient = requestHandler.getClient();
            } catch (java.lang.RuntimeException e2) {
                e = e2;
                anyClient = null;
            }
            try {
                responseHeader = new com.huawei.hms.common.internal.ResponseHeader(1, com.huawei.hms.support.api.entity.core.CommonCode.ErrorCode.INTERNAL_ERROR, exc.getMessage());
                try {
                    str = new org.json.JSONObject().toString();
                    try {
                        taskCompletionSource = this.mTaskApiCallWrapper.getTaskCompletionSource();
                        try {
                            taskApiCall = this.mTaskApiCallWrapper.getTaskApiCall();
                        } catch (java.lang.RuntimeException e3) {
                            e = e3;
                            com.huawei.hms.support.log.HMSLog.e(com.huawei.hms.common.HuaweiApi.TAG, "<notifyCpException> " + e.getMessage());
                            if ((anyClient != null || responseHeader == null || str == null || taskCompletionSource == null || taskApiCall == null) ? false : true) {
                            }
                        }
                    } catch (java.lang.RuntimeException e4) {
                        e = e4;
                        taskCompletionSource = null;
                    }
                } catch (java.lang.RuntimeException e5) {
                    e = e5;
                    str = null;
                    taskCompletionSource = null;
                }
            } catch (java.lang.RuntimeException e6) {
                e = e6;
                str = null;
                responseHeader = null;
                taskCompletionSource = null;
                com.huawei.hms.support.log.HMSLog.e(com.huawei.hms.common.HuaweiApi.TAG, "<notifyCpException> " + e.getMessage());
                if ((anyClient != null || responseHeader == null || str == null || taskCompletionSource == null || taskApiCall == null) ? false : true) {
                }
            }
            if ((anyClient != null || responseHeader == null || str == null || taskCompletionSource == null || taskApiCall == null) ? false : true) {
                taskApiCall.onResponse(anyClient, responseHeader, str, taskCompletionSource);
            } else {
                com.huawei.hms.support.log.HMSLog.e(com.huawei.hms.common.HuaweiApi.TAG, "<notifyCpException> isNotify is false, Can not notify CP.");
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            com.huawei.hms.common.HuaweiApi.RequestHandler requestHandler = new com.huawei.hms.common.HuaweiApi.RequestHandler(this.mApi);
            try {
                requestHandler.sendRequest(this.mTaskApiCallWrapper);
            } catch (java.lang.RuntimeException e) {
                notifyCpException(requestHandler, e);
            }
        }
    }

    public static class TaskApiCallbackWrapper {
        private final com.huawei.hms.common.internal.TaskApiCallWrapper mApiCallWrapper;
        private final com.huawei.hms.common.internal.AnyClient.CallBack mCallBack;

        public TaskApiCallbackWrapper(com.huawei.hms.common.internal.TaskApiCallWrapper taskApiCallWrapper, com.huawei.hms.common.internal.AnyClient.CallBack callBack) {
            this.mApiCallWrapper = taskApiCallWrapper;
            this.mCallBack = callBack;
        }

        public com.huawei.hms.common.internal.TaskApiCallWrapper getApiCallWrapper() {
            return this.mApiCallWrapper;
        }

        public com.huawei.hms.common.internal.AnyClient.CallBack getCallBack() {
            return this.mCallBack;
        }
    }

    public HuaweiApi(android.app.Activity activity, com.huawei.hms.api.Api<TOption> api, TOption toption, com.huawei.hms.common.internal.AbstractClientBuilder abstractClientBuilder) {
        com.huawei.hms.utils.Checker.checkNonNull(activity, "Null activity is not permitted.");
        this.mActivity = new java.lang.ref.WeakReference<>(activity);
        init(activity, api, toption, abstractClientBuilder, 0, null);
    }

    public HuaweiApi(android.app.Activity activity, com.huawei.hms.api.Api<TOption> api, TOption toption, com.huawei.hms.common.internal.AbstractClientBuilder abstractClientBuilder, int i) {
        com.huawei.hms.utils.Checker.checkNonNull(activity, "Null activity is not permitted.");
        this.mActivity = new java.lang.ref.WeakReference<>(activity);
        init(activity, api, toption, abstractClientBuilder, i, null);
    }

    public HuaweiApi(android.app.Activity activity, com.huawei.hms.api.Api<TOption> api, TOption toption, com.huawei.hms.common.internal.AbstractClientBuilder abstractClientBuilder, int i, java.lang.String str) {
        com.huawei.hms.utils.Checker.checkNonNull(activity, "Null activity is not permitted.");
        this.mActivity = new java.lang.ref.WeakReference<>(activity);
        init(activity, api, toption, abstractClientBuilder, i, str);
    }

    public HuaweiApi(android.content.Context context, com.huawei.hms.api.Api<TOption> api, TOption toption, com.huawei.hms.common.internal.AbstractClientBuilder abstractClientBuilder) {
        com.huawei.hms.utils.Checker.checkNonNull(context, "Null context is not permitted.");
        init(context, api, toption, abstractClientBuilder, 0, null);
    }

    public HuaweiApi(android.content.Context context, com.huawei.hms.api.Api<TOption> api, TOption toption, com.huawei.hms.common.internal.AbstractClientBuilder abstractClientBuilder, int i) {
        com.huawei.hms.utils.Checker.checkNonNull(context, "Null context is not permitted.");
        init(context, api, toption, abstractClientBuilder, i, null);
    }

    public HuaweiApi(android.content.Context context, com.huawei.hms.api.Api<TOption> api, TOption toption, com.huawei.hms.common.internal.AbstractClientBuilder abstractClientBuilder, int i, java.lang.String str) {
        com.huawei.hms.utils.Checker.checkNonNull(context, "Null context is not permitted.");
        init(context, api, toption, abstractClientBuilder, i, str);
    }

    private void init(android.content.Context context, com.huawei.hms.api.Api<TOption> api, TOption toption, com.huawei.hms.common.internal.AbstractClientBuilder abstractClientBuilder, int i, java.lang.String str) {
        this.mContext = context.getApplicationContext();
        this.mOption = toption;
        this.mClientBuilder = abstractClientBuilder;
        setHostAppId(context);
        this.mSubAppInfo = new com.huawei.hms.support.api.client.SubAppInfo("");
        this.mKitSdkVersion = i;
        if (!android.text.TextUtils.isEmpty(str)) {
            if (str.equals(this.mHostAppid)) {
                com.huawei.hms.support.log.HMSLog.e(TAG, "subAppId is host appid");
            } else {
                com.huawei.hms.support.log.HMSLog.i(TAG, "subAppId is " + str);
                this.mSubAppInfo = new com.huawei.hms.support.api.client.SubAppInfo(str);
            }
        }
        initBI(context);
    }

    private void initBI(android.content.Context context) {
        com.huawei.hms.utils.HMSBIInitializer.getInstance(context).initBI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void innerDisconnect(com.huawei.hms.common.HuaweiApi<?> huaweiApi, com.huawei.hmf.tasks.TaskCompletionSource<java.lang.Boolean> taskCompletionSource) {
        com.huawei.hms.support.log.HMSLog.i(TAG, "innerDisconnect.");
        try {
            huaweiApi.getClient(com.huawei.hms.common.internal.RequestManager.getHandler().getLooper(), null).disconnect();
            taskCompletionSource.setResult(java.lang.Boolean.TRUE);
        } catch (java.lang.Exception e) {
            com.huawei.hms.support.log.HMSLog.w(TAG, "disconnect the binder failed for:" + e.getMessage());
        }
    }

    private <TResult, TClient extends com.huawei.hms.common.internal.AnyClient> com.huawei.hmf.tasks.Task<TResult> sendRequest(com.huawei.hms.common.internal.TaskApiCall<TClient, TResult> taskApiCall) {
        com.huawei.hmf.tasks.TaskCompletionSource taskCompletionSource = taskApiCall.getToken() == null ? new com.huawei.hmf.tasks.TaskCompletionSource() : new com.huawei.hmf.tasks.TaskCompletionSource(taskApiCall.getToken());
        com.huawei.hms.common.internal.RequestManager.getHandler().post(new com.huawei.hms.common.HuaweiApi.RequestRunnable(this, new com.huawei.hms.common.internal.TaskApiCallWrapper(taskApiCall, taskCompletionSource)));
        return taskCompletionSource.getTask();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHostAppId(android.content.Context context) {
        java.lang.String appId = com.huawei.hms.utils.Util.getAppId(context);
        this.mHostAppid = appId;
        this.mAppID = appId;
    }

    @java.lang.Deprecated
    public com.huawei.hmf.tasks.Task<java.lang.Boolean> disconnectService() {
        com.huawei.hmf.tasks.TaskCompletionSource taskCompletionSource = new com.huawei.hmf.tasks.TaskCompletionSource();
        com.huawei.hms.common.internal.RequestManager.getInstance();
        com.huawei.hms.common.internal.RequestManager.getHandler().post(new com.huawei.hms.common.HuaweiApi.AnonymousClass1(this, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    public <TResult, TClient extends com.huawei.hms.common.internal.AnyClient> com.huawei.hmf.tasks.Task<TResult> doWrite(com.huawei.hms.common.internal.TaskApiCall<TClient, TResult> taskApiCall) {
        this.isFirstReqSent = true;
        if (taskApiCall == null) {
            com.huawei.hms.support.log.HMSLog.e(TAG, "in doWrite:taskApiCall is null");
            com.huawei.hmf.tasks.TaskCompletionSource taskCompletionSource = new com.huawei.hmf.tasks.TaskCompletionSource();
            taskCompletionSource.setException(new com.huawei.hms.common.ApiException(com.huawei.hms.support.api.client.Status.FAILURE));
            return taskCompletionSource.getTask();
        }
        com.huawei.hms.support.hianalytics.b.a(this.mContext, taskApiCall.getUri(), android.text.TextUtils.isEmpty(this.mSubAppInfo.getSubAppID()) ? this.mAppID : this.mSubAppInfo.getSubAppID(), taskApiCall.getTransactionId(), java.lang.String.valueOf(getKitSdkVersion()));
        if (this.requestManager == null) {
            this.requestManager = com.huawei.hms.common.internal.RequestManager.getInstance();
        }
        return sendRequest(taskApiCall);
    }

    public android.app.Activity getActivity() {
        java.lang.ref.WeakReference<android.app.Activity> weakReference = this.mActivity;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public int getApiLevel() {
        return this.apiLevel;
    }

    public java.lang.String getAppID() {
        return this.mAppID;
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [com.huawei.hms.common.internal.AnyClient] */
    public com.huawei.hms.common.internal.AnyClient getClient(android.os.Looper looper, com.huawei.hms.common.HuaweiApi.RequestHandler requestHandler) {
        return this.mClientBuilder.buildClient(this.mContext, getClientSetting(), requestHandler, requestHandler);
    }

    public com.huawei.hms.common.internal.ClientSettings getClientSetting() {
        com.huawei.hms.common.internal.ClientSettings clientSettings = new com.huawei.hms.common.internal.ClientSettings(this.mContext.getPackageName(), this.mContext.getClass().getName(), getScopes(), this.mHostAppid, null, this.mSubAppInfo);
        if (!this.isUseInnerHms) {
            this.innerHmsPkg = com.huawei.hms.utils.HMSPackageManager.getInstance(this.mContext).getHMSPackageNameForMultiService();
            com.huawei.hms.support.log.HMSLog.i(TAG, "No setInnerHms, hms pkg name is " + this.innerHmsPkg);
        }
        clientSettings.setInnerHmsPkg(this.innerHmsPkg);
        clientSettings.setUseInnerHms(this.isUseInnerHms);
        java.lang.ref.WeakReference<android.app.Activity> weakReference = this.mActivity;
        if (weakReference != null) {
            clientSettings.setCpActivity(weakReference.get());
        }
        return clientSettings;
    }

    public android.content.Context getContext() {
        return this.mContext;
    }

    public int getKitSdkVersion() {
        return this.mKitSdkVersion;
    }

    public TOption getOption() {
        return this.mOption;
    }

    public java.util.List<com.huawei.hms.support.api.entity.auth.Scope> getScopes() {
        return java.util.Collections.emptyList();
    }

    public java.lang.String getSubAppID() {
        return this.mSubAppInfo.getSubAppID();
    }

    public void setApiLevel(int i) {
        this.apiLevel = i;
    }

    public void setHostContext(android.content.Context context) {
        this.mHostContext = context;
    }

    public void setInnerHms() {
        this.innerHmsPkg = this.mContext.getPackageName();
        this.isUseInnerHms = true;
        com.huawei.hms.support.log.HMSLog.i(TAG, "<setInnerHms> init inner hms pkg info:" + this.innerHmsPkg);
    }

    public void setKitSdkVersion(int i) {
        this.mKitSdkVersion = i;
    }

    public void setSubAppId(java.lang.String str) throws com.huawei.hms.common.ApiException {
        if (!setSubAppInfo(new com.huawei.hms.support.api.client.SubAppInfo(str))) {
            throw new com.huawei.hms.common.ApiException(com.huawei.hms.support.api.client.Status.FAILURE);
        }
    }

    @java.lang.Deprecated
    public boolean setSubAppInfo(com.huawei.hms.support.api.client.SubAppInfo subAppInfo) {
        com.huawei.hms.support.log.HMSLog.i(TAG, "Enter setSubAppInfo");
        com.huawei.hms.support.api.client.SubAppInfo subAppInfo2 = this.mSubAppInfo;
        if (subAppInfo2 != null && !android.text.TextUtils.isEmpty(subAppInfo2.getSubAppID())) {
            com.huawei.hms.support.log.HMSLog.e(TAG, "subAppInfo is already set");
            return false;
        }
        if (subAppInfo == null) {
            com.huawei.hms.support.log.HMSLog.e(TAG, "subAppInfo is null");
            return false;
        }
        java.lang.String subAppID = subAppInfo.getSubAppID();
        if (android.text.TextUtils.isEmpty(subAppID)) {
            com.huawei.hms.support.log.HMSLog.e(TAG, "subAppId is empty");
            return false;
        }
        if (subAppID.equals(this.mHostAppid)) {
            com.huawei.hms.support.log.HMSLog.e(TAG, "subAppId is host appid");
            return false;
        }
        if (this.isFirstReqSent) {
            com.huawei.hms.support.log.HMSLog.e(TAG, "Client has sent request to Huawei Mobile Services, setting subAppId is not allowed");
            return false;
        }
        this.mSubAppInfo = new com.huawei.hms.support.api.client.SubAppInfo(subAppInfo);
        return true;
    }
}
