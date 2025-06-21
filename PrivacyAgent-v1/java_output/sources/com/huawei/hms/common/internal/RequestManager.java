package com.huawei.hms.common.internal;

/* loaded from: classes22.dex */
public class RequestManager implements android.os.Handler.Callback {
    public static final int NOTIFY_CONNECT_FAILED = 10012;
    public static final int NOTIFY_CONNECT_SUCCESS = 10011;
    public static final int NOTIFY_CONNECT_SUSPENDED = 10013;
    private static final java.lang.String TAG = "RequestManager";
    private static android.os.Handler mHandler;
    private static volatile com.huawei.hms.common.internal.RequestManager mInstance;
    private static final java.lang.Object LOCK_OBJECT = new java.lang.Object();
    private static java.util.Queue<com.huawei.hms.common.HuaweiApi.RequestHandler> requestQueue = new java.util.concurrent.ConcurrentLinkedQueue();
    private static java.util.Map<java.lang.String, com.huawei.hms.common.HuaweiApi.RequestHandler> connectedReqMap = new java.util.LinkedHashMap();

    /* renamed from: com.huawei.hms.common.internal.RequestManager$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ com.huawei.hms.common.HuaweiApi.RequestHandler val$requestHandler;
        final /* synthetic */ java.lang.String val$transId;

        public AnonymousClass1(java.lang.String str, com.huawei.hms.common.HuaweiApi.RequestHandler requestHandler) {
            this.val$transId = str;
            this.val$requestHandler = requestHandler;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.huawei.hms.common.internal.RequestManager.connectedReqMap.put(this.val$transId, this.val$requestHandler);
        }
    }

    /* renamed from: com.huawei.hms.common.internal.RequestManager$2, reason: invalid class name */
    public static class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String val$transId;

        public AnonymousClass2(java.lang.String str) {
            this.val$transId = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.huawei.hms.common.internal.RequestManager.connectedReqMap.remove(this.val$transId);
        }
    }

    private RequestManager(android.os.Looper looper) {
        mHandler = new android.os.Handler(looper, this);
    }

    public static void addRequestToQueue(com.huawei.hms.common.HuaweiApi.RequestHandler requestHandler) {
        requestQueue.add(requestHandler);
    }

    public static void addToConnectedReqMap(java.lang.String str, com.huawei.hms.common.HuaweiApi.RequestHandler requestHandler) {
        if (mHandler == null) {
            return;
        }
        com.huawei.hms.support.log.HMSLog.i(TAG, "addToConnectedReqMap");
        mHandler.post(new com.huawei.hms.common.internal.RequestManager.AnonymousClass1(str, requestHandler));
    }

    public static android.os.Handler getHandler() {
        return mHandler;
    }

    public static com.huawei.hms.common.internal.RequestManager getInstance() {
        synchronized (LOCK_OBJECT) {
            if (mInstance == null) {
                android.os.HandlerThread handlerThread = new android.os.HandlerThread(TAG);
                handlerThread.start();
                mInstance = new com.huawei.hms.common.internal.RequestManager(handlerThread.getLooper());
            }
        }
        return mInstance;
    }

    private void handleConnectFailed(android.os.Message message) {
        com.huawei.hms.support.log.HMSLog.i(TAG, "NOTIFY_CONNECT_FAILED.");
        try {
            com.huawei.hms.common.internal.BaseHmsClient.ConnectionResultWrapper connectionResultWrapper = (com.huawei.hms.common.internal.BaseHmsClient.ConnectionResultWrapper) message.obj;
            com.huawei.hms.common.HuaweiApi.RequestHandler request = connectionResultWrapper.getRequest();
            requestQueue.remove(request);
            request.onConnectionFailed(connectionResultWrapper.getConnectionResult());
        } catch (java.lang.RuntimeException e) {
            com.huawei.hms.support.log.HMSLog.e(TAG, "<handleConnectFailed> handle Failed" + e.getMessage());
        }
    }

    private void handleConnectSuccess() {
        while (!requestQueue.isEmpty()) {
            com.huawei.hms.common.HuaweiApi.RequestHandler poll = requestQueue.poll();
            if (poll != null) {
                java.lang.Object client = poll.getClient();
                if (client instanceof com.huawei.hms.common.internal.BaseHmsClient) {
                    com.huawei.hms.common.internal.BaseHmsClient baseHmsClient = (com.huawei.hms.common.internal.BaseHmsClient) client;
                    baseHmsClient.setService(com.huawei.hms.core.aidl.IAIDLInvoke.Stub.asInterface(baseHmsClient.getAdapter().getServiceBinder()));
                    poll.onConnected();
                }
            }
        }
    }

    private void handleConnectSuspend() {
        com.huawei.hms.support.log.HMSLog.i(TAG, "NOTIFY_CONNECT_SUSPENDED.");
        while (!requestQueue.isEmpty()) {
            requestQueue.poll().onConnectionSuspended(1);
        }
        notifyRunningRequestConnectSuspend();
    }

    private void notifyRunningRequestConnectSuspend() {
        com.huawei.hms.support.log.HMSLog.i(TAG, "notifyRunningRequestConnectSuspend, connectedReqMap.size(): " + connectedReqMap.size());
        java.util.Iterator<java.util.Map.Entry<java.lang.String, com.huawei.hms.common.HuaweiApi.RequestHandler>> it = connectedReqMap.entrySet().iterator();
        while (it.hasNext()) {
            try {
                it.next().getValue().onConnectionSuspended(1);
            } catch (java.lang.RuntimeException e) {
                com.huawei.hms.support.log.HMSLog.e(TAG, "NOTIFY_CONNECT_SUSPENDED Exception: " + e.getMessage());
            }
            it.remove();
        }
    }

    public static void removeReqByTransId(java.lang.String str) {
        if (mHandler == null) {
            return;
        }
        com.huawei.hms.support.log.HMSLog.i(TAG, "removeReqByTransId");
        mHandler.post(new com.huawei.hms.common.internal.RequestManager.AnonymousClass2(str));
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(android.os.Message message) {
        if (message == null) {
            return false;
        }
        com.huawei.hms.support.log.HMSLog.i(TAG, "RequestManager handleMessage.");
        switch (message.what) {
            case 10011:
                handleConnectSuccess();
                break;
            case 10012:
                handleConnectFailed(message);
                break;
            case 10013:
                handleConnectSuspend();
                break;
            default:
                com.huawei.hms.support.log.HMSLog.i(TAG, "handleMessage unknown msg:" + message.what);
                break;
        }
        return false;
    }
}
