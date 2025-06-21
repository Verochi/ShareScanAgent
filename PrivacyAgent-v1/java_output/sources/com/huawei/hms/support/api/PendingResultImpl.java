package com.huawei.hms.support.api;

/* loaded from: classes22.dex */
public abstract class PendingResultImpl<R extends com.huawei.hms.support.api.client.Result, T extends com.huawei.hms.core.aidl.IMessageEntity> extends com.huawei.hms.support.api.client.InnerPendingResult<R> {
    private static final java.lang.String TAG = "PendingResultImpl";
    private java.lang.ref.WeakReference<com.huawei.hms.support.api.client.ApiClient> api;
    private java.util.concurrent.CountDownLatch countLatch;
    protected com.huawei.hms.support.api.transport.DatagramTransport transport = null;
    private R result = null;
    private java.lang.String url = null;
    private java.lang.String transId = null;
    private boolean isNeedReport = true;

    public class a implements com.huawei.hms.support.api.transport.DatagramTransport.a {
        public a() {
        }

        @Override // com.huawei.hms.support.api.transport.DatagramTransport.a
        public void a(int i, com.huawei.hms.core.aidl.IMessageEntity iMessageEntity) {
            com.huawei.hms.support.api.PendingResultImpl.this.setResult(i, iMessageEntity);
            com.huawei.hms.support.api.PendingResultImpl.this.countLatch.countDown();
        }
    }

    public class b implements com.huawei.hms.support.api.transport.DatagramTransport.a {
        final /* synthetic */ java.util.concurrent.atomic.AtomicBoolean a;

        public b(java.util.concurrent.atomic.AtomicBoolean atomicBoolean) {
            this.a = atomicBoolean;
        }

        @Override // com.huawei.hms.support.api.transport.DatagramTransport.a
        public void a(int i, com.huawei.hms.core.aidl.IMessageEntity iMessageEntity) {
            if (!this.a.get()) {
                com.huawei.hms.support.api.PendingResultImpl.this.setResult(i, iMessageEntity);
            }
            com.huawei.hms.support.api.PendingResultImpl.this.countLatch.countDown();
        }
    }

    public class c implements com.huawei.hms.support.api.transport.DatagramTransport.a {
        final /* synthetic */ com.huawei.hms.support.api.PendingResultImpl.d a;
        final /* synthetic */ com.huawei.hms.support.api.client.ResultCallback b;

        public c(com.huawei.hms.support.api.PendingResultImpl.d dVar, com.huawei.hms.support.api.client.ResultCallback resultCallback) {
            this.a = dVar;
            this.b = resultCallback;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.huawei.hms.support.api.transport.DatagramTransport.a
        public void a(int i, com.huawei.hms.core.aidl.IMessageEntity iMessageEntity) {
            com.huawei.hms.support.api.PendingResultImpl.this.setResult(i, iMessageEntity);
            this.a.a(this.b, com.huawei.hms.support.api.PendingResultImpl.this.result);
        }
    }

    public static class d<R extends com.huawei.hms.support.api.client.Result> extends android.os.Handler {
        public d(android.os.Looper looper) {
            super(looper);
        }

        public void a(com.huawei.hms.support.api.client.ResultCallback<? super R> resultCallback, R r) {
            sendMessage(obtainMessage(1, new android.util.Pair(resultCallback, r)));
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void b(com.huawei.hms.support.api.client.ResultCallback<? super R> resultCallback, R r) {
            resultCallback.onResult(r);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            if (message.what != 1) {
                return;
            }
            android.util.Pair pair = (android.util.Pair) message.obj;
            b((com.huawei.hms.support.api.client.ResultCallback) pair.first, (com.huawei.hms.support.api.client.Result) pair.second);
        }
    }

    public PendingResultImpl(com.huawei.hms.support.api.client.ApiClient apiClient, java.lang.String str, com.huawei.hms.core.aidl.IMessageEntity iMessageEntity) {
        init(apiClient, str, iMessageEntity, getResponseType(), 0);
    }

    public PendingResultImpl(com.huawei.hms.support.api.client.ApiClient apiClient, java.lang.String str, com.huawei.hms.core.aidl.IMessageEntity iMessageEntity, int i) {
        init(apiClient, str, iMessageEntity, getResponseType(), i);
    }

    public PendingResultImpl(com.huawei.hms.support.api.client.ApiClient apiClient, java.lang.String str, com.huawei.hms.core.aidl.IMessageEntity iMessageEntity, java.lang.Class<T> cls) {
        init(apiClient, str, iMessageEntity, cls, 0);
    }

    private void biReportEvent(int i, int i2) {
        com.huawei.hms.support.api.client.SubAppInfo subAppInfo;
        com.huawei.hms.support.log.HMSLog.i(TAG, "biReportEvent ====== ");
        com.huawei.hms.support.api.client.ApiClient apiClient = this.api.get();
        if (apiClient == null || this.url == null || com.huawei.hms.support.hianalytics.HiAnalyticsUtil.getInstance().hasError(apiClient.getContext())) {
            return;
        }
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put("package", apiClient.getPackageName());
        hashMap.put(com.huawei.hms.support.hianalytics.HiAnalyticsConstant.HaKey.BI_KEY_BASE_VERSION, "6.5.0.300");
        if (i2 == 1) {
            hashMap.put(com.huawei.hms.support.hianalytics.HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, com.huawei.hms.support.hianalytics.HiAnalyticsConstant.Direction.REQUEST);
        } else {
            hashMap.put(com.huawei.hms.support.hianalytics.HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, com.huawei.hms.support.hianalytics.HiAnalyticsConstant.Direction.RESPONSE);
            hashMap.put("result", java.lang.String.valueOf(i));
            R r = this.result;
            if (r != null && r.getStatus() != null) {
                hashMap.put(com.huawei.hms.support.hianalytics.HiAnalyticsConstant.HaKey.BI_KEY_RESULT, java.lang.String.valueOf(this.result.getStatus().getStatusCode()));
            }
        }
        hashMap.put("version", "0");
        java.lang.String appId = com.huawei.hms.utils.Util.getAppId(apiClient.getContext());
        if (android.text.TextUtils.isEmpty(appId) && (subAppInfo = apiClient.getSubAppInfo()) != null) {
            appId = subAppInfo.getSubAppID();
        }
        hashMap.put("appid", appId);
        if (android.text.TextUtils.isEmpty(this.transId)) {
            java.lang.String id = com.huawei.hms.common.internal.TransactionIdCreater.getId(appId, this.url);
            this.transId = id;
            hashMap.put("transId", id);
        } else {
            hashMap.put("transId", this.transId);
            this.transId = null;
        }
        java.lang.String[] split = this.url.split("\\.");
        if (split.length >= 2) {
            hashMap.put("service", split[0]);
            hashMap.put("apiName", split[1]);
        }
        hashMap.put("callTime", java.lang.String.valueOf(java.lang.System.currentTimeMillis()));
        hashMap.put(com.huawei.hms.support.hianalytics.HiAnalyticsConstant.HaKey.BI_KEY_PHONETYPE, com.huawei.hms.utils.Util.getSystemProperties("ro.logsystem.usertype", ""));
        com.huawei.hms.support.hianalytics.HiAnalyticsUtil.getInstance().onEvent(apiClient.getContext(), com.huawei.hms.support.hianalytics.HiAnalyticsConstant.HMS_SDK_BASE_CALL_AIDL, hashMap);
    }

    private void init(com.huawei.hms.support.api.client.ApiClient apiClient, java.lang.String str, com.huawei.hms.core.aidl.IMessageEntity iMessageEntity, java.lang.Class<T> cls, int i) {
        com.huawei.hms.support.log.HMSLog.i(TAG, "init uri:" + str);
        this.url = str;
        if (apiClient == null) {
            com.huawei.hms.support.log.HMSLog.e(TAG, "client is null");
            return;
        }
        this.api = new java.lang.ref.WeakReference<>(apiClient);
        this.countLatch = new java.util.concurrent.CountDownLatch(1);
        try {
            this.transport = (com.huawei.hms.support.api.transport.DatagramTransport) java.lang.Class.forName(apiClient.getTransportName()).getConstructor(java.lang.String.class, com.huawei.hms.core.aidl.IMessageEntity.class, java.lang.Class.class, java.lang.Integer.TYPE).newInstance(str, iMessageEntity, cls, java.lang.Integer.valueOf(i));
        } catch (java.lang.ClassNotFoundException | java.lang.IllegalAccessException | java.lang.IllegalArgumentException | java.lang.InstantiationException | java.lang.NoSuchMethodException | java.lang.reflect.InvocationTargetException e) {
            com.huawei.hms.support.log.HMSLog.e(TAG, "gen transport error:" + e.getMessage());
            throw new java.lang.IllegalStateException("Instancing transport exception, " + e.getMessage(), e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void setResult(int i, com.huawei.hms.core.aidl.IMessageEntity iMessageEntity) {
        com.huawei.hms.support.api.client.Status status;
        com.huawei.hms.support.log.HMSLog.i(TAG, "setResult:" + i);
        com.huawei.hms.support.api.client.Status commonStatus = iMessageEntity instanceof com.huawei.hms.core.aidl.AbstractMessageEntity ? ((com.huawei.hms.core.aidl.AbstractMessageEntity) iMessageEntity).getCommonStatus() : null;
        if (i == 0) {
            this.result = onComplete(iMessageEntity);
        } else {
            this.result = onError(i);
        }
        if (this.isNeedReport) {
            biReportEvent(i, 2);
        }
        R r = this.result;
        if (r == null || (status = r.getStatus()) == null || commonStatus == null) {
            return;
        }
        int statusCode = status.getStatusCode();
        java.lang.String statusMessage = status.getStatusMessage();
        int statusCode2 = commonStatus.getStatusCode();
        java.lang.String statusMessage2 = commonStatus.getStatusMessage();
        if (statusCode == statusCode2) {
            if (!android.text.TextUtils.isEmpty(statusMessage) || android.text.TextUtils.isEmpty(statusMessage2)) {
                return;
            }
            com.huawei.hms.support.log.HMSLog.i(TAG, "rstStatus msg (" + statusMessage + ") is not equal commonStatus msg (" + statusMessage2 + ")");
            this.result.setStatus(new com.huawei.hms.support.api.client.Status(statusCode, statusMessage2, status.getResolution()));
            return;
        }
        com.huawei.hms.support.log.HMSLog.e(TAG, "rstStatus code (" + statusCode + ") is not equal commonStatus code (" + statusCode2 + ")");
        com.huawei.hms.support.log.HMSLog.e(TAG, "rstStatus msg (" + statusMessage + ") is not equal commonStatus msg (" + statusMessage2 + ")");
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public final R await() {
        com.huawei.hms.support.log.HMSLog.i(TAG, "await");
        if (android.os.Looper.myLooper() != android.os.Looper.getMainLooper()) {
            return awaitOnAnyThread();
        }
        com.huawei.hms.support.log.HMSLog.e(TAG, "await in main thread");
        throw new java.lang.IllegalStateException("await must not be called on the UI thread");
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public R await(long j, java.util.concurrent.TimeUnit timeUnit) {
        com.huawei.hms.support.log.HMSLog.i(TAG, "await timeout:" + j + " unit:" + timeUnit.toString());
        if (android.os.Looper.myLooper() != android.os.Looper.getMainLooper()) {
            return awaitOnAnyThread(j, timeUnit);
        }
        com.huawei.hms.support.log.HMSLog.i(TAG, "await in main thread");
        throw new java.lang.IllegalStateException("await must not be called on the UI thread");
    }

    @Override // com.huawei.hms.support.api.client.InnerPendingResult
    public final R awaitOnAnyThread() {
        com.huawei.hms.support.log.HMSLog.i(TAG, "awaitOnAnyThread");
        java.lang.ref.WeakReference<com.huawei.hms.support.api.client.ApiClient> weakReference = this.api;
        if (weakReference == null) {
            com.huawei.hms.support.log.HMSLog.e(TAG, "api is null");
            setResult(com.huawei.hms.support.api.entity.core.CommonCode.ErrorCode.CLIENT_API_INVALID, null);
            return this.result;
        }
        com.huawei.hms.support.api.client.ApiClient apiClient = weakReference.get();
        if (!checkApiClient(apiClient)) {
            com.huawei.hms.support.log.HMSLog.e(TAG, "client invalid");
            setResult(com.huawei.hms.support.api.entity.core.CommonCode.ErrorCode.CLIENT_API_INVALID, null);
            return this.result;
        }
        if (this.isNeedReport) {
            biReportEvent(0, 1);
        }
        this.transport.send(apiClient, new com.huawei.hms.support.api.PendingResultImpl.a());
        try {
            this.countLatch.await();
        } catch (java.lang.InterruptedException unused) {
            com.huawei.hms.support.log.HMSLog.e(TAG, "await in anythread InterruptedException");
            setResult(com.huawei.hms.support.api.entity.core.CommonCode.ErrorCode.INTERNAL_ERROR, null);
        }
        return this.result;
    }

    @Override // com.huawei.hms.support.api.client.InnerPendingResult
    public final R awaitOnAnyThread(long j, java.util.concurrent.TimeUnit timeUnit) {
        com.huawei.hms.support.log.HMSLog.i(TAG, "awaitOnAnyThread timeout:" + j + " unit:" + timeUnit.toString());
        java.lang.ref.WeakReference<com.huawei.hms.support.api.client.ApiClient> weakReference = this.api;
        if (weakReference == null) {
            com.huawei.hms.support.log.HMSLog.e(TAG, "api is null");
            setResult(com.huawei.hms.support.api.entity.core.CommonCode.ErrorCode.CLIENT_API_INVALID, null);
            return this.result;
        }
        com.huawei.hms.support.api.client.ApiClient apiClient = weakReference.get();
        if (!checkApiClient(apiClient)) {
            com.huawei.hms.support.log.HMSLog.e(TAG, "client invalid");
            setResult(com.huawei.hms.support.api.entity.core.CommonCode.ErrorCode.CLIENT_API_INVALID, null);
            return this.result;
        }
        java.util.concurrent.atomic.AtomicBoolean atomicBoolean = new java.util.concurrent.atomic.AtomicBoolean();
        if (this.isNeedReport) {
            biReportEvent(0, 1);
        }
        this.transport.post(apiClient, new com.huawei.hms.support.api.PendingResultImpl.b(atomicBoolean));
        try {
            if (!this.countLatch.await(j, timeUnit)) {
                atomicBoolean.set(true);
                setResult(com.huawei.hms.support.api.entity.core.CommonCode.ErrorCode.EXECUTE_TIMEOUT, null);
            }
        } catch (java.lang.InterruptedException unused) {
            com.huawei.hms.support.log.HMSLog.e(TAG, "awaitOnAnyThread InterruptedException");
            setResult(com.huawei.hms.support.api.entity.core.CommonCode.ErrorCode.INTERNAL_ERROR, null);
        }
        return this.result;
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    @java.lang.Deprecated
    public void cancel() {
    }

    public boolean checkApiClient(com.huawei.hms.support.api.client.ApiClient apiClient) {
        return true;
    }

    public java.lang.Class<T> getResponseType() {
        java.lang.reflect.Type type;
        java.lang.reflect.Type genericSuperclass = getClass().getGenericSuperclass();
        if (genericSuperclass == null || (type = ((java.lang.reflect.ParameterizedType) genericSuperclass).getActualTypeArguments()[1]) == null) {
            return null;
        }
        return (java.lang.Class) type;
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    @java.lang.Deprecated
    public boolean isCanceled() {
        return false;
    }

    public abstract R onComplete(T t);

    public R onError(int i) {
        java.lang.reflect.Type genericSuperclass = getClass().getGenericSuperclass();
        java.lang.reflect.Type type = genericSuperclass != null ? ((java.lang.reflect.ParameterizedType) genericSuperclass).getActualTypeArguments()[0] : null;
        java.lang.Class<?> type2 = type != null ? com.huawei.hms.support.gentyref.GenericTypeReflector.getType(type) : null;
        if (type2 != null) {
            try {
                R r = (R) type2.newInstance();
                this.result = r;
                r.setStatus(new com.huawei.hms.support.api.client.Status(i));
            } catch (java.lang.Exception e) {
                com.huawei.hms.support.log.HMSLog.e(TAG, "on Error:" + e.getMessage());
                return null;
            }
        }
        return this.result;
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public final void setResultCallback(android.os.Looper looper, com.huawei.hms.support.api.client.ResultCallback<R> resultCallback) {
        com.huawei.hms.support.log.HMSLog.i(TAG, "setResultCallback");
        if (looper == null) {
            looper = android.os.Looper.myLooper();
        }
        com.huawei.hms.support.api.PendingResultImpl.d dVar = new com.huawei.hms.support.api.PendingResultImpl.d(looper);
        java.lang.ref.WeakReference<com.huawei.hms.support.api.client.ApiClient> weakReference = this.api;
        if (weakReference == null) {
            com.huawei.hms.support.log.HMSLog.e(TAG, "api is null");
            setResult(com.huawei.hms.support.api.entity.core.CommonCode.ErrorCode.CLIENT_API_INVALID, null);
            return;
        }
        com.huawei.hms.support.api.client.ApiClient apiClient = weakReference.get();
        if (checkApiClient(apiClient)) {
            if (this.isNeedReport) {
                biReportEvent(0, 1);
            }
            this.transport.post(apiClient, new com.huawei.hms.support.api.PendingResultImpl.c(dVar, resultCallback));
        } else {
            com.huawei.hms.support.log.HMSLog.e(TAG, "client is invalid");
            setResult(com.huawei.hms.support.api.entity.core.CommonCode.ErrorCode.CLIENT_API_INVALID, null);
            dVar.a(resultCallback, this.result);
        }
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public void setResultCallback(com.huawei.hms.support.api.client.ResultCallback<R> resultCallback) {
        this.isNeedReport = !(resultCallback instanceof com.huawei.hms.adapter.BaseAdapter.BaseRequestResultCallback);
        setResultCallback(android.os.Looper.getMainLooper(), resultCallback);
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    @java.lang.Deprecated
    public void setResultCallback(com.huawei.hms.support.api.client.ResultCallback<R> resultCallback, long j, java.util.concurrent.TimeUnit timeUnit) {
        setResultCallback(resultCallback);
    }
}
