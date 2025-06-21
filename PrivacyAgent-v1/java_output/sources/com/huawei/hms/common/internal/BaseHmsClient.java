package com.huawei.hms.common.internal;

/* loaded from: classes22.dex */
public abstract class BaseHmsClient implements com.huawei.hms.support.api.client.AidlApiClient {
    private static final int BINDING = 5;
    private static final int CONNECTED = 3;
    private static final int DISCONNECTED = 1;
    private static final int MSG_CONN_TIMEOUT = 2;
    private static final java.lang.String TAG = "BaseHmsClient";
    protected static final int TIMEOUT_DISCONNECTED = 6;
    private static com.huawei.hms.adapter.BinderAdapter mInnerBinderAdapter;
    private static com.huawei.hms.adapter.BinderAdapter mOuterBinderAdapter;
    private com.huawei.hms.common.HuaweiApi.RequestHandler internalRequest;
    private java.lang.String mAppID;
    private final com.huawei.hms.common.internal.ClientSettings mClientSettings;
    private android.os.Handler mConnectTimeoutHandler = null;
    private final com.huawei.hms.common.internal.BaseHmsClient.ConnectionCallbacks mConnectionCallbacks;
    private final com.huawei.hms.common.internal.BaseHmsClient.OnConnectionFailedListener mConnectionFailedListener;
    private final android.content.Context mContext;
    private volatile com.huawei.hms.core.aidl.IAIDLInvoke mService;
    protected java.lang.String sessionId;
    private static final java.lang.Object LOCK_CONNECT_TIMEOUT_HANDLER = new java.lang.Object();
    private static final java.util.concurrent.atomic.AtomicInteger CONN_STATUS = new java.util.concurrent.atomic.AtomicInteger(1);
    private static final java.util.concurrent.atomic.AtomicInteger INNER_CONN_STATUS = new java.util.concurrent.atomic.AtomicInteger(1);

    /* renamed from: com.huawei.hms.common.internal.BaseHmsClient$1, reason: invalid class name */
    public class AnonymousClass1 implements com.huawei.hms.adapter.BinderAdapter.BinderCallBack {

        /* renamed from: com.huawei.hms.common.internal.BaseHmsClient$1$1, reason: invalid class name and collision with other inner class name */
        public class C03621 implements com.huawei.hms.api.FailedBinderCallBack.BinderCallBack {
            public C03621() {
            }

            @Override // com.huawei.hms.api.FailedBinderCallBack.BinderCallBack
            public void binderCallBack(int i) {
                if (i != 0) {
                    com.huawei.hms.common.internal.BaseHmsClient.this.notifyFailed(new com.huawei.hms.api.ConnectionResult(10, (android.app.PendingIntent) null));
                    com.huawei.hms.common.internal.BaseHmsClient.this.mService = null;
                }
            }
        }

        public AnonymousClass1() {
        }

        @Override // com.huawei.hms.adapter.BinderAdapter.BinderCallBack
        public void onBinderFailed(int i) {
            onBinderFailed(i, null);
        }

        @Override // com.huawei.hms.adapter.BinderAdapter.BinderCallBack
        public void onBinderFailed(int i, android.content.Intent intent) {
            if (intent == null) {
                com.huawei.hms.support.log.HMSLog.i(com.huawei.hms.common.internal.BaseHmsClient.TAG, "onBinderFailed: intent is null!");
                com.huawei.hms.common.internal.BaseHmsClient.this.notifyFailed(new com.huawei.hms.api.ConnectionResult(10, (android.app.PendingIntent) null));
                com.huawei.hms.common.internal.BaseHmsClient.this.mService = null;
                return;
            }
            android.app.Activity activeActivity = com.huawei.hms.utils.Util.getActiveActivity(com.huawei.hms.common.internal.BaseHmsClient.this.getClientSettings().getCpActivity(), com.huawei.hms.common.internal.BaseHmsClient.this.getContext());
            if (activeActivity == null) {
                com.huawei.hms.support.log.HMSLog.i(com.huawei.hms.common.internal.BaseHmsClient.TAG, "onBinderFailed: return pendingIntent to kit and cp");
                com.huawei.hms.common.internal.BaseHmsClient.this.notifyFailed(new com.huawei.hms.api.ConnectionResult(10, android.app.PendingIntent.getActivity(com.huawei.hms.common.internal.BaseHmsClient.this.mContext, 11, intent, 67108864)));
                com.huawei.hms.common.internal.BaseHmsClient.this.mService = null;
                return;
            }
            com.huawei.hms.support.log.HMSLog.i(com.huawei.hms.common.internal.BaseHmsClient.TAG, "onBinderFailed: SDK try to resolve and reConnect!");
            long time = new java.sql.Timestamp(java.lang.System.currentTimeMillis()).getTime();
            com.huawei.hms.api.FailedBinderCallBack.getInstance().setCallBack(java.lang.Long.valueOf(time), new com.huawei.hms.common.internal.BaseHmsClient.AnonymousClass1.C03621());
            intent.putExtra(com.huawei.hms.api.FailedBinderCallBack.CALLER_ID, time);
            activeActivity.startActivity(intent);
        }

        @Override // com.huawei.hms.adapter.BinderAdapter.BinderCallBack
        public void onNullBinding(android.content.ComponentName componentName) {
            com.huawei.hms.common.internal.BaseHmsClient.this.setConnectStatus(1);
            com.huawei.hms.common.internal.BaseHmsClient.this.notifyFailed(10);
        }

        @Override // com.huawei.hms.adapter.BinderAdapter.BinderCallBack
        public void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
            com.huawei.hms.support.log.HMSLog.i(com.huawei.hms.common.internal.BaseHmsClient.TAG, "Enter onServiceConnected.");
            com.huawei.hms.common.internal.BaseHmsClient.this.connectedInternal(iBinder);
        }

        @Override // com.huawei.hms.adapter.BinderAdapter.BinderCallBack
        public void onServiceDisconnected(android.content.ComponentName componentName) {
            com.huawei.hms.support.log.HMSLog.i(com.huawei.hms.common.internal.BaseHmsClient.TAG, "Enter onServiceDisconnected.");
            com.huawei.hms.common.internal.BaseHmsClient.this.setConnectStatus(1);
            com.huawei.hms.common.internal.RequestManager.getHandler().sendEmptyMessage(10013);
            if (com.huawei.hms.common.internal.BaseHmsClient.this.mConnectionCallbacks == null || (com.huawei.hms.common.internal.BaseHmsClient.this.mConnectionCallbacks instanceof com.huawei.hms.common.HuaweiApi.RequestHandler)) {
                return;
            }
            com.huawei.hms.common.internal.BaseHmsClient.this.mConnectionCallbacks.onConnectionSuspended(1);
        }

        @Override // com.huawei.hms.adapter.BinderAdapter.BinderCallBack
        public void onTimedDisconnected() {
            com.huawei.hms.common.internal.BaseHmsClient.this.setConnectStatus(6);
            if (com.huawei.hms.common.internal.BaseHmsClient.this.mConnectionCallbacks == null || (com.huawei.hms.common.internal.BaseHmsClient.this.mConnectionCallbacks instanceof com.huawei.hms.common.HuaweiApi.RequestHandler)) {
                return;
            }
            com.huawei.hms.common.internal.BaseHmsClient.this.mConnectionCallbacks.onConnectionSuspended(1);
        }
    }

    /* renamed from: com.huawei.hms.common.internal.BaseHmsClient$2, reason: invalid class name */
    public class AnonymousClass2 implements com.huawei.hms.adapter.AvailableAdapter.AvailableCallBack {
        public AnonymousClass2() {
        }

        @Override // com.huawei.hms.adapter.AvailableAdapter.AvailableCallBack
        public void onComplete(int i) {
            com.huawei.hms.common.internal.BaseHmsClient.this.notifyFailed(i);
        }
    }

    /* renamed from: com.huawei.hms.common.internal.BaseHmsClient$3, reason: invalid class name */
    public class AnonymousClass3 implements com.huawei.hms.adapter.AvailableAdapter.AvailableCallBack {
        public AnonymousClass3() {
        }

        @Override // com.huawei.hms.adapter.AvailableAdapter.AvailableCallBack
        public void onComplete(int i) {
            if (i == 0) {
                com.huawei.hms.common.internal.BaseHmsClient.this.bindCoreService();
            } else {
                com.huawei.hms.common.internal.BaseHmsClient.this.notifyFailed(i);
            }
        }
    }

    public interface ConnectionCallbacks {
        public static final int CAUSE_API_CLIENT_EXPIRED = 3;
        public static final int CAUSE_NETWORK_LOST = 2;
        public static final int CAUSE_SERVICE_DISCONNECTED = 1;

        void onConnected();

        void onConnectionSuspended(int i);
    }

    public static final class ConnectionResultWrapper {
        private com.huawei.hms.api.ConnectionResult connectionResult;
        private com.huawei.hms.common.HuaweiApi.RequestHandler request;

        public ConnectionResultWrapper(com.huawei.hms.common.HuaweiApi.RequestHandler requestHandler, com.huawei.hms.api.ConnectionResult connectionResult) {
            this.request = requestHandler;
            this.connectionResult = connectionResult;
        }

        public com.huawei.hms.api.ConnectionResult getConnectionResult() {
            return this.connectionResult;
        }

        public com.huawei.hms.common.HuaweiApi.RequestHandler getRequest() {
            return this.request;
        }
    }

    public interface OnConnectionFailedListener {
        void onConnectionFailed(com.huawei.hms.api.ConnectionResult connectionResult);
    }

    public BaseHmsClient(android.content.Context context, com.huawei.hms.common.internal.ClientSettings clientSettings, com.huawei.hms.common.internal.BaseHmsClient.OnConnectionFailedListener onConnectionFailedListener, com.huawei.hms.common.internal.BaseHmsClient.ConnectionCallbacks connectionCallbacks) {
        this.mContext = context;
        this.mClientSettings = clientSettings;
        this.mAppID = clientSettings.getAppID();
        this.mConnectionFailedListener = onConnectionFailedListener;
        this.mConnectionCallbacks = connectionCallbacks;
    }

    private void bindCoreInternal(java.lang.String str, java.lang.String str2) {
        if (this.mClientSettings.isUseInnerHms()) {
            mInnerBinderAdapter = com.huawei.hms.adapter.InnerBinderAdapter.getInstance(this.mContext, str2, str);
            if (!isConnected()) {
                setConnectStatus(5);
                mInnerBinderAdapter.binder(newBinderCallBack());
                return;
            } else {
                com.huawei.hms.support.log.HMSLog.i(TAG, "The binder is already connected.");
                getAdapter().updateDelayTask();
                connectedInternal(getAdapter().getServiceBinder());
                return;
            }
        }
        mOuterBinderAdapter = com.huawei.hms.adapter.OuterBinderAdapter.getInstance(this.mContext, str2, str);
        if (!isConnected()) {
            setConnectStatus(5);
            mOuterBinderAdapter.binder(newBinderCallBack());
        } else {
            com.huawei.hms.support.log.HMSLog.i(TAG, "The binder is already connected.");
            getAdapter().updateDelayTask();
            connectedInternal(getAdapter().getServiceBinder());
        }
    }

    private void cancelConnDelayHandle() {
        synchronized (LOCK_CONNECT_TIMEOUT_HANDLER) {
            android.os.Handler handler = this.mConnectTimeoutHandler;
            if (handler != null) {
                handler.removeMessages(2);
                this.mConnectTimeoutHandler = null;
            }
        }
    }

    private void checkAvailabilityAndConnect(int i, boolean z) {
        com.huawei.hms.support.log.HMSLog.i(TAG, "====== HMSSDK version: 60500300 ======");
        int i2 = (this.mClientSettings.isUseInnerHms() ? INNER_CONN_STATUS : CONN_STATUS).get();
        com.huawei.hms.support.log.HMSLog.i(TAG, "Enter connect, Connection Status: " + i2);
        if (z || !(i2 == 3 || i2 == 5)) {
            if (getMinApkVersion() > i) {
                i = getMinApkVersion();
            }
            com.huawei.hms.support.log.HMSLog.i(TAG, "connect minVersion:" + i + " packageName:" + this.mClientSettings.getInnerHmsPkg());
            if (this.mContext.getPackageName().equals(this.mClientSettings.getInnerHmsPkg())) {
                com.huawei.hms.support.log.HMSLog.i(TAG, "service packageName is same, bind core service return");
                bindCoreService();
                return;
            }
            if (!com.huawei.hms.utils.Util.isAvailableLibExist(this.mContext)) {
                int isHuaweiMobileServicesAvailable = com.huawei.hms.api.HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(this.mContext, i);
                com.huawei.hms.support.log.HMSLog.i(TAG, "HuaweiApiAvailability check available result: " + isHuaweiMobileServicesAvailable);
                if (isHuaweiMobileServicesAvailable == 0) {
                    bindCoreService();
                    return;
                } else {
                    notifyFailed(isHuaweiMobileServicesAvailable);
                    return;
                }
            }
            com.huawei.hms.adapter.AvailableAdapter availableAdapter = new com.huawei.hms.adapter.AvailableAdapter(i);
            int isHuaweiMobileServicesAvailable2 = availableAdapter.isHuaweiMobileServicesAvailable(this.mContext);
            com.huawei.hms.support.log.HMSLog.i(TAG, "check available result: " + isHuaweiMobileServicesAvailable2);
            if (isHuaweiMobileServicesAvailable2 == 0) {
                bindCoreService();
                return;
            }
            if (availableAdapter.isUserResolvableError(isHuaweiMobileServicesAvailable2)) {
                com.huawei.hms.support.log.HMSLog.i(TAG, "bindCoreService3.0 fail, start resolution now.");
                resolution(availableAdapter, isHuaweiMobileServicesAvailable2);
            } else {
                if (availableAdapter.isUserNoticeError(isHuaweiMobileServicesAvailable2)) {
                    com.huawei.hms.support.log.HMSLog.i(TAG, "bindCoreService3.0 fail, start notice now.");
                    notice(availableAdapter, isHuaweiMobileServicesAvailable2);
                    return;
                }
                com.huawei.hms.support.log.HMSLog.i(TAG, "bindCoreService3.0 fail: " + isHuaweiMobileServicesAvailable2 + " is not resolvable.");
                notifyFailed(isHuaweiMobileServicesAvailable2);
            }
        }
    }

    private com.huawei.hms.adapter.BinderAdapter.BinderCallBack newBinderCallBack() {
        return new com.huawei.hms.common.internal.BaseHmsClient.AnonymousClass1();
    }

    private void notice(com.huawei.hms.adapter.AvailableAdapter availableAdapter, int i) {
        com.huawei.hms.support.log.HMSLog.i(TAG, "enter notice");
        if (!getClientSettings().isHasActivity()) {
            if (i == 29) {
                i = 9;
            }
            notifyFailed(new com.huawei.hms.api.ConnectionResult(26, com.huawei.hms.api.HuaweiApiAvailability.getInstance().getErrPendingIntent(this.mContext, i, 0)));
        } else {
            android.app.Activity activeActivity = com.huawei.hms.utils.Util.getActiveActivity(getClientSettings().getCpActivity(), getContext());
            if (activeActivity != null) {
                availableAdapter.startNotice(activeActivity, new com.huawei.hms.common.internal.BaseHmsClient.AnonymousClass2());
            } else {
                notifyFailed(26);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyFailed(int i) {
        com.huawei.hms.support.log.HMSLog.i(TAG, "notifyFailed result: " + i);
        android.os.Message message = new android.os.Message();
        message.what = 10012;
        message.obj = new com.huawei.hms.common.internal.BaseHmsClient.ConnectionResultWrapper(this.internalRequest, new com.huawei.hms.api.ConnectionResult(i));
        com.huawei.hms.common.internal.RequestManager.getHandler().sendMessage(message);
        com.huawei.hms.common.internal.BaseHmsClient.OnConnectionFailedListener onConnectionFailedListener = this.mConnectionFailedListener;
        if (onConnectionFailedListener == null || (onConnectionFailedListener instanceof com.huawei.hms.common.HuaweiApi.RequestHandler)) {
            return;
        }
        onConnectionFailedListener.onConnectionFailed(new com.huawei.hms.api.ConnectionResult(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyFailed(com.huawei.hms.api.ConnectionResult connectionResult) {
        com.huawei.hms.support.log.HMSLog.i(TAG, "notifyFailed result: " + connectionResult.getErrorCode());
        android.os.Message message = new android.os.Message();
        message.what = 10012;
        com.huawei.hms.common.HuaweiApi.RequestHandler requestHandler = this.internalRequest;
        this.internalRequest = null;
        message.obj = new com.huawei.hms.common.internal.BaseHmsClient.ConnectionResultWrapper(requestHandler, connectionResult);
        com.huawei.hms.common.internal.RequestManager.getHandler().sendMessage(message);
        com.huawei.hms.common.internal.BaseHmsClient.OnConnectionFailedListener onConnectionFailedListener = this.mConnectionFailedListener;
        if (onConnectionFailedListener == null || (onConnectionFailedListener instanceof com.huawei.hms.common.HuaweiApi.RequestHandler)) {
            return;
        }
        onConnectionFailedListener.onConnectionFailed(connectionResult);
    }

    private void resolution(com.huawei.hms.adapter.AvailableAdapter availableAdapter, int i) {
        com.huawei.hms.support.log.HMSLog.i(TAG, "enter HmsCore resolution");
        if (!getClientSettings().isHasActivity()) {
            notifyFailed(new com.huawei.hms.api.ConnectionResult(26, com.huawei.hms.api.HuaweiApiAvailability.getInstance().getErrPendingIntent(this.mContext, i, 0)));
            return;
        }
        android.app.Activity activeActivity = com.huawei.hms.utils.Util.getActiveActivity(getClientSettings().getCpActivity(), getContext());
        if (activeActivity != null) {
            availableAdapter.startResolution(activeActivity, new com.huawei.hms.common.internal.BaseHmsClient.AnonymousClass3());
        } else {
            notifyFailed(26);
        }
    }

    private void tryUnBind() {
        com.huawei.hms.support.log.HMSLog.w(TAG, "Failed to get service as interface, trying to unbind.");
        if (this.mClientSettings.isUseInnerHms()) {
            com.huawei.hms.adapter.BinderAdapter binderAdapter = mInnerBinderAdapter;
            if (binderAdapter == null) {
                com.huawei.hms.support.log.HMSLog.w(TAG, "mInnerBinderAdapter is null.");
                return;
            }
            binderAdapter.unBind();
        } else {
            com.huawei.hms.adapter.BinderAdapter binderAdapter2 = mOuterBinderAdapter;
            if (binderAdapter2 == null) {
                com.huawei.hms.support.log.HMSLog.w(TAG, "mOuterBinderAdapter is null.");
                return;
            }
            binderAdapter2.unBind();
        }
        setConnectStatus(1);
        notifyFailed(10);
    }

    private void unBindAdapter() {
        if (this.mClientSettings.isUseInnerHms()) {
            com.huawei.hms.adapter.BinderAdapter binderAdapter = mInnerBinderAdapter;
            if (binderAdapter != null) {
                binderAdapter.unBind();
                return;
            }
            return;
        }
        com.huawei.hms.adapter.BinderAdapter binderAdapter2 = mOuterBinderAdapter;
        if (binderAdapter2 != null) {
            binderAdapter2.unBind();
        }
    }

    public void bindCoreService() {
        java.lang.String innerHmsPkg = this.mClientSettings.getInnerHmsPkg();
        java.lang.String serviceAction = getServiceAction();
        com.huawei.hms.support.log.HMSLog.i(TAG, "enter bindCoreService, packageName is " + innerHmsPkg + ", serviceAction is " + serviceAction);
        bindCoreInternal(innerHmsPkg, serviceAction);
    }

    public final void checkConnected() {
        if (!isConnected()) {
            throw new java.lang.IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public void connect(int i) {
        checkAvailabilityAndConnect(i, false);
    }

    public void connect(int i, boolean z) {
        checkAvailabilityAndConnect(i, z);
    }

    public void connectedInternal(android.os.IBinder iBinder) {
        this.mService = com.huawei.hms.core.aidl.IAIDLInvoke.Stub.asInterface(iBinder);
        if (this.mService != null) {
            onConnecting();
        } else {
            com.huawei.hms.support.log.HMSLog.e(TAG, "mService is null, try to unBind.");
            tryUnBind();
        }
    }

    public final void connectionConnected() {
        setConnectStatus(3);
        com.huawei.hms.common.internal.RequestManager.getHandler().sendEmptyMessage(10011);
        com.huawei.hms.common.internal.BaseHmsClient.ConnectionCallbacks connectionCallbacks = this.mConnectionCallbacks;
        if (connectionCallbacks == null || (connectionCallbacks instanceof com.huawei.hms.common.HuaweiApi.RequestHandler)) {
            return;
        }
        connectionCallbacks.onConnected();
    }

    public void disconnect() {
        int i = (this.mClientSettings.isUseInnerHms() ? INNER_CONN_STATUS : CONN_STATUS).get();
        com.huawei.hms.support.log.HMSLog.i(TAG, "Enter disconnect, Connection Status: " + i);
        if (i != 1) {
            if (i == 3) {
                unBindAdapter();
                setConnectStatus(1);
            } else {
                if (i != 5) {
                    return;
                }
                cancelConnDelayHandle();
                setConnectStatus(1);
            }
        }
    }

    public com.huawei.hms.adapter.BinderAdapter getAdapter() {
        com.huawei.hms.support.log.HMSLog.i(TAG, "getAdapter:isInner:" + this.mClientSettings.isUseInnerHms() + ", mInnerBinderAdapter:" + mInnerBinderAdapter + ", mOuterBinderAdapter:" + mOuterBinderAdapter);
        return this.mClientSettings.isUseInnerHms() ? mInnerBinderAdapter : mOuterBinderAdapter;
    }

    @Override // com.huawei.hms.support.api.client.AidlApiClient
    public java.util.List<java.lang.String> getApiNameList() {
        return this.mClientSettings.getApiName();
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public java.lang.String getAppID() {
        return this.mAppID;
    }

    public com.huawei.hms.common.internal.ClientSettings getClientSettings() {
        return this.mClientSettings;
    }

    public int getConnectionStatus() {
        return (this.mClientSettings.isUseInnerHms() ? INNER_CONN_STATUS : CONN_STATUS).get();
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public android.content.Context getContext() {
        return this.mContext;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public java.lang.String getCpID() {
        return this.mClientSettings.getCpID();
    }

    @java.lang.Deprecated
    public int getMinApkVersion() {
        return 30000000;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public java.lang.String getPackageName() {
        return this.mClientSettings.getClientPackageName();
    }

    @Override // com.huawei.hms.support.api.client.AidlApiClient
    public com.huawei.hms.core.aidl.IAIDLInvoke getService() {
        return this.mService;
    }

    public java.lang.String getServiceAction() {
        com.huawei.hms.utils.HMSPackageManager hMSPackageManager = com.huawei.hms.utils.HMSPackageManager.getInstance(this.mContext);
        return this.mClientSettings.isUseInnerHms() ? hMSPackageManager.getInnerServiceAction() : hMSPackageManager.getServiceAction();
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public java.lang.String getSessionId() {
        return this.sessionId;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public com.huawei.hms.support.api.client.SubAppInfo getSubAppInfo() {
        return this.mClientSettings.getSubAppID();
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public java.lang.String getTransportName() {
        return com.huawei.hms.api.IPCTransport.class.getName();
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public boolean isConnected() {
        return !this.mClientSettings.isUseInnerHms() ? CONN_STATUS.get() != 3 : INNER_CONN_STATUS.get() != 3;
    }

    public boolean isConnecting() {
        return (this.mClientSettings.isUseInnerHms() ? INNER_CONN_STATUS : CONN_STATUS).get() == 5;
    }

    public void onConnecting() {
        connectionConnected();
    }

    public void setConnectStatus(int i) {
        if (this.mClientSettings.isUseInnerHms()) {
            INNER_CONN_STATUS.set(i);
        } else {
            CONN_STATUS.set(i);
        }
    }

    public final void setInternalRequest(com.huawei.hms.common.HuaweiApi.RequestHandler requestHandler) {
        this.internalRequest = requestHandler;
    }

    public void setService(com.huawei.hms.core.aidl.IAIDLInvoke iAIDLInvoke) {
        this.mService = iAIDLInvoke;
    }
}
